package gestion_location;

public class Véhicules {
	int id ;
	String marque ;
	String modéle;
	int année;
	public Véhicules () {
		
	}
	public Véhicules(int id, String marque, String modéle, int année) {
		super();
		this.id = id;
		this.marque = marque;
		this.modéle = modéle;
		this.année = année;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	public String getModéle() {
		return modéle;
	}
	public void setModéle(String modéle) {
		this.modéle = modéle;
	}
	
	
	public int getAnnée() {
		return année;
	}
	public void setAnnée(int année) {
		this.année = année;
	}
	@Override
	public String toString() {
		return "Véhicules [id=" + id + ", marque=" + marque + ", modéle=" + modéle + ", année=" + année + "]";
	}
	
	

}
