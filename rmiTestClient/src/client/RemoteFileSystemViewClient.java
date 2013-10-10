package client;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import base.RemoteFileSystemView;

public class RemoteFileSystemViewClient extends FileSystemView {
    
    static RemoteFileSystemView c;
    
    public RemoteFileSystemViewClient() {
        try {
            c = (RemoteFileSystemView) Naming.lookup("rmi://localhost:2099/RemoteFileSystem");
        }
        catch (MalformedURLException murle) {
            System.out.println();
            System.out.println(
            "MalformedURLException");
            System.out.println(murle);
        }
        catch (RemoteException re) {
            System.out.println();
            System.out.println(
            "RemoteException");
            System.out.println(re);
        }
        catch (NotBoundException nbe) {
            System.out.println();
            System.out.println(
            "NotBoundException");
            System.out.println(nbe);
        }
        
    }
    public File getHomeDirectory() {
        File tempf;
        try {
            tempf= new File(c.getHomeDirectory().gettoString());
        } catch (RemoteException re){System.out.println(re);tempf=null;}
        return tempf;
    }
    
    public File createFileObject(File dir, String filename) {
        File tempf;
        try {
            tempf= new File(c.createFileObject(dir, filename).gettoString());
        } catch (RemoteException re){System.out.println(re);tempf=null;}
        return tempf;
    }
    
    public File createFileObject(String path) {
        File tempf;
        try {
            tempf=new File(c.createFileObject(path).gettoString());
        } catch (RemoteException re){System.out.println(re);tempf=null;}
        return tempf;
    }
    
    public File createNewFolder(File containingDir) throws RemoteException {
        File tempf = null;
        try {
            tempf=new File(c.createNewFolder(containingDir).getAbsolutePath());
        } catch (RemoteException re){System.out.println(re);tempf=null;} catch (IOException e) {
			
			e.printStackTrace();
		}
        return tempf;
    }
    
    public File getChild(File parent, String fileName) {
        File tempf;
        try {
            tempf=new File(c.getChild(parent,fileName).gettoString());
        } catch (RemoteException re){System.out.println(re);tempf=null;}
        return tempf;
    }
    
    public File getDefaultDirectory() {
        File tempf;
        try {
            tempf=new File(c.getDefaultDirectory().gettoString());
        } catch (RemoteException re){System.out.println(re);tempf=null;}
        return tempf;
    }
    
    public File[] getFiles(File dir, boolean useFileHiding) {
        File[] tempf;
        try {
            tempf=new File[c.getFiles(dir,useFileHiding).length];
            String[] rtempf=c.getFiles(dir, useFileHiding);
            int i;
            for(i=0;i<c.getFiles(dir, useFileHiding).length;i++) tempf[i]=new File(rtempf[i]);

} catch (RemoteException re){System.out.println(re);tempf=null;}

return tempf;

}



public File getParentDirectory(File dir) {

File tempf;

try {

tempf= new File(c.getParentDirectory(dir).gettoString());

} catch (RemoteException re){System.out.println(re);tempf=null;}

return tempf;

}



public File[] getRoots(){

File[] tempf;

try {

String[] rtempf= c.getRoots();

System.out.println("in");

tempf=new File[rtempf.length];

int i;

for(i=0;i<c.getRoots().length;i++) tempf[i]=new File(rtempf[i]);

} catch (RemoteException re){System.out.println(re);tempf=null;}

return tempf;

}



public String getSystemDisplayName(File f) {

String tempf;

try{

tempf=c.getSystemDisplayName(f);

} catch (RemoteException re){System.out.println(re);tempf=null;}

return tempf;

}

public javax.swing.Icon getSystemIcon(File f) {

javax.swing.Icon tempf;

try{

tempf=c.getSystemIcon(f);

} catch (RemoteException re){System.out.println(re);tempf=null;}

return tempf;

}



public String getSystemTypeDescription(File f) {

String tempf;

try {

tempf=c.getSystemTypeDescription(f);

} catch (RemoteException re){System.out.println(re);tempf=null;}

return tempf;

}



public boolean isComputerNode(File dir) {

boolean tempf;

try {

tempf= c.isComputerNode(dir);

} catch (RemoteException re){System.out.println(re);tempf=false;}

return tempf;

}



public boolean isDrive(File dir) {

boolean tempf;

try {

tempf= c.isDrive(dir);

} catch (RemoteException re){System.out.println(re);tempf=false;}

return tempf;

}



public boolean isFileSystem(File f) {

boolean tempf;

try {

tempf= c.isFileSystem(f);

} catch (RemoteException re){System.out.println(re);tempf=false;}

return tempf;

}



public boolean isFileSystemRoot(File dir) {

boolean tempf;

try {

tempf= c.isFileSystemRoot(dir);

} catch (RemoteException re){System.out.println(re);tempf=false;}

return tempf;

}



public boolean isFloppyDrive(File dir) {

boolean tempf;

try {

tempf= c.isFloppyDrive(dir);

} catch (RemoteException re){System.out.println(re);tempf=false;}

return tempf;

}



public boolean isHiddenFile(File f) {

boolean tempf;

try {

tempf= c.isHiddenFile(f);

} catch (RemoteException re){System.out.println(re);tempf=false;}

return tempf;

}

public boolean isParent(File folder, File file) {

boolean tempf;

try {

tempf= c.isParent(folder,file);

} catch (RemoteException re){System.out.println(re);tempf=false;}

return tempf;

}



public boolean isRoot(File f) {

boolean tempf;

try {

tempf= c.isRoot(f);

} catch (RemoteException re){System.out.println(re);tempf=false;}

return tempf;

}

public Boolean isTraversable(File f) {

Boolean tempf;

try {

tempf= c.isTraversable(f);

} catch (RemoteException re){System.out.println(re);tempf=new Boolean(false);}

return tempf;

}



public static void main(String[] args) {

RemoteFileSystemViewClient rc = new RemoteFileSystemViewClient();



JFileChooser fch= new JFileChooser(rc);

fch.showOpenDialog(null);

} 

}
