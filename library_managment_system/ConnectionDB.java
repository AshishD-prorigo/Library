package library_managment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionDB {
		Scanner add=new Scanner(System.in);
		
		public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		public static final String CONN_URL="jdbc:mysql://localhost:3306/library";
		public static final String USER="root";
		public static final String PASS="Ashishar123@";
		
//		String user=add.next();
//		String pass=add.next();
		static Connection con=null;
		
		public static Connection getConnectionDB() {
			try {
				Class.forName(JDBC_DRIVER);
				try {
					con=DriverManager.getConnection(CONN_URL,USER,PASS);
//					System.out.println(con); // Just To check Connection is Establish or Not
					return con;
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		public static void main(String[] arg) {
			getConnectionDB();
		}
		
	

}
