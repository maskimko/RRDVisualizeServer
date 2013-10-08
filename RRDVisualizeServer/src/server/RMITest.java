package server;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import base.RMITestInterface;

public class RMITest extends UnicastRemoteObject implements RMITestInterface{

	

	public RMITest(int port) throws RemoteException {
		super(port);
	}


	public RMITest() throws RemoteException {
		super();
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	public String doSomething() throws RemoteException{
		return "something is done!";
	}



	@Override
	public String getCurrentPath() throws RemoteException {		
		String path = System.getProperty("user.dir");
		return path;
	}



	@Override
	public File[] getDirectoryListing() throws RemoteException {
		return getDirectoryListing(System.getProperty("user.dir"));
	}



	@Override
	public File[] getDirectoryListing(String dirPath) throws RemoteException {
		return getDirectoryListing(new File(dirPath));
	}



	@Override
	public File[] getDirectoryListing(File directory) throws RemoteException {
		File[] fList = null;
		File curDir = directory;
		if (curDir.canRead()) {
			fList = curDir.listFiles();
		} else {
			throw new RemoteException("Error: Cannot read file " + curDir.getAbsolutePath());
		}
		
		return fList;
	}



	@Override
	public File getCurrentFile() throws RemoteException {
		File curFile = new File(System.getProperty("user.dir"));
		return curFile;
	}
	

}
