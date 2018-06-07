package Contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.border.LineBorder;

import main.BasicPanel;
import main.MainFrame;

public class ContactPanel extends BasicPanel {

	private TopContactPanel topContactMainScreen = new TopContactPanel();
	protected JPanel savedContacts = new BasicPanel();
	//private JList list;
	private NewContactPanel butpan;

	
	
	public ContactPanel() {	
	
	butpan = new NewContactPanel(this);
					
	savedContacts.setLayout(new BoxLayout(savedContacts, BoxLayout.PAGE_AXIS));	

	JScrollPane scrollPanel = new JScrollPane(savedContacts);
	
    scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
	
	
	this.add(scrollPanel,BorderLayout.CENTER);
    this.add(topContactMainScreen, BorderLayout.NORTH); 
    
    
    
   
	}
	

}
