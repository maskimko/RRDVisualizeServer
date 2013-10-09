package server;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

import base.RemoteFileSystem;

/**
 * 
 * @author Esmond Pitt
 * @version $Revision: 3 $
 */
public class RemoteFileSystemServer extends UnicastRemoteObject implements
		RemoteFileSystem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileSystemView fs = FileSystemView.getFileSystemView();
	private Logger logger = Logger.getLogger(this.getClass().getName());

	/** Creates a new instance of RemoteFileSystemServer */
	public RemoteFileSystemServer(int port) throws RemoteException {
		super(port);
		logger.log(Level.INFO,
				"exported on port {0} and receiving calls fs={1}",
				new Object[] { port, fs });
	}
	
	public RemoteFileSystemServer() throws RemoteException {
		super();
		logger.log(Level.INFO, "exported on default port and receiving calls fs={0}", new Object[] { fs});
		
	}

	public File createFileObject(String path) {
		logger.log(Level.FINE, "createFileObject({0})", path);
		return fs.createFileObject(path);
	}

	public File createFileObject(File dir, String filename) {
		logger.log(Level.FINE, "createFileObject({0},{1})", new Object[] { dir,
				filename });
		return fs.createFileObject(dir, filename);
	}

	public File[] getFiles(File dir, boolean useFileHiding) {
		logger.log(Level.FINE, "getFiles({0},{1})", new Object[] { dir,
				useFileHiding });
		return fs.getFiles(dir, useFileHiding);
	}

	public File getChild(File parent, String fileName) {
		logger.log(Level.FINE, "getChild({0},{1})", new Object[] { parent,
				fileName });
		return fs.getChild(parent, fileName);
	}

	public boolean isFloppyDrive(File dir) {
		logger.log(Level.FINE, "isFloppyDrive({0})", dir);
		return fs.isFloppyDrive(dir);
	}

	public boolean isFileSystemRoot(File dir) {
		logger.log(Level.FINE, "isFileSystemRoot({0})", dir);
		return fs.isFileSystemRoot(dir);
	}

	public boolean isFileSystem(File f) {
		logger.log(Level.FINE, "isFileSystem({0})", f);
		return fs.isFileSystem(f);
	}

	public boolean isDrive(File dir) {
		logger.log(Level.FINE, "isDrive({0})", dir);
		return fs.isDrive(dir);
	}

	public boolean isComputerNode(File dir) {
		logger.log(Level.FINE, "isComputerNode({0})", dir);
		return fs.isComputerNode(dir);
	}

	public File createNewFolder(File containingDir) throws IOException {
		logger.log(Level.FINE, "createNewFolder({0})", containingDir);
		return fs.createNewFolder(containingDir);
	}

	public File getParentDirectory(File dir) {
		logger.log(Level.FINE, "getParentDirectory({0})", dir);
		return fs.getParentDirectory(dir);
	}

	public String getSystemDisplayName(File f) {
		logger.log(Level.FINE, "getSystemDisplayName({0})", f);
		return fs.getSystemDisplayName(f);
	}

	public Icon getSystemIcon(File f) {
		logger.log(Level.FINE, "getSystemIcon({0})", f);
		return fs.getSystemIcon(f);
	}

	public String getSystemTypeDescription(File f) {
		logger.log(Level.FINE, "getSystemTypeDescription({0})", f);
		return fs.getSystemTypeDescription(f);
	}

	public File getDefaultDirectory() {
		logger.log(Level.FINE, "getDefaultDirectory()");
		return fs.getDefaultDirectory();
	}

	public File getHomeDirectory() {
		logger.log(Level.FINE, "getHomeDirectory()");
		return fs.getHomeDirectory();
	}

	public File[] getRoots() {
		logger.log(Level.FINE, "getRoots()");
		return fs.getRoots();
	}

	/*
	 * public File createFileSystemRoot(File f) { return
	 * fs.createFileSystemRoot(f); }
	 */

}