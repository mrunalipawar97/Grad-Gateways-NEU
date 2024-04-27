<%-- 
    Author     : mrunalipawar
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Login - GRAD GATEWAYS NEU</title>
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
        .login-btn {
            background-color: #7DF9FF;
            color: #191970;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        .login-btn:hover {
            background-color: #6ec6dd;
        }
        .error {
            color: #dc3545;
        }
        .form-control {
            border-radius: 0.25rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="login-container">
            <h3 class="text-center">Student Login</h3>
            <form:form modelAttribute="student" action="${pageContext.request.contextPath}/students/login.htm" method="post" class="form-horizontal">
                <c:if test="${ requestScope.error != null}">
                    <div class="alert alert-danger" role="alert">
                        Invalid Username or Password
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="email">Student Email:</label>
                    <form:input path="email" type="text" name="email" class="form-control" required="true" />
                    <form:errors path="email" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="password">Student Password:</label>
                    <form:input path="password" type="password" name="password" class="form-control" required="true"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Login" class="login-btn btn btn-block">
                </div>
            </form:form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>