package Controller;

import java.awt.event.WindowEvent;

import View.MainWindow;

public class Main{
	
	public static void main (String[] args){
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(300, 300);
		window.setDefaultCloseOperation(1);
		window.setLocationRelativeTo(null);
		
		Database db = new Database("jdbc:mysql://localhost/world", "root", "qwerty123");
		switch (db.state) {
		case 0: System.out.println("Sucessvolle connectie");
				break;
		case 1: System.out.println("De ingevoerde url is niet gevonden, probeer het opnieuw");
				window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
				break;
		case 2: System.out.println("De SQL library is niet gevonden");
				window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
				break;
		}
		
		Student s = new Student(0);
		s.zoekStudent(db);
	}
}
