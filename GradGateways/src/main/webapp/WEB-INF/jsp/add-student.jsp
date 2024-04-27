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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #FFC0CB;
            color: #000;
            font-family: Arial, sans-serif;
        }
        .error {
            color: #FF0000;
        }
        .btn-register {
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
    <div class="container mt-5">
        <h2 class="mb-4 text-center">Student Registration</h2>
        <form:form modelAttribute="student" method="POST" enctype="multipart/form-data" class="form-horizontal needs-validation">
            <div class="form-row">
                <div class="form-group col-md-6 offset-md-3">
                    <label for="name">Full Name:</label>
                    <form:input path="name" type="text" class="form-control" id="name" required="required"/>
                    <form:errors path="name" cssClass="error form-text text-danger"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6 offset-md-3">
                    <label for="email">E-mail:</label>
                    <form:input path="email" type="text" class="form-control" id="email" required="required"/>
                    <form:errors path="email" cssClass="error form-text text-danger"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6 offset-md-3">
                    <label for="skill">Skills:</label>
                    <form:input path="skill" type="text" class="form-control" id="skill" required="required"/>
                    <form:errors path="skill" cssClass="error form-text text-danger"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6 offset-md-3">
                    <label for="major">Major:</label>
                    <form:input path="major" type="text" class="form-control" id="major" required="required"/>
                    <form:errors path="major" cssClass="error form-text text-danger"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6 offset-md-3">
                    <label for="password">Password:</label>
                    <form:input path="password" type="password" class="form-control" id="password" required="required"/>
                    <form:errors path="password" cssClass="error form-text text-danger"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6 offset-md-3">
                    <label for="resume">Upload Resume (PDF only):</label>
                    <input type="file" name="resume" class="form-control" accept="application/pdf" required="required"/>
                </div>
            </div>

            <div class="form-row">
                <div class="col-md-6 offset-md-3 text-center">
                    <button type="submit" class="btn btn-register"">Register</button>
                </div>
            </div>
        </form:form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
</body>
</html>