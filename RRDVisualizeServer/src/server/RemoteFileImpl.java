package server;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import base.RemoteFile;

public class RemoteFileImpl extends UnicastRemoteObject implements RemoteFile {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File f;
    

    public RemoteFileImpl(File sf) throws java.rmi.RemoteException {
        f=sf;
    }
    @Override
    public boolean canRead() throws java.rmi.RemoteException {
        return f.canRead();
  
    }
	@Override
	public boolean canWrite() throws RemoteException {
		
		return f.canWrite();
	}
	@Override
	public int compareTo(File pathname) throws RemoteException {
		
		return f.compareTo(pathname);
	}
	@Override
	public boolean canExecute() throws RemoteException {
		
		return f.canExecute();
	}
	@Override
	public boolean createNewFile() throws RemoteException {
		
		try {
		return f.createNewFile();
		} catch (IOException ioe) {
			throw new RemoteException(ioe.getMessage());
		}
	}
	@Override
	public boolean delete() throws RemoteException {
				return f.delete();
	}
	@Override
	public void deleteOnExit() throws RemoteException {
		f.deleteOnExit();
		
	}
	@Override
	public boolean exists() throws RemoteException {
		
		return f.exists();
	}
	@Override
	public File getAbsoluteFile() throws RemoteException {
		
		return f.getAbsoluteFile();
	}
	@Override
	public String getAbsolutePath() throws RemoteException {

		return f.getAbsolutePath();
	}
	@Override
	public File getCanonicalFile() throws RemoteException {
		try {
			return f.getCanonicalFile();
		} catch (IOException ioe) {
			throw new RemoteException(ioe.getMessage());
		}
	}
	@Override
	public String getCanonicalPath() throws RemoteException {
		try {
			return  f.getCanonicalPath();
		} catch (IOException ioe) {
			throw new RemoteException(ioe.getMessage());
		}
	}
	@Override
	public long getFreeSpace() throws RemoteException {
		
		return f.getFreeSpace();
	}
	@Override
	public String getName() throws RemoteException {
		
		return f.getName();
	}
	@Override
	public String getParent() throws RemoteException {
		
		return f.getParent();
	}
	@Override
	public File getParentFile() throws RemoteException {
		
		return f.getParentFile();
	}
	@Override
	public String getPath() throws RemoteException {
		
		return f.getPath();
	}
	@Override
	public long getTotalSpace() throws RemoteException {
		
		return f.getTotalSpace();
	}
	@Override
	public long getUsableSpace() throws RemoteException {
	
		return f.getUsableSpace();
	}
	@Override
	public boolean isAbsolute() throws RemoteException {
		
		return f.isAbsolute();
	}
	@Override
	public boolean isDirectory() throws RemoteException {
		
		return f.isDirectory();
	}
	@Override
	public boolean isFile() throws RemoteException {
		
		return f.isFile();
	}
	@Override
	public boolean isHidden() throws RemoteException {
	
		return f.isHidden();
	}
	@Override
	public long lastModified() throws RemoteException {
		
		return f.lastModified();
	}
	@Override
	public long length() throws RemoteException {
		
		return f.length();
	}
	@Override
	public String[] list() throws RemoteException {
		return f.list();
	}
	@Override
	public String[] list(FilenameFilter filter) throws RemoteException {
		
		return f.list(filter);
	}
	@Override
	public File[] listFiles() throws RemoteException {
		
		return f.listFiles();
	}
	@Override
	public File[] listFiles(FileFilter filter) throws RemoteException {
		
		return f.listFiles(filter);
	}
	@Override
	public File[] listFiles(FilenameFilter filter) throws RemoteException {
		
		return f.listFiles(filter);
	}
	@Override
	public boolean mkdir() throws RemoteException {
		
		return f.mkdir();
	}
	@Override
	public boolean mkdirs() throws RemoteException {
		
		return f.mkdirs();
	}
	@Override
	public boolean renameTo(File dest) throws RemoteException {
		
		return f.renameTo(dest);
	}
	@Override
	public boolean setExecutable(boolean executable) throws RemoteException {
		
		return f.setExecutable(executable);
	}
	@Override
	public boolean setExecutable(boolean executable, boolean ownerOnly)
			throws RemoteException {
		
		return f.setExecutable(executable, ownerOnly);
	}
	@Override
	public boolean setLastModified(long time) throws RemoteException {
		
		return f.setLastModified(time);
	}
	@Override
	public boolean setReadable(boolean readable) throws RemoteException {
		
		return f.setReadable(readable);
	}
	@Override
	public boolean setReadable(boolean readable, boolean ownerOnly)
			throws RemoteException {
		
		return f.setReadable(readable, ownerOnly);
	}
	@Override
	public boolean setReadOnly() throws RemoteException {
		
		return f.setReadOnly();
	}
	@Override
	public boolean setWritable(boolean writable) throws RemoteException {
		
		return f.setWritable(writable);
	}
	@Override
	public boolean setWritable(boolean writable, boolean ownerOnly)
			throws RemoteException {
		
		return f.setWritable(writable, ownerOnly);
	}
	@Override
	public Path toPath() throws RemoteException {
		
		return f.toPath();
	}
	@Override
	public URI toURI() throws RemoteException {
		
		return f.toURI();
	}
	@Override
	public String gettoString() throws RemoteException{
		String name  = f.toString();
		return name;
	}
	
	
    

    
}