package JavaRevisionDated20_11_23.Day_1;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<>();
        cars.add("TATA");
        cars.add("NANO");
        cars.add("HONDA");
        cars.add("HERO");
        cars.add("HERO");

        System.out.println(cars);
        System.out.println(cars.contains("HERO"));
    }
}
