package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.CalculatorActionListener;

public class CalculatorUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public JTextField textFieldInput;
	public JTextField inputTrackingField;
		
	private CalculatorActionListener actionListener;

	public CalculatorUI() {
		actionListener = new CalculatorActionListener(this);
		
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		setLayout(new BorderLayout());
		
		
		JPanel jPanelTextFields = new JPanel();
		jPanelTextFields.setLayout(new GridLayout(2, 1));
		this.add(jPanelTextFields, "North");

		inputTrackingField = new JTextField();
		inputTrackingField.setFont(new Font("Arial", Font.ITALIC, 16));
		inputTrackingField.setEditable(false);
		inputTrackingField.setPreferredSize(new Dimension(WIDTH, 40));
		jPanelTextFields.add(inputTrackingField);
		
		textFieldInput = new JTextField("0");
		textFieldInput.setBackground(Color.black);
		textFieldInput.setForeground(Color.white);
		textFieldInput.setFont(new Font("Arial", Font.BOLD, 20));
		textFieldInput.setEditable(false); // set the read only property
		textFieldInput.setPreferredSize(new Dimension(WIDTH, 60));
		jPanelTextFields.add(textFieldInput);
		

		// create panel containing calculation buttons
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(8, 4));
		
		jPanel.setBackground(Color.yellow);

		// list 16 buttons
		String[] arr = { "7", "8", "9", "<=",
				"4", "5", "6", "/", 
				 "1", "2", "3", "*",
				 "0", ".", "-", "+", "%", "C", "\u221A", "sin", "cos", "tan", "!", "^", "e^", "="
				, "log", "^2", "^3"
		};

		for (int i = 0; i < arr.length; i++) {
			JButton button = new JButton(arr[i]);
			button.setBackground(Color.BLUE);
			button.setFont(new Font("Arial", Font.PLAIN, 20));
			jPanel.add(button);
			button.addActionListener(actionListener);
		}

		this.add(jPanel, "Center");
	}
}
