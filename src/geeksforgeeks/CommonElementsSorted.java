package geeksforgeeks;

import java.util.*;

public class CommonElementsSorted {
    public static ArrayList<Integer> commonElementsSorted(int[] v1, int[] v2) {
        // Create HashSet to store unique elements from v1 and v2.
        ArrayList<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> tm1 = new TreeMap<>();
//        HashMap<Integer, Integer> tm1 = new HashMap<>();

        for(int num : v1){
            tm1.put(num, tm1.getOrDefault(num,0)+1);
        }
        for(int num : v2){
            if(tm1.containsKey(num) && tm1.get(num)>0){
                tm1.put(num,tm1.get(num)-1);
                res.add(num);
            }
        }

        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] v1 = {3, 4, 2, 2, 4};
        int[] v2 = {3, 2, 2, 7};

        ArrayList<Integer> result = commonElementsSorted(v1, v2);
        System.out.println("Common elements in sorted order: " + result);
    }
}

