package Controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import View.BinnenlandInvoer;

public class Student {
	private String student;
	private Database db;
	
	public Student(Database db, int type) {
		this.db = db;
		
		switch(type){
		case 0: student = "HHS_student";
				break;
		case 1: student = "EXC_student";
				break;
		}
		maakBinnenlandStudent();
	}
	
	public void zoekStudent(ArrayList<String> row) {
//		ResultSet rs = db.executeStatement("SELECT Name, CountryCode, Population FROM city WHERE Name = '" + name + "'");
//		int len = row.size();
//		try {
//			while(rs.next()) {
//				for(int i=0; i<len; i++) {
//					System.out.println(rs.getString(row.get(i)));
//				}
//			}
//			rs.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	//needs an frame
	//werkt in theorie, maar genereert error omdat de test datbase die ik (arjun) gebruik teveel entries heeft
	private void maakBinnenlandStudent(){	
		Main.mainWindow.getBtnHhsStuIn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                BinnenlandInvoer invoer = new BinnenlandInvoer();
                Main.mainWindow.getSplitPane().setRightComponent(invoer);
                invoer.getBtnOk().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(!invoer.getTxtFieldEmailadres().getText().isEmpty() && !invoer.getTxtFieldGeslacht().getText().isEmpty() && !invoer.getTxtFieldId().getText().isEmpty() && !invoer.getTxtFieldVoornaam().getText().isEmpty() && !invoer.getTxtFieldAchternaam().getText().isEmpty() && !invoer.getTxtFieldOpleiding().getText().isEmpty()){
                        db.executeInsertStatement("INSERT INTO " + student + " VALUES" + "(" + Integer.parseInt(invoer.getTxtFieldId().getText()) + ","
                                + "'" + invoer.getTxtFieldVoornaam().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldTussenvoegsel().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldAchternaam().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldGeslacht().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldEmailadres().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldOpleiding().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldOpleiding().getText() + "'"
                                + ")");
                        } else {
                        	System.out.println("Gelieve alle velden in te vullen");
                        }
                    }
                });
            }
        });
	}
	
	private void maakExchangeStudent() {
		
	}
}