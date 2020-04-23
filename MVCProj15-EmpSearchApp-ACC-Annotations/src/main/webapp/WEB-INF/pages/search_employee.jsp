<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<body>
	<h1 style="color: green; text-align: center">Search Employee details
	</h1>
	<div align="center">
		<form action="search_emps.htm" method="POST">
			Employee no:: <input type="text" name="empno" value="0" /> <br>
			Employee name:: <input type="text" name="ename" /><br> Employee
			desg :: <input type="text" name="job" /><br> Employee salary ::
			<input type="text" name="sal" value="5001" /><br> <input
				type="submit" value="search Employess">
		</form>
	</div>
</body>
