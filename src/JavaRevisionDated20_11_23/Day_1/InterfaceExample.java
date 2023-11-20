package JavaRevisionDated20_11_23.Day_1;

public class InterfaceExample {
    public static void main(String[] args) {

        Lion lion = new Lion();
        lion.animalSound();
        lion.sleep();
        lion.eat();
    }
}

interface Animal2 {
    public void animalSound();
    public void sleep();
}
interface Animal3 {
    void eat();
}

class Lion implements Animal2, Animal3{

    @Override
    public void animalSound() {
        System.out.println("Lion says: Grrrr-Grrrr.........");
    }

    @Override
    public void sleep() {
        System.out.println("Zzzzzzzz");
    }

    @Override
    public void eat() {
        System.out.println("Lion is eating.....");
    }
}
