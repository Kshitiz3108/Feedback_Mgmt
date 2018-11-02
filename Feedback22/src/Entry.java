import java.util.*;
import java.lang.*;
import java.sql.SQLException;

import com.cg.project.dao.EmployeeDAOImpl;
import com.cg.project.dao.Employee_dao;
import com.cg.project.dto.CourseDto;
import com.cg.project.dto.EmployeeDTO;
import com.cg.project.dto.FacultySkillDTO;
import com.cg.project.dto.FeedbackDTO;
import com.cg.project.service.EmployeeServiceImpl;
import com.cg.project.service.IEmployeeService;

import java.io.*;
public class Entry {

	static Scanner sc= new Scanner(System.in);
	public static IEmployeeService services;
public static void main(String args[])throws IOException, SQLException{
 services=new EmployeeServiceImpl();
System.out.println("||||Enter the choice||||");
System.out.println("*-----*-------*-------*---------*---------*");
System.out.println("Enter 1 to Register as new User");
System.out.println("Enter 2 to Login as existing User");
int choice = sc.nextInt();
switch (choice) {
case 1:
	
	RegisterUser();
	break;
case 2:
	LoginUser();
	break;
default:
	break;
}


}
//add user if not registered
	public static void RegisterUser() {
		
		System.out.println("Enter the Employee ID");
		int id=sc.nextInt();
		System.out.println("Enter the Employee Name");
		String name=sc.next();
		System.out.println("Enter the Employee Password");
		String password=sc.next();
		System.out.println("Enter the Employee Role");
		String role=sc.next();
		EmployeeDTO empdto=new EmployeeDTO();
		empdto.setEmployee_id(id);
		empdto.setEmployee_name(name);
		empdto.setPassword(password);
		empdto.setRole(role);
		try {
			services.addUser(empdto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	//login user and calling methods according to their role
	public static void LoginUser() throws SQLException {
		
		EmployeeDTO empdto= new EmployeeDTO();
		System.out.println("Enter the employee_id");
		int id= sc.nextInt();
		System.out.println("Enter the password");
		String password= sc.next();
		empdto.setEmployee_id(id);
		empdto.setPassword(password);
		String role= services.SearchForRole(empdto);
		if(role.equalsIgnoreCase("Admin"))
			adminRole();
		if(role.equalsIgnoreCase("Participant"))
			participantRole();
		if(role.equalsIgnoreCase("cocoordinator"))
			coordinatorRole();
	}
private static void coordinatorRole() {
		// TODO Auto-generated method stub
		
	}
private static void participantRole() {
		// TODO Auto-generated method stub
		
	}
	//if user is admin
	private static void adminRole() {
		// TODO Auto-generated method stub
		System.out.println("||||Enter the choice||||");
		System.out.println("*-----*-------*-------*---------*---------*");
		System.out.println("Enter 1 to Faculty Skill Maintenance");
		System.out.println("Enter 2 to Course Maintenance");
		System.out.println("Enter 3 to View Feedback Report");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			facultySkill();
			break;
		case 2:
			courseM();
			break;
		case 3:
			viewFeedback();
			break;
		default:
			break;
		}
	}
	private static void viewFeedback() {
		// TODO Auto-generated method stub
		FeedbackDTO feedback=new FeedbackDTO();
		System.out.println();
		try {
			List<FeedbackDTO> feedbacks=services.feedbacks();
			
				for(FeedbackDTO c:feedbacks)
				{
					System.out.println("Training Code"+c.getTraining_code()+" Faculty Skills;"+c.getParticipant_id()+" Pres&Comm"+
							c.getFb_prs_comm()+"Clarify Doubts "+c.getFb_prs_dbts()+" TM"+c.getFb_tm()+" Handout"+c.getFb_hnd_out()+" Hw/Sw/Ntwrk"+c.getFb_hw_sw_ntwrk()
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void courseM() {
		// TODO Auto-generated method stub
		System.out.println("Enter 1 to Show all Course");
		System.out.println("Enter 2 to Show Course by ID");
		System.out.println("Enter 3 to Add Course");
		System.out.println("Enter 4 to Delete Course");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			showCourse();
			break;
		case 2:
			showCoursebyID();
			break;	
		case 3:
			addCourse();
			break;
		case 4:
			deleteCourse();
			break;
		}
	}
	private static void deleteCourse() {
		// TODO Auto-generated method stub
		CourseDto course = new CourseDto();
		System.out.println("Enter course id");
		int course_id = sc.nextInt();
		course.setCourse_id(course_id);
		try {
			course =services.DeleteCourse(course);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void addCourse() {
		// TODO Auto-generated method stub
		CourseDto course = new CourseDto();
		System.out.println("Enter the Course ID");
		int course_id = sc.nextInt();
		System.out.println("Enter The Course Name");
		String course_name = sc.next();
		System.out.println("Enter The Duration Of course");
		int no_of_days = sc.nextInt();
		course.setCourse_id(course_id);
		course.setCourse_name(course_name);
		course.setNo_of_days(no_of_days);
		try {
			course =services.AddCourse(course);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void showCoursebyID() {
		// TODO Auto-generated method stub
		CourseDto course = new CourseDto();
		System.out.println("Enter Course Id");
		int course_id = sc.nextInt();
		course.setCourse_id(course_id);
		try {
			course =services.SearchCourse(course);
			System.out.println(course.getCourse_name());
			System.out.println(course.getNo_of_days());} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static void showCourse() {
		// TODO Auto-generated method stub
		
	}
	private static void facultySkill() {
		// TODO Auto-generated method stub
		System.out.println("Enter 1 to Show all Skills");
		System.out.println("Enter 2 to Show Skills by ID");
		System.out.println("Enter 3 to Add Skill");
		System.out.println("Enter 4 to Delete Skill");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			showSkill();
			break;
		case 2:
			showSkillbyID();
			break;	
		case 3:
			addSkill();
			break;
		case 4:
			deleteSkill();
			break;
		}
	}
	private static void showSkillbyID() {
		// TODO Auto-generated method stub
		System.out.println("Enter the ID for which you need to get Skills");
		int id=sc.nextInt();
		FacultySkillDTO faculty=new FacultySkillDTO();
		faculty.setFaculty_id(id);
		try {
			String skill=services.showSkill(faculty);
			System.out.println(skill);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void deleteSkill() {
		// TODO Auto-generated method stub
		
	}
	private static void addSkill() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Faculty ID to which it has to be added");
		int id=sc.nextInt();
		System.out.println("Enter the skill to be added to the set");
		String skill=sc.next();
		FacultySkillDTO faculty=new FacultySkillDTO();
		faculty.setFaculty_id(id);
		faculty.setSkillset(skill);
		try {
			services.addSkill(faculty);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void showSkill() {
		// TODO Auto-generated method stub
		FacultySkillDTO faculty=new FacultySkillDTO();
		System.out.println();
		try {
			List<FacultySkillDTO> facultylist=services.facultyskill();
			
				for(FacultySkillDTO c:facultylist)
				{
					System.out.println("Faculty Id:"+c.getFaculty_id()+"  Faculty Skills;"+c.getSkillset()
							);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

