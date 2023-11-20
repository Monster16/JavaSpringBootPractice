package collections;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {
    public static void main(String[] args) {

        SortedSet<Integer> sortedSet1 = new TreeSet<>();
        SortedSet<String> sortedSet = new TreeSet<>();

        //Adding element to the set
        sortedSet1.add(1);
        sortedSet1.add(2);
        sortedSet1.add(3);
        sortedSet1.add(3);

        sortedSet.add("Java");
        sortedSet.add("Java");
        sortedSet.add("java");

        System.out.println(sortedSet);
        System.out.println(sortedSet1);


    }
}
