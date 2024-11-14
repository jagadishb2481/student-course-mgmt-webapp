package com.studcourse.mgmt.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studcourse.mgmt.model.Student;
import com.studcourse.mgmt.service.StudentService;

/**
 * Servlet implementation class StudentEditFormServlet
 */
//@WebServlet("/StudentEditFormServlet")
public class StudentEditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private StudentService studentService = new StudentService();

    // Handle GET request to display student details in edit form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long studentId = Long.parseLong(request.getParameter("id"));
        
        // Fetch student details from the database using StudentService
        Student student = studentService.getStudentById(studentId);
        
        // Set the student object in the request scope to pass to JSP
        request.setAttribute("student", student);
        
        // Forward to the edit form (editStudent.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("editStudent.jsp");
        dispatcher.forward(request, response);
    }

	

}
