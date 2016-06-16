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

	public static int n;

	public void startListener(Database db) {

		Main.mainWindow.getBtnOplSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// HashMap<String, OpleidingModel> opleidingMap = new
				// HashMap<>();
				// OpleidingZoeken opleidingZoeken = new OpleidingZoeken();
				// Main.mainWindow.getSplitPane().setRightComponent(opleidingZoeken);
				// ResultSet rs = db.executeStatement(
				// "SELECT Opleiding.id, Opleiding.naam, Opleiding.type,
				// Contactpersoon.naam AS Contactpersoon\n"
				// + "FROM Opleiding\n"
				// + "JOIN Contactpersoon ON Contactpersoon.id =
				// Opleiding.contactpersoon;");
				// ResultSet typeRs = db.executeStatement("SELECT DISTINCT
				// Opleiding.type FROM Opleiding;");
				// ResultSet naamRs = db.executeStatement("SELECT DISTINCT
				// Contactpersoon.naam FROM Contactpersoon;");
				// try {
				// while (rs.next()) {
				// OpleidingModel opleiding = new
				// OpleidingModel(rs.getString("id"), rs.getString("naam"),
				// rs.getString("type"), rs.getString("Contactpersoon"));
				// opleidingMap.put(opleiding.getNaam(), opleiding);
				// opleidingZoeken.getTxtNaamOpleiding().addItem(rs.getString("naam"));
				// }
				// while (typeRs.next()) {
				// opleidingZoeken.getTxtType().addItem(typeRs.getString("type"));
				// }
				// while (naamRs.next()) {
				// opleidingZoeken.getTxtContact().addItem(naamRs.getString("naam"));
				// }
				//
				// opleidingZoeken.getTxtNaamOpleiding().addItemListener(new
				// ItemListener() {
				// @Override
				// public void itemStateChanged(ItemEvent ie) {
				// if (ItemEvent.SELECTED == ie.getStateChange()) {
				// if (!ie.getItem().equals("Choose one")) {
				// OpleidingModel selectedOpleiding = opleidingMap.get((String)
				// ie.getItem());
				// opleidingZoeken.getTxtId().setText(selectedOpleiding.getId());
				// opleidingZoeken.getTxtType().setSelectedItem(selectedOpleiding.getType());
				// opleidingZoeken.getTxtContact()
				// .setSelectedItem(selectedOpleiding.getContactpersoonNaam());
				// }
				// }
				// }
				// });
				// rs.close();
				// typeRs.close();
				// } catch (SQLException e1) {
				// e1.printStackTrace();
				// }
				ResultSet rs = db.executeStatement("SELECT max(id) FROM Onderwijseenheid;");
				ResultSet rs2 = db.executeStatement("SELECT Opleiding.naam, Opleiding.id FROM Opleiding;");
				OpleidingModel[] opleidngen = null;
				int id = 0;
				try {
					rs2.last();

					opleidngen = new OpleidingModel[rs2.getRow()];
					rs2.beforeFirst();
					while (rs2.next()) {
						opleidngen[rs2.getRow() - 1] = new OpleidingModel();
						opleidngen[rs2.getRow() - 1].setId(rs2.getString("id"));
						opleidngen[rs2.getRow() - 1].setNaam(rs2.getString("naam"));
					}
					rs.next();
					id = Integer.parseInt(rs.getString("max(id)"));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Object[] types = { "MINOR", "MAJOR" };
				String naam = JOptionPane.showInputDialog("Geef naam");
				String type = (String) JOptionPane.showInputDialog(null, "Choose type", "Type",
						JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
				String punten = JOptionPane.showInputDialog("Geef aantal studiepunten");
				Object opleiding =  JOptionPane.showInputDialog(null, "Choose opleiding", "Opleiding",
						JOptionPane.QUESTION_MESSAGE, null, opleidngen, opleidngen[0]);
				
				
				db.executeInsertStatement("INSERT INTO Onderwijseenheid VALUES("+ (id+1) + ",'" + type + "','" + punten + "','" + ((OpleidingModel)opleiding).getId() + "')");
				// opleidingZoeken.getBtnOk().addActionListener(new
				// ActionListener() {
				//
				// @Override
				// public void actionPerformed(ActionEvent e) {
				// if
				// (!opleidingZoeken.getTxtNaamOpleiding().getSelectedItem().equals("Choose
				// one")) {
				// // TODO Auto-generated method stub
				// try {
				// ResultSet rsid = db.executeStatement("SELECT id FROM
				// Contactpersoon WHERE naam = " + "'"
				// + (String) opleidingZoeken.getTxtContact().getSelectedItem()
				// + "'");
				//
				// rsid.next();
				// System.out.println(rsid.getString("id"));
				// db.executeInsertStatement("UPDATE Opleiding SET " + "naam='"
				// + (String)
				// opleidingZoeken.getTxtNaamOpleiding().getSelectedItem() + "'"
				// + ", "
				// + "type='" + (String)
				// opleidingZoeken.getTxtType().getSelectedItem() + "'"
				// + ", " + "contactpersoon=" +
				// Integer.parseInt(rsid.getString("id"))
				// + " WHERE id=" +
				// Integer.parseInt(opleidingZoeken.getTxtId().getText()));
				// rsid.close();
				// } catch (SQLException e2) {
				// System.out.println("Gelieve naam opnieuw na te kijken");
				// e2.printStackTrace();
				// }
				// } else {
				// JOptionPane.showMessageDialog(null, "You havent chosen an
				// opleiding", "Choose an opleiding",
				// JOptionPane.WARNING_MESSAGE);
				// }
				// }
				// });
				//
				// opleidingZoeken.getBtnCancel().addActionListener(new
				// ActionListener() {
				//
				// @Override
				// public void actionPerformed(ActionEvent e) {
				// // TODO Auto-generated method stub
				//
				// }
				// });
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
								invoer.getTxtFieldOpleiding().setText(studentModel.getOpleiding());
								invoer.getTxtFieldTel().setText("placeholder");
								invoer.getTxtFieldUniversiteit().setText(studentModel.getUniversiteit());
								Main.mainWindow.getSplitPane().setRightComponent(invoer);

								invoer.getBtnOk().addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										Student s = new Student(db, 0);
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
								invoer.getTxtFieldUniversiteit().setText(excModel.getUniversiteit());
								invoer.getTxtFieldPost().setText(excModel.getPostcode());
								invoer.getTxtFieldTel().setText("placeholder");
								invoer.getTxtFieldToe().setText(excModel.getToevoeging());
								Main.mainWindow.getSplitPane().setRightComponent(invoer);

								invoer.getBtnOk().addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										Student s = new Student(db, 1);
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
								if (optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0)
										.getClass().getName().equals(StudentModel.class.getName().toString())) {
									db.executeInsertStatement("insert into HHS_inschrijving_onderwijseenheid VALUES ("
											+ optiesPane.getTableModel()
													.getValueAt(optiesPane.getTable().getSelectedRow(), 0)
											+ "," + ((OpleidingModel) selectedStudie).getId() + ",'"
											+ new Date(System.currentTimeMillis()).toString() + "')");
								} else {
									db.executeInsertStatement("insert into EXC_inschrijving_onderwijseenheid VALUES ("
											+ optiesPane.getTableModel()
													.getValueAt(optiesPane.getTable().getSelectedRow(), 0)
											+ "," + ((OpleidingModel) selectedStudie).getId() + ",'"
											+ new Date(System.currentTimeMillis()).toString() + "')");
								}
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
								if (optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0)
										.getClass().getName().equals(StudentModel.class.getName().toString())) {
									db.executeInsertStatement("insert into HHS_inschrijving_stage VALUES ("
											+ optiesPane.getTableModel()
													.getValueAt(optiesPane.getTable().getSelectedRow(), 0)
											+ "," + ((StageModel) selectedStudie).getId() + ",'"
											+ new Date(System.currentTimeMillis()).toString() + "')");
								} else {
									db.executeInsertStatement("insert into EXC_inschrijving_stage VALUES ("
											+ optiesPane.getTableModel()
													.getValueAt(optiesPane.getTable().getSelectedRow(), 0)
											+ "," + ((StageModel) selectedStudie).getId() + ",'"
											+ new Date(System.currentTimeMillis()).toString() + "')");
								}
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

				MouseListener locatieMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							// Date date = new Date(System.currentTimeMillis());
							// System.out.println(date);
							ResultSet rs = db.executeStatement("select * from EXC_student");
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
								ExcStudentModel excStudent = comps[Integer.parseInt((String) optiesPane.getTableModel()
										.getValueAt(optiesPane.getTable().getSelectedRow(), 0)) - 1];
								JOptionPane.showMessageDialog(null,
										"Locatie student: " + excStudent.getStraat() + " " + excStudent.getHuisnr()
												+ " " + excStudent.getWoonplaats(),
										"Locatie", JOptionPane.INFORMATION_MESSAGE);
								;
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

				MouseListener onderWijsOverzichtMouseListener = new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent me) {
						if (me.getClickCount() == 2) {
							// Date date = new Date(System.currentTimeMillis());
							// System.out.println(date);
							String id = ((StudentModel) optiesPane.getTableModel()
									.getValueAt(optiesPane.getTable().getSelectedRow(), 0)).getId();
							ResultSet rs = db.executeStatement(
									"SELECT HHS_student.id, Opleiding.naam, Onderwijseenheid.studiepunt FROM HHS_inschrijving_onderwijseenheid    JOIN HHS_student ON HHS_student.id = HHS_inschrijving_onderwijseenheid.id  JOIN Opleiding ON Opleiding.id = HHS_inschrijving_onderwijseenheid.onderwijseenheid    JOIN Onderwijseenheid ON Onderwijseenheid.opleiding = Opleiding.id WHERE  HHS_student.id ="
											+ id + ";");
							try {
								StringBuilder sb = new StringBuilder();
								while (rs.next()) {
									sb.append("Opleiding: " + rs.getString("naam") + "\tAantal studiepunten: "
											+ rs.getString("studiepunt") + "\n");
								}
								JOptionPane.showMessageDialog(null, new TextArea(sb.toString()), "Overzicht",
										JOptionPane.INFORMATION_MESSAGE);
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
										rsex.getString("toevoeging"), rsex.getString("postcode"));
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
										rs.getString("postcode"));
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
								optiesPane.getTxtFieldNaam().addActionListener(zoekListener);
								optiesPane.getTable().addMouseListener(studieInschrijvingMouseListener);
							} else if (e.getItem().equals("Stage inschrijven")) {
								optiesPane.getTxtFieldNaam().addActionListener(zoekListener);
								optiesPane.getTable().addMouseListener(stageInschrijvingMouseListener);
							} else if (e.getItem().equals("Locatie Exchange Student")) {
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
							} else if (e.getItem().equals("Locatie Exchange Student")) {
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
