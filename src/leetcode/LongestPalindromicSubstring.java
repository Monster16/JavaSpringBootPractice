package leetcode;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }

        boolean[][] isPalindrome = new boolean[n][n];
        int start = 0;
        int maxLength = 1;

        // All single characters are palindromes
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for palindromes of length greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1; // Ending index of the current substring
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindromicSubstring = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstring);
    }
}

