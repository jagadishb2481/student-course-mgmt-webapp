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
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1>Enrollments for Student ID: ${studentId}</h1>
			<a href="enrollCoursesForm?id=${studentId}" class="btn btn-primary">EnrollCourses</a>
		</div>
		<table class="table table-bordered mt-3">
			<thead>
				<tr>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Schedule</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty courses}">
					<c:forEach var="course" items="${courses}">
						<tr>
							<td>${course.id}</td>
							<td>${course.courseName}</td>
							<td>${course.schedule}</td>
							<td><a
								href="deleteEnrollment?studentId=${studentId}&courseId=${course.id}"
								class="btn btn-danger btn-sm">Delete</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty courses}">
					<tr>
						<td colspan="4">No courses found for this student.</td>
					</tr>
				</c:if>
			</tbody>
		</table>

		<a href="students" class="btn btn-secondary">Back to Student List</a>
	</div>
</body>
</html>
