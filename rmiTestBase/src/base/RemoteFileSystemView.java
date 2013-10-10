package base;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.Icon;

public interface RemoteFileSystemView extends Remote {
 
    
	RemoteFile createFileObject(String path) throws RemoteException;

	String[] getFiles(File dir, boolean useFileHiding) throws RemoteException;

	RemoteFile createFileObject(File dir, String filename) throws RemoteException;

	RemoteFile getChild(File parent, String fileName) throws RemoteException;

	boolean isFloppyDrive(File dir) throws RemoteException;

	boolean isFileSystemRoot(File dir) throws RemoteException;

	boolean isFileSystem(File f) throws RemoteException;

	boolean isDrive(File dir) throws RemoteException;

	boolean isComputerNode(File dir) throws RemoteException;

	RemoteFile createNewFolder(File containingDir) throws RemoteException,
			IOException;

	RemoteFile getParentDirectory(File dir) throws RemoteException;

	String getSystemDisplayName(File f) throws RemoteException;

	Icon getSystemIcon(File f) throws RemoteException;

	String getSystemTypeDescription(File f) throws RemoteException;

	RemoteFile getDefaultDirectory() throws RemoteException;

	RemoteFile getHomeDirectory() throws RemoteException;

	String[] getRoots() throws RemoteException;

	// File createFileSystemRoot(File f) throws RemoteException;

	
	boolean isHiddenFile(File f) throws RemoteException;

	boolean isParent(File folder, File file) throws RemoteException;

	boolean isRoot(File f) throws RemoteException;

	Boolean isTraversable(File f) throws RemoteException;
}