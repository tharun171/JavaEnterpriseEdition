<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
	.center
	{
		text-align:center;
		display:flex;
		justify-content:center;
	}
	form
	{
		display:flex;
		justify-content:center;
	}
	.horLine
	{
		width:400px;
	}
	.status 
	{
		color:orange;
	}
</style>
</head>
<body>
<h2 class="center">Login Page</h2>
<!-- email will be null when new page is loaded -->
<!-- if email == null prints Login Here! message -->
<%
	if(request.getAttribute("email")==null)
	{
		request.setAttribute("loginStatus","Login Here!");
	}
%>
<!-- printing status of registration -->
<p class="center status"><%=request.getAttribute("loginStatus") %></p>
<!-- @WebServlet("login") in loginServlet -->
<form action="LoginServlet" method="Post">
	<table border="2">
		<tr>
			<td>Email:</td>
			<td><input type="email" name="loginEmail" required/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="loginPassword" required/></td>
		</tr>
		<br>
	</table>
	<br>
	<input type="submit" value="Login"/>
</form>
<hr class="horLine">
<p class="center">Dont have an Account?</p><a class="center" href="Register.jsp">Sign Up!!!</a>

</body>
</html>