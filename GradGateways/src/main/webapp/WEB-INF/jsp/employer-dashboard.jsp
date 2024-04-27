<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Employer Dashboard - GRAD Gateways NEU</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FFC0CB; 
            color: #000;
            text-align: center;
        }
        .btn-custom {
            background-color: #7DF9FF;
            border: none;
            color: #191970;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 5px;
            font-size: 1.2rem;
            cursor: pointer;
        }
        .btn-custom:hover {
            opacity: 0.8;
        }
        .dashboard-link {
            text-decoration: none;
            display: inline;
            width: 100%;
            margin-bottom: 10px;
        }
        .container {
            padding-top: 50px;
        }
        .logout-link {
            color: #191970;
            font-weight: bold;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Employer Dashboard</h1>
        <div class="dashboard-link">
            <button onclick="location.href='${pageContext.request.contextPath}/jobs/employer/addjob.htm'" class="btn-custom">Add Job to Portal</button>
        </div>
        <div class="dashboard-link">
            <button onclick="location.href='${pageContext.request.contextPath}/jobs/employer/viewjob.htm'" class="btn-custom">View Jobs</button>
        </div>
        <div class="dashboard-link">
            <button onclick="location.href='${pageContext.request.contextPath}/employer/viewApplications.htm'" class="btn-custom">View Received Job Applications</button>
        </div>
        <div class="dashboard-link">
            <button onclick="location.href='${pageContext.request.contextPath}/employer/viewprofile.htm'" class="btn-custom">View/Update Profile</button>
        </div>
        <div class="dashboard-link">
            <a href="${pageContext.request.contextPath}/employer/logout.htm" class="btn-custom logout-link">Logout</a>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
