package print_details;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library_managment_system.ConnectionDB;

public class Book {
	Connection con;
	ResultSet rs;
	Statement sm;
	
	public Book() {
		con=ConnectionDB.getConnectionDB();
		
		System.out.println("Connection Establish");
	}
	
	public void getBook() throws SQLException{
		
		sm=con.createStatement();
		rs=sm.executeQuery("select*from book");
		System.out.println("book_id"+"\t\t"+"book_name"+"\t\t"+"book_author"+"\t"+"book_price"+"\t"+"book_copies");
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String a=rs.getString(3);
			float price=rs.getFloat(4);
			int no=rs.getInt(5);
		
			
			System.out.println(id+"\t\t"+name+"\t"+a+"\t"+price+"\t\t"+no);
		}
	
	}
	
	public static void main(String[] args) throws SQLException {
		Book book=new Book();
		book.getBook();
	}

}
