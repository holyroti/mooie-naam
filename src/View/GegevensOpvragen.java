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
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton getBtnExcStudent() {
		return btnExcStudent;
	}

	public JButton getBtnAantalInschrijvingen() {
		return btnAantalInschrijvingen;
	}

	public JButton getBtnStage() {
		return btnStage;
	}

    JButton btnExcStudent = new JButton("Exchange studenten per studie");
	JButton btnAantalInschrijvingen = new JButton("Aantal inschrijvingen per onderwijseenheid (Exchange)");
    JButton btnStage = new JButton("Meest bezochte land");
    JButton btnExcLand = new JButton("Land meeste exchange studenten");
    private JButton btnContactpersoon = new JButton("Contactpersoon van opleiding");
    
    public JButton getBtnExcLand() {
		return btnExcLand;
	}
    
    public GegevensOpvragen(){
        setLayout(null);
        setBackground(new Color(0x395e7c));
        
        btnExcStudent.setBounds(20, 100, 500, 50);
        btnExcStudent.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnExcStudent.setForeground(new Color(0x00284d));
        btnExcStudent.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(btnExcStudent);
        btnAantalInschrijvingen.setBounds(20, 200, 500, 50);
        btnAantalInschrijvingen.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnAantalInschrijvingen.setForeground(new Color(0x00284d));
        btnAantalInschrijvingen.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(btnAantalInschrijvingen);
        btnStage.setBounds(20, 300, 500, 50);
        btnStage.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnStage.setForeground(new Color(0x00284d));
        btnStage.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(btnStage);
        btnExcLand.setBounds(20, 400, 500, 50);
        btnExcLand.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnExcLand.setForeground(new Color(0x00284d));
        btnExcLand.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(btnExcLand);  
        btnContactpersoon.setBounds(20, 500, 500, 50);
        btnContactpersoon.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnContactpersoon.setForeground(new Color(0x00284d));
        btnContactpersoon.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        add(btnContactpersoon);
    }

    /**
     * @return the btnContactpersoon
     */
    public JButton getBtnContactpersoon() {
        return btnContactpersoon;
    }

    /**
     * @param btnContactpersoon the btnContactpersoon to set
     */
    public void setBtnContactpersoon(JButton btnContactpersoon) {
        this.btnContactpersoon = btnContactpersoon;
    }
}
