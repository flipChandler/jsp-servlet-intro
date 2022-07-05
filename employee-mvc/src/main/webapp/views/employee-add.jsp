<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>edit employee</title>
		<link href="https://unpkg.com/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet" />
	</head>
	<body>

		<div class="container">	
			<div class="float-right">
				<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
			</div>
			<h1>Employee Directory</h1>	
			<hr />
			<div class="row">
				<div class="col-md-4">
					<form action="${pageContext.request.contextPath}/EmployeeController" method="post">
						<div class="form-group">
							<input type="text" name="firstname" value="${employee.name}" 
							placeholder="Enter name" class="form-control" />
						</div>
						<div class="form-group">
							<input type="date" name="dob" value="${employee.dob}" 
							placeholder="Enter date of birth" class="form-control" />
						</div>
						<div class="form-group">
							<input type="text" name="department" value="${employee.department}" 
							placeholder="Enter department" class="form-control" />
						</div>
						<input type="hidden" value="${employee.id}" name="id"/>
						<button class="btn btn-primary" type="submit">Save employee</button>
					</form>
				</div>
			</div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</body>
</html>