package main;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.*;




public class MainFrame extends JFrame {
	
	private static CardLayout cardLayout;
	private static JPanel cards;
	private MainPanel mainScreen = new MainPanel();
	private ImageIcon image = new ImageIcon("Images/screen.jpg");
	private JLabel label = new JLabel();
	
	
	
	
	public MainFrame() {
		
		cards = new JPanel (cardLayout = new CardLayout());
		cards.add(mainScreen, "launcherJPanel");
		add(cards, BorderLayout.CENTER);
		this.add(mainScreen,BorderLayout.CENTER);
		
		
		
	
	add(mainScreen, BorderLayout.CENTER);
	this.setUndecorated(true); // mets le JFrame sans bordures
	this.setResizable(false);
	this.setSize(270, 540);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);

	
		
		
		
		
		
	}
	
	
	
	

}
