package leetcode;

public class MergeStrings {
    public static String mergeStrings(String word1, String word2) {
        StringBuilder merged = new StringBuilder();

        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                merged.append(word1.charAt(i));
                i++;
            }

            if (j < word2.length()) {
                merged.append(word2.charAt(j));
                j++;
            }
        }

        return merged.toString();
    }

    public static void main(String[] args) {
        String word1 = "hello";
        String word2 = "wo";
        String result = mergeStrings(word1, word2);
        System.out.println(result);
    }
}

