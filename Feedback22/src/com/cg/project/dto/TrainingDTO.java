package com.cg.project.dto;

import java.util.Date;

public class TrainingDTO {
	private int training_code;
	private int course_code;
	private int faculty_code;
	private Date start_date;
	private Date end_date;
	public int getTraining_code() {
		return training_code;
	}
	public void setTraining_code(int training_code) {
		this.training_code = training_code;
	}
	public int getCourse_code() {
		return course_code;
	}
	public void setCourse_code(int course_code) {
		this.course_code = course_code;
	}
	public int getFaculty_code() {
		return faculty_code;
	}
	public void setFaculty_code(int faculty_code) {
		this.faculty_code = faculty_code;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
}
