<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<title>Student Management</title>
<!-- You can add Bootstrap for better styling -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<jsp:include page="/header.jsp" />
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1 class="mb-0">Student Management</h1>
			<a href="add-student.jsp" class="btn btn-primary">Add Student</a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Major</th>
					<th>Actions</th>
					<th>EnrollmentActions</th>
				</tr>
			</thead>
			<tbody>
				<!-- JSTL to loop through the list of students -->
				<c:forEach var="student" items="${students}">
					<tr>
						<td>${student.id}</td>
						<td>${student.name}</td>
						<td>${student.email}</td>
						<td>${student.major}</td>
						<td>
							<!-- You can add links or buttons for actions like Edit/Delete -->
							<a href="editStudent?id=${student.id}" class="btn btn-primary">Edit</a>
							<a href="deleteStudent?id=${student.id}" class="btn btn-danger">Delete</a>
						</td>
						<td><a href="studentEnrollments?id=${student.id}"
							class="btn btn-success">Enrollments</a> <a
							href="enrollCoursesForm?id=${student.id}" class="btn btn-primary">EnrollCourses</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
