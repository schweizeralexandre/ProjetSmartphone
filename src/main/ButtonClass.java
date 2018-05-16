package main;

import java.awt.Dimension;

import javax.swing.*;

public class ButtonClass extends JButton{

	
	
	
	public ButtonClass(String source) {
		
		try {
			ImageIcon menuIcon = new ImageIcon(source);
		    setIcon(menuIcon);
		} catch (Exception ex) {
		    System.out.println(ex);
		}
		

		setPreferredSize(new Dimension(60, 60));
		setOpaque(false);
		setContentAreaFilled(false); 
		setBorderPainted(false); 
		setFocusPainted(false); 
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
