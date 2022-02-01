package com.bcp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ArPanel extends JPanel  implements ActionListener {

	
	private String name = "";
	public String getAcctRow() {
		return acctRow;
	}
	public void setAcctRow(String acctRow) {
		this.acctRow = acctRow;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getTransLabel() {
		return transLabel;
	}
	public void setTransLabel(String transLabel) {
		this.transLabel = transLabel;
	}
	public String getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}
	public String getTransBalance() {
		return transBalance;
	}
	public void setTransBalance(String transBalance) {
		this.transBalance = transBalance;
	}
	public String getTransOther() {
		return transOther;
	}
	public void setTransOther(String transOther) {
		this.transOther = transOther;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String acctRow = "";
	private String transDate = "";
	private String transLabel = "";
	private String transAmount = "";
	private String transBalance = "";
	private String transOther = "";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
public ArPanel() {
	this("Unknown");
}
public ArPanel (String StrN) {
	name = StrN;
}
public String getName() {
	return name;
}
public void setAccRow(String row) {
	acctRow = row;
	parseRow(row);
}
private void parseRow(String row) {



String[] output = row.split(",");
for(int i = 0; i < output.length; i++)
	{  
	if(i == 0) {transDate = output[i];};
	if(i == 1) {transLabel = output[i];};
	if(i == 2) {transAmount = output[i];};
	if(i == 3) {transBalance = output[i];};
	if(i == 4) {transOther = output[i];};
	

	}

	
}

public String getData() {
	
	String Acctitem = "Item :" +  transDate + "" +  transLabel + "" + transAmount +  "" +transBalance +  "" + transOther;
	return Acctitem;
	
}
public String getItemDateString() {
	if(transDate == null)
		return "";
	else return transDate;
		
	
}
public String getItemAmountString() {
	if(transAmount == null)
		return "0.00";
	else return transAmount;
}
	
}
