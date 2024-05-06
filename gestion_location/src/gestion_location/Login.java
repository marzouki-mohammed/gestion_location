package gestion_location;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Login extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HashMap<String, String> credentialsMap = new HashMap<>(); // Map pour stocker les informations d'identification

    JTextField usernameField = new JTextField(); // Champ de texte pour le nom d'utilisateur
    JPasswordField passwordField = new JPasswordField(); // Champ de texte pour le mot de passe
    JButton loginButton = new JButton("Login"); // Bouton de connexion
    JLabel resultLabel; // Étiquette pour afficher le résultat de la connexion

    public Login() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 530);
        setLocationRelativeTo(null);

        // Initialisation des informations d'identification dans la map
        credentialsMap.put("Marzouki", "m2003");

        JPanel imagePanel = createImagePanel(); // Panneau pour l'image
        JPanel inputPanel = createInputPanel(); // Panneau pour les champs de saisie

        getContentPane().setLayout(null);
        getContentPane().add(imagePanel);
        getContentPane().add(inputPanel);
    }

    // Créer le panneau pour l'image
    private JPanel createImagePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 350, 500);
        panel.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("image/location.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0,(panel.getHeight()/2)-128, panel.getWidth(), 256);
        panel.add(imageLabel);

        return panel;
    }

    // Créer le panneau pour les champs de saisie
    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(350, 0, 450, 500);

        JLabel loginLabel = new JLabel(" USER LOGIN ");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loginLabel.setForeground(Color.BLUE);
        loginLabel.setVerticalAlignment(SwingConstants.CENTER);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(loginLabel);
        loginLabel.setBounds(panel.getWidth() / 2 - 110, 150, 200, 50);
        loginLabel.setOpaque(true);
        loginLabel.setBackground(Color.BLACK);

        JPanel usernameIconPanel = new JPanel();
        usernameIconPanel.setBackground(Color.WHITE);
        usernameIconPanel.setBounds(panel.getWidth() / 2 - 170, 220, 25, 50);
        ImageIcon usernameIcon = new ImageIcon("image/img2.png");
        JLabel usernameIconLabel = new JLabel(usernameIcon);
        usernameIconPanel.add(usernameIconLabel);
        panel.add(usernameIconPanel);

        JPanel passwordIconPanel = new JPanel();
        passwordIconPanel.setBackground(Color.WHITE);
        passwordIconPanel.setBounds(panel.getWidth() / 2 - 170, 280, 25, 50);
        ImageIcon passwordIcon = new ImageIcon("image/img3.png");
        JLabel passwordIconLabel = new JLabel(passwordIcon);
        passwordIconPanel.add(passwordIconLabel);
        panel.add(passwordIconPanel);

        usernameField.setBounds((panel.getWidth() / 2 - 170) + 40, 220, ((panel.getWidth() / 2 - 170) * 2 - 25) + 200, 50);
        panel.add(usernameField);

        passwordField.setBounds((panel.getWidth() / 2 - 170) + 40, 280, ((panel.getWidth() / 2 - 170) * 2 - 25) + 200, 50);
        panel.add(passwordField);

        resultLabel = new JLabel("");
        resultLabel.setBounds((panel.getWidth() / 2 - 170) + 40, 335, ((panel.getWidth() / 2 - 170) * 2 - 25) + 200, 20);
        resultLabel.setForeground(Color.RED);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(resultLabel);

        loginButton.setBounds((panel.getWidth() / 2 - 170) + 40, 370, ((panel.getWidth() / 2 - 170) - 25) + 200, 50);
        loginButton.setBackground(new Color(90, 100, 70));
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setForeground(Color.WHITE);
        loginButton.setVerticalAlignment(SwingConstants.CENTER);
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(loginButton);

        // Création d'un raccourci clavier pour le bouton de connexion
        InputMap inputMap = loginButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");

        ActionMap actionMap = loginButton.getActionMap();
        actionMap.put("enterPressed", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick();
            }
        });

        loginButton.addActionListener(this);

        return panel;
    }

    // Gestionnaire d'événements pour le bouton de connexion
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Vérification des informations d'identification
        if (credentialsMap.containsKey(username) && credentialsMap.get(username).equals(password)) {
            resultLabel.setText("Login successful for user: " + username);
                this.dispose();
                SwingUtilities.invokeLater(inerface::new);
			
           
        } else {
            resultLabel.setText("Incorrect username or password!");
            clearFields();
        }
    }

    // Effacer les champs de saisie
    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new NimbusLookAndFeel());
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
    
    
    
}
