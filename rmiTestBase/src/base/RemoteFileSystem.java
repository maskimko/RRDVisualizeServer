package base;

/*
 * RemoteFileSystem.java
 *
 * Created on 13 May 2007, 14:39
 */

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.Icon;

/**
 * 
 * @author Esmond Pitt
 */
public interface RemoteFileSystem extends Remote {
	File createFileObject(String path) throws RemoteException;

	File[] getFiles(File dir, boolean useFileHiding) throws RemoteException;

	File createFileObject(File dir, String filename) throws RemoteException;

	File getChild(File parent, String fileName) throws RemoteException;

	boolean isFloppyDrive(File dir) throws RemoteException;

	boolean isFileSystemRoot(File dir) throws RemoteException;

	boolean isFileSystem(File f) throws RemoteException;

	boolean isDrive(File dir) throws RemoteException;

	boolean isComputerNode(File dir) throws RemoteException;

	File createNewFolder(File containingDir) throws RemoteException,
			IOException;

	File getParentDirectory(File dir) throws RemoteException;

	String getSystemDisplayName(File f) throws RemoteException;

	Icon getSystemIcon(File f) throws RemoteException;

	String getSystemTypeDescription(File f) throws RemoteException;

	File getDefaultDirectory() throws RemoteException;

	File getHomeDirectory() throws RemoteException;

	File[] getRoots() throws RemoteException;

	// File createFileSystemRoot(File f) throws RemoteException;

	boolean isHiddenFile(File f) throws RemoteException;

	boolean isParent(File folder, File file) throws RemoteException;

	boolean isRoot(File f) throws RemoteException;

	Boolean isTraversable(File f) throws RemoteException;

}