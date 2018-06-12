package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Calculator.CalculatorPanel;

class CalculatorTest {

	double number = 4;
	double resultat;
	
	CalculatorPanel calculator = new CalculatorPanel();
	
	

	@Test
	void testDivision() {
		
	String result = calculator.division(number);
	assertEquals("0.0",result);
  
	result = calculator.division(0.0);
	assertEquals("Impossible",result);
	}

}
