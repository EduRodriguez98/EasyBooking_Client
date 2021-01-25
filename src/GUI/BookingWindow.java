package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import dto.EBFlightDTO;


/** Window to add passengers to the flight. Prince changes
*
*/
public class BookingWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Controller controller;
	
	ArrayList<String> passengers = new ArrayList<String>();
	JTextField passengerName;

	//Window java components
	private JLabel origin, destination, departureDate, price;
	private JButton gotoPayment;
	
	
	public BookingWindow(Controller controller) {
		
		this.controller = controller;
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		
		//Panel setup
		JPanel jp = new JPanel();
		jp.setLayout(null);
		
		origin = new JLabel("Origin:   " + SelectFlightWindow.selection.getOrigin());
		origin.setBounds(80, 20, 300, 40);
		destination = new JLabel("Destination:  " + SelectFlightWindow.selection.getDestination());
		destination.setBounds(80, 70, 300, 40);
		departureDate = new JLabel("Departure date:   " + SelectFlightWindow.selection.getDate());
		departureDate.setBounds(80, 120, 300, 40);
		price = new JLabel("Flight price:   " + SelectFlightWindow.selection.getPrice());
		price.setBounds(80, 170, 300, 40);

		/*
		int l,j = 0;
		seatsNum = Integer.parseInt(SearchWindow.passNumbTF.getText());
		for(int i=1; i<seatsNum+1; i++) {
			l = 220 + j;
			JLabel passengerLabel = new JLabel("Name of passenger " + i + " : ");
			passengerLabel.setBounds(10, l, 180, 25);
			passengerName = new JTextField(15);
			passengerName.setBounds(170, l, 150, 30);
			JButton addPassenger = new JButton("Add");
			addPassenger.setBounds(300, l, 50, 25);
			addPassenger.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					passengers.add(passengerName.getText());
				}
			});
			
			jp.add(passengerLabel);
			jp.add(passengerName);
			jp.add(addPassenger);
			j = j+50;
		}
		*/
		
		JLabel passengerLabel = new JLabel("Name of passenger: ");
		passengerLabel.setBounds(10, 220, 180, 25);
		passengerName = new JTextField(15);
		passengerName.setBounds(170, 220, 150, 30);
		JButton addPassenger = new JButton("Add");
		addPassenger.setBounds(350, 220, 100, 30);
		addPassenger.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				passengers.add(passengerName.getText());
				if(passengers.size() == Integer.parseInt(SearchWindow.passNumbTF.getText())) {
					JOptionPane.showMessageDialog(null, "You added all the passengers");
				}
			}
		});
		
		jp.add(passengerLabel);
		jp.add(passengerName);
		jp.add(addPassenger);
		
		
		gotoPayment = new JButton("Book");
		gotoPayment.setBounds(170, 300, 120, 22);
		gotoPayment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Add functionality to switch windows
				gotoPaymentActionPerformed();
			}
		});
		
		//Add content to panels and panel to container
		jp.add(origin);
		jp.add(destination);
		jp.add(departureDate);
		jp.add(price);
		jp.add(gotoPayment);
			
		cp.add(jp);
		
		//Container - Window properties
		this.setSize(500, 400);
		this.setTitle("Introduce booking details");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void gotoPaymentActionPerformed() {
		String username = LoginWindow.userText.getText();
		EBFlightDTO flight = SelectFlightWindow.selection;
		int numSeats = passengers.size();
		controller.bookFlight(username, flight, numSeats, passengers);
		
		setVisible(false);
		PaymentWindow pw = new PaymentWindow(controller);
		pw.setVisible(true);
	}

}
