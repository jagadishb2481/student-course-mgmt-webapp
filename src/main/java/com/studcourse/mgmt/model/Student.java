package com.studcourse.mgmt.model;



public class Student {
    
    private Long id;

    private String name;
    private String email;
    private String major;
    
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Student(String name, String email, String major) {
		super();
		this.name = name;
		this.email = email;
		this.major = major;
	}
	public Student(Long id, String name, String email, String major) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.major = major;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", major=" + major + "]";
	}

    
}
