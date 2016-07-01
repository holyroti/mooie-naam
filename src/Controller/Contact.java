/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.ContactModel;
/**
 *
 * @author Arjun
 */
public class Contact {
    
    public void maakContact(ContactModel model, Database db) {
        try {
            db.executeInsertStatement("INSERT INTO Contactpersoon VALUES (" +
                    model.getId() + "," +
                    "'" + model.getMail() + "'" + "," +
                    "'" + model.getTel() + "'" + "," +
                    "'" + model.getNaam() + "'" + "," +
                    "'" + model.getGeslacht() + "')");
            db.executeInsertStatement("UPDATE Opleiding SET contactpersoon ='" + model.getId() + "'" + " WHERE naam='" + model.getStudie() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void wijzigContact(ContactModel model, Database db, String id) {
        try {
            db.executeInsertStatement("DELETE FROM Contactpersoon WHERE id='" + model.getId() + "'");
            maakContact(model, db);
        } catch (SQLException ex) {
            Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
