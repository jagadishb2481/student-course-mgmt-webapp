package com.studcourse.mgmt.controller;

import com.studcourse.mgmt.model.Course;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class UpdateCourseServlet extends HttpServlet {

    private static final String COURSE_API_URL = "http://localhost:8081/courses"; 
    // POST method to handle form submission for updating course
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve updated course details from the form
    	String id = request.getParameter("id");
        String courseName = request.getParameter("courseName");
        String description = request.getParameter("description");
        String schedule = request.getParameter("schedule");
        // Create a Course object to hold the updated details
        Course updateCourse = new Course();
        updateCourse.setId(Long.parseLong(id));
        updateCourse.setCourseName(courseName);
        updateCourse.setDescription(description);
        updateCourse.setSchedule(schedule);        // Create a RestTemplate object to make the HTTP request to the backend
        RestTemplate restTemplate = new RestTemplate();

        // Set the headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // Wrap the updated course object into an HttpEntity
        HttpEntity<Course> entity = new HttpEntity<>(updateCourse, headers);

        // Make the PUT request to update the course 
        String updateUrl = COURSE_API_URL + "/" + id; 
        ResponseEntity<Course> responseEntity = restTemplate.exchange(updateUrl, HttpMethod.PUT, entity, Course.class);
       
        // Check the response status and perform the appropriate action
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            // Redirect to the course list page after the update
            response.sendRedirect("courses");
        } else {
            // Handle failure (if needed, e.g., show an error message)
            request.setAttribute("errorMessage", "Error updating course.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

	/*
	 * // GET method to show the edit form protected void doGet(HttpServletRequest
	 * request, HttpServletResponse response) throws ServletException, IOException {
	 * String id = request.getParameter("id");
	 * 
	 * // Call the backend service to get the course details (assuming GET method
	 * is available) RestTemplate restTemplate = new RestTemplate(); String apiUrl =
	 * COURSE_API_URL + "/" + id; ResponseEntity<Course> courseResponse =
	 * restTemplate.exchange(apiUrl, HttpMethod.GET, null, Course.class);
	 * 
	 * if (courseResponse.getStatusCode() == HttpStatus.OK) { Course course =
	 * courseResponse.getBody(); request.setAttribute("course", course);
	 * request.getRequestDispatcher("editCourse.jsp").forward(request, response); }
	 * else { request.setAttribute("errorMessage", "Course not found.");
	 * request.getRequestDispatcher("error.jsp").forward(request, response); } }
	 */
}
