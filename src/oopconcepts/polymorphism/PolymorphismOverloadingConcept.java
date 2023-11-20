package oopconcepts.polymorphism;


class Animal {
    public void sound(){
        System.out.println("Animal makes a Sound...");
    }
}

class Dog extends Animal {
    public void sound(){
        System.out.println("Dog barks...");
    }
}

class Cat extends Animal {
    public void sound(){
        System.out.println("Cat meows...");
    }
}

public class PolymorphismOverloadingConcept {

    public static void main(String[] args) {

       Animal animal1 = new Animal();
       Animal animal2 = new Dog();
       Animal animal3 = new Cat();
       animal1.sound();
       animal2.sound();
       animal3.sound();

    }
}
