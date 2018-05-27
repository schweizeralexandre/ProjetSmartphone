package Contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.BasicPanel;
import main.ButtonClass;
import main.MainFrame;

public class TopContactPanel extends BasicPanel {

	private JPanel addcontactPanel = new BasicPanel();
	private JButton addcontact = new ButtonClass("Images/addcontact.png");
	private JLabel contactlabel = new JLabel("Contacts");
	
	
	public TopContactPanel() {
		
		
	addcontact.setPreferredSize(new Dimension(28,28));
	contactlabel.setFont(new Font("Arial", Font.BOLD, 23));
	
    
    
    addcontact.addActionListener(new ActionClass());
    
    addcontactPanel.add(addcontact, BorderLayout.EAST);
    addcontactPanel.add(contactlabel, BorderLayout.SOUTH);
    this.add(addcontactPanel,BorderLayout.NORTH);
		
    
    
		
	}
	
	public class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()== addcontact)
				MainFrame.changePanel("NewContact");
			
		}
		
		
		
		
		
	}
	
	
	
}
