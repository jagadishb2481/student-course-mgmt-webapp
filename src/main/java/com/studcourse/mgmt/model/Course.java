package com.studcourse.mgmt.model;

public class Course {
   
    private Long id;

    private String courseName;
    private String description;
    private String schedule;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String courseName, String description, String schedule) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.schedule = schedule;
	}
	public Course(Long id, String courseName, String description, String schedule) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.schedule = schedule;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", description=" + description + ", schedule="
				+ schedule + "]";
	}


}
