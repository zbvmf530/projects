/**
 * 
 */
// 수정버튼
document.querySelector("#modBtn").addEventListener('click',function(){
	let str = document.getElementsByName("page");
	document.forms.myFrm.action = `modBoardForm.do?page="${str[0].value}"`; // 수정화면 호출
	document.forms.myFrm.submit();
});

// 삭제버튼
document.querySelector("#delBtn").addEventListener('click',function(){
	let str = document.getElementsByName("page");
	
	document.forms.myFrm.action = `romoveBoardForm.do?page="${str[0].value}"`; // 삭제화면 호출
	document.forms.myFrm.submit();
});