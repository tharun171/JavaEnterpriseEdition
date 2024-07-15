<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
.error
{
	color:#ff0000;
	font-style:italic;
}
</style>
</head>
<body>
<center>
<h2>Registration Form</h2>
<h5>The Ui componenets(values of dropdowns,checkboxes) are given from dao</h5>
<form:form action="register" method="POST" modelAttribute="DetailsMA">
<table border="2">
	<tr>
		<td><label>UserName:</label></td>
		<td><form:input type="text" path="username"/></td>
		<td><form:errors path="username" cssClass="error"/>
	</tr>
	<tr>
		<td><label>password</label></td>
		<td><form:password path="password"/></td>
		<td><form:errors path="password" cssClass="error"/>
	</tr>
	<!-- radiobuttons -->
	<tr>
		<td>Gender</td>
		<td>
			<form:radiobuttons path="gender" items="${gender}"/>
		</td>
		<td><form:errors path="gender" cssClass="error"/>
	</tr>
	<!-- Drop down options -->
	<tr>
		<td>country</td>
		<td>
		<form:select path="country">
			<form:option value="" label="--Select--"/>
			<form:options items="${dropDownOptions}"/>
		</form:select>
		</td>
		<td><form:errors path="country" cssClass="error"/>
	</tr>
	<!-- textarea -->
	<tr>
		<td>About you</td>
		<td><form:textarea path="aboutYou"/></td>
		<td><form:errors path="aboutYou" cssClass="error"/>
	</tr>
	<!-- checkboxes -->
	<tr>
		<td>preferred language</td>
		<td><form:checkboxes items="${preferredLanguages}" path="language"/></td>
		<td><form:errors path="language" cssClass="error"/>
	</tr>
	<tr>
		<td>Salary: </td>
		<td><form:input path="salary"/></td>
		<td><form:errors path="salary" cssClass="error"/>
	</td>
	<tr>
		<td>age: </td>
		<td><form:input path="age"/></td>
		<td><form:errors path="age" cssClass="error"/>
	<tr>
	<tr>
		<td>Joining Date: </td>
		<td><form:input path="joiningDate"/></td>
		<td><form:errors path="joiningDate" cssClass="error"/>
	<tr>
	<tr>
		<td colspan="2"><form:checkbox path="mailingList" label="would you like to join our playlist"/></td>
		<td><form:errors path="mailingList" cssClass="error"/></td>
	</tr>
	<tr align="center">
		<td colspan="3"><input type="Submit" value="Register"/></td>
	</tr>
</table>
	<spring:hasBindErrors name="DetailsMA">
		<h3>All Errors</h3>
		<form:errors path="*" cssClass="error"/>
	</spring:hasBindErrors>
</form:form>
<a href="${pageContext.request.contextPath}/">Home</a>
</center>
</body>
</html>