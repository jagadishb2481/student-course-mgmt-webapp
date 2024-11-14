package com.studcourse.mgmt.controller;

import com.studcourse.mgmt.model.Student;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

public class UpdateStudentServlet extends HttpServlet {

    private static final String STUDENT_API_URL = "http://localhost:8081/students"; 
    // POST method to handle form submission for updating student
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve updated student details from the form
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String major = request.getParameter("major");
        // Create a Student object to hold the updated details
        Student updatedStudent = new Student();
        updatedStudent.setId(Long.parseLong(id));
        updatedStudent.setName(name);
        updatedStudent.setEmail(email);
        updatedStudent.setMajor(major);

        // Create a RestTemplate object to make the HTTP request to the backend
        RestTemplate restTemplate = new RestTemplate();

        // Set the headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // Wrap the updated student object into an HttpEntity
        HttpEntity<Student> entity = new HttpEntity<>(updatedStudent, headers);

        // Make the PUT request to update the student 
        String updateUrl = STUDENT_API_URL + "/" + id; 
        ResponseEntity<Student> responseEntity = restTemplate.exchange(updateUrl, HttpMethod.PUT, entity, Student.class);
       
        // Check the response status and perform the appropriate action
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            // Redirect to the student list page after the update
            response.sendRedirect("students");
        } else {
            // Handle failure (if needed, e.g., show an error message)
            request.setAttribute("errorMessage", "Error updating student.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

	/*
	 * // GET method to show the edit form protected void doGet(HttpServletRequest
	 * request, HttpServletResponse response) throws ServletException, IOException {
	 * String id = request.getParameter("id");
	 * 
	 * // Call the backend service to get the student details (assuming GET method
	 * is available) RestTemplate restTemplate = new RestTemplate(); String apiUrl =
	 * STUDENT_API_URL + "/" + id; ResponseEntity<Student> studentResponse =
	 * restTemplate.exchange(apiUrl, HttpMethod.GET, null, Student.class);
	 * 
	 * if (studentResponse.getStatusCode() == HttpStatus.OK) { Student student =
	 * studentResponse.getBody(); request.setAttribute("student", student);
	 * request.getRequestDispatcher("editStudent.jsp").forward(request, response); }
	 * else { request.setAttribute("errorMessage", "Student not found.");
	 * request.getRequestDispatcher("error.jsp").forward(request, response); } }
	 */
}
