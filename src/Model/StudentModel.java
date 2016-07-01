/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mrctje
 */
public class StudentModel {
    private String id;
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private String geslacht;
    private String emailadres;
    private String opleiding;
    private String universiteit;
    private String tel;

    public StudentModel(String id, String voornaam, String tussenvoegsel, String achternaam, String geslacht, String emailadres, String opleiding, String universiteit) {
        this.id = id;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.emailadres = emailadres;
        this.opleiding = opleiding;
        this.universiteit = universiteit;
        tel = new String();
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * @param tussenvoegsel the tussenvoegsel to set
     */
    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * @param geslacht the geslacht to set
     */
    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    /**
     * @param emailadres the emailadres to set
     */
    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    /**
     * @param opleiding the opleiding to set
     */
    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    /**
     * @param universiteit the universiteit to set
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
     * @return the opleiding
     */
    public String getOpleiding() {
        return opleiding;
    }

    /**
     * @return the universiteit
     */
    public String getUniversiteit() {
        return universiteit;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return id;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
}
