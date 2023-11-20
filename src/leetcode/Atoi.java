package leetcode;

public class Atoi {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int sign = 1;
        int result = 0;

        // Step 1: Remove leading whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Check for '+' or '-'
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Read digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        // Apply sign
        return result * sign;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("42")); // Output: 42
        System.out.println(atoi.myAtoi("   -42")); // Output: -42
        System.out.println(atoi.myAtoi("4193 with words")); // Output: 4193
    }
}

