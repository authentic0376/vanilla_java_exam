package stream;

import java.util.stream.IntStream;

public class CharStream {
    public static void main(String[] args) {
        /*
        * Since there is no such thing as CharStream, IntStream is used instead
        */

        IntStream streamOfChars = "abc".chars();
        streamOfChars.forEach(System.out::println); // 97 98 99

        "abc".chars() // A stream that has been closed cannot be reused, so a new stream is created
                .mapToObj(c -> (char) c) // IntStream -> Stream<Character>
                .forEach(System.out::println); // a b c

        "abc".chars()
                .forEach(s -> System.out.println((char) s)); // a b c
    }
}
