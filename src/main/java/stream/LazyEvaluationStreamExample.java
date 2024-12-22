package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LazyEvaluationStreamExample {
    public static void main(String[] args) {

        /*
         * Lazy Evaluation
         * Intermediate Operations are not called before Terminal Operation Called
         * https://www.baeldung.com/java-8-streams#invocation
         *
         * Since findFirst() only needs to find a single element,
         * the lambda passed to the filter() method is not executed three times.
         * Instead, it runs only twice to find the first matching element containing "2".
         * Similarly, the lambda passed to the map() method is executed only once,
         * as it only needs to produce one result.
         */
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");

        Optional<String> found = list.stream().filter(element -> {
            System.out.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();

        System.out.println(found.orElse("abc12"));
    }
}
