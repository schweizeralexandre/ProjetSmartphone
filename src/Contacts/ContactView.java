package Contacts;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import main.BasicPanel;

/**
 * classe qui permet d'afficher l'aperçu d'un contact qui a été créé
 * @author ashan
 *
 */

public class ContactView extends BasicPanel{
	
	private ContactPanel contactPanel;
	private CardLayout cards;
	private ArrayList<PersonDetails> person;
	private JPanel topPan = new BasicPanel();
	private JPanel centerpan = new BasicPanel();
	private JPanel infoPan = new BasicPanel();
	private JButton contacts = new JButton("Contacts");
    private JButton modifier = new JButton("Modifier");
    protected JLabel contactImage = new JLabel();
    protected JLabel contactName = new JLabel();
    private JLabel[] contactInfo = new JLabel[3];
    protected int j;
	private ContactModify contactmodify;
	
	/**
	 * contructeur qui permet de créer l'aperçu pour chaque contact qui a été créé
	 * @param contactPanel
	 * @param cards
	 * @param person
	 * @param j
	 * @param contactmodify
	 */

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
		
		try {
	         ImageIcon img = new ImageIcon(person.get(j).getImage());
	         
	         Image picture  = getImageIcon(img.getImage(), 270, 250);
	        
				contactImage.setIcon(new ImageIcon(picture)) ;
	         
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
	    
	  

	    

        for( ActionListener al : contactmodify.Deletebut.getActionListeners() ) {
    	contactmodify.Deletebut.removeActionListener( al );
    	
        }
        
       

        
	
 
        
	    contactmodify.Deletebut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				contactPanel.contactlist.getPerson().remove(j);
				
				System.out.println(j);
				contactPanel.affichecontact(contactPanel.contactlist.savedContacts);
				
				 try {
			        	
			        	contactmodify.serializeObject(contactPanel.getPerson());
			        	
			    		
			    	} catch (IOException e1) {
			    		
			    		e1.printStackTrace();
			    	}
			           contactPanel.affichecontact(contactPanel.getContactlist().getSavedContacts());
			            
		
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

	/**
	 * méthode qui permet de personnaliser le bouton contact et modifier
	 * @param but
	 * @return
	 */
	
     public JButton perzonaliszeButton(JButton but) {
		
		but.setBackground(Color.WHITE);
		but.setFont(new Font("Arial", Font.PLAIN, 12));
		but.setForeground(new Color(51,153,255));	
		but.setBorderPainted(false);
		
		
		return but;
	}
	
	/**
	 * classe actionListner qui permet de retourner au contactlist panel quand le bouton contacts est cliqué
	 * @author ashan
	 *
	 */
	public class ActionContactList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==contacts)
		
			cards.show(contactPanel,"contactlist");
			
		}	
		
	}
	
	/**
	 * classe actionListner qui permet modifier un contact qui a été créé
	 * @author ashan
	 *
	 */
	
	public class ActionContactModify implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==modifier) {
				
				contactPanel.contactlist.setTestcontact(true);
				
				contactmodify.newContactLabel.setVisible(false);
				contactmodify.Okbut.setEnabled(true);
				contactmodify.id=j;
				
				ImageIcon img = new ImageIcon(person.get(j).getImage());
				contactImage.setIcon(img);
			
				contactmodify.champs[0].setText(contactPanel.getPerson().get(j).getName());
				contactmodify.champs[1].setText(contactPanel.getPerson().get(j).getSurname());
				contactmodify.champs[2].setText(contactPanel.getPerson().get(j).getEmail());
				contactmodify.champs[3].setText(contactPanel.getPerson().get(j).getNum1());
				contactmodify.champs[4].setText(contactPanel.getPerson().get(j).getNum2());
				contactInfo[1].setText(contactPanel.getPerson().get(j).getNum1());
				contactInfo[2].setText(contactPanel.getPerson().get(j).getNum2());
				contactmodify.Deletebut.setEnabled(true);
				
			
				
				cards.show(contactPanel, "contactmodify");
			}
				
			
		}
		
		
		
		
		
		
		
	}
	
	/**
	 * méthode qui permet de récupérer les contacts qui ont été créés afin de les afficher dans modifycontact pour ensuite les modifier
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */

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
	
	
	/**
	 * méthode qui permet redimensionner l'image choisi pour le contact afin de l'afficher dans l'aperçu du contact
	 * @param img
	 * @param x
	 * @param y
	 * @return
	 */
	private Image getImageIcon (Image img, int x, int y) {
		BufferedImage resizedImg = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB) ;
		Graphics2D g2 = resizedImg.createGraphics() ;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR) ;
		g2.drawImage(img, 0, 0,x, y, null) ;
		g2.dispose() ;
		return resizedImg ;
	}

	public ArrayList<PersonDetails> getPerson() {
		return person;
	}

	public void setPerson(ArrayList<PersonDetails> person) {
		this.person = person;
	}


	
	
	
}
