package mcqspractice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Data2 {
    int number;
    Data2(int number) {
        this.number = number;
    }
}
public class Test1 {
    public static void main(String[] args) {
        Set<Data2> set1 = new HashSet<>();

        set1.add( new Data2(1));
        Set<Data2> set2 = Collections.unmodifiableSet(set1);
        set2.stream().findAny().get().number = 2;
        int number = set1.stream().findAny().get().number;
        System.out.println(number);
    }
}
