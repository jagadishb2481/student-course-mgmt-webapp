package com.studcourse.mgmt.controller;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.studcourse.mgmt.model.Course;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnrollCoursesFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.parseInt(request.getParameter("id"));
        
        // Get all available courses
        String allCoursesUrl = "http://localhost:8081/courses";  // Assuming the API to fetch all courses
       // List<Course> allCourses = restTemplate.getForObject(allCoursesUrl, List.class);

        ResponseEntity<List<Course>> allCoursesResponse = restTemplate.exchange(
        		allCoursesUrl, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<Course>>() {}
        );
        List<Course> allCourses = allCoursesResponse.getBody();
        // Get the courses the student is already enrolled in
        String enrolledCoursesUrl = "http://localhost:8081/enrollments/student/" + studentId + "/courses";
        ResponseEntity<List<Course>> enrolledCoursesResponse = restTemplate.exchange(
                enrolledCoursesUrl, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<Course>>() {}
        );
        List<Course> enrolledCourses = enrolledCoursesResponse.getBody();

        System.out.println("enrolledCourses:"+enrolledCourses);
        List<Course> availableCourses = new ArrayList<>();
     // Remove already enrolled courses from the list of available courses
        if(CollectionUtils.isNotEmpty(enrolledCourses)) {
        	List<Long> enrolledCourseIds = new ArrayList<Long>();
        	for(Course enrolledCourse:enrolledCourses) {
        		enrolledCourseIds.add(enrolledCourse.getId());
        	}
        	System.out.println("enrolledCourseIds:"+enrolledCourseIds);
        	for(Course course:allCourses) {
        		if(!enrolledCourseIds.stream().anyMatch(id -> id.equals(course.getId()))) {
        			availableCourses.add(course);
        		}
        	}
			/*
			 * availableCourses = allCourses.stream() .filter(course ->
			 * enrolledCourses.stream() .noneMatch(enrolledCourse ->
			 * enrolledCourse.getId().equals(course.getId())))
			 * .collect(Collectors.toList());
			 */
        }else {
        	availableCourses = allCourses;
        }
        System.out.println("availableCourses:"+availableCourses);
       // Set attributes to be accessed in the JSP
        request.setAttribute("availableCourses", availableCourses);
        request.setAttribute("studentId", studentId);

        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("enrollCoursesForm.jsp");
        dispatcher.forward(request, response);
    }
}
