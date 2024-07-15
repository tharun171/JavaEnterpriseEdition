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
<h2>Login</h2>
<form method="post" action="validateLogin">
	<table>
		<tr>
			<td><label>Name</label></td>
			<td><input type="text" name="uName"/></td>
		</tr>
		<tr>
			<td><label>Password</label></td>
			<td><input type="password" name="pwd"/></td>
		</tr>
	</table>
	<input type="submit" value="Login!"/>
</form>
</center>
</body>
</html>