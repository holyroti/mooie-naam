package Model;

public class OnderwijseenheidModel {
	private int id;
	private String type;
	private int punten;
	private String periode;
        private String schooljaar;
	public OnderwijseenheidModel(int id, String type, int punten, String periode, String schooljaar) {
		this.id = id;
		this.type = type;
		this.punten = punten;
                this.periode = periode;
                this.schooljaar = schooljaar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPunten() {
		return punten;
	}

	public void setPunten(int punten) {
		this.punten = punten;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return type + "(" + punten + ") " + "Periode: " + periode + " Schooljaar: " + schooljaar ;
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
