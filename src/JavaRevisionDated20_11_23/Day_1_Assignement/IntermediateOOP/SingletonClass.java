package JavaRevisionDated20_11_23.Day_1_Assignement.IntermediateOOP;

public class SingletonClass {
    private static SingletonClass instance;
    private SingletonClass(){
    }

    public static SingletonClass getInstance() {
        if (instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }

    public void displayMessage(){
        System.out.println("Singleton class method called.");
    }
}

class Subclass extends SingletonClass{
    public static void main(String[] args) {
        Subclass subclassInstance = new Subclass();
    }
}
