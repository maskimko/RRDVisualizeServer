package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import base.RMITestInterface;

public class RMITest extends UnicastRemoteObject implements RMITestInterface{

	




	protected RMITest() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	public String doSomething() throws RemoteException{
		return "something is done!";
	}
	

}
