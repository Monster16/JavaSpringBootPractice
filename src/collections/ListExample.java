package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        List<String> list1 = new LinkedList<>();

        //Add element to the list
        list.add("Java");
        list.add("java");
        list.add("Python");
        list.add("C++");

        //printing the first and last element
        System.out.println("Printing the first element: " + list.get(0));
        System.out.println("Printing the last element: " + list.get(list.size()-1));
        System.out.println("printing the lists: "+ list);

        //Modifying the list
        list.set(1,"Ruby");
        System.out.println("The modified list is: "+ list);

        //Removing from the list
        list.remove(3);
        System.out.println("The updated list is: "+ list);

    }
}
