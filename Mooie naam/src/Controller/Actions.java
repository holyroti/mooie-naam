package Controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Actions{
	public static int n;
	
	public void startListener(Database db){
		Main.mainWindow.getBtnStudent().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame frame = new Frame();
				Object[] options = {"HHS Student", "Exchange Student"};
				n = JOptionPane.showOptionDialog(frame, "Wat voor student wilt u invoeren", "Student", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//				System.out.println(n);
				Student s = new Student(db, n);
			}
		});
	}
}
