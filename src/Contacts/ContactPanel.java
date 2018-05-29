package Contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;

import main.BasicPanel;

public class ContactPanel extends BasicPanel {

	private TopContactPanel topContactMainScreen = new TopContactPanel();
	private JPanel savedContacts = new BasicPanel();
	
	
	public ContactPanel() {	
	
	
	this.add(savedContacts,BorderLayout.CENTER);
    this.add(topContactMainScreen, BorderLayout.NORTH);
		
		
		
	}
	
	
	
	
	
	

}
