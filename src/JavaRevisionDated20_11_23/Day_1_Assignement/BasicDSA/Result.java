package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;

import java.util.Scanner;

/**
 * Question
 *
 */
public class Result {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            float maths = sc.nextFloat();
            float science = sc.nextFloat();
            float history = sc.nextFloat();
            float marks = 60;
            if (maths >= marks && science >= marks && history >= marks) {
                System.out.println("You're Passed!!!");
            } else if (((maths >= marks && science >= marks || history >= marks) || (maths >= marks || science >= marks && history >= marks) || (maths >= marks || science >= marks && history >= marks))) {
                System.out.println("You're Promoted!!!");
            } else {
                System.out.println("You're Fail!!!");
            }
        } catch (Exception ex) {
            System.out.println("Number format Exception!!!!");
        }



    }
}
