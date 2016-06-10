package Controller;

import java.awt.event.WindowEvent;
import View.MainWindow;

public class Main{
	
	public static MainWindow mainWindow = new MainWindow();
	
	public static void main (String[] args){
		
		mainWindow.setVisible(true);
		mainWindow.setSize(1280, 720);
		mainWindow.setDefaultCloseOperation(1);
		mainWindow.setLocationRelativeTo(null);
		
		Database db = new Database("jdbc:mysql://meru.hhs.nl/15025713", "15025713", "raiHepha3j");
		switch (db.state) {
		case 0: System.out.println("Sucessvolle connectie");
				break;
		case 1: System.out.println("De ingevoerde url is niet gevonden, probeer het opnieuw");
				mainWindow.dispatchEvent(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
				break;
		case 2: System.out.println("De SQL library is niet gevonden");
				mainWindow.dispatchEvent(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
				break;
		}
		
		Actions a = new Actions();
		a.startListener(db);
		
//		ArrayList<String> list = new ArrayList<>();
//		list.add("Name");
//		list.add("CountryCode");
//		list.add("Population");
//		s.zoekStudent(list);
	}
}
