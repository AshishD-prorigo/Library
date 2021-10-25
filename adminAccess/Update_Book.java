package adminAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import library_managment_system.ConnectionDB;
public class Update_Book {
	
	Connection cn;
	PreparedStatement ps;
	Resultset rs;
	 
	public Update_Book() throws ClassNotFoundException {
		
		cn=ConnectionDB.getConnectionDB();
		
	}
	
	public void update() throws SQLException {
		
		String sql="update book set book_name=?, book_price=? ,book_author=? where book_id=?";
		
		ps=cn.prepareStatement(sql);
		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter Book Name");
//		String book_name=sc.nextLine();
		ps.setString(1, "Electrical Network");
		
//		System.out.println("Enter Book Price");
//		
//		float book_price=sc.nextFloat();
		ps.setFloat(2, 300.f);
		
//		System.out.println("Enter Book author");
//		String author_name=sc.nextLine();
		ps.setString(3, "Ashish");
		
//		System.out.println("Enter Update book id");
//		int book_id=sc.nextInt();
		ps.setInt(4, 1111);
		int r=ps.executeUpdate();
	
		System.out.println("data Updated:"+r);
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Update_Book ub=new Update_Book();
		ub.update();
	}

}
