package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GegevensOpvragen extends JPanel{
    
    JButton BtnOverzicht1 = new JButton("Overzicht 1");
    JButton BtnOverzicht2 = new JButton("Overzicht 2");
    JButton BtnOverzicht3 = new JButton("Overzicht 3");
    
    private JTable table;
    private DefaultTableModel tableModel;
    
    public GegevensOpvragen(){
        setLayout(null);
        setBackground(new Color(0x395e7c));
        
        table = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"..", "...", "....", "....."});
        table.setModel(tableModel);
        table.setDefaultEditor(Object.class, null);
        
        JScrollPane tbl = new JScrollPane(table);
        
        BtnOverzicht1.setBounds(20, 100, 200, 50);
        BtnOverzicht1.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        BtnOverzicht1.setForeground(new Color(0x00284d));
        BtnOverzicht1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(BtnOverzicht1);
        BtnOverzicht2.setBounds(20, 200, 200, 50);
        BtnOverzicht2.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        BtnOverzicht2.setForeground(new Color(0x00284d));
        BtnOverzicht2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(BtnOverzicht2);
        BtnOverzicht3.setBounds(20, 300, 200, 50);
        BtnOverzicht3.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        BtnOverzicht3.setForeground(new Color(0x00284d));
        BtnOverzicht3.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(BtnOverzicht3);
        tbl.setBounds(250, 20, 740, 620);
        add(tbl);
        
    }
    
    
	
}
