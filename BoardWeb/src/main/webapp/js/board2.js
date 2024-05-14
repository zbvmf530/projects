/**
 * 
 */
// 수정버튼
document.querySelector("#modBtn").addEventListener('click', function() {
	let str = document.getElementsByName("page");
/*	console.log(page);
	console.log(searchCondition);
	console.log(keyword);*/

	document.forms.myFrm.action = `modBoardForm.do?page="${str[0].value}"`; // 수정화면 호출
	document.forms.myFrm.submit();
});

// 삭제버튼
document.querySelector("#delBtn").addEventListener('click', function() {
	let str = document.getElementsByName("page");
	
	document.forms.myFrm.action = `romoveBoardForm.do?page="${str[0].value}"`; // 삭제화면 호출
	document.forms.myFrm.submit();
});



//const bno = 14656;
//console.log(bno);
let page = 1;
showList();
function showList(){
	// 댓글목록 초기화
	document.querySelectorAll('div.content ul li').forEach((li, idx)=>{
		if(idx>2){
			li.remove();
		}
	});
	fetch('replyList.do?bno=' + bno+"&page"+page)
	.then(resolve => resolve.json()) // json->rorcp
	.then(result => {
		//console.log(result);
		result.forEach(reply => {
			const row = makeRow(reply);
			document.querySelector('div.reply ul').appendChild(row);
		})
		createPageList();
	})
	.catch(err => console.log(err));
}


function makeRow(reply={}){
	let tmpl = document.querySelector('div.reply li:nth-of-type(3)').cloneNode(true);
			//console.log(tmpl);
			tmpl.style.display = 'block';
			tmpl.setAttribute('data-rno', reply.replyNo);
			tmpl.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
			document.querySelector('div.reply ul').appendChild(tmpl);
			tmpl.querySelector('span:nth-of-type(2)').innerText = reply.reply;
			document.querySelector('div.reply ul').appendChild(tmpl);
			tmpl.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
			document.querySelector('div.reply ul').appendChild(tmpl);
			// 내가 적은 댓글이 아닌 댓글은 삭제못하게 예외처리,
			// 작성자 가져와서 로그아이디랑 비교 -> 다르면 밑에녀석 disable
			if(reply.replyer != writer){
			//console.log(tmpl.querySelector('span:nth-of-type(4)').children[0]);
			tmpl.querySelector('span:nth-of-type(4)').children[0].style.display = 'none';
			}
			else{
				tmpl.querySelector('span:nth-of-type(4)').children[0].style.display = 'block';
			}
			return tmpl;
}
// 댓글 페이지 생성
let pagination = document.querySelector('div.pagination');

function createPageList(){
	let totalCnt = 143; // 불러와야함
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
	pagination.innerHTML='';
	if(prev){
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page',startPage-1);
		aTag.setAttribute('href','#');
		aTag.innerHTML="&laquo;";
		aTag.addEventListener('click',function (e) {
		e.preventDefault(); // a 태그 기본 이벤트 차단
		
		page=e.target.dataset.page;
		showList();	
		});
		pagination.appendChild(aTag);
	}
	
	for(let pg = startPage;pg<=endPage;pg++){
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page',pg);
		aTag.setAttribute('href',pg);
		if(pg==page){aTag.className='active';}
		aTag.innerHTML=pg;
		aTag.addEventListener('click',function (e) {
		e.preventDefault(); // a 태그 기본 이벤트 차단
		
		page=e.target.dataset.page;
		showList();	
		});
		pagination.appendChild(aTag);
	}
	if(next){
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page',endPage+1);
		aTag.setAttribute('href','#');
		aTag.innerHTML="&raquo;";
		aTag.addEventListener('click',function (e) {
		e.preventDefault(); // a 태그 기본 이벤트 차단
		
		page=e.target.dataset.page;
		showList();	
		});
		pagination.appendChild(aTag);
	}
}

function deleteRow(e) {
	const rno = e.target.parentElement.parentElement.dataset.rno;
	const activepg = pagination.querySelector('.active').dataset.page;
	
	console.log(activepg);
	//console.log(e.target.parentElement.parentElement);
	//console.log(rno);
	fetch('removeReply.do?rno=' + rno)
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('삭제완료');
				page = activepg;
/*				e.target.parentElement.parentElement.remove();*/
				showList();
			}
			else if (result.retCode == 'NG') { alert('삭제실패'); }
			else { alert('알수 없는 반환값'); }
		})
		.catch(err => console.log(err));
}

function addReply() {
	const content = document.querySelector('#reply').value;
	// 로그인 안했을시 댓글작성안되게 예외처리,
	
	if (writer == '') {
		alert("작성권한이 없습니다! 로그인 먼저 해주세요");
	}
	else {
		// 댓글에 내용 없이 등록할시 안되게 예외처리,
		if (document.querySelector('#reply').value == '') { alert("댓글 내용을 입력해주세요!"); }
		else {
			fetch('addReply.do?bno=' + bno + '&writer=' + writer + '&content=' + content)
				.then(resolve => resolve.json())
				.then(result => {
					//	console.log(result);
					//	if(result!='null')
					//	{
					//		result.boardNo
					//		result.reply
					//		result.replyNo
					//	}
					if (result.retCode == 'OK') {

/*						location.reload();*/
						const row = makeRow(result.retVal);
						document.querySelector('div.reply ul').appendChild(row);
						document.getElementById('reply').value="";
						
						
					}
					else if (result.retCode == 'NG') { alert('등록실패'); }
					else { alert('알수 없는 반환값'); }
				})
				.catch(err => console.log(err));

		}
	}

}

