<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Course</title>
<!-- Add Bootstrap CSS from CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
</head>
<body>

	<div class="container mt-5">
		<jsp:include page="/header.jsp" />
		<h2>Edit Course</h2>

		<form action="updateCourse" method="post">
			<!-- Hidden field for course ID -->
			<input type="hidden" name="id" value="${course.id}" />

			<div class="form-group">
				<label for="courseName">CourseName</label> <input type="text"
					class="form-control" name="courseName" value="${course.courseName}"
					required />
			</div>

			<div class="form-group">
				<label for="description">Description</label> <input type="text"
					class="form-control" name="description"
					value="${course.description}" required />
			</div>
			<div class="form-group">
				<label for="schedule">Schedule</label> <input type="text"
					class="form-control" name="schedule" value="${course.schedule}" />
			</div>

			<button type="submit" class="btn btn-primary">Update Course</button>
			<a href="courses" class="btn btn-secondary">Cancel</a>
		</form>
	</div>

	<!-- Add Bootstrap JS and Popper.js for interactive elements -->
	<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 -->
</body>
</html>
