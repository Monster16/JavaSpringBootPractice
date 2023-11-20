package JavaRevisionDated20_11_23.Day_1;

import java.util.LinkedList;

public class LinkListExample {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(111);
        integerLinkedList.add(222);
        integerLinkedList.add(333);
        System.out.println(integerLinkedList);

        System.out.println("After Adding some data............");

        integerLinkedList.addFirst(111);
        integerLinkedList.addLast(444);
        System.out.println(integerLinkedList);

        System.out.println("After Removing some data............");

        integerLinkedList.removeFirst();
        integerLinkedList.removeLast();
        System.out.println(integerLinkedList);

    }
}
