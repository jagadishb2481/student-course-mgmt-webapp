<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Student</title>
<!-- Add Bootstrap CSS from CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
</head>
<body>

	<div class="container mt-5">
		<jsp:include page="/header.jsp" />
		<h2>Edit Student</h2>

		<form action="updateStudent" method="post">
			<!-- Hidden field for student ID -->
			<input type="hidden" name="id" value="${student.id}" />

			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" name="name" value="${student.name}" required />
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" name="email" value="${student.email}" required />
			</div>
			<div class="form-group">
				<label for="major">Major</label> <input type="text"
					class="form-control" name="major" value="${student.major}" />
			</div>

			<button type="submit" class="btn btn-primary">Update Student</button>
			<a href="students" class="btn btn-secondary">Cancel</a>
		</form>
	</div>

	<!-- Add Bootstrap JS and Popper.js for interactive elements -->
	<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 -->
</body>
</html>
