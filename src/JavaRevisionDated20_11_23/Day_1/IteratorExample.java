package JavaRevisionDated20_11_23.Day_1;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("BMW");
        data.add("TATA");
        data.add("MAHINDRA");
        data.add("HERO");

        Iterator<String> iterator = data.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
