package JavaRevisionDated20_11_23.Day_1;

public class ThreadsExample implements Runnable {

    public static void main(String[] args) {
        ThreadsExample threadsExample = new ThreadsExample();
        Thread thread = new Thread(threadsExample);
        thread.start();
        System.out.println("This code is outside of thread!!!");
    }
    public void run(){
        System.out.println("This code running in thread!!!");
    }
}
