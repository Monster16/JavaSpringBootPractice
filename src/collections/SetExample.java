package collections;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        //Adding into the set
        set.add("java");
        set.add("Python");
        set.add("C++");
        set.add("java"); //  since sets do not allow duplicates
        set.add("Java"); // This is allowed since its case-sensitive.

        //Printing every element
        System.out.println("printing the sets: "+ set);

        //checking particular element in set
        System.out.println("Checking python present or not? "+ set.contains("Python"));

        //Remove element from set
        set.remove("Java");
        System.out.println("printing the sets: "+ set);

    }
}
