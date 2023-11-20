package collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {

    public static void main(String[] args) {

        SortedMap<String, Integer> sortedMap = new TreeMap<>();

        //Adding into sorted map
        sortedMap.put("Java",1);
        sortedMap.put("Java",2);
//        sortedMap.put("java",3);
//        sortedMap.put("Python",4);

        System.out.println(sortedMap);

    }
}
