<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Admin Dashboard - GRAD GATEWAYS NEU</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<style>
	body {
		background-color: #FFC0CB;
		color: #000;
		font-family: Arial, sans-serif;
		padding-top: 20px;
	}
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>Admin Dashboard</h1>
				<div class="mb-3">
					<a href="${pageContext.request.contextPath}/admin/logout.htm" class="btn btn-info">Logout</a>
					<a href="${pageContext.request.contextPath}/admin/viewfeedbacks.htm" class="btn btn-info">View Feedback</a>
				</div>
				<div class="row">
					<div class="col-md-6">
						<h2>Students</h2>
						<table class="table table-bordered">
							<thead class="thead-light">
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Email</th>
									<th>Major</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${students}" var="student">
									<tr>
										<td>${student.id}</td>
										<td>${student.name}</td>
										<td>${student.email}</td>
										<td>${student.major}</td>
										<td>
											<form action="${pageContext.request.contextPath}/admin/deletestudent.htm" method="POST">
												<input type="hidden" name="studentName" value="${student.name}" />
												<button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this student?');">Delete</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-md-6">
						<h2>Employers</h2>
						<table class="table table-striped">
							<thead class="thead-light">
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Email</th>
									<th>Address</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employers}" var="employer">
									<tr>
										<td>${employer.id}</td>
										<td>${employer.employerName}</td>
										<td>${employer.employerEmail}</td>
										<td>${employer.employerAddress}</td>		
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
</body>
</html>