package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

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
		setLayout(new GridLayout(0, 2, 0, 30));
		labelId = new JLabel();
		labelNaam = new JLabel();
		labelGeslacht = new JLabel();
		labelEmailadres = new JLabel();
		labelOpleiding = new JLabel();
		add(labelEmailadres);
		txtFieldId = new JTextField();
		add(txtFieldId);
		add(labelGeslacht);
		txtFieldEmailadres = new JTextField();
		add(txtFieldEmailadres);
		add(labelId);
		txtFieldGeslacht = new JTextField();
		add(txtFieldGeslacht);
		add(labelNaam);
		txtFieldOpleiding = new JTextField();
		add(txtFieldOpleiding);
		add(labelOpleiding);
		txtFieldNaam = new JTextField();
		add(txtFieldNaam);
		btnOk = new JButton("Ok");
		add(btnOk);
		btnCancel = new JButton("Cancel");
		add(btnCancel);

	}

}
