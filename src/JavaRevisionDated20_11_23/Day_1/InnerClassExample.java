package JavaRevisionDated20_11_23.Day_1;

public class InnerClassExample {
    public static void main(String[] args) {

//        OuterClass outerClass = new OuterClass();
//        OuterClass.InnerClass myInner = outerClass.new InnerClass();
//        System.out.println(outerClass.x + myInner.y);

        OuterClass.InnerClass outerClass1 = new OuterClass.InnerClass();
        System.out.println(outerClass1.y);
    }
}

class OuterClass {
    int x = 5;

    static class InnerClass {
        int y = 10;
    }
}
