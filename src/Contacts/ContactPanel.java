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

import main.BasicPanel;


public class ContactPanel extends BasicPanel {

	//private TopContactPanel topContactMainScreen = new TopContactPanel();
	//protected JPanel savedContacts = new BasicPanel();
	//private JList list;
//	private ArrayList<PersonDetails> person = new ArrayList<>();
//    private CardLayout cards = new CardLayout();
//    private ContactList contactlist = new ContactList(this,cards,person);
//    private ContactView contactview = new ContactView(this,cards,person);
//    private ContactModify contactmodify = new ContactModify(this,cards,person);
//    
	private ArrayList<PersonDetails> person;
    public CardLayout cards = new CardLayout();
    public ContactList contactlist;
    public ContactView contactview; 
    public ContactModify contactmodify;
  
	
	public ContactPanel() {	
	try {
		person=deserializeObject();
		System.out.println("ok");
	} catch (Exception e) {
		person= new ArrayList<>();
	}
	contactview = new ContactView(this,cards,person);
	contactlist = new ContactList(this,cards,person);
	contactmodify= new ContactModify(this,cards,person);
    this.setLayout(cards);
    this.add(contactlist,"contactlist");
    this.add(contactmodify,"contactmodify");
    this.add(contactview,"contactview");
    //this.add(topContactMainScreen, BorderLayout.NORTH); 


  
   
	}
	
	public void affichecontact(Container nea)
	{
;
		nea.removeAll();
		for (int i = 0; i <this.person.size(); i++) {
			
		
			nea.add(new ButtonContact(person.get(i).getName()));
			
		}
		System.out.println(person.size());
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


	
	
	
	
}
