package View;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
	
	public StudentenOpties(){
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
		lblGeslacht = new JLabel();;
		lblId = new JLabel();;
		
		btnGroup.add(rBtnV);
		btnGroup.add(rBtnM);
	}
	
}
