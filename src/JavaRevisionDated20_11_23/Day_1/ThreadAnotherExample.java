package JavaRevisionDated20_11_23.Day_1;

public class ThreadAnotherExample extends Thread{
    public static int amount = 0;

    public static void main(String[] args) {
        ThreadAnotherExample example = new ThreadAnotherExample();
        example.start();
        while (example.isAlive()) {
            System.out.println("Waiting.....");
        }
        System.out.println("Main " + amount);
        amount++;
        System.out.println("Main " + amount);
    }
    public void run() {
        amount++;
    }
}
