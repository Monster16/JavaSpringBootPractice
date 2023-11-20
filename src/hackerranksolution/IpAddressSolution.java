package hackerranksolution;

import java.util.Scanner;

public class IpAddressSolution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String IP = sc.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex{
    String num = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
    String pattern = num + "." + num + "." +num + "." + num;
}
