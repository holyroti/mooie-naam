package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentInvoer extends JPanel {
	private JTextField txtFieldId;
	private JTextField txtFieldNaam;
	private JTextField txtFieldGeslacht;
	private JTextField txtFieldEmailadres;
	private JTextField txtFieldOpleiding;
	private JLabel labelId;
	private JLabel labelNaam;
	private JLabel labelGeslacht;
	private JLabel labelEmailadres;
	private JLabel labelOpleiding;

	private JButton btnOk;
	private JButton btnCancel;

	public StudentInvoer() {
		txtFieldId = new JTextField();
		txtFieldNaam = new JTextField();
		txtFieldGeslacht = new JTextField();
		txtFieldEmailadres = new JTextField();
		txtFieldOpleiding = new JTextField();
		add(txtFieldEmailadres);
		add(btnCancel);
		add(btnOk);
		add(txtFieldGeslacht);
		add(txtFieldId);
		add(txtFieldNaam);
		add(txtFieldOpleiding);
		add(labelEmailadres);
		add(labelGeslacht);
		add(labelId);
		add(labelNaam);
		add(labelOpleiding);

	}

}
