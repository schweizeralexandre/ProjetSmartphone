package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import main.BasicPanel;


public class CalculatorPanel extends BasicPanel {

	CalculatorButton button[] = new CalculatorButton[16];
	JPanel calculator = new BasicPanel();
    JPanel buttonsPan = new BasicPanel();
    JPanel champPan = new BasicPanel();
    JLabel field = new JLabel("0");
	
	public CalculatorPanel() {
		
	buttonsPan.setLayout(new GridLayout(4, 4));
		
	for (int i = 0; i < button.length; i++) {
		
	     button[i] = new CalculatorButton();
	     buttonsPan.add(button[i]);
	    
	}	
	
	field.setForeground(Color.BLACK);
	field.setSize(new Dimension(300, 150));
	champPan.add(field);
	
	
	calculator.add(champPan,BorderLayout.NORTH);
	calculator.add(buttonsPan, BorderLayout.CENTER);
	this.add(calculator);
	
		
	}
	
	
	
}
