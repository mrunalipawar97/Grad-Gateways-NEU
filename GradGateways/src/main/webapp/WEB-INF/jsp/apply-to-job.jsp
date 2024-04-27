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

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Available Jobs</h1>
	<table>
		<thead>
			<tr>
				<th>Job Title</th>
				<th>Description</th>
				<th>Location</th>
				<th>Posted Date</th>
				<th>Employer Name</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${jobPostings}" var="job">
    	<tr>
        <td>${job.jobtitle}</td>
        <td>${job.description}</td>
        <td>${job.location}</td>
        <td><fmt:formatDate value="${job.postedDate}" pattern="yyyy-MM-dd HH:mm" /></td>
        <td>${job.employerName}</td>
        <td>
            <c:if test="${!appliedJobIds.contains(job.id)}">
                <!-- Form for applying to the job -->
                <form action="${pageContext.request.contextPath}/students/jobapply.htm" method="post">
                    <input type="hidden" name="jobId" value="${job.id}" />
                    <input type="submit" value="Apply" />
                </form>
            </c:if>
            <c:if test="${appliedJobIds.contains(job.id)}">
                Application Submitted
            </c:if>
        </td>
    </tr>
</c:forEach>
		</tbody>
	</table>
	<c:if test="${empty jobPostings}">
		<p class="error">No jobs posted yet.</p>
	</c:if>
	
	<a href="${pageContext.request.contextPath}/students/dashboard.htm">Return to Student Dashboard</a>
</body>
</html>