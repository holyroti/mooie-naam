package Controller;

import java.sql.*;

public class Database {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String url;
	private String user;
	private String pass;
	public int state;
	
	public Database(String url, String user, String pass) {
		//Assign values
		this.url = url;
		this.user = user;
		this.pass = pass;
		
		//Make and verify db connection
		connectDB();
	}
	
	private int connectDB(){
		
		try{
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("con");
		} catch (SQLException e) {
			e.getStackTrace();
			System.out.println("State" + e.getSQLState());
			return state = 1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return state = 2;
		}
		
		return state = 0;
	}
}
