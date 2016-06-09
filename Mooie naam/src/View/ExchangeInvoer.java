package View;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class ExchangeInvoer extends BinnenlandInvoer {
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
		super.setLayout(new GridLayout(0, 2, 0, 20));
		super.remove(super.getBtnOk());
		super.remove(super.getBtnCancel());
		GridLayout gridLayout = (GridLayout) getLayout();
		gridLayout.setVgap(10);
		lblStraat = new JLabel("Straat");
		txtFieldStraat = new JTextField();
		lblHuisnr = new JLabel("Huisnummer");
		txtFieldHuisnr = new JTextField();
		lblToe = new JLabel("Toevoeging");
		txtFieldToe = new JTextField();
		lblPost = new JLabel("Postcode");
		txtFieldPost = new JTextField();
		lblLandvanherkomst = new JLabel("Land van herkosmt");
		txtFieldLandvanherkomst = new JTextField();
		lblWoonplaats = new JLabel("Woonplaats");
		txtFieldWoonplaats = new JTextField();
		
		add(lblWoonplaats);
		add(txtFieldWoonplaats);
		add(lblStraat);
		add(txtFieldStraat);
		add(lblHuisnr);
		add(txtFieldHuisnr);
		add(lblToe);
		add(txtFieldToe);
		add(lblPost);
		add(txtFieldPost);
		add(lblLandvanherkomst);
		add(txtFieldLandvanherkomst);
		
		add(super.getBtnOk());
		add(super.getBtnCancel());
		
		super.remove(super.getTxtFieldOpleiding());
		super.remove(super.getLabelOpleiding());

	}

}
