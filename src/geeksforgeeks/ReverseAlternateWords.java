package geeksforgeeks;


// Given a string str consisting of multiple words, reverse alternate words in str.
class ReverseAlternateWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "geeks for geeks";
        System.out.println(solution.reverseAlternate(str));
    }
}
class Solution {
    String reverseAlternate(String s){
        String words[] = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < words.length; i++){
            if(i % 2 == 1){
                String reversedWord = reverseWord(words[i]);
                result.append(reversedWord);
            } else {
                result.append(words[i]);
            }
            if(i < words.length -1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
    private String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
