package student_log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import adminAccess.AddBook;
import library_managment_system.ConnectionDB;

public class Order2 {
	
	Connection cnb;
	ResultSet rs;
	PreparedStatement ps;
	Statement sm;
	
	Order2() throws SQLException{
		cnb=ConnectionDB.getConnectionDB();
		System.out.println("Connection Establish");
	}
	
	public void fetchData() throws SQLException
	{
		sm=cnb.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
	}
	
	public int order_book(int record_id,String book_name, int book_id, String issue_date, String return_date, int student_id ) throws SQLException {
		
		ps=cnb.prepareStatement("insert into order2 values(?,?,?,?,?,?)");
		ps.setInt(1, record_id);
		ps.setString(2, book_name);
		ps.setInt(3, book_id);
		ps.setString(4, issue_date);
		ps.setString(5, return_date);
		ps.setInt(6, student_id);
		
		
		int n=ps.executeUpdate();
		System.out.println("No of Insertion is:"+n);
		return n;
	}
	

	public static void main(String[] args) throws SQLException {
		Order2 order2=new Order2();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Record id");
		int r_id=sc.nextInt();
		System.out.println("Enter Book Name");
		String book_name=sc.next();
		System.out.println("Enter book id");
		int book_id=sc.nextInt();
		System.out.println("Enter From Date");
		String from_date=sc.next();
		
		System.out.println("Enter to Date");
		String to_date=sc.next();
		System.out.println("Enter Student_id");
		int student_id=sc.nextInt();
		
		
		order2.order_book(r_id,book_name, book_id, from_date, to_date, student_id);
	}

}
