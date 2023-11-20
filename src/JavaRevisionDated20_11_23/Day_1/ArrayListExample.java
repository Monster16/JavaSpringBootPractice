package JavaRevisionDated20_11_23.Day_1;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("BMW");
        data.add("TATA");
        data.add("MAHINDRA");
        data.add("HERO");

        for (String i : data) {
            System.out.println(i);
        }
        data.remove(3);

        for (int i = 0; i < data.size(); i++){
            System.out.println(data.get(i));
        }
        data.set(0, "SUMO");

        for (int i = 0; i < data.size(); i++){
            System.out.println(data.get(i));
        }
    }
}
