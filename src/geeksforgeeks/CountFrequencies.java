package geeksforgeeks;

import java.util.Arrays;
import java.util.HashMap;

public class CountFrequencies {

    public static void countFrequencies(int[] arr, int N, int P) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            if(arr[i] >= 1 && arr[i] <= P) {
                map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            }
        }
        for(int i = 0; i < N; i++){
            arr[i] = map.getOrDefault(i+1, 0);
        }
    }

    public static void main(String[] args) {

        int N = 5;
        int[] arr = {2, 3, 2, 3, 5};
        int P = 5;

        countFrequencies(arr,N, P);

        System.out.println(Arrays.toString(arr)); // Updated array with frequency counts
    }

}
