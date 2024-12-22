package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamJoiningToString {
    public static void main(String[] args) {
        /*
         * This is an example to demonstrate joining elements of a stream.
         * Note that there is actually a simpler way to join elements of a list:
         *
         *   String str = String.join(delimiter, list)
         *
         */


        List<String> list = Arrays.asList("abc", "de", "fg");

        String str = list.stream().collect(Collectors.joining("..", "<", ">"));
        System.out.println("str = " + str);
        // str = <abc..de..fg>
    }
}
