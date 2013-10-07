package base;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.Icon;

public interface RemoteFileSystemView extends Remote {
    
    public RemoteFile createFileObject(File dir, String filename) throws RemoteException;
    public RemoteFile createFileObject(String path) throws RemoteException;

  
    RemoteFile 	createFileSystemRoot(File f) throws RemoteException;
  
    abstract RemoteFile 	createNewFolder(File containingDir) throws RemoteException;
  
    RemoteFile 	getChild(File parent, String fileName)  throws RemoteException;
    RemoteFile 	getDefaultDirectory() throws RemoteException;
  
    RemoteFile[] 	getFiles(File dir, boolean useFileHiding) throws RemoteException;
  

    RemoteFile 	getHomeDirectory()  throws RemoteException;
    RemoteFile 	getParentDirectory(File dir) throws RemoteException;
  
    RemoteFile[] 	getRoots() throws RemoteException;
  
    String 	getSystemDisplayName(File f) throws RemoteException;
  
    Icon 	getSystemIcon(File f) throws RemoteException;
  
    String 	getSystemTypeDescription(File f) throws RemoteException;
  
    boolean 	isComputerNode(File dir) throws RemoteException;
  
    boolean 	isDrive(File dir) throws RemoteException;
  
    boolean 	isFileSystem(File f) throws RemoteException;
  
    boolean 	isFileSystemRoot(File dir) throws RemoteException;
  
    boolean 	isFloppyDrive(File dir) throws RemoteException;
  
    boolean 	isHiddenFile(File f) throws RemoteException;
  
    boolean 	isParent(File folder, File file) throws RemoteException;
  
    boolean 	isRoot(File f) throws RemoteException;
  
    Boolean 	isTraversable(File f) throws RemoteException;
}
  