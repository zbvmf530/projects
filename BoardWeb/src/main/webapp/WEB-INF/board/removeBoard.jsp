<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
BoardVO brd = (BoardVO) request.getAttribute("bno");
%>
<%
if (brd == null) {
%>
<p>조회된 결과가 없습니다.</p>
<%
} else {
%>
<h3>삭제화면</h3>
<form action="deleteBoard.do">
<table class="table">
	<tr>
		<th>게시글번호</th>
		<td><%=brd.getBoardNo()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td ><%=brd.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td ><%=brd.getContent()%></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=brd.getWriter()%></td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<input type="submit" class="btn btn-danger" value="삭제">
		</td>
	</tr>
</table>
	<input type="hidden" name="bno" value="<%=brd.getBoardNo()%>">
</form>
<%
}
%>
<jsp:include page="../includes/footer.jsp"></jsp:include>