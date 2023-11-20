package JavaRevisionDated20_11_23.Day_1;

public class AbstractClassExample {
    public static void main(String[] args) {
        Pig pig = new Pig();
        pig.animalSound();
        pig.sleep();

    }
}

abstract class Animal1 {
    public abstract void animalSound();
    public void sleep() {
        System.out.println("Zzz");
    }
}

class Pig extends Animal1 {

    @Override
    public void animalSound() {
        System.out.println("The Pig says: wee-wee");
    }
}
