package gestion_location;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class routeurLocationInter extends JPanel implements ActionListener{
	
	
	 
	private static final long serialVersionUID = 1L;
	
	
	
		JButton routeur , annuler , afficher;
	    JLabel id, etatVéhiculeReteur , kilometrageReteur , LabelNORTH;
	    JTextField etatVéhiculeReteurField , kilometrageReteurField , idField;
	public routeurLocationInter() {
		 // Ajustez la taille pour remplir entièrement le conteneur textArea
	    this.setPreferredSize(new Dimension(550, 400));
	    this.setLayout(new BorderLayout());
	    
	    LabelNORTH = createHeaderFooterLabel("Informations de localisation du routeur ");

	    this.add(LabelNORTH ,BorderLayout.NORTH );
	    
	    
	    JPanel centerPanel = new JPanel( new BorderLayout());
	    // Panneau pour les champs de saisie
	    JPanel Paneln = new JPanel(new GridLayout(3, 2, 20, 20));
	    Paneln.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
	    
	    id = createLabel("id Location : ");
	    idField = new JTextField();
	    Paneln.add(id);
	    Paneln.add(idField);
	    
	    
	    kilometrageReteur = createLabel("kilometrageReteur : ");
	    kilometrageReteurField = new JTextField();
	    Paneln.add(kilometrageReteur);
	    Paneln.add(kilometrageReteurField);
	    
	
	    etatVéhiculeReteur = createLabel("etatVéhiculeReteur : ");
	    etatVéhiculeReteurField = new JTextField();
	    Paneln.add(etatVéhiculeReteur);
	    Paneln.add(etatVéhiculeReteurField);
	    
	    centerPanel.add(Paneln  ,BorderLayout.NORTH);
	    
	    
	    JPanel buttonPanel = new JPanel(new GridLayout(1,3));
	    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    

	    afficher = createButton("afficher");
	    afficher.addActionListener(this);
	    routeur = createButton("routeur");
	    routeur.addActionListener(this);
	    annuler = createButton("annuler");
	    annuler.addActionListener(this);
	    
	   
	    buttonPanel.add(afficher);
	    buttonPanel.add(routeur);
	    buttonPanel.add(annuler);
	    
	    
	    centerPanel.add(buttonPanel,BorderLayout.SOUTH);
	    
	    
	    this.add(centerPanel , BorderLayout.CENTER);
	    
	  
	
	}
	
	
	
	
	private JLabel createHeaderFooterLabel(String text) {
	    JLabel label = new JLabel(text);
	    label.setBackground(Color.darkGray);
	    label.setForeground(Color.white);
	    label.setFont(new Font("Arial", Font.BOLD, 30));
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setOpaque(true);
	    return label;
	}


	// Crée un label avec une apparence cohérente
	private JLabel createLabel(String text) {
	    JLabel label = new JLabel(text);
	    label.setFont(new Font("Arial", Font.BOLD, 20));
	    return label;
	}


	// Crée un bouton avec une apparence cohérente
	private JButton createButton(String text) {
	    JButton button = new JButton(text);
	    button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	    return button;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==annuler) reset();
		else {
			gestion_agence_Location cas =new gestion_agence_Location();
			if(e.getSource()==afficher) {
				cas.afficheLocation();	
			}
			else {
			 try {
				cas.retoureVéhicules(Integer.parseInt(idField.getText()), etatVéhiculeReteurField.getText(), Integer.parseInt(kilometrageReteurField.getText()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 reset();
		  }
		}
		
		
	}
	
	public void reset() {
		idField.setText("");
		etatVéhiculeReteurField.setText("") ;
		kilometrageReteurField.setText("");
	
		
	}

	

}
