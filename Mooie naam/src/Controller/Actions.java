package Controller;

import java.awt.Frame;
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

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

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

	public static int n;

	public void startListener(Database db) {

		Main.mainWindow.getBtnOplSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String, OpleidingModel> opleidingMap = new HashMap<>();
				OpleidingZoeken opleidingZoeken = new OpleidingZoeken();
				Main.mainWindow.getSplitPane().setRightComponent(opleidingZoeken);
				// String s = JOptionPane.showInputDialog("Naam van opleiding");
				// ResultSet rs = db.executeStatement("SELECT Opleiding.naam as
				// naamopleiding, Opleiding.type, Opleiding.id, Contactpersoon.*
				// FROM Opleiding"
				// + " JOIN Contactpersoon on Opleiding.contactpersoon =
				// Contactpersoon.id"
				// + " WHERE Opleiding.naam = " + "'" + s + "'");
				ResultSet rs = db.executeStatement(
						"SELECT Opleiding.id, Opleiding.naam, Opleiding.type, Contactpersoon.naam AS Contactpersoon\n"
								+ "FROM Opleiding\n"
								+ "JOIN Contactpersoon ON Contactpersoon.id = Opleiding.contactpersoon;");
				ResultSet typeRs = db.executeStatement("SELECT DISTINCT Opleiding.type FROM Opleiding;");
				ResultSet naamRs = db.executeStatement("SELECT DISTINCT Contactpersoon.naam FROM Contactpersoon;");
				try {
					while (rs.next()) {
						OpleidingModel opleiding = new OpleidingModel(rs.getString("id"), rs.getString("naam"),
								rs.getString("type"), rs.getString("Contactpersoon"));
						opleidingMap.put(opleiding.getNaam(), opleiding);
						opleidingZoeken.getTxtNaamOpleiding().addItem(rs.getString("naam"));
					}
					while (typeRs.next()) {
						opleidingZoeken.getTxtType().addItem(typeRs.getString("type"));
					}
					while (naamRs.next()) {
						opleidingZoeken.getTxtContact().addItem(naamRs.getString("naam"));
					}

					opleidingZoeken.getTxtNaamOpleiding().addItemListener(new ItemListener() {
						@Override
						public void itemStateChanged(ItemEvent ie) {
							if (ItemEvent.SELECTED == ie.getStateChange()) {
								if (!ie.getItem().equals("Choose one")) {
									OpleidingModel selectedOpleiding = opleidingMap.get((String) ie.getItem());
									opleidingZoeken.getTxtId().setText(selectedOpleiding.getId());
									opleidingZoeken.getTxtType().setSelectedItem(selectedOpleiding.getType());
									opleidingZoeken.getTxtContact()
											.setSelectedItem(selectedOpleiding.getContactpersoonNaam());
								}
							}
						}
					});
					// opleidingZoeken.getTxtId().setText(rs.getString("id"));
					// opleidingZoeken.getTxtNaamOpleiding().setText(rs.getString("naamopleiding"));
					// opleidingZoeken.getTxtType().setText(rs.getString("type"));
					// opleidingZoeken.getTxtContact().setText(rs.getString("Contactpersoon"));
					// System.out.println(rs.getString("naamopleiding"));
					// System.out.println(rs.getString("type"));
					// System.out.println(rs.getString("emailadres"));
					// System.out.println(rs.getString("telefoonnummer"));
					// System.out.println(rs.getString("naam"));
					// System.out.println(rs.getString("geslacht"));
					rs.close();
					typeRs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				opleidingZoeken.getBtnOk().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!opleidingZoeken.getTxtNaamOpleiding().getSelectedItem().equals("Choose one")) {
							// TODO Auto-generated method stub
							try {
								ResultSet rsid = db.executeStatement("SELECT id FROM Contactpersoon WHERE naam = " + "'"
										+ (String) opleidingZoeken.getTxtContact().getSelectedItem() + "'");

								rsid.next();
								System.out.println(rsid.getString("id"));
								db.executeInsertStatement("UPDATE Opleiding SET " + "naam='"
										+ (String) opleidingZoeken.getTxtNaamOpleiding().getSelectedItem() + "'" + ", "
										+ "type='" + (String) opleidingZoeken.getTxtType().getSelectedItem() + "'"
										+ ", " + "contactpersoon=" + Integer.parseInt(rsid.getString("id"))
										+ " WHERE id=" + Integer.parseInt(opleidingZoeken.getTxtId().getText()));
								rsid.close();
							} catch (SQLException e2) {
								System.out.println("Gelieve naam opnieuw na te kijken");
								e2.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null, "You havent chosen an opleiding", "Choose an opleiding",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});

				opleidingZoeken.getBtnCancel().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

					}
				});
			}
		});

		Main.mainWindow.getBtnStudent().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame frame = new Frame();
				Object[] options = { "HHS Student", "Exchange Student" };
				n = JOptionPane.showOptionDialog(frame, "Wat voor student wilt u invoeren", "Student",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				// System.out.println(n);
				Student s = new Student(db, n);
			}
		});
		Main.mainWindow.getBtnStuSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {

				StudentenOpties optiesPane = new StudentenOpties();
				Main.mainWindow.getSplitPane().setRightComponent(optiesPane);
				BinnenlandInvoer invoer = new BinnenlandInvoer();
				HashMap<String, StudentModel> map = new HashMap<>();
				MouseListener wijzigMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							StudentModel studentModel = map.get(
									optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0));
							invoer.getTxtFieldAchternaam().setText(studentModel.getAchternaam());
							invoer.getTxtFieldEmailadres().setText(studentModel.getEmailadres());
							invoer.getTxtFieldGeslacht().setText(studentModel.getGeslacht());
							invoer.getTxtFieldOpleiding().setText(studentModel.getOpleiding());
							invoer.getTxtFieldTussenvoegsel().setText(studentModel.getTussenvoegsel());
							invoer.getTxtFieldUniversiteit().setText(studentModel.getUniversiteit());
							invoer.getTxtFieldVoornaam().setText(studentModel.getVoornaam());
							invoer.getTxtFieldId().setText(studentModel.getId());
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
							ResultSet rs = db.executeStatement("select * from Opleiding;");
							try {
								rs.last();
								OpleidingModel[] comps = new OpleidingModel[rs.getRow()];
								rs.beforeFirst();
								while (rs.next()) {
									comps[rs.getRow() - 1] = new OpleidingModel(rs.getString("id"),
											rs.getString("naam"), rs.getString("type"), rs.getString("contactpersoon"));
								}
								Object selectedStudie = JOptionPane.showInputDialog(null, "Kies studie",
										"Inschrijving studie", JOptionPane.PLAIN_MESSAGE, null, comps, comps[0]);
								db.executeInsertStatement("insert into HHS_inschrijving_onderwijseenheid VALUES ("
										+ optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(),
												0)
										+ "," + ((OpleidingModel) selectedStudie).getId() + ",'"
										+ new Date(System.currentTimeMillis()).toString() + "')");
								JOptionPane.showMessageDialog(null, "Student is ingeschreven");

							} catch (SQLException e) {
								e.printStackTrace();
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
				MouseListener stageInschrijvingMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							// Date date = new Date(System.currentTimeMillis());
							// System.out.println(date);
							ResultSet rs = db.executeStatement("select * from Stage;");
							try {
								rs.last();
								StageModel[] comps = new StageModel[rs.getRow()];
								rs.beforeFirst();
								while (rs.next()) {
									comps[rs.getRow() - 1] = new StageModel(rs.getString("id"),
											rs.getString("bedrijfsnaam"), rs.getString("straat"), rs.getString("stad"),
											rs.getString("land"), rs.getString("postcode"), rs.getString("toevoeging"),
											rs.getString("huisnummer"));
								}
								Object selectedStudie = JOptionPane.showInputDialog(null, "Kies stage",
										"Inschrijving stage", JOptionPane.PLAIN_MESSAGE, null, comps, comps[0]);
								db.executeInsertStatement("insert into HHS_inschrijving_stage VALUES ("
										+ optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(),
												0)
										+ "," + ((StageModel) selectedStudie).getId() + ",'"
										+ new Date(System.currentTimeMillis()).toString() + "')");
								JOptionPane.showMessageDialog(null, "Student is ingeschreven");

							} catch (SQLException e) {
								e.printStackTrace();
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
				MouseListener InschrijvingWijzigenMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							// Date date = new Date(System.currentTimeMillis());
							// System.out.println(date);
							ResultSet rs = db.executeStatement("select * from Stage;");
							try {
								rs.last();
								StageModel[] comps = new StageModel[rs.getRow()];
								rs.beforeFirst();
								while (rs.next()) {
									comps[rs.getRow() - 1] = new StageModel(rs.getString("id"),
											rs.getString("bedrijfsnaam"), rs.getString("straat"), rs.getString("stad"),
											rs.getString("land"), rs.getString("postcode"), rs.getString("toevoeging"),
											rs.getString("huisnummer"));
								}
								// Object selectedStudie =
								// JOptionPane.showInputDialog(null, "Kies
								// stage",
								// "Inschrijving stage",
								// JOptionPane.PLAIN_MESSAGE, null, comps,
								// comps[0]);
								// db.executeInsertStatement("insert into
								// HHS_inschrijving_stage VALUES (" +
								// optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(),0)
								// + "," + ((StageModel) selectedStudie).getId()
								// + ",'" + new
								// Date(System.currentTimeMillis()).toString()
								// +"')");
								// JOptionPane.showMessageDialog(null, "Student
								// is ingeschreven");

							} catch (SQLException e) {
								e.printStackTrace();
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

				MouseListener locatieMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							// Date date = new Date(System.currentTimeMillis());
							// System.out.println(date);
							ResultSet rs = db.executeStatement("select * from EXC_student;");
							try {
								rs.last();
								ExcStudentModel[] comps = new ExcStudentModel[rs.getRow()];
								rs.beforeFirst();
								while (rs.next()) {
									comps[rs.getRow() - 1] = new ExcStudentModel(rs.getString("id"),
											rs.getString("voornaam"), rs.getString("tussenvoegsel"),
											rs.getString("achternaam"), rs.getString("geslacht"),
											rs.getString("emailadres"), rs.getString("straat"),
											rs.getString("woonplaats"), rs.getString("landvherkomst"),
											rs.getString("universiteit"), rs.getString("huisnummer"),
											rs.getString("toevoeging"), rs.getString("postcode"));
								}
								ExcStudentModel  excStudent = comps[ Integer.parseInt((String) optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0)) - 1];
								JOptionPane.showMessageDialog(null, "Locatie student: " + excStudent.getStraat()+ " " + excStudent.getHuisnr()+ " "  + excStudent.getWoonplaats(), "Locatie", JOptionPane.INFORMATION_MESSAGE);;
							} catch (SQLException e) {
								e.printStackTrace();
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

				ActionListener zoekListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						ResultSet rs = db.executeStatement("SELECT * FROM HHS_student WHERE naam LIKE'%"
								+ optiesPane.getTxtFieldNaam().getText() + "%'");
						try {
							optiesPane.getTableModel().setDataVector(null,
									new String[] { "ID", "Naam", "Tussenvoegsel", "Achternaam", "Geslacht" });
							while (rs.next()) {

								StudentModel studentModel = new StudentModel(rs.getString("id"), rs.getString("naam"),
										rs.getString("tussenvoegsel"), rs.getString("achternaam"),
										rs.getString("geslacht"), rs.getString("emailadres"), rs.getString("opleiding"),
										rs.getString("universiteit"));
								System.out.println(studentModel.getVoornaam() + studentModel.getTussenvoegsel() + studentModel.getAchternaam() + studentModel.getGeslacht() + studentModel.getId());
								map.put(studentModel.getId(), studentModel);
								optiesPane.getTableModel()
										.addRow(new String[] { rs.getString("ID"), rs.getString("naam"),
												rs.getString("tussenvoegsel"), rs.getString("achternaam"),
												rs.getString("geslacht") });
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
										rs.getString("emailadres"), rs.getString("straat"),
										rs.getString("woonplaats"), rs.getString("landvherkomst"),
										rs.getString("universiteit"), rs.getString("huisnummer"),
										rs.getString("toevoeging"), rs.getString("postcode"));
								System.out.println(excStudentModel.getVoornaam() + excStudentModel.getTussenvoegsel()+ excStudentModel.getAchternaam()+excStudentModel.getGeslacht()+excStudentModel.getId());
//								 map.put(studentModel.getId(), studentModel);
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
								invoer.changeLayout();
								invoer.setBounds(40, 335, 890, 310);
								optiesPane.add(invoer);
								optiesPane.updateUI();

								optiesPane.getTable().addMouseListener(wijzigMouseListener);
								invoer.getBtnOk().addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent ae) {
										if (invoer.isFilled()) {
											db.executeInsertStatement("UPDATE HHS_student SET naam='"
													+ invoer.getTxtFieldVoornaam().getText() + "'," + "tussenvoegsel='"
													+ invoer.getTxtFieldTussenvoegsel().getText() + "',"
													+ "achternaam='" + invoer.getTxtFieldAchternaam().getText() + "',"
													+ "geslacht='" + invoer.getTxtFieldGeslacht().getText() + "',"
													+ "emailadres='" + invoer.getTxtFieldEmailadres().getText() + "',"
													+ "opleiding='" + invoer.getTxtFieldOpleiding().getText() + "',"
													+ "universiteit='" + invoer.getTxtFieldUniversiteit().getText()
													+ "'" + " WHERE id=" + invoer.getTxtFieldId().getText());
											optiesPane.getTxtFieldNaam().postActionEvent();
										}
									}
								});
							} else if (e.getItem().equals("Studie inschrijven")) {
								optiesPane.getTable().addMouseListener(studieInschrijvingMouseListener);
							} else if (e.getItem().equals("Stage inschrijven")) {
								optiesPane.getTable().addMouseListener(stageInschrijvingMouseListener);
							} else if (e.getItem().equals("Inschrijving wijzigen")) {
								optiesPane.getTable().addMouseListener(InschrijvingWijzigenMouseListener);
							} else if (e.getItem().equals("Locatie")) {
								optiesPane.getTable().addMouseListener(locatieMouseListener);
								optiesPane.getTxtFieldNaam().addActionListener(zoekExcListener);
							}
						} else {
							if (e.getItem().equals("Wijzigen")) {
								optiesPane.getTxtFieldNaam().removeActionListener(zoekListener);
								optiesPane.getTable().removeMouseListener(wijzigMouseListener);
								optiesPane.remove(invoer);
								optiesPane.updateUI();
							} else if (e.getItem().equals("Studie inschrijven")) {
								optiesPane.getTable().removeMouseListener(studieInschrijvingMouseListener);
							} else if (e.getItem().equals("Stage inschrijven")) {
								optiesPane.getTable().removeMouseListener(stageInschrijvingMouseListener);
							} else if (e.getItem().equals("Inschrijving wijzigen")) {
								optiesPane.getTable().removeMouseListener(InschrijvingWijzigenMouseListener);
							} else if (e.getItem().equals("Locatie")) {
								optiesPane.getTxtFieldNaam().removeActionListener(zoekExcListener);
								optiesPane.getTxtFieldNaam().addActionListener(zoekListener);
								optiesPane.getTable().removeMouseListener(locatieMouseListener);
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

				gegOpvragen.getBtnOverzicht1().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String naamOpleiding = JOptionPane.showInputDialog("Naam van opleiding");
						String inschrijfdatum = JOptionPane.showInputDialog("Jaar");
						ResultSet rsid = db
								.executeStatement("SELECT id FROM Opleiding WHERE naam = '" + naamOpleiding + "'");
						ResultSet rs;
						try {
							rsid.next();
							rs = db.executeStatement(
									"SELECT count(id) as aantal_Inschrijvingen FROM EXC_inschrijving_onderwijseenheid WHERE studie = "
											+ Integer.parseInt(rsid.getString("id")) + " AND inschrijfdatum like '%"
											+ inschrijfdatum + "%'");
							rsid.close();

							rs.next();
							System.out.println(rs.getString("aantal_Inschrijvingen"));
							rs.close();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							try {
								rsid.close();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							try {
								rsid.close();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
					}
				});

				gegOpvragen.getBtnOverzicht2().addActionListener(new ActionListener() {
					// Not complete
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String onderwijsType = JOptionPane.showInputDialog("Naam van Onderwijseenheid");
						String inschrijfdatum = JOptionPane.showInputDialog("Jaar");

						ResultSet rs = db.executeStatement(
								"SELECT COUNT(EXC_inschrijving_onderwijseenheid.studie) AS aantal, Onderwijseenheid.type,"
										+ " EXTRACT(YEAR FROM EXC_inschrijving_onderwijseenheid.inschrijfdatum) as jaar"
										+ " FROM EXC_inschrijving_onderwijseenheid"
										+ " JOIN Onderwijseenheid ON Onderwijseenheid.id = EXC_inschrijving_onderwijseenheid.id"
										+ " WHERE Onderwijseenheid.type = '" + onderwijsType + "'"
										+ " AND inschrijfdatum like '%" + inschrijfdatum + "%'"
										+ "	GROUP BY TYPE, inschrijfdatum");

						try {
							rs.next();
							System.out.println(rs.getString("aantal"));
							System.out.println(rs.getString("type"));
							System.out.println(rs.getString("jaar"));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

				gegOpvragen.getBtnOverzicht3().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ResultSet rs = db.executeStatement("SELECT land, count(*) as aantal FROM Stage"
								+ " GROUP BY land" + " ORDER BY aantal DESC" + " LIMIT 1");
						try {
							rs.next();
							System.out.println(rs.getString("land"));
							System.out.println(rs.getString("aantal"));
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

				gegOpvragen.getBtnOverzicht4().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ResultSet rs = db.executeStatement("SELECT landvherkomst, count(*) as aantal FROM EXC_student"
								+ " GROUP BY landvherkomst" + " ORDER BY aantal DESC" + " LIMIT 1");
						try {
							rs.next();
							System.out.println(rs.getString("landvherkomst"));
							System.out.println(rs.getString("aantal"));
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
