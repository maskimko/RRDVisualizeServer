package RRDtools;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

public class RRDServer extends UnicastRemoteObject implements
		RRDServerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5356175385871958571L;
	private String description = "Some description";

	protected RRDServer() throws RemoteException {
	};

	/**
	 * @param args
	 *            you can specify port in first argument
	 */
	public static void main(String[] args) {
		Registry registry = null;
		RRDServerInterface rrdServerStub = null;
		try {
			RRDServer rrdsrv = new RRDServer();
			//rrdsrv.setDescription("RRD files processing server");
			
			try {
			rrdServerStub = (RRDServerInterface) UnicastRemoteObject
					.exportObject(rrdsrv, 0);
			} catch (ExportException eex) {
				UnicastRemoteObject.unexportObject(rrdsrv, true);
				rrdServerStub = (RRDServerInterface) UnicastRemoteObject
						.exportObject(rrdsrv, 0);
			}
			registry = LocateRegistry.getRegistry();
			
			if (rrdServerStub != null) {
				registry.bind("RRDServer", rrdServerStub);
				System.err.println("RRD Server is ready");
			} else {
				System.out.println("Stub has not been created");
			}
			

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
/*
	@Override
	public void registerRRDp(String nameLookup, String basedir)
			throws RemoteException, IOException, AlreadyBoundException {
		RRDp rrdProcessor = new RRDp(basedir);
		Registry procReg = LocateRegistry.getRegistry();
		procReg.bind(nameLookup, rrdProcessor);
	}

	@Override
	public void registerRRDp(String nameLookup, String basedir,
			String cachedAddress) throws RemoteException, IOException,
			AlreadyBoundException {
		RRDp rrdProcessor = new RRDp(basedir, cachedAddress);
		Registry procReg = LocateRegistry.getRegistry();
		procReg.bind(nameLookup, rrdProcessor);
	}

	@Override
	public void RRDp(String nameLookup, String host, int port)
			throws RemoteException, IOException, AlreadyBoundException {
		RRDp rrdProcessor = new RRDp(host, port);
		Registry procReg = LocateRegistry.getRegistry();
		procReg.bind(nameLookup, rrdProcessor);
	}
*/

	public String getDescription() {
		return this.description;
	}


	public void setDescription(String descr) {
		this.description = descr;
	}
}
