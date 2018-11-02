package com.cg.project.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.project.dto.CourseDto;
import com.cg.project.dto.EmployeeDTO;
import com.cg.project.dto.FacultySkillDTO;
import com.cg.project.dto.FeedbackDTO;
import com.cg.project.utils.DBUtils;

public class EmployeeDAOImpl implements Employee_dao {
private Connection dbConnection;
EmployeeDTO emp;



{
	try {
		dbConnection = DBUtils.getConnection();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


@Override
public String SearchForRole(EmployeeDTO emp) throws SQLException {
String role="";
	try {
		String selectQuery = "select role from employee_master where employee_id=? and password=?";
		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		selectStatement.setInt(1, emp.getEmployee_id());
		selectStatement.setString(2, emp.getPassword());
		
		
		ResultSet rs = selectStatement.executeQuery();
		while (rs.next()) {
		    role=rs.getString(1);
		}
		
		//System.out.println(role);
			

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return role;	
}


@Override
public EmployeeDTO addUser(EmployeeDTO emp) throws SQLException {
	// TODO Auto-generated method stub
	String insertQuery="insert into employee_master"+"(employee_id,employee_name,password,role)"+"values(?,?,?,?)";
	
	try {
		PreparedStatement ps=dbConnection.prepareStatement(insertQuery);
		ps.setInt(1, emp.getEmployee_id());
		ps.setString(2, emp.getEmployee_name());
		ps.setString(3, emp.getPassword());
		ps.setString(4, emp.getRole());
		int row =ps.executeUpdate();
		System.out.println("Congratulations!!!.....You have successfully registered");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return emp;
}


@Override
public String showSkill(FacultySkillDTO faculty) throws SQLException {
	// TODO Auto-generated method stub
	String skill="";
	int count=0;
	try {
		String selectQuery="Select skill_set from faculty_skill where faculty_id=?";
		PreparedStatement p=dbConnection.prepareStatement(selectQuery);
		p.setInt(1, faculty.getFaculty_id());
		ResultSet rs=p.executeQuery();
		while(rs.next()){
			
			count++;
			skill=skill.concat(rs.getString(1)).concat(",");
		}
		if(count==0)
		{
			System.out.println("asd");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return skill;
}


@Override
public FacultySkillDTO addSkill(FacultySkillDTO faculty) throws SQLException {
	// TODO Auto-generated method stub
	String insertQuery="Insert into faculty_skill"+"(faculty_id,skill_set)"+"values(?,?)";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(insertQuery);
		ps.setInt(1, faculty.getFaculty_id());
		ps.setString(2, faculty.getSkillset());
		int row=ps.executeUpdate();
		System.out.println("Skill added to faculty id:"+faculty.getFaculty_id());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}


@Override
public FacultySkillDTO deleteSkill(FacultySkillDTO faculty) throws SQLException {
	// TODO Auto-generated method stub
	String selectQuery="Select * from faculty_skill where faculty_id=?";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(selectQuery);
		ps.setInt(1, faculty.getFaculty_id());
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+",");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}


@Override
public List<FacultySkillDTO> facultyskill() throws Exception {
	// TODO Auto-generated method stub
	List<FacultySkillDTO> facultyskill=new ArrayList<>();
	String sql="Select  * from faculty_skill ";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			int fid= rs.getInt("Faculty_Id");
			String  skillset= rs.getString("Skill_Set");
			FacultySkillDTO f=new FacultySkillDTO();
			f.setFaculty_id(fid);
			f.setSkillset(skillset);
			
			facultyskill.add(f);
			
			
		}
		return facultyskill;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}


@Override
public CourseDto AddCourse(CourseDto course) throws SQLException {
	// TODO Auto-generated method stub
	String selectQuery = "insert into course_master" + " (course_id,course_name,no_of_days)" + "values (?,?,?)";
	try {

		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		selectStatement.setInt(1, course.getCourse_id());
		selectStatement.setString(2, course.getCourse_name());
		selectStatement.setInt(3, course.getNo_of_days());
		selectStatement.executeUpdate();
		System.out.println("Your Course Have Successfully added........");

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return course;
}


@Override
public CourseDto DeleteCourse(CourseDto course) throws SQLException {
	// TODO Auto-generated method stub
	String selectQuery = "delete from course_master" +" where course_id=?";
	try{
		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		selectStatement.setInt(1, course.getCourse_id());
		selectStatement.executeQuery();
		System.out.println("Your Course Have successfully Deleted........");
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return course;
}


@Override
public CourseDto SearchCourse(CourseDto course) throws SQLException {
	// TODO Auto-generated method stub
	String selectQuery = "select * from course_master" +" where course_id=?";
	try{
		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		selectStatement.setInt(1, course.getCourse_id());
		ResultSet rs= selectStatement.executeQuery();
while(rs.next()){
course.setCourse_id(rs.getInt(1));
course.setCourse_name(rs.getString(2));
course.setNo_of_days(rs.getInt(3));
}

	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return course;
}


@Override
public FeedbackDTO addFeedback(FeedbackDTO feedback) throws SQLException {
	// TODO Auto-generated method stub
	String sql="insert into feedback_master"+"values(?,?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement ps=dbConnection.prepareStatement(sql);
		ps.setInt(1, feedback.getTraining_code());
		ps.setInt(2, feedback.getParticipant_id());
		ps.setInt(3, feedback.getFb_prs_comm());
		ps.setInt(4, feedback.getFb_prs_dbts());
		ps.setInt(5, feedback.getFb_tm());
		ps.setInt(6, feedback.getFb_hnd_out());
		ps.setInt(7, feedback.getFb_hw_sw_ntwrk());
		ps.setString(8, feedback.getComments());
		ps.setString(9, feedback.getSuggestion());
		int rows=ps.executeUpdate(sql);
		if(rows>0)
			System.out.println("feedback entered");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return feedback;
}


@Override
public List<FeedbackDTO> feedbacks() throws SQLException {
	// TODO Auto-generated method stub
	String sql="Select * from feedback_master";
	
	try {
		PreparedStatement ps=dbConnection.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int tcode=rs.getInt("training_code");
			int pid=rs.getInt("participant_id");
			int fbprsc=rs.getInt("fb_prs_comm");
			int fbprsd=rs.getInt("fb_prs_dbts");
			int fbtm=rs.getInt("fb_tm");
			int fbhn=rs.getInt("fb_hnd_out");
			int fbhw=rs.getInt("fb_hw_sw_ntwrk");
			String comm=rs.getString("comments");
			String sugg=rs.getString("suggestion");
			FeedbackDTO feedback=new FeedbackDTO();
			feedback.setTraining_code(tcode);
			feedback.setParticipant_id(pid);
			feedback.setFb_prs_comm(fbprsc);
			feedback.setFb_prs_dbts(fbprsd);
			feedback.setFb_tm(fbtm);
			feedback.setFb_hnd_out(fbhn);
			feedback.setFb_hw_sw_ntwrk(fbhw);
			feedback.setComments(comm);
			feedback.setSuggestion(sugg);
			feedbacks().add(feedback);
		}
		return feedbacks();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}

}
