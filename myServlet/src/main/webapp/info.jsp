<%@page import="com.yedam.vo.EmployeeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>
</head>
<body>
	<%
	Object req = request.getAttribute("req"); // 반환타입 : Object
	String name = (String) request.getAttribute("name");
	// 컨트롤 스페이스 -> jsp에서 임포트하는 키
	List<EmployeeVO> empList = (List<EmployeeVO>) request.getAttribute("emplist");
	//System.out.println("jsp: " + req+" name: "+name);
	%>
	<p><%=name%></p>
	<ol>
		<%for (EmployeeVO evo : empList) {%>
		<li>
		사번 : <%=evo.getEmployeeId()%> 
		이름 : <%=evo.getFirstName()%>
		</li>
		<%}%>
	</ol>
</body>
</html>