package Controller;

import View.MainWindow;

public class Main{
	
	public static void main (String[] args){
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(300, 300);
		window.setDefaultCloseOperation(0);
		window.setLocationRelativeTo(null);
	}
}
