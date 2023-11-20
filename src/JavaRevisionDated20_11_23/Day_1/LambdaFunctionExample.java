package JavaRevisionDated20_11_23.Day_1;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctionExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Consumer<Integer> integerConsumer = (n) -> {System.out.println(n);};
        list.forEach(integerConsumer);

//        System.out.println(list);
        list.forEach( (n) -> {System.out.println(n);});
    }
}
