package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpleidingZoeken extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JComboBox<String> getTxtNaamOpleiding() {
        return txtNaamOpleiding;
    }

    public void setTxtNaamOpleiding(JComboBox<String> txtNaamOpleiding) {
        this.txtNaamOpleiding = txtNaamOpleiding;
    }

    public JComboBox<String> getTxtType() {
        return txtType;
    }

    public void setTxtType(JComboBox<String> txtType) {
        this.txtType = txtType;
    }

    public JComboBox<String> getTxtContact() {
        return txtContact;
    }

    public void setTxtContact(JComboBox<String> txtContact) {
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
    private JComboBox<String> txtNaamOpleiding;
    private JComboBox<String> txtType;
    private JComboBox<String> txtContact;

    private JLabel lblId;
    private JLabel lblNaamOpleiding;
    private JLabel lblType;
    private JLabel lblContact;

    private JButton btnOk;
    private JButton btnCancel;

    public OpleidingZoeken() {
        setLayout(new GridLayout(0, 2, 10, 15));
        setBackground(new Color(0x395e7c));

        txtId = new JTextField();
        txtId.setEditable(false);
        txtNaamOpleiding = new JComboBox<>();
        txtNaamOpleiding.addItem("Choose one");
        txtType = new JComboBox<>();
        txtContact = new JComboBox<>();

        lblId = new JLabel("    ID");
        lblNaamOpleiding = new JLabel("    Naam Opleiding");
        lblType = new JLabel("    Type");
        lblContact = new JLabel("    Contactpersoon");
        
        
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        lblId.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblId.setForeground(new Color(0xA5C3F7));
        add(lblId);
        add(txtId);
        lblNaamOpleiding.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblNaamOpleiding.setForeground(new Color(0xA5C3F7));
        add(lblNaamOpleiding);
        add(txtNaamOpleiding);
        lblType.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblType.setForeground(new Color(0xA5C3F7));
        add(lblType);
        add(txtType);
        lblContact.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblContact.setForeground(new Color(0xA5C3F7));
        add(lblContact);
        add(txtContact);
        
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());

        btnOk = new JButton("Ok");
        btnOk.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnOk.setForeground(new Color(0x00284d));
        btnOk.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(btnOk);
        btnCancel = new JButton("Cancel");
        btnCancel.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnCancel.setForeground(new Color(0x00284d));
        btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(btnCancel);
    }
}
