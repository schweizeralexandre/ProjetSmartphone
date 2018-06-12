package main;

import java.awt.Dimension;
import javax.swing.*;

/**
 * class qui permet de créer un jbutton avec une image
 * @author ashan
 *
 */

public class ButtonClass extends JButton{

	/**
	 * méthode qui permet de redimensionner l'image sur le jbutton
	 * @param source
	 */
	
	
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
