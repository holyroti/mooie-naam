package Controller;

import Model.OpleidingModel;
import Model.StudentModel;
import View.BinnenlandInvoer;
import View.GegevensOpvragen;
import View.StudentenOpties;
import View.OpleidingZoeken;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class Actions {

    public static int n;

    public void startListener(Database db) {

        Main.mainWindow.getBtnOplSearch().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, OpleidingModel> opleidingMap = new HashMap<>();
                OpleidingZoeken opleidingZoeken = new OpleidingZoeken();
                Main.mainWindow.getSplitPane().setRightComponent(opleidingZoeken);
//				String s = JOptionPane.showInputDialog("Naam van opleiding");
//				ResultSet rs = db.executeStatement("SELECT Opleiding.naam as naamopleiding, Opleiding.type, Opleiding.id, Contactpersoon.* FROM Opleiding"
//						+ " JOIN Contactpersoon on Opleiding.contactpersoon = Contactpersoon.id"
//						+ " WHERE Opleiding.naam = " + "'" + s + "'");
                ResultSet rs = db.executeStatement("SELECT Opleiding.id, Opleiding.naam, Opleiding.type, Contactpersoon.naam AS Contactpersoon\n"
                        + "FROM Opleiding\n"
                        + "JOIN Contactpersoon ON Contactpersoon.id = Opleiding.contactpersoon;");
                ResultSet typeRs = db.executeStatement("SELECT DISTINCT Opleiding.type FROM Opleiding;");
                ResultSet naamRs = db.executeStatement("SELECT DISTINCT Contactpersoon.naam FROM Contactpersoon;");
                try {
                    while (rs.next()) {
                        OpleidingModel opleiding = new OpleidingModel(rs.getString("id"), rs.getString("naam"), rs.getString("type"), rs.getString("Contactpersoon"));
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
                                    opleidingZoeken.getTxtContact().setSelectedItem(selectedOpleiding.getContactpersoonNaam());
                                }
                            }
                        }
                    });
