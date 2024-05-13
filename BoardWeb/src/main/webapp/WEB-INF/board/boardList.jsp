<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <jsp:include page="../includes/header.jsp"></jsp:include> --%>
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<h3>게시글 목록</h3>
<div class="center">
	<form action="main.do">
		<div class="row">
			<div class="col-sm-4">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${searchCondition == 'T' ? 'selected' : ''} >제목</option>
					<option value="W" ${searchCondition == 'W' ? 'selected' : ''}>작성자</option>
					<option value="TW" ${searchCondition == 'TW' ? 'selected' : ''}>제목 & 작성자</option>
				</select>
			</div>
			<div class="col-sm-6">
				<input type="text" name="keyword" value="${keyword}" class="form-control">
			</div>
			<div class="col-sm-2">
				<input type="submit" value="조회" class="btn btn-primary">
			</div>
		</div>
	</form>
</div>
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
				<td><a
					href="boardInfo.do?bno=${brd.boardNo}&page=${paging.page}&searchCondition=${searchCondition}&keyword=${keyword}">${brd.title}</a></td>
				<td>${brd.writer}</td>
				<td><fmt:formatDate value="${brd.createDate}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${brd.viewCnt}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<hr />
<my:paging pageInfo="${paging}" />
<%-- <jsp:include page="../includes/footer.jsp"></jsp:include> --%>