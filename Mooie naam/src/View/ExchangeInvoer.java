package View;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class ExchangeInvoer extends BinnenlandInvoer {
	private JTextField txtFieldAdres;
	private JTextField txtFieldWoonplaats;
	private JTextField txtFieldLandvanherkomst;

	private JLabel lblAdres;
	private JLabel lblWoonplaats;
	private JLabel lblLandvanherkomst;

	public ExchangeInvoer() {
		super();
		super.remove(super.getBtnOk());
		super.remove(super.getBtnCancel());
		GridLayout gridLayout = (GridLayout) getLayout();
		gridLayout.setVgap(10);
		lblLandvanherkomst = new JLabel("Land van herkosmt");
		lblWoonplaats = new JLabel("Woonplaats");
		txtFieldAdres = new JTextField();
		txtFieldLandvanherkomst = new JTextField();
		lblAdres = new JLabel("Adres");
		txtFieldWoonplaats = new JTextField();
		add(lblWoonplaats);
		add(txtFieldWoonplaats);
		add(lblAdres);
		add(txtFieldAdres);
		add(lblLandvanherkomst);
		add(txtFieldLandvanherkomst);
		
		add(super.getBtnOk());
		add(super.getBtnCancel());
		
		super.remove(super.getTxtFieldOpleiding());
		super.remove(super.getLabelOpleiding());

	}

}
