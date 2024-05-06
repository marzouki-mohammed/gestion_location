package gestion_location;

import java.sql.Date;

public class Location {
       int id ;
       int idVéhicules ;
       int idClient;
       Date dateLocation;
       Date dateReteur;
       String etatVéhiculeReteur;
       int kilometrageReteur;
       public Location () {
    	   
       }
	public Location(int id, int idVéhicules, int idClient, Date dateLocation, Date dateReteur,
			String etatVéhiculeReteur, int kilometrageReteur) {
		super();
		this.id = id;
		this.idVéhicules = idVéhicules;
		this.idClient = idClient;
		this.dateLocation = dateLocation;
		this.dateReteur = dateReteur;
		this.etatVéhiculeReteur = etatVéhiculeReteur;
		this.kilometrageReteur = kilometrageReteur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdVéhicules() {
		return idVéhicules;
	}
	public void setIdVéhicules(int idVéhicules) {
		this.idVéhicules = idVéhicules;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public Date getDateLocation() {
		return dateLocation;
	}
	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}
	public Date getDateReteur() {
		return dateReteur;
	}
	public void setDateReteur(Date dateReteur) {
		this.dateReteur = dateReteur;
	}
	public String getEtatVéhiculeReteur() {
		return etatVéhiculeReteur;
	}
	public void setEtatVéhiculeReteur(String etatVéhiculeReteur) {
		this.etatVéhiculeReteur = etatVéhiculeReteur;
	}
	public int getKilometrageReteur() {
		return kilometrageReteur;
	}
	public void setKilometrageReteur(int kilometrageReteur) {
		this.kilometrageReteur = kilometrageReteur;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", idVéhicules=" + idVéhicules + ", idClient=" + idClient + ", dateLocation="
				+ dateLocation + ", dateReteur=" + dateReteur + ", etatVéhiculeReteur=" + etatVéhiculeReteur
				+ ", kilometrageReteur=" + kilometrageReteur + "]";
	}
       
       
}
