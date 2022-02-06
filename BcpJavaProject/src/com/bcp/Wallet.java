package com.bcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

/**
 * Class Wallet to hold the Credit Cards
 */
public class Wallet {
  private final static Charset ENCODING = StandardCharsets.UTF_8;
  private static StringBuffer logString = new StringBuffer();
  private static String walletFileName = "mywallet.txt";

/**
 * Wallet has file interface capability
 * @return
 */
    public Wallet(){
    }
    public static StringBuffer getLogString() {
      return logString;
    }
    public static void setLogString(StringBuffer logString) {
      Wallet.logString = logString;
    }


  public static String checkWallet () {

    log("Classpath: " + System.getProperty("java.class.path"));
    log("user.dir: " + System.getProperty("user.dir"));

    String cpath = System.getProperty("java.class.path");
    String usdir = System.getProperty("user.dir");

    System.out.println("Static CheckWallet is looking at the file system");
    System.out.println("Classpath:" + cpath + " User Dir:" + usdir);
   
  try{
   
    File file = new File("" + usdir + "mywallet.txt");
    if (file == null) {
      System.out.println("File should not be null.");
    }
    if (!file.exists()) {
      System.out.println("File does not exist: " + file);
    }
    if (!file.isFile()) {
      System.out.println("Should not be a directory: " + file);
    }
    if (!file.canWrite()) {
      System.out.println("File cannot be written: " + file);
    }

    log("Buffer loaded from file\n");

 //log("Reaching for my Wallet\n");
    //File file = new File("mywallet.txt");
     // log("Looking for mywallet.txt\n");
 //verifyFile(file);
    //readWithBuffer(file);
    //

  }catch(Exception e){
    log("You have lost your wallet!");
    return getLogString().toString();
  }

    

    Wallet read = new Wallet();
    try {
      read.readFileViaStream();
      //read.readFileasViaUrl();
      //read.readFileViaPath();
    
      } catch (IOException e1) {
        log("Wallet.read IOException thrown");
        //e1.printStackTrace();
      } catch(Exception e2){
        System.out.println("Wallet Error");
        e2.printStackTrace();
      }
  

    
    log("Feels like there could be a wallet in your pocket");
    return getLogString().toString();  
  }

  
  private static void log(Object msg){
      logString.append(Objects.toString(msg));
  }


