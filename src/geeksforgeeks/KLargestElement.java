package geeksforgeeks;

import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 8, 9, 10, 2};
        int k = 3; // Change k to the desired number of largest elements.

        if (k <= 0 || k > arr.length) {
            System.out.println("Invalid value of K.");
            return;
        }

        // Create a max heap (PriorityQueue in reverse order) to store the K largest elements.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> Integer.compare(b, a));

        // Insert the first K elements into the max heap.
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        // Process the remaining elements in the array.
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > maxHeap.peek()) {
                maxHeap.poll(); // Remove the smallest element in the heap.
                maxHeap.add(arr[i]); // Add the larger element.
            }
        }

        // Print the K largest elements in decreasing order.
        System.out.println("K largest elements (in decreasing order):");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
