package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.text.DecimalFormat;

import ui.CalculatorUI;

public class CalculatorActionListener implements ActionListener {
	
	private CalculatorUI ui;
	
	// store operator
	public String operator = "";
	
	// store operands
	public String s1 = "", s2 = "";
	
	public CalculatorActionListener(CalculatorUI calculatorFrame) {
		this.ui = calculatorFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand();
		
		//ui.inputTrackingField.setText(ui.inputTrackingField.getText() + (s.equals("=") ? "" : s));
		if(!s.equals("<="))
			ui.inputTrackingField.setText(ui.inputTrackingField.getText() + s);
	
		// if the value is a number
		if (s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.equals(".")) {
			// if operand is present then add to second no
			if (!operator.equals("")) {
				s2 += s;
			} else {
				s1 += s;
			}
		
//			ui.textFieldInput.setText(s1 + operator + s2);
		} else if (s.equals("=")) {
			// perform calculations
			double result = this.calculator();

			s1 = String.valueOf(result);
			s2 = "";
			operator = "";
			
			ui.inputTrackingField.setText(s1);
			ui.textFieldInput.setText(s1 + operator + s2);
		}
		else if(s.equals("C")) {
			// reset operators and operands
			s1 = "";
			s2 = "";
			operator = "";
			
			ui.inputTrackingField.setText("");
			ui.textFieldInput.setText("0");
		}
		else if(s.equals("<=")) {
			if(s2 != "") {
				s2 = s2.substring(0, s2.length() - 1);
			}
			else if(operator != "") {
				operator = operator.substring(0, operator.length() - 1);
			}
			else if(s1 != "" ) {
				s1 = s1.substring(0, s1.length() - 1);
			}
			
			String originalText = ui.inputTrackingField.getText();
			ui.inputTrackingField.setText(originalText.substring(0, originalText.length() - 1));
		}
		else {
			// if the button clicked represents an operator and two operands are already present
			// perform the calculation for existing operator and operands
			// then, update the display the result and reset the operator and second operand for the next calculation
			if(!operator.equals("") || !s2.equals("")) {
				double result = calculator();
			
				s1 = String.valueOf(result);
				s2 = "";
			}
			
			// place the operator
			operator = s;
			
//			ui.textFieldInput.setText(s1);
		}
	}

	private double calculator() {
		double num1 = 0;
		double num2 = 0;
		if(s1 != "")
			num1 = Double.parseDouble(s1);
		if(s2 != "") 
			num2 = Double.parseDouble(s2);
		double result = 0;
		if (operator.equals("+")) {
			result = num1 + num2;
		} else if (operator.equals("-")) {
			result = num1 - num2;
		} else if (operator.equals("*")) {
			result = num1 * num2;
		} else if (operator.equals("/")) {
			result = num1 / num2;
		} 
		else if(operator.equals("%")) {
			result = (int) num1 % (int) num2;
		}
		else if (operator.equals("\u221A")) {
			if(s1 != "") {
				result = Math.sqrt(num1);
			}
			else {
				result = Math.sqrt(num2);
			}
		}
		else if(operator.equals("!")) {
			if(s1 != "") {
				result = this.factorial(num1);
			}
			else {
				result = this.factorial(num2);
			}
		}
		else if(operator.equals("^")) {
			result = Math.pow(num1, num2);
		}
		else if(operator.equals("e^")) {
			if(s1 != "") {
				result = Math.exp(num1);
			}
			else {
				result = Math.exp(num2);
			}
		}
		else if(operator.equals("log")) {
			if(s1 != "") {
				result = Math.log(num1);
			}
			else {
				result = Math.log(num2);
			}
		}
		else if(operator.equals("sin")) {
			if(s1 != "") {
				result = Math.sin(num1);
			}
			else {
				result = Math.sin(num2);
			}
		}
		else if(operator.equals("cos")) {
			if(s1 != "") {
				result = Math.cos(num1);
			}
			else {
				result = Math.cos(num2);
			}
		}
		else if(operator.equals("tan")) {
			if(s1 != "") {
				result = Math.tan(num1);
			}
			else {
				result = Math.tan(num2);
			}
		}
		else if(operator.equals("^2")) {
			if(s1 != "") {
				result = Math.pow(num1, 2);
			}
			else {
				result = Math.pow(num2, 2);
			}
		}
		else if(operator.equals("^3")) {
			if(s1 != "") {
				result = Math.pow(num1, 3);
			}
			else {
				result = Math.pow(num2, 3);
			}
		}
//		DecimalFormat decimalFormat = new DecimalFormat("0.00");
//		return Double.parseDouble(decimalFormat.format(result));
		return result;
	}
	
	private long factorial(double number) {
		long res = 1;
		for(double i = 2; i <= number; i++) {
			res *= i;
		}
		return res;
	}
}