  /**
  * @param file is a file which already exists and can be read.
  */
  static public void readWithBuffer(File file) {
    try (Reader input = new BufferedReader(new FileReader(file))){
      int data = 0;
      while ((data = input.read()) != -1){
        //do nothing
      }
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
  * @param file is an existing file which can be read.
  */
  static public void readWithoutBuffer(File file) {
    try (Reader input = new FileReader(file)){
      int data = 0;
      while ((data = input.read()) != -1){
        //do nothing
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
  }

  private static void verifyFile(File file) {
    if (file == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!file.exists()) {
      throw new IllegalArgumentException ("File does not exist: " + file);
    }
    if (!file.isFile()) {
      throw new IllegalArgumentException("Should not be a directory: " + file);
    }
    if (!file.canWrite()) {
      throw new IllegalArgumentException("File cannot be written: " + file);
    }
  }



  /* Must have a instance to use these */

    /**
     * @implNote uses the CreditCard Class
     * @return
     */
    public ArrayList getCardData(){
        CreditCard card = new CreditCard();
        card.loadDefaultCard();
        return card.getList();
    }
    public void saveWallet(){
      System.out.println(getCardData().toString());
    }

    public void add(int i) {
    }
    
  
    void readFileViaStream() throws IOException {
      log("Via stream...");
      try (
        //uses the class loader search mechanism:
        InputStream input = this.getClass().getResourceAsStream(walletFileName);
        InputStreamReader isr = new InputStreamReader(input, ENCODING);
        BufferedReader reader = new BufferedReader(isr);
      ){
        String line = null;
        while ((line = reader.readLine()) != null) {
          //process the line in some way
          log(line);
        }      
      }
    }
    
    void readFileasViaUrl() throws IOException{
      log("Via URL...");
      //this doesn't work in a Java Web Start context
      //the URL points back to the server; it's not local
      //uses the class loader search mechanism:
      java.net.URL url = this.getClass().getResource(walletFileName);
      URI uri = null;
      try {
        uri = url.toURI();
      }
      catch(URISyntaxException ex){
        //in practice this will be very rare
        ex.printStackTrace();
      }
      Path path = Paths.get(uri);    
      
      //now that you have the path, it's just regular text file processing
      
      //this gets the whole content at once:
      List<String> lines = Files.readAllLines(path, ENCODING);
      log("Number of lines in the file: "  + lines.size());
      
      //OR, use this style, to process each line one at a time
      try (Scanner scanner =  new Scanner(path, ENCODING.name())){
        while (scanner.hasNextLine()){
          //process each line in some way
          log(scanner.nextLine());
        }      
      }    
    }
    
    /**
     Here, relative Path objects don't know about the file system in the same way that a 
     classloader does. It only knows about the 'user.dir' directory, the base 
     directory of the runtime; this style is much less flexible, and is not 
     recommended.
    */
    void readFileViaPath() throws IOException{
      log("Via path (not recommended)...");
      //Succeeds: absolute reference
      //Path path = Paths.get("C:\\myproj\\test-api\\bin\\test.txt"); 
      
      /*
      * Relative reference.
      * 
      * Fails when the file is beside the .class file.
      * Succeeds only when the test.txt file is in the 'user.dir' directory.
      * 
      * This means that relative paths don't use the classpath; they 
      * only use the 'user.dir' System property.
      */
      Path path = Paths.get("test.txt"); 
      
      log("Path: " + path);
      log("Absolute: " + path.isAbsolute());
      List<String> lines = Files.readAllLines(path, ENCODING);
      log("Number of lines in the file: "  + lines.size());
    }
    
   


 /**
  * old code 
  
  */   
    class CardAccount{

        CardAccount(){

        }

        void loadDefaultCard(){
            setBankAccount_name("Capitol One Gold");
            setCc_type("Visa Quick Silver Points");
            setCc_number("9999 9999 9999 9999");
            setCc_expire("12/2023");
            setLastDue_date("1/4/2022");
            setNextDue_date("2/4/2022");
            setLastPayment_amount("$50.00");
            setNextPayment_amount("$100.00");
            setMaxBalance_amount("$1000.00");
            setInterestRate("23.99%");

        }
        ArrayList getList(){
            ArrayList list = new ArrayList<>();
            list.add(getBankAccount_name());
            list.add(getCc_type());
            list.add(getCc_number());
            list.add(getCc_expire());
            list.add(getLastDue_date());
            list.add(getNextDue_date());
            list.add(getLastPayment_amount());
            list.add(getNextPayment_amount());
            list.add(getMaxBalance_amount());
            list.add(getInterestRate());
            return list;


        }
   
    public String getBankAccount_name() {
        return bankAccount_name;
    }

    public void setBankAccount_name(String bankAccount_name) {
        this.bankAccount_name = bankAccount_name;
    }

    public String getCc_type() {
        return cc_type;
    }

    public void setCc_type(String cc_type) {
        this.cc_type = cc_type;
    }

    public String getCc_number() {
        return cc_number;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public String getCc_expire() {
        return cc_expire;
    }

    public void setCc_expire(String cc_expire) {
        this.cc_expire = cc_expire;
    }

    public String getLastDue_date() {
        return lastDue_date;
    }

    public void setLastDue_date(String lastDue_date) {
        this.lastDue_date = lastDue_date;
    }

    public String getNextDue_date() {
        return nextDue_date;
    }

    public void setNextDue_date(String nextDue_date) {
        this.nextDue_date = nextDue_date;
    }

    public String getLastPayment_amount() {
        return lastPayment_amount;
    }

    public void setLastPayment_amount(String lastPayment_amount) {
        this.lastPayment_amount = lastPayment_amount;
    }

    public String getNextPayment_amount() {
        return nextPayment_amount;
    }

    public void setNextPayment_amount(String nextPayment_amount) {
        this.nextPayment_amount = nextPayment_amount;
    }

    public String getMaxBalance_amount() {
        return maxBalance_amount;
    }

    public void setMaxBalance_amount(String maxBalance_amount) {
        this.maxBalance_amount = maxBalance_amount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

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

    }


    class SomeCreditAccount{
        //Raw elements not implemented
        int cc_id;
        Currency cc_amount;
        String cc_number;
        String cc_number_plain;
        int cc_type_id;
        String bankAccount_name;
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
        

    }
}
