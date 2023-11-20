package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("Java");
        collection.add("python");
        collection.add("c++");
        System.out.println("printing the collections: "+ collection);

        //check if the collection is empty
        System.out.println("Is the collection empty? " + collection.isEmpty());

        //Iterate over the elements in the collection
        System.out.println("Element in the collection: ");
        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Remove an element from the collection
        collection.remove("Java");

        //check the size of the collection
        System.out.println("After deletion size of collection: " + collection.size());
    }
}
