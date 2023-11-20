package JavaRevisionDated20_11_23.Day_1;

import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name, age, salary, phoneNumber:");

        String name = sc.nextLine();
        int age = sc.nextInt();
        double salary = sc.nextDouble();
        long phoneNumber = sc.nextLong();
        System.out.println("Data is: " + name + ", "+ age + ", " + salary +", "+ phoneNumber);
    }
}
