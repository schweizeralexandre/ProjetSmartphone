package Contacts;


import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;



import main.BasicPanel;

/**
 * Classe qui contient les panels contactslist, contactmodify et contatactpicturepanel, et contactview
 * @author ashan
 *
 */

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
   

      contactpanel = this;
   
   
	}
	
/**
 * méthode qui permet de créer les boutons 
 * @param nea
 */
	
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
	
	/**
	 * méthode qui déserialise les objets personnes afin de les afficher dans contactlist, dans contactview et dans contact modifiy
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
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
