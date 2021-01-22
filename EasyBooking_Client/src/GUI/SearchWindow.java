package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import dto.EBFlightDTO;

public class SearchWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Controller controller;
	
	//Window java components
	private JLabel originLB, destinationLB, dateLB, passNumbLB ;
	private JTextField originTF, destinationTF, dateTF, passNumbTF;
	private JButton searchBtn;
	
	static ArrayList<EBFlightDTO> search;
	
	public SearchWindow(Controller controller) {
		this.controller = controller;
		
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
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(170, 240, 120, 22);
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchBtnActionPerformed();
				
			}
		});
		
		
		//Add content to panels and panel to container
		principal.add(originLB);
		principal.add(originTF);
		principal.add(destinationLB);
		principal.add(destinationTF);
		principal.add(dateLB);
		principal.add(dateTF);
		principal.add(searchBtn);
		
		cp.add(principal);
		
		//Container - window properties
		this.setSize(480, 320);
		this.setTitle("Search for a flight");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void searchBtnActionPerformed() {
		String origin = originTF.getText();
		String destination = destinationTF.getText();
		String date = dateTF.getText();
		
		search = controller.searchFlights(origin, destination, date);
		
		if(search.size() != 0) {
			// REVISAR
			System.out.println("Showing flights...");
			for(EBFlightDTO f : search) {
				System.out.println(f.getOrigin() + ", " + f.getDestination() + ", " + f.getDate());
			}
			setVisible(false);
			SelectFlightWindow sf = new SelectFlightWindow(controller);
			sf.setVisible(true);
		}
	}
	
}
	
	
