package codingPractice;

public class MyClass {

    public static void main(String[] args) {
        char f = 97;
        char s = 'A';
        char t = s += 18;
        f++;
        s++;
        System.out.println(f +""+s+""+t);
    }
}
