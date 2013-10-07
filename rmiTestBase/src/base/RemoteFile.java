package base;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.URI;
import java.nio.file.Path;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteFile extends Remote {

	public boolean canRead() throws RemoteException;

	public boolean canWrite() throws RemoteException;

	public int compareTo(File pathname) throws RemoteException;

	boolean canExecute() throws RemoteException;

	boolean createNewFile() throws RemoteException;

	boolean delete() throws RemoteException;

	void deleteOnExit() throws RemoteException;

	boolean exists() throws RemoteException;

	File getAbsoluteFile() throws RemoteException;

	String getAbsolutePath() throws RemoteException;

	File getCanonicalFile() throws RemoteException;

	String getCanonicalPath() throws RemoteException;

	long getFreeSpace() throws RemoteException;

	String getName() throws RemoteException;

	String getParent() throws RemoteException;

	File getParentFile() throws RemoteException;

	String getPath() throws RemoteException;

	long getTotalSpace() throws RemoteException;

	long getUsableSpace() throws RemoteException;

	boolean isAbsolute() throws RemoteException;

	boolean isDirectory() throws RemoteException;

	boolean isFile() throws RemoteException;

	boolean isHidden() throws RemoteException;

	long lastModified() throws RemoteException;

	long length() throws RemoteException;

	String[] list() throws RemoteException;

	String[] list(FilenameFilter filter) throws RemoteException;

	File[] listFiles() throws RemoteException;

	File[] listFiles(FileFilter filter) throws RemoteException;

	File[] listFiles(FilenameFilter filter) throws RemoteException;

	boolean mkdir() throws RemoteException;

	boolean mkdirs() throws RemoteException;

	boolean renameTo(File dest) throws RemoteException;

	boolean setExecutable(boolean executable) throws RemoteException;

	boolean setExecutable(boolean executable, boolean ownerOnly)
			throws RemoteException;

	boolean setLastModified(long time) throws RemoteException;

	boolean setReadable(boolean readable) throws RemoteException;

	boolean setReadable(boolean readable, boolean ownerOnly)
			throws RemoteException;

	boolean setReadOnly() throws RemoteException;

	boolean setWritable(boolean writable) throws RemoteException;

	boolean setWritable(boolean writable, boolean ownerOnly)
			throws RemoteException;

	Path toPath() throws RemoteException;

	URI toURI() throws RemoteException;

	

}