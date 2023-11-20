package JavaRevisionDated20_11_23.Day_1;

public class Vehicle {

    protected String brand = "Ferrari";
    void honk(){
        System.out.println("Hummm hummmmm");
    }
}

class Car extends Vehicle {
    private String modelName = "Mustang";
    public static void main(String[] args) {
        Car car = new Car();
        car.honk();
        System.out.println(car.brand + " " + car.modelName);
    }
}
