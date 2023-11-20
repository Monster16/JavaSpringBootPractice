package hackerranksolution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the inputs");
        String s = scan.nextLine();
        scan.close();

        String[] tokens = s.split("[ !,?._'@]+");
        tokens = Arrays.asList(tokens)
                        .stream()
                                .filter(str -> !str.isEmpty())
                                        .collect(Collectors.toList())
                                                .toArray(new String[0]);
        System.out.println(tokens.length);
        for (String token : tokens){
            System.out.println(token);
        }
    }
}
