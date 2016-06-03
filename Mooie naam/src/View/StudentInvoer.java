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
		labelId = new JLabel("ID:");
		labelNaam = new JLabel("Naam:");
		labelGeslacht = new JLabel("Geslacht:");
		labelEmailadres = new JLabel("Emailadres");
		labelOpleiding = new JLabel("Opleiding");
                txtFieldNaam = new JTextField();
                txtFieldGeslacht = new JTextField();
                txtFieldEmailadres = new JTextField();
                txtFieldId = new JTextField();
                txtFieldOpleiding = new JTextField();
                add(labelNaam);
                add(txtFieldNaam);
                add(labelGeslacht);
                add(txtFieldGeslacht);
                
		add(labelEmailadres);
                add(txtFieldEmailadres);
                add(labelOpleiding);
                add(txtFieldOpleiding);
		
                
                add(labelId);
		add(txtFieldId);
		
		
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
        return txtFieldNaam;
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
        return labelNaam;
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
