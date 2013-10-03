package RRDtools;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.TreeSet;

public interface RRDProcessorInterface extends Remote, Serializable {

	TreeSet<RRDRR> executeCommand(String cmd[]) throws RemoteException, Exception;
	 
	
}
