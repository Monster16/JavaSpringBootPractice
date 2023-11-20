package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;

import java.util.Scanner;

/**
 * Question
 * Find out if the given number is an Armstrong Number.
 */
public class ArmStrongNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
        int number = sc.nextInt();
        int temp, remainder, result = 0;
        int n = 0;
        temp = number;
        // finding the number of digits

            while (temp != 0) {
                temp /= 10;
                ++n;
            }
            temp = number;

            // checking the number is armstrong

            while (temp != 0) {
                remainder = temp % 10;
                int digitPower = 1;
                for(int i = 0; i < n; i++){
                    digitPower *= remainder;
                }
//                result += Math.pow(remainder, n);
                result += digitPower;
                temp /= 10;
            }
            if (result == number) {
                System.out.print(number + " is an Armstrong number\n");
            } else {
                System.out.print(number + " is not an Armstrong number\n");
            }
        } catch (Exception ex){
            System.out.println("Please enter valid Number");
        } finally {
            sc.close();
        }
    }
}