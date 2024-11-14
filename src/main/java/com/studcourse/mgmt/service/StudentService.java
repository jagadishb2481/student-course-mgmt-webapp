package com.studcourse.mgmt.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.studcourse.mgmt.model.Student;

public class StudentService {

	String apiUrl = "http://localhost:8081/students";
	RestTemplate restTemplate = new RestTemplate();
	public Student getStudentById(long studentId) {
		String url = apiUrl+"/"+studentId;
		// TODO Auto-generated method stub
		Student student = restTemplate.getForObject(url, Student.class);
		System.out.println("student:"+student);
		return student;
	}

	public void deleteStudentById(long studentId) {
		String url = apiUrl+"/"+studentId;
		// TODO Auto-generated method stub
		ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
		
		System.out.println("delete status:"+responseEntity.getStatusCode());
		
	}
}
