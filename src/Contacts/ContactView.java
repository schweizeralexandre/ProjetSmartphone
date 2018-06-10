package Contacts;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import main.BasicPanel;


public class ContactView extends BasicPanel{
	
	private ContactPanel contactPanel;
	private CardLayout cards;
	final ArrayList<PersonDetails> person;
	private JPanel topPan = new BasicPanel();
	private JPanel centerpan = new BasicPanel();
	private JPanel infoPan = new BasicPanel();
	private JButton contacts = new JButton("Contacts");
    private JButton modifier = new JButton("Modifier");
    private JLabel contactImage = new JLabel();
    protected JLabel contactName = new JLabel();
    private JLabel[] contactInfo = new JLabel[3];
    private int j;
	private ContactModify contactmodify;
	

	public ContactView(ContactPanel contactPanel, CardLayout cards, ArrayList<PersonDetails> person, int j, ContactModify contactmodify) {
		
		this.contactPanel = contactPanel;
		this.cards = cards;
		this.person = person;
		this.j = j;
		this.contactmodify = contactmodify;
		
		perzonaliszeButton(contacts);
		perzonaliszeButton(modifier);

		contacts.addActionListener(new ActionContactList());
		modifier.addActionListener(new ActionContactModify());
		
		contactName.setHorizontalAlignment(SwingConstants.CENTER);
		  
		contactmodify.champs[0].setText(contactPanel.getPerson().get(j).getEmail());
		
		
		
	    infoPan.setLayout(new GridLayout(3, 1));
		
		for (int i = 0; i < contactInfo.length; i++) {
			contactInfo[i] = new JLabel();
			infoPan.add(contactInfo[i]);
			
			contactInfo[i].setPreferredSize(new Dimension(300, 50));
		
		
        }
		
		contactName.setText(contactPanel.getPerson().get(j).getName()+" "+contactPanel.getPerson().get(j).getSurname());
		contactInfo[0].setText(" E-mail:     "+ contactPanel.getPerson().get(j).getEmail());
		contactInfo[1].setText(" Portable:  " +contactPanel.getPerson().get(j).getNum1());
		contactInfo[2].setText(" Domicile:  "+contactPanel.getPerson().get(j).getNum2());
		
		
	    
	    topPan.add(contacts,BorderLayout.WEST);
	    topPan.add(modifier, BorderLayout.EAST);
	    centerpan.add(contactImage,BorderLayout.CENTER);
	    centerpan.add(contactName, BorderLayout.SOUTH);
	    this.add(infoPan, BorderLayout.SOUTH);
	    this.add(centerpan, BorderLayout.CENTER);
	    this.add(topPan, BorderLayout.NORTH);
	    
	    
	    
	    contactmodify.Deletebut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				contactPanel.contactlist.savedContacts.remove(contactPanel.button);
				
		
				cards.show(contactPanel,"contactlist");
				
				
		

			}
			
			 
		});
	    
	    
	    try {
			 person = deserializeObject();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		person.clear();
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
		
			cards.show(contactPanel,"contactlist");
			
		}	
		
	}
	
	public class ActionContactModify implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==modifier) {
				
				
				contactmodify.newContactLabel.setVisible(false);
				contactmodify.champs[0].setText(contactPanel.getPerson().get(j).getName());
				contactmodify.champs[1].setText(contactPanel.getPerson().get(j).getSurname());
				contactmodify.champs[2].setText(contactPanel.getPerson().get(j).getEmail());
				contactmodify.champs[3].setText(contactPanel.getPerson().get(j).getNum1());
				contactmodify.champs[4].setText(contactPanel.getPerson().get(j).getNum2());
				contactInfo[1].setText(contactPanel.getPerson().get(j).getNum1());
				contactInfo[2].setText(contactPanel.getPerson().get(j).getNum2());
				contactmodify.Deletebut.setEnabled(true);
				
				
				//contactPanel.getPerson().remove(j);
				
				cards.show(contactPanel, "contactmodify");
			}
				
			
		}
		
		
		
		
		
		
		
	}

	public ArrayList<PersonDetails> deserializeObject() throws IOException, ClassNotFoundException 
	{
		ArrayList <PersonDetails> personne;
		FileInputStream ffichier = new FileInputStream("Contacts/contacts.ser");
		BufferedInputStream bfichier = new BufferedInputStream(ffichier);
		ObjectInputStream obfichier = new ObjectInputStream(bfichier);
		personne=(ArrayList<PersonDetails>) obfichier.readObject();
		personne.remove(person.get(j));
		obfichier.close();
		return personne;
	}

	
	
	
	
	
}
