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
	
	final JList<String> paneList;
	
	static EBFlightDTO selection;
	ArrayList<EBFlightDTO> flights;
	
	public SelectFlightWindow(Controller controller) {
		this.controller = controller;
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		
		//Panel setup
		JPanel panelSelect = new JPanel();
		panelSelect.setLayout(null);

		
		final DefaultListModel<String> model = new DefaultListModel<String>();
		
		// Add flights to model
		flights = SearchWindow.search; 
		for(EBFlightDTO f : flights) { 
			model.addElement(f.getOrigin() + ", " + f.getDestination() + ", " + f.getDate() + ", " + f.getPrice()); 
			//model.addElement(f.toString());
		}

		
		paneList = new JList<String>(model);
		
		scrollpane = new JScrollPane(paneList);
		scrollpane.setBounds(30, 30, 410, 180);
		
		
		selectBtn = new JButton("Select");
		selectBtn.setBounds(170, 240, 120, 22);
		
		selectBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Add functionality for switching windows
				selectBtnActionPerformed();
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
	
	
	private void selectBtnActionPerformed() {
		int index = paneList.getSelectedIndex();
		//selection = paneList.getModel().getElementAt(index);
		selection = flights.get(index);
		System.out.println("The selected flight is: " + selection.getOrigin() + ", " + selection.getDestination() + ", " + selection.getDate());
	
		// Proceed booking
		setVisible(false);
		BookingWindow bw = new BookingWindow(controller);
		bw.setVisible(true);
	}
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * SelectFlightWindow sf = new SelectFlightWindow(); sf.setVisible(true); }
	 */
}
