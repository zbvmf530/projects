<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
%>
<h3>게시글 목록</h3>
<!-- 글번호, 제목, 작성자, 작성일시, 조회수 -->
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
	<%for(BoardVO brd : list){ %>
	<tr>
	<td><%=brd.getBoardNo() %></td>
	<td><a href="boardInfo.do?bno=<%=brd.getBoardNo() %>"><%=brd.getTitle() %></td>
	<td><%=brd.getWriter() %></td>
	<td><%=brd.getCreateDate() %></td>
	<td><%=brd.getViewCnt() %></td>
	<% } %>
	</tr>
	</tbody>
</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>