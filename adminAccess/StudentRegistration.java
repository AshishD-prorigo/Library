package adminAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library_managment_system.ConnectionDB;

public class StudentRegistration {
	
	Connection cnb;
	ResultSet rs;
	PreparedStatement ps;
	Statement sm;
	
	public StudentRegistration() throws SQLException{
		
		cnb=ConnectionDB.getConnectionDB();
		System.out.println("Connection Establish");
	}

	public int insertStudent(int id,String student_name, String branch, int age, String gender, Object dob ) throws SQLException {
	
	ps=cnb.prepareStatement("insert into student values(?,?,?,?,?,?)");
	ps.setInt(1, id);
	ps.setString(2, student_name);
	ps.setString(3, branch);
	ps.setInt(4, age);
	ps.setString(5, gender);
	ps.setObject(6, dob);
	
	int n=ps.executeUpdate();
	System.out.println("No Of Row Inserted:"+n);
	
	return n;
	
	}
	
	public static void main(String[] args) throws SQLException{
		StudentRegistration sr=new StudentRegistration();
		sr.insertStudent(5,"Vishau Das", "AERO", 22, "M","1999-05-10");
	}
}
