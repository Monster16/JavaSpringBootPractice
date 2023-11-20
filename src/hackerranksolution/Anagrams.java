package hackerranksolution;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] charArray1 = a.toCharArray();
        Arrays.sort(charArray1);
        String sortedString1 = new String(charArray1);

        char[] charArray2 = b.toCharArray();
        Arrays.sort(charArray2);
        String sortedString2 = new String(charArray2);

        return sortedString1.equals(sortedString2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();
        boolean ret = isAnagram(a,b);
        System.out.println((ret) ? "Anagrams":"Not Anagrams");

    }
}
