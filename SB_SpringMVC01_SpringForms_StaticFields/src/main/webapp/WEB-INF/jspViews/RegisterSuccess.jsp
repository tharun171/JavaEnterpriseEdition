<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Success</title>
</head>
<body>
<center>
	<h2>Register Success</h2>
	<h3>${message}</h3>
	<h3>${rb}</h3>
	<h3>${rb.userName}</h3>
	<br>
	<table border="2">
		<tr>
			<td><label>Name: </label></td>
			<td>${rb.userName}</td>
		</tr>
		<tr>
			<td><label>Password: </label></td>
			<td>${rb.userPass}</td>
		</tr>
		<tr>
			<td><label>Salary (2 decimals)</label></td>
			<td>${rb.userSalary}</td>
		</tr>
		<tr>
			<td><label>Gender: </label></td>
			<td>
				${rb.userGender}
			</td>
		</tr>
		<tr>
			<td><label>Select Country</label></td>
			<td>
				${rb.userCountry}
			</td>
		</tr>
		<tr>
			<td><label>Language known</label></td>
			<td>
				${rb.userLang[0]}
				${rb.userLang[1]}
				${rb.userLang[2]}
			</td>
		</tr>
		<tr>
			<td><label>Join Date(year/mon/date)</label>
			<td>
				<fmt:formatDate value="${rb.userDate}" pattern="yyyy-MMM-dd"/>
			</td>
		</tr>
		<tr>
			<td>Mention about you</td>
			<td>
				${rb.userAbout}
			</td>
		</tr>
		<tr>
				<td>terms and conditions</td>
				<td>${rb.termsandcotd}</td>
		</tr>
	</table>
</center>
</body>
</html>