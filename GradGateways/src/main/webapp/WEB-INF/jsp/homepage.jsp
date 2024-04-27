<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GRAD Gateways NEU</title>
    <!-- Bootstrap CSS for responsive and attractive components -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- Custom styles -->
    <style>
        body {
            font-family: 'Nunito', sans-serif;
            background-color: #FFC0CB; 
                        color: #495057;
            text-align: center;
            margin-top: 40px;
        }
        h1 {
            margin-bottom: 40px;
        }
        .nav {
            justify-content: center;
            padding: 0;
        }
        .nav-item {
            list-style-type: none;
        }
        .nav-link {
            background-color: #007bff;
            color: white;
            border-radius: 5px;
            padding: 10px 20px;
            margin: 5px;
            display: inline-block;
            text-decoration: none;
            transition: background-color 0.2s ease-in-out;
        }
        .nav-link:hover, .nav-link:focus {
            background-color: #0056b3;
            text-decoration: none;
        }
        .action-buttons {
            display: none;
        }
    </style>
</head>
<body>

    <h1>Welcome to GRAD GATEWAYS NEU - Job Portal</h1>
    
    <select id="userType" class="custom-select w-auto mt-3">
        <option value="">Select User Type...</option>
        <option value="Student">Student</option>
        <option value="Employer">Employer</option>
        <option value="Admin">Admin</option>
    </select>

    <div id="Student" class="action-buttons">
        <a href="${pageContext.request.contextPath}/students/registerstudent.htm" class="btn btn-info mt-2">Register as Student</a>
        <a href="${pageContext.request.contextPath}/students/login.htm" class="btn btn-info mt-2">Login as Student</a>
    </div>

    <div id="Employer" class="action-buttons">
        <a href="${pageContext.request.contextPath}/employer/registeremployer.htm" class="btn btn-info mt-2">Register as Employer</a>
        <a href="${pageContext.request.contextPath}/employer/login.htm" class="btn btn-info mt-2">Login as Employer</a>
    </div>

    <div id="Admin" class="action-buttons">
        <a href="${pageContext.request.contextPath}/admin/login.htm" class="btn btn-info mt-2">Admin Login</a>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script>
        // Script to handle user type selection and display corresponding action buttons
        document.getElementById('userType').addEventListener('change', function() {
            var userType = this.value;
            var actionButtons = document.getElementsByClassName('action-buttons');
            for (var i = 0; i < actionButtons.length; i++) {
                actionButtons[i].style.display = 'none'; // Hide all action buttons
            }
            if (userType) {
                document.getElementById(userType).style.display = 'block'; // Show the action buttons for the selected user type
            }
        });
    </script>
</body>
</html>