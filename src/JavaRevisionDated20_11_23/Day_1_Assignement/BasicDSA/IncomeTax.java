package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;

import java.util.Scanner;

public class IncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double income = sc.nextDouble();
            double tax = 0;

            if (income > 0 && income <= 180000) {
                tax = 0;
                System.out.println(tax);
            } else if (income > 180001 && income <= 300000) {
                tax = 0.1 * income;
                System.out.println(tax);
            } else if (income > 300001 && income <= 500000) {
                tax = 0.2 * income;
                System.out.println(tax);
            } else {
                tax = 0.3 * income;
                System.out.println(tax);
            }
        }catch (Exception ex) {
            System.out.println("Number Format Exception");
        }
    }
}
