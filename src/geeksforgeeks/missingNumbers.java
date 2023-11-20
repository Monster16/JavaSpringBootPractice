package geeksforgeeks;

import java.util.Arrays;

public class missingNumbers {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5};
        Solution2 solution2 = new Solution2();
        int result = solution2.missingNumber(A);
        System.out.println(result);

    }
}

class Solution2 {
    int missingNumber(int array[]) {
        int flag = 0;
        Arrays.sort(array);
        int result = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i]!= i+1)
            {
                result = i + 1;
                flag = 1;
                break;
            }
        }
        if(flag == 0) return 0;
        return result;
    }
}
