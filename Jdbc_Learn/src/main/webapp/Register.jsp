<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h2 class="center">Registration Page</h2>

<!-- Checks whether name is null or not
if name is null prints Register here message
else prints nothing -->

<%
	if(request.getAttribute("name")==null)
	{
		request.setAttribute("status","Register Here!");
	}
%>
<!-- prints the status of registration -->
<p class="center status"><%=request.getAttribute("status") %></p>
<!-- @WebServlet("Register") in register servlet -->
<form action="Register" method="Post">
	<table border="2">
		<tr>
			<td>Name:</td>
			<td><input type="text" name="RegName" required/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="RegEmail" required/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="RegPassword" required/></td>
		</tr><br>
	</table>
	<br>
	<input type="submit" value="Register"/>
</form>
<br>
<hr class="horLine"/>
<p class="center">Already have an Account! </p><a class="center" href="Login.jsp">Login Here</a>


</body>
</html>