package com.bcp;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;

public class ItemView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel itemDateLabel ;
	private JLabel itemAmountLabel;
	private JLabel itemLabel;
	private JLabel itemBalanceLabel;
	private JLabel itemOtherLabel;
	private JPanel panel;
	private JTable table;
	
/**
 * a @wbp.parser.constructor 
 */
	public ItemView() {
		prepareGUI();
	}
	
	public ItemView(ArPanel ar) {
		this();
		addArItem(ar);
	}
	
	public JPanel getPanel() {
		return panel;
	}

	private void addArItem(ArPanel ar) {
		
		itemDateLabel.setText(ar.getItemDateString());
		itemAmountLabel.setText(ar.getItemAmountString());
		
	}

	private void prepareGUI() {
		panel = new JPanel();
		/*
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("73px"),
				ColumnSpec.decode("1px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("57px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("82px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("1px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("56px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("1px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("37px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("37px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("1px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

				*/
		JLabel label = new JLabel("Item Viewer");
		panel.add(label, "1, 2, left, top");
		setItemBalanceLabel(new JLabel());
		JLabel label_1 = new JLabel("Transaction Date");
		panel.add(label_1, "4, 4, left, top");
		
		JLabel label_2 = new JLabel("Transaction");
		panel.add(label_2, "6, 4, left, top");
		
			
		JLabel label_3 = new JLabel("Amount");
		panel.add(label_3, "14, 4, left, default");
		
		
		JLabel label_4 = new JLabel("Balance");
		panel.add(label_4, "16, 4, left, top");
		//panel.setLayout(new FlowLayout());
		
		table = new JTable();
		table.setBackground(Color.PINK);
		panel.add(table, "4, 10, 12, 1, left, center");
		itemDateLabel = new JLabel();
		panel.add(itemDateLabel, "4, 18, left, center");
		itemLabel = new JLabel();
		panel.add(itemLabel, "6, 18, left, center");
		itemAmountLabel = new JLabel();
		panel.add(itemAmountLabel);
		panel.add(itemAmountLabel);
		
		
		
		
		/*
		ar.getItemAmountString();
		
		
			JLabel panelLabel = new JLabel();
		JLabel itemDateLabel = new JLabel();
		
		JLabel panelLabel2 = new JLabel("Transaction ");
		
		JLabel lblItemVal1 = new JLabel();
		JLabel lblItemVal = new JLabel();
		JLabel lblItemVal = new JLabel();
		JLabel lblItemVal = new JLabel();
		
*/
		
	}

	public void add(JPanel panel2) {
		// TODO Auto-generated method stub
		
	}

	public JLabel getItemBalanceLabel() {
		return itemBalanceLabel;
	}

	public void setItemBalanceLabel(JLabel itemBalanceLabel) {
		this.itemBalanceLabel = itemBalanceLabel;
	}

	public JLabel getItemOtherLabel() {
		return itemOtherLabel;
	}

	public void setItemOtherLabel(JLabel itemOtherLabel) {
		this.itemOtherLabel = itemOtherLabel;
	}

}
