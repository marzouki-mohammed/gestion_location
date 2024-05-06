package gestion_location;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class gestion_agence_Location {
	
	private String user ="root";
	private String pass ="";
	private String url ="jdbc:mysql://localhost:3306/base_gestion_agence";
	private Connection myConnection; 
	
   public gestion_agence_Location (){

	   try {
		Class.forName("com.mysql.jdbc.Driver");
		myConnection=DriverManager.getConnection(url, user, pass);
		System.out.println("good ");
	} catch (ClassNotFoundException e) {
		System.out.println("erreur1");
	}
	catch (SQLException e) {
		System.out.println("erreur2");
	}
   }

   
   
   
   public void afficheVéhicules() {
	  
	   String requete="Select * from véhicules "  ;
	   Statement st ;
	   ResultSet r=null;
	   try {
		st =myConnection.createStatement();
		r=st.executeQuery(requete);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   
	   try {
		while(r.next()){
			   System.out.println(r.getInt(1) +", "+ r.getString(2) +", "+r.getString(3)+", "+r.getInt(4) );
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
  
   
   public void insererVéhicule (Véhicules v) throws Exception {
	    String requete = "INSERT INTO véhicules (id, marque, modéle, année) VALUES (?, ?, ?, ?)";
	    PreparedStatement pr = myConnection.prepareStatement(requete);
	    pr.setInt(1, v.getId());
	    pr.setString(2, v.getMarque());
	    pr.setString(3, v.getModéle()); // Utilisation correcte du nom de colonne modèle
	    pr.setInt(4, v.getAnnée());
	    pr.executeUpdate();
	    System.out.println("L'insertion est validée");
	}

   
   
   public void supprVéhicule (Véhicules v) throws Exception {
	   
	   String requete = "DELETE FROM véhicules WHERE id = ?";

	   PreparedStatement pr =myConnection.prepareStatement(requete);
	   pr.setInt(1,v.id);
	   pr.executeUpdate();
   }
   
   
   
   public void modéfierVéhicule(Véhicules v) throws Exception {
	    String requete = "UPDATE véhicules SET marque = ?, modéle = ?, année = ? WHERE id = ?";
	    PreparedStatement pr = myConnection.prepareStatement(requete);
	    pr.setString(1, v.getMarque());
	    pr.setString(2, v.getModéle());
	    pr.setInt(3, v.getAnnée());
	    pr.setInt(4, v.getId()); // Définir le quatrième paramètre
	    pr.executeUpdate();
	}

  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public void afficheClient() {
		  
	   String requete="Select * from client "  ;
	   Statement st ;
	   ResultSet r=null;
	   try {
		st =myConnection.createStatement();
		r=st.executeQuery(requete);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   
	   try {
		while(r.next()){
			   System.out.println(r.getInt(1) +", "+ r.getString(2) +", "+r.getString(3) );
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   public void insererClient (Client v) throws Exception {
	   
	   String requete="insert into  client values(?,?,?) "  ;
	   PreparedStatement pr =myConnection.prepareStatement(requete);
	   pr.setInt(1, v.getId());
	   pr.setString(2, v.getNom());
	   pr.setString(3, v.getPrénom());
	   pr.executeUpdate();
	   System.out.println("l'insertion est valide ");
   }
   
   
  
   public void supprClient (Client v) throws Exception {
	   
	   
	   String requete = "delete from client where id = ?";
	   
	  
	   PreparedStatement pr =myConnection.prepareStatement(requete);
	   pr.setInt(1,v.id);
	   pr.executeUpdate();
	   System.out.println("la supprestion  est valide ");
	   
   }
   
   
   public void modéfierClient (Client v ) throws Exception {
	   
	   String requete = "UPDATE client SET nom = ?, prénom = ? WHERE id = ?";

	   
	   PreparedStatement pr =myConnection.prepareStatement(requete);
	   pr.setString(1,v.getNom());
	   pr.setString(2,v.getPrénom());
	   pr.setInt(3,v.id);
	   pr.executeUpdate(); 
	   
	   
   }
   
   
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public void afficheLocation() {
		  
	   String requete="Select * from location "  ;
	   Statement st ;
	   ResultSet r=null;
	   try {
		st =myConnection.createStatement();
		r=st.executeQuery(requete);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   
	   try {
		while(r.next()){
			   System.out.println(r.getInt(1) +", "+ r.getInt(2) +", "+r.getInt(3) + ", "+r.getDate(4) +", "+ r.getDate(5) + ", "+r.getString(6)+", "+ r.getInt(7));
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   
   
  
   
   
   public void insererLocation(Location v) throws Exception {
	    String requete = "INSERT INTO location (id, idVéhicules, idClient, dateLocation) VALUES ( ?, ?, ?, ?)";
	    PreparedStatement pr = myConnection.prepareStatement(requete);
	    pr.setInt(1, v.getId());
	    pr.setInt(2, v.getIdVéhicules());
	    pr.setInt(3, v.getIdClient());
	    pr.setDate(4, v.getDateLocation());
	    pr.executeUpdate();
	}
   
   
  
  public void retoureVéhicules(int id , String état , int kilométrage ) throws Exception {
	   
	  // Obtenir la date actuelle
	    LocalDate currentDate = LocalDate.now();
	    // Convertir LocalDate en java.sql.Date
	    Date sqlDate = Date.valueOf(currentDate);

	    String requete = "UPDATE location SET dateReteur = ?, etatVéhiculeReteur = ?, kilometrageReteur = ? WHERE id = ?";
	    PreparedStatement pr = myConnection.prepareStatement(requete);
	    pr.setDate(1, sqlDate);
	    pr.setString(2, état);
	    pr.setInt(3, kilométrage);
	    pr.setInt(4, id);

	    pr.executeUpdate();
	}
  
  
  public void supprLocation(int id, int idVéhicule , int idClient) throws Exception {
	    String requete = "DELETE FROM location WHERE id = ? AND idVéhicules = ? AND idClient = ?";
	    PreparedStatement pr = myConnection.prepareStatement(requete);
	    pr.setInt(1, id);
	    pr.setInt(2, idVéhicule);
	    pr.setInt(3, idClient);

	    pr.executeUpdate();
	}

  

	

}
