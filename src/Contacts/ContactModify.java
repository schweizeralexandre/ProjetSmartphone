package Contacts;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import main.BasicPanel;
import main.ButtonClass;



public class ContactModify extends BasicPanel{

	private ContactPanel contactPanel;
	private CardLayout cards;
	private ArrayList<PersonDetails> person;
	private JPanel TopNewcontactPanel = new BasicPanel();
	private JPanel contactDetailsPanel = new BasicPanel();
	private JPanel photoPanel = new BasicPanel();
	protected JPanel contactDeletePanel = new BasicPanel();
	protected JButton Deletebut = new ButtonClass("Images/delete.png");
	private JButton Cancelbut = new JButton("Annuler");
	protected JButton Okbut = new JButton("OK");
	protected JLabel newContactLabel = new JLabel("Nouveau contact");
	protected JButton addimage = new JButton("Ajouter une photo");
	private JLabel nom = new JLabel("Nom");
	private JLabel prenom = new JLabel("Prenom");
	private JLabel mail = new JLabel ("Mail");
	private JLabel portable = new JLabel("Portable");
	private JLabel domicile = new JLabel("Domicile");
	protected JTextField [] champs = new JTextField[5];
	protected int id;
	ContactPicturePanel panel;
	
	

	public ContactModify(ContactPanel contactPanel, CardLayout cards, ArrayList<PersonDetails> person) {
		
		
		
		this.contactPanel = contactPanel;
		this.cards = cards;
		this.person = person;
		
		
		
		perzonaliszeButton(Cancelbut);
		perzonaliszeButton(Okbut);
		
		// désactive le bouton ok par défaut
		Okbut.setEnabled(false);
		
		// ajout des actionslistners aux boutons
		Okbut.addActionListener(new AddContactClass());
		Cancelbut.addActionListener(new ActionClass());
		
		// fait centrer le texte dans le JLabel
		newContactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
         for (int i = 0; i < champs.length; i++) {
			
			champs[i] = new JTextField("",10);
		    champs[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		    champs[i].addKeyListener(new KeyTypedClass());
			
			
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
		contactDetailsPanel.add(portable,c);
		
		c.gridx = 1;
		c.gridy = 4;
		contactDetailsPanel.add(champs[3], c);
		
		c.gridx = 0;
		c.gridy = 5;
		contactDetailsPanel.add(domicile,c);
		
		c.gridx = 1;
		c.gridy = 5;
		contactDetailsPanel.add(champs[4], c);
		
		
		photoPanel.setLayout(new FlowLayout());
		
		addimage = perzonaliszeAddImageButton(addimage);
		addimage.addActionListener(new ImageListner());
		
		photoPanel.add(addimage);
		Deletebut.setPreferredSize(new Dimension(20, 20));
		Deletebut.setEnabled(false);
		contactDeletePanel.add(Deletebut);
		
		
		
		
		
		
		TopNewcontactPanel.add(Cancelbut, BorderLayout.WEST);
		TopNewcontactPanel.add(newContactLabel, BorderLayout.CENTER);
		TopNewcontactPanel.add(Okbut, BorderLayout.EAST);
		TopNewcontactPanel.add(photoPanel,BorderLayout.SOUTH);
		this.add(TopNewcontactPanel, BorderLayout.NORTH);
		this.add(contactDetailsPanel,BorderLayout.CENTER);
		this.add(contactDeletePanel, BorderLayout.SOUTH);
		

	
		
	}
	


	public JTextField[] getChamps() {
		return champs;
	}



	public void setChamps(JTextField[] champs) {
		this.champs = champs;
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
    
    public JButton perzonaliszeAddImageButton(JButton but) {
    	
    	but.setPreferredSize(new Dimension(150, 70));
		perzonaliszeButton(addimage);
		but.setForeground(Color.BLACK);
		but.setHorizontalAlignment(SwingConstants.CENTER);

    	
    	
    	
    	return but;
   }
    

	
    public class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == Cancelbut) {
				cards.show(contactPanel, "contactlist");
				
				for (int i = 0; i < champs.length; i++) {
					// on enlève les caractères saisis
					champs[i].setText(null);
				}
			}
		}
		
	}
	public class ImageListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==addimage) {
				
				cards.show(contactPanel, "contactpic");
			
			}
			
			
			
			
			
		}
		
		
	}
	public class KeyTypedClass implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
	
		}
		@Override
		public void keyTyped(KeyEvent e) {
		
			/* le bouton ok qui permet d'ajouter un contact s'active lorsqu'au moins le nom, 
			 * le prénom et un numéro de téléphone sont saisis.
		       Sinon le bouton ok reste désactivé */
	
				
				if(champs[0].getText().isEmpty()||champs[1].getText().isEmpty()||
						champs[3].getText().isEmpty()&&champs[4].getText().isEmpty()) {
					Okbut.setEnabled(false);
				}else {
					Okbut.setEnabled(true);
				}
			
		}
	
	}
	
	public class AddContactClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==Okbut) {
		
				
			    try {
			    	
			    	serializeObject(person);
			    	
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			    
			
			    
			      if(contactPanel.contactlist.isTestcontact()==false) {
			    	contactPanel.getPerson().add(new PersonDetails(champs[0].getText(),champs[1].getText(),champs[2].getText(),champs[3].getText(),champs[4].getText()));
			    	contactPanel.affichecontact(contactPanel.getContactlist().getSavedContacts());
					}
					else {
						
						contactPanel.getPerson().get(contactPanel.contactmodify.id).setName(champs[0].getText());
						contactPanel.getPerson().get(contactPanel.contactmodify.id).setSurname(champs[1].getText());
						contactPanel.getPerson().get(contactPanel.contactmodify.id).setEmail(champs[2].getText());
						contactPanel.getPerson().get(contactPanel.contactmodify.id).setNum1(champs[3].getText());
						contactPanel.getPerson().get(contactPanel.contactmodify.id).setNum2(champs[4].getText());
						contactPanel.affichecontact(contactPanel.getContactlist().getSavedContacts());
						contactPanel.contactlist.setTestcontact(true);
						}
			    
			    
			    

			       cards.show(contactPanel,"contactlist");
			       
			       
			       
			       
			       
			       try {
					serializeObject(person);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				for (int i = 0; i < champs.length; i++) {
					// on enlève les caractères saisis
					champs[i].setText(null);
				}
				
				Okbut.setEnabled(false);
				
				
				
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

	
		
		
	
	
}
