<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-2">
<title>Confirm Page</title>
</head>
<body>
<center>
<h2>Confirmed Details Page</h2>
	<form:form action="Confirmed" method="POST" modelAttribute="RegisterBeanSubMA2">
		<table border="2">
			<tr>
				<!-- First name -->
				<td><label>FirstName: </label></td>
				<td>${RegisterBeanSubMA2.firstName}</td>
			</tr>
			<tr>
				<!-- Last name -->
				<td><label>LastName: </label></td>
				<td>${RegisterBeanSubMA2.lastName}</td>
			</tr>
			<tr>
				<td><label>Email: </label></td>
				<td>${RegisterBeanSubMA2.email}</td>
			</tr>
			<tr>
				<td><label>Password: </label></td>
				<td>${RegisterBeanSubMA2.password}</td>
			</tr>
			<!-- date of birth = must be past -->
			<tr>
				<td><label>Date of Birth: </label></td>
				<td>${RegisterBeanSubMA2.dob}</td>
			</tr>
			<!-- country name = dropdown -->
			<tr>
				<td><label>Country :</label></td>
				<td>
					${RegisterBeanSubMA2.country}
				</td>
			</tr>
			<!-- checkboxes -->
			<tr>
				<td><label>Preferred: </label></td>
				<td>
					${RegisterBeanSubMA2.language[0]}
					${RegisterBeanSubMA2.language[2]}
					${RegisterBeanSubMA2.language[2]}
					${RegisterBeanSubMA2.language[3]}
				</td>
			</tr>
			<!-- Radiobuttons -->
			<tr>
				<td><label>Gender: </label></td>
				<td>
					${RegisterBeanSubMA2.gender}
				</td>
			</tr>
			<!-- textarea -->
			<tr>
				<td>About yorself </td>
				<td>
					${RegisterBeanSubMA2.aboutYou}
				</td>
			</tr>
			<tr>
				<td>terms and conditions</td>
				<td colspan="3">
					${RegisterBeanSubMA2.termsAndCotd}
				</td>
			</tr>
		</table>
	</form:form>
</center>
</body>
</html>