<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title> Registration </title>
</head>
<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: lightgreen;
	padding: 10px;
	text-align: center;
}
</style>

<body>
	<div align="center">
		<h1 style="color:green;">Corona Patient Registration Form</h1>
		<form:form modelAttribute="patCmd">
			<table>
				<tr>
					<th>Patient Name :</th>
					<td><form:input path="patName" /></td>
				</tr>


				<tr>
					<th>Patient Age :</th>
					<td><form:input path="patAge" /></td>
				</tr>


				<tr>
					<th>Patient Location :</th>
					<td><form:input path="location" /></td>
				</tr>


				<tr>
					<th>Hospital :</th>
					<td><form:input path="hospital" /></td>
				</tr>


				<tr>
					<th><input type="submit" value="Register" /></th>
					<td><input type="reset" value="cancel"></td>
				</tr>

			</table>
		</form:form>

	</div>


</body>
</html>
