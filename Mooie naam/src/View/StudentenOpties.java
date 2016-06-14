package View;

import java.awt.GridBagLayout;
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
import java.awt.GridBagConstraints;
import java.awt.Insets;

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

	public BinnenlandInvoer getInvoer() {
		return invoer;
	}

	public StudentenOpties() {
		btnGroup = new ButtonGroup();

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Naam", "Tussenvoegsel", "Achternaam", "Geslacht" });
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 21, 0, 0, 21, 28, 21, 21, 21, 0, 25, 0, 23, 6, 1, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 286, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 5.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		table = new JTable();
		table.setModel(tableModel);
		table.setDefaultEditor(Object.class, null);
		lblGeslacht = new JLabel();
		lblGeslacht.setText("Geslacht:");
		GridBagConstraints gbc_lblGeslacht = new GridBagConstraints();
		gbc_lblGeslacht.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblGeslacht.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeslacht.gridx = 1;
		gbc_lblGeslacht.gridy = 0;
		add(lblGeslacht, gbc_lblGeslacht);
		rBtnM = new JRadioButton();

		GridBagConstraints gbc_rBtnM = new GridBagConstraints();
		gbc_rBtnM.anchor = GridBagConstraints.NORTHWEST;
		gbc_rBtnM.insets = new Insets(0, 0, 5, 5);
		gbc_rBtnM.gridx = 2;
		gbc_rBtnM.gridy = 0;
		add(rBtnM, gbc_rBtnM);
		btnGroup.add(rBtnM);
		rBtnV = new JRadioButton();
		GridBagConstraints gbc_rBtnV = new GridBagConstraints();
		gbc_rBtnV.anchor = GridBagConstraints.NORTHWEST;
		gbc_rBtnV.insets = new Insets(0, 0, 5, 5);
		gbc_rBtnV.gridx = 3;
		gbc_rBtnV.gridy = 0;
		add(rBtnV, gbc_rBtnV);
		btnGroup.add(rBtnV);
		comboBox = new JComboBox<String>();

		comboBox.addItem("Wijzigen");
		comboBox.addItem("Studie inschrijven");
		comboBox.addItem("Stage inschrijven");
		comboBox.addItem("Inschrijving wijzigen");
		comboBox.addItem("locatie");
		comboBox.addItem("Onderwijs overzicht");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		chckbxGeslacht = new JCheckBox();
		GridBagConstraints gbc_chckbxGeslacht = new GridBagConstraints();
		gbc_chckbxGeslacht.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxGeslacht.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGeslacht.gridx = 5;
		gbc_chckbxGeslacht.gridy = 0;
		add(chckbxGeslacht, gbc_chckbxGeslacht);
		chckbxId = new JCheckBox();
		GridBagConstraints gbc_chckbxId = new GridBagConstraints();
		gbc_chckbxId.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxId.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxId.gridx = 6;
		gbc_chckbxId.gridy = 0;
		add(chckbxId, gbc_chckbxId);
		chckbxNaam = new JCheckBox();
		GridBagConstraints gbc_chckbxNaam = new GridBagConstraints();
		gbc_chckbxNaam.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxNaam.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNaam.gridx = 7;
		gbc_chckbxNaam.gridy = 0;
		add(chckbxNaam, gbc_chckbxNaam);
		lblId = new JLabel();
		lblId.setText("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 8;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		txtFieldId = new JTextField();
		GridBagConstraints gbc_txtFieldId = new GridBagConstraints();
		gbc_txtFieldId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldId.anchor = GridBagConstraints.NORTH;
		gbc_txtFieldId.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldId.gridx = 9;
		gbc_txtFieldId.gridy = 0;
		add(txtFieldId, gbc_txtFieldId);
		lblNaam = new JLabel();
		lblNaam.setText("Naam:");
		GridBagConstraints gbc_lblNaam = new GridBagConstraints();
		gbc_lblNaam.insets = new Insets(0, 0, 0, 5);
		gbc_lblNaam.gridheight = 2;
		gbc_lblNaam.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNaam.gridx = 10;
		gbc_lblNaam.gridy = 0;
		add(lblNaam, gbc_lblNaam);
		txtFieldNaam = new JTextField();
		GridBagConstraints gbc_txtFieldNaam = new GridBagConstraints();
		gbc_txtFieldNaam.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldNaam.gridwidth = 2;
		gbc_txtFieldNaam.anchor = GridBagConstraints.NORTH;
		gbc_txtFieldNaam.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldNaam.gridx = 11;
		gbc_txtFieldNaam.gridy = 0;
		add(txtFieldNaam, gbc_txtFieldNaam);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 13;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		invoer = new BinnenlandInvoer();
		GridBagConstraints gbc_invoer = new GridBagConstraints();
		gbc_invoer.gridx = 13;
		gbc_invoer.gridy = 1;
		add(invoer, gbc_invoer);
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

}
