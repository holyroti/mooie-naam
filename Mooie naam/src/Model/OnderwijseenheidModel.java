package Model;

public class OnderwijseenheidModel {
	private int id;
	private String type;
	private int punten;
	
	public OnderwijseenheidModel(int id, String type, int punten) {
		this.id = id;
		this.type = type;
		this.punten = punten;
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
		return type + "(" + punten + ")";
	}
}
