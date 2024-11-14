package com.studcourse.mgmt.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.studcourse.mgmt.model.Course;

public class CourseService {

	String apiUrl = "http://localhost:8081/courses";
	RestTemplate restTemplate = new RestTemplate();
	public Course getCourseById(long courseId) {
		String url = apiUrl+"/"+courseId;
		// TODO Auto-generated method stub
		Course course = restTemplate.getForObject(url, Course.class);
		System.out.println("course:"+course);
		return course;
	}

	public void deleteCourseById(long courseId) {
		String url = apiUrl+"/"+courseId;
		// TODO Auto-generated method stub
		ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
		
		System.out.println("delete status:"+responseEntity.getStatusCode());
		
	}
}
