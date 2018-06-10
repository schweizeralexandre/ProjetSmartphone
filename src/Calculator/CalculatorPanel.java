package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.*;
import main.BasicPanel;


public class CalculatorPanel extends BasicPanel {

	private CalculatorButton button[] = new CalculatorButton[16];
	private JButton zero = new JButton();
	private JButton comma = new CalculatorButton();
	private JButton equal = new CalculatorButton();
	private JPanel calculator = new BasicPanel();
    private JPanel buttonsPan = new BasicPanel();
    private JPanel secondbuttonPan = new BasicPanel();
    private JPanel champPan = new BasicPanel();
    private JLabel field = new JLabel("0");
    private String[] values = {"AC","+/-","%","÷","7","8","9","×","4","5","6","-","1","2","3","+","+"};
	
	public CalculatorPanel() {
		
	buttonsPan.setLayout(new GridLayout(4, 4));
	
		
		
	for (int i = 0; i < button.length; i++) {
		
	     button[i] = new CalculatorButton();
	     buttonsPan.add(button[i]);
	    
	}	
	
	field.setForeground(Color.BLACK);
	field.setSize(new Dimension(300, 150));
	field.setFont(new Font("Serif", Font.BOLD, 70));
	field.setHorizontalAlignment(SwingConstants.RIGHT);
	field.setForeground(Color.WHITE);
	champPan.setBackground(Color.BLACK);
	champPan.setPreferredSize(new Dimension(50, 100));
	champPan.add(field);
	
	
	for (int i = 0; i < button.length; i++) {
		
		button[i].setText(values[i]);
		
		
		if(i==0||i==1||i==2) {
			button[i].setForeground(Color.BLACK);
			button[i].setBackground(new Color(204,204,204));
		}
		
		if(i==3||i==7||i==11||i==15) {
			button[i].setBackground(new Color(255,153,0));
		}
		
		
	}
	zero.setText("0");
	comma.setText(",");
	equal.setText("=");
	
	
	
	zero.setBackground(new Color(51,51,51));
	zero.setForeground(Color.BLACK);
	zero.setFocusPainted(false);
	zero.setFont(new Font("Serif", Font.BOLD, 22));
	zero.setForeground(Color.WHITE);
	equal.setBackground(new Color(255,153,0));
	
	
	zero.setPreferredSize(new Dimension(135, 70));
	comma.setPreferredSize(new Dimension(70, 70));
	equal.setPreferredSize(new Dimension(70, 70));
	
	
	secondbuttonPan.add(zero,BorderLayout.WEST);
	secondbuttonPan.add(comma,BorderLayout.CENTER);
	secondbuttonPan.add(equal,BorderLayout.EAST);

	

	

	
	
	
	
	
	calculator.add(champPan,BorderLayout.NORTH);
	calculator.add(buttonsPan, BorderLayout.CENTER);
	calculator.add(secondbuttonPan,BorderLayout.SOUTH);
	this.add(calculator);
	
		
	}
	
	
	
	
}
