package com.bcp;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

//import com.bcp.batworks.Batarang;

import java.awt.Color;

public class SwingFrame extends JFrame {
	
	private static final boolean isverbose = true;	
	

	
	private JFrame mainFrame;
	private JPanel headerPanel;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JLabel msglabel;
	private JPanel dataPanel;
	private JTextComponent pane;
	private final JFileChooser fc = new JFileChooser();



	private String cwd;
	private	JFileChooser jfc = new JFileChooser(cwd);
	private JButton filebutton = new JButton("Choose");

	//private com.bco.util.ItemView itemView;

	
	public SwingFrame() {
		
		setupPanel();
	}
private void setupPanel() {
	getContentPane().setBackground(new Color(199, 21, 133));
	
}
}
