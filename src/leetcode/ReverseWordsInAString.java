package leetcode;

public class ReverseWordsInAString {

    public static String reverseWord(String s){
        String words[] = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i-- ){
            result.append(words[i]);

            if(i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {

        String word = "   sky is blue    ";
        String result = reverseWord(word);
        System.out.println(result);
    }
}
