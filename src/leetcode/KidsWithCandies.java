package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {

        int candies[] = {1,2,4,5,3};
        int extraCandy = 3;
        Solution3 solution3 = new Solution3();
        List<Boolean> result =  solution3.kidsWithCandies(candies, extraCandy);
//        result.forEach(System.out::println);
        System.out.println(result);
    }
}

class Solution3 {
    public List<Boolean> kidsWithCandies (int[] candies, int extraCandies){
        int maxCandies = 0;

        for(int candy : candies){
            maxCandies = Math.max(candy, maxCandies);
        }

        List<Boolean> result = new ArrayList<>();
        for(int candy: candies){
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }
}
