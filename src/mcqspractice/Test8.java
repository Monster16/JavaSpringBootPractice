package mcqspractice;

public class Test8 {
    public void m1(String s){
        System.out.println("String");
    }

    public void m1(StringBuffer sb){
        System.out.println("StringBuffer");
    }
    public static void main(String[] args) {
        Test8 test8 = new Test8();
        test8.m1("string");
        test8.m1(new StringBuffer("stringbuffer"));
//        test8.m1(null);  // Compilation error on this line
    }
}
