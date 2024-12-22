package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AverageOfStream {
    public static void main(String[] args) {
        /*
         * Example of calculating the average of stream elements.
         *
         * For primitive types, there is a direct method to calculate the average:
         * ex) IntStream.average()
         *
         * For reference types, you need to provide an instance method to extract the value.
         * The stream elements (objects) act as the instance on which the method is called.
         */

        // Primitive types
        double average = IntStream.rangeClosed(1, 4).average().orElse(2); // rangeClosed includes 1, 2, 3, 4
        System.out.println("average = " + average);
        /*
         * The reason for using OptionalDouble instead of double is
         * that if the stream is empty, the average cannot be calculated.
         */

        // Calculating the average by converting primitive types to reference types (not recommended)
        average = IntStream.rangeClosed(1, 4).boxed().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("average = " + average);

        // Reference types
        List<ProductEntity> productEntityList = Arrays.asList(
                new ProductEntity("potatoes", 23),
                new ProductEntity("orange", 14),
                new ProductEntity("lemon", 13),
                new ProductEntity("bread", 23),
                new ProductEntity("sugar", 13)
        );

        average = productEntityList.stream().collect(Collectors.averagingInt(ProductEntity::getPrice));
        // averagingInt calculates the average of int values and returns a double result
        System.out.println("average = " + average);

    }
}
