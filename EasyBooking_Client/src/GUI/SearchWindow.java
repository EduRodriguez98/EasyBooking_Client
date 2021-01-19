package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import elements.Flight;
import elements.Pasajero;
import elements.Reservation;

public class SearchWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//Window java components
	private JLabel originLB, destinationLB, dateLB, passNumbLB ;
	private JTextField originTF, destinationTF, dateTF, passNumbTF;
	private JButton searchBtn;
	
	public SearchWindow() {
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		
		//Panel setup
		JPanel principal = new JPanel();
		principal.setLayout(null);
		
		
		originLB = new JLabel("Origin");
		originLB.setBounds(20, 20, 100, 40);
		originTF = new JTextField(15);
		originTF.setBounds(170, 20, 200, 30);
		
		destinationLB = new JLabel("Destination");
		destinationLB.setBounds(20, 70, 100, 40);
		destinationTF = new JTextField(15);
		destinationTF.setBounds(170,70,200, 30);
		
		dateLB = new JLabel("Date");
		dateLB.setBounds(20, 120, 100, 40);
		dateTF = new JTextField(15);
		dateTF.setBounds(170, 120, 200, 30);
		
		passNumbLB = new JLabel("Number of Passengers");
		passNumbLB.setBounds(20, 170, 140, 40);
		passNumbTF = new JTextField(15);
		passNumbTF.setBounds(170, 170, 200, 30);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(170, 240, 120, 22);
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Add functionality to switch windows
				
			}
		});
		
		
		//Add content to panels and panel to container
		principal.add(originLB);
		principal.add(originTF);
		principal.add(destinationLB);
		principal.add(destinationTF);
		principal.add(dateLB);
		principal.add(dateTF);
		principal.add(passNumbLB);
		principal.add(passNumbTF);
		principal.add(searchBtn);
		
		cp.add(principal);
		
		//Container - window properties
		this.setSize(480, 320);
		this.setTitle("Search for a Flight");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
public static void main(String[] args) {
	
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			new SearchWindow();
			
		}
	});
	}
}
	
	
	
	
