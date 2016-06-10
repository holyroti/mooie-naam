package View;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

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
        
	public StudentenOpties(){
            setLayout(new GridLayout(0, 4, 0, 15));
		comboBox = new JComboBox<String>();
		rBtnV = new JRadioButton();
		rBtnM = new JRadioButton();
		chckbxNaam = new JCheckBox();
		chckbxId = new JCheckBox();
		chckbxGeslacht = new JCheckBox();
		txtFieldNaam = new JTextField();
		txtFieldId= new JTextField();
		btnGroup = new ButtonGroup();
		lblNaam = new JLabel();
		lblGeslacht = new JLabel();
		lblId = new JLabel();
                table = new JTable();
                tableModel = new DefaultTableModel();
                tableModel.setColumnIdentifiers(new String[]{"Naam", "Tussenvoegsel", "Achternaam", "Geslacht"});
                table.setModel(tableModel);
                table.setDefaultEditor(Object.class, null);
                        
                
		comboBox.addItem("Wijzigen");
                comboBox.addItem("Studie inschrijven");
                comboBox.addItem("Stage inschrijven");
                comboBox.addItem("Inschrijving wijzigen");
                comboBox.addItem("locatie");
                comboBox.addItem("Onderwijs overzicht");
                
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
                add(new JScrollPane(table));
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

    
	
}
