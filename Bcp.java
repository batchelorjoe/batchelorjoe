package bcp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.WindowConstants;

import bcp.gui.BcpDialog;
import bcp.gui.SwingFrame;

public class Bcp implements WindowListener, ActionListener{
//private static Bcp bcp;
private String statusText = "BCP is running";

private BcpDialog dialog;
private SwingFrame frame;



public static void run() {
		System.out.println("BCP is running");
		new Bcp();
		//bcp.startClock();
	}
public Bcp(){
	//Constructor
statusText = "BCP Constructor";
dialog = new BcpDialog();
frame = new SwingFrame();

}
	
public String getStatusText() {
	return statusText;
}
public void setStatusText(String statusText) {
	this.statusText = statusText;
}
public BcpDialog getDialog() {
	return dialog;
}
private void setDialog(BcpDialog dialog) {
	this.dialog = dialog;
}
public SwingFrame getFrame() {
	return frame;
}
private void setFrame(SwingFrame frame) {
	this.frame = frame;
}
public void startClock() {
	setDialog(new BcpDialog());
	getDialog().addWindowListener(this);
	getDialog().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BCP actionPerformed");
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BCP windowOpened");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BCP windowClosing");
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BCP windowClosed");
		System.exit(0);
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BCP windowIconified");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BCP windowDeiconified");
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BCP windowActivated");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BCP windowDeactivated");
	}
	
	
}


