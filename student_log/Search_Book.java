package print_details;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import library_managment_system.ConnectionDB;

public class Search_Book {

	Connection cn;
	Statement st;
	PreparedStatement ps;
	
	public Search_Book() throws ClassNotFoundException {
		cn=ConnectionDB.getConnectionDB();
		System.out.println("COnnection Establish");
	} 
	
	Scanner sc=new Scanner(System.in);
	
	public void search_id() throws SQLException {
		
		
		System.out.println("Enter the book_id");
		int id=sc.nextInt();
		
		String sql="select *from book where book_id=?";
		ps=cn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.print("id"+" : "+rs.getInt(1)+" ");
			System.out.print("Book Name"+" : "+rs.getString(2)+" ");
			System.out.print("Book_price"+" : "+rs.getFloat(3)+" ");
			System.out.print("Book_Author"+" : "+rs.getString(4)+" ");
			System.out.print("Book_copies"+" : "+rs.getInt(5)+" ");
		}
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Search_Book sb=new Search_Book();
		sb.search_id();
	}
	
	
	
	
	

}
