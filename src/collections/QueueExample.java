package collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(4);

        //print the element in the queue
        System.out.println("Element in the Queue: " + queue);

        // Remove the first element from the queue
        System.out.println("Removed element: " + queue.remove());

        // Print the elements in the queue after removing an element
        System.out.println("Elements in the queue: " + queue);

    }
}
