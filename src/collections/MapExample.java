package collections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        //Adding element to the map
        map.put("Java",1);
        map.put("Python",2);
        map.put("C++",4);

        //Access elements in the map
        System.out.println("The value for the Key Java is: " + map.get("Java"));
        System.out.println("The value for the Key Ruby is: " + map.get("Ruby")); // This will return null since the key does not exist in the map

        //Modify elements in the map
        map.put("java",5);

        //Remove elements in the map
        map.remove("C++");

        //print the element of map
        System.out.println("Elements in the map: " + map);
    }
}
