package View;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnStudent;
	private JSplitPane splitPane;

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public JButton getBtnStudent() {
		return btnStudent;
	}

	public MainWindow(){
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		splitPane = new JSplitPane();
		getContentPane().add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		btnStudent = new JButton("Nieuwe student invoeren");
		btnStudent.setToolTipText("Klik om een nieuwe student met zijn gegevens in te voeren");
		panel.add(btnStudent);
		
		JButton btnStuSearch = new JButton("Student opzoeken");
		btnStuSearch.setToolTipText("Klik om een student te zoeken zodat je deze kunt: wijzigen, inschrijven, bekijken of vinden");
		panel.add(btnStuSearch);
		
		JButton btnOplSearch = new JButton("Opleiding opzoeken");
		btnOplSearch.setToolTipText("Klik om een opleiding op te zoeken zodat je er een kunt toevoegen of bekijken");
		panel.add(btnOplSearch);
		
		JButton btnGegOpvragen = new JButton("Gegevens opvragen");
		btnGegOpvragen.setToolTipText("Klik om verschillende overzichten te kunnen bekijken");
		panel.add(btnGegOpvragen);
		
	}
}
