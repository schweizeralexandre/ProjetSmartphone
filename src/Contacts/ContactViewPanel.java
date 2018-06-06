package Contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import main.BasicPanel;
import main.MainFrame;

public class ContactViewPanel extends BasicPanel{

	private JPanel topPan = new BasicPanel();
	private JPanel centerpan = new BasicPanel();
	private JPanel infoPan = new BasicPanel();
	private JButton contacts = new JButton("Contacts");
    private JButton modifier = new JButton("Modifier");
    private ArrayList<PersonDetails> person ;
    private NewContactPanel newcontactpan;
    private JLabel contactImage = new JLabel();
    private JLabel contactName = new JLabel();
    private JLabel[] contactInfo = new JLabel[3];
	
	public ContactViewPanel(ArrayList<PersonDetails>person,int id, NewContactPanel newcontactpan) {
		
		this.person = person;
		this.newcontactpan = newcontactpan;
		
		
		perzonaliszeButton(contacts);
		perzonaliszeButton(modifier);

		contacts.addActionListener(new ActionContactList());
		modifier.addActionListener(new ActionContactModify());
		
		contactName.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		for (int i = 0; i < person.size(); i++) {
			
		 // newcontactpan.getContactLabels().get(i).removeAll();
		 /* if(newcontactpan.getContactLabels().get(i))
          contactName.setText(newcontactpan.getContactLabels().get(i).getName());*/
		}
		
		
		
		
		
		
		infoPan.setLayout(new GridLayout(3, 1));
		
		for (int i = 0; i < contactInfo.length; i++) {
			contactInfo[i] = new JLabel();
			infoPan.add(contactInfo[i]);
			contactInfo[i].setPreferredSize(new Dimension(300, 50));
			contactInfo[i].setText("yooo");
		}
		
		
		
		
	    topPan.add(contacts,BorderLayout.WEST);
	    topPan.add(modifier, BorderLayout.EAST);
	    centerpan.add(contactImage,BorderLayout.CENTER);
	    centerpan.add(contactName, BorderLayout.SOUTH);
	    this.add(infoPan, BorderLayout.SOUTH);
	    this.add(centerpan, BorderLayout.CENTER);
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
