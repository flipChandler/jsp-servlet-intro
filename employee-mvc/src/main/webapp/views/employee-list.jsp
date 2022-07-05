<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>list of employees</title>
		<link href="https://unpkg.com/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet" />
		<link href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css" rel="stylesheet"  type="text/css" />
	</head>
	<body>
		<%
			String email = (String) session.getAttribute("email");
		
			if (email == null) {
				response.sendRedirect("index.jsp");
			}
		%>
	
		<div class="container">
			<div class="float-right">
				<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
			</div>
			<p>${message}</p>
			<button 
				class="btn btn-primary"
				onclick="window.location.href='views/employee-add.jsp'">
				Add Employee
			</button>
			<table class="table table-striped" id="datatable">
				<thead>
					<tr class="table-dark">
						<th>Name</th>
						<th>Department</th>
						<th>Date of Birth</th>
						<th>Actions</th>
					</tr>
				</thead>
				<c:forEach items="${employees}" var="employee">
					<tbody>
						<tr>
							<td>${employee.name}</td>
							<td>${employee.department}</td>
							<td>${employee.dob}</td>
							<td>
								<a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">
									Edit
								</a>
								|
								<a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}">
									Delete
								</a>
							</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script>
		<script>
			$(document).ready(() => {
				$("#datatable").DataTable();
			})
		</script>	
	</body>
</html>