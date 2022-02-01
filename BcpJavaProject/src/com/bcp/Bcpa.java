package com.bcp;

import java.util.Random;

import javax.swing.JTextArea;

public class Bcpa {

	public Bcpa(JTextArea textArea) {
		initialize(textArea);
	}
private void initialize(JTextArea textArea) {
	// Start Here
			Pocket pocket = new Pocket(new Hand());
			pocket.getHand().take(new Wallet());
			Wallet wallet = pocket.getHand().getWallet();
			wallet.add(20);
			pocket.addTextArea(textArea);
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

// Start Here
		Pocket pocket = new Pocket(new Hand());
		pocket.getHand().take(new Wallet());
		Wallet wallet = pocket.getHand().getWallet();
		wallet.add(20);
		
		
		Bar bar = new Bar();
		ItemView item = new ItemView();
		//jpanel.add(new JTextField("Hello World"));
		bar.show(item.getPanel());
		
		//ArPanel arp = new ArPanel();
		//arp.setName("My Name is buttercup");
		///arp.add(new JTextField("Hello"));
		
		//bar.show((JPanel)arp);
	
		
		
		
		int length = 10;

		System.out.println(geek_Password(length));

		}

	// This our Password generating method

	// We have use static here, so that we not to

	// make any object for it

	static char[] geek_Password(int len)

	{

	System.out.println("Generating passcode using random() : ");

	System.out.print("new cyphr is : ");


	// A strong password has Cap_chars, Lower_chars,

	// numeric value and symbols. So we are using all of

	// them to generate our password

	String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	String Small_chars = "abcdefghijklmnopqrstuvwxyz";

	String numbers = "0123456789";

	String symbols = "!@#$%^&*_=+-/.?<>)";



	String values = Capital_chars + Small_chars +

	numbers + symbols;


	// Using random method

	Random rndm_method = new Random();

char[] password = new char[len];


for (int i = 0; i < len; i++)

{

// Use of charAt() method : to get character value

// Use of nextInt() as it is scanning the value as int

password[i] =

values.charAt(rndm_method.nextInt(values.length()));


}

return password;

}

 



	}
	
	
	
	
	


