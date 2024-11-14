package com.studcourse.mgmt.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studcourse.mgmt.model.Course;
import com.studcourse.mgmt.service.CourseService;


public class CourseEditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEditFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private CourseService courseService = new CourseService();

    // Handle GET request to display course details in edit form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long courseId = Long.parseLong(request.getParameter("id"));
        
        // Fetch course details from the database using CourseService
        Course course = courseService.getCourseById(courseId);
        
        // Set the course object in the request scope to pass to JSP
        request.setAttribute("course", course);
        
        // Forward to the edit form (editCourse.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("editCourse.jsp");
        dispatcher.forward(request, response);
    }

	

}
