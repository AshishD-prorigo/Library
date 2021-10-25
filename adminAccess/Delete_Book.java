package adminAccess;

import java.sql.*;

import library_managment_system.ConnectionDB;

public class Delete_Book {
	PreparedStatement ps;
	Connection cn;
	ResultSet rs;
	Statement st;
	
	public Delete_Book() throws ClassNotFoundException {
		cn=ConnectionDB.getConnectionDB();
		System.out.println("Connection Estrablish");
	}
	
	public int remove_book() throws SQLException {
		String sql="delete from book where book_id=?";
		ps=cn.prepareStatement(sql);
		ps.setInt(1, 4444);
		int n=ps.executeUpdate();
		System.out.println("No of Row Affected:"+n);
		return n;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Delete_Book db=new Delete_Book();
		db.remove_book();
	}

}
