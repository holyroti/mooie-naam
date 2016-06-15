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
public class OpleidingModel {
    private String id;
    private String naam;
    private String type;
    private String contactpersoonNaam;

    public OpleidingModel(String id, String naam, String type, String contactpersoonNaam) {
        this.id = id;
        this.naam = naam;
        this.type = type;
        this.contactpersoonNaam = contactpersoonNaam;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the contactpersoonNaam
     */
    public String getContactpersoonNaam() {
        return contactpersoonNaam;
    }

    /**
     * @param contactpersoonNaam the contactpersoonNaam to set
     */
    public void setContactpersoonNaam(String contactpersoonNaam) {
        this.contactpersoonNaam = contactpersoonNaam;
    }
    
}
