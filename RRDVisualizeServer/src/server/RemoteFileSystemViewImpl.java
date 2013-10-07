package server;

import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

import base.RemoteFile;
import base.RemoteFileSystemView;

public class RemoteFileSystemViewImpl extends java.rmi.server.UnicastRemoteObject implements RemoteFileSystemView {
    
    int length;
    
    private FileSystemView fs;
    
    public RemoteFileSystemViewImpl() throws java.rmi.RemoteException {
        fs=FileSystemView.getFileSystemView();
    }
    
    public RemoteFile createFileObject(String path) throws java.rmi.RemoteException {
        return new RemoteFileImpl(fs.createFileObject(path));
    }
    
    public RemoteFile createFileObject(java.io.File dir, String filename) throws java.rmi.RemoteException {
        return new RemoteFileImpl(fs.createFileObject(dir,filename));
    }
    
    //public RemoteFileImpl createFileSystemRoot(java.io.File f) throws java.rmi.RemoteException {
    //    return new RemoteFileImpl(fs.createFileSystemRoot(f));
    // }
    
    public RemoteFile createNewFolder(java.io.File containingDir) throws java.rmi.RemoteException {
        RemoteFile tempf;
        try{
            tempf= new RemoteFileImpl(fs.createNewFolder(containingDir));
        } catch (IOException e){System.out.println(e); tempf=null;}
        return  tempf;
    }
    
    public RemoteFile getDefaultDirectory() throws java.rmi.RemoteException {
        return new RemoteFileImpl(fs.getDefaultDirectory());
    }
    
    public String[] getFiles(java.io.File dir, boolean useFileHiding) throws java.rmi.RemoteException {
        String[] tempf= new String[fs.getFiles(dir,useFileHiding).length];
        int i;
        File[] f = fs.getFiles(dir,useFileHiding);
        for(i=0;i<tempf.length;i++) tempf=f[i].toString();

return tempf;

}



public RemoteFile getHomeDirectory() throws java.rmi.RemoteException {

return new RemoteFileImpl(fs.getHomeDirectory());

}



public RemoteFile getParentDirectory(java.io.File dir) throws java.rmi.RemoteException {

return new RemoteFileImpl(fs.getParentDirectory(dir));

}



public String[] getRoots() throws java.rmi.RemoteException {

String[] tempf= new String[fs.getRoots().length];

System.out.println("fs is-"+fs.getRoots().length);

int i;

File[] f = fs.getRoots();

for(i=0;i<tempf.length;i++) {tempf[i]=f[i].toString();}

System.out.println("Roots="+tempf[0]);

return tempf;

}



public String getSystemDisplayName(java.io.File f) throws java.rmi.RemoteException {

return fs.getSystemDisplayName(f);

}



public javax.swing.Icon getSystemIcon(java.io.File f) throws java.rmi.RemoteException {

return fs.getSystemIcon(f);

}



public String getSystemTypeDescription(java.io.File f) throws java.rmi.RemoteException {

return fs.getSystemTypeDescription(f);

}



public boolean isComputerNode(java.io.File dir) throws java.rmi.RemoteException {

return fs.isComputerNode(dir);

}



public boolean isDrive(java.io.File dir) throws java.rmi.RemoteException {

return fs.isDrive(dir);

}



public boolean isFileSystem(java.io.File f) throws java.rmi.RemoteException {

return fs.isFileSystem(f);

}



public boolean isFileSystemRoot(java.io.File dir) throws java.rmi.RemoteException {

return fs.isFileSystemRoot(dir);

}



public boolean isFloppyDrive(java.io.File dir) throws java.rmi.RemoteException {

return fs.isFloppyDrive(dir);

}



public boolean isHiddenFile(java.io.File f) throws java.rmi.RemoteException {

return fs.isHiddenFile(f);

}



public boolean isParent(java.io.File folder, java.io.File file) throws java.rmi.RemoteException {

return fs.isParent(folder,file);

}



public boolean isRoot(java.io.File f) throws java.rmi.RemoteException {

return fs.isRoot(f);

}



public Boolean isTraversable(java.io.File f) throws java.rmi.RemoteException {

return fs.isTraversable(f);

}



public RemoteFile getChild(File parent, String fileName) throws java.rmi.RemoteException {

return new RemoteFileImpl(fs.getChild(parent,fileName));

}



}
