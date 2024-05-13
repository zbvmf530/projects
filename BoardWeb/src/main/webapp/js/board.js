/**
 * 
 */
// 수정버튼
document.querySelector("#modBtn").addEventListener('click', function() {
	let str = document.getElementsByName("page");
	document.forms.myFrm.action = `modBoardForm.do?page="${str[0].value}"`; // 수정화면 호출
	document.forms.myFrm.submit();
});

// 삭제버튼
document.querySelector("#delBtn").addEventListener('click', function() {
	let str = document.getElementsByName("page");

	document.forms.myFrm.action = `romoveBoardForm.do?page="${str[0].value}"`; // 삭제화면 호출
	document.forms.myFrm.submit();
});


// 댓글 목록 출력
//const bno = 14656;
console.log(bno);
fetch('replyList.do?bno=' + bno)
	.then(resolve => resolve.json()) // json->rorcp
	.then(result => {
		console.log(result);
		result.forEach(reply => {
			let tmpl = document.querySelector('div.reply li:nth-of-type(3)').cloneNode(true);
			console.log(tmpl);
			tmpl.style.display = 'block';
			tmpl.setAttribute('data-rno', reply.replyNo);
			tmpl.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
			document.querySelector('div.reply ul').appendChild(tmpl);
			tmpl.querySelector('span:nth-of-type(2)').innerText = reply.reply;
			document.querySelector('div.reply ul').appendChild(tmpl);
			tmpl.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
			document.querySelector('div.reply ul').appendChild(tmpl);
		})
	})
	.catch(err => console.log(err));


function deleteRow(e) {
	const rno = e.target.parentElement.parentElement.dataset.rno;
	console.log(rno);
	fetch('removeReply.do?rno=' + rno)
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('삭제완료');
				e.target.parentElement.parentElement.remove();
			}
			else if (result.retCode == 'NG') { alert('삭제실패'); }
			else { alert('알수 없는 반환값'); }
		})
		.catch(err => console.log(err));
}

function addReply() {
	const content = document.querySelector('#reply').value;
	//console.log(document.querySelector('#reply').value);
	fetch('addReply.do?bno=' + bno + '&writer=' + writer + '&content=' + content)
		.then(resolve => resolve.json())
		.then(result => {
/*			console.log(result);
			if(result!='null')
			{
				result.boardNo
				result.reply
				result.replyNo
			}*/
			if (result.retCode == 'OK') {
				
				location.reload();
			}
			else if (result.retCode == 'NG') { alert('등록실패'); }
			else { alert('알수 없는 반환값'); }
		})
		.catch(err => console.log(err));
}

