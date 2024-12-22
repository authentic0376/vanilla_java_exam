package stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ReduceStream {
    public static void main(String[] args) {
        /*
         * reduce()
         * - identity: the initial value for an accumulator
         * - accumulator: a function which specifies the logic of the aggregation of elements
         * - combiner: a function used to combine the results of the accumulator when
         *   performing a parallel reduction. This parameter is typically used in cases where
         *   the stream is processed in parallel.
         *
         * Depending on the method overload, some parameters may be omitted.
         */

        OptionalInt reduced = IntStream.range(1, 5).reduce((prev_result, element) ->  prev_result * element);
        /*
         * The accumulator takes two arguments and returns a single result.
         * The first parameter is the previous result returned by the reduce operation.
         * The second parameter is the current element of the stream.
         * The elements of the stream are sequentially passed into the accumulator
         * to produce the final result.
         *
         * a + b can be replaced with Integer::sum
         */

        System.out.printf("reduced: %s\n", reduced.orElse(0));

    }
}
