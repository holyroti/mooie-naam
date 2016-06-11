package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpleidingZoeken extends JPanel{
	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNaamOpleiding() {
		return txtNaamOpleiding;
	}

	public void setTxtNaamOpleiding(JTextField txtNaamOpleiding) {
		this.txtNaamOpleiding = txtNaamOpleiding;
	}

	public JTextField getTxtType() {
		return txtType;
	}

	public void setTxtType(JTextField txtType) {
		this.txtType = txtType;
	}

	public JTextField getTxtContact() {
		return txtContact;
	}

	public void setTxtContact(JTextField txtContact) {
		this.txtContact = txtContact;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	private JTextField txtId;
	private JTextField txtNaamOpleiding;
	private JTextField txtType;
	private JTextField txtContact;
	
	private JLabel lblId;
	private JLabel lblNaamOpleiding;
	private JLabel lblType;
	private JLabel lblContact;
	
	private JButton btnOk;
	private JButton btnCancel;
	
	public OpleidingZoeken() {
		setLayout(new GridLayout(0, 2, 0, 10));
		txtId = new JTextField();
		txtId.setEditable(false);
		txtNaamOpleiding = new JTextField();
		txtType = new JTextField();
		txtContact = new JTextField();
		
		lblId = new JLabel("ID");
		lblNaamOpleiding = new JLabel("Naam Opleiding");
		lblType = new JLabel("Type");
		lblContact = new JLabel("Contactpersoon");
		
		add(lblId);
		add(txtId);
		add(lblNaamOpleiding);
		add(txtNaamOpleiding);
		add(lblType);
		add(txtType);
		add(lblContact);
		add(txtContact);
		
		btnOk = new JButton("Ok");
		add(btnOk);
		btnCancel = new JButton("Cancel");
		add(btnCancel);
	}
}
