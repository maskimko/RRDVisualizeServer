package test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMITestServer implements RMITestInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RMITestServer() {};
	
	@Override
	public String getString() {
		
		return "It works";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RMITestServer rts = new RMITestServer();
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
		RMITestInterface rtStub = (RMITestInterface) UnicastRemoteObject.exportObject(rts, 0);
		Registry reg = LocateRegistry.getRegistry();
		reg.bind("test1", rtStub);
		System.out.println("OKAY!");
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}

}
