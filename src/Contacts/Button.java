package Contacts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Button extends JButton{

	private String name;
	private int id;
	private ArrayList<PersonDetails> person;
	
	public Button(String name, int id) {
		
		this.person = person;
		this.name = name;
		this.id = id;
		setText(name);
	}
	
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}


	



	
	
	
	
	
	
	
}
