package com.bcp;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

//import com.bcp.batworks.Batarang;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.EventQueue;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
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
	private JPanel pnl;

	public SwingFrame() {		
		setupPanel();
	}

	public SwingFrame(String string) {
		
		setupPanel();
		setTitle(string);
    }

	private void setupPanel(){


		String bankAccount_name = "Capitol One";
		String cc_type = "Visa";

		String cc_number = "9999 9999 9999 9999";
		String cc_expire =	"12/2022";

		String lastDue_date = "1/3/2022";
    	String nextDue_date = "2/3/2022";
        String lastPayment_amount = "$100.00";
        String nextPayment_amount = "$200.00";
        String maxBalance_amount = "$1000.00";
        String interestRate	=	"27.3%";



		controlPanel = (JPanel) getContentPane();
		var lbl_card_name = new JLabel(bankAccount_name);
		var lbl_card_type = new JLabel(cc_type);
		
		var lbl_card_number = new JLabel(cc_number);
		var lbl_card_exp = new JLabel(cc_expire);

		var lbl_lastDue_label = new JLabel("Last Due");
		var lbl_lastDue = new JLabel(lastDue_date);

		var lbl_lastPayment_lbl = new JLabel("Last Payment Amount");
		var lbl_lastPayment = new JLabel(lastPayment_amount);

		var lbl_nextDue_label = new JLabel("Next Due");
		var lbl_nextDue = new JLabel(nextDue_date);

		var lbl_nextPayment_label = new JLabel("Next Payment Amount");
		var lbl_nextPayment = new JLabel(nextPayment_amount);

		createCardLayout(lbl_card_name,lbl_card_type,lbl_card_number,lbl_card_exp, lbl_lastDue_label,lbl_lastDue,
		lbl_lastPayment_lbl,lbl_lastPayment,lbl_nextDue_label,lbl_nextDue,lbl_nextPayment_label,lbl_nextPayment);

		
		/*
		var balLbl = new JLabel("$0.00");
		var dueLbl = new JLabel("$0.00");
		int cc_id;
        Currency cc_amount;
        String cc_number_plain;
        String aba_routing;
        int accountType_id;
        String bank_name;
        String account_name;
        int user_id;
        String user_name;
        LocalDate create_date;
        LocalDate update_date;
        LocalDate payment_date;
        LocalDate lastDue_date;
        LocalDate nextDue_date;
        Currency lastPayment_amount;
        Currency nextPayment_amount;
        Currency maxBalance_amount;
        int interestRate;
		createLayout(vendorLbl, acctLbl, balLbl, dueLbl);

*/

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		controlPanel.setBackground(new Color(199, 21, 133));

	}

	private void createCardLayout(JComponent... arg) {

		var pane = getContentPane();
		var gl = new GroupLayout(pane);
		pane.setLayout(gl);
	
		gl.setAutoCreateGaps(true);
	
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[0])
						.addComponent(arg[2]))
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[1])
						.addComponent(arg[3]))

				.addGroup(gl.createParallelGroup()
						.addComponent(arg[4])
						.addComponent(arg[6]))	
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[5])
						.addComponent(arg[7]))			
						
				.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
		);
	
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[0])
						.addComponent(arg[1]))
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[2])
						.addComponent(arg[3]))

				.addGroup(gl.createParallelGroup()
						.addComponent(arg[4])
						.addComponent(arg[5]))

				.addGroup(gl.createParallelGroup()
						.addComponent(arg[6])
						.addComponent(arg[7]))

				.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
		);
	
		gl.linkSize(arg[0], arg[1], arg[2], arg[3]  , arg[4] , arg[5] , arg[6] , arg[7]    );
	
		pack();
	}
	private void setupButtonPanel() {
	
		pnl = (JPanel) getContentPane();
		var warBtn = new JButton("Warning");
        var errBtn = new JButton("Error");
        var queBtn = new JButton("Question");
        var infBtn = new JButton("Information");

        warBtn.addActionListener(event -> JOptionPane.showMessageDialog(pnl,
                "A deprecated call!", "Warning", JOptionPane.WARNING_MESSAGE));

        errBtn.addActionListener(event -> JOptionPane.showMessageDialog(pnl,
                "Could not open file!", "Error", JOptionPane.ERROR_MESSAGE));

        queBtn.addActionListener(event -> JOptionPane.showMessageDialog(pnl,
                "Are you sure to quit?", "Question", JOptionPane.QUESTION_MESSAGE));

        infBtn.addActionListener(event -> JOptionPane.showMessageDialog(pnl,
                "Download completed.", "Information", 
                JOptionPane.INFORMATION_MESSAGE));

        createLayout(warBtn, errBtn, queBtn, infBtn);

        setTitle("Message dialogs");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		pnl.setBackground(new Color(199, 21, 133));
	
}
private void createLayout(JComponent... arg) {

	var pane = getContentPane();
	var gl = new GroupLayout(pane);
	pane.setLayout(gl);

	gl.setAutoCreateGaps(true);

	gl.setHorizontalGroup(gl.createSequentialGroup()
			.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
			.addGroup(gl.createParallelGroup()
					.addComponent(arg[0])
					.addComponent(arg[2]))
			.addGroup(gl.createParallelGroup()
					.addComponent(arg[1])
					.addComponent(arg[3]))
			.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
	);

	gl.setVerticalGroup(gl.createSequentialGroup()
			.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
			.addGroup(gl.createParallelGroup()
					.addComponent(arg[0])
					.addComponent(arg[1]))
			.addGroup(gl.createParallelGroup()
					.addComponent(arg[2])
					.addComponent(arg[3]))
			.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
	);

	gl.linkSize(arg[0], arg[1], arg[2], arg[3]);

	pack();
}
}
