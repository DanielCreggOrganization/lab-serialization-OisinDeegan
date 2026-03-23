package ie.atu.serialization;

import java.io.Serializable;

public class Bankaccount implements Serializable {
    private String accountNum;
    private String accountHolder;
    private double balance;
    private transient String pin;

    public Bankaccount(String accountNum,String accountHolder, double balance, String pin){
        this.accountHolder=accountHolder;
        this.accountNum=accountNum;
        this.balance=balance;
        this.pin=pin;
    }

    @Override
    public String toString(){
        return "BankAccount{accountNumber='"+accountNum+"', accountHolder='"+accountHolder+"', balance="+balance+", pin='"+pin+"'}";
    }
}
