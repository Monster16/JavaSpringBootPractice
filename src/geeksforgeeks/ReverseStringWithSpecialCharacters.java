package geeksforgeeks;

public class ReverseStringWithSpecialCharacters {
    public static void main(String[] args) {
        String input = "a,b$c";
        String reversedString = reverseString(input);
        System.out.println(reversedString);
    }

    public static String reverseString(String S) {
        char[] charArray = S.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (!Character.isAlphabetic(charArray[left])) {
                left++;
            } else if (!Character.isAlphabetic(charArray[right])) {
                right--;
            } else {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }

        return new String(charArray);
    }
}

