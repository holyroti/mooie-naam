package Controller;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Student {
	private String name;
	private Database db;
	
	public Student(Database db) {
		this.db = db;
		Frame frame = new Frame();
		name = (String)JOptionPane.showInputDialog(frame, "Student naam, leeg laten om nieuwe student aan te maken");
		if(name.equals(""))
			maakStudent();
	}
	
	public void zoekStudent(ArrayList<String> row) {
		ResultSet rs = db.executeStatement("SELECT Name, CountryCode, Population FROM city WHERE Name = '" + name + "'");
		int len = row.size();
		try {
			while(rs.next()) {
				for(int i=0; i<len; i++) {
					System.out.println(rs.getString(row.get(i)));
				}
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//needs an frame
	//werkt in theorie, maar genereert error omdat de test datbase die ik (arjun) gebruik teveel entries heeft
	private void maakStudent(){
		Frame frame = new Frame();
		String id = (String)JOptionPane.showInputDialog(frame, "enter id");
		String cname = (String)JOptionPane.showInputDialog(frame, "name");
		String ccode = (String)JOptionPane.showInputDialog(frame, "countrycode");
		String district = (String)JOptionPane.showInputDialog(frame, "district");
		String population = (String)JOptionPane.showInputDialog(frame, "population");
		
		int i = db.executeInsertStatement("INSERT INTO city VALUES" + "(" + Integer.parseInt(id) + "," +
				"'" + cname + "'" + "," +
				"'" + ccode + "'" + "," +
				"'" + district + "'" + "," +
				Integer.parseInt(population) +
				")");
		if (i==0) System.out.println("Failed");
		
		ResultSet rs = db.executeStatement("SELECT Name FROM city WHERE Name = '" + cname + "'");
		try {
			while(rs.next()) {
				System.out.println(rs.getString("Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}