package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class BinnenlandInvoer extends JPanel {
	private JTextField txtFieldId;
	private JTextField txtFieldVoornaam;
	private JTextField txtFieldTussenvoegsel;
	private JTextField txtFieldAchternaam;
	private JTextField txtFieldGeslacht;
	private JTextField txtFieldEmailadres;
	private JTextField txtFieldOpleiding;
	private JTextField txtFieldUniversiteit;

	private JLabel labelId;
	private JLabel labelVoornaam;
	private JLabel labelTussenvoegsel;
	private JLabel labelAchternaam;
	private JLabel labelGeslacht;
	private JLabel labelEmailadres;
	private JLabel labelOpleiding;
	private JLabel labelUniversiteit;

	public JTextField getTxtFieldVoornaam() {
		return txtFieldVoornaam;
	}

	public void setTxtFieldVoornaam(JTextField txtFieldVoornaam) {
		this.txtFieldVoornaam = txtFieldVoornaam;
	}

	public JTextField getTxtFieldTussenvoegsel() {
		return txtFieldTussenvoegsel;
	}

	public void setTxtFieldTussenvoegsel(JTextField txtFieldTussenvoegsel) {
		this.txtFieldTussenvoegsel = txtFieldTussenvoegsel;
	}

	public JTextField getTxtFieldAchternaam() {
		return txtFieldAchternaam;
	}

	public void setTxtFieldAchternaam(JTextField txtFieldAchternaam) {
		this.txtFieldAchternaam = txtFieldAchternaam;
	}

	public void setTxtFieldId(JTextField txtFieldId) {
		this.txtFieldId = txtFieldId;
	}

	public void setTxtFieldGeslacht(JTextField txtFieldGeslacht) {
		this.txtFieldGeslacht = txtFieldGeslacht;
	}

	public void setTxtFieldEmailadres(JTextField txtFieldEmailadres) {
		this.txtFieldEmailadres = txtFieldEmailadres;
	}

	public void setTxtFieldOpleiding(JTextField txtFieldOpleiding) {
		this.txtFieldOpleiding = txtFieldOpleiding;
	}

	private JButton btnOk;
	private JButton btnCancel;

	public BinnenlandInvoer() {
		setLayout(new GridLayout(0, 2, 0, 10));
		labelVoornaam = new JLabel("Voornaam");
		labelTussenvoegsel = new JLabel("Tussenvoegsel");
		labelAchternaam = new JLabel("Achternaam");
		labelGeslacht = new JLabel("Geslacht");
		labelEmailadres = new JLabel("Emailadres");
		labelOpleiding = new JLabel("Opleiding");
		labelUniversiteit = new JLabel("Universiteit");
		txtFieldVoornaam = new JTextField();
		txtFieldTussenvoegsel = new JTextField();
		txtFieldAchternaam = new JTextField();
		txtFieldGeslacht = new JTextField();
		txtFieldEmailadres = new JTextField();
		txtFieldId = new JTextField();
		txtFieldOpleiding = new JTextField();
		txtFieldUniversiteit = new JTextField();
		
		add(labelVoornaam);
		add(txtFieldVoornaam);
		add(labelTussenvoegsel);
		add(txtFieldTussenvoegsel);
		add(labelAchternaam);
		add(txtFieldAchternaam);
		add(labelGeslacht);
		add(txtFieldGeslacht);
		add(labelEmailadres);
		add(txtFieldEmailadres);
		add(labelOpleiding);
		add(txtFieldOpleiding);
		add(labelUniversiteit);
		add(txtFieldUniversiteit);

		btnOk = new JButton("Ok");
		add(btnOk);
		btnCancel = new JButton("Cancel");
		add(btnCancel);

	}

	/**
	 * @return the txtFieldId
	 */
	public JTextField getTxtFieldId() {
		return txtFieldId;
	}

	/**
	 * @return the txtFieldNaam
	 */
	public JTextField getTxtFieldNaam() {
		return txtFieldVoornaam;
	}

	/**
	 * @return the txtFieldGeslacht
	 */
	public JTextField getTxtFieldGeslacht() {
		return txtFieldGeslacht;
	}

	/**
	 * @return the txtFieldEmailadres
	 */
	public JTextField getTxtFieldEmailadres() {
		return txtFieldEmailadres;
	}

	/**
	 * @return the txtFieldOpleiding
	 */
	public JTextField getTxtFieldOpleiding() {
		return txtFieldOpleiding;
	}

	/**
	 * @return the labelId
	 */
	public JLabel getLabelId() {
		return labelId;
	}

	/**
	 * @return the labelNaam
	 */
	public JLabel getLabelNaam() {
		return labelVoornaam;
	}

	/**
	 * @return the labelGeslacht
	 */
	public JLabel getLabelGeslacht() {
		return labelGeslacht;
	}

	/**
	 * @return the labelEmailadres
	 */
	public JLabel getLabelEmailadres() {
		return labelEmailadres;
	}

	/**
	 * @return the labelOpleiding
	 */
	public JLabel getLabelOpleiding() {
		return labelOpleiding;
	}

	/**
	 * @return the btnOk
	 */
	public JButton getBtnOk() {
		return btnOk;
	}

	/**
	 * @return the btnCancel
	 */
	public JButton getBtnCancel() {
		return btnCancel;
	}

}
