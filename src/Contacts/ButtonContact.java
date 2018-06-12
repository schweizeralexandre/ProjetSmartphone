package Contacts;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;


public class ButtonContact extends JButton{
	
   private int id ;
    
	public ButtonContact(String name,int id)
	{
		this.id=id;
		setText(name);
		setMaximumSize(new Dimension(300,40));
		//this.setBackground(Color.WHITE);
		//this.setContentAreaFilled(false);
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
