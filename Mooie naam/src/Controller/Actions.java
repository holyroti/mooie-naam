package Controller;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.EscapeTokenizer;

import Model.ExcStudentModel;
import Model.OpleidingModel;
import Model.StageModel;
import Model.StudentModel;
import View.BinnenlandInvoer;
import View.ExchangeInvoer;
import View.GegevensOpvragen;
import View.OpleidingZoeken;
import View.StudentenOpties;

public class Actions {

	public int n;

	public void startListener(Database db) {

		Main.mainWindow.getBtnOplSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//naamgeving niet correct????
				Opleiding search = new Opleiding(db);
				search.zoekOpleiding();
//				ResultSet rs = db.executeStatement("SELECT max(id) FROM Onderwijseenheid;");
//				ResultSet rs2 = db.executeStatement("SELECT Opleiding.naam, Opleiding.id FROM Opleiding;");
//				OpleidingModel[] opleidngen = null;
//				int id = 0;
//				try {
//					rs2.last();
//
//					opleidngen = new OpleidingModel[rs2.getRow()];
//					rs2.beforeFirst();
//					while (rs2.next()) {
//						opleidngen[rs2.getRow() - 1] = new OpleidingModel();
//						opleidngen[rs2.getRow() - 1].setId(rs2.getString("id"));
//						opleidngen[rs2.getRow() - 1].setNaam(rs2.getString("naam"));
//					}
//					rs.next();
//					id = Integer.parseInt(rs.getString("max(id)"));
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//				Object[] types = { "MINOR", "MAJOR" };
//				String naam = JOptionPane.showInputDialog("Geef naam");
//				String type = (String) JOptionPane.showInputDialog(null, "Choose type", "Type",
//						JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
//				String punten = JOptionPane.showInputDialog("Geef aantal studiepunten");
//				Object opleiding =  JOptionPane.showInputDialog(null, "Choose opleiding", "Opleiding",
//						JOptionPane.QUESTION_MESSAGE, null, opleidngen, opleidngen[0]);
//				
//				db.executeInsertStatement("INSERT INTO Onderwijseenheid VALUES("+ (id+1) + ",'" + type + "','" + punten + "','" + ((OpleidingModel)opleiding).getId() + "')");
			}
		});

		Main.mainWindow.getBtnStudent().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame frame = new Frame();
				Object[] options = { "HHS Student", "Exchange Student" };
				n = JOptionPane.showOptionDialog(frame, "Wat voor student wilt u invoeren", "Student",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				Student s = new Student(db, n, n);
			}
		});
		Main.mainWindow.getBtnStuSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {

				StudentenOpties optiesPane = new StudentenOpties();
				Main.mainWindow.getSplitPane().setRightComponent(optiesPane);
				BinnenlandInvoer invoer = new BinnenlandInvoer();
				HashMap<String, StudentModel> map = new HashMap<>();
				HashMap<String, ExcStudentModel> exMap = new HashMap<>();
				MouseListener wijzigMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							String type = optiesPane.getTableModel()
									.getValueAt(optiesPane.getTable().getSelectedRow(), 0).getClass().getName();

							if (type.equals("Model.StudentModel")) {
								View.BinnenlandInvoer invoer = new BinnenlandInvoer();
								StudentModel studentModel = map.get(((StudentModel) optiesPane.getTableModel()
										.getValueAt(optiesPane.getTable().getSelectedRow(), 0)).getId());
								invoer.getTxtFieldId().setText(studentModel.getId());
								invoer.getTxtFieldVoornaam().setText(studentModel.getVoornaam());
								invoer.getTxtFieldTussenvoegsel().setText(studentModel.getTussenvoegsel());
								invoer.getTxtFieldAchternaam().setText(studentModel.getAchternaam());
								invoer.getTxtFieldEmailadres().setText(studentModel.getEmailadres());
								invoer.getTxtFieldGeslacht().setText(studentModel.getGeslacht());
								invoer.getTxtFieldOpleiding().setSelectedItem(studentModel.getOpleiding());
								invoer.getTxtFieldTel().setText("placeholder");
								Main.mainWindow.getSplitPane().setRightComponent(invoer);

								invoer.getBtnOk().addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										Student s = new Student(db, 0, 0);
										s.updateHhsStudent(invoer);
									}
								});
							} else {
								View.ExchangeInvoer invoer = new ExchangeInvoer();
								ExcStudentModel excModel = exMap.get(((ExcStudentModel) optiesPane.getTableModel()
										.getValueAt(optiesPane.getTable().getSelectedRow(), 0)).getId());
								invoer.getTxtFieldVoornaam().setText(excModel.getVoornaam());
								invoer.getTxtFieldAchternaam().setText(excModel.getAchternaam());
								invoer.getTxtFieldTussenvoegsel().setText(excModel.getTussenvoegsel());
								invoer.getTxtFieldEmailadres().setText(excModel.getEmailadres());
								invoer.getTxtFieldGeslacht().setText(excModel.getGeslacht());
								invoer.getTxtFieldHuisnr().setText(excModel.getHuisnr());
								invoer.getTxtFieldId().setText(excModel.getId());
								invoer.getTxtFieldLandvanherkomst().setText(excModel.getLand());
								invoer.getTxtFieldStraat().setText(excModel.getStraat());
								invoer.getTxtFieldWoonplaats().setText(excModel.getWoonplaats());
								invoer.getTxtFieldPost().setText(excModel.getPostcode());
								invoer.getTxtFieldTel().setText("placeholder");
								invoer.getTxtFieldToe().setText(excModel.getToevoeging());
								invoer.getTxtFieldOpleiding().setSelectedItem(excModel.getOpleiding());
								Main.mainWindow.getSplitPane().setRightComponent(invoer);

								invoer.getBtnOk().addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										Student s = new Student(db, 1, 1);
										s.updateExchangeStudent(invoer);
									}
								});
							}
						}
					}

					@Override
					public void mousePressed(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseReleased(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseEntered(MouseEvent me) {

					}

					@Override
					public void mouseExited(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}
				};
				MouseListener studieInschrijvingMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							// Date date = new Date(System.currentTimeMillis());
							// System.out.println(date);
							Student s = new Student(db, 0, 2);
							s.inschrijvenOnderwijseenheid(optiesPane);
						}
					}

					@Override
					public void mousePressed(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseReleased(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseEntered(MouseEvent me) {

					}

					@Override
					public void mouseExited(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}
				};
				MouseListener stageInschrijvingMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							Student s = new Student(db, 0, 2);
							s.inschrijvenStage(optiesPane);
						}
					}

					@Override
					public void mousePressed(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseReleased(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseEntered(MouseEvent me) {

					}

					@Override
					public void mouseExited(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}
				};

				MouseListener locatieMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							Student s = new Student(db, 1, 2);
							s.locatieExcStudent(optiesPane);
						}
					}

					@Override
					public void mousePressed(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseReleased(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseEntered(MouseEvent me) {

					}

					@Override
					public void mouseExited(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}
				};

				MouseListener onderWijsOverzichtMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							Student s = new Student(db, 0, 2);
							s.overzichtInschrijvingen(optiesPane);
						}
					}

					@Override
					public void mousePressed(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseReleased(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}

					@Override
					public void mouseEntered(MouseEvent me) {

					}

					@Override
					public void mouseExited(MouseEvent me) {
						// To change body of generated methods,
						// choose Tools | Templates.
					}
				};

				ActionListener zoekListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						ResultSet rs = db.executeStatement("SELECT * FROM HHS_student WHERE naam LIKE'%"
								+ optiesPane.getTxtFieldNaam().getText() + "%'");
						ResultSet rsex = db.executeStatement("SELECT * FROM EXC_student WHERE voornaam LIKE '%"
								+ optiesPane.getTxtFieldNaam().getText() + "%'");
						try {
							optiesPane.getTableModel().setDataVector(null,
									new String[] { "ID", "Naam", "Tussenvoegsel", "Achternaam", "Geslacht" });
							while (rs.next()) {

								StudentModel studentModel = new StudentModel(rs.getString("id"), rs.getString("naam"),
										rs.getString("tussenvoegsel"), rs.getString("achternaam"),
										rs.getString("geslacht"), rs.getString("emailadres"), rs.getString("opleiding"),
										rs.getString("universiteit"));
								System.out.println(studentModel.getVoornaam() + studentModel.getTussenvoegsel()
										+ studentModel.getAchternaam() + studentModel.getGeslacht()
										+ studentModel.getId());
								map.put(studentModel.getId(), studentModel);
								optiesPane.getTableModel()
										.addRow(new Object[] { studentModel, rs.getString("naam"),
												rs.getString("tussenvoegsel"), rs.getString("achternaam"),
												rs.getString("geslacht") });
							}

							while (rsex.next()) {
								ExcStudentModel excStudentModel = new ExcStudentModel(rsex.getString("id"),
										rsex.getString("voornaam"), rsex.getString("tussenvoegsel"),
										rsex.getString("achternaam"), rsex.getString("geslacht"),
										rsex.getString("emailadres"), rsex.getString("straat"),
										rsex.getString("woonplaats"), rsex.getString("landvherkomst"),
										rsex.getString("universiteit"), rsex.getString("huisnummer"),
										rsex.getString("toevoeging"), rsex.getString("postcode"), rsex.getString("universiteit"));
								exMap.put(excStudentModel.getId(), excStudentModel);
								System.out.println(excStudentModel.getVoornaam() + excStudentModel.getTussenvoegsel()
										+ excStudentModel.getAchternaam() + excStudentModel.getGeslacht()
										+ excStudentModel.getId());
								// map.put(studentModel.getId(), studentModel);
								optiesPane.getTableModel()
										.addRow(new Object[] { excStudentModel, rsex.getString("voornaam"),
												rsex.getString("tussenvoegsel"), rsex.getString("achternaam"),
												rsex.getString("geslacht") });
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				};

				ActionListener zoekExcListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						ResultSet rs = db.executeStatement("SELECT * FROM EXC_student WHERE voornaam LIKE '%"
								+ optiesPane.getTxtFieldNaam().getText() + "%'");
						try {
							optiesPane.getTableModel().setDataVector(null,
									new String[] { "ID", "Naam", "Tussenvoegsel", "Achternaam", "Geslacht" });
							while (rs.next()) {
								ExcStudentModel excStudentModel = new ExcStudentModel(rs.getString("id"),
										rs.getString("voornaam"), rs.getString("tussenvoegsel"),
										rs.getString("achternaam"), rs.getString("geslacht"),
										rs.getString("emailadres"), rs.getString("straat"), rs.getString("woonplaats"),
										rs.getString("landvherkomst"), rs.getString("universiteit"),
										rs.getString("huisnummer"), rs.getString("toevoeging"),
										rs.getString("postcode"), rs.getString("universiteit"));
								System.out.println(excStudentModel.getVoornaam() + excStudentModel.getTussenvoegsel()
										+ excStudentModel.getAchternaam() + excStudentModel.getGeslacht()
										+ excStudentModel.getId());
								// map.put(studentModel.getId(), studentModel);
								optiesPane.getTableModel()
										.addRow(new String[] { rs.getString("id"), rs.getString("voornaam"),
												rs.getString("tussenvoegsel"), rs.getString("achternaam"),
												rs.getString("geslacht") });
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				};

				optiesPane.getComboBox().addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {

						if (e.getStateChange() == ItemEvent.SELECTED) {
							if (e.getItem().equals("Wijzigen")) {
								optiesPane.getTxtFieldNaam().addActionListener(zoekListener);
								optiesPane.getTable().addMouseListener(wijzigMouseListener);
							} else if (e.getItem().equals("Studie inschrijven")) {
								optiesPane.getTxtFieldNaam().addActionListener(zoekListener);
								optiesPane.getTable().addMouseListener(studieInschrijvingMouseListener);
							} else if (e.getItem().equals("Stage inschrijven")) {
								optiesPane.getTxtFieldNaam().addActionListener(zoekListener);
								optiesPane.getTable().addMouseListener(stageInschrijvingMouseListener);
							} else if (e.getItem().equals("Locatie Student")) {
								optiesPane.getTable().addMouseListener(locatieMouseListener);
								optiesPane.getTxtFieldNaam().addActionListener(zoekExcListener);
							} else if (e.getItem().equals("Onderwijs overzicht")) {
								optiesPane.getTxtFieldNaam().addActionListener(zoekListener);
								optiesPane.getTable().addMouseListener(onderWijsOverzichtMouseListener);
							}
						} else {
							if (e.getItem().equals("Wijzigen")) {
								optiesPane.getTxtFieldNaam().removeActionListener(zoekListener);
								optiesPane.getTable().removeMouseListener(wijzigMouseListener);
								optiesPane.remove(invoer);
								optiesPane.updateUI();
							} else if (e.getItem().equals("Studie inschrijven")) {
								optiesPane.getTxtFieldNaam().removeActionListener(zoekListener);
								optiesPane.getTable().removeMouseListener(studieInschrijvingMouseListener);
							} else if (e.getItem().equals("Stage inschrijven")) {
								optiesPane.getTxtFieldNaam().removeActionListener(zoekListener);
								optiesPane.getTable().removeMouseListener(stageInschrijvingMouseListener);
							} else if (e.getItem().equals("Locatie Student")) {
								optiesPane.getTxtFieldNaam().removeActionListener(zoekExcListener);

								optiesPane.getTable().removeMouseListener(locatieMouseListener);
							} else if (e.getItem().equals("Onderwijs overzicht")) {
								optiesPane.getTxtFieldNaam().removeActionListener(zoekListener);
								optiesPane.getTable().removeMouseListener(onderWijsOverzichtMouseListener);
							}
						}
					}
				});

			}
		});

		Main.mainWindow.getBtnGegOpvragen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GegevensOpvragen gegOpvragen = new GegevensOpvragen();
				Main.mainWindow.getSplitPane().setRightComponent(gegOpvragen);

				gegOpvragen.getBtnExcStudent().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							ResultSet rsNaam = db.executeStatement("SELECT DISTINCT naam FROM Opleiding;");
							Object[] naam = null;
							rsNaam.last();
							naam = new Object[rsNaam.getRow()];
							rsNaam.beforeFirst();
							while(rsNaam.next()){
								naam[rsNaam.getRow() - 1] = rsNaam.getString("naam");
							}
							String naamOpleiding = (String) JOptionPane.showInputDialog(null, "Kies opleiding", "Naam van opleiding", JOptionPane.QUESTION_MESSAGE, null, naam, naam[0]);
							rsNaam.close();
							
							ResultSet rsStudent = db.executeStatement("select EXC_student.voornaam, EXC_student.landvherkomst from EXC_student" +
									" join Opleiding on EXC_student.opleiding = Opleiding.id" +
								    " where Opleiding.naam = '" + naamOpleiding + "'");
							StringBuilder sb = new StringBuilder();
							while(rsStudent.next()) {
								sb.append(rsStudent.getString("voornaam") + ": " + rsStudent.getString("landvherkomst") + "\n");
							}
							JOptionPane.showMessageDialog(null, new TextArea(sb.toString()), "Overzicht",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

				gegOpvragen.getBtnAantalInschrijvingen().addActionListener(new ActionListener() {
					// Not complete
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ResultSet rsType = db.executeStatement("SELECT DISTINCT type FROM Onderwijseenheid;");
						Object[] type = null;
						try {
							rsType.last();
							type = new Object[rsType.getRow()];
							rsType.beforeFirst();
							while(rsType.next()){
								type[rsType.getRow() - 1] = rsType.getString("type");
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

						String onderwijsType = (String) JOptionPane.showInputDialog(null, "Kies opleiding", "Naam van Onderwijseenheid", JOptionPane.QUESTION_MESSAGE, null, type, type[0]);
						
						ResultSet rsJaar = db.executeStatement("select distinct extract(year from inschrijfdatum) as jaar from EXC_inschrijving_onderwijseenheid"
								+ "	join Onderwijseenheid on EXC_inschrijving_onderwijseenheid.onderwijseenheid = Onderwijseenheid.id"
								+ " where Onderwijseenheid.type = '" + onderwijsType + "'");
						Object[] jaar = null;
						try {
							rsJaar.last();
							jaar = new Object[rsJaar.getRow()];
							rsJaar.beforeFirst();
							while(rsJaar.next()){
								jaar[rsJaar.getRow() - 1] = rsJaar.getString("jaar");
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						String inschrijfdatum = (String) JOptionPane.showInputDialog(null, "Kies jaar", "Kies een schooljaar", JOptionPane.QUESTION_MESSAGE, null, jaar, jaar[0]);

						ResultSet rs = db.executeStatement(
								"SELECT COUNT(EXC_inschrijving_onderwijseenheid.onderwijseenheid) AS aantal, Onderwijseenheid.type,"
										+ " EXTRACT(YEAR FROM EXC_inschrijving_onderwijseenheid.inschrijfdatum) as jaar"
										+ " FROM EXC_inschrijving_onderwijseenheid"
										+ " JOIN Onderwijseenheid ON Onderwijseenheid.id = EXC_inschrijving_onderwijseenheid.id"
										+ " WHERE Onderwijseenheid.type = '" + onderwijsType + "'"
										+ " AND inschrijfdatum like '%" + inschrijfdatum + "%'"
										+ "	GROUP BY TYPE, inschrijfdatum");

						try {
							rs.next();
							JOptionPane.showMessageDialog(null, "aantal inschrijvingen: " + rs.getString("aantal") + "\n" + rs.getString("type") + "\n" + rs.getString("jaar"));
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showConfirmDialog(null, "Jaar nakijken");
						}
					}
				});

				gegOpvragen.getBtnStage().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ResultSet rs = db.executeStatement("SELECT land, count(*) as aantal FROM Stage"
								+ " GROUP BY land" + " ORDER BY aantal DESC" + " LIMIT 1");
						try {
							rs.next();
							JOptionPane.showMessageDialog(null, "Land: " + rs.getString("land") + "\n" + "Aantal: " + rs.getString("aantal"));
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							try {
								rs.close();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
					}
				});

				gegOpvragen.getBtnExcLand().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ResultSet rs = db.executeStatement("SELECT landvherkomst, count(*) as aantal FROM EXC_student"
								+ " GROUP BY landvherkomst" + " ORDER BY aantal DESC" + " LIMIT 1");
						try {
							rs.next();
							JOptionPane.showMessageDialog(null, "Land: " + rs.getString("landvherkomst") + "\n" + "Aantal: " + rs.getString("aantal"));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		});
	}
}
