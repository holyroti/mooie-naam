package Controller;

import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Model.ExcStudentModel;
import Model.OnderwijseenheidModel;
import Model.OpleidingModel;
import Model.StageModel;
import Model.StudentModel;
import View.BinnenlandInvoer;
import View.ExchangeInvoer;
import View.StudentenOpties;

public class Student {

	private String student;
	private Database db;
	private int id;
	private int nieuw;

	public Student(Database db, int type, int nieuw) {
		this.db = db;
		this.nieuw = nieuw;

		switch (type) {
		case 0:
			student = "HHS_student";
			break;
		case 1:
			student = "EXC_student";
			break;
		}

		switch (nieuw) {
		case 0:
			maakBinnenlandStudent();
			break;
		case 1:
			maakExchangeStudent();
			break;
		case 2:
			System.out.println("");
		}
	}

	private void maakBinnenlandStudent() {
		BinnenlandInvoer invoer = new BinnenlandInvoer();

		Main.mainWindow.getSplitPane().setRightComponent(invoer);
		ResultSet rs = db.executeStatement("SELECT max(id) FROM " + "`15025713`" + "." + student);
		ResultSet rs2 = db.executeStatement("select * from Opleiding;");
                HashMap<String, OpleidingModel> opleidingMap = new HashMap<>();
		try {
			rs.next();
			String sid = rs.getString("max(id)");
			id = Integer.parseInt(sid) + 1;
                        invoer.getTxtFieldId().setText(Integer.toString(id));

			rs2.last();
			OpleidingModel[] opleiding = new OpleidingModel[rs2.getRow()];
			rs2.beforeFirst();                       
			while (rs2.next()) {
				opleiding[rs2.getRow() - 1] = new OpleidingModel(rs2.getString("id"), rs2.getString("naam"),
						rs2.getString("type"), rs2.getString("contactpersoon"));
                                opleidingMap.put(opleiding[rs2.getRow() - 1].getNaam(), opleiding[rs2.getRow() - 1]);
				invoer.getTxtFieldOpleiding().addItem(opleiding[rs2.getRow() - 1].getNaam());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invoer.getBtnOk().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (invoer.isFilled()) {
					db.executeInsertStatement("INSERT INTO " + student + " VALUES" + "(" + id + "," // id
							+ "'" + invoer.getTxtFieldVoornaam().getText() + "'" + "," // voornaam
							+ "'" + invoer.getTxtFieldTussenvoegsel().getText() + "'" + "," // tussenvoegsel
							+ "'" + invoer.getTxtFieldAchternaam().getText() + "'" + "," // achternaam
							+ "'" + invoer.getTxtFieldGeslacht().getText() + "'" + "," // geslacht
							+ "'" + invoer.getTxtFieldEmailadres().getText() + "'" + "," // emailadres
							+ "'" + opleidingMap.get(invoer.getTxtFieldOpleiding().getSelectedItem()).getId() + "'"
							+ "," // opleiding
							+ "'" + "Haagse Hogeschool" + "'" // universiteit
							+ ")");
                                        toevoegenTelHhs(invoer);
				} else {
					System.out.println("Gelieve alle velden in te vullen");
				}
			}
		});
                invoer.getBtnCancel().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       Main.mainWindow.getSplitPane().setRightComponent(Main.mainWindow.getRightPanel());
                    }
                });
		// }
		// });
	}

	private void maakExchangeStudent() {
		ExchangeInvoer invoer = new ExchangeInvoer();
		Main.mainWindow.getSplitPane().setRightComponent(invoer);
		ResultSet rs = db.executeStatement("SELECT max(id) FROM " + student);
		ResultSet rs2 = db.executeStatement("select * from Opleiding;");
                HashMap<String, OpleidingModel> opleidingMap = new HashMap<>();
		try {
			rs.next();
			String sid = rs.getString("max(id)");
			id = Integer.parseInt(sid) + 1;
                        invoer.getTxtFieldId().setText(Integer.toString(id));

			rs2.last();
			OpleidingModel[] opleiding = new OpleidingModel[rs2.getRow()];
			rs2.beforeFirst();
			while (rs2.next()) {
				opleiding[rs2.getRow() - 1] = new OpleidingModel(rs2.getString("id"), rs2.getString("naam"),
						rs2.getString("type"), rs2.getString("contactpersoon"));
                                opleidingMap.put(opleiding[rs2.getRow() - 1].getNaam(), opleiding[rs2.getRow() - 1]);
				invoer.getTxtFieldOpleiding().addItem(opleiding[rs2.getRow() - 1].getNaam());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invoer.getBtnOk().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!invoer.getTxtFieldStraat().getText().isEmpty() && !invoer.getTxtFieldPost().getText().isEmpty()
						&& !invoer.getTxtFieldHuisnr().getText().isEmpty()
						&& !invoer.getTxtFieldUniversiteit().getText().isEmpty()
						&& !invoer.getTxtFieldLandvanherkomst().getText().isEmpty()
						&& !invoer.getTxtFieldWoonplaats().getText().isEmpty()
						&& !invoer.getTxtFieldEmailadres().getText().isEmpty()
						&& !invoer.getTxtFieldGeslacht().getText().isEmpty()
						&& !invoer.getTxtFieldVoornaam().getText().isEmpty()
						&& !invoer.getTxtFieldAchternaam().getText().isEmpty()) {
					db.executeInsertStatement("INSERT INTO " + student + " VALUES " + "(" + id + "," // id
							+ " '" + invoer.getTxtFieldVoornaam().getText() + "'" + "," // voornaam
							+ " '" + invoer.getTxtFieldTussenvoegsel().getText() + "'" + "," // tussenvoegsel
							+ " '" + invoer.getTxtFieldAchternaam().getText() + "'" + "," // achternaam
							+ " '" + invoer.getTxtFieldGeslacht().getText() + "'" + "," // geslacht
							+ " '" + invoer.getTxtFieldEmailadres().getText() + "'" + "," // emailadres
							+ " '" + invoer.getTxtFieldStraat().getText() + "'" + "," // straat
							+ " '" + invoer.getTxtFieldWoonplaats().getText() + "'" + "," // woonplaats
							+ " '" + invoer.getTxtFieldLandvanherkomst().getText() + "'" + "," // land
							+ " '" + invoer.getTxtFieldUniversiteit().getText() + "'" + "," // universiteit
							+ " '" + invoer.getTxtFieldHuisnr().getText() + "'" + "," // huisnr
							+ " '" + invoer.getTxtFieldToe().getText() + "'" + "," // toevoeging
							+ " '" + invoer.getTxtFieldPost().getText() + "'" // postcode
							+ " ," + opleidingMap.get(invoer.getTxtFieldOpleiding().getSelectedItem()).getId() // opleiding
							+ ")");
					                               toevoegenTelExc(invoer);
				} else {
					System.out.println("Gelieve alle velden in te vullen");
				}
			}
		});
                invoer.getBtnCancel().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       Main.mainWindow.getSplitPane().setRightComponent(Main.mainWindow.getRightPanel());
                    }
                });
	}

	public void updateExchangeStudent(ExchangeInvoer invoer, HashMap<String, OpleidingModel> map) {
		String tussenvoegsel;
		if (invoer.getTxtFieldTussenvoegsel().getText() == null
				|| invoer.getTxtFieldTussenvoegsel().getText().equals("")) {
			tussenvoegsel = " tussenvoegsel = null,";
		} else
			tussenvoegsel = " tussenvoegsel ='" + invoer.getTxtFieldTussenvoegsel().getText() + "',";

		db.executeInsertStatement("UPDATE " + student + " SET" + " voornaam='" + invoer.getTxtFieldVoornaam().getText()
				+ "'," + tussenvoegsel + " achternaam='" + invoer.getTxtFieldAchternaam().getText() + "',"
				+ " geslacht='" + invoer.getTxtFieldGeslacht().getText() + "'," + " emailadres='"
				+ invoer.getTxtFieldEmailadres().getText() + "'," + " straat='" + invoer.getTxtFieldStraat().getText()
				+ "'," + " woonplaats='" + invoer.getTxtFieldWoonplaats().getText() + "'," + " landvherkomst='"
				+ invoer.getTxtFieldLandvanherkomst().getText() + "'," + " universiteit='"
				+ invoer.getTxtFieldUniversiteit().getText() + "'," + " toevoeging='"
				+ invoer.getTxtFieldToe().getText() + "'," + " postcode='" + invoer.getTxtFieldPost().getText() + "',"
				+ " opleiding=" + map.get(invoer.getTxtFieldOpleiding().getSelectedItem()).getId() + " WHERE id = "
				+ invoer.getTxtFieldId().getText());

		Main.mainWindow.getSplitPane().setRightComponent(Main.mainWindow.getRightPanel());
	}

	public void updateHhsStudent(BinnenlandInvoer invoer, HashMap<String, OpleidingModel> map) {
		String tussenvoegsel;
		if (invoer.getTxtFieldTussenvoegsel().getText() == null
				|| invoer.getTxtFieldTussenvoegsel().getText().equals("")) {
			tussenvoegsel = " tussenvoegsel = null,";
		} else
			tussenvoegsel = " tussenvoegsel ='" + invoer.getTxtFieldTussenvoegsel().getText() + "',";

		db.executeInsertStatement("UPDATE " + student + " SET" + " naam='" + invoer.getTxtFieldVoornaam().getText()
				+ "'," + tussenvoegsel + " achternaam='" + invoer.getTxtFieldAchternaam().getText() + "',"
				+ " geslacht='" + invoer.getTxtFieldGeslacht().getText() + "'," + " emailadres='"
				+ invoer.getTxtFieldEmailadres().getText() + "'," + " opleiding='"
				+  map.get(invoer.getTxtFieldOpleiding().getSelectedItem()).getId() + "'," + " universiteit='"
				+ "Haagse Hogeschool" + "'" + " WHERE id = " + invoer.getTxtFieldId().getText());

		Main.mainWindow.getSplitPane().setRightComponent(Main.mainWindow.getRightPanel());
	}
        
        public void toevoegenTelHhs(BinnenlandInvoer invoer) {            
            String tel = invoer.getTxtFieldTel().getText();
            int nr = 0;
            for (int i=0; i < tel.length(); i++) {
                if (tel.charAt(i) == ',')
                    nr++;
            }
            
            String[] telnr = new String[nr];
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i=0; i < tel.length(); i++) {
                if (tel.charAt(i) == ',') {
                    telnr[count] = sb.toString();
                    sb = new StringBuilder();
                    count++;
                } else {
                    sb.append(tel.charAt(i));
                }
            }
            
            db.executeInsertStatement("delete from HHS_student_tel where id ='" + invoer.getTxtFieldId().getText() + "'"); //delete all telephonenumbers from a hhs student
            
            for (int i=0; i < nr; i++) {
                db.executeInsertStatement("insert into HHS_student_tel values('" + invoer.getTxtFieldId().getText() + "','" + telnr[i] + "')");
            }
        }

        public void toevoegenTelExc(ExchangeInvoer invoer) {
            String tel = invoer.getTxtFieldTel().getText();
            int nr = 0;
            for (int i=0; i < tel.length(); i++) {
                if (tel.charAt(i) == ',')
                    nr++;
            }
            
            String[] telnr = new String[nr];
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i=0; i < tel.length(); i++) {
                if (tel.charAt(i) == ',') {
                    telnr[count] = sb.toString();
                    sb = new StringBuilder();
                    count++;
                } else {
                    sb.append(tel.charAt(i));
                }
            }
            
            db.executeInsertStatement("delete from EXC_student_tel where id ='" + invoer.getTxtFieldId().getText() + "'"); //delete all telephonenumbers from a hhs student
            
            for (int i=0; i < nr; i++) {
                db.executeInsertStatement("insert into EXC_student_tel values('" + invoer.getTxtFieldId().getText() + "','" + telnr[i] + "')");
            }
        }
        
	public void inschrijvenOnderwijseenheid(StudentenOpties optiesPane) {
		try {
			try {
				StudentModel student = (StudentModel) optiesPane.getTableModel()
						.getValueAt(optiesPane.getTable().getSelectedRow(), 0);
				ResultSet rs = db
						.executeStatement("select * from Onderwijseenheid where opleiding = " + student.getOpleiding());
				rs.last();
				OnderwijseenheidModel[] comps = new OnderwijseenheidModel[rs.getRow()];
				rs.beforeFirst();
				while (rs.next()) {
					comps[rs.getRow() - 1] = new OnderwijseenheidModel(Integer.parseInt(rs.getString("id")),
							rs.getString("type"), Integer.parseInt(rs.getString("studiepunt")));
				}
				Object selectedOnderwijs = JOptionPane.showInputDialog(null, "Kies onderwijseenheid",
						"Inschrijving onderwijseenheid", JOptionPane.PLAIN_MESSAGE, null, comps, comps[0]);
				if (selectedOnderwijs != null) {
					db.executeInsertStatement("insert into HHS_inschrijving_onderwijseenheid VALUES ("
							+ optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0) + ","
							+ ((OnderwijseenheidModel) selectedOnderwijs).getId() + ",'"
							+ new Date(System.currentTimeMillis()).toString() + "')");
					JOptionPane.showMessageDialog(null, "Student is ingeschreven");
				}
			} catch (Exception e) {
				ExcStudentModel student = (ExcStudentModel) optiesPane.getTableModel()
						.getValueAt(optiesPane.getTable().getSelectedRow(), 0);
				ResultSet rs = db
						.executeStatement("select * from Onderwijseenheid where opleiding = " + student.getOpleiding());
				rs.last();
				OnderwijseenheidModel[] comps = new OnderwijseenheidModel[rs.getRow()];
				rs.beforeFirst();
				while (rs.next()) {
					comps[rs.getRow() - 1] = new OnderwijseenheidModel(Integer.parseInt(rs.getString("id")),
							rs.getString("type"), Integer.parseInt(rs.getString("studiepunt")));
				}
				Object selectedOnderwijs = JOptionPane.showInputDialog(null, "Kies studie", "Inschrijving studie",
						JOptionPane.PLAIN_MESSAGE, null, comps, comps[0]);
				if (selectedOnderwijs != null) {
					db.executeInsertStatement("insert into EXC_inschrijving_onderwijseenheid VALUES ("
							+ optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0) + ","
							+ ((OnderwijseenheidModel) selectedOnderwijs).getId() + ",'"
							+ new Date(System.currentTimeMillis()).toString() + "')");
					JOptionPane.showMessageDialog(null, "Student is ingeschreven");
				}
			}

			// rs.last();
			// OnderwijseenheidModel[] comps = new
			// OnderwijseenheidModel[rs.getRow()];
			// rs.beforeFirst();
			// while (rs.next()) {
			// comps[rs.getRow() - 1] = new
			// OnderwijseenheidModel(Integer.parseInt(rs.getString("id")),
			// rs.getString("type"),
			// Integer.parseInt(rs.getString("studiepunt")));
			// }
			// Object selectedOnderwijs = JOptionPane.showInputDialog(null,
			// "Kies studie",
			// "Inschrijving studie", JOptionPane.PLAIN_MESSAGE, null, comps,
			// comps[0]);
			// if
			// (optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(),
			// 0)
			// .getClass().getName().equals(StudentModel.class.getName().toString()))
			// {
			// db.executeInsertStatement("insert into
			// HHS_inschrijving_onderwijseenheid VALUES ("
			// + optiesPane.getTableModel()
			// .getValueAt(optiesPane.getTable().getSelectedRow(), 0)
			// + "," + ((OnderwijseenheidModel) selectedOnderwijs).getId() +
			// ",'"
			// + new Date(System.currentTimeMillis()).toString() + "')");
			// } else {
			// db.executeInsertStatement("insert into
			// EXC_inschrijving_onderwijseenheid VALUES ("
			// + optiesPane.getTableModel()
			// .getValueAt(optiesPane.getTable().getSelectedRow(), 0)
			// + "," + ((OnderwijseenheidModel) selectedOnderwijs).getId() +
			// ",'"
			// + new Date(System.currentTimeMillis()).toString() + "')");
			// }
			// JOptionPane.showMessageDialog(null, "Student is ingeschreven");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inschrijvenStage(StudentenOpties optiesPane) {
		ResultSet rs = db.executeStatement("select * from Stage;");
		try {
			rs.last();
			StageModel[] comps = new StageModel[rs.getRow()];
			rs.beforeFirst();
			while (rs.next()) {
				comps[rs.getRow() - 1] = new StageModel(rs.getString("id"), rs.getString("bedrijfsnaam"),
						rs.getString("straat"), rs.getString("stad"), rs.getString("land"), rs.getString("postcode"),
						rs.getString("toevoeging"), rs.getString("huisnummer"));
			}
			Object selectedStudie = JOptionPane.showInputDialog(null, "Kies stage", "Inschrijving stage",
					JOptionPane.PLAIN_MESSAGE, null, comps, comps[0]);
			if (selectedStudie != null) {
				if (optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0).getClass()
						.getName().equals(StudentModel.class.getName().toString())) {
					db.executeInsertStatement("insert into HHS_inschrijving_stage VALUES ("
							+ optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0) + ","
							+ ((StageModel) selectedStudie).getId() + ",'"
							+ new Date(System.currentTimeMillis()).toString() + "')");
				} else {
					db.executeInsertStatement("insert into EXC_inschrijving_stage VALUES ("
							+ optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0) + ","
							+ ((StageModel) selectedStudie).getId() + ",'"
							+ new Date(System.currentTimeMillis()).toString() + "')");
				}
				JOptionPane.showMessageDialog(null, "Student is ingeschreven");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void locatieExcStudent(StudentenOpties optiesPane) {
		if (optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0).getClass().getName()
				.equals("Model.ExcStudentModel")) {
			JOptionPane.showMessageDialog(null, "Locatie student: Den Haag", "Locatie",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			StudentModel student = (StudentModel) optiesPane.getTableModel()
					.getValueAt(optiesPane.getTable().getSelectedRow(), 0);
			ResultSet rs = db.executeStatement("select Stage.stad, Stage.land from HHS_inschrijving_stage"
					+ " join HHS_student on HHS_inschrijving_stage.id = HHS_student.id"
					+ " join Stage on HHS_inschrijving_stage.stage = Stage.id" + " where HHS_inschrijving_stage.id = '"
					+ student.getId() + "'");

			try {
				StringBuilder sb = new StringBuilder();
				while (rs.next()) {
					sb.append(rs.getString("stad") + ", " + rs.getString("land") + "\n");
				}
				JOptionPane.showMessageDialog(null, "Locatie student: " + sb.toString(), "Locatie",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (HeadlessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void overzichtInschrijvingen(StudentenOpties optiesPane) {
		String id = ((StudentModel) optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0))
				.getId();
		ResultSet rs = db.executeStatement(
				"SELECT DISTINCT HHS_student.id, Opleiding.naam, Onderwijseenheid.studiepunt FROM HHS_inschrijving_onderwijseenheid JOIN HHS_student ON HHS_student.id = HHS_inschrijving_onderwijseenheid.id  JOIN Opleiding ON Opleiding.id = HHS_inschrijving_onderwijseenheid.onderwijseenheid    JOIN Onderwijseenheid ON Onderwijseenheid.opleiding = Opleiding.id WHERE  HHS_student.id ="
						+ id);
		try {
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				sb.append("Opleiding: " + rs.getString("naam") + "\tAantal studiepunten: " + rs.getString("studiepunt")
						+ "\n");
			}
			JOptionPane.showMessageDialog(null, new TextArea(sb.toString()), "Overzicht",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
