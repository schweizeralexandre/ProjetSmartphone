package main;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import Calculator.CalculatorPanel;
import Contacts.ContactPanel;
import Contacts.ContactViewPanel;
import Contacts.NewContactPanel;
import Gallery_Photos.GalleryPanel;
import Meteo.WeatherPanel;




public class MainFrame extends JFrame {
	
	

	private static CardLayout cl = new CardLayout();
	
	// panel qui permet de gérer le cardLayout
	private static JPanel cards = new JPanel();
	
	private MainPanel mainScreen = new MainPanel();
	private GalleryPanel gallery = new GalleryPanel();
	private ContactPanel contacts = new ContactPanel();
	private CalculatorPanel calculator = new CalculatorPanel();
	private WeatherPanel weather = new WeatherPanel() ;
	private ImageIcon image = new ImageIcon("Images/screen.jpg");
	private JLabel label = new JLabel();
	private MenuButtonPanel homebutton = new MenuButtonPanel();
	private TopScreenPanel topscreen = new TopScreenPanel();
	//public ContactViewPanel contactview;
	//private NewContactPanel newcontact = new NewContactPanel(contacts,contactview);
	
	
	
	public MainFrame() {
		
	/*for (int i = 0; i < newcontact.getPerson().size(); i++) {
		contactview = new ContactViewPanel(newcontact.getPerson(),newcontact);
		System.out.println( newcontact.getPerson().size());
	}
		*/
		
		
	
		
		
	
		
		
	this.add(mainScreen,BorderLayout.CENTER);
	this.add(homebutton, BorderLayout.SOUTH);
	this.add(topscreen, BorderLayout.NORTH);
	this.setUndecorated(true); // mets le JFrame sans bordures
	
	// changement des bordures du JFrame via componentListner 
	this.addComponentListener(new ComponentAdapter() {
        @Override
         public void componentResized(ComponentEvent e) {
             setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 55, 55));
         }
     });
	
	
	
	
	cards.setLayout(cl);
	cards.add(mainScreen, "MainScreenPanel");
	cards.add(contacts, "ContactPanel");
	/*cards.add(newcontact, "NewContact");
	cards.add(contactview,"contactView");*/
	cards.add(gallery, "GalleryPanel");
	cards.add(calculator, "CalculatorPanel");
	cards.add(weather, "WeatherPanel");
	cards.setBackground(new Color(0,0,0,0));
	
	
	add(cards, BorderLayout.CENTER);
	
	
	
	
	this.setResizable(false);
	this.setSize(270, 540);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);

	

		
		
		
	}
	
    // méthode qui permet de changer les panels via les boutons
	public static void changePanel(String name){
		cl.show(cards, name);
    }

}
	
	
	
	


