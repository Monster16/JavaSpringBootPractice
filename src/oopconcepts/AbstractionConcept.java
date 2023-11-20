package oopconcepts;


abstract class Shape {
    abstract void draw();
}
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}
class Square extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Square");
    }
}
public class AbstractionConcept {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Square();
        shape1.draw();
        shape2.draw();
    }
}


