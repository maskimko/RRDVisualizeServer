package base;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMITestInterface extends Remote {
	
	public String doSomething() throws RemoteException;
	
	public String getCurrentPath() throws RemoteException;
	public File getCurrentFile() throws RemoteException;
	public File[] getDirectoryListing() throws RemoteException;
	public File[] getDirectoryListing(String dirPath) throws RemoteException;
	public File[] getDirectoryListing(File directory) throws RemoteException;

}
