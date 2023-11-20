package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        //Add elements to the deque

       /* deque.add("Java");
        deque.add("java");
        System.out.println(deque);
        */

        deque.addFirst("Java");
        deque.addLast("Python");
        deque.addLast("C++");
        deque.add("Hello");
        deque.add("World");
        System.out.println("Element in the deque: "+ deque);

        //Retrieve the head and tail of the deque using peek
        System.out.println("Head of the deque using peek: " + deque.peekFirst());
        System.out.println("Tail of the deque using peek: " + deque.peekLast());
        System.out.println("Element in the deque: "+ deque);

        //Remove and retrieve the head and tail of the deque using Poll
        System.out.println("Head of the deque using poll: "+deque.pollFirst());
        System.out.println("Tail of the deque using poll: "+deque.pollLast());

        //Printing after the poll
        System.out.println("Element in the deque: "+ deque);


    }
}
