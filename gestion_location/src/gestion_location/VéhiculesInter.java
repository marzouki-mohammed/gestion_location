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


public class VéhiculesInter extends JPanel implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	
	
	
	JButton affiche, inserer,suppr,modéfier , annuler ;
    JLabel id, marque, modéle ,année , LabelNORTH;
    JTextField modéleField, idField, marqueField ,annéeField ;
public VéhiculesInter() {
    // Ajustez la taille pour remplir entièrement le conteneur textArea
    this.setPreferredSize(new Dimension(550, 400));
    this.setLayout(new BorderLayout());
    
    LabelNORTH = createHeaderFooterLabel("Informations sur le véhicule ");
    
    
   
    
    this.add(LabelNORTH ,BorderLayout.NORTH );
    
    
    JPanel centerPanel = new JPanel( new BorderLayout());
    // Panneau pour les champs de saisie
    JPanel Paneln = new JPanel(new GridLayout(4, 2, 20, 20));
    Paneln.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // Labels et champs de saisie
    id = createLabel("id : ");
    idField = createTextField();
    Paneln.add(id);
    Paneln.add(idField);

    marque = createLabel("marque : ");
    marqueField = createTextField();
    Paneln.add(marque);
    Paneln.add(marqueField);

    
    
    modéle = createLabel("modéle : ");
    modéleField = createTextField();
    Paneln.add(modéle);
    Paneln.add(modéleField);
    
    
    
    année = createLabel("année : ");
    annéeField = createTextField();
    Paneln.add(année);
    Paneln.add(annéeField);
    

    
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
		
		if(e.getSource()==affiche) cas.afficheVéhicules();
		else {
			Véhicules v=new  Véhicules(Integer.parseInt(idField.getText()), marqueField.getText(), modéleField.getText(),Integer.parseInt(annéeField.getText()));
		
		if(e.getSource()==inserer) {
			
			try {
				cas.insererVéhicule(v);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			reset();
		
		}
		
		
		
		if(e.getSource()==suppr) {
			
			try {
				cas.supprVéhicule(v);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			reset();
		
		}
		
		if(e.getSource()==modéfier) {
			
			try {
				
				cas.modéfierVéhicule(v);
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
	idField.setText("");
	modéleField.setText("");
	marqueField.setText("");
	annéeField.setText("");
	
}



}
