package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.OpleidingModel;

public class Opleiding {

	Database db;
	int id;
	
	public Opleiding(Database db) {
		this.db = db;
	}
	
	public void zoekOpleiding() {
		ResultSet rsId = db.executeStatement("SELECT max(id) FROM Onderwijseenheid;");
		ResultSet rsOpleiding = db.executeStatement("SELECT Opleiding.naam, Opleiding.id FROM Opleiding;");
		ResultSet rsType = db.executeStatement("SELECT DISTINCT type FROM Onderwijseenheid;");
		
		OpleidingModel[] opleidngen = null;
		Object[] types = null;
		try {
			rsOpleiding.last();
			opleidngen = new OpleidingModel[rsOpleiding.getRow()];
			rsOpleiding.beforeFirst();
			while (rsOpleiding.next()) {
				opleidngen[rsOpleiding.getRow() - 1] = new OpleidingModel();
				opleidngen[rsOpleiding.getRow() - 1].setId(rsOpleiding.getString("id"));
				opleidngen[rsOpleiding.getRow() - 1].setNaam(rsOpleiding.getString("naam"));
			}
			rsId.next();
			id = Integer.parseInt(rsId.getString("max(id)"));
			
			rsType.last();
			types = new Object[rsType.getRow()];
			rsType.beforeFirst();
			while(rsType.next()){
				types[rsType.getRow() - 1] = rsType.getString("type");
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
//		String naam = JOptionPane.showInputDialog("Geef naam");
		String type = (String) JOptionPane.showInputDialog(null, "Choose type", "Type",
				JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
		String punten = JOptionPane.showInputDialog("Geef aantal studiepunten");
		Object opleiding =  JOptionPane.showInputDialog(null, "Choose opleiding", "Opleiding",
				JOptionPane.QUESTION_MESSAGE, null, opleidngen, opleidngen[0]);
		
		db.executeInsertStatement("INSERT INTO Onderwijseenheid VALUES("+ (id+1) + ",'" + type + "','" + punten + "','" + ((OpleidingModel)opleiding).getId() + "')");
	}
}
