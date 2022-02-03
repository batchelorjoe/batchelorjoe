package com.bcp;

import java.time.LocalDate;
import java.util.Currency;

/**
 * Class Wallet to hold the Credit Cards
 */
public class Wallet {

    public void add(int i) {
    }

    class CreditCard{
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
