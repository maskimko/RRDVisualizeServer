package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

/**
 * 
 * @author Esmond Pitt
 * @version $Revision: 4 $
 */
public class RemoteFileSystemViewSimple extends FileSystemView {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private RemoteFileSystem fs;

	public RemoteFileSystemViewSimple(String host) throws NotBoundException,
			RemoteException, MalformedURLException {
		String url = "rmi://" + host + "/" + RemoteFileSystem.class.getName();
		this.fs = (RemoteFileSystem) Naming.lookup(url);
		logger.log(Level.INFO, "Connected to {0} via {1}", new Object[] { url,
				fs });
	}

	public RemoteFileSystemViewSimple(RemoteFileSystem rfs) throws RemoteException {
		fs = rfs;
		logger.log(Level.INFO, "Connected to {0}", new Object[] { rfs });
	}

	public File createFileObject(String path) {
		logger.entering(this.getClass().getName(), "createFileObject", path);
		try {
			return fs.createFileObject(path);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "path=" + path, exc);
			return null;
		}
	}

	public File[] getFiles(File dir, boolean useFileHiding) {
		logger.entering(this.getClass().getName(), "getFiles", new Object[] {
				dir, useFileHiding });
		try {
			return fs.getFiles(dir, useFileHiding);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "dir=" + dir + " useFileHiding="
					+ useFileHiding, exc);
			return null;
		}
	}

	public File createFileObject(File dir, String filename) {
		logger.entering(this.getClass().getName(), "createFileObject",
				new Object[] { dir, filename });
		try {
			return fs.createFileObject(dir, filename);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "dir=" + dir + " filename=" + filename,
					exc);
			return null;
		}
	}

	public File getChild(File parent, String fileName) {
		logger.entering(this.getClass().getName(), "getChild", new Object[] {
				parent, fileName });
		try {
			return fs.getChild(parent, fileName);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "parent=" + parent + " fileName="
					+ fileName, exc);
			return null;
		}
	}

	public boolean isFloppyDrive(File dir) {
		logger.entering(this.getClass().getName(), "isFloppyDrive", dir);
		try {
			return fs.isFloppyDrive(dir);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "dir=" + dir, exc);
			return false;
		}
	}

	public boolean isFileSystemRoot(File dir) {
		logger.entering(this.getClass().getName(), "isFileSystemRoot", dir);
		try {
			return fs.isFileSystemRoot(dir);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "dir=" + dir, exc);
			return false;
		}
	}

	public boolean isFileSystem(File file) {
		logger.entering(this.getClass().getName(), "isFileSystem", file);
		try {
			return fs.isFileSystem(file);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "file=" + file, exc);
			return false;
		}
	}

	public boolean isDrive(File dir) {
		logger.entering(this.getClass().getName(), "isDrive", dir);
		try {
			return fs.isDrive(dir);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "dir=" + dir, exc);
			return false;
		}
	}

	public boolean isComputerNode(File dir) {
		logger.entering(this.getClass().getName(), "isComputerNode", dir);
		try {
			return fs.isComputerNode(dir);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "dir=" + dir, exc);
			return false;
		}
	}

	public File createNewFolder(File containingDir) throws IOException {
		logger.entering(this.getClass().getName(), "createNewFolder",
				containingDir);
		try {
			return fs.createNewFolder(containingDir);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "containingDir=" + containingDir, exc);
			return null;
		}
	}

	public File getParentDirectory(File dir) {
		logger.entering(this.getClass().getName(), "getParentDirectory", dir);
		try {
			return fs.getParentDirectory(dir);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "dir=" + dir, exc);
			return null;
		}
	}

	public String getSystemDisplayName(File file) {
		logger.entering(this.getClass().getName(), "getSystemDisplayName", file);
		try {
			return fs.getSystemDisplayName(file);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "file=" + file, exc);
			return null;
		}
	}

	public Icon getSystemIcon(File file) {
		logger.entering(this.getClass().getName(), "getSystemIcon", file);
		try {
			return fs.getSystemIcon(file);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "file=" + file, exc);
			return null;
		}
	}

	public String getSystemTypeDescription(File file) {
		logger.entering(this.getClass().getName(), "getSystemTypeDescription",
				file);
		try {
			return fs.getSystemTypeDescription(file);
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "file=" + file, exc);
			return null;
		}
	}

	public File getDefaultDirectory() {
		logger.entering(this.getClass().getName(), "getDefaultDirectory");
		try {
			return fs.getDefaultDirectory();
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "getDefaultDirectory()", exc);
			return null;
		}
	}

	public File getHomeDirectory() {
		logger.entering(this.getClass().getName(), "getHomeDirectory");
		try {
			return fs.getHomeDirectory();
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "getHomeDirectory()", exc);
			return null;
		}
	}

	public File[] getRoots() {
		logger.entering(this.getClass().getName(), "getRoots");
		try {
			return fs.getRoots();
		} catch (RemoteException exc) {
			logger.log(Level.SEVERE, "getRoots()", exc);
			return null;
		}
	}

	protected File createFileSystemRoot(File file) {
		logger.entering(this.getClass().getName(), "createFileSystemRoot", file);
		logger.log(Level.SEVERE, "createFileSystemRoot called with ({0})",
				new Object[] { file });
		/*
		 * try { return fs.createFileSystemRoot(file); } catch (RemoteException
		 * exc) { logger.log(Level.SEVERE, "", exc); }
		 */
		return null;
	}

	public static FileSystemView getFileSystemView() {
		RemoteFileSystem rfs = null;
		Registry regstr = null;
		RemoteFileSystemViewSimple rfsv = null;
		try {
			regstr = LocateRegistry.getRegistry("rcu8.sdab.sn", 2099);
			rfs = (RemoteFileSystem) regstr.lookup("RemoteFileSystem");
			rfsv = new RemoteFileSystemViewSimple(rfs);
		} catch (AccessException e) {

			e.printStackTrace();
		} catch (RemoteException e) {

			e.printStackTrace();
		} catch (NotBoundException e) {

			e.printStackTrace();
		}

		return rfsv;
	}

	/*
	 * public boolean isHiddenFile(File f) { boolean isHid = false; try { isHid
	 * = fs.isHiddenFile(f); } catch (RemoteException re) {
	 * re.printStackTrace(); } return isHid; }
	 * 
	 * public boolean isParent(File folder, File file) { boolean isPa = false;
	 * try { fs.isParent(folder, file); } catch (RemoteException re ) {
	 * re.printStackTrace(); } return isPa; };
	 * 
	 * public boolean isRoot(File f) { boolean isR = false; try { fs.isRoot(f);
	 * } catch (RemoteException re) { re.printStackTrace(); } return isR; };
	 * 
	 * public Boolean isTraversable(File f) { Boolean isTra = new
	 * Boolean(false); try { fs.isTraversable(f); } catch (RemoteException re) {
	 * re.printStackTrace(); } return isTra; };
	 */

}