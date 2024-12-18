package stream;

import java.util.stream.Stream;

public class CreateStreamByIterate {
    public static void main(String[] args) {
        /*
         * Stream.iterate(T seed, UnaryOpertor<T> recurrenceRelation)
         * 초항과 점화식을 인자로 받아 스트림을 만든다
         * 수열과 같다
         */

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(5);
        streamIterated.forEach(System.out::println);
    }
}
