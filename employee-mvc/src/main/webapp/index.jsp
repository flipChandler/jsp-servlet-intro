<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
		<link href="https://unpkg.com/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
	</head>
	<body>
	
		<%
			String email = (String) session.getAttribute("email");
	
			if (email != null) {
				response.sendRedirect("EmployeeController?action=LIST");
			}
	
			String status = request.getParameter("status");
			if (status != null) {
				switch(status) {
					case "false":
						out.print("Bad Credentials");
						break;
					
					case "error":
						out.print("Some error occured");
						break;
				}
			}
	
		%>
	
		<div class="container">
			<form action="login" method="post">
				<div class="card">
					<div class="card-header">
						Employee App
					</div>
					<div class="card-body">
						<div class="form-group">
							<input type="text" name="email"  class="form-control" placeholder="Enter email"/>
						</div>
						<br />
						<div class="form-group">
							<input type="password" name="password" class="form-control" placeholder="Enter password"/>
						</div>
					</div>
					<div class="card-footer">
						<input type="submit" value="Login" class="btn btn-primary" />
					</div>
				</div>
			</form>
		</div>
	</body>
</html> 