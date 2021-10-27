package print_details;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library_managment_system.ConnectionDB;

public class Student {
	Connection con;
	ResultSet rs;
	Statement sm;
	
	public Student() {
		con=ConnectionDB.getConnectionDB();
		
		System.out.println("Connection Establish");
	}
	
	public void getStudent() throws SQLException{
		
		sm=con.createStatement();
		rs=sm.executeQuery("select*from student");
		System.out.println("student_id"+"\t"+"student_name"+"\t"+"\t"+"student_branch"
				+"\t"+"age"+"\t"+"gender"+"\t"+"DOB");
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String b=rs.getString(3);
			int age=rs.getInt(4);
			String gender=rs.getString(5);
			Object dob=rs.getObject(6);
			
			System.out.println(id+"\t\t"+name+"\t\t"+b+"\t\t"+age+"\t"+gender+"\t"+dob);
		}
		
	}
	public static void main(String[] args) throws SQLException {
		Student student=new Student();
		student.getStudent();
		
		
	}
	
	

}
