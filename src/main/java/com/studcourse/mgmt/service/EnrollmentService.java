package com.studcourse.mgmt.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.studcourse.mgmt.model.Student;

public class EnrollmentService {

	String apiUrl = "http://localhost:8081/enrollments";
	RestTemplate restTemplate = new RestTemplate();

	public void deleteEnrollment(long studentId, long courseId) {
		String url = apiUrl+"/"+studentId+"/courses/"+courseId;
		ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
		System.out.println("delete status:"+responseEntity.getStatusCode());
	}
}
