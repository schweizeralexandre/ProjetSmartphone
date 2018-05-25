package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class MenuButtonPanel extends JPanel {
	
	private JButton menu = new ButtonClass("Images/menuButton.png");
	

	
	public MenuButtonPanel() {
		
		
	    this.add(menu, BorderLayout.CENTER);
	    // changement de la couleur du jPanel surlequel se retrouve le homebutton
		this.setBackground(new Color(51, 51, 51));
		
		
		menu.addActionListener(new ActionClass());
		
		
		
	}


	public class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == menu) {
				   MainFrame.changePanel("MainScreenPanel");
				}
			
			
		}
		
		
	}
	
	
	

	
	
	
	
	
	
	
	

}
