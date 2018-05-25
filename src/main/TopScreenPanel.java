package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TopScreenPanel extends JPanel {
	
	
	private JLabel toplabel = new JLabel();
	
	
	public TopScreenPanel() {
		
		/*toplabel.setIcon(new ImageIcon("Images/topScreen.png"));
		add(toplabel,BorderLayout.CENTER);*/
		this.setPreferredSize(new Dimension(200, 60));
	    this.setBackground(new Color(51,51,51));
		
		
	}

	protected void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("Images/topScreen.png"));
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
}
