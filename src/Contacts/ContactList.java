package Contacts;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import main.BasicPanel;
import main.ButtonClass;


public class ContactList extends BasicPanel{
	
   private ContactPanel contactPanel;
   private CardLayout cards;
   private ArrayList<PersonDetails> person;
   private JPanel addcontactPanel = new BasicPanel();
   protected JPanel savedContacts = new BasicPanel();
   private JButton addcontact = new ButtonClass("Images/addcontact.png");
   private JLabel contactlabel = new JLabel("Contacts");
   private JScrollPane scrollPanel = new JScrollPane(savedContacts);
   private boolean testcontact;
	
	public ContactList(ContactPanel contactPanel, CardLayout cards, ArrayList<PersonDetails> person) {
		
		
		this.contactPanel = contactPanel;
		this.cards = cards;
		this.person = person;
		
		
		addcontact.setPreferredSize(new Dimension(28,28));
		contactlabel.setFont(new Font("Arial", Font.BOLD, 23));
		
	    
	    
	    addcontact.addActionListener(new ActionClass());
	    
	    addcontactPanel.add(addcontact, BorderLayout.EAST);
	    addcontactPanel.add(contactlabel, BorderLayout.SOUTH);
	    this.add(addcontactPanel,BorderLayout.NORTH);
	    
	    
		
		
	    savedContacts.setLayout(new BoxLayout(savedContacts, BoxLayout.PAGE_AXIS));	

		
		
	    scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    
	   
	    
		
		
		this.add(scrollPanel,BorderLayout.CENTER);
		
		contactPanel.affichecontact(savedContacts);
		
		
	}
	
	
	public JPanel getSavedContacts() {
		return savedContacts;
	}

   
	public void setSavedContacts(JPanel savedContacts) {
		this.savedContacts = savedContacts;
	}


	public class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			testcontact= false;
			contactPanel.contactmodify.Deletebut.setEnabled(false);
			
			
			cards.show(contactPanel, "contactmodify");
		}
		
		
		
		
		
	}


	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}


	public boolean isTestcontact() {
		return testcontact;
	}


	public void setTestcontact(boolean testcontact) {
		this.testcontact = testcontact;
	}

	 public ArrayList<PersonDetails> getPerson() {
			return person;
		}
	
	  
	 public void setPerson(ArrayList<PersonDetails> person) {
	 	this.person = person;
	 }



	
}
