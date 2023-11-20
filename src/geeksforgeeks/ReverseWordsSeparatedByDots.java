package geeksforgeeks;

//{ Driver Code Starts
//Initial Template for Java


public class ReverseWordsSeparatedByDots {
    public String reverseWords(String s) {
        String[] words = s.split("\\.", -1); // Split the string by dots
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String reversedWord = reverseWord(words[i]);
            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(".");
            }
        }
        return result.toString();
    }

    private String reverseWord(String word) {
//        char[] wordChars = word.toCharArray();
//        int left = 0;
//        int right = wordChars.length - 1;
//
//        while (left < right) {
//            // Swap characters at left and right pointers
//            char temp = wordChars[left];
//            wordChars[left] = wordChars[right];
//            wordChars[right] = temp;
//
//            left++;
//            right--;
//        }
//
//        return new String(wordChars);
        return  new StringBuilder(word).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseWordsSeparatedByDots reverser = new ReverseWordsSeparatedByDots();
        String input = "hello.bubbye.goodbye.";
        System.out.println(reverser.reverseWords(input));
    }
}

