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
    <title>Feedback Overview - GRAD Gateways NEU</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            text-align: center;
        }
        table {
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            width: 80%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f0f0f0;
        }
        .logout-btn {
            color: #191970;
            background-color: #7DF9FF;
            border-color: #7DF9FF;
            padding: 5px 10px;
            border-radius: 5px;
            text-decoration: none;
            float: right;
            margin: 10px 20px;
        }
        .logout-btn:hover {
            background-color: #7DF9FF;
            border-color: #bd2130;
        }
    </style>
</head>
<body>
    <a href="${pageContext.request.contextPath}/admin/logout.htm" class="logout-btn">Logout</a>
    <h2>Feedback Overview</h2>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Employer Name</th>
                <th>Employer Email</th>
                <th>Student Name</th>
                <th>Message</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${feedbacks}" var="feedback">
                <tr>
                    <td>${feedback.id}</td>
                    <td>${feedback.employer.employerName}</td>
                    <td>${feedback.employer.employerEmail}</td>
                    <td>${feedback.studentName}</td>
                    <td>${feedback.message}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>