<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
	.error
	{
		color:red;
		font-style:italic;
	}
</style>
</head>
<body>
<center>
	<h1>Registration Page</h1>
	<form:form action="Register" method="POST" modelAttribute="RegisterBeanMA">
		<table border="2">
			<tr>
				<!-- First name -->
				<td><label>FirstName: </label></td>
				<td><input type="text" name="firstName"/></td>
				<td><form:errors path="firstName" cssClass="error"/></td>
			</tr>
			<tr>
				<!-- Last name -->
				<td><label>LastName: </label></td>
				<td><input type="text" name="lastName"/></td>
				<td><form:errors path="lastName" cssClass="error"/></td>
			</tr>
			<tr>
				<td><label>Email: </label></td>
				<td><input type="email" name="email"/></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td><label>Password: </label></td>
				<td><input type="password" name="password"></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<!-- date of birth = must be past -->
			<tr>
				<td><label>Date of Birth: </label></td>
				<td><input name="dob" path="dob"/></td>
				<td><form:errors path="dob" cssClass="error"/></td>
			</tr>
			<!-- country name = dropdown -->
			<tr>
				<td><label>Country :</label></td>
				<td>
					<form:select path="country">
						<form:option value="" label="--Select--"/>
						<form:option value="IND" label="India"/>
						<form:option value="Uk" label="London"/>
						<form:option value="US" label="America"/>
					</form:select>
				</td>
				<td><form:errors path="country" cssClass="error"/></td>
			</tr>
			<!-- checkboxes -->
			<tr>
				<td><label>Preferred: </label></td>
				<td>
					<form:checkbox path="language" value="Tel" label="telugu"/>
					<form:checkbox path="language" value="Hin" label="Hindi"/>
					<form:checkbox path="language" value="Eng" label="English"/>
					<form:checkbox path="language" value="Othr" label="Others"/>
				</td>
				<td><form:errors path="language" cssClass="error"/></td>
			</tr>
			<!-- Radiobuttons -->
			<tr>
				<td><label>Gender: </label></td>
				<td>
					<form:radiobutton path="gender" value="M" label="Male"/>
					<form:radiobutton path="gender" value="F" label="Female"/>
				</td>
				<td><form:errors path="gender" cssClass="error"/></td>
			</tr>
			<!-- textarea -->
			<tr>
				<td>About yorself </td>
				<td>
					<form:textarea path="aboutYou"/>
				</td>
				<td><form:errors path="aboutYou" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<form:checkbox path="termsAndCotd" label="I agree terms"/>
				</td>
				<td><form:errors path="termsAndCotd" cssClass="error"/></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="Register"></td>
			</tr>
		</table>
		<spring:hasBindErrors name="RegisterBeanMA">
			<h3>All Errors</h3>
			<form:errors path="*" cssClass="error"></form:errors>
		</spring:hasBindErrors>
	</form:form>
</center>
</body>
</html>