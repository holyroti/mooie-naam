package Model;

public class ExcStudentModel {
	/*
	 * To change this license header, choose License Headers in Project
	 * Properties. To change this template file, choose Tools | Templates and
	 * open the template in the editor.
	 */

	/**
	 *
	 * @author mrctje
	 */
	private String id;
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private String geslacht;
	private String emailadres;
	private String straat;
	private String woonplaats;
	private String land;
	private String universiteit;
	private String huisnr;
	private String toevoeging;
	private String postcode;
	
	
	public ExcStudentModel(String id, String voornaam, String tussenvoegsel, String achternaam, String geslacht, String email, String straat, String woonplats, String land, String universitiet, String huisnr, String toevoeging, String postcode)  {
		 this.id = id;
		 this.voornaam = voornaam;
		 this.tussenvoegsel = tussenvoegsel;
		 this.achternaam = achternaam;
		 this.geslacht = geslacht;
		 this.emailadres = email;
		 this.straat = straat;
		 this.woonplaats = woonplats;
		 this.land = land;
		 this.universiteit = universitiet;
		 this.huisnr = huisnr;
		 this.toevoeging = toevoeging;
		 this.postcode = postcode;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getVoornaam() {
		return voornaam;
	}


	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}


	public String getTussenvoegsel() {
		return tussenvoegsel;
	}


	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}


	public String getAchternaam() {
		return achternaam;
	}


	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}


	public String getGeslacht() {
		return geslacht;
	}


	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}


	public String getEmailadres() {
		return emailadres;
	}


	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
	}


	public String getStraat() {
		return straat;
	}


	public void setStraat(String straat) {
		this.straat = straat;
	}


	public String getWoonplaats() {
		return woonplaats;
	}


	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}


	public String getLand() {
		return land;
	}


	public void setLand(String land) {
		this.land = land;
	}


	public String getUniversiteit() {
		return universiteit;
	}


	public void setUniversiteit(String universiteit) {
		this.universiteit = universiteit;
	}


	public String getHuisnr() {
		return huisnr;
	}


	public void setHuisnr(String huisnr) {
		this.huisnr = huisnr;
	}


	public String getToevoeging() {
		return toevoeging;
	}


	public void setToevoeging(String toevoeging) {
		this.toevoeging = toevoeging;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id;
	}
}
