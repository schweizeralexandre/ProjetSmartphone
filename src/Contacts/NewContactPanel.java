package Contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.BasicPanel;
import main.MainFrame;

public class NewContactPanel extends BasicPanel {

	private JPanel TopNewcontactPanel = new BasicPanel();	
	private JButton Cancelbut = new JButton("Annuler");
	private JButton Okbut = new JButton("OK");
	private JLabel newContactLabel = new JLabel("Nouveau contact");
	
	
	public NewContactPanel() {
		
		
		
		Cancelbut.setBackground(Color.WHITE);
		//Cancelbut.setHorizontalAlignment(SwingConstants.LEFT);
		Okbut.setBackground(Color.WHITE);
		

		
		Cancelbut.setFont(new Font("Arial", Font.PLAIN, 12));
		Okbut.setFont(new Font("Arial", Font.PLAIN, 12));
		
		Cancelbut.setForeground(new Color(51,153,255));
		Okbut.setForeground(new Color(51,153,255));
	    
		
		
		// enlève les bordures des boutons
		Cancelbut.setBorderPainted(false);
		Okbut.setBorderPainted(false);
		
		// fait centrer le texte dans le JLabel
		newContactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		Cancelbut.addActionListener(new ActionClass());
		
		
		
		TopNewcontactPanel.add(Cancelbut, BorderLayout.WEST);
		TopNewcontactPanel.add(newContactLabel, BorderLayout.CENTER);
		TopNewcontactPanel.add(Okbut, BorderLayout.EAST);
		this.add(TopNewcontactPanel, BorderLayout.NORTH);
		
		
		
		
		
		
	}
	
	public class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == Cancelbut)
				MainFrame.changePanel("ContactPanel");
			
		}
		
		
		
		
		
	}
	
}
