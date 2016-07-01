package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainWindow extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton btnStudent;
    private JButton btnStuSearch;
    private JButton btnOnderwijseenheid;
    private JButton btnContact;
    private JButton btnGegOpvragen;
    private JSplitPane splitPane;
    private JPanel rightPanel;

    public MainWindow() {
        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel = new JPanel();
        GridLayout gl = new GridLayout(9, 2);
        gl.setVgap(20);
        gl.setHgap(20);
        panel.setLayout(gl);
        
        rightPanel = new JPanel();

        splitPane = new JSplitPane();
        splitPane.setDividerSize(1);
        splitPane.setDividerLocation(260);

        getContentPane().add(splitPane);

        splitPane.setLeftComponent(panel);
        splitPane.getLeftComponent().setMinimumSize(new Dimension(260, 720));
        splitPane.getLeftComponent().setMaximumSize(new Dimension(260, 720));
        //panel.setBackground(new Color(0xe6ffff));
        panel.setBackground(new Color(0x39325d));

        splitPane.setRightComponent(rightPanel);
        rightPanel.setBackground(new Color(0x395e7c));
        panel.add(new JLabel());

        JLabel lbl = new JLabel("<html>HHS <br>International Office<br> <br> </html>");
        lbl.setHorizontalAlignment(JLabel.CENTER);
        //lbl.setForeground(new Color(0x003300));
        lbl.setForeground(new Color(0xA5C3F7));
        lbl.setFont(new Font("Stencil", Font.PLAIN, 22));
        panel.add(lbl);

        //panel.add(new JLabel());
        btnStudent = new JButton("Nieuwe student");
        btnStudent.setToolTipText("Klik om een nieuw student met zijn gegevens toe te voegen");
        //btnStudent.setBackground(new Color(0xcccccc));
        btnStudent.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnStudent.setForeground(new Color(0x00284d));
        btnStudent.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        panel.add(btnStudent);
        
        btnContact = new JButton("Contact studie");
        btnContact.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnContact.setForeground(new Color(0x00284d));
        btnContact.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        panel.add(btnContact);

        btnStuSearch = new JButton("Student opties");
        btnStuSearch.setToolTipText("Klik voor het opzoeken van een student om deze te kunnen wijzigen of inschrijven");
        btnStuSearch.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnStuSearch.setForeground(new Color(0x00284d));
        btnStuSearch.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        panel.add(btnStuSearch);

        btnOnderwijseenheid = new JButton("Onderwijseenhied toevoegen");
        btnOnderwijseenheid.setToolTipText("Klik voor het opzoeken van een opleiding om er een kunt te kunnen toevoegen of bekijken");
        btnOnderwijseenheid.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnOnderwijseenheid.setForeground(new Color(0x00284d));
        btnOnderwijseenheid.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        panel.add(btnOnderwijseenheid);

        btnGegOpvragen = new JButton("Gegevens opvragen");
        btnGegOpvragen.setToolTipText("Klik om verschillende overzichten te kunnen bekijken");
        btnGegOpvragen.setBorder(BorderFactory.createLineBorder(new Color(0x003300)));
        btnGegOpvragen.setForeground(new Color(0x00284d));
        btnGegOpvragen.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        panel.add(btnGegOpvragen);
        
        panel.add(new JLabel());
        panel.add(new JLabel());
        

    }
    
    public JButton getBtnOnderwijseenheid() {
        return btnOnderwijseenheid;
    }
    
    public JButton getBtnGegOpvragen() {
        return btnGegOpvragen;
    }
    
    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public JButton getBtnStudent() {
        return btnStudent;
    }

    /**
     * @return the btnStuSearch
     */
    public JButton getBtnStuSearch() {
        return btnStuSearch;
    }

	public JPanel getRightPanel() {
		return rightPanel;
	}

    /**
     * @return the btnContact
     */
    public JButton getBtnContact() {
        return btnContact;
    }
}
