package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import elements.Flight;
import elements.Pasajero;
import elements.Reservation;

public class ListFlightsWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	//Window java components
	private JScrollPane scrollpane;
	private JScrollBar scrollbar;
	private JButton selectBtn;
	private JList<String> paneList;
	
	public ListFlightsWindow() {
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		
		//Panel setup
		JPanel panelSelect = new JPanel();
		panelSelect.setLayout(null);

		
		final DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		model.addElement("testing");

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
		this.setTitle("Select a Flight");
		this.setSize(480, 320);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ListFlightsWindow();
				
			}
		});
	}
}
