package Contacts;

import java.awt.CardLayout;
import java.util.ArrayList;

import main.BasicPanel;

public class ContactView extends BasicPanel{
	
	private ContactPanel contactPanel;
	private CardLayout cards;
	private ArrayList<PersonDetails> person;
	

	public ContactView(ContactPanel contactPanel, CardLayout cards, ArrayList<PersonDetails> person) {
		
		
		this.contactPanel = contactPanel;
		this.cards = cards;
		this.person = person;
		
		
		
		
		
		
	}

	
	
	
	
	
	
}
