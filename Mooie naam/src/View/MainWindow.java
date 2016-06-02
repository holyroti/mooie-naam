package View;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow(){
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnExcStuIn = new JButton("Buitenlandse student invoeren");
		btnExcStuIn.setToolTipText("Klik om een nieuwe buitenlandse student met zijn gegevens in te voeren");
		panel.add(btnExcStuIn);
		
		JButton btnHhsStuIn = new JButton("Binnenlandse student invoeren");
		btnHhsStuIn.setToolTipText("Klik om een nieuwe binnenlandse student met zijn gegevens in te voeren");
		panel.add(btnHhsStuIn);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
