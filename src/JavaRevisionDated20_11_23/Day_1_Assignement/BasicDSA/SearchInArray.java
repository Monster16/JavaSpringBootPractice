package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int[] arr = {5,12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        int flag = 0;

       for( int i =0; i < arr.length; i++){
           if (arr[i] == number){
               flag = 1;
               break;
           }
       }
        if(flag == 1){
            System.out.println(number + "Number Found!!!\n");
        } else {
            System.out.println(number + " Number not found!!!");
        }
    }
}
