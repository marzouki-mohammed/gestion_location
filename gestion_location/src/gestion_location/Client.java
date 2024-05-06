package gestion_location;

public final class Client {
	int id ;
	String nom ;
	String prénom ;
	
	public Client () {
		
	}
	public Client(int id, String nom, String prénom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prénom = prénom;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrénom() {
		return prénom;
	}
	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prénom=" + prénom +"]";
	}
	
	
	

}
