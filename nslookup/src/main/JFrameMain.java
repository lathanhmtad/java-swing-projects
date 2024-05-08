package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JFrameMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextFieldDomainName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên miền");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 33, 84, 24);
		contentPane.add(lblNewLabel);
		
		jTextFieldDomainName = new JTextField();
		jTextFieldDomainName.setFont(new Font("Arial", Font.PLAIN, 18));
		jTextFieldDomainName.setBounds(139, 22, 286, 48);
		contentPane.add(jTextFieldDomainName);
		jTextFieldDomainName.setColumns(10);
		
		JButton btnSearch = new JButton("Tra cứu IP");
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
			
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSearch.setBounds(464, 25, 157, 40);
		contentPane.add(btnSearch);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(30, 110, 563, 123);
		contentPane.add(textAreaResult);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String domainName = jTextFieldDomainName.getText();
				try {
					InetAddress[] ipAddress = InetAddress.getAllByName(domainName);
					
					String result = "";
					for(int i = 0; i < ipAddress.length; i++) {
						result += ipAddress[i] + "\n";
					}
					textAreaResult.setText(result);
				} catch (UnknownHostException ex) {
					textAreaResult.setText(ex.getMessage());
				}
				
			}
		});
	}
}
