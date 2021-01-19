package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

import elements.Flight;
import elements.Pasajero;
import elements.Reservation;

/** Window for the payment process. Booking complete if process is correct, error if there are problems.
*
*/
public class PaymentWindow extends JFrame {
	
	private JTextField text;
	private JLabel name;
	private JButton JAñadirP;
	public static String  nombre;
	private static Reservation reservation;	
		
	//People on the Flight
	public PaymentWindow(Reservation reservation) {
		this.reservation = reservation;
		setTitle("RESERVATION");
		setSize(333, 220);
		setLocation(166, 110);
		
//		panel_fondo = new PanelConImagenFondo();
//		panel_fondo.setImage(fondo);
//		panel_fondo.setOpaque(false);
//		setContentPane(panel_fondo);
//		setLayout(new BorderLayout());
		crearPaneles();
		crear();
//		crearBotones();
	}
	
	public void crearPaneles() {
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize( new Dimension( 333, 71 ));
		panel_1.setOpaque(false);
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize( new Dimension( 77, 1 ));
		panel_2.setOpaque(false);
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize( new Dimension( 333, 71 ));
		panel_3.setOpaque(false);
		JPanel panel_4= new JPanel();
		panel_4.setPreferredSize( new Dimension( 177, 5 ));
		panel_4.setOpaque(false);
		add(panel_1, BorderLayout.NORTH);
		add(panel_3, BorderLayout.SOUTH);
		add(panel_2, BorderLayout.EAST);
		add(panel_4, BorderLayout.WEST);
		
	}
	
	public void crear() {

		text = new JTextField(15);
		text.setBounds(85, 70, 80, 30);
		add(text);
		
	}
}
