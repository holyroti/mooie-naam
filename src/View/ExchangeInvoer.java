package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExchangeInvoer extends BinnenlandInvoer {

    public JTextField getTxtFieldStraat() {
        return txtFieldStraat;
    }

    public void setTxtFieldStraat(JTextField txtFieldStraat) {
        this.txtFieldStraat = txtFieldStraat;
    }

    public JTextField getTxtFieldHuisnr() {
        return txtFieldHuisnr;
    }

    public void setTxtFieldHuisnr(JTextField txtFieldHuisnr) {
        this.txtFieldHuisnr = txtFieldHuisnr;
    }

    public JTextField getTxtFieldToe() {
        return txtFieldToe;
    }

    public void setTxtFieldToe(JTextField txtFieldToe) {
        this.txtFieldToe = txtFieldToe;
    }

    public JTextField getTxtFieldPost() {
        return txtFieldPost;
    }

    public void setTxtFieldPost(JTextField txtFieldPost) {
        this.txtFieldPost = txtFieldPost;
    }

    public JTextField getTxtFieldWoonplaats() {
        return txtFieldWoonplaats;
    }

    public void setTxtFieldWoonplaats(JTextField txtFieldWoonplaats) {
        this.txtFieldWoonplaats = txtFieldWoonplaats;
    }

    public JTextField getTxtFieldLandvanherkomst() {
        return txtFieldLandvanherkomst;
    }

    public void setTxtFieldLandvanherkomst(JTextField txtFieldLandvanherkomst) {
        this.txtFieldLandvanherkomst = txtFieldLandvanherkomst;
    }

    private JTextField txtFieldStraat;
    private JTextField txtFieldHuisnr;
    private JTextField txtFieldToe;
    private JTextField txtFieldPost;
    private JTextField txtFieldWoonplaats;
    private JTextField txtFieldLandvanherkomst;

    private JLabel lblStraat;
    private JLabel lblHuisnr;
    private JLabel lblToe;
    private JLabel lblPost;
    private JLabel lblWoonplaats;
    private JLabel lblLandvanherkomst;

    public ExchangeInvoer() {
        super();
        super.setLayout(new GridLayout(0, 2, 10, 7));
        super.remove(super.getBtnOk());
        super.remove(super.getBtnCancel());

        lblStraat = new JLabel("    Straat");
        txtFieldStraat = new JTextField();
        lblHuisnr = new JLabel("    Huisnummer");
        txtFieldHuisnr = new JTextField();
        lblToe = new JLabel("    Toevoeging");
        txtFieldToe = new JTextField();
        lblPost = new JLabel("    Postcode");
        txtFieldPost = new JTextField();
        lblLandvanherkomst = new JLabel("    Land van herkomst");
        txtFieldLandvanherkomst = new JTextField();
        lblWoonplaats = new JLabel("    Woonplaats");
        txtFieldWoonplaats = new JTextField();

        lblWoonplaats.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblWoonplaats.setForeground(new Color(0xA5C3F7));
        txtFieldWoonplaats.setDocument(new JTextFieldLimit(45));
        add(lblWoonplaats);
        add(txtFieldWoonplaats);
        lblStraat.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblStraat.setForeground(new Color(0xA5C3F7));
        txtFieldStraat.setDocument(new JTextFieldLimit(45));

        add(lblStraat);
        add(txtFieldStraat);
        lblHuisnr.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblHuisnr.setForeground(new Color(0xA5C3F7));
        txtFieldHuisnr.setDocument(new JTextFieldLimit(45));

        add(lblHuisnr);
        add(txtFieldHuisnr);
        lblToe.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblToe.setForeground(new Color(0xA5C3F7));
        txtFieldToe.setDocument(new JTextFieldLimit(10));
        add(lblToe);
        add(txtFieldToe);
        lblPost.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblPost.setForeground(new Color(0xA5C3F7));
        txtFieldPost.setDocument(new JTextFieldLimit(5));

        add(lblPost);
        add(txtFieldPost);
        lblLandvanherkomst.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblLandvanherkomst.setForeground(new Color(0xA5C3F7));
        txtFieldLandvanherkomst.setDocument(new JTextFieldLimit(6));

        add(lblLandvanherkomst);
        add(txtFieldLandvanherkomst);

        add(super.getLabelUniversiteit());
        add(super.getTxtFieldUniversiteit());
        add(super.getBtnOk());
        add(super.getBtnCancel());

    }

}
