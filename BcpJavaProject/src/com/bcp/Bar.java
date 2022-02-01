package com.bcp;


//import com.bcp.batworks.Batarang;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.Component;
import java.awt.PopupMenu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bar {
	
	public static int focusCount;
	private static final boolean isverbose = true;
			
	
	
	
	public static void gainFocus() {

		int focusCount = 0;
		if (focusCount == 1)
			return;
		focusCount = focusCount + 1;
		verbose("Window has focus " + focusCount + " times");
	}
	static int getFocusCount() {
		return focusCount;
	}



	static boolean isIsverbose() {
		return isverbose;
	}

	private static void journal(String string) {
		try {
			File jrnl = new File("journal.txt");
			if (jrnl.createNewFile()) {
				verbose("File created: " + jrnl.getName());
				FileWriter pen = new FileWriter(jrnl);
				pen.write(string);
				pen.close();

			} else {
				System.out.println("Using verbose would create a loop");
			}
		} catch (IOException e) {
			System.out.println("An error to journal occured.");
			e.printStackTrace();
		}

	}

	public static void lostFocus() {
		verbose("Batarang : lostFocus , called by Window");

	}
	// We are being called by Contructor
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bar window = new Bar();
					//window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static void setFocusCount(int focusCount) {
		Bar.focusCount = focusCount;
	}
	private static void verbose(String string) {
		boolean isverbose = false;
		if (isverbose)
			System.out.println(string);
		else
			journal(string);

	}
	ArrayList<ArPanel> arList;


	public ArPanel arp[]; // array of objects created in constructor
	/**
	 * @wbp.nonvisual location=51,19
	 */
	
	
		Object barCenter;
	private JPanel barHeader = null; // ret
	private JPanel barLeftNav = null;

	//private final JLabel barTitle = DefaultComponentFactory.getInstance().createTitle("Bat Accounts Rec");
	private final JLabel barTitle = new JLabel("Bat Accounts Rec");
	private JPanel canvasPanel; // Seen in initialize
	private JPanel controlPanel;
	private String cwd = System.getProperty("user.dir");
	private JPanel dataPanel;
	private JButton filebutton = new JButton("Choose");

	private JFileChooser fileChooser = new JFileChooser(cwd);

	private JLabel headerLabel;

	private JPanel headerPanel;

	private com.bcp.ItemView itemView;

	// private static Batarang bapp;
	// private Bar window;
	private JFrame mainFrame;

	private JLabel msglabel;

	private JTextComponent pane;

	private JLabel statusLabel;

	private JTextArea textArea;

	/**
	 * Create the application.
	 * 
	 * @param bapp
	 */

	public Bar() {
		miniGUI();
	}
	public Bar(Object obj) {
		prepareGUI();
	}

	private void buildHeader() {

		/**
		 * Header Panel added the screen size to the status Label
		 * 
		 */
		setHeaderPanel(new JPanel());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		String myScreen = ("" + screenWidth + "X" + screenHeight);

		JLabel headerLabel = new JLabel(myScreen, SwingConstants.CENTER);
		headerLabel.setBackground(Color.BLUE);
		JLabel statusLabel = new JLabel("Status Label", SwingConstants.CENTER);
		headerPanel.add(headerLabel);

		// Creating the MenuBar and adding components
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("FILE");
		JMenu m2 = new JMenu("Help");
		mb.add(m1);
		mb.add(m2);
		JMenuItem m11 = new JMenuItem("Open");
		JMenuItem m22 = new JMenuItem("Save as");
		JMenuItem m33 = new JMenuItem("Quit");
		m1.add(m11);
		m1.add(m22);
		m1.add(m33);

		// Text Area at the Center
		JTextArea ta = new JTextArea();
		// Press button on the left
		JButton button = new JButton("Press");
		// Adding Components to the frame.

		// getWindow().getFrame().add(ta);
		getFrame().getContentPane().add(BorderLayout.NORTH, mb);

	}

	// getArList
	public ArrayList<ArPanel> getArList() {
		return arList;
	}

	ArPanel[] getArp() {
		return arp;
	}

	// barCenter
	public Object getBarCenter() {
		return barCenter;
	}

	// barHeader
	public JPanel getBarHeader() {
		return barHeader;
	}

	// leftNav
	public JPanel getBarLeftNav() {
		return barLeftNav;
	}

	// bar Title
	public JLabel getBarTitle() {
		return barTitle;
	}

	// canvasPanel
	public JPanel getCanvasPanel() {
		return canvasPanel;
	}

	JPanel getControlPanel() {
		return controlPanel;
	}
	JPanel getDataPanel() {
		return dataPanel;
	}
	JFileChooser getFileChooser() {
		return fileChooser;
	}

	// Getters and Setters

	// mainFrame
	public JFrame getFrame() {
		return mainFrame;
	}

	JLabel getHeaderLabel() {
		return headerLabel;
	}

	JPanel getHeaderPanel() {
		return headerPanel;
	}

	JFrame getMainFrame() {
		return mainFrame;
	}

	JLabel getMsglabel() {
		return msglabel;
	}

	private Consumer<? super ArPanel> getName() {
		// TODO Auto-generated method stub
		return null;
	}

	JTextComponent getPane() {
		return pane;
	}

	JLabel getStatusLabel() {
		return statusLabel;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	private void makePanel() {

		// Creating the Frame
		JFrame frame = new JFrame("Target View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		// Creating the MenuBar and adding components
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("FILE");
		JMenu m2 = new JMenu("Help");
		mb.add(m1);
		mb.add(m2);
		JMenuItem m11 = new JMenuItem("Open");
		JMenuItem m22 = new JMenuItem("Save as");
		JMenuItem m33 = new JMenuItem("Quit");
		m1.add(m11);
		m1.add(m22);
		m1.add(m33);

		// Creating the panel at bottom and adding components
		JPanel panel = new JPanel(); // the panel is not visible in output
		JLabel label = new JLabel("Enter Text");
		JTextField tf = new JTextField(10); // accepts upto 10 characters
		JButton send = new JButton("Send");
		JButton reset = new JButton("Reset");
		panel.add(label); // Components Added using Flow Layout
		panel.add(label); // Components Added using Flow Layout
		panel.add(tf);
		panel.add(send);
		panel.add(reset);

		// Text Area at the Center
		JTextArea ta = new JTextArea();
		// Press button on the left
		JButton button = new JButton("Press");
		// Adding Components to the frame.
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.getContentPane().add(BorderLayout.NORTH, mb);
		frame.getContentPane().add(BorderLayout.CENTER, ta);
		frame.getContentPane().add(BorderLayout.WEST, button); // Adds Button to content pane of frame
		frame.setVisible(true);
	}

	public int preload() {
		// Time to work while the spash screen is up
		verbose("Preload");

		return 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void prepareGUI() {

		// Initialize the class objects for the GUI

		setCanvasPanel(new JPanel());
		setBarHeader(new JPanel());
		setFrame(new JFrame());
		setControlPanel(new JPanel());
		setHeaderPanel(new JPanel());
		setDataPanel(new JPanel());
		setHeaderLabel(new JLabel("..."));
		setStatusLabel(new JLabel("..."));
		setMsglabel(new JLabel("..."));
		setBarLeftNav(new JPanel());
		setTextArea(new JTextArea());

		/*
		 * Settting the initial Window Size Here
		 * 
		 */
		getFrame().setBounds(100, 100, 1750, 800);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(new BorderLayout(0, 0));

		/*
		 * Customize Gui Components
		 */

		getBarHeader().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getHeaderLabel().setText("Feature Selection :");
		getBarHeader().add(getHeaderLabel());

		getCanvasPanel().setLayout(new BorderLayout(0, 0));
		getCanvasPanel().add(getBarHeader(), BorderLayout.NORTH);

		getFrame().getContentPane().add(getCanvasPanel());

		JButton btnPreviousPeriod = new JButton("Previous Period");
		btnPreviousPeriod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Previous Period Event
				// Add Prev Period Handler

			}
		});
		barHeader.add(btnPreviousPeriod);

		JButton btnNextPeriod = new JButton("Next Period");
		btnNextPeriod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Add Next Period handler

			}
		});
		barHeader.add(btnNextPeriod);

		JLabel lblTimes = new JLabel("Times :");
		barHeader.add(lblTimes);

		JButton btnWeek = new JButton("Week");
		btnWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set the View Mode to weekly View

			}
		});
		barHeader.add(btnWeek);

		JButton btnMonth = new JButton("Month");
		btnMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set the view to the monthly View

			}
		});
		barHeader.add(btnMonth);

		/*
		 * SET UP THE LEFT NAVIGATION PANEL
		 */

		// setBarLeftNav(new JPanel());
		// JPanel barLeftNav = new JPanel();

		getBarLeftNav().setLayout(new GridLayout(0, 1));
		getCanvasPanel().add(getBarLeftNav(), BorderLayout.WEST);

		JLabel lblOptions = new JLabel("Options");
		barLeftNav.add(lblOptions);

		JButton btnSave = new JButton("Save");
		getBarLeftNav().add(btnSave);

		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Clicked the Load Button
				System.out.println("Load");

			}
		});
		getBarLeftNav().add(btnLoad);

		ItemView itemView = new ItemView();
		setBarCenter((ItemView) itemView);
		getCanvasPanel().add(getTextArea());

		/*
		 * getFrame().addWindowFocusListener(new WindowFocusListener() { public void
		 * windowGainedFocus(WindowEvent e) { Batarang.gainFocus(); } public void
		 * windowLostFocus(WindowEvent e) { Batarang.lostFocus(); } });
		 */

	}

	private void miniGUI() {

		// Bar window = getWindow();
		 mainFrame = new JFrame();
		
		////headerPanel = getBarHeader();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		String myScreen = ("" + screenWidth + "X" + screenHeight);

		//JLabel headerLabel = new JLabel(myScreen, SwingConstants.CENTER);
		//headerLabel.setBackground(Color.BLUE);
		//headerLabel.setText("Header Label");
		JLabel statusLabel = new JLabel("", SwingConstants.CENTER);
		statusLabel.setSize(350, 100);
		statusLabel.setText("Status");
		//headerPanel.add(headerLabel);

		
		 //mainFrame = new
		 //JFrame("Bat Accounts Recievable Management System the BatARang");
		 mainFrame.setSize(800,800); mainFrame.setLayout(new GridLayout(3, 3));
		 
		 mainFrame.addWindowListener
		 (
				 new WindowAdapter() 
				 { public void windowClosing(WindowEvent windowEvent)
				 { System.exit(0); } 
				 }
		 );
		 
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		JPanel dataPanel = new JPanel();
		ItemView viewer = new ItemView(new ArPanel("test"));
		// dataPanel.add(viewer);
		dataPanel.setLayout(new FlowLayout());
		dataPanel.setSize(500, 500);
		/*
		 * mainFrame.add(headerLabel); mainFrame.add(controlPanel);
		 * mainFrame.add(statusLabel); mainFrame.add(dataPanel);
		 * mainFrame.setVisible(true);
		 */
		statusLabel.setText("Prepared GUI");
		//this.getFrame().setVisible(true);
	}

	private void prepArList() {
		// load data into the arList
		arList = new ArrayList<ArPanel>();
		arList.add(new ArPanel("Sunday"));
		arList.add(new ArPanel("Monday"));
		arList.add(new ArPanel("Tuesday"));
		arList.add(new ArPanel("Wednesday"));
		arList.add(new ArPanel("Thursday"));
		arList.add(new ArPanel("Friday"));
		arList.add(new ArPanel("Saturday"));
	}

	private void readDataFile() {

		if (fileChooser.showOpenDialog(getFrame()) != JFileChooser.APPROVE_OPTION)
			return;

		File f = fileChooser.getSelectedFile();
//            readin(f.toString(), pane);

		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				ArPanel ar = new ArPanel("");
				ar.setAccRow(line);
				arList.add(ar);
				sb.append(line);
				line = br.readLine();
			}
			String everything = sb.toString();
			br.close();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void readin(String fn, JTextComponent pane) {
		verbose("File reader");
		try {
			FileReader fr = new FileReader(fn);
			pane.read(fr, null);
			fr.close();
		} catch (IOException e) {
			System.err.println(e);

		}
	}

	public void setArList(ArrayList<ArPanel> arList) {
		this.arList = arList;
	}

	void setArp(ArPanel[] arp) {
		this.arp = arp;
	}

	public void setBarCenter(Object barCenter) {
		this.barCenter = barCenter;
	}

	public void setBarHeader(JPanel barHeader) {
		this.barHeader = barHeader;
	}

	public void setBarLeftNav(JPanel barLeftNav) {
		this.barLeftNav = barLeftNav;
	}

	public void setCanvasPanel(JPanel canvas) {
		this.canvasPanel = canvas;
	}

	void setControlPanel(JPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	void setDataPanel(JPanel dataPanel) {
		this.dataPanel = dataPanel;
	}

	void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public void setFrame(JFrame frame) {
		this.mainFrame = frame;
	}

	void setHeaderLabel(JLabel headerLabel) {
		this.headerLabel = headerLabel;
	}

	void setHeaderPanel(JPanel headerPanel) {
		this.headerPanel = headerPanel;
	}

	void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	void setMsglabel(JLabel msglabel) {
		this.msglabel = msglabel;
	}

	void setPane(JTextComponent pane) {
		this.pane = pane;
	}

	void setStatusLabel(JLabel statusLabel) {
		this.statusLabel = statusLabel;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void show() {
		// TODO Auto-generated method stub
		
	}
	public void show(Component jpanel) {
		getFrame().add(jpanel);
		
		
	}

	private void showGridLayoutDemo() {

		readDataFile();
		// window.getTextArea().setText(t);

		Collection collection = arList;
		Iterator iterator = collection.iterator();

		while (iterator.hasNext()) {
			Object object = iterator.next();
			getTextArea().setText(((ArPanel) object).getData());
			verbose(((ArPanel) object).getName());
			verbose(((ArPanel) object).getData());
			verbose(((ArPanel) object).getItemAmountString());
			verbose(((ArPanel) object).getItemDateString());

		}

		// prepArList();
		String anElement = "an element";
		// Collection collection = new HashSet();
		boolean didCollectionChange = collection.add(anElement);

		ItemView itemview = new ItemView();
		JFrame f = getFrame();

		// f.add((JPanel)itemview);
		// Collection collection = new ArrayList();
		// doSomething(collection);

		JLabel statusLabel = null;
		statusLabel.setText("Demo");

		JPanel panel = new JPanel();
		// panel.setBorder(new Border());
		panel.setBackground(Color.darkGray);
		panel.setSize(800, 500);
		GridLayout layout = new GridLayout(3, 3);
		layout.setHgap(10);
		layout.setVgap(10);
		panel.setLayout(layout);
		readDataFile();

		for (ArPanel pan : arList) {
			panel.add(new JButton((pan.getData())));
		}

		JTextField pane = new JTextField();
		panel.add(pane);

		Container controlPanel = null;
		controlPanel.add(panel);

		Container dataPanel = null;
		dataPanel.add(pane);
		dataPanel.setSize(200, 200);
		Window mainFrame = null;
		mainFrame.setVisible(true);

		statusLabel.setText("Load Data");

	}

	/**
	 * Getters and Setters
	 * 
	 * @return
	 */

	public void splash(int i) {
		// java.awt.Robot.Wait(i);
		System.out.println("Spashing the system");
		Frame f = new Frame();
		new SplashWindow("myfile", f, i);
		// getParentApp().preload();
		//getFrame().setVisible(true);
	}
	public void showItem(ItemView item) {
		
		getFrame().getContentPane().add(BorderLayout.NORTH, item.getPanel());
	}



	/* GRAVE YARD FOR OLD CODE */
	/*
	 * Taking this out to remove dependence on a parent object public Bar(Batarang
	 * bapp) { setParentApp(bapp); initialize(); }
	 * 
	 * public void setParentApp(Batarang newApp) { bapp = newApp;
	 * 
	 * } public Batarang getParentApp() { return bapp;
	 * 
	 * }
	 */

}