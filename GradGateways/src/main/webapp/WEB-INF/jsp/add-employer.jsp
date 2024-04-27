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
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <form:form modelAttribute="employer" method="POST" class="form-horizontal needs-validation">
                <fieldset>
                    <legend>Employer Registration</legend>
                    
                    <div class="form-group">
                        <label for="employerName" class="col-form-label">Employer Name:</label>
                        <form:input path="employerName" type="text" name="employerName" class="form-control" required="required"/>
                        <form:errors path="employerName" cssClass="text-danger" />
                    </div>

                    <div class="form-group">
                        <label for="employerAddress" class="col-form-label">Employer Address:</label>
                        <form:input path="employerAddress" type="text" name="employerAddress" class="form-control" required="required"/>
                        <form:errors path="employerAddress" cssClass="text-danger" />
                    </div>

                    <div class="form-group">
                        <label for="employerEmail" class="col-form-label">Employer Email:</label>
                        <form:input path="employerEmail" type="text" name="employerEmail" class="form-control" required="required"/>
                        <form:errors path="employerEmail" cssClass="text-danger" />
                    </div>

                    <div class="form-group">
                        <label for="employerPassword" class="col-form-label">Employer Password:</label>
                        <form:input path="employerPassword" type="password" name="employerPassword" class="form-control" required="required"/>
                        <form:errors path="employerPassword" cssClass="text-danger" />
                    </div>

                    <div class="form-group text-center">
                        <input type="submit" value="Register" class="btn-register"" />
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>