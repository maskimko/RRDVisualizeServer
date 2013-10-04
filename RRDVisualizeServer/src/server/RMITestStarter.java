package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import base.RMITestInterface;
import base.RmiStarter;

public class RMITestStarter extends RmiStarter{

	public static Registry registry;
	
	public RMITestStarter() {
		super(RMITestInterface.class);
		
	}

	@Override
	public void doCustomRmiHandling() {
		try {
		RMITestInterface engine = new RMITest() ;
		UnicastRemoteObject.unexportObject(engine, false);
		RMITestInterface engineStub = (RMITestInterface) UnicastRemoteObject.exportObject(engine, 0);
		registry  = LocateRegistry.createRegistry(2099);
		registry.rebind("testserver", engineStub);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		new RMITestStarter();
	}

}
