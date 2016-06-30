/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Arjun
 */
public class ContactModel {
    private String id;
    private String mail;
    private String tel;
    private String naam;
    private String geslacht;
    
    public ContactModel(String id, String mail, String tel, String naam, String geslacht) {
        this.id = id;
        this.mail = mail;
        this.tel = tel;
        this.naam = naam;
        this.geslacht = geslacht;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
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

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return the geslacht
     */
    public String getGeslacht() {
        return geslacht;
    }

    /**
     * @param geslacht the geslacht to set
     */
    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }
    
    
}
