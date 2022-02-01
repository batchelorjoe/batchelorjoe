package com.bcp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.JPanel;

public class swingWindow {

	private JFrame JustaWin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingWindow window = new swingWindow();
					window.JustaWin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public swingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JustaWin = new JFrame();
		JustaWin.setTitle("Just A window Dude");
		JustaWin.setBounds(100, 100, 450, 300);
		JustaWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		JustaWin.getContentPane().add(desktopPane, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(321, 11, 103, 35);
		desktopPane.add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 195, 35);
		desktopPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(205, 5, 80, 35);
		desktopPane.add(panel_1);
	}
}
