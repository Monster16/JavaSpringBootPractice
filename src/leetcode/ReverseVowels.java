package leetcode;

public class ReverseVowels {
    public static String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            while (left < right && !isVowel(charArray[left])) {
                left++;
            }

            while (left < right && !isVowel(charArray[right])) {
                right--;
            }

            // Swap vowels
            if (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }

        return new String(charArray);
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        String input = "Hello World";
        String result = reverseVowels(input);
        System.out.println(result);  // Output: Holle Werld
    }
}

