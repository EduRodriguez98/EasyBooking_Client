package remote;

import java.util.HashMap;

import remote.IEasyBookingManager;

public class ServiceLocator {
	
	private IEasyBookingManager service;
	public HashMap<String, IEasyBookingManager> serviceMap = new HashMap<String, IEasyBookingManager>();
	
	public ServiceLocator() { 
	    
    }
	
	public void setService(String[] args) {
		// args[0] -> ip	args[1] -> port 	args[2] -> serviceName
		
		//Check if we have the service already saved 
    	if(serviceMap.containsKey(args[2])){
    		service = serviceMap.get(args[2]); 
    		
    	} else {
    		try {
    			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
    			serviceMap.put(args[2], (IEasyBookingManager) java.rmi.Naming.lookup(name));
    			service = serviceMap.get(args[2]);
    			
    			System.out.println("Service OK.");

    		} catch (Exception e) {
    			System.out.println("Error trying to set Service.");
    		}
    	}
		
	}
    
	
	public IEasyBookingManager getService() {
		return service;
	}

}
