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
<style>
	.error
	{
		color:#ff0000;
		font-style=italic;
	}
</style>
</head>
<body>
<center>
<h2>Register form</h2>
<form:form action="Register" method="POST" modelAttribute="RegisterBeanMA">
	<table border="2">
		<tr>
			<td><label>Name: </label></td>
			<td><form:input type="text" path="userName"/></td>
			<td><form:errors path="userName" cssClass="error"/>
		</tr>
		<tr>
			<td><label>Password: </label></td>
			<td><form:password path="userPass"/></td>
			<td><form:errors path="userPass" cssClass="error"/>
		</tr>
		<tr>
			<td><label>Salary (2 decimals)</label></td>
			<td><form:input path="userSalary"/></td>
			<td><form:errors path="userSalary" cssClass="error"/>
		</tr>
		<tr>
			<td><label>Gender: </label></td>
			<td>
				<form:radiobuttons path="userGender" items="${genders}"/>
			</td>
			<td><form:errors path="userGender" cssClass="error"/>
		</tr>
		<tr>
			<td><label>Select Country</label></td>
			<td>
				<form:select path="userCountry">
					<form:option value="" label="--Select--"/>
					<form:options items="${countryListSameNameAndValue}"/>
				</form:select>
				<td><form:errors path="userCountry" cssClass="error"/>
			</td>
		</tr>
		<tr>
			<td><label>Language known</label></td>
			<td>
				<form:checkboxes items="${languages}" path="userLang"/>
			</td>
			<td><form:errors path="userLang" cssClass="error"/>
		</tr>
		<tr>
			<td><label>Join Date(year/mon/date)</label>
			<td>
				<form:input path="userDate"/>
			</td>
			<td><form:errors path="userDate" cssClass="error"/>
		</tr>
		<tr>
			<td>Mention about you</td>
			<td>
				<form:textarea path="userAbout"/>
			</td>
			<td><form:errors path="userAbout" cssClass="error"/>
		</tr>
		<tr>
				<td>terms and conditions</td>
				<td><form:checkbox path="termsCotd" label="Accept terms and conditions"/></td>
				<td><form:errors path="termsCotd" cssClass="error"/>
		</tr>
	</table>
	<br>
		<input type="submit" value="Register!"/>
		<spring:hasBindErrors name="RegisterBeanMA">
				<h3>All Errors</h3>
				<form:errors path="*" cssClass="error" />
		</spring:hasBindErrors>
</form:form>
</center>
</body>
</html>