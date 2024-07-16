<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submitted page</title>
</head>
<body>
<center>
<h1>Submitted Details Page</h1>
		<table border="2">
			<tr>
				<!-- First name -->
				<td><label>FirstName: </label></td>
				<td>${RegisterBeanSubMA1.firstName}</td>
			</tr>
			<tr>
				<!-- Last name -->
				<td><label>LastName: </label></td>
				<td>${RegisterBeanSubMA1.lastName}</td>
			</tr>
			<tr>
				<td><label>Email: </label></td>
				<td>${RegisterBeanSubMA1.email}</td>
			</tr>
			<tr>
				<td><label>Password: </label></td>
				<td>${RegisterBeanSubMA1.password}</td>
			</tr>
			<!-- date of birth = must be past -->
			<tr>
				<td><label>Date of Birth: </label></td>
				<td>
				${RegisterBeanSubMA1.dob}
				</td>
			</tr>
			<!-- country name = dropdown -->
			<tr>
				<td><label>Country :</label></td>
				<td>
					${RegisterBeanSubMA1.country}
				</td>
			</tr>
			<!-- checkboxes -->
			<tr>
				<td><label>Preferred: </label></td>
				<td>
					${RegisterBeanSubMA1.language[0]}
					${RegisterBeanSubMA1.language[1]}
					${RegisterBeanSubMA1.language[2]}
					${RegisterBeanSubMA1.language[3]}
				</td>
			</tr>
			<!-- Radiobuttons -->
			<tr>
				<td><label>Gender: </label></td>
				<td>
					${RegisterBeanSubMA1.gender}
				</td>
			</tr>
			<!-- textarea -->
			<tr>
				<td>About yorself </td>
				<td>
					${RegisterBeanSubMA1.aboutYou}
				</td>
			</tr>
			<tr>
				<td>Terms and cotd. :</td>
				<td colspan="3">
					${RegisterBeanSubMA1.termsAndCotd}
				</td>
			</tr>
		</table>
		<button><a href="${pageContext.request.contextPath}/Confirm">Confirm Details</a></button>
</center>
</body>
</html>