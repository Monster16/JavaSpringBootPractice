package JavaRevisionDated20_11_23.Day_1;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, String> capabilities = new HashMap<>();
        capabilities.put("India", "New Delhi");
        capabilities.put("Nepal", "Kathmandu");
        capabilities.put("USA", "Washington DC");
//        System.out.println(capabilities);

        for(String i : capabilities.keySet()){
            System.out.println(i);
        }
        System.out.println(capabilities.get("India"));

        capabilities.clear();
        System.out.println("Printing clear things" + capabilities);
    }
}
