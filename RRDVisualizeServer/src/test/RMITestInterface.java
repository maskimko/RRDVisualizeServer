package test;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMITestInterface extends Remote, Serializable {

	String getString() throws RemoteException;
}
