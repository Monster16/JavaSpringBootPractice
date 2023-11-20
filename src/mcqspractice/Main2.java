package mcqspractice;


import java.security.PublicKey;

class Demo1{
    public int scratchCard(int number){
        if(number < 100) return 1;
        return 0;
    }
}

class Demo2{
    public Demo1 demo1 = new Demo1();
    public int scratchCard(int number ){
        if(number < 50) return 1;
        return 0;
    }
}
public class Main2 {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.scratchCard(75)
                +demo2.scratchCard(45)
                +demo2.demo1.scratchCard(75));
    }
}
