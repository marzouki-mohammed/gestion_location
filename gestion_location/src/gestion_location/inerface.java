package gestion_location;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;



public class inerface  extends JFrame{
	 
    private static final long serialVersionUID = 4443303248990993973L;
   
    // --- Construction de l'interface graphique ---
    
    
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton checkBox1 = new JRadioButton("Client ");
    JRadioButton checkBox2 = new JRadioButton("Véhicules");
    JRadioButton checkBox3 = new JRadioButton("Location");
    JRadioButton checkBox4 = new JRadioButton("Routeur Location");
    JPanel textArea = new JPanel();
    
    public inerface() {
        super( "gestion_agence" );
        this.setSize(800,500);
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
        
        
        checkBox1.setSelected(true);
        buttonGroup.add(checkBox1);
        checkBox1.addItemListener(this::radioButtons_itemStateChanged);
        
        checkBox2.addItemListener(this::radioButtons_itemStateChanged);
        buttonGroup.add(checkBox2);
        checkBox3.addItemListener(this::radioButtons_itemStateChanged);
        buttonGroup.add(checkBox3);
        
        checkBox4.addItemListener(this::radioButtons_itemStateChanged);
        buttonGroup.add(checkBox4);
        
        // --- On récupère le contentPane ---
        JPanel contentPane = (JPanel) getContentPane();


        // --- L'explorateur de projet et ses scrollbars ---
        JPanel projectExplorerTree = new JPanel();
        projectExplorerTree.setLayout(new GridLayout(4, 1));
        projectExplorerTree.setBackground(Color.WHITE);
        
        projectExplorerTree.add(checkBox1);
        projectExplorerTree.add(checkBox2);
        projectExplorerTree.add(checkBox3);
        projectExplorerTree.add(checkBox4);
        
        JScrollPane projectScrollPane = new JScrollPane( projectExplorerTree );
        projectScrollPane.setPreferredSize( new Dimension( 200, 0 ) );
        
        
        
        // --- L'éditeur principal et ses scrollbars ---
        textArea.add(new ClientInter());
        JScrollPane editorScrollPane = new JScrollPane( textArea );
        editorScrollPane.setPreferredSize(new Dimension(0,400));
        
      
        
       
        
        
        // --- Et maintenant on assemble le tout avec de JSplitPane ---
      
    
        JSplitPane mainSplitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, projectScrollPane, editorScrollPane );
        contentPane.add( mainSplitPane /*, BorderLayout.CENTER */ ); 
        
        
        this.setVisible(true);
        
        

    }
    
    
    
    
    void radioButtons_itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == checkBox1) {
        	textArea.removeAll();
            textArea.add(new ClientInter());
            textArea.revalidate();
            textArea.repaint();
        }
        if (source == checkBox2) {
        	textArea.removeAll();
            textArea.add(new VéhiculesInter());
            textArea.revalidate();
            textArea.repaint();
        }
        if (source == checkBox3) {
        	textArea.removeAll();
            textArea.add(new LocationInter());
            textArea.revalidate();
            textArea.repaint();
        }
        
        if (source == checkBox4) {
        	textArea.removeAll();
            textArea.add(new routeurLocationInter());
            textArea.revalidate();
            textArea.repaint();
        }
        
    }

  
}
