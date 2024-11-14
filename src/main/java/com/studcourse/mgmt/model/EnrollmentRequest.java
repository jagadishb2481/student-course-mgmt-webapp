package com.studcourse.mgmt.model;

import java.util.List;

public class EnrollmentRequest {
    private Long studentId;
    private List<Long> courseIds;
    
	public EnrollmentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnrollmentRequest(Long studentId, List<Long> courseIds) {
		super();
		this.studentId = studentId;
		this.courseIds = courseIds;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public List<Long> getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(List<Long> courseIds) {
		this.courseIds = courseIds;
	}

	@Override
	public String toString() {
		return "EnrollmentRequest [studentId=" + studentId + ", courseIds=" + courseIds + "]";
	}

    
}
