 package com.cg.project.dto;

public class EmployeeDTO {
private int employee_id;
private String employee_name;
private String password;
private String role;
public String getEmployee_name() {
	return employee_name;
}
public void setEmployee_name(String employee_name) {
	this.employee_name = employee_name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getEmployee_id() {
	return employee_id;
}

public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
