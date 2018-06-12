package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private String[] values = { "AC", "+/-", "%", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+"};
	private double result;
	private boolean clicOperateur = false, update = false;
	private String operateur;

	public CalculatorPanel() {

		buttonsPan.setLayout(new GridLayout(4, 4));

		for (int i = 0; i < button.length; i++) {

			button[i] = new CalculatorButton();
			buttonsPan.add(button[i]);

		}

		field = customizeLabel(field);

		champPan.setBackground(Color.BLACK);
		champPan.setPreferredSize(new Dimension(50, 100));
		champPan.add(field);

		for (int i = 0; i < button.length; i++) {

			button[i].setText(values[i]);

			if (i == 0 || i == 1 || i == 2) {
				button[i].setForeground(Color.BLACK);
				button[i].setBackground(new Color(204, 204, 204));
			}

			if (i == 3 || i == 7 || i == 11 || i == 15) {
				button[i].setBackground(new Color(255, 153, 0));
			}

		}
		zero.setText("0");
		comma.setText(".");
		equal.setText("=");

		zero = customizeButton(zero);
		equal.setBackground(new Color(255, 153, 0));

		actionListners();

		secondbuttonPan.add(zero, BorderLayout.WEST);
		secondbuttonPan.add(comma, BorderLayout.CENTER);
		secondbuttonPan.add(equal, BorderLayout.EAST);

		calculator.add(champPan, BorderLayout.NORTH);
		calculator.add(buttonsPan, BorderLayout.CENTER);
		calculator.add(secondbuttonPan, BorderLayout.SOUTH);
		this.add(calculator);

		comma.addActionListener(new Numberlistner());
		equal.addActionListener(new EqualListner());
		zero.addActionListener(new Numberlistner());

	}

	public JLabel customizeLabel(JLabel lab) {

		lab.setForeground(Color.BLACK);
		lab.setSize(new Dimension(300, 150));
		lab.setFont(new Font("Serif", Font.BOLD, 40));
		lab.setHorizontalAlignment(SwingConstants.RIGHT);
		lab.setForeground(Color.WHITE);

		return lab;
	}

	public JButton customizeButton(JButton but) {

		but.setBackground(new Color(51, 51, 51));
		but.setForeground(Color.BLACK);
		but.setFocusPainted(false);
		but.setFont(new Font("Serif", Font.BOLD, 22));
		but.setForeground(Color.WHITE);
		but.setPreferredSize(new Dimension(135, 70));

		return but;
	}

	public void actionListners() {

		for (int i = 0; i < button.length; i++) {
			// button[i].addActionListener(new MinusplusListner());

			switch (i) {

			case 0:
				button[i].addActionListener(new AcListner());
				break;
			case 1:
				button[i].addActionListener(new MinusplusListner());
				break;

			case 2:

				button[i].addActionListener(new PourcentageListner());
				break;

			case 3:

				button[i].addActionListener(new DevisionListner());
				break;

			case 7:

				button[i].addActionListener(new MultiplicationListner());
				break;

			case 11:

				button[i].addActionListener(new MinusListner());
				break;

			case 15:

				button[i].addActionListener(new PlusListner());
				break;

			default:

				button[i].addActionListener(new Numberlistner());
				break;

			}

		}

	}

	private void calculOperateurs() {

		if (operateur == "+") {

			result = result + Double.valueOf(field.getText()).doubleValue();
			field.setText(String.valueOf(result));
		}
		if (operateur == "-") {
			result = result - Double.valueOf(field.getText()).doubleValue();
			field.setText(String.valueOf(result));
		}
		if (operateur == "×") {
			result = result * Double.valueOf(field.getText()).doubleValue();
			field.setText(String.valueOf(result));
		}
		if (operateur == "÷") {

			String res = division(Double.valueOf(field.getText()).doubleValue());
			field.setText(res);
		}
		
		if (operateur == "%") {
			result = Double.valueOf(field.getText()).doubleValue()/100;
			//result = result/100;
			field.setText(String.valueOf(result));
			
		}

	}

	public String division(Double num) {

		result = result / num;

		if (num == 0) {

			return "Impossible";

		} else {
			return String.valueOf(result);
		}
	}

	public class AcListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			clicOperateur = false;
			update = true;
			result = 0;
			field.setText("0");
		}

	}

	public class MinusplusListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			Object src = e.getSource();

			if (src == button[1])
				field.setText("" + Double.parseDouble(field.getText()) * -1);

		}

	}

	public class PourcentageListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if(clicOperateur){
                calculOperateurs();
                field.setText(String.valueOf(result));
              }
              else{
                result = Double.valueOf(field.getText()).doubleValue();
                clicOperateur = true;
              }
              operateur = "%";
              update = true;
			
			
			
		}

	}

	public class DevisionListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (clicOperateur) {
				calculOperateurs();
				field.setText(String.valueOf(result));
			} else {
				result = Double.valueOf(field.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "÷";
			update = true;
		}

	}

	public class MultiplicationListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(clicOperateur){
                calculOperateurs();
                field.setText(String.valueOf(result));
              }
              else{
                result = Double.valueOf(field.getText()).doubleValue();
                clicOperateur = true;
              }
              operateur = "×";
              update = true;
		}

	}

	public class MinusListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (clicOperateur) {
				calculOperateurs();
				field.setText(String.valueOf(result));
			} else {
				result = Double.valueOf(field.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "-";
			update = true;
		}

	}

	public class PlusListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (clicOperateur) {
				calculOperateurs();
				field.setText(String.valueOf(result));
			} else {
				result = Double.valueOf(field.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "+";
			update = true;
		}

	}

	public class CommaListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class EqualListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			calculOperateurs();
			update = true;
			clicOperateur = false;
		}

	}

	public class Numberlistner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String stk = ((JButton) e.getSource()).getText();
			if (update) {
				update = false;
			} else {
				if (!field.getText().equals("0"))
					stk = field.getText() + stk;
			}
			field.setText(stk);
		}
	}

}
