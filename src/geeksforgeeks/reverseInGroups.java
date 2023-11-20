package geeksforgeeks;
import java.io.*;
import java.util.*;
class reverseInGroups {
    //{ Driver Code Starts
//Initial Template for Java
    public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
//
//            //while testcases exist
//            while(t-->0){
//
//                String inputLine1[] = br.readLine().trim().split(" ");
//                int n = Integer.parseInt(inputLine1[0]);
//                int k = Integer.parseInt(inputLine1[1]);
//
//                ArrayList<Integer> arr = new ArrayList<>();
//                String inputLine2[] = br.readLine().trim().split(" ");
//                for(int i=0; i<n; i++){
//                    arr.add(Integer.parseInt(inputLine2[i]));
//                }
//
//                Solution1 obj = new Solution1();
//                obj.reverseInGroups(arr, n, k);
//
//                StringBuffer str = new StringBuffer();
//                for(int i=0; i<n; i++){
//                    str.append(arr.get(i) + " ");
//                }
//                System.out.println(str);
//            }
        Solution1 reverser = new Solution1();
        int n = 5;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        int k = 3;


        reverser.reverseInGroups(arr, k);
        // Print the modified ArrayList
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
    }


// } Driver Code Ends


//User function Template for Java

    static class Solution1 {
        //Function to reverse every sub-array group of size k.
        void reverseInGroups(ArrayList<Integer> arr, int k) {
            // code here

            int n = arr.size();
            for (int i = 0; i < n; i += k) {
                int left = i;
                int right = Math.min(i + k - 1, n - 1);
                System.out.println(i);
                System.out.println(left);
                System.out.println(right);

                Collections.reverse(arr.subList(left, right + 1));
            }
        }
    }
}




