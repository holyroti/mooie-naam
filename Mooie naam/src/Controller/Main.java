package Controller;

import View.MainWindow;

public class Main{
	
	public static void main (String[] args){
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(300, 300);
		window.setDefaultCloseOperation(1);
		window.setLocationRelativeTo(null);
		
		Database db = new Database("jdbc:mysql://localhost/world", "root", "qwerty123");
	}
}
