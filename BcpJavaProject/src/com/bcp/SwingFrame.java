package com.bcp;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import java.awt.Color;

public class SwingFrame extends JFrame {
	
	private static final boolean isverbose = true;		
	private JFrame mainFrame;
	private JPanel headerPanel;

	// Card Labels
	private JLabel jlbl_BankAccount_name;
	private JLabel jlbl_Cc_type;
	private JLabel jlbl_Cc_number;
	private JLabel jlbl_Cc_expire;
	private JLabel jlbl_LastDue_date;
	private JLabel jlbl_NextDue_date;
	private JLabel jlbl_LastPayment_amount;
	private JLabel jlbl_NextPayment_amount;
	private JLabel jlbl_MaxBalance_amount;
	private JLabel jlbl_InterestRate;

	

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
		this("Default Title");
		//setupPanel();
	}

	public SwingFrame(String string) {
		
		//setupPanel();
		setTitle(string);
		initGUI();
    }

	private void initGUI(){
		JPanel p1 = new Clock();
		JPanel p2 = new Hand();
		
		var pane = getContentPane();
		var gl = new GroupLayout(pane);
		pane.setLayout(gl);
	
		gl.setAutoCreateGaps(true);
	
		gl.setHorizontalGroup(gl.createSequentialGroup()
				//.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl.createParallelGroup()
						.addComponent(p1)
						.addComponent(p2))
				
				//.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
		);
	
		gl.setVerticalGroup(gl.createSequentialGroup()
				//.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl.createParallelGroup()
						.addComponent(p2)
						.addComponent(p1))
			
				//.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
		);
	
		gl.linkSize(p1, p2);
	
		pack();



	}

	private void setupPanel(){

		String bankAccount_name = "Capitol One";
		String cc_type = "Visa Quick Silver";
		String cc_number = "9999 9999 9999 9999";
		String cc_expire =	"12/2022";
		String lastDue_date = "1/3/2022";
    	String nextDue_date = "2/3/2022";
        String lastPayment_amount = "$100.00";
        String nextPayment_amount = "$200.00";
        String maxBalance_amount = "$1000.00";
        String interestRate	=	"27.3%";

		jlbl_BankAccount_name = new JLabel(bankAccount_name);
		jlbl_Cc_type= new JLabel(cc_type);
		jlbl_Cc_number= new JLabel(cc_number);
		jlbl_Cc_expire= new JLabel(cc_expire);
		jlbl_LastDue_date= new JLabel(lastDue_date);
		jlbl_NextDue_date= new JLabel(nextDue_date);
		jlbl_LastPayment_amount= new JLabel(lastPayment_amount);
		jlbl_NextPayment_amount= new JLabel(nextPayment_amount);
		jlbl_MaxBalance_amount= new JLabel(maxBalance_amount);
		jlbl_InterestRate= new JLabel(interestRate);



		controlPanel = (JPanel) getContentPane();
		var lbl_card_name = jlbl_BankAccount_name;
		var lbl_card_type = jlbl_Cc_type;		
		var lbl_card_number = new JLabel(cc_number);
		var lbl_card_exp = new JLabel(cc_expire);
		var lbl_lastDue_label = new JLabel("Prev Payment");
		var lbl_lastDue = new JLabel(lastDue_date);
		var lbl_lastPayment_lbl = new JLabel("Amount Paid");
		var lbl_lastPayment = new JLabel(lastPayment_amount);
		var lbl_nextDue_label = new JLabel("Next Payment");
		var lbl_nextDue = new JLabel(nextDue_date);
		var lbl_nextPayment_label = new JLabel("Amount Due");
		var lbl_nextPayment = new JLabel(nextPayment_amount);
		var lbl_valid_label = new JLabel("Valid Thru");
		var lbl_card_limit_lbl = new JLabel("Credit Limit");
		var lbl_card_limit = new JLabel(maxBalance_amount);
		var lbl_interest_rate_lbl = new JLabel("Interest Rate");
		var lbl_interest_rate = new JLabel(interestRate);

		createCardLayout(lbl_card_name,lbl_card_type,lbl_card_number,lbl_card_exp, lbl_lastDue_label,lbl_lastDue,
		lbl_lastPayment_lbl,lbl_lastPayment,lbl_nextDue_label,lbl_nextDue,lbl_nextPayment_label,lbl_nextPayment,lbl_valid_label,
		lbl_card_limit_lbl,lbl_card_limit,lbl_interest_rate_lbl,lbl_interest_rate);	

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
		
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[0])
						.addComponent(arg[1])
						.addComponent(arg[2])
						.addComponent(arg[12]))

				.addGroup(gl.createParallelGroup()
						.addComponent(arg[3])  //valid thru date
						)

				.addGroup(gl.createParallelGroup()
					.addComponent(arg[10])		
					.addComponent(arg[8]))
		
				.addGroup(gl.createParallelGroup()
					.addComponent(arg[9])
					.addComponent(arg[4])
					.addComponent(arg[6])
					.addComponent(arg[11]))

				.addGroup(gl.createParallelGroup()
					.addComponent(arg[7])
					.addComponent(arg[5]))

				.addGroup(gl.createParallelGroup()
					.addComponent(arg[13])
					.addComponent(arg[14]))

				.addGroup(gl.createParallelGroup()
					.addComponent(arg[15])
					.addComponent(arg[16]))

				.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
		);
	
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
				
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[0])				
						.addComponent(arg[8])
						.addComponent(arg[9])
						.addComponent(arg[13])
						.addComponent(arg[15]))
				
				.addGroup(gl.createParallelGroup()
					.addComponent(arg[1])	
					.addComponent(arg[11])
					.addComponent(arg[10])
					.addComponent(arg[14])
					.addComponent(arg[16]))

				.addGroup(gl.createParallelGroup()
					.addComponent(arg[2])
					.addComponent(arg[4])
					.addComponent(arg[5]))
					
				.addGroup(gl.createParallelGroup()
					.addComponent(arg[3])
					.addComponent(arg[7])
					.addComponent(arg[12])
					.addComponent(arg[6]))	

				.addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
		);

		gl.linkSize(arg[0], arg[1], arg[2], arg[3], arg[4], arg[5], arg[6], arg[7], arg[8], arg[9], arg[10],
		 arg[11], arg[12], arg[13], arg[14], arg[15], arg[16] );
	
		pack();
	}

public void refreshCard(ArrayList list){
	
	
	jlbl_BankAccount_name.setText((String) list.get(0));
	jlbl_Cc_type.setText((String) list.get(1));
	jlbl_Cc_number.setText((String) list.get(2));
	jlbl_Cc_expire.setText((String) list.get(3));
	jlbl_LastDue_date.setText((String) list.get(4));
	jlbl_NextDue_date.setText((String) list.get(5));
	jlbl_LastPayment_amount.setText((String) list.get(6));
	jlbl_NextPayment_amount.setText((String) list.get(7));
	jlbl_MaxBalance_amount.setText((String) list.get(8));
	jlbl_InterestRate.setText((String) list.get(9));


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
}
