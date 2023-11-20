package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;


import java.util.Scanner;

/***
 * Find out the Simple and compound Interest of Supplied Value
 */
public class SimpleAndCompoundInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double principle = sc.nextDouble();
            double rate = sc.nextDouble();
            double time = sc.nextDouble();

            double SI = principle * rate / 100 * time;
            System.out.println(SI);
            double CI = principle * (Math.pow((1 + (rate / 100)), time)) - principle;
            System.out.println(CI);
        } catch (Exception ex) {
            System.out.println("Invalid input " + ex.getMessage());
        }
    }
}
