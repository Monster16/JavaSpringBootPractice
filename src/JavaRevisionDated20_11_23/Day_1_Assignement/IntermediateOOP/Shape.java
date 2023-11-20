package JavaRevisionDated20_11_23.Day_1_Assignement.IntermediateOOP;

public class Shape {
    public static void main(String[] args) {
        Line line = new Line();
        System.out.println(line.draw());

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.draw());

        Cube cube = new Cube();
        System.out.println(cube.draw());
    }
}

class Line extends DrawingShape {

    @Override
    String draw() {
        return "Drawing Line";
    }
}

class Rectangle extends DrawingShape {

    @Override
    String draw() {
        return "Drawing Rectangle";
    }
}

class Cube extends DrawingShape {

    @Override
    String draw() {
        return "Drawing Cube";
    }
}

abstract class DrawingShape {
    abstract String draw();
}
