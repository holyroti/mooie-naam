package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentenOpties extends JPanel {

	private JComboBox<String> comboBox;

	private JLabel lblNaam;
	private JTextField txtFieldNaam;

	private JTable table;
	private DefaultTableModel tableModel;

	private BinnenlandInvoer invoer;

	public StudentenOpties() {
		setBackground(new Color(0x395e7c));

		setLayout(null);

		comboBox = new JComboBox<String>();

		txtFieldNaam = new JTextField();
		lblNaam = new JLabel("Naam");

		invoer = new BinnenlandInvoer();

		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] {"ID", "Naam", "Tussenvoegsel", "Achternaam", "Geslacht" });
		table.setModel(tableModel);
		table.setDefaultEditor(Object.class, null);
		comboBox.addItem("Choose option");
		comboBox.addItem("Wijzigen");
		comboBox.addItem("Onderwijseenheid inschrijven");
		comboBox.addItem("Stage inschrijven");
		comboBox.addItem("Locatie Student");
		comboBox.addItem("Onderwijs overzicht");

		JScrollPane tbl = new JScrollPane(table);

		lblNaam.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblNaam.setForeground(new Color(0xA5C3F7));

		comboBox.setBounds(20, 20, 250, 50);
		lblNaam.setBounds(410, 35, 100, 20);

		txtFieldNaam.setBounds(540, 35, 250, 20);

		tbl.setBounds(20, 110, 960, 215);
		// zou iets van een if statement moeten worden in actions van als
		// wijzigingen gekozen en als student geselecteerd dan:
//		invoer.changeLayout();
//		invoer.setBounds(40, 335, 890, 310);
//		add(invoer);

		add(comboBox);
		add(txtFieldNaam);
		add(lblNaam);
		add(tbl);
	}

	/**
	 * @return the comboBox
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * @return the txtFieldNaam
	 */
	public JTextField getTxtFieldNaam() {
		return txtFieldNaam;
	}

	/**
	 * @return the lblNaam
	 */
	public JLabel getLblNaam() {
		return lblNaam;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @return the tableModel
	 */
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public BinnenlandInvoer getInvoer() {
		return invoer;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public void setTxtFieldNaam(JTextField txtFieldNaam) {
		this.txtFieldNaam = txtFieldNaam;
	}

	public void setLblNaam(JLabel lblNaam) {
		this.lblNaam = lblNaam;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public void setInvoer(BinnenlandInvoer invoer) {
		this.invoer = invoer;
	}

}
