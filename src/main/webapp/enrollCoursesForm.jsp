<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<title>Student Enrollments</title>
<!-- You can add Bootstrap for better styling -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>


	<div class="container my-3">
		<jsp:include page="/header.jsp" />
		<h1>Enroll in Courses for Student ID: ${studentId}</h1>

		<form action="processEnrollments" method="POST">
			<input type="hidden" name="studentId" value="${studentId}" />

			<table class="table table-bordered mt-3">
				<thead>
					<tr>
						<th>Select</th>
						<th>Course ID</th>
						<th>Course Name</th>
						<th>Schedule</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${availableCourses}">
						<tr>
							<td><input type="checkbox" name="courseIds"
								value="${course.id}" /></td>
							<td>${course.id}</td>
							<td>${course.courseName}</td>
							<td>${course.schedule}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<button type="submit" class="btn btn-success">Enroll
				Selected Courses</button>
				<a href="studentEnrollments?id=${studentId}"
			class="btn btn-secondary ">Back to Enrollments</a>
			
		</form>

		
	</div>
</body>
</html>
