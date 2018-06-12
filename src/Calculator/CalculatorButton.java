package Calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

/**
 * classe qui permet personnaliser  les boutons de la calculatrice
 * @author ashan
 *
 */


public class CalculatorButton extends JButton {

	
	
	public CalculatorButton() {
	
		
		this.setPreferredSize(new Dimension(70, 70));
		this.setBackground((new Color(102,102,102)));
		this.setFocusPainted(false);
		this.setFont(new Font("Serif", Font.BOLD, 22));
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(51,51,51));
	
	
		
	
		
		
		
		
		
	}
	

		
	
	
	
}
