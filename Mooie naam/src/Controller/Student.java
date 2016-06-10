package Controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import View.BinnenlandInvoer;
import View.ExchangeInvoer;

public class Student {
	private String student;
	private Database db;
	
	public Student(Database db, int type) {
		this.db = db;
		
		switch(type){
		case 0: student = "HHS_student";
				maakBinnenlandStudent();
				break;
		case 1: student = "EXC_student";
				maakExchangeStudent();
				break;
		}
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

	private void maakBinnenlandStudent(){	
//		Main.mainWindow.getBtnStudent().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
                BinnenlandInvoer invoer = new BinnenlandInvoer();
                Main.mainWindow.getSplitPane().setRightComponent(invoer);
                invoer.getBtnOk().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(!invoer.getTxtFieldEmailadres().getText().isEmpty() && !invoer.getTxtFieldGeslacht().getText().isEmpty() && !invoer.getTxtFieldId().getText().isEmpty() && !invoer.getTxtFieldVoornaam().getText().isEmpty() && !invoer.getTxtFieldAchternaam().getText().isEmpty() && !invoer.getTxtFieldOpleiding().getText().isEmpty()){
                        db.executeInsertStatement("INSERT INTO " + student + " VALUES" + "(" + Integer.parseInt(invoer.getTxtFieldId().getText()) + "," //id
                                + "'" + invoer.getTxtFieldVoornaam().getText() + "'" + "," 		//voornaam
                                + "'" + invoer.getTxtFieldTussenvoegsel().getText() + "'" + ","	//tussenvoegsel
                                + "'" + invoer.getTxtFieldAchternaam().getText() + "'" + ","	//achternaam
                                + "'" + invoer.getTxtFieldGeslacht().getText() + "'" + ","		//geslacht, moet een radiobuttongroup worden
                                + "'" + invoer.getTxtFieldEmailadres().getText() + "'" + ","	//emailadres
                                + "'" + invoer.getTxtFieldOpleiding().getText() + "'" + ","		//opleiding
                                + "'" + invoer.getTxtFieldUniversiteit().getText() + "'"		//universiteit
                                + ")");
                        db.executeInsertStatement("INSERT INTO " + student + "_tel VALUES" + "(" +
                                Integer.parseInt("30") + "," + //30 placeholder
                                "'" + invoer.getTxtFieldTel().getText() + "'" + ")");
                        } else {
                        	System.out.println("Gelieve alle velden in te vullen");
                        }
                    }
                });
//            }
//        });
	}
	
	private void maakExchangeStudent() {
		ExchangeInvoer invoer = new ExchangeInvoer();
		Main.mainWindow.getSplitPane().setRightComponent(invoer);
		invoer.getBtnOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!invoer.getTxtFieldStraat().getText().isEmpty() && !invoer.getTxtFieldPost().getText().isEmpty() && !invoer.getTxtFieldHuisnr().getText().isEmpty() && !invoer.getTxtFieldUniversiteit().getText().isEmpty() && !invoer.getTxtFieldLandvanherkomst().getText().isEmpty() && !invoer.getTxtFieldWoonplaats().getText().isEmpty() && !invoer.getTxtFieldEmailadres().getText().isEmpty() && !invoer.getTxtFieldGeslacht().getText().isEmpty() && !invoer.getTxtFieldVoornaam().getText().isEmpty() && !invoer.getTxtFieldAchternaam().getText().isEmpty()){
                    db.executeInsertStatement("INSERT INTO " + student + " VALUES" + "(" + Integer.parseInt(invoer.getTxtFieldId().getText()) + "," //id
                            + "'" + invoer.getTxtFieldVoornaam().getText() + "'" + "," 		//voornaam
                            + "'" + invoer.getTxtFieldTussenvoegsel().getText() + "'" + ","	//tussenvoegsel
                            + "'" + invoer.getTxtFieldAchternaam().getText() + "'" + ","	//achternaam
                            + "'" + invoer.getTxtFieldGeslacht().getText() + "'" + ","		//geslacht, moet een radiobuttongroup worden
                            + "'" + invoer.getTxtFieldEmailadres().getText() + "'" + ","	//emailadres
                            + "'" + invoer.getTxtFieldStraat().getText() + "'" + ","		//straat
                            + "'" + invoer.getTxtFieldWoonplaats().getText() + "'" + ","	//woonplaats
                            + "'" + invoer.getTxtFieldLandvanherkomst().getText() + "'" + "," //land
                            + "'" + invoer.getTxtFieldUniversiteit().getText() + "'"		//universiteit
                            + "'" + invoer.getTxtFieldHuisnr().getText() + "'" + ","		//huisnr
                            + "'" + invoer.getTxtFieldToe().getText() + "'" + ","			//toevoeging
                            + "'" + invoer.getTxtFieldPost().getText() + "'" + ","			//postcode
                            + ")");
                    db.executeInsertStatement("INSERT INTO " + student + "_tel VALUES" + "(" +
                            Integer.parseInt("30") + "," + //30 placeholder
                            "'" + invoer.getTxtFieldTel().getText() + "'" + ")");
                    } else {
                    	System.out.println("Gelieve alle velden in te vullen");
                    }
			}
		});
	}
}