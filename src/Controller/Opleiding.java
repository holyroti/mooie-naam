package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.OpleidingModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.EventObject;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Opleiding {

    Database db;
    int id;

    public Opleiding(Database db) {
        this.db = db;
    }

    public void zoekOpleiding() {
        ResultSet rsId = db.executeStatement("SELECT max(id) FROM Onderwijseenheid;");
        ResultSet rsOpleiding = db.executeStatement("SELECT Opleiding.naam, Opleiding.id FROM Opleiding;");
        ResultSet rsType = db.executeStatement("SELECT DISTINCT type FROM Onderwijseenheid;");

        OpleidingModel[] opleidngen = null;
        Object[] types = null;
        try {
            rsOpleiding.last();
            opleidngen = new OpleidingModel[rsOpleiding.getRow()];
            rsOpleiding.beforeFirst();
            while (rsOpleiding.next()) {
                opleidngen[rsOpleiding.getRow() - 1] = new OpleidingModel();
                opleidngen[rsOpleiding.getRow() - 1].setId(rsOpleiding.getString("id"));
                opleidngen[rsOpleiding.getRow() - 1].setNaam(rsOpleiding.getString("naam"));
            }
            rsId.next();
            id = Integer.parseInt(rsId.getString("max(id)"));

            rsType.last();
            types = new Object[rsType.getRow()];
            rsType.beforeFirst();
            while (rsType.next()) {
                types[rsType.getRow() - 1] = rsType.getString("type");
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        // String naam = JOptionPane.showInputDialog("Geef naam");

        String type = (String) JOptionPane.showInputDialog(null, "Choose type", "Type", JOptionPane.QUESTION_MESSAGE,
                null, types, types[0]);
        if (type != null) {
            String punten = JOptionPane.showInputDialog("Geef aantal studiepunten");
            if (!punten.isEmpty() || punten != null) {
                Object opleiding = JOptionPane.showInputDialog(null, "Choose opleiding", "Opleiding",
                        JOptionPane.QUESTION_MESSAGE, null, opleidngen, opleidngen[0]);
                if (opleiding != null) {
                    String[] jaren = new String[9];
                    for (int i = new GregorianCalendar().get(Calendar.YEAR); i < 2025; i++) {
                        jaren[i - new GregorianCalendar().get(Calendar.YEAR)] = i + "/" + (i + 1);
                    }
                    Object jaar = JOptionPane.showInputDialog(null, "Kies schooljaar", "Schooljaar", JOptionPane.QUESTION_MESSAGE, null, jaren, jaren[0]);
                    if (jaar != null) {
                        JTable table = new JTable();

                        DefaultTableModel tm = new DefaultTableModel();
                        tm.setColumnIdentifiers(new Object[]{"", "Periode"});
                        for (int i = 1; i < 5; i++) {
                            tm.addRow(new Object[]{false, i});
                        }

                        table.setModel(tm);

                        table.getColumnModel()
                                .getColumn(0).setCellRenderer(new TableCellRenderer() {
                            @Override
                            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
                            ) {
                                return new JCheckBox("", (boolean) value);
                            }
                        }
                        );
                        table.getColumnModel().getColumn(0).setCellEditor(new TableCellEditor() {
                            @Override
                            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                                tm.setValueAt(!(Boolean) tm.getValueAt(row, column), row, column);
                                return new JCheckBox("", !(Boolean) tm.getValueAt(row, column));

                            }

                            @Override
                            public Object getCellEditorValue() {
                                return tm.getValueAt(table.getSelectedRow(), 0);
                            }

                            @Override
                            public boolean isCellEditable(EventObject anEvent) {
                                return true;
                            }

                            @Override
                            public boolean shouldSelectCell(EventObject anEvent) {
                                return false;
                            }

                            @Override
                            public boolean stopCellEditing() {
                                return !table.isCellSelected(table.getSelectedRow(), table.getSelectedColumn());
                            }

                            @Override
                            public void cancelCellEditing() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void addCellEditorListener(CellEditorListener l) {

                            }

                            @Override
                            public void removeCellEditorListener(CellEditorListener l) {

                            }
                        }
                        );
                        table.getColumnModel().getColumn(1).setCellEditor(new TableCellEditor() {
                            @Override
                            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                                return null;

                            }

                            @Override
                            public Object getCellEditorValue() {
                                return null;
                            }

                            @Override
                            public boolean isCellEditable(EventObject anEvent) {
                                return false;
                            }

                            @Override
                            public boolean shouldSelectCell(EventObject anEvent) {
                                return false;
                            }

                            @Override
                            public boolean stopCellEditing() {
                                return !table.isCellSelected(table.getSelectedRow(), table.getSelectedColumn());
                            }

                            @Override
                            public void cancelCellEditing() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void addCellEditorListener(CellEditorListener l) {

                            }

                            @Override
                            public void removeCellEditorListener(CellEditorListener l) {

                            }
                        }
                        );

                        table.getColumnModel().getColumn(0).setMaxWidth(23);
                        table.getColumnModel().getColumn(0).setMinWidth(23);
                        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                        JScrollPane scroll = new JScrollPane();
                        table.setSize(new Dimension(480, 10));
                        table.setPreferredSize(new Dimension(480, table.getPreferredSize().height));
                        scroll.getViewport().add(table);
                        scroll.updateUI();
                        table.updateUI();
                        JFrame frame = new JFrame("Kies periodes");
                        JPanel panel = new JPanel();
                        panel.setLayout(null);
                        panel.setBounds(0, 0, 290, 120);
                        JButton btnOk = new JButton("Ok");
                        scroll.setBounds(0, 0, 283, 87);
                        panel.add(scroll);
                        panel.add(btnOk);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        frame.setSize(290, 145);
                        frame.setResizable(false);

                        btnOk.setBounds(0, 87, 283, 27);
                        frame.add(panel);
                        btnOk.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Iterator it = tm.getDataVector().iterator();
                                try {
                                    db.executeInsertStatement("INSERT INTO Onderwijseenheid VALUES(" + (id + 1) + ",'" + type + "','"
                                            + punten + "','" + ((OpleidingModel) opleiding).getId() + "')");
                                } catch (SQLException ex) {
                                    Logger.getLogger(Opleiding.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                for (Iterator iterator = it; iterator.hasNext();) {
                                    Vector next = (Vector) iterator.next();
                                    //System.out.println(next);
                                    if ((Boolean) next.get(0)) {

                                        try {
                                            frame.dispose();
                                            
                                            db.executeInsertStatement("INSERT INTO Onderwijseenheid_periode VALUES(" + (id + 1) + ",'" + next.get(1) + "','" + jaar + "')");
                                            JOptionPane.showMessageDialog(null, "Onderwijseenheid is aangemaakt");
                                        } catch (SQLException ex) {
                                            Logger.getLogger(Opleiding.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
    }
}
