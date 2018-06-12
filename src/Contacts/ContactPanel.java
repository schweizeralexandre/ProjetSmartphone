package Contacts;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

import Gallery_Photos.GalleryPanel;


import main.BasicPanel;


public class ContactPanel extends BasicPanel {


	private ArrayList<PersonDetails> person;
    protected CardLayout cards = new CardLayout();
    protected ContactList contactlist;
    protected ContactView contactview; 
    protected ContactModify contactmodify;
    private ContactPanel contactpanel;
    protected ContactPicturePanel picturepanel;
    private int j;
    protected ButtonContact button;
    

  
	
	public ContactPanel() {	
	try {
		person=deserializeObject();
	} catch (Exception e) {
		person= new ArrayList<>();
	}
	
	
	contactlist = new ContactList(this,cards,person);
	contactmodify= new ContactModify(this,cards,person);
	picturepanel = new ContactPicturePanel(contactmodify, this);
			
    this.setLayout(cards);
    this.add(contactlist,"contactlist");
    this.add(contactmodify,"contactmodify");
    this.add(picturepanel, "contactpic");
   //this.add(contactview,"contactview");
   //this.add(topContactMainScreen, BorderLayout.NORTH); 

    
    //contactmodify.Deletebut.addActionListener(new deletecontact());

      contactpanel = this;
      //button = this.button;
   
	}
	
	public void affichecontact(Container nea)
	{

		nea.removeAll();
		for (int i = 0; i <this.person.size(); i++) {
			
		 ButtonContact button = new ButtonContact(person.get(i).getName()+" "+person.get(i).getSurname(), i);
			nea.add(button);
			this.button = button;
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					contactview = new ContactView(contactpanel, cards, person,button.getId(),contactmodify);
					add(contactview,"contactview" );
					
					cards.show(contactpanel, "contactview");
					
				}
			});
		}
		
	}

	public ContactList getContactlist() {
		return contactlist;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<PersonDetails> deserializeObject() throws IOException, ClassNotFoundException 
	{
		ArrayList <PersonDetails> personne;
		FileInputStream ffichier = new FileInputStream("Contacts/contacts.ser");
		BufferedInputStream bfichier = new BufferedInputStream(ffichier);
		ObjectInputStream obfichier = new ObjectInputStream(bfichier);
		personne=(ArrayList<PersonDetails>) obfichier.readObject();
		obfichier.close();
		return personne;
	}

	public ArrayList<PersonDetails> getPerson() {
		return person;

	
	
	}

	public void setPerson(ArrayList<PersonDetails> person) {
		this.person = person;
	}
	
	


	

}
