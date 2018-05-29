package Contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;


import main.BasicPanel;
import main.MainFrame;

public class NewContactPanel extends BasicPanel {

	private JPanel TopNewcontactPanel = new BasicPanel();
	private JPanel contactDetailsPanel = new BasicPanel();
	private JPanel photoPanel = new BasicPanel();
	private JButton Cancelbut = new JButton("Annuler");
	private JButton Okbut = new JButton("OK");
	private JLabel newContactLabel = new JLabel("Nouveau contact");
	private JButton addimage = new JButton("Ajouter une photo");
	private JLabel nom = new JLabel("Nom");
	private JLabel prenom = new JLabel("Prenom");
	private JLabel mail = new JLabel ("Mail");
	private JTextField [] champs = new JTextField[5];
	private JComboBox [] tel = new JComboBox[2];
	private String[]telTypes = {"Domicile","Privé","Travail"};
	private ArrayList<PersonDetails> person = new ArrayList<PersonDetails>();

	
	
	
	
	
	public NewContactPanel() {
		
		
		
		Cancelbut.setBackground(Color.WHITE);
		Cancelbut.setHorizontalAlignment(SwingConstants.LEFT);
		Okbut.setBackground(Color.WHITE);
		

		
		Cancelbut.setFont(new Font("Arial", Font.PLAIN, 12));
		Okbut.setFont(new Font("Arial", Font.PLAIN, 12));
		
		Cancelbut.setForeground(new Color(51,153,255));
		Okbut.setForeground(new Color(51,153,255));
	    
		
		
		// enlève les bordures des boutons
		Cancelbut.setBorderPainted(false);
		Okbut.setBorderPainted(false);
		// désactive le bouton ok par défaut
		Okbut.setEnabled(false);
		
		// fait centrer le texte dans le JLabel
		newContactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		Cancelbut.addActionListener(new ActionClass());
		
		
		
		//addimage.setHorizontalAlignment(SwingConstants.CENTER);
		
	
		
		
		
		
		
		
		
		for (int i = 0; i < champs.length; i++) {
			
			champs[i] = new JTextField("",10);
		    champs[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		    champs[i].addKeyListener(new KeyTypedClass());
			
			
		}
	
	
		for (int i = 0; i < tel.length; i++) {
			
			tel[i] = new JComboBox(telTypes);
			tel[i].setBackground(Color.WHITE);;
		
		}
		
		
		contactDetailsPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(20,20,20,20);
		
		c.gridx = 0;
		c.gridy = 1;
		contactDetailsPanel.add(nom,c);
		
		c.gridx = 1;
		c.gridy = 1;
		contactDetailsPanel.add(champs[0], c);
		
	    c.gridx = 0;
		c.gridy = 2;
		contactDetailsPanel.add(prenom,c);
		
		c.gridx = 1;
		c.gridy = 2;
		contactDetailsPanel.add(champs[1], c);
		
		c.gridx = 0;
		c.gridy = 3;
		contactDetailsPanel.add(mail,c);
		
		c.gridx = 1;
		c.gridy = 3;
		contactDetailsPanel.add(champs[2], c);
		
		c.gridx = 0;
		c.gridy = 4;
		contactDetailsPanel.add(tel[0],c);
		
		c.gridx = 1;
		c.gridy = 4;
		contactDetailsPanel.add(champs[3], c);
		
		c.gridx = 0;
		c.gridy = 5;
		contactDetailsPanel.add(tel[1],c);
		
		c.gridx = 1;
		c.gridy = 5;
		contactDetailsPanel.add(champs[4], c);
		
		
		
		
		
		
		
		
		
		
		
		
		
		TopNewcontactPanel.add(Cancelbut, BorderLayout.WEST);
		TopNewcontactPanel.add(newContactLabel, BorderLayout.CENTER);
		TopNewcontactPanel.add(Okbut, BorderLayout.EAST);
		
		//contactDetailsPanel.add(addimage,BorderLayout.NORTH);
		this.add(TopNewcontactPanel, BorderLayout.NORTH);
		this.add(contactDetailsPanel,BorderLayout.CENTER);
		
		
		
		
		
		
		
		
	}
	
	public class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == Cancelbut) {
				MainFrame.changePanel("ContactPanel");
				
				for (int i = 0; i < champs.length; i++) {
					// on enlève les caractères saisis
					champs[i].setText(null);
				}
			}
		}
		
		
		
		
		
	}
	
	public class KeyTypedClass implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		
		// si on enlève les valeurs saisies dans les champs, le bouton ok se désactive
			for (int i = 0; i < champs.length; i++) {
				
				if(e.getSource()==champs[i]) {
				
					if(champs[i].getText().isEmpty())
					Okbut.setEnabled(false);
				}
										
			}
			
			
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
		
			// si on saisit qqch dans les champs le button ok s'active
	
				for (int i = 0; i < champs.length; i++) {
					
					if(e.getSource()==champs[i]) {
						Okbut.setEnabled(true);
											
				}
				
			
				
				
			}
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	
}
