package mcqspractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test {

    static String text = "foo";
    public static void main(String[] args) {

        if (!text.equals("Foo")){
            String text = "bar";
//            System.out.println(text);
        }else {
            String text = "baz";
//            System.out.println(text);
        }
        System.out.println(text);
      /*  Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        var i1 = deque.peek();
        var i2 = deque.poll();
        var i3 = deque.peek();

        System.out.println(i1 + ""  + i2 + "" +i3);
       */
    }
}
