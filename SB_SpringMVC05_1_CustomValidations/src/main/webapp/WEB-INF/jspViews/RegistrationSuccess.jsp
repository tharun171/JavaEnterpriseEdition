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
<table border="2">
	<tr>
		<td>username</td>
		<td>${DetailsBean.username}</td>
	</tr>
	<tr>
		<td>password</td>
		<td>${DetailsBean.password}</td>
	</tr>
	<tr>
		<td>Gender</td>
		<td>${DetailsBean.gender}</td>
	</tr>
	<tr>
		<td>country</td>
		<td>${DetailsBean.country}</td>
	</tr>
	<tr>
		<td>About you</td>
		<td>${DetailsBean.aboutYou}</td>
	</tr>
	<tr>
		<td>Age</td>
		<td>${DetailsBean.age}</td>
	</tr>
	<tr>
		<td>Salary</td>
		<td>${DetailsBean.salary}</td>
	</tr>
	<tr>
		<td>Joining Date</td>
		<td>${DetailsBean.joiningDate}</td>
	</tr>
	<tr>
		<td>language</td>
		<td>
			${DetailsBean.language[0]}
			${DetailsBean.language[1]}
			${DetailsBean.language[2]}
			${DetailsBean.language[3]}
		</td>
	</tr>
	<tr>
		<td>mailingList</td>
		<td>${DetailsBean.mailingList}</td>
	</tr>
</table>
<a href="${pageContext.request.contextPath}/">Home</a>
</center>
</body>
</html>