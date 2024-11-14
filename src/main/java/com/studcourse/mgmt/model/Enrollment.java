package com.studcourse.mgmt.model;


public class Enrollment {
    
    private Long id;

    private Student student;

    private Course course;

    private String grade;

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(Long id, Student student, Course course, String grade) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.grade = grade;
	}

	public Enrollment(Student student, Course course, String grade) {
		super();
		this.student = student;
		this.course = course;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", student=" + student + ", course=" + course + ", grade=" + grade + "]";
	}

}
