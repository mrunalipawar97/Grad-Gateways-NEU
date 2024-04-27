<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GRAD Gateways NEU</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #FFC0CB;
            color: #000;
            font-family: Arial, sans-serif;
        }
        .error {
            color: #FF0000;
        }
        .center-div {
            margin: auto;
            width: 50%;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-8 center-div">
            <h2 class="text-center">Add New Job Posting</h2>
            <form:form action="${pageContext.request.contextPath}/jobs/employer/addjob.htm" method="post" modelAttribute="jobPosting" class="needs-validation">
                <div class="form-group">
                    <label>Employer Name:</label>
                    <form:input path="employerName" readonly="true" class="form-control" />
                </div>
                <div class="form-group">
                    <label>Job Title:</label>
                    <form:input path="jobtitle" class="form-control" />
                    <form:errors path="jobtitle" cssClass="error" />
                </div>
                <div class="form-group">
                    <label>Description:</label>
                    <form:textarea path="description" rows="4" class="form-control" />
                    <form:errors path="description" cssClass="error" />
                </div>
                <div class="form-group">
                    <label>Location:</label>
                    <form:input path="location" class="form-control" />
                    <form:errors path="location" cssClass="error" />
                </div>
                <div class="form-group">
                    <label>Posted Date:</label>
                    <form:input path="postedDate" class="form-control" />
                    <form:errors path="postedDate" cssClass="error" />
                </div>
                <div class="form-group text-center">
                    <input type="submit" value="Add Job Posting" class="btn btn-primary" />
                </div>
            </form:form>
            <div class="text-center">
                <h5><a href="${pageContext.request.contextPath}/employer/logout.htm">Logout</a></h5>
                <h5><a href="${pageContext.request.contextPath}/jobs/employer/viewjob.htm">View Jobs</a></h5>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>