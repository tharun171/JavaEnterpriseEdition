<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2>Login failed</h2>
	<c:out value="${errorMessage}"></c:out><br>
	<a href="${pageContext.request.contextPath}/home">Home</a>
</center>
</body>
</html>