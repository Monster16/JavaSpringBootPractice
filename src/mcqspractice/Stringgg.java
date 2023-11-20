package mcqspractice;

public class Stringgg {

    public static void main(String[] args) {
        String string1 = "Give";
        String string2 = "Give";
        StringBuilder string3 = new StringBuilder();
        string3.append("Gi").append("ve");

        System.out.println(string1 == string2);
        System.out.println(string1.equals(string2));
        System.out.println(string3.toString() == string1);
        System.out.println(string3.toString().equals(string1));
    }
}
