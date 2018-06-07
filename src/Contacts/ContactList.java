package Contacts;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
   private JPanel savedContacts = new BasicPanel();
   private JButton addcontact = new ButtonClass("Images/addcontact.png");
   private JLabel contactlabel = new JLabel("Contacts");
   private JScrollPane scrollPanel = new JScrollPane(savedContacts);
	
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
		

		contactPanel.affichecontact(scrollPanel);
		
		
	}
	
	
	public class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			cards.show(contactPanel, "contactmodify");
		}
		
		
		
		
		
	}


	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	
	
}
