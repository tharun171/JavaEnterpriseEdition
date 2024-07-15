<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="abc" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Login Page</h2>
<abc:form action="validate" modelAttribute="loginBeanMA" method="Post" >
<table>
<tr>
	<td><label>Name:</label></td>
	<!-- bind to loginBean.userName -->
	<td><abc:input type="text" path="userName"/></td>
</tr>
<tr>
	<td><label>Password</label></td>
	<!-- bind to loginBean.password -->
	<td><abc:password path="password"/></td>
</tr>
</table>
<input type="submit" value="Login!"/>
</abc:form>

</center>
</body>
</html>