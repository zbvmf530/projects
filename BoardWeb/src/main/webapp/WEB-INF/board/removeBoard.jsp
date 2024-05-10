<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<c:choose>
	<c:when test="${empty bno}"><p>조회된 결과가 없습니다.</p></c:when>
	
	<c:otherwise>
<h3>삭제화면</h3>
<form name="myFrm" action="deleteBoard.do">
<table class="table">
	<tr>
		<th>게시글번호</th>
		<td>${bno.boardNo}></td>
	</tr>
	<tr>
		<th>제목</th>
		<td >${bno.title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td >${bno.content}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${bno.writer}</td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<input type="submit" class="btn btn-danger" value="삭제">
		</td>
	</tr>
</table>
	<input type="hidden" name="bno" value="${bno.boardNo}">
	<input type="hidden" name="page" value="${page}">
</form>
	</c:otherwise>
</c:choose>
<script>

const logId = "${logId}";
const writer = "${bno.writer}";
document.forms.myFrm.addEventListener('submit',function(e){
		e.preventDefault();
	if(writer!=logId)
	{
		alert("권한이 없습니다!")
		return;
	}
	else{this.submit();}
});

</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>