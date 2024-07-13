<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>
<style>
	.center
	{
		text-align:center;
		display:flex;
		justify-content:center;
	}
	.status
	{
		color:orange;
	}
</style>
<body>
<h1 class="center">Login Success</h1>
<p class="center status"><%= request.getAttribute("loginStatus") %></p>

<p><%= request.getAttribute("emp") %></p>

</body>
</html>