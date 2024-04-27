<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employer Login - GRAD Gateways NEU</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FFC0CB;
            color: #000;
        }
        .login-container {
            max-width: 400px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
            margin-top: 50px;
        }
        .btn-primary {
            background-color: #7DF9FF;
            color: #191970;
            border: none;
        }
        .btn-primary:hover {
            background-color: #6ec6dd;
        }
        .form-control {
            border-radius: 0.25rem;
        }
        .text-danger {
            color: #dc3545;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="login-container">
            <h3 class="text-center">Employer Login</h3>
            <form:form modelAttribute="employer" action="${pageContext.request.contextPath}/employer/login.htm" method="POST" class="needs-validation">
                <c:if test="${not empty loginError}">
                    <div class="alert alert-danger">${loginError}</div>
                </c:if>
                <div class="form-group">
                    <label for="employerEmail">Employer Email:</label>
                    <form:input path="employerEmail" type="text" class="form-control" required="true"/>
                    <form:errors path="employerEmail" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="employerPassword">Employer Password:</label>
                    <form:input path="employerPassword" type="password" class="form-control" required="true"/>
                    <form:errors path="employerPassword" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Login" class="btn btn-primary btn-block"/>
                </div>
            </form:form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>