/**
 * 
 */
// 수정버튼
document.querySelector("#modBtn").addEventListener('click',function(){
	document.forms.myFrm.action = `modBoardForm.do?page="${page}"`; // 수정화면 호출
	document.forms.myFrm.submit();
})

// 삭제버튼
document.querySelector("#delBtn").addEventListener('click',function(){
	
	document.forms.myFrm.action = `romoveBoardForm.do?page="${page}"`; // 삭제화면 호출
	document.forms.myFrm.submit();
})