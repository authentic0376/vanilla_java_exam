package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SumStream {
    public static void main(String[] args) {

        // Primitives
        int sum = IntStream.rangeClosed(1, 4).sum();
        System.out.println("sum = " + sum);


        // Reference Type
        List<ProductEntity> productEntityList = Arrays.asList(
                new ProductEntity("potatoes", 23),
                new ProductEntity("orange", 14),
                new ProductEntity("lemon", 13),
                new ProductEntity("bread", 23),
                new ProductEntity("sugar", 13)
        );

        sum = productEntityList.stream().mapToInt(ProductEntity::getPrice).sum();
        // productEntityList.stream().collect(Collectors.summingInt(ProductEntity::getPrice));

        System.out.println("sum = " + sum);



    }
}
