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
    <title>Student Profile - GRAD GATEWAYS NEU</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FFC0CB; 
            color: #000;
            text-align: center;
        }
        table {
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #000;
        }
        .btn-blue {
            background-color: #7DF9FF;
            border: none;
            color: #191970;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px 2px;
            cursor: pointer;
            border-radius: 5px;
        }
        .btn-blue:hover {
            background-color: #7DF9FF;
        }
        .button-container {
            margin: 20px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1>Student Profile</h1>
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Student Name</th>
                    <th>Student Email</th>
                    <th>Student Major</th>
                    <th>Student Skills</th>
                    <th>Student Resume</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.major}</td>
                    <td>${student.skill}</td>
                    <td><a href="${pageContext.request.contextPath}/employer/studentResumeByName/${student.name}" target="_blank" class="btn btn-primary">View Resume</a></td>
                </tr>
            </tbody>
        </table>
        <div class="button-container">
            <a href="${pageContext.request.contextPath}/feedback/form.htm?studentName=${student.name}" class="btn-blue">Give Student Feedback</a>
            <a href="${pageContext.request.contextPath}/employer/viewApplications.htm" class="btn-blue">Back to Job Applications</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>