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
		ResultSet rs = db.executeStatement("SELECT max(id) FROM Onderwijseenheid;");
		ResultSet rs2 = db.executeStatement("SELECT Opleiding.naam, Opleiding.id FROM Opleiding;");
		OpleidingModel[] opleidngen = null;
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
//		String naam = JOptionPane.showInputDialog("Geef naam");
		String type = (String) JOptionPane.showInputDialog(null, "Choose type", "Type",
				JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
		String punten = JOptionPane.showInputDialog("Geef aantal studiepunten");
		Object opleiding =  JOptionPane.showInputDialog(null, "Choose opleiding", "Opleiding",
				JOptionPane.QUESTION_MESSAGE, null, opleidngen, opleidngen[0]);
		
		db.executeInsertStatement("INSERT INTO Onderwijseenheid VALUES("+ (id+1) + ",'" + type + "','" + punten + "','" + ((OpleidingModel)opleiding).getId() + "')");
	}
}
