/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Arjun
 */
public class ContactInvoer extends JPanel{
    private JTextField txtEmail;
    private JTextField txtTel;
    private JTextField txtNaam;
    private JComboBox<String> comGeslacht;
    
    private JLabel lblEmail;
    private JLabel lblTel;
    private JLabel lblNaam;
    private JLabel lblGeslacht;
    
    private JButton btnOk;
    private JButton btnCancel;
    
    public ContactInvoer() {
        setLayout(new GridLayout(0, 2, 10, 90));
        setBackground(new Color(0x395e7c));
        
        lblEmail = new JLabel("    Emailadres");
        lblTel = new JLabel("    Telefoonnummer");
        lblNaam = new JLabel("    Naam");
        lblGeslacht = new JLabel("    Geslacht");
        
        txtEmail = new JTextField();
        txtEmail.setDocument(new JTextFieldLimit(45));
        txtTel = new JTextField();
        txtTel.setDocument(new JTextFieldLimit(45));
        txtNaam = new JTextField();
        txtNaam.setDocument(new JTextFieldLimit(45));
        comGeslacht = new JComboBox<>();
        comGeslacht.addItem("M");
        comGeslacht.addItem("V");
        
        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");
        
        lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblEmail.setForeground(new Color(0xA5C3F7));
        add(lblEmail);
        add(txtEmail);
        lblTel.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblTel.setForeground(new Color(0xA5C3F7));
        add(lblTel);
        add(txtTel);
        lblNaam.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblNaam.setForeground(new Color(0xA5C3F7));
        add(lblNaam);
        add(txtNaam);
        lblGeslacht.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblGeslacht.setForeground(new Color(0xA5C3F7));
        add(lblGeslacht);
        add(comGeslacht);
        add(btnOk);
        add(btnCancel);
    }

    /**
     * @return the txtEmail
     */
    public JTextField getTxtEmail() {
        return txtEmail;
    }

    /**
     * @param txtEmail the txtEmail to set
     */
    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    /**
     * @return the txtTel
     */
    public JTextField getTxtTel() {
        return txtTel;
    }

    /**
     * @param txtTel the txtTel to set
     */
    public void setTxtTel(JTextField txtTel) {
        this.txtTel = txtTel;
    }

    /**
     * @return the txtNaam
     */
    public JTextField getTxtNaam() {
        return txtNaam;
    }

    /**
     * @param txtNaam the txtNaam to set
     */
    public void setTxtNaam(JTextField txtNaam) {
        this.txtNaam = txtNaam;
    }

    /**
     * @return the comGeslacht
     */
    public JComboBox<String> getComGeslacht() {
        return comGeslacht;
    }

    /**
     * @param comGeslacht the comGeslacht to set
     */
    public void setComGeslacht(JComboBox<String> comGeslacht) {
        this.comGeslacht = comGeslacht;
    }

    /**
     * @return the lblEmail
     */
    public JLabel getLblEmail() {
        return lblEmail;
    }

    /**
     * @param lblEmail the lblEmail to set
     */
    public void setLblEmail(JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    /**
     * @return the lblTel
     */
    public JLabel getLblTel() {
        return lblTel;
    }

    /**
     * @param lblTel the lblTel to set
     */
    public void setLblTel(JLabel lblTel) {
        this.lblTel = lblTel;
    }

    /**
     * @return the lblNaam
     */
    public JLabel getLblNaam() {
        return lblNaam;
    }

    /**
     * @param lblNaam the lblNaam to set
     */
    public void setLblNaam(JLabel lblNaam) {
        this.lblNaam = lblNaam;
    }

    /**
     * @return the lblGeslacht
     */
    public JLabel getLblGeslacht() {
        return lblGeslacht;
    }

    /**
     * @param lblGeslacht the lblGeslacht to set
     */
    public void setLblGeslacht(JLabel lblGeslacht) {
        this.lblGeslacht = lblGeslacht;
    }

    /**
     * @return the btnOk
     */
    public JButton getBtnOk() {
        return btnOk;
    }

    /**
     * @param btnOk the btnOk to set
     */
    public void setBtnOk(JButton btnOk) {
        this.btnOk = btnOk;
    }

    /**
     * @return the btnCancel
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }

    /**
     * @param btnCancel the btnCancel to set
     */
    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }
}
