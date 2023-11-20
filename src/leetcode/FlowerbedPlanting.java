package leetcode;

public class FlowerbedPlanting {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            // Check if the current position is empty and its adjacent positions are also empty
            if(flowerbed[i] == 0){
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) ||
                        (flowerbed[i + 1] == 0);

                if(emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 0, 1};
        int n = 2;

        boolean result = canPlaceFlowers(flowerbed, n);
        System.out.println(result); // Output: true

    }
}

