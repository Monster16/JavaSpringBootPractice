package JavaRevisionDated20_11_23.Day_1;

public class PolymorphismExample {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.bark();
        Animal cat = new Cat();
        cat.bark();
        Animal dog = new Dog();
        dog.bark();
    }
}
class Animal {
    void bark(){
        System.out.println("Animal is barking");
    }
}

class Cat extends Animal {
    void bark() {
        System.out.println("The cat says: Meow-Meow");
    }
}

class Dog extends Animal{
    void bark() {
        System.out.println("The Dog says: Bhow-Bhow");
    }
}
