package main;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Class qui permet de créer l'écran principal qui contients les boutons permettant d'accéder aux contacts, 
 * à la galerie, la météo et à la calculatrice.
 * 
 * @author ashan
 *
 */




public class MainPanel extends JPanel {
	
	
	private JPanel label= new JPanel();
	private ClockPanel clock = new ClockPanel();
	private JButton contactButton = new ButtonClass("Images/ContactIcon.png");
	private JButton galleryButton = new ButtonClass("Images/PhotosICon.png");
	private JButton calculatorButton = new ButtonClass("Images/CalculatorIcon.png");
	private JButton weatherButton = new ButtonClass("Images/weather.png");

	
	
	
	public MainPanel() {
		setLayout(new BorderLayout());
		label.setLayout(new GridLayout(1,4));
		label.setOpaque(false);
		
	
		label.add(contactButton);
		label.add(galleryButton);
		label.add(calculatorButton);
		label.add(weatherButton);
		
		add(label,BorderLayout.SOUTH);
		
		clock.setOpaque(false);
		add(clock,BorderLayout.NORTH);
		
		
		contactButton.addActionListener(new ActionClass());
		galleryButton.addActionListener(new ActionClass());
		calculatorButton.addActionListener(new ActionClass());
		weatherButton.addActionListener(new ActionClass());
		
		

	}
	
	/**
	 * méthode permettant d'ajouter une image au fond d'écran du smartphone
	 * 
	 */

	protected void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("Images/Background.jpg"));
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * cette classe action listner permet de passer d'un panel à l'autre quand on clique sur les boutons qui se trouvent sur le panel principal
	 * @author ashan
	 * 
	 *
	 */

     
	public class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()== contactButton) {
				 MainFrame.changePanel("ContactPanel");
			}
				if(e.getSource()==galleryButton) {
					MainFrame.changePanel("GalleryPanel");
				}
					if(e.getSource()==calculatorButton) {
						MainFrame.changePanel("CalculatorPanel");
					}
					else if (e.getSource()==weatherButton) {
						MainFrame.changePanel("WeatherPanel");
					}
				
			
			
			
		}

	}






	
	
	
	
	

}


