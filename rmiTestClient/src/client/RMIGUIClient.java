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
import base.RmiStarter;

public class RMIGUIClient extends RmiStarter {

	private Registry reg = null;
	private RMITestInterface engine = null;
	private File userCurDir = null, selDirectory = null;
	private JFrame main;
	private JTextArea listSpace;
	private boolean away = false;

	public RMIGUIClient() {
		super(RMITestInterface.class);
	}

	private void init() {

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
				userCurDir));
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

		File userDirectory = null;

		ChooseDirectoryButtonListener(File dir) {
			userDirectory = dir;
		}

		public void actionPerformed(ActionEvent ae) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int result = jfc.showOpenDialog(main);
			if (result == JFileChooser.APPROVE_OPTION) {
				selDirectory = jfc.getSelectedFile();
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
			reg = LocateRegistry.getRegistry("vm-cacti.sdab.sn", 2099);
			engine = (RMITestInterface) reg.lookup("testserver");
			userCurDir = engine.getCurrentFile();
			System.out.println("I got current dir: "
					+ userCurDir.getAbsolutePath());
			System.out.println("Start of init method");
			init();
			System.out.println("End of init method");

		} catch (NotBoundException nbe) {
			nbe.printStackTrace();
		} catch (RemoteException re) {
			re.printStackTrace();
		}

	}
}
