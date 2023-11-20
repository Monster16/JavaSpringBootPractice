package leetcode;

public class LargestCommonDivisor {
    public static String gcdOfStrings(String str1, String str2) {
//        if (!(str1 + str2).equals(str2 + str1)) {
//            return "";
//        }
//
//        int gcdLength = gcd(str1.length(), str2.length());
//        return str1.substring(0, gcdLength);

        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

//    private static int gcd(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }

    public static void main(String[] args) {
        String str1 = "helhelhel";
        String str2 = "hel";
        String result = gcdOfStrings(str1, str2);
        System.out.println(result);
    }
}

