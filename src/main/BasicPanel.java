package main;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;


/**
 * class qui permet de créer un jPanel avec un fond d'écran blanc
 * @author ashan
 *
 */
public class BasicPanel extends JPanel{
	
	public BasicPanel() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
	
	}

}
