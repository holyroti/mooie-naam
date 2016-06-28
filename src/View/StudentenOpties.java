package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.util.Calendar;
import java.util.Date;
import java.util.EventObject;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Consumer;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import sun.util.calendar.LocalGregorianCalendar;

public class StudentenOpties extends JPanel {

    private JComboBox<String> comboBox;

    private JLabel lblAchternaam;
    private JTextField txtFieldAchternaam;

    private JLabel lblVoornaam;
    private JTextField txtFieldVoornaam;

    private JButton btnSearch;

    private JTable table;
    private DefaultTableModel tableModel;

    private BinnenlandInvoer invoer;

    public StudentenOpties() {
        setBackground(new Color(0x395e7c));

        setLayout(null);

        comboBox = new JComboBox<String>();
        txtFieldVoornaam = new JTextField();
        lblVoornaam = new JLabel("Voornaam");
        txtFieldAchternaam = new JTextField();
        lblAchternaam = new JLabel("Achternaam");
        btnSearch = new JButton("Zoek");

        invoer = new BinnenlandInvoer();

        table = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Naam", "Tussenvoegsel", "Achternaam", "Geslacht"});
        table.setModel(tableModel);
        table.setDefaultEditor(Object.class, null);
        comboBox.addItem("Choose option");
        comboBox.addItem("Wijzigen");
        comboBox.addItem("Onderwijseenheid inschrijven");
        comboBox.addItem("Stage inschrijven");
        comboBox.addItem("Locatie Student");
        comboBox.addItem("Onderwijs overzicht");

        JScrollPane tbl = new JScrollPane(table);

        lblAchternaam.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblAchternaam.setForeground(new Color(0xA5C3F7));
        lblVoornaam.setFont(new Font("Century Gothic", Font.BOLD, 17));
        lblVoornaam.setForeground(new Color(0xA5C3F7));

        comboBox.setBounds(20, 20, 250, 50);
        lblAchternaam.setBounds(410, 35, 100, 20);
        lblVoornaam.setBounds(410, 10, 100, 20);

        txtFieldAchternaam.setBounds(540, 35, 250, 20);
        txtFieldVoornaam.setBounds(540, 10, 250, 20);

        btnSearch.setBounds(830, 12, 100, 40);

        tbl.setBounds(20, 110, 960, 215);
        // zou iets van een if statement moeten worden in actions van als
        // wijzigingen gekozen en als student geselecteerd dan:
        // invoer.changeLayout();
        // invoer.setBounds(40, 335, 890, 310);
        // add(invoer);
        
        add(lblVoornaam);

        add(txtFieldVoornaam);

        add(comboBox);

        add(txtFieldAchternaam);

        add(lblAchternaam);

        add(btnSearch);

        add(tbl);
        
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
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
    public JTextField getTxtFieldAchternaam() {
        return txtFieldAchternaam;
    }

    /**
     * @return the lblNaam
     */
    public JLabel getLblAchternaam() {
        return lblAchternaam;
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

    public void setTxtFieldAchternaam(JTextField txtFieldAchternaam) {
        this.txtFieldAchternaam = txtFieldAchternaam;
    }

    public void setLblAchternaam(JLabel lblAchternaam) {
        this.lblAchternaam = lblAchternaam;
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

    /**
     * @return the lblVoornaam
     */
    public JLabel getLblVoornaam() {
        return lblVoornaam;
    }

    /**
     * @param lblVoornaam the lblVoornaam to set
     */
    public void setLblVoornaam(JLabel lblVoornaam) {
        this.lblVoornaam = lblVoornaam;
    }

    /**
     * @return the txtFieldVoornaam
     */
    public JTextField getTxtFieldVoornaam() {
        return txtFieldVoornaam;
    }

    /**
     * @param txtFieldVoornaam the txtFieldVoornaam to set
     */
    public void setTxtFieldVoornaam(JTextField txtFieldVoornaam) {
        this.txtFieldVoornaam = txtFieldVoornaam;
    }

}
