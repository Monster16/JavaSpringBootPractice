package mcqspractice;

/* public class Converter {
    public static void main(String[] args) {
        int i = args[0];  // Error on this line
        int j = 12;

        System.out.println("It is " + (j==i) + "that j==i");
    }
}
 */

class Converter {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        System.out.println("Number is: "+num);
    }
}