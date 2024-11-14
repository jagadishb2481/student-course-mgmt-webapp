<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<title>Course Management</title>
<!-- You can add Bootstrap for better styling -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<jsp:include page="/header.jsp" />
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1 class="mb-0">Course Management</h1>
			<a href="add-course.jsp" class="btn btn-primary">Add Course</a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>CourseName</th>
					<th>Description</th>
					<th>Schedule</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<!-- JSTL to loop through the list of courses -->
				<c:forEach var="course" items="${courses}">
					<tr>
						<td>${course.id}</td>
						<td>${course.courseName}</td>
						<td>${course.description}</td>
						<td>${course.schedule}</td>
						<td>
							<!-- You can add links or buttons for actions like Edit/Delete -->
							<a href="editCourse?id=${course.id}" class="btn btn-primary">Edit</a>
							<a href="deleteCourse?id=${course.id}" class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
