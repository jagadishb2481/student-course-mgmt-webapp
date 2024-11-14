package com.studcourse.mgmt.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.studcourse.mgmt.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
        String apiUrl = "http://localhost:8081/students";

        List<Student> students;
		students = restTemplate.getForObject(apiUrl, List.class);
		
		System.out.println("students:"+students);
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
        dispatcher.forward(request, response);
    }
}
