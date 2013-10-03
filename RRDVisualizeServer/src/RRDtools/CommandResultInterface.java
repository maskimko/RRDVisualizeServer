package RRDtools;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.TreeSet;

public interface CommandResultInterface extends Remote, Serializable {
	float user = 0;
    float system = 0;
    float total = 0;
    public boolean ok = false;
    public String error = null;
  
    
    ArrayList<String> names = null;
    
    public void setFieldNames(String[] fields) throws RemoteException;
    public void addFieldName(String fname)throws RemoteException;
    
    public float getUser() throws RemoteException;

	public float getSystem() throws RemoteException;

	public float getTotal() throws RemoteException;

	public boolean isOk() throws RemoteException;

	public String getError() throws RemoteException;

	//public void setOutput(String output)throws Exception;
	//public void setOutput(StringBuffer sb) throws Exception;
	
	public String getOutput() throws RemoteException;
	
	
	public TreeSet<RRDRR> getOutputObject() throws RemoteException;



    public String toString() ; 
}
