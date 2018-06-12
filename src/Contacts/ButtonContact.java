package Contacts;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * classe qui permet de créer les bountons pour les contacts
 * @author ashan
 *
 */

public class ButtonContact extends JButton{
	
   private int id ;
   
   /**
    * constructeur de la classe buttonContct qui permet d'afficher le nom de la personne sur le bouton
    * @param name
    * @param id
    */
    
	public ButtonContact(String name,int id)
	{
		this.id=id;
		setText(name);
		setMaximumSize(new Dimension(300,40));
		this.setFocusPainted(false);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
