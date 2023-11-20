package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;

public class SortUingBubble {
    public static void main(String[] args) {
        int[] arr = {5,12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i <arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
