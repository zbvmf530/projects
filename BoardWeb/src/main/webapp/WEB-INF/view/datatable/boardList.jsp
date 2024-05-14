<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/2.0.7/css/dataTables.dataTables.min.css">

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
	<c:forEach var="brd" items="${boardList}">
	<tr>
	<td>${brd.boardNo}</td>
	<td><a href="boardInfo.do?bno=${brd.boardNo}&page=${paging.page}">${brd.title}</a></td>
	<td>${brd.writer}</td>
	<td><fmt:formatDate value="${brd.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${brd.viewCnt}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<hr/>
<my:paging pageInfo="${paging}"/>
<jsp:include page="../../includes/footer.jsp"></jsp:include>