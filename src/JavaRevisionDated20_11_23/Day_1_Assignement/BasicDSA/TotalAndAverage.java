package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;

import java.util.Scanner;

public class TotalAndAverage {
    public static void main(String[] args) {

//        int numStudents = 3;
//        int numSubject = 3;

        int[][] marks = new int[3][3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            System.out.println("Enter scores for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++){
                System.out.println("Enter scores for Student " + (j + 1) + ":");
                marks[i][j] = sc.nextInt();
            }
        }
        System.out.println("Total score of stud1 = "+ (marks[0][0]+marks[1][0]+marks[2][0]));
        System.out.println("Total score of stud2 = "+ (marks[0][1]+marks[1][1]+marks[2][1]));
        System.out.println("Total score of stud3 = "+ (marks[0][2]+marks[1][2]+marks[2][2]));

        System.out.println("Average score of stud1 = "+ ((double)(marks[0][0]+marks[1][0]+marks[2][0])/3));
        System.out.println("Average score of stud2 = "+ ((double)(marks[0][1]+marks[1][1]+marks[2][1])/3));
        System.out.println("Average score of stud3 = "+ ((double)(marks[0][2]+marks[1][2]+marks[2][2])/3));

        System.out.println("Total score of sub1 = "+ (marks[0][0]+marks[0][1]+marks[0][2]));
        System.out.println("Total score of sub2 = "+ (marks[1][0]+marks[1][1]+marks[1][2]));
        System.out.println("Total score of sub3 = "+ (marks[2][0]+marks[2][1]+marks[2][2]));

        System.out.println("Average score of sub1 = "+ ((double)(marks[0][0]+marks[0][1]+marks[0][2])/3));
        System.out.println("Average score of sub2 = "+ ((double)(marks[1][0]+marks[1][1]+marks[1][2])/3));
        System.out.println("Average score of sub3 = "+ ((double)(marks[2][0]+marks[2][1]+marks[2][2])/3));
    }
}
