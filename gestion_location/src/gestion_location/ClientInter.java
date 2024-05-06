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

public class ClientInter extends JPanel implements ActionListener{
	
	
	private static final long serialVersionUID = 4525228430269455326L;
	
	
	
	
	
	JButton affiche, inserer,suppr,modéfier , annuler ;
    JLabel id, nom, prénom , LabelNORTH;
    JTextField nameField, idField, prénomField;
    
    
    
public ClientInter() {
    // Ajustez la taille pour remplir entièrement le conteneur textArea
    this.setPreferredSize(new Dimension(550, 400));
    this.setLayout(new BorderLayout());
    
    LabelNORTH = createHeaderFooterLabel(" Informations Client ");
    
    
   
    
    this.add(LabelNORTH ,BorderLayout.NORTH );
    
    
    JPanel centerPanel = new JPanel( new BorderLayout());
    
    
    
    // Panneau pour les champs de saisie
    JPanel Paneln = new JPanel(new GridLayout(3, 2, 20, 20));
    Paneln.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // Labels et champs de saisie
    id = createLabel("id : ");
    idField = createTextField();
    Paneln.add(id);
    Paneln.add(idField);

    nom = createLabel("nom : ");
    nameField = createTextField();
    Paneln.add(nom);
    Paneln.add(nameField);

    
    
    prénom = createLabel("Prénom : ");
    prénomField = createTextField();
    Paneln.add(prénom);
    Paneln.add(prénomField);

    
    centerPanel.add(Paneln  ,BorderLayout.NORTH);
    
    
    
    // Panneau pour les boutons d'envoi et d'annulation
   
    
    JPanel buttonPanel = new JPanel(new GridLayout(1, 5) );
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    

    affiche = createButton("affiche");
    affiche.addActionListener(this);
    inserer = createButton("inserer");
    inserer.addActionListener(this);
    suppr = createButton("suppr");
    suppr.addActionListener(this);
    modéfier = createButton("modéfier");
    modéfier.addActionListener(this);

    annuler= createButton("annuler");
    annuler.addActionListener(this);
    
    
    buttonPanel.add(affiche);
    
    buttonPanel.add(inserer);
    buttonPanel.add(suppr);
    buttonPanel.add(modéfier);
    buttonPanel.add(annuler);
    
    
    centerPanel.add(buttonPanel,BorderLayout.SOUTH);
    
    
    this.add(centerPanel , BorderLayout.CENTER);
    
    
    
    
}



// Crée un label d'en-tête ou de pied de page avec une apparence cohérente
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



// Crée un champ de saisie avec une apparence cohérente
private JTextField createTextField() {
    JTextField textField = new JTextField();
    return textField;
}



// Crée un bouton avec une apparence cohérente
private JButton createButton(String text) {
    JButton button = new JButton(text);
    button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    return button;
}



@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==annuler) {
		reset();	
	}
	else {
		gestion_agence_Location cas=new gestion_agence_Location ();
		
		if(e.getSource()==affiche) cas.afficheClient();
		else {
			Client c=new Client(Integer.parseInt(idField.getText()),nameField.getText(),prénomField.getText());
		
		if(e.getSource()==inserer) {
			
			try {
				cas.insererClient(c);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			reset();
		
		}
		
		
		
		if(e.getSource()==suppr) {
			
			try {
				cas.supprClient(c);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			reset();
		
		}
		
		if(e.getSource()==modéfier) {
			
			try {
				
				cas.modéfierClient(c);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			reset();
		
		}
		}
		
		
		
	}
	
	
	
}



public void reset() {
	nameField.setText("");
	idField.setText("");
	prénomField.setText("");
}


}
