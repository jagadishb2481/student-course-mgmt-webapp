package com.studcourse.mgmt.controller;

import org.springframework.web.client.RestTemplate;
import com.studcourse.mgmt.model.Enrollment;
import com.studcourse.mgmt.model.EnrollmentRequest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessEnrollmentsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long studentId = Long.parseLong(request.getParameter("studentId"));
		String[] courseIds = request.getParameterValues("courseIds"); // Course IDs selected for enrollment

		if (courseIds != null) {
			List<Long> courseIdList = Stream.of(courseIds).map(str -> Long.parseLong(str)).collect(Collectors.toList());
			// Create the Enrollment object
			EnrollmentRequest enrollment = new EnrollmentRequest();
			enrollment.setStudentId(studentId);
			enrollment.setCourseIds(courseIdList);

			// Call the API to enroll the student in the selected courses
			String apiUrl = "http://localhost:8081/enrollments/enrollStudentInCourses";
			restTemplate.postForObject(apiUrl, enrollment, List.class);
			System.out.println("Enrollment of courses completed");
		}

		// After enrollment, redirect back to the enrollments page
		response.sendRedirect("studentEnrollments?id=" + studentId);
	}
}
