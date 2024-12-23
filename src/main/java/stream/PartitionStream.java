package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionStream {
    public static void main(String[] args) {

        /*
         * Collectors.partitioningBy divides the stream into two groups based on a predicate: true and false.
         * Since it is similar to Collectors.groupingBy, refer to the GroupStream class in this package for more details.
         */

        List<ProductEntity> productList = Arrays.asList(
                new ProductEntity("potatoes", 23),
                new ProductEntity("orange", 14),
                new ProductEntity("lemon", 13),
                new ProductEntity("bread", 23),
                new ProductEntity("sugar", 13)
        );

        Map<Boolean, List<String>> partitionByPrice =
                productList.stream().collect(
                        Collectors.partitioningBy(
                                product -> product.getPrice() > 15
                                , Collectors.mapping(
                                        ProductEntity::getName
                                        , Collectors.toList()
                                )
                        )
                );

        System.out.println("partitionByPrice = " + partitionByPrice);
    }
}
