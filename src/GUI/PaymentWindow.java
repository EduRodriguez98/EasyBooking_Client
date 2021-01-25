package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;

public class PaymentWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private JLabel userLabel, passwordLabel;
	static JTextField userText;
	private JPasswordField passwordText;
	private JButton payButton;
	private JPanel panel;
	
	public PaymentWindow(Controller controller) {
		this.controller = controller;
		initComponents();
		this.setSize(300, 150);
		this.setTitle("Payment");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	private void initComponents() {

		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel);

		userLabel = new JLabel("Email");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		payButton = new JButton("Pay");
		payButton.setBounds(10, 80, 80, 25);
		panel.add(payButton);
		
		payButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				payButtonActionPerformed();
				
			}
		});
		

		
	}
	
	private void payButtonActionPerformed() {
		String username = userText.getText();
		String password = String.valueOf(passwordText.getPassword());

		boolean validation = controller.validatePayment(username, password);
		System.out.println(validation);
		
		if(validation == true) {
			System.out.println("Payment completed!");
			System.out.println("Windows closing in 5 seconds...");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e1) {
				System.out.println("SLEEP ERROR");
			}
			setVisible(false);
		}
	}

}
