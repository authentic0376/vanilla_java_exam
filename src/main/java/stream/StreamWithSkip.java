package stream;

import java.util.Arrays;
import java.util.List;

public class StreamWithSkip {
    public static void main(String[] args) {
        /*
         * Skips the given number of elements in the stream.
         * Note that it skips by the number of elements, not by index.
        */
        List<String> list = Arrays.asList("abc1", "abc2", "abc3", "abc4", "abc5");

        list.stream().skip(3).forEach(System.out::println);

        System.out.println("------");

        // Equivalent to calling skip(2).
        list.stream().skip(1).skip(1).forEach(System.out::println);
    }
}
