package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.MainWindow;
import View.StudentInvoer;

public class InvoerStudent {

    StudentInvoer invoer = new StudentInvoer();

    public InvoerStudent(MainWindow window, Database db) {
        window.getBtnHhsStuIn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                StudentInvoer invoer = new StudentInvoer();
                window.getSplitPane().setRightComponent(invoer);
                invoer.getBtnOk().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.out.println("Heeeeeeeeeeee");
                        if(!invoer.getTxtFieldEmailadres().getText().isEmpty() && !invoer.getTxtFieldGeslacht().getText().isEmpty() && !invoer.getTxtFieldId().getText().isEmpty() && !invoer.getTxtFieldNaam().getText().isEmpty() && !invoer.getTxtFieldOpleiding().getText().isEmpty()){
                        db.executeInsertStatement("INSERT INTO HHS_student VALUES" + "(" + Integer.parseInt(invoer.getTxtFieldId().getText()) + ","
                                + "'" + invoer.getTxtFieldNaam().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldGeslacht().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldEmailadres().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldOpleiding().getText() + "'" + ","
                                + "'" + invoer.getTxtFieldOpleiding().getText() + "'"
                                + ")");
                        }
                    }
                });
            }
        });

    }
}
