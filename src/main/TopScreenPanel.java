package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * classe permettant d'insérer une image topScreen en haut du smartphone
 * @author ashan
 *
 */

public class TopScreenPanel extends JPanel {
	
	
	
	
	public TopScreenPanel() {
		
		this.setPreferredSize(new Dimension(200, 60));
	    this.setBackground(new Color(51,51,51));
		
		
	}

	
	/**
	 * méthode permettant de redimensionner l'image topScreen sur le topScreenPanel
	 * 
	 */
	
	protected void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("Images/topScreen.png"));
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
}
