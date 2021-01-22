package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import dto.EBFlightDTO;

public class SelectFlightWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private Controller controller;
	
	//Window java components
	private JScrollPane scrollpane;
	private JButton selectBtn;
	
	public SelectFlightWindow(Controller controller) {
		this.controller = controller;
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		
		//Panel setup
		JPanel panelSelect = new JPanel();
		panelSelect.setLayout(null);

		
		final DefaultListModel<String> model = new DefaultListModel<String>();
		
		ArrayList<EBFlightDTO> flights = SearchWindow.search; 
		for(EBFlightDTO f : flights) { 
			model.addElement(f.getOrigin() + ", " + f.getDestination() + ", " + f.getDate()); 
		}
		

		final JList<String> paneList = new JList<String>(model);
		
		scrollpane = new JScrollPane(paneList);
		scrollpane.setBounds(30, 30, 410, 180);
		
		
		selectBtn = new JButton("Select");
		selectBtn.setBounds(170, 240, 120, 22);
		
		selectBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Add functionality for switching windows
				
			}
		});
		
		
		//Add content to panels and panel to container
		panelSelect.add(scrollpane);
		panelSelect.add(selectBtn);
		
		cp.add(panelSelect);
		
		
		//Container - Window properties
		this.setTitle("Select your flight");
		this.setSize(480, 320);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * SelectFlightWindow sf = new SelectFlightWindow(); sf.setVisible(true); }
	 */
}
