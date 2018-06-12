package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.*;


/**
 * class qui permet de créer l'horlage 
 * @author ashan
 *
 */

public class ClockPanel extends JPanel{
	
	 private JLabel clock = new JLabel();
	 
	 
	public ClockPanel() {
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
	    tickTock();
	    add(clock);
	    
	    Timer timer = new Timer(50, (ActionListener) new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	      tickTock();
	      }
	    });
	    timer.setRepeats(true);
	    timer.setCoalesce(true);
	    timer.setInitialDelay(0);
	    timer.start();
	    clock.setForeground(Color.WHITE);
		
		
		
	}
	
	/**
	 * méthode qui permet de ajouter l'heure actuelle et la date au panel
	 */
	
	public void tickTock() {
		    clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
		
		    
		  }

}
