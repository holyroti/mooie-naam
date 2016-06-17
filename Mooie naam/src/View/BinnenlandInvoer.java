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

public class BinnenlandInvoer extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField txtFieldId;
    private JTextField txtFieldVoornaam;
    private JTextField txtFieldTussenvoegsel;
    private JTextField txtFieldAchternaam;
    private JTextField txtFieldGeslacht;
    private JTextField txtFieldEmailadres;
    private JComboBox<String> txtFieldOpleiding;
    private JTextField txtFieldUniversiteit;
    
    private JTextField txtFieldTel;

    private JLabel labelId;
    private JLabel labelVoornaam;
    private JLabel labelTussenvoegsel;
    private JLabel labelAchternaam;
    private JLabel labelGeslacht;
    private JLabel labelEmailadres;
    private JLabel labelOpleiding;
    private JLabel labelUniversiteit;
    private JLabel labelTel;
    private JButton btnOk;
    private JButton btnCancel;
    private JLabel lblEmpty1;
    private JLabel lblEmpty2;
    private JLabel lblEmpty3;
    private JLabel lblEmpty4;
    private JLabel lblEmpty5;
    private JLabel lblEmpty6;

    public BinnenlandInvoer() {
        setLayout(new GridLayout(0, 2, 10, 15));
        setBackground(new Color(0x395e7c));
        labelVoornaam = new JLabel("    Voornaam");
        labelTussenvoegsel = new JLabel("    Tussenvoegsel");
        labelAchternaam = new JLabel("    Achternaam");
        labelGeslacht = new JLabel("    Geslacht");
        labelEmailadres = new JLabel("    Emailadres");
        labelOpleiding = new JLabel("    Opleiding");
        labelUniversiteit = new JLabel("    Universiteit");
        labelTel = new JLabel("    Telefoonnummer");

        txtFieldVoornaam = new JTextField();
        txtFieldTussenvoegsel = new JTextField();
        txtFieldAchternaam = new JTextField();
        txtFieldGeslacht = new JTextField();
        txtFieldEmailadres = new JTextField();
        txtFieldId = new JTextField();
        txtFieldOpleiding = new JComboBox<String>();
        txtFieldUniversiteit = new JTextField();
        txtFieldTel = new JTextField();
        
        lblEmpty1 = new JLabel();
        lblEmpty2 = new JLabel();
        lblEmpty3 = new JLabel();
        lblEmpty4 = new JLabel();
        lblEmpty5 = new JLabel();
        lblEmpty6 = new JLabel();
        
        add(lblEmpty1);
        add(lblEmpty2);
        add(lblEmpty3);
        add(lblEmpty4);
        labelVoornaam.setFont(new Font("Century Gothic", Font.BOLD, 17));
        labelVoornaam.setForeground(new Color(0xA5C3F7));
        add(labelVoornaam);
        add(txtFieldVoornaam);
        labelTussenvoegsel.setFont(new Font("Century Gothic", Font.BOLD, 17));
        labelTussenvoegsel.setForeground(new Color(0xA5C3F7));
        add(labelTussenvoegsel);
        add(txtFieldTussenvoegsel);
        labelAchternaam.setFont(new Font("Century Gothic", Font.BOLD, 17));
        labelAchternaam.setForeground(new Color(0xA5C3F7));
        add(labelAchternaam);
        add(txtFieldAchternaam);
        labelGeslacht.setFont(new Font("Century Gothic", Font.BOLD, 17));
        labelGeslacht.setForeground(new Color(0xA5C3F7));
        add(labelGeslacht);
        add(txtFieldGeslacht);
        labelEmailadres.setFont(new Font("Century Gothic", Font.BOLD, 17));
        labelEmailadres.setForeground(new Color(0xA5C3F7));
        add(labelEmailadres);
        add(txtFieldEmailadres);
        labelOpleiding.setFont(new Font("Century Gothic", Font.BOLD, 17));
        labelOpleiding.setForeground(new Color(0xA5C3F7));
        add(labelOpleiding);
        add(txtFieldOpleiding);
        labelUniversiteit.setFont(new Font("Century Gothic", Font.BOLD, 17));
        labelUniversiteit.setForeground(new Color(0xA5C3F7));
        labelTel.setFont(new Font("Century Gothic", Font.BOLD, 17));
        labelTel.setForeground(new Color(0xA5C3F7));
        add(labelTel);
        add(txtFieldTel);

        add(lblEmpty5);
        add(lblEmpty6);

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
    
    public void changeLayout() {
        this.remove(lblEmpty1);
        this.remove(lblEmpty2);
        this.remove(lblEmpty3);
        this.remove(lblEmpty4);
        this.remove(lblEmpty5);
        this.remove(lblEmpty6);
    }
    
    
    
        public JTextField getTxtFieldUniversiteit() {
        return txtFieldUniversiteit;
    }

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

    public void setTxtFieldOpleiding(JComboBox<String> txtFieldOpleiding) {
        this.txtFieldOpleiding = txtFieldOpleiding;
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
    public JComboBox<String> getTxtFieldOpleiding() {
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
    
        public JTextField getTxtFieldTel() {
        return txtFieldTel;
    }

    public void setTxtFieldTel(JTextField txtFieldTel) {
        this.txtFieldTel = txtFieldTel;
    }

    public JLabel getLabelVoornaam() {
        return labelVoornaam;
    }

    public void setLabelVoornaam(JLabel labelVoornaam) {
        this.labelVoornaam = labelVoornaam;
    }

    public JLabel getLabelTussenvoegsel() {
        return labelTussenvoegsel;
    }

    public void setLabelTussenvoegsel(JLabel labelTussenvoegsel) {
        this.labelTussenvoegsel = labelTussenvoegsel;
    }

    public JLabel getLabelAchternaam() {
        return labelAchternaam;
    }

    public void setLabelAchternaam(JLabel labelAchternaam) {
        this.labelAchternaam = labelAchternaam;
    }

    public JLabel getLabelUniversiteit() {
        return labelUniversiteit;
    }

    public void setLabelUniversiteit(JLabel labelUniversiteit) {
        this.labelUniversiteit = labelUniversiteit;
    }

    public JLabel getLabelTel() {
        return labelTel;
    }

    public void setLabelTel(JLabel labelTel) {
        this.labelTel = labelTel;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setTxtFieldUniversiteit(JTextField txtFieldUniversiteit) {
        this.txtFieldUniversiteit = txtFieldUniversiteit;
    }

    public void setLabelId(JLabel labelId) {
        this.labelId = labelId;
    }

    public void setLabelGeslacht(JLabel labelGeslacht) {
        this.labelGeslacht = labelGeslacht;
    }

    public void setLabelEmailadres(JLabel labelEmailadres) {
        this.labelEmailadres = labelEmailadres;
    }

    public void setLabelOpleiding(JLabel labelOpleiding) {
        this.labelOpleiding = labelOpleiding;
    }

    public void setBtnOk(JButton btnOk) {
        this.btnOk = btnOk;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }
    
    public boolean isFilled() {
        return !getTxtFieldEmailadres().getText().isEmpty() && !getTxtFieldGeslacht().getText().isEmpty() && !getTxtFieldVoornaam().getText().isEmpty() && !getTxtFieldAchternaam().getText().isEmpty();
    }
    
    

}
