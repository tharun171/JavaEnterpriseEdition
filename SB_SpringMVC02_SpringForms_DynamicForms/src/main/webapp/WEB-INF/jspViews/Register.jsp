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
<title>Regsiter Page Dynamic Values</title>
</head>
<body>
<center>
<h2>Register form</h2>
<form:form action="Register" method="POST" modelAttribute="RegisterBeanMA">
	<table border="2">
		<tr>
			<td><label>Name: </label></td>
			<td><form:input type="text" path="userName"/></td>
		</tr>
		<tr>
			<td><label>Password: </label></td>
			<td><form:password path="userPass"/></td>
		</tr>
		<tr>
			<td><label>Salary (2 decimals)</label></td>
			<td><form:input path="userSalary"/></td>
		</tr>
		<tr>
			<td><label>Gender: </label></td>
			<td>
				<form:radiobuttons path="userGender" items="${genders}"/>
			</td>
		</tr>
		<tr>
			<td><label>Select Country</label></td>
			<td>
				<form:select path="userCountry">
					<form:option value="--Select--"/>
					<form:options items="${countryList}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><label>Language known</label></td>
			<td>
				<form:checkboxes items="${languages}" path="userLang"/>
			</td>
		</tr>
		<tr>
			<td><label>Join Date(year/mon/date)</label>
			<td>
				<form:input path="userDate"/>
			</td>
		</tr>
		<tr>
			<td>Mention about you</td>
			<td>
				<form:textarea path="userAbout"/>
			</td>
		</tr>
		<tr>
				<td>terms and conditions</td>
				<td><form:checkbox path="termsCotd" label="Accept terms and conditions"/></td>
		</tr>
	</table>
	<br>
		<input type="submit" value="Register!"/>
</form:form>
</center>
</body>
</html>