package Controller;

import java.awt.event.WindowEvent;
import java.util.ArrayList;

import View.MainWindow;

public class Main{
	
	public static void main (String[] args){
		MainWindow window = new MainWindow();
		
		window.setVisible(true);
		window.setSize(1280, 720);
		window.setDefaultCloseOperation(1);
		window.setLocationRelativeTo(null);
		
		Database db = new Database("jdbc:mysql://meru.hhs.nl/15025713", "15025713", "raiHepha3j");
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
		
                InvoerStudent invoer = new InvoerStudent(window, db);
//		Student s = new Student(db);
//		ArrayList<String> list = new ArrayList<>();
//		list.add("Name");
//		list.add("CountryCode");
//		list.add("Population");
//		s.zoekStudent(list);
	}
}
