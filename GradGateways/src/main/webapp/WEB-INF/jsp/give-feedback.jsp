<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Feedback Form - GRAD GATEWAYS NEU</title>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
	body {
		background-color: #f4f4f4;
		font-family: Arial, sans-serif;
	}
	
	.container {
		margin-top: 50px;
	}
	
	.error-message {
		color: #a94442;
	}
	
	.success-message {
		color: #28a745;
	}
	
	.btn-blue {
		background-color: #dc3545;
		color: white;
	}
	
	.btn-blue:hover {
		background-color: #c82333;
		color: white;
	}
</style>
</head>
<body>
	<div class="container">
		<h2>Feedback Form</h2>

		<c:if test="${not empty successMessage}">
			<div class="alert alert-success success-message">${successMessage}</div>
		</c:if>
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger error-message">${errorMessage}</div>
		</c:if>

		<form:form modelAttribute="feedback"
			action="${pageContext.request.contextPath}/feedback/form.htm"
			method="post" class="form-horizontal">
			<form:hidden path="employerName" />
			<form:hidden path="employerEmail" />
			<!-- Input for Student Name -->
			<div class="form-group">
				<form:label path="studentName" class="control-label col-sm-2">Student Name:</form:label>
				<div class="col-sm-10">
					<form:input path="studentName" class="form-control" />
					<form:errors path="studentName" cssClass="error-message" />
				</div>
			</div>

			<div class="form-group">
				<form:label path="message" class="control-label col-sm-2">Message:</form:label>
				<div class="col-sm-10">
					<form:textarea path="message" rows="4" class="form-control" />
					<form:errors path="message" cssClass="error-message" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Submit Feedback" class="btn btn-blue" />
				</div>
			</div>
		</form:form>
	</div>
	
	<a href="${pageContext.request.contextPath}/employer/dashboard.htm" class="btn btn-link">Back to Employer Dashboard</a>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>