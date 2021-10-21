package adminAccess;


import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library_managment_system.ConnectionDB;

public class AddBook {
	Connection cnb;
	ResultSet rs;
	PreparedStatement ps;
	Statement sm;
	
	AddBook() throws SQLException{
		cnb=ConnectionDB.getConnectionDB();
		System.out.println("Connection Establish");
	}
	
	public void fetchData() throws SQLException
	{
		sm=cnb.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
	}
	
	public int insertBook(int id,String book_name, String bk_author, float price, int copies ) throws SQLException {
		
		ps=cnb.prepareStatement("insert into book values(?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, book_name);
		ps.setString(3, bk_author);
		ps.setFloat(4, price);
		ps.setInt(5, copies);
		
		int n=ps.executeUpdate();
		System.out.println("No of Insertion is:"+n);
		return n;
	}
	

	public static void main(String[] args) throws SQLException {
		AddBook ab=new AddBook();
		ab.insertBook(6666, "Thermal Engineering", "Mr.RD.Deshmukh", 360, 30);
	}
	
	

}
