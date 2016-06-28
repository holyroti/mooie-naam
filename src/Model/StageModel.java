package Model;

public class StageModel {

    private String id;
    private String bedrijfsnaam;
    private String straat;
    private String stad;
    private String land;
    private String postcode;
    private String toevoeging;
    private String huisnummer;
    private String periode;
    private String schooljaar;

    public StageModel(String id, String bedrijfsnaam, String straat, String stad, String land, String postcode, String toevoeging, String huisnummer, String periode, String schooljaar) {
        this.id = id;
        this.bedrijfsnaam = bedrijfsnaam;
        this.straat = straat;
        this.stad = stad;
        this.land = land;
        this.postcode = postcode;
        this.toevoeging = toevoeging;
        this.huisnummer = huisnummer;
        this.periode = periode;
        this.schooljaar = schooljaar;
    }

    public StageModel(String id, String bedrijfsnaam, String straat, String stad, String land, String postcode,
            String toevoeging, String huisnummer) {
        super();
        this.id = id;
        this.bedrijfsnaam = bedrijfsnaam;
        this.straat = straat;
        this.stad = stad;
        this.land = land;
        this.postcode = postcode;
        this.toevoeging = toevoeging;
        this.huisnummer = huisnummer;
    }

    public StageModel(String id, String bedrijfsnaam, String straat, String stad, String land, String postcode,
            String huisnummer) {
        super();
        this.id = id;
        this.bedrijfsnaam = bedrijfsnaam;
        this.straat = straat;
        this.stad = stad;
        this.land = land;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return bedrijfsnaam + " Periode: " + getPeriode() + " Schooljaar: " + getSchooljaar();
    }

    /**
     * @return the periode
     */
    public String getPeriode() {
        return periode;
    }

    /**
     * @param periode the periode to set
     */
    public void setPeriode(String periode) {
        this.periode = periode;
    }

    /**
     * @return the schooljaar
     */
    public String getSchooljaar() {
        return schooljaar;
    }

    /**
     * @param schooljaar the schooljaar to set
     */
    public void setSchooljaar(String schooljaar) {
        this.schooljaar = schooljaar;
    }
}
