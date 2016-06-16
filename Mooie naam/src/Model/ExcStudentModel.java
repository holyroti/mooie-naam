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
	private String universiteit;
	private String straat;
	private String woonplaats;
	private String landvherkomst;
	private String huisnummer;
	private String toevoeging;
	private String postcode;
	
	
	public ExcStudentModel(String id, String voornaam, String tussenvoegsel, String achternaam, String geslacht,
			String emailadres, String universiteit, String straat, String woonplaats, String landvherkomst,
			String huisnummer, String toevoeging, String postcode) {
		this.id = id;
		this.voornaam = voornaam;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geslacht = geslacht;
		this.emailadres = emailadres;
		this.universiteit = universiteit;
		this.straat = straat;
		this.woonplaats = woonplaats;
		this.landvherkomst = landvherkomst;
		this.huisnummer = huisnummer;
		this.toevoeging = toevoeging;
		this.postcode = postcode;
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

	public String getLandvherkomst() {
		return landvherkomst;
	}

	public void setLandvherkomst(String landvherkomst) {
		this.landvherkomst = landvherkomst;
	}

	public String getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
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

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param voornaam
	 *            the voornaam to set
	 */
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	/**
	 * @param tussenvoegsel
	 *            the tussenvoegsel to set
	 */
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	/**
	 * @param achternaam
	 *            the achternaam to set
	 */
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	/**
	 * @param geslacht
	 *            the geslacht to set
	 */
	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	/**
	 * @param emailadres
	 *            the emailadres to set
	 */
	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
	}

	/**
	 * @param universiteit
	 *            the universiteit to set
	 */
	public void setUniversiteit(String universiteit) {
		this.universiteit = universiteit;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the voornaam
	 */
	public String getVoornaam() {
		return voornaam;
	}

	/**
	 * @return the tussenvoegsel
	 */
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	/**
	 * @return the achternaam
	 */
	public String getAchternaam() {
		return achternaam;
	}

	/**
	 * @return the geslacht
	 */
	public String getGeslacht() {
		return geslacht;
	}

	/**
	 * @return the emailadres
	 */
	public String getEmailadres() {
		return emailadres;
	}

	/**
	 * @return the universiteit
	 */
	public String getUniversiteit() {
		return universiteit;
	}

}
