package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import GUI.LoginWindow;
import GUI.SearchWindow;
import remote.ServiceLocator;
import dto.EBFlightDTO;

public class Controller {
	
	private ServiceLocator rsl;
	
	public Controller(String[] args) throws RemoteException {
		rsl = new ServiceLocator();
		rsl.setService(args[0], args[1], args[2]); // ip, port, serviceName
		new LoginWindow(this);
		//new SearchWindow(this);
	}
	
	public boolean validateUser(String username, String password) {
    	boolean validation = false; 
		
    	try {
    		validation = rsl.getService().validateUser(username, password);
    	} catch (Exception e){
    		System.err.println("Error trying to identify the user.");
    	}
    	return validation;
    }
	
	
	public boolean registerUser(String username, String password) { 
		boolean registration = false;
	 
		try { 
			registration = rsl.getService().registerUser(username, password); 
		} catch (Exception e){ 
			System.err.println("Error trying to register the user."); 
		} 
		return registration; 
	}
	 
	 
	public ArrayList<EBFlightDTO> searchFlights(String origin, String destination, String date) { 
		ArrayList<EBFlightDTO> flights = new ArrayList<EBFlightDTO>();
	 
		try { 
			flights = rsl.getService().searchFlights(origin, destination, date); 
		}
		catch (Exception e) { 
			System.err.println("Error trying to search flights.");
		} 
		return flights; 
	}
	 
	 /*
	 * public boolean bookFlight(String username, FlightDTO flight, int numSeats,
	 * ArrayList<String> passengers, String date) { boolean reservation = false;
	 * 
	 * try { rsl.getService().bookFlight(username, flight, numSeats, passengers,
	 * date); } catch (Exception e) {
	 * System.err.println("Error trying to book the flight."); } return reservation;
	 * }
	 */

	 public static void main(String[] args) throws RemoteException {    	
	    	new Controller(args);
	 }
}
