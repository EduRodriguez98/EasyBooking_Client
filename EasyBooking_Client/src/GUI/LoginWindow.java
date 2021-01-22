package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;

public class LoginWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private JLabel userLabel, passwordLabel;
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton loginButton, registerButton;
	private JPanel panel;
	
	public LoginWindow(Controller controller) {
		this.controller = controller;
		initComponents();
		this.setSize(300, 150);
		this.setTitle("LogIn");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	private void initComponents() {

		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel);

		userLabel = new JLabel("User");
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

		loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginButtonActionPerformed();
				
			}
		});
		
		registerButton = new JButton("Register");
		registerButton.setBounds(180, 80, 90, 25);
		panel.add(registerButton);
		
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				registerButtonActionPerformed();
				
			}
		});
		
	}
	
	private void loginButtonActionPerformed() {
		String username = userText.getText();
		String password = String.valueOf(passwordText.getPassword());

		boolean validation = controller.validateUser(username, password);
		System.out.println(validation);
		
		if(validation == true) {
			setVisible(false);
			SearchWindow sw = new SearchWindow(controller);
			sw.setVisible(true);
		}
	}
	
	private void registerButtonActionPerformed() {
		String username = userText.getText();
		String password = String.valueOf(passwordText.getPassword());

		boolean registration = controller.registerUser(username, password);
		System.out.println(registration);
	}

}
