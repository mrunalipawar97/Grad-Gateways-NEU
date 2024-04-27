<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Job Applications Received - GRAD Gateways NEU</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FFC0CB;
            color: #000;
            text-align: left;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f0f0f0;
        }
        .btn-update {
            background-color: #7DF9FF;
            border: none;
            color: #191970;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Job Applications Received</h1>
    <table class="table table-bordered">
        <thead class="thead-light">
            <tr>
                <th>Job Title</th>
                <th>Student Name</th>
                <th>Application Status</th>
                <th>Applied Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${jobApplication}" var="app">
                <tr>
                    <td>${app.job.jobtitle}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/employer/viewStudentProfile.htm?studentName=${app.studentName}">
                            ${app.studentName}
                        </a>
                    </td>
                    <td>${app.status}</td>
                    <td><fmt:formatDate value="${app.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/employer/updateApplicationStatus.htm" method="post">
                            <input type="hidden" name="applicationId" value="${app.applicationId}" />
                            <select name="status">
                                <option ${app.status == 'Pending' ? 'selected' : ''}>Pending</option>
                                <option ${app.status == 'Accepted' ? 'selected' : ''}>Accepted</option>
                                <option ${app.status == 'Rejected' ? 'selected' : ''}>Rejected</option>
                            </select>
                            <button type="submit" class="btn btn-primary" onclick="return confirm('Are you sure you want to update this status?');">Update Status</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${empty jobApplication}">
        <div class="alert alert-info">No applications received yet.</div>
    </c:if>
    <a href="${pageContext.request.contextPath}/employer/dashboard.htm" class="btn btn-secondary">Return to Employer Dashboard</a>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>