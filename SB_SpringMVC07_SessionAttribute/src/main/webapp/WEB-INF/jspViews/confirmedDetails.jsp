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
	<h2>Confirmed Details</h2>
	<h3>${message}</h3>
	<h3>${eb}</h3>
	<h3>${eb.userName}</h3>
	<br>
	<table border="2">
		<tr>
			<td><label>Name: </label></td>
			<td>${eb.userName}</td>
		</tr>
		<tr>
			<td><label>Password: </label></td>
			<td>${eb.userPass}</td>
		</tr>
		<tr>
			<td><label>Age </label></td>
			<td>${eb.userAge}</td>		
		</tr>
		<tr>
			<td><label>Salary (2 decimals)</label></td>
			<td>${eb.userSalary}</td>
		</tr>
		<tr>
			<td><label>Gender: </label></td>
			<td>
				${eb.userGender}
			</td>
		</tr>
		<tr>
			<td><label>Select Country</label></td>
			<td>
				${eb.userCountry}
			</td>
		</tr>
		<tr>
			<td><label>Language known</label></td>
			<td>
				${eb.userLang[0]}
				${eb.userLang[1]}
				${eb.userLang[2]}
			</td>
		</tr>
		<tr>
			<td><label>Join Date(year/mon/date)</label>
			<td>
				<fmt:formatDate value="${eb.userDate}" pattern="yyyy-MMM-dd"/>
			</td>
		</tr>
		<tr>
			<td>Mention about you</td>
			<td>
				${eb.userAbout}
			</td>
		</tr>
		<tr>
			<td>Terms and conditions</td>
			<td>
				${eb.termsCotd}
			</td>
		</tr>
	</table>
</center>
</body>
</html>