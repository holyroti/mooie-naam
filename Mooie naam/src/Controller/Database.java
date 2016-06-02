package Controller;

import java.sql.*;

public class Database {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String url;
	private String user;
	private String pass;
	private Connection con;
	private Statement stat;
	
	public int state;
	
	public Database(String url, String user, String pass) {
		//Assign values
		this.url = url;
		this.user = user;
		this.pass = pass;
		
		//Make and verify db connection
		connectDB();
	}
	
	private void connectDB(){
		try{
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(url, user, pass);
			state = 0;
		} catch (SQLException e) {
			e.getStackTrace();
			System.out.println("State" + e.getSQLState());
			state = 1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			state = 2;
		}		
	}
	
	public void executeStatement(String statement, String row) {
		try {
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(statement);
			
			while(rs.next()) {
				System.out.println(rs.getString(row));
			}
			
			rs.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
