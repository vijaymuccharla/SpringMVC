<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title> Registration </title>
</head>
<style>
table, tr, th, td, span {
	color:red;
	boder: 2px;
	border-collapse: collapse;
	background-color: lightgreen;
	padding: 10px;
	text-align: center;
}

</style>
<script type="text/javascript" src="js/validations.js">
</script>
<noscript>
		<h1 style="color:red;text-align:center"> ---- Your browser JavaScript is Disabled ----</h1>
</noscript>
<body>
	<div align="center">
		<h1 style="color:green;">Corona Patient Registration Form</h1>
		<form:form modelAttribute="patCmd" onsubmit="return formvalidate(this)" >
		
		<!-- to display all errors sent from validator -->
		<%-- <p style="color:red;align-items: center;">
			<li> <form:errors path="*"/>  </li>		
		</p> --%>
		
			<table>
				<tr>
					<th>Patient Name :</th>
					<td><form:input path="patName" /> <form:errors path="patName"/><span id="patNameErr"/></td>
				</tr>


				<tr>
					<th>Patient Age :</th>
					<td><form:input path="patAge" /><form:errors path="patAge"/><span id="patAgeErr"/></td>
				</tr>


				<tr>
					<th>Patient Location :</th>
					<td><form:input path="location" /><form:errors path="location"/><span id="locationErr"/></td>
				</tr>


				<tr>
					<th>Hospital :</th>
					<td><form:input path="hospital" /><form:errors path="hospital"/><span id="hospitalErr"/></td>
				</tr>


				<tr>
					<th><input type="submit" value="Register" /></th>
					<td><a href="index.jsp"> Reload</a></td>
				</tr>
	
				<form:hidden path="vflag"/>
	
			</table>
		</form:form>

	</div>


</body>
</html>
