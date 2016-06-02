package Controller;

import java.awt.Frame;

import javax.swing.JOptionPane;

public class Student {
	private int type;
	private String name;
	
	public Student(int type) {
		this.type = type;
		Frame frame = new Frame();
		name = (String)JOptionPane.showInputDialog(frame, "Student naam, leeg laten om nieuwe student aan te maken");
	}
	
	public void zoekStudent(Database db) {
		db.executeStatement("SELECT Name FROM city WHERE Name = '" + name + "'", "Name");
	}
}