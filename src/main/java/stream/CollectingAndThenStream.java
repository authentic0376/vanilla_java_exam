package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectingAndThenStream {
    public static void main(String[] args) {
        /*
         * collectingAndThen is used to perform post-processing after collecting data with a Collector.
         * The function (transforming function) provided as the second argument transforms or wraps the resulting collection.
         */

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3, 4, 1, 2, 3, 3, 4, 1, 5, 2);
        // Initialized this way to create a mutable list

        // Convert the stream to a Set and then make it an unmodifiableSet
        Set<Integer> unmodifiableSet = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toSet(),
                        Collections::unmodifiableSet
                )
        );
        // unmodifiableSet.add(3); runtime error

        System.out.println("unmodifiableSet = " + unmodifiableSet);

        // Convert the stream to a List and then make it an unmodifiableList
        List<Integer> unmodifiableList = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                )
        );
        // unmodifiableList.add(3); runtime error

        System.out.println("unmodifiableList = " + unmodifiableList);

    }
}
