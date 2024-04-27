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
    <title>Edit Employer Profile - GRAD Gateways NEU</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FFC0CB;
            color: #000;
            text-align: left;
        }
        .error {
            color: #FF0000;
        }
    </style>
</head>
<body class="bg-pink-100">
    <div class="container mt-5">
        <h1 class="mb-4">VIEW/UPDATE Employer Profile</h1>

        <form:form modelAttribute="employer" method="POST" action="${pageContext.request.contextPath}/employer/updateprofile.htm" class="needs-validation">
            <form:hidden path="id"/> <!-- Hidden field for the employer's id -->
            
            <div class="form-group">
                <label for="employerName">Employer Name:</label>
                <form:input path="employerName" id="employerName" class="form-control"/>
                <form:errors path="employerName" cssClass="text-danger"/>
            </div>

            <div class="form-group">
                <label for="employerEmail">Employer Email:</label>
                <form:input path="employerEmail" id="employerEmail" class="form-control"/>
                <form:errors path="employerEmail" cssClass="text-danger"/>
            </div>

            <div class="form-group">
                <label for="employerAddress">Employer Address:</label>
                <form:input path="employerAddress" id="employerAddress" class="form-control"/>
                <form:errors path="employerAddress" cssClass="text-danger"/>
            </div>

            <div class="form-group">
                <label for="employerPassword">Employer Password:</label>
                <form:textarea path="employerPassword" id="employerPassword" rows="5" class="form-control"/>
                <form:errors path="employerPassword" cssClass="text-danger"/>
            </div>

            <div class="form-group">
                <input type="submit" value="Update Profile" class="btn btn-primary"/>
            </div>
        </form:form>

        <a href="${pageContext.request.contextPath}/employer/dashboard.htm" class="btn btn-link">Back to Employer Dashboard</a>
    </div>

    <c:if test="${not empty sessionScope.updateSuccess}">
        <script type="text/javascript">
            alert('${requestScope.updateSuccess}');
            <c:remove var="updateSuccess" scope="session"/> 
        </script>
    </c:if>
</body>
</html>