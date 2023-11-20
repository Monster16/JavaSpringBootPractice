package mcqspractice;

public class IceCream {
    public static void main(String... args) {
        int flavours = 30;
        int eaten = 0;
        switch (flavours){
            case 30: eaten++;
            case 40: eaten+=2;
            default:eaten--;
        }
        System.out.println(eaten);
    }
}
