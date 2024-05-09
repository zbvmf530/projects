<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>상세화면</h3>
<%
BoardVO brd = (BoardVO) request.getAttribute("result");
%>
<%
if (brd == null) {
%>
<p>조회된 결과가 없습니다.</p>
<%
} else {
%>
<form name = "myFrm">
<input type="hidden" name="bno" value=<%=brd.getBoardNo()%>>
</form>
<table class="table">
	<tr>
		<th>게시글번호</th>
		<td><%=brd.getBoardNo()%></td>
		<th>작성자</th>
		<td><%=brd.getWriter()%></td>

	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=brd.getTitle()%></td>

	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><%=brd.getContent()%></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td><%=brd.getCreateDate()%></td>
		<th>조회수</th>
		<td><%=brd.getViewCnt()%></td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<button class="btn btn-primary"id = "modBtn">수정</button>
			<button class="btn btn-danger" id="delBtn">삭제</button>
		</td>
	</tr>
</table>
<%
}
%>
<script src="js/board.js"></script>

<jsp:include page="../includes/footer.jsp"></jsp:include>