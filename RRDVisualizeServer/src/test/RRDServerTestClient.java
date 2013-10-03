package test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RRDtools.RRDServerInterface;

public class RRDServerTestClient {

	
	private RRDServerTestClient() {}
	
	/**
	 * @param args First argument can point on remote host 
	 */
	public static void main(String[] args) {
		String host  = (args.length < 1) ? null : args[0];
		try {
			Registry registry =  LocateRegistry.getRegistry(host);
			RRDServerInterface rrdServerStub = (RRDServerInterface) registry.lookup("RRDServer");
			String rrdDescr = rrdServerStub.getDescription();
			System.out.println(rrdDescr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
