package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;

import java.util.Scanner;

public class loginAttempt {
    public static void main(String[] args) {
//        String Username = "Anil";
//        String Password = "anil";

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3 ; i++) {
        String user = sc.next();
        String pass = sc.next();

        if( user.contains("Anil") && pass.contains("anil")) {
            System.out.println("Welcome " + user);
        } else {
            if(i==2) {
                System.out.println("Contact admin");
            }else {
                System.out.println("Invalid Cred try again!!!");
            }
        }
        }

    }
}
