package Contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import main.BasicPanel;
import main.MainFrame;

public class ContactViewPanel extends BasicPanel{

	private JPanel topPan = new BasicPanel();
	private JButton contacts = new JButton("Contacts");
    private JButton modifier = new JButton("Modifier");
    private ArrayList<PersonDetails> person ;
	
	public ContactViewPanel(ArrayList<PersonDetails>person,int id) {
		
		this.person = person;
		
		perzonaliszeButton(contacts);
		perzonaliszeButton(modifier);

		contacts.addActionListener(new ActionContactList());
		modifier.addActionListener(new ActionContactModify());
		
		
		
		
		
		
		
		
		
	    topPan.add(contacts,BorderLayout.WEST);
	    topPan.add(modifier, BorderLayout.EAST);
	    this.add(topPan, BorderLayout.NORTH);

	
		
		
	}
	
	
	public JButton perzonaliszeButton(JButton but) {
		
		but.setBackground(Color.WHITE);
		but.setFont(new Font("Arial", Font.PLAIN, 12));
		but.setForeground(new Color(51,153,255));	
		but.setBorderPainted(false);
		
		
		return but;
	}
	
	
	public class ActionContactList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==contacts)
			 MainFrame.changePanel("ContactPanel");
		}	
		
	}
	
	public class ActionContactModify implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==modifier) {
				MainFrame.changePanel("NewContact");
			}
				
			
		}
		
		
		
		
		
		
		
	}
	
}
