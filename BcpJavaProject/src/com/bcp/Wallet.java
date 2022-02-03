package com.bcp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;

/**
 * Class Wallet to hold the Credit Cards
 */
public class Wallet {

    public Wallet(){


    }
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

class CreditCard{

        CreditCard(){

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
