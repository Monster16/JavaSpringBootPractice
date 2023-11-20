package geeksforgeeks;

import java.util.ArrayList;

public class SubarraySum {
    public static ArrayList<Integer> findSubarray(int[] A, int S) {

        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right < A.length) {
            sum += A[right];

            while (sum > S) {
                sum -= A[left];
                left++;
            }
            if (sum == S) {
                if (left > right) break;
                result.add(left + 1);
                result.add(right + 1);
                break;
            }
            right++;
        }
            if (result.isEmpty()) result.add(-1);
            return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int S = 333;

        ArrayList<Integer> subarray = findSubarray(A, S);

        if (subarray.get(0) == -1) {
            System.out.println("No subarray found with sum " + S);
        } else {
            System.out.println("Subarray with sum " + S + " found at indices " + subarray.get(0) + " to " + subarray.get(1));
        }
    }
}

