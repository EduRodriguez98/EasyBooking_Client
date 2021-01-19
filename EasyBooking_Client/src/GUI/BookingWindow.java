package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

import elements.Airline;
import elements.Airport;
import elements.Flight;
import elements.User;
import elements.Reservation;


/** Window to add passengers to the flight. Prince changes
*
*/
public class BookingWindow extends JFrame{
	

	//Window java components
	private JLabel origin, destination, Ddate, Adate ;
	private JButton gotoPayment;
	
	
	public BookingWindow(Flight flight, int passNumb) {
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		
		//Panel setup
		JPanel jp = new JPanel();
		jp.setLayout(null);
		
		origin = new JLabel("Origin airport:   " + flight.originA.name);
		origin.setBounds(80, 20, 300, 40);
		destination = new JLabel("Destination airport:  " + flight.destinationA.name);
		destination.setBounds(80, 70, 300, 40);
		Ddate = new JLabel("Departure date:   " + flight.departure_date);
		Ddate.setBounds(80, 120, 300, 40);
		Adate = new JLabel("Arrival date:   " + flight.arrival_date);
		Adate.setBounds(80, 170, 300, 40);

		int l,j = 0;
		for(int i=1; i<passNumb+1; i++) {
			l = 220 + j;
			JLabel userLabel = new JLabel("Passenger " + i +" name: ");
			userLabel.setBounds(10, l, 180, 25);
			JTextField userName = new JTextField(15);
			userName.setBounds(170, l, 150, 30);
			
			jp.add(userLabel);
			jp.add(userName);
			j = j+50;
		}
		
		gotoPayment = new JButton("Payment");
		gotoPayment.setBounds(170, 550, 120, 22);
		gotoPayment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Add functionality to switch windows
				
			}
		});
		
		//Add content to panels and panel to container
		jp.add(origin);
		jp.add(destination);
		jp.add(Ddate);
		jp.add(Adate);
		jp.add(gotoPayment);
			
		cp.add(jp);
		
		//Container - Window properties
		this.setSize(980, 620);
		this.setTitle("BOOKING");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
public static void main(String[] args) {
	
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			Airport oa = new Airport ("MAD", "Madrid");
			Airport da = new Airport ("LOI", "Loiu");
			Airline ai = new Airline ("IBE", "Iberia");
			Flight f = new Flight(oa, da, ai, 1, "3/3/2021", "4:30", "3/3/2021", "5:50");
			new BookingWindow(f, 3);
			
		}
	});
	}
}
