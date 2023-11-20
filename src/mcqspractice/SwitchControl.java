package mcqspractice;

public class SwitchControl {
    public static void main(String[] args) {
        int i = 10;
        switch (10) { // Compilation error will be caused if given boolean. It only support byte,int,short and long.
            case 10 : System.out.println("Case 10");
            break;
            case 20 : System.out.println("case 20");
            break;
            default : System.out.println("Default case"); // for default only default keyword is used!!
            break;
        }
    }
}
