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
	private JCheckBox chckbxNaam;
	private JCheckBox chckbxId;
	private JCheckBox chckbxGeslacht;

	private JTextField txtFieldNaam;
	private JTextField txtFieldId;

	private ButtonGroup btnGroup;
	private JRadioButton rBtnV;
	private JRadioButton rBtnM;

	private JLabel lblNaam;
	private JLabel lblGeslacht;
	private JLabel lblId;

	private JTable table;
	private DefaultTableModel tableModel;

	private BinnenlandInvoer invoer;

	public StudentenOpties() {
		setBackground(new Color(0x395e7c));

		setLayout(null);

		comboBox = new JComboBox<String>();

		rBtnV = new JRadioButton();
		rBtnM = new JRadioButton();
		chckbxNaam = new JCheckBox();
                chckbxNaam.setBackground(null);
		chckbxId = new JCheckBox();
                chckbxId.setBackground(null);
		chckbxGeslacht = new JCheckBox();
                chckbxGeslacht.setBackground(null);

		txtFieldNaam = new JTextField();
		txtFieldId = new JTextField();
		btnGroup = new ButtonGroup();
		lblNaam = new JLabel("Naam");
		lblGeslacht = new JLabel("Geslacht");
		lblId = new JLabel("Id");

		invoer = new BinnenlandInvoer();

		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Naam", "Tussenvoegsel", "Achternaam", "Geslacht" });
		table.setModel(tableModel);
		table.setDefaultEditor(Object.class, null);
		comboBox.addItem("Choose option");
		comboBox.addItem("Wijzigen");
		comboBox.addItem("Studie inschrijven");
		comboBox.addItem("Stage inschrijven");
		comboBox.addItem("Inschrijving wijzigen");
		comboBox.addItem("locatie");
		comboBox.addItem("Onderwijs overzicht");

		JScrollPane tbl = new JScrollPane(table);

		lblGeslacht.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblGeslacht.setForeground(new Color(0xA5C3F7));
		lblNaam.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblNaam.setForeground(new Color(0xA5C3F7));
		lblId.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblId.setForeground(new Color(0xA5C3F7));

		comboBox.setBounds(20, 20, 250, 50);

		chckbxGeslacht.setBounds(380, 18, 20, 20);
		chckbxNaam.setBounds(380, 35, 20, 20);
		chckbxId.setBounds(380, 53, 20, 20);

		lblGeslacht.setBounds(410, 18, 100, 20);
		lblNaam.setBounds(410, 35, 100, 20);
		lblId.setBounds(410, 53, 100, 20);

		rBtnM.setBounds(540, 18, 20, 20);
		rBtnV.setBounds(665, 18, 20, 20);

		txtFieldNaam.setBounds(540, 35, 250, 20);
		txtFieldId.setBounds(540, 53, 250, 20);

		tbl.setBounds(20, 110, 960, 215);
		// zou iets van een if statement moeten worden in actions van als
		// wijzigingen gekozen en als student geselecteerd dan:
//		invoer.changeLayout();
//		invoer.setBounds(40, 335, 890, 310);
//		add(invoer);

		add(rBtnM);
		add(rBtnV);
		add(comboBox);
		add(chckbxGeslacht);
		add(chckbxId);
		add(chckbxNaam);
		add(txtFieldId);
		add(txtFieldNaam);
		add(lblGeslacht);
		add(lblId);
		add(lblNaam);
		add(tbl);
		btnGroup.add(rBtnV);
		btnGroup.add(rBtnM);
	}

	/**
	 * @return the comboBox
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * @return the chckbxNaam
	 */
	public JCheckBox getChckbxNaam() {
		return chckbxNaam;
	}

	/**
	 * @return the chckbxId
	 */
	public JCheckBox getChckbxId() {
		return chckbxId;
	}

	/**
	 * @return the chckbxGeslacht
	 */
	public JCheckBox getChckbxGeslacht() {
		return chckbxGeslacht;
	}

	/**
	 * @return the txtFieldNaam
	 */
	public JTextField getTxtFieldNaam() {
		return txtFieldNaam;
	}

	/**
	 * @return the txtFieldId
	 */
	public JTextField getTxtFieldId() {
		return txtFieldId;
	}

	/**
	 * @return the btnGroup
	 */
	public ButtonGroup getBtnGroup() {
		return btnGroup;
	}

	/**
	 * @return the rBtnV
	 */
	public JRadioButton getrBtnV() {
		return rBtnV;
	}

	/**
	 * @return the rBtnM
	 */
	public JRadioButton getrBtnM() {
		return rBtnM;
	}

	/**
	 * @return the lblNaam
	 */
	public JLabel getLblNaam() {
		return lblNaam;
	}

	/**
	 * @return the lblGeslacht
	 */
	public JLabel getLblGeslacht() {
		return lblGeslacht;
	}

	/**
	 * @return the lblId
	 */
	public JLabel getLblId() {
		return lblId;
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

}
