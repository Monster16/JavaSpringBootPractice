package geeksforgeeks;

public class ReverseArrayRange {
    public static void main(String[] args) {
        int N = 5;
        int[] Arr = {1, 2, 3, 4, 5};
        int L = 2, R = 5;

        reverseRange(Arr, L, R);

        for (int i = 0; i < N; i++) {
            System.out.print(Arr[i] + " ");
        }
    }

    public static void reverseRange(int[] arr, int L, int R) {
        if (L < 0 || R > arr.length || L >= R) {
            // Invalid range or nothing to reverse
            return;
        }

        // Reverse the elements in the specified range
        while (L < R) {
            int temp = arr[L - 1];
            arr[L - 1] = arr[R - 1];
            arr[R - 1] = temp;
            L++;
            R--;
        }
    }
}

