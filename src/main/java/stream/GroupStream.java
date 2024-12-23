package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStream {
    public static void main(String[] args) {
        /*
         * Example of grouping elements in a stream.
         *
         * Collectors.groupingBy(classifier[, downstream])
         *
         * classifier: A method that takes an item and generates a key. Elements with the same key are grouped together.
         * downstream: An additional operation (method) to perform on the grouped data.
         */

        List<ProductEntity> productEntityList = Arrays.asList(
                new ProductEntity("potatoes", 23)
                , new ProductEntity("orange", 14)
                , new ProductEntity("lemon", 13)
                , new ProductEntity("bread", 23)
                , new ProductEntity("sugar", 13)
        );

        // ----------------------------------------------------------------------------------------------
        // Without downstream

        // Grouping by name length
        Map<Integer, List<ProductEntity>> productGroupsByNameLength =
                productEntityList.stream().collect(Collectors.groupingBy(product->product.getName().length()));

        System.out.println("productGroupsByNameLength = " + productGroupsByNameLength);

        // ----------------------------------------------------------------------------------------------
        // With downstream

        // Grouping by the length of the name and performing an additional operation ("counting") on each group
        Map<Integer, Long> ProductCountByNameLength =
                productEntityList.stream().collect(
                        Collectors.groupingBy(
                                product -> product.getName().length()
                                , Collectors.counting()
                        )
                );

        System.out.println("ProductCountByNameLength = " + ProductCountByNameLength);

        // ----------------------------------------------------------------------------------------------
        // With Collectors.mapping()

        // Grouping names by price
        Map<Integer, List<String>> productNameGroupsByPrice =
                productEntityList.stream().collect(
                        Collectors.groupingBy(
                                ProductEntity::getPrice // classifier
                                , Collectors.mapping(   // downstream: a Collector implementing the downstream reduction
                                        ProductEntity::getName  // mapper: a function to be applied to the input elements
                                        , Collectors.toList()   // downstream: a collector which will accept mapped values
                                )
                        )
                );

        /*
         * Methods in Collectors are used to collect streams into collections. The methods return a Collector.
         * The grouping operation is delegated in the order: groupingBy -> mapping -> toList.
         *
         * The downstream parameter in mapping() cannot be omitted.
         */
        System.out.println("productNameGroupsByPrice = " + productNameGroupsByPrice);

        // Example of using "joining" instead of toList
        Map<Integer, String> productNamesStringByPrice =
                productEntityList.stream().collect(
                        Collectors.groupingBy(
                                ProductEntity::getPrice
                                , Collectors.mapping(
                                        ProductEntity::getName
                                        , Collectors.joining("//", "<<", ">>")
                                )
                        )
                );

        System.out.println("productNamesStringByPrice = " + productNamesStringByPrice);

        // Grouping names by their length and converting each group to "uppercase"
        Map<Integer, List<String>> uppercaseProductNameGroupsByNameLength =
                productEntityList.stream().collect(
                        Collectors.groupingBy(
                                product -> product.getName().length()
                                , Collectors.mapping(
                                        product -> product.getName().toUpperCase()
                                        , Collectors.toList()
                                )
                        )
                );

        System.out.println("uppercaseProductNameGroupsByNameLength = " + uppercaseProductNameGroupsByNameLength);

    }

}
