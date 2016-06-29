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
import java.awt.Color;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

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

                    try {
                        db.executeInsertStatement("INSERT INTO " + student + " VALUES" + "(" + id + "," // id
                                + "'" + invoer.getTxtFieldVoornaam().getText() + "'" + "," // voornaam
                                + "'" + invoer.getTxtFieldTussenvoegsel().getText() + "'" + "," // tussenvoegsel
                                + "'" + invoer.getTxtFieldAchternaam().getText() + "'" + "," // achternaam
                                + "'" + invoer.getTxtFieldGeslacht().getSelectedItem() + "'" + "," // geslacht
                                + "'" + invoer.getTxtFieldEmailadres().getText() + "'" + "," // emailadres
                                + "'" + opleidingMap.get(invoer.getTxtFieldOpleiding().getSelectedItem()).getId() + "'"
                                + "," // opleiding
                                + "'" + "Haagse Hogeschool" + "'" // universiteit
                                + ")");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        if (ex.getMessage().contains("emailadres_UNIQUE")) {
                            invoer.getTxtFieldEmailadres().setBorder(new LineBorder(Color.RED, 2));
                        }
                    }

                    toevoegenTelHhs(invoer);
                    JOptionPane.showMessageDialog(null, "Student is aangemaakt");
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
                        && !invoer.getTxtFieldVoornaam().getText().isEmpty()
                        && !invoer.getTxtFieldAchternaam().getText().isEmpty()) {
                    try {
                        db.executeInsertStatement("INSERT INTO " + student + " VALUES " + "(" + id + "," // id
                                + " '" + invoer.getTxtFieldVoornaam().getText() + "'" + "," // voornaam
                                + " '" + invoer.getTxtFieldTussenvoegsel().getText() + "'" + "," // tussenvoegsel
                                + " '" + invoer.getTxtFieldAchternaam().getText() + "'" + "," // achternaam
                                + " '" + invoer.getTxtFieldGeslacht().getSelectedItem() + "'" + "," // geslacht
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
                    } catch (SQLException ex) {
                        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                        if (ex.getMessage().contains("emailadres")) {
                            invoer.getTxtFieldEmailadres().setBorder(new LineBorder(Color.RED, 2));
                        }
                    }
                    toevoegenTelExc(invoer);
                    JOptionPane.showMessageDialog(null, "Student gewijzigd");
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
        } else {
            tussenvoegsel = " tussenvoegsel ='" + invoer.getTxtFieldTussenvoegsel().getText() + "',";
        }

        try {
            db.executeInsertStatement("UPDATE " + student + " SET" + " voornaam='" + invoer.getTxtFieldVoornaam().getText()
                    + "'," + tussenvoegsel + " achternaam='" + invoer.getTxtFieldAchternaam().getText() + "',"
                    + " geslacht='" + invoer.getTxtFieldGeslacht().getSelectedItem() + "'," + " emailadres='"
                    + invoer.getTxtFieldEmailadres().getText() + "'," + " straat='" + invoer.getTxtFieldStraat().getText()
                    + "'," + " woonplaats='" + invoer.getTxtFieldWoonplaats().getText() + "'," + " landvherkomst='"
                    + invoer.getTxtFieldLandvanherkomst().getText() + "'," + " universiteit='"
                    + invoer.getTxtFieldUniversiteit().getText() + "'," + " toevoeging='"
                    + invoer.getTxtFieldToe().getText() + "'," + " postcode='" + invoer.getTxtFieldPost().getText() + "',"
                    + " opleiding=" + map.get(invoer.getTxtFieldOpleiding().getSelectedItem()).getId() + " WHERE id = "
                    + invoer.getTxtFieldId().getText());
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("emailadres")) {
                invoer.getTxtFieldEmailadres().setBorder(new LineBorder(Color.RED, 2));
            }
        }

        Main.mainWindow.getSplitPane().setRightComponent(Main.mainWindow.getRightPanel());
    }

    public void updateHhsStudent(BinnenlandInvoer invoer, HashMap<String, OpleidingModel> map) {
        String tussenvoegsel;
        if (invoer.getTxtFieldTussenvoegsel().getText() == null
                || invoer.getTxtFieldTussenvoegsel().getText().equals("")) {
            tussenvoegsel = " tussenvoegsel = null,";
        } else {
            tussenvoegsel = " tussenvoegsel ='" + invoer.getTxtFieldTussenvoegsel().getText() + "',";
        }

        try {
            db.executeInsertStatement("UPDATE " + student + " SET" + " naam='" + invoer.getTxtFieldVoornaam().getText()
                    + "'," + tussenvoegsel + " achternaam='" + invoer.getTxtFieldAchternaam().getText() + "',"
                    + " geslacht='" + invoer.getTxtFieldGeslacht().getSelectedItem() + "'," + " emailadres='"
                    + invoer.getTxtFieldEmailadres().getText() + "'," + " opleiding='"
                    + map.get(invoer.getTxtFieldOpleiding().getSelectedItem()).getId() + "'," + " universiteit='"
                    + "Haagse Hogeschool" + "'" + " WHERE id = " + invoer.getTxtFieldId().getText());
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("emailadres_UNIQUE")) {
                invoer.getTxtFieldEmailadres().setBorder(new LineBorder(Color.RED, 2));
            }
        }

        Main.mainWindow.getSplitPane().setRightComponent(Main.mainWindow.getRightPanel());
    }

    public void toevoegenTelHhs(BinnenlandInvoer invoer) {
        String tel = invoer.getTxtFieldTel().getText();

        String[] telnr = tel.split(",");

        try {
            db.executeInsertStatement("delete from HHS_student_tel where id ='" + invoer.getTxtFieldId().getText() + "'"); //delete all telephonenumbers from a hhs student
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < telnr.length; i++) {
            try {
                db.executeInsertStatement("insert into HHS_student_tel values('" + invoer.getTxtFieldId().getText() + "','" + telnr[i] + "')");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage().contains("telefoonnummer_UNIQUE"));
                if (ex.getMessage().contains("telefoonnummer_UNIQUE")) {
                    System.out.println("HEELLOOOOOO");
                    invoer.getTxtFieldTel().setBorder(new LineBorder(Color.RED, 2));
                }
            }
        }
    }

    public void toevoegenTelExc(ExchangeInvoer invoer) {
        String tel = invoer.getTxtFieldTel().getText();

        String[] telnr = tel.split(",");

        try {
            db.executeInsertStatement("delete from EXC_student_tel where id ='" + invoer.getTxtFieldId().getText() + "'"); //delete all telephonenumbers from a hhs student
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < telnr.length; i++) {
            try {
                db.executeInsertStatement("insert into EXC_student_tel values('" + invoer.getTxtFieldId().getText() + "','" + telnr[i] + "')");
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                if (ex.getMessage().contains("telefoonnummer")) {
                    System.out.println("HEELLOOOOOO");
                    invoer.getTxtFieldTel().setBorder(new LineBorder(Color.RED, 2));
                }
            }
        }
    }

    public void inschrijvenOnderwijseenheid(StudentenOpties optiesPane) {
        try {
            if (optiesPane.getTableModel()
                    .getValueAt(optiesPane.getTable().getSelectedRow(), 0).getClass().getName().equals(StudentModel.class.getName())) {
                StudentModel student = (StudentModel) optiesPane.getTableModel()
                        .getValueAt(optiesPane.getTable().getSelectedRow(), 0);
                ResultSet rs = db
                        .executeStatement("SELECT Onderwijseenheid.id, Onderwijseenheid.`type`, Onderwijseenheid.studiepunt, Onderwijseenheid.opleiding, Onderwijseenheid_periode.periode, Onderwijseenheid_periode.schooljaar\n"
                                + "FROM Onderwijseenheid\n"
                                + "JOIN Onderwijseenheid_periode ON Onderwijseenheid_periode.id = Onderwijseenheid.id\n"
                                + "WHERE opleiding = " + student.getOpleiding());
                rs.last();
                OnderwijseenheidModel[] comps = new OnderwijseenheidModel[rs.getRow()];
                rs.beforeFirst();
                while (rs.next()) {
                    comps[rs.getRow() - 1] = new OnderwijseenheidModel(Integer.parseInt(rs.getString("id")),
                            rs.getString("type"), Integer.parseInt(rs.getString("studiepunt")), rs.getString("periode"), rs.getString("schooljaar"));
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
            } else {
                ExcStudentModel student = (ExcStudentModel) optiesPane.getTableModel()
                        .getValueAt(optiesPane.getTable().getSelectedRow(), 0);
                ResultSet rs = db
                        .executeStatement("SELECT Onderwijseenheid.id, Onderwijseenheid.`type`, Onderwijseenheid.studiepunt, Onderwijseenheid.opleiding, Onderwijseenheid_periode.periode, Onderwijseenheid_periode.schooljaar\n"
                                + "FROM Onderwijseenheid\n"
                                + "JOIN Onderwijseenheid_periode ON Onderwijseenheid_periode.id = Onderwijseenheid.id\n"
                                + "WHERE opleiding = " + student.getOpleiding());
                rs.last();
                OnderwijseenheidModel[] comps = new OnderwijseenheidModel[rs.getRow()];
                rs.beforeFirst();
                while (rs.next()) {
                    comps[rs.getRow() - 1] = new OnderwijseenheidModel(Integer.parseInt(rs.getString("id")),
                            rs.getString("type"), Integer.parseInt(rs.getString("studiepunt")), rs.getString("periode"), rs.getString("schooljaar"));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inschrijvenStage(StudentenOpties optiesPane) {
        ResultSet rs = db.executeStatement("SELECT Stage.id, Stage.bedrijfsnaam, Stage.straat, Stage.stad, Stage.land, Stage.postcode, Stage.toevoeging, Stage.huisnummer, Stage_periode.periode, Stage_periode.schooljaar\n"
                + "FROM Stage\n"
                + "JOIN Stage_periode on Stage_periode.id = Stage.id");
        try {
            rs.last();
            StageModel[] comps = new StageModel[rs.getRow()];
            rs.beforeFirst();
            while (rs.next()) {
                comps[rs.getRow() - 1] = new StageModel(rs.getString("id"), rs.getString("bedrijfsnaam"),
                        rs.getString("straat"), rs.getString("stad"), rs.getString("land"), rs.getString("postcode"),
                        rs.getString("toevoeging"), rs.getString("huisnummer"), rs.getString("periode"), rs.getString("schooljaar"));
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

    public void locatieStudent(String land) {
        ResultSet rsStudent = db.executeStatement("select HHS_inschrijving_stage.id, HHS_student.id as studentid, naam, tussenvoegsel, achternaam, telefoonnummer from HHS_inschrijving_stage "
                + "join HHS_student on HHS_inschrijving_stage.id = HHS_student.id "
                + "join Stage on HHS_inschrijving_stage.stage = Stage.id "
                + "join HHS_student_tel on HHS_inschrijving_stage.id = HHS_student_tel.id "
                + "where land = '" + land + "'");
        HashSet<String> studentSet = new HashSet<>();
        try {
            StringBuilder sb = new StringBuilder();
            while (rsStudent.next()) {
                String id = rsStudent.getString("studentid");
                if (!studentSet.contains(id)) {
                    studentSet.add(id);
                    sb.append(rsStudent.getString("naam")).append(" ");
                    if (rsStudent.getString("tussenvoegsel") == null) {
                        sb.append("").append(" ");
                    } else {
                        sb.append(rsStudent.getString("tussenvoegsel")).append(" ");
                    }
                    sb.append(rsStudent.getString("achternaam")).append("\n");

                    ResultSet rsTel = db.executeStatement("select telefoonnummer from HHS_student_tel "
                            + "where id='" + rsStudent.getString("id") + "'");

                    while (rsTel.next()) {
                        sb.append(rsTel.getString("telefoonnummer")).append("\n");
                    }
                    sb.append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, new TextArea(sb.toString()));
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void overzichtInschrijvingen(StudentenOpties optiesPane) {
        String id = ((StudentModel) optiesPane.getTableModel().getValueAt(optiesPane.getTable().getSelectedRow(), 0))
                .getId();
        ResultSet rs = db.executeStatement(
                "SELECT HHS_student.id, Onderwijseenheid.type, Onderwijseenheid.studiepunt, Onderwijseenheid_periode.periode, Onderwijseenheid_periode.schooljaar\n"
                + "FROM HHS_inschrijving_onderwijseenheid\n"
                + "JOIN HHS_student ON HHS_student.id = HHS_inschrijving_onderwijseenheid.id\n"
                + "JOIN Opleiding ON Opleiding.id = HHS_inschrijving_onderwijseenheid.onderwijseenheid\n"
                + "JOIN Onderwijseenheid ON Onderwijseenheid.opleiding = Opleiding.id\n"
                + "LEFT JOIN Onderwijseenheid_periode ON Onderwijseenheid_periode.id = Onderwijseenheid.id\n"
                + "WHERE HHS_student.id = "
                + id);
        try {
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("Onderwijseenheid: " + rs.getString("type") + "\tAantal studiepunten: " + rs.getString("studiepunt")
                        + "\tPeriode: " + rs.getString("periode") + "\tSchooljaar: " + rs.getString("schooljaar") + "\n");
            }
            JOptionPane.showMessageDialog(null, new TextArea(sb.toString()), "Overzicht",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
