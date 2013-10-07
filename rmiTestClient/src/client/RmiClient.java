package client;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import base.RMITestInterface;
import base.RmiStarter;

public class RmiClient extends RmiStarter {

	private RMITestInterface engine = null;
	
	public RmiClient() {
		super(RMITestInterface.class);
	}

	private void listDir() throws RemoteException{
		File[] fList = engine.getDirectoryListing();
		for (int i = 0; i < fList.length; i++) {
			System.out.println("File: " + fList[i]);
		}
	}
	
	private void listDir(String path) throws RemoteException {
		File[] fList = engine.getDirectoryListing(path);
		for (int i = 0; i < fList.length; i++) {
			System.out.println("File: " + fList[i]);
		}
	}
	
	@Override
	public void doCustomRmiHandling() {
		try {
		Registry registry = LocateRegistry.getRegistry(2099);
		engine = (RMITestInterface) registry.lookup("testserver");
		System.out.println(engine.doSomething());
		listDir();
		listDir("d:\\transfer");

		} catch (Exception e ) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RmiClient rc = new RmiClient();
		
	}
	

}
