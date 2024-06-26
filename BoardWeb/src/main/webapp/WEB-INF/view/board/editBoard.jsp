<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <jsp:include page="../includes/header.jsp"></jsp:include> --%>
<c:choose>
	<c:when test="${empty bno}"><p>조회된 결과가 없습니다.</p></c:when>
	
	<c:otherwise>
<h3>수정화면</h3>
<form action="updateBoard.do" method="post">
	<table class="table">
		<tr>
			<th>게시글번호</th>
			<td>${bno.boardNo}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${bno.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content">${bno.content}</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bno.writer}</td>
		</tr>
		
		<tr>
		<th>파일</th>
		<c:choose>
		<c:when test="${empty bno.img}">
		<td><input type="file" name = "myImg"></td>
		</c:when>
		<c:otherwise>
		<td><input type="file" name = "myImg" value="http://localhost:8080/BoardWeb/images/${bno.img}"></td> 
		</c:otherwise>
		</c:choose>
		
		</tr>
		
		<tr align="center">
			<td colspan="4">
			<c:choose>
			<c:when test="${bno.writer.equals(logId)}">
			<input type="submit" class="btn btn-primary" value="수정">
			</c:when>
			<c:otherwise>
			<input type="submit" class="btn btn-primary" disabled value="수정">
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>
	<input type="hidden" name="bno" value="${bno.boardNo}">
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
</form>
	</c:otherwise>
</c:choose>
<%-- <jsp:include page="../includes/footer.jsp"></jsp:include> --%>