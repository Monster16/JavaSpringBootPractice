package geeksforgeeks;

public class DeEliminateOddFromString {

    public static String deleteOddCharacters(String s){
        StringBuilder result = new StringBuilder();

        for( int i = 0; i < s.length(); i++){
            if ( i % 2 == 0) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello World";
        String res = deleteOddCharacters(input);
        System.out.println("Original String: " + input);
        System.out.println("String with Odd Indices Deleted: " + res);
    }
}
