/**
 * 
 */

 /**
 * 
 */
// 수정버튼
document.querySelector("#modBtn").addEventListener('click', function() {
	let str = $("input[name=page]:first").val();
	console.log(str);
	document.forms.myFrm.action = `modBoardForm.do?page="${str}"`; // 수정화면 호출
	document.forms.myFrm.submit();
});

// 삭제버튼
$("#delBtn").on('click', function() {
	let str = $("input[name=page]:first").val();
	console.log(str);
	document.forms.myFrm.action = `romoveBoardForm.do?page="${str}"`; // 삭제화면 호출
	document.forms.myFrm.submit();
});



//const bno = 14656;
//console.log(bno);
let page = 1;
showList();
function showList(){
	// 댓글목록 초기화
	$('div.content ul li:gt(2)').remove();
	svc.replyList({bno:bno,page:page}, result => {
		//console.log(result);
										result.forEach(reply => {
											const row = makeRow(reply);
											$('div.reply ul').append(row);
										});makePageInfo();},
					err=>{console.log(err)});
}

$('.modal-content button').on('click',modifyRep);

function modifyRep() {
	let str = $('p:contains("댓글")').text();
	let rno = str.substring(str.indexOf(": ") + 2);
	let rep = $('.modal-content input').val();
	
	svc.moifyReply({ bno: bno, rno: rno, reply: rep }, result => {
		if (result.retCode == 'OK') {
			alert('수정완료');
			$('#myModal').css('display', 'none');
			showList();
		}
		else if (result.retCode == 'NG') { alert('수정실패'); }
		else { alert('알수 없는 반환값'); }
	},
		err => console.log(err)
	);
}

function makeRow(reply={}){
	let tmpl = $('div.reply li:eq(2)').clone(true);
			//console.log(tmpl);
			tmpl.css('display','block');
			tmpl.on('dblclick',function(e){
				$('#myModal').css('display','block');
				$('p:contains("댓글")').text("댓글번호: "+$(e.target).parent().children().eq(0).text());
				//console.log($('.modal-content button'));
				
			})
			
			tmpl.attr('data-rno', reply.replyNo);
			tmpl.find('span:eq(0)').text(reply.replyNo);
			$('div.reply ul').append(tmpl);
			tmpl.find('span:eq(1)').text(reply.reply);
			$('div.reply ul').append(tmpl);
			tmpl.find('span:eq(2)').text(reply.replyer);
			$('div.reply ul').append(tmpl);
			// 내가 적은 댓글이 아닌 댓글은 삭제못하게 예외처리,
			// 작성자 가져와서 로그아이디랑 비교 -> 다르면 밑에녀석 disable
			if(reply.replyer != writer){
			//console.log(tmpl.querySelector('span:nth-of-type(4)').children[0]);
			tmpl.find('span:eq(3):first').css('display','none');
			}
			else{
				tmpl.find('span:eq(3):first').css('display','inline-block');
			}
			return tmpl;
}
// 댓글 페이지 생성
let pagination = $('div.pagination');


function makePageInfo(){
	svc.getTotalCount(bno,
	createPageList,
	err=>console.log(err))	
}

function createPageList(result){
	console.log(result);
	let totalCnt = result.totalCount; // 불러와야함
	let startPage, endPage, realEnd;
	let prev, next; 
	realEnd = Math.ceil(totalCnt/5);
	
	endPage = Math.ceil(page/5)*5;
	startPage = endPage -4;
	endPage = endPage>realEnd?realEnd:endPage;
	
	// 이전, 이후 페이지 체크
	prev = startPage>1;
	next = endPage <realEnd;
	console.log(startPage,endPage,realEnd,prev,next);
	// a 태그 생성
	pagination.html('');
	if(prev){
		let aTag = $('<a/>');
		aTag.attr({'data-page':startPage-1,'href':'#'})
		aTag.html("&laquo;");
		aTag.on('click',function (e) {
		e.preventDefault(); // a 태그 기본 이벤트 차단
		
		page=e.target.dataset.page;
		showList();	
		});
		pagination.append(aTag);
	}
	
	for(let pg = startPage;pg<=endPage;pg++){
		let aTag = $('<a/>');
		aTag.attr({'data-page':pg,'href':pg})
		if(pg==page){aTag.attr('class','active');}
		aTag.html(pg);
		aTag.on('click',function (e) {
		e.preventDefault(); // a 태그 기본 이벤트 차단
		
		page=e.target.dataset.page;
		showList();	
		});
		pagination.append(aTag);
	}
	if(next){
		let aTag = $('<a/>');
		aTag.attr({'data-page':endPage+1,'href':'#'})
		aTag.html("&raquo;");
		aTag.on('click',function (e) {
		e.preventDefault(); // a 태그 기본 이벤트 차단
		page=e.target.dataset.page;
		showList();	
		});
		pagination.append(aTag);
	}
}

function deleteRow(e) {
	const rno = $(e.target).parent().parent().data('rno');
	const activepg = pagination.find('.active').data('page');
	
	svc.removeReply(rno,
					result => {
							if (result.retCode == 'OK') {
								alert('삭제완료');
								svc.getTotalCount(bno,
								result=>{
									page=Math.ceil(result.totalCount/5);
									showList();
									},
								err=>console.log(err));
								//page = activepg;
								
								//showList();
							}
							else if (result.retCode == 'NG') { alert('삭제실패'); }
							else { alert('알수 없는 반환값'); }
						},
					err => console.log(err));
}

function addReply() {
	let content = $('#reply').val();
	console.log(content);
	// 로그인 안했을시 댓글작성안되게 예외처리,
	if (writer == '') {alert("작성권한이 없습니다! 로그인 먼저 해주세요");}
	else {
		// 댓글에 내용 없이 등록할시 안되게 예외처리,
		if (content == '') { alert("댓글 내용을 입력해주세요!"); }
		else {
			svc.addReply({bno:bno,writer:writer,reply:content},
			result => {
					if (result.retCode == 'OK') {
						const row = makeRow(result.retVal);
						// 댓글 등록 시 등록한 글을 보여주도록(페이지를 활용).
						// -힌트: 오름차순 (마지막 페이지 계산)
						svc.getTotalCount(bno,
						result=>{page=Math.ceil(result.totalCount/5);showList();},
						err=>console.log(err));
						
						$('div.reply ul').append(row);
						$('#reply').val('');
					}
					else if (result.retCode == 'NG') { alert('등록실패'); }
					else { alert('알수 없는 반환값'); }
				},
				err => console.log(err));
		}
	}
}

