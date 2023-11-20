package JavaRevisionDated20_11_23.Day_1_Assignement.IntermediateOOP;

public class AccountSavingAndCurrent {
    public static void main(String[] args) {

        Account savingAccount = new Savings(2000, 20000);
        System.out.println(savingAccount.calculateTotalCash());

        Account currentAccount = new Current(5000, 300000);
        System.out.println(currentAccount.calculateTotalCash());
    }
}
interface Account {
     double calculateTotalCash();
}

class Savings implements Account {
    private double balance;
    private double fixedDeposit;

    public Savings(double balance, double fixedDeposit){
        this.balance = balance;
        this.fixedDeposit = fixedDeposit;
    }
    @Override
    public double calculateTotalCash() {
        return balance + fixedDeposit;
    }
}

class Current implements Account {
    private double balance;
    private double cashCredit;

    public Current(double balance, double cashCredit){
        this.balance = balance;
        this.cashCredit = cashCredit;
    }

    @Override
    public double calculateTotalCash() {
        return balance + cashCredit;
    }
}