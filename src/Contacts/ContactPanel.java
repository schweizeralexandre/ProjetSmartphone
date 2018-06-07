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
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

import main.BasicPanel;


public class ContactPanel extends BasicPanel {

	//private TopContactPanel topContactMainScreen = new TopContactPanel();
	//protected JPanel savedContacts = new BasicPanel();
	//private JList list;
	private ArrayList<PersonDetails> person = new ArrayList<>();
    private CardLayout cards = new CardLayout();
    private ContactList contactlist = new ContactList(this,cards,person);
    private ContactView contactview = new ContactView(this,cards,person);
    private ContactModify contactmodify = new ContactModify(this,cards,person);
    
	
	
	public ContactPanel() {	
	
    this.setLayout(cards);
    this.add(contactlist,"contactlist");
    this.add(contactmodify,"contactmodify");
    this.add(contactview,"contactview");
    //this.add(topContactMainScreen, BorderLayout.NORTH); 
    
    
    
   
	}
	
	public void affichecontact(Container nea)
	{
		nea.removeAll();
		for (int i = 0; i < person.size(); i++) {
			
			nea.add(new Button(person.get(i).getName()));
			
		}
	}

	public ContactList getContactlist() {
		return contactlist;
	}
	
   

}
