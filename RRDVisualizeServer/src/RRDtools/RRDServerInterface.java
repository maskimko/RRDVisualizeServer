package RRDtools;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RRDServerInterface extends Remote, Serializable {

	/**
	 * 
	 * @param nameLookup
	 *            Lookup name for RMIRegistry
	 * @param basedir
	 *            Base directory where rrdtool daemon operates
	 * @throws RemoteException
	 *             Usual RMI Exception
	 * @throws IOException
	 *             IOExceptions which can be caused when operates on rrd files
	 */
//	void registerRRDp(String nameLookup, String basedir)
//			throws RemoteException, IOException, AlreadyBoundException;

	/**
	 * 
	 * @param nameLookup
	 *            Lookup name for RMIRegistry
	 * @param basedir
	 *            Base directory where rrdtool daemon operates
	 * @param cachedAddress
	 *            RRDCached address
	 * @throws RemoteException
	 *             Usual RMI Exception
	 * @throws IOException
	 *             IOExceptions which can be caused when operates on rrd files
	 */
//	void registerRRDp(String nameLookup, String basedir, String cachedAddress)
//			throws RemoteException, IOException, AlreadyBoundException;

	/**
	 * 
	 * @param nameLookup
	 *            Lookup name for RMIRegistry
	 * @param host
	 *            Host address where rrdtool daemon operates
	 * @param port
	 *            Port on which rrdtool daemon operates
	 * @throws RemoteException
	 *             Usual RMI Exception
	 * @throws IOException
	 *             IOExceptions which can be caused when operates on rrd files
	 */
//	void RRDp(String nameLookup, String host, int port) throws RemoteException,
//			IOException, AlreadyBoundException;

	/**
	 * 
	 * @return Returns description of this server 
	 */
	public String getDescription() throws RemoteException;
	/**
	 * 
	 * @param descr String with a description
	 */
	public void setDescription(String descr) throws RemoteException;
}
