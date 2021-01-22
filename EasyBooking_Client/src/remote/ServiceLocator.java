package remote;

import java.util.HashMap;
import remote.IEasyBookingManager;

public class ServiceLocator {
	
	private IEasyBookingManager service;
	public HashMap<String, IEasyBookingManager> serviceMap = new HashMap<String, IEasyBookingManager>();
	
	public ServiceLocator() { 
	    
    }
	
	 public void setService(String ip, String port, String serviceName) {    
	    	// Add your code to get the TARGET reference HERE 
	    	
	    	//Check if we have the service already saved 
	    	if(serviceMap.containsKey(serviceName)){
	    		service = serviceMap.get(serviceName); 
	    		
	    	} else {
	    		try {
	        		String name = "//" + ip + ":" + port + "/" + serviceName;
	            	serviceMap.put(serviceName, (IEasyBookingManager) java.rmi.Naming.lookup(name));
	            	service = serviceMap.get(serviceName);
	        	} catch (Exception e) {
	    			System.err.println("- Exception running the client: " + e.getMessage());
	        	}
	    	}
	    	
	    }
    
	
	public IEasyBookingManager getService() {
		return service;
	}

}
