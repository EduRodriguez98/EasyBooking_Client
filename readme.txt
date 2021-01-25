Execution steps
1. ant build for compilation
2. ant client for launching the client

Login window will appear, where the user should introduce sign in details (email and password).
Default user in Google: 
users.put("mireya.quintana@opendeusto.es", "1111");

If the user is not registered, registration must be done. Once the user is registered and login details
are correct searching flights process comes on. 

In the search window, the user must introduce the origin, destination, date and number of seats to 
get the available flights. 
Default flight in Vueling: 
Flight flight1 = new Flight("VY1101", "Bilbao", "Madrid", "30-01-2021", 45);

If the user searches for this flight, it should be shown in the select flight window. Otherwise,
Vueling server will show a message that says there are no available flights and consequently an error
in the client.

After selecting the flight, names of all passengers must be added (including the one making the reservation).
Press "Book" button and the reservation will be stored in the EasyBooking database. You can check that the 
reservation has been correctly saved in the workbench.

Finally, payment must be done. There is one PayPal user inserted by default. If the email and the password
are correct, payment will be successfully completed. Otherwise, it will be rejected.