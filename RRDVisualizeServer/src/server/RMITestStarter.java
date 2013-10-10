package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import base.RMITestInterface;
import base.RemoteFileSystem;
import base.RemoteFileSystemView;
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
		RemoteFileSystemView rfsv = new RemoteFileSystemViewImpl();
		UnicastRemoteObject.unexportObject(engine, false);
		UnicastRemoteObject.unexportObject(rfsv, false);
		RMITestInterface engineStub = (RMITestInterface) UnicastRemoteObject.exportObject(engine, 0);
		RemoteFileSystemView rfsvStub = (RemoteFileSystemView) UnicastRemoteObject.exportObject(rfsv, 0);
		
		registry  = LocateRegistry.createRegistry(2099);
		registry.rebind("testserver", engineStub);
		registry.rebind("RemoteFileSystem", rfsvStub);
		while(true) {
			Thread.sleep(5000);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		new RMITestStarter();
		/*while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException ie){
				ie.printStackTrace();
			}
		}*/
	}

}
