package JavaRevisionDated20_11_23.Day_1;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {

        //Create a list of Integer
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        //map function demo
        List<Integer> mapDemo  = number.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(mapDemo);

        //Create a list of String
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

        //Filter function demo
        List<String> filterDemo = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(filterDemo);

        //Sorted function demo
        List<String> sortedDemo = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedDemo);

        // create a list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);

        //collect method
        Set<Integer> collectDemo = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(collectDemo);

        //foreach demo
        number.stream().map(x -> x * x).forEach(y -> System.out.println(y));

        //reduce demo
        int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        System.out.println(even);



    }
}
