package Controller;

import Model.StudentModel;
import View.BinnenlandInvoer;
import View.StudentenOpties;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class Actions {

    public static int n;

    public void startListener(Database db) {
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
                invoer.getBtnOk().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(invoer.isFilled())
                         db.executeInsertStatement("UPDATE HHS_student SET naam='" + invoer.getTxtFieldVoornaam().getText()
                                 + "'," + "tussenvoegsel='" + invoer.getTxtFieldTussenvoegsel() .getText()
                                 + "'," + "achternaam='" + invoer.getTxtFieldAchternaam().getText()
                                 + "'," + "geslacht='" + invoer.getTxtFieldGeslacht().getText()
                                 + "'," + "emailadres='" + invoer.getTxtFieldEmailadres().getText()
                                 + "'," + "opleiding='" + invoer.getTxtFieldOpleiding().getText()
                                 + "'," + "universiteit='" + invoer.getTxtFieldUniversiteit().getText() + "'"
                                 + " WHERE id=" + invoer.getTxtFieldId().getText()
                                 );
                    }
                });
            }
        });

    }
}
