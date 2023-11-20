package codingPractice;

public class DotComGame {
    public static void main(String[] args) {
        DotComGameTestDrive dotComGameTestDrive = new DotComGameTestDrive();
        int[] locations = {2,3,4};
        dotComGameTestDrive.setLocationCells(locations);
        String userGuess = "2";
        String result = dotComGameTestDrive.checkYourself(userGuess);
    }
}
class DotComGameTestDrive {
    int[] locationCells;
    int numberOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;

    }
    public String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "Miss";
        for(int cell: locationCells) {
            if(guess == cell){
                result = "Hit";
                numberOfHits ++;
                break;
            }
        }
        if(numberOfHits == locationCells.length){
            result = "Kill";

        }
        System.out.println(result);
        return result;
    }
}