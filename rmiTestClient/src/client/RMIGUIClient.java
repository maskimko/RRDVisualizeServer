package client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import base.RMITestInterface;
import base.RemoteFileSystem;
import base.RemoteFileSystemView;
import base.RmiStarter;

public class RMIGUIClient extends RmiStarter {

	private Registry reg = null;
	
	private File  selDirectory = null;
	private JFrame main;
	private JTextArea listSpace;
	private boolean away = false;

	public RMIGUIClient() {
		super(RMITestInterface.class);
	}

	private void init(RemoteFileSystem remoteFileSystem) {

		main = new JFrame("Gui chooser test");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel(new BorderLayout());
		listSpace = new JTextArea(20, 50);
		JScrollPane listSSpace = new JScrollPane(listSpace);
		listSSpace
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		listSSpace
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JPanel bp = new JPanel();
		bp.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton chooseDir = new JButton("Choose directory");
		chooseDir.addActionListener(new ChooseDirectoryButtonListener(
				remoteFileSystem));
		bp.add(chooseDir);
		JButton doList = new JButton("Show listing");
		doList.addActionListener(new DoListingListener());
		bp.add(doList);
		mainPanel.add(BorderLayout.NORTH, bp);
		mainPanel.add(BorderLayout.SOUTH, listSSpace);
		main.getContentPane().add(mainPanel);
		main.pack();
		main.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RMIGUIClient rmigc = new RMIGUIClient();
		try {
			while (!rmigc.away) {
				Thread.sleep(5000);
			}
		} catch (InterruptedException ie) {

		}
		System.out.println("End of program!");
	}

	class ChooseDirectoryButtonListener implements ActionListener {

		RemoteFileSystem remFS = null;
		
		ChooseDirectoryButtonListener(RemoteFileSystem remFS) {
			this.remFS = remFS;
		}

		public void actionPerformed(ActionEvent ae){
			try {
			RemoteFileSystemView rfsView = new RemoteFileSystemView(remFS);
			JFileChooser jfc = new JFileChooser(rfsView);
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			
			int result = jfc.showOpenDialog(main);
			if (result == JFileChooser.APPROVE_OPTION) {
				selDirectory = jfc.getSelectedFile();
			}
			} catch (RemoteException re) {
				re.printStackTrace();
			}
		}
	}

	class DoListingListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (selDirectory.canRead()) {

				File[] fList = selDirectory.listFiles();
				for (int i = 0; i < fList.length; i++) {
					listSpace.append(fList[i] + "\n");
				}
				away = true;
			}

		}
	}

	@Override
	public void doCustomRmiHandling() {
		try {
			reg = LocateRegistry.getRegistry("rcu8.sdab.sn", 2099);
			RemoteFileSystem rfsStub = (RemoteFileSystem) reg.lookup("RemoteFileSystem"); 
			
			System.out.println("Start of init method");
			init(rfsStub);
			System.out.println("End of init method");

		} catch (NotBoundException nbe) {
			nbe.printStackTrace();
		} catch (RemoteException re) {
			re.printStackTrace();
		}

	}
}