//                    opleidingZoeken.getTxtId().setText(rs.getString("id"));
//					opleidingZoeken.getTxtNaamOpleiding().setText(rs.getString("naamopleiding"));
//					opleidingZoeken.getTxtType().setText(rs.getString("type"));
//                    opleidingZoeken.getTxtContact().setText(rs.getString("Contactpersoon"));
//					System.out.println(rs.getString("naamopleiding"));
//					System.out.println(rs.getString("type"));
//					System.out.println(rs.getString("emailadres"));
//					System.out.println(rs.getString("telefoonnummer"));
//					System.out.println(rs.getString("naam"));
//					System.out.println(rs.getString("geslacht"));
                    rs.close();
                    typeRs.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                opleidingZoeken.getBtnOk().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!opleidingZoeken.getTxtNaamOpleiding().getSelectedItem().equals("Choose one"))  {
                            // TODO Auto-generated method stub
                            try {
                                ResultSet rsid = db.executeStatement("SELECT id FROM Contactpersoon WHERE naam = " + "'" + (String) opleidingZoeken.getTxtContact().getSelectedItem() + "'");

                                rsid.next();
                                System.out.println(rsid.getString("id"));
                                db.executeInsertStatement("UPDATE Opleiding SET "
                                        + "naam='" + (String) opleidingZoeken.getTxtNaamOpleiding().getSelectedItem() + "'" + ", "
                                        + "type='" + (String) opleidingZoeken.getTxtType().getSelectedItem() + "'" + ", "
                                        + "contactpersoon=" + Integer.parseInt(rsid.getString("id"))
                                        + " WHERE id=" + Integer.parseInt(opleidingZoeken.getTxtId().getText()));
                                rsid.close();
                            } catch (SQLException e2) {
                                System.out.println("Gelieve naam opnieuw na te kijken");
                                e2.printStackTrace();
                            }
                        }else{JOptionPane.showMessageDialog(null, "You havent chosen an opleiding", "Choose an opleiding", JOptionPane.WARNING_MESSAGE);}
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
                Object[] options = {"HHS Student", "Exchange Student"};
                n = JOptionPane.showOptionDialog(frame, "Wat voor student wilt u invoeren", "Student", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//				System.out.println(n);
                Student s = new Student(db, n);
            }
        });
        Main.mainWindow.getBtnStuSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StudentenOpties optiesPane = new StudentenOpties();
                Main.mainWindow.getSplitPane().setRightComponent(optiesPane);
                BinnenlandInvoer invoer = new BinnenlandInvoer();
                optiesPane.add(invoer);
                HashMap<String, StudentModel> map = new HashMap<>();
                optiesPane.getTxtFieldNaam().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ResultSet rs = db.executeStatement("SELECT * FROM HHS_student WHERE naam LIKE'%" + optiesPane.getTxtFieldNaam().getText() + "%'");
                        try {
                            optiesPane.getTableModel().setDataVector(null, new String[]{"Naam", "Tussenvoegsel", "Achternaam", "Geslacht"});
                            while (rs.next()) {

                                StudentModel studentModel = new StudentModel(rs.getString("id"), rs.getString("naam"), rs.getString("tussenvoegsel"), rs.getString("achternaam"), rs.getString("geslacht"), rs.getString("emailadres"), rs.getString("opleiding"), rs.getString("universiteit"));
                                map.put(studentModel.getVoornaam(), studentModel);
                                optiesPane.getTableModel().addRow(new String[]{rs.getString("naam"), rs.getString("tussenvoegsel"), rs.getString("achternaam"), rs.getString("geslacht")});
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                optiesPane.getTable().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        if (me.getClickCount() == 2) {
                            StudentModel studentModel = map.get(optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0));
                            optiesPane.getInvoer().getTxtFieldAchternaam().setText(studentModel.getAchternaam());
                            optiesPane.getInvoer().getTxtFieldEmailadres().setText(studentModel.getEmailadres());
                            optiesPane.getInvoer().getTxtFieldGeslacht().setText(studentModel.getGeslacht());
                            optiesPane.getInvoer().getTxtFieldOpleiding().setText(studentModel.getOpleiding());
                            optiesPane.getInvoer().getTxtFieldTussenvoegsel().setText(studentModel.getTussenvoegsel());
                            optiesPane.getInvoer().getTxtFieldUniversiteit().setText(studentModel.getUniversiteit());
                            optiesPane.getInvoer().getTxtFieldVoornaam().setText(studentModel.getVoornaam());
                            optiesPane.getInvoer().getTxtFieldId().setText(studentModel.getId());
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                        //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                        //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent me) {

                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        //To change body of generated methods, choose Tools | Templates.
                    }
                });
                optiesPane.getInvoer().getBtnOk().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (optiesPane.getInvoer().isFilled()) {
                            db.executeInsertStatement("UPDATE HHS_student SET naam='" + optiesPane.getInvoer().getTxtFieldVoornaam().getText()
                                    + "'," + "tussenvoegsel='" + optiesPane.getInvoer().getTxtFieldTussenvoegsel().getText()
                                    + "'," + "achternaam='" + optiesPane.getInvoer().getTxtFieldAchternaam().getText()
                                    + "'," + "geslacht='" + optiesPane.getInvoer().getTxtFieldGeslacht().getText()
                                    + "'," + "emailadres='" + optiesPane.getInvoer().getTxtFieldEmailadres().getText()
                                    + "'," + "opleiding='" + optiesPane.getInvoer().getTxtFieldOpleiding().getText()
                                    + "'," + "universiteit='" + optiesPane.getInvoer().getTxtFieldUniversiteit().getText() + "'"
                                    + " WHERE id=" + optiesPane.getInvoer().getTxtFieldId().getText()
                            );
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
            }

        });

    }
}
