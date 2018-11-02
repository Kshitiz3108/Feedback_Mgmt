package com.cg.project.dto;

public class CourseDto {
private int course_id;
private String course_name;
private int no_of_days;
public int getCourse_id() {
	return course_id;
}
public CourseDto(){
	
}
public void setCourse_id(int course_id) {
	this.course_id = course_id;
}
public String getCourse_name() {
	return course_name;
}
public void setCourse_name(String course_name) {
	this.course_name = course_name;
}
public int getNo_of_days() {
	return no_of_days;
}
public void setNo_of_days(int no_of_days) {
	this.no_of_days = no_of_days;
}

}
