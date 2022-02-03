package com.bcp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class Bcp implements WindowListener, ActionListener{


public Bcp(){
	/**
	 * Contructed in the App class
	 * frame size and visibility is set in App class
	 */

	statusText = "BCP Under Construction";
	/***
	 * Create the main window
	 */
	setFrame(new SwingFrame("Credit Accounts"));

	/** 
	 *  The SwingFrame will create a menu and load the components.
	 *  Utilizing this class to handle the menu and window events of 
	 *  the frame.
	 */

}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
           
				case "Open":
					runMenuOpen();
					break;
				case "Save as":
					runMenuSave();
					break;
				case "Quit":
					runMenuExit();
					break;
				
				case "About":
					message("About Time?");
					break;
				default: 
					message("Default Action, this is an error");
					break;
			}
	
	}
	private void runMenuExit() {
		message("Bye Bye");
		System.exit(0);
	}

	private void runMenuSave() {
		message("Starting to implement Save");
		Wallet w = new Wallet();
		w.saveWallet();

		try{
			FileInputStream readData = new FileInputStream("peopledata.ser");
			ObjectInputStream readStream = new ObjectInputStream(readData);
		
			ArrayList<CreditCard> wallet = (ArrayList<CreditCard>) readStream.readObject();
			readStream.close();
			System.out.println(wallet.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void runMenuOpen() {
	message("Starting to implement Open.");
		Wallet w = new Wallet();
		getFrame().refreshCard(w.getCardData());



	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		message("BCP windowOpened");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		message("BCP windowClosing");
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		message("BCP windowClosed");
		System.exit(0);
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		message("BCP windowIconified");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		message("BCP windowDeiconified");
	}
	@Override
	public void windowActivated(WindowEvent e) {		
		message("BCP windowActivated");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		message("BCP windowDeactivated");
	}
	public void setFrameSize(int i, int j) {
		frame.setSize(i,j);
		message("Frame size is now "+ i + " by " + j + " per Bcp.setFrameSize(int,int)");
	}
    public void showFrame(boolean b) {
		frame.setVisible(b);
    }
	public void message(String string) {
		System.out.println(string);
	}

	/**
	 * Class Variables
	 */
	private String statusText = "BCP is running";
	private BcpDialog dialog;
	private SwingFrame frame;
	
	/**
 	* 
 	* Getters and Setters
 	*/
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public BcpDialog getDialog() {
		return dialog;
	}
	private void setDialog(BcpDialog d) {
		// Add default attributes to the dialog
		d.addWindowListener(this);
		d.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.dialog = d;
	}
	public SwingFrame getFrame() {
		return frame;
		}
	private void setFrame(SwingFrame frame) {
		frame.setJMenuBar(getMenu());
		this.frame = frame;
	}
	/**
	 * 	MENU Code
	 */
	private JMenuBar getMenu(){
		// Creating the MenuBar and adding components
		JMenuItem mi_open = new JMenuItem("Open");
		mi_open.addActionListener(this);

		JMenuItem mi_save = new JMenuItem("Save as");
		mi_save.addActionListener(this);

		JMenuItem mi_quit = new JMenuItem("Quit");
		mi_quit.addActionListener(this);
		
		JMenu m_file = new JMenu("FILE");
		m_file.add(mi_open);
		m_file.add(mi_save);
		m_file.add(mi_quit);
	
		JMenuItem mi_about = new JMenuItem("About");
		mi_about.addActionListener(this);

		JMenu m_help = new JMenu("HELP");
		m_help.add(mi_about);

		JMenuBar m_bar = new JMenuBar();
		m_bar.add(m_file);
		m_bar.add(m_help);
		return m_bar;
	}
	/**
	 * main was defined during initial coding, this class is intended to be called by the application class
	 */
	public static void run() {	
		Bcp bcp = new Bcp();
		bcp.message("BCP is running");
		bcp.startClock();
	}

	public void startClock() {
		getDialog().setClockFace("Starting Clock");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		@Override
		public void run() {
			//System.out.println("Running: " + new java.util.Date());
			getDialog().setClockFace("Running: " + new java.util.Date());
			}
		}, 0, 1000);
		getDialog().setVisible(true);
	}
}


