package JavaRevisionDated20_11_23.Day_1;

public class TryandCatchExample {
    public static void main(String[] args) {

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[10]);
        } catch (Exception ex) {
            System.out.println("Something went wrong "+ ex.getMessage());
        } finally {
            System.out.println("This Block automatically get executed after Try_Catch Block!!!");
        }
    }
}
