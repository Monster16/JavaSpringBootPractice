package oopconcepts.polymorphism;


class Shape {
    public void draw(){
        System.out.println("Drawing a shape");
    }
}
class Circle extends Shape {
    public void draw(){
        System.out.println("Drawing a circle");
    }
}
public class PolymorphismOverridingConcept {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Shape circle = new Circle();
        shape.draw();
        circle.draw();
    }
}
