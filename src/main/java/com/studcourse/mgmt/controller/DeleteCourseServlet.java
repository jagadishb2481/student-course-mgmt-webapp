package com.studcourse.mgmt.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.web.client.RestTemplate;

import com.studcourse.mgmt.service.CourseService;


public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestTemplate resttemplate = new RestTemplate();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int courseId = Integer.parseInt(request.getParameter("id"));
		CourseService service = new CourseService();
		service.deleteCourseById(courseId);
        // Redirect to the course list after deletion
		response.sendRedirect("courses");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
