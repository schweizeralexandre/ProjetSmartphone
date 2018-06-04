package Contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;


import main.BasicPanel;
import main.MainFrame;

public class NewContactPanel extends BasicPanel {

	private JPanel TopNewcontactPanel = new BasicPanel();
	private JPanel contactDetailsPanel = new BasicPanel();
	private JPanel photoPanel = new BasicPanel();
	private JButton Cancelbut = new JButton("Annuler");
	protected JButton Okbut = new JButton("OK");
	private JLabel newContactLabel = new JLabel("Nouveau contact");
	private JButton addimage = new JButton("Ajouter une photo");
	private JLabel nom = new JLabel("Nom");
	private JLabel prenom = new JLabel("Prenom");
	private JLabel mail = new JLabel ("Mail");
	private JTextField [] champs = new JTextField[5];
	private JComboBox [] tel = new JComboBox[2];
	private String[]telTypes = {"Domicile","Prive","Travail"};
	private ArrayList<PersonDetails> person = new ArrayList<>();
	private ArrayList<Button> contactLabels = new ArrayList<>();
	private ContactPanel pan;

	
	
	
	
	
	public NewContactPanel(ContactPanel pan) {
		
	
		
		
		 
		this.pan = pan;

		getbackButtons();  
		perzonaliszeButton(Cancelbut);
		perzonaliszeButton(Okbut);
		
		// désactive le bouton ok par défaut
		Okbut.setEnabled(false);
		
		// ajout des actionslistners aux boutons
		Okbut.addActionListener(new AddContactClass());
		Cancelbut.addActionListener(new ActionClass());
		
		// fait centrer le texte dans le JLabel
		newContactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
	
		
		    
		
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
	
     public JButton perzonaliszeButton(JButton but) {
		
		but.setBackground(Color.WHITE);
		but.setFont(new Font("Arial", Font.PLAIN, 12));
		but.setHorizontalAlignment(SwingConstants.LEFT);
		but.setForeground(new Color(51,153,255));	
		
		// enlève les bordures des boutons
		but.setBorderPainted(false);
		
		
		return but;
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
	
	public class AddContactClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==Okbut) {
		
			person.add(new PersonDetails(champs[0].getText(),champs[1].getText(),champs[2].getText(),champs[3].getText(),champs[4].getText()));
						
			    try {
			    	
			    	serializeObject(person);
			    	
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			   // création des contactsLabels
			    
			 // contactLabels.add(new Button(champs[0].getText()+champs[1].getText()));
			  
			   
			    
			    
			  for(int i = 0; i < contactLabels.size(); i++) {
				
				   contactLabels.get(i).setMaximumSize(new Dimension(300, 50));
				   pan.savedContacts.add(contactLabels.get(i));
			}
				
				
			    
				MainFrame.changePanel("ContactPanel");
				
				for (int i = 0; i < champs.length; i++) {
					// on enlève les caractères saisis
					champs[i].setText(null);
				}
				
			}
			
		}
		
	}
	


		public void serializeObject(ArrayList<PersonDetails> person) throws IOException 
	{
		FileOutputStream fichier = new FileOutputStream("Contacts/contacts.ser");
		BufferedOutputStream bfichier = new BufferedOutputStream(fichier);
		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier);
		obfichier.writeObject(person);
		obfichier.close();
	}

	
		
		@SuppressWarnings("unchecked")
		public ArrayList<PersonDetails> deserializeObject(String fichier) throws IOException, ClassNotFoundException 
		{
			ArrayList <PersonDetails> personne;
			FileInputStream ffichier = new FileInputStream(fichier);
			BufferedInputStream bfichier = new BufferedInputStream(ffichier);
			ObjectInputStream obfichier = new ObjectInputStream(bfichier);
			personne=(ArrayList<PersonDetails>) obfichier.readObject();
			obfichier.close();
			return personne;
		}

		public void getbackButtons() {
			
			try {
				person = deserializeObject("Contacts/contacts.ser");
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			 
		    for (int i = 0; i < person.size(); i++) {
			
			   contactLabels.add(new Button(person.get(i).getName()+person.get(i).getSurname(),i));
			   pan.savedContacts.add(contactLabels.get(i));
			   contactLabels.get(i).setMaximumSize(new Dimension(300, 50));
				  
		   }   
		
			  
		}

		public ArrayList<Button> getContactLabels() {
			return contactLabels;
		}

		public void setContactLabels(ArrayList<Button> contactLabels) {
			this.contactLabels = contactLabels;
		}

		public ArrayList<PersonDetails> getPerson() {
			return person;
		}

		public void setPerson(ArrayList<PersonDetails> person) {
			this.person = person;
		}
		
		
		
		
		
	
}



