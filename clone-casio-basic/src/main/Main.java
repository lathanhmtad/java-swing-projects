package main;

import javax.swing.UIManager;

import ui.CalculatorUI;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		CalculatorUI calculator = new CalculatorUI();
		calculator.setVisible(true);
	}
}
