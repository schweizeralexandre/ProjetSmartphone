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





public class MainPanel extends JPanel {
	
	
	private JPanel label= new JPanel();
	private ClockPanel clock = new ClockPanel();
	private JButton contactButton = new ButtonClass("Images/ContactIcon.png");
	private JButton galleryButton = new ButtonClass("Images/PhotosICon.png");
	private JButton calculatorButton = new ButtonClass("Images/CalculatorIcon.png");
	private JButton appButton = new ButtonClass("Images/AppTodefine.png");

	
	
	
	public MainPanel() {
		setLayout(new BorderLayout());
		label.setLayout(new GridLayout(1,4));
		label.setOpaque(false);
		
	
		label.add(contactButton);
		label.add(galleryButton);
		label.add(calculatorButton);
		label.add(appButton);
		
		add(label,BorderLayout.SOUTH);
		
		clock.setOpaque(false);
		add(clock,BorderLayout.NORTH);
		
		
		contactButton.addActionListener(new ActionClass());
		galleryButton.addActionListener(new ActionClass());
		calculatorButton.addActionListener(new ActionClass());
		
		

	}

	protected void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("Images/Background.jpg"));
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
     
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
				else
					if(e.getSource()==calculatorButton) {
						MainFrame.changePanel("CalculatorPanel");
					}
				
			
			
			
		}

	}






	
	
	
	
	

}


