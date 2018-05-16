package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.*;

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
	
	  public void tickTock() {
		    clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
		    
		  }

}
