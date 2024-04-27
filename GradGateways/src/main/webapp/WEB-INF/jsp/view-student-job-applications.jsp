<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>GRAD Gateways NEU</title>
    <style>
            body {
            font-family: Arial, sans-serif;
            background-color: #FFC0CB; 
            color: #000;
            text-align: left;
        }
    </style>
	<link rel="stylesheet" href="//path-to-your-css-files/style.css"> <!-- Link to your CSS file -->
</head>
<body>
    <div class="container">
        <h2>My Job Applications</h2>
        <table border="1" class="table">
            <thead>
                <tr>
                    <th>Job Title</th>
                    <th>Application Status</th>
                    <th>Applied Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${jobApplication}" var="application">
                    <tr>
                        <td>${application.job.jobtitle}</td>
                        <td>${application.status}</td>
                        <td><fmt:formatDate value="${application.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/students/dashboard.htm">Return to Student Dashboard</a>
    </div>
</body>
</html>