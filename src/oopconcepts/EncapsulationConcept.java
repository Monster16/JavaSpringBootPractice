package oopconcepts;


class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit( double amount) {

        balance += amount;
    }

    public void withdraw(double amount) {

        if(amount<= balance){
            balance -= amount;
        }else {
            System.out.println("Insufficient funds!!!");
        }
    }

    public double getBalance() {
        return balance;
    }
}
public class EncapsulationConcept {
}
