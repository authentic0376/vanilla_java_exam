package stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SummaryStatisticsStream {
    public static void main(String[] args) {

        // Primitives
        IntSummaryStatistics statistics = IntStream.rangeClosed(1, 4).summaryStatistics();
        System.out.println("statistics = " + statistics);

        // Reference Type
        List<ProductEntity> productList = Arrays.asList(
                new ProductEntity("potatoes", 23),
                new ProductEntity("orange", 14),
                new ProductEntity("lemon", 13),
                new ProductEntity("bread", 23),
                new ProductEntity("sugar", 13)
        );

        statistics = productList.stream()
                .collect(Collectors.summarizingInt(ProductEntity::getPrice));

        System.out.println("statistics = " + statistics);
        // statistics = IntSummaryStatistics{count=5, sum=86, min=13, average=17.200000, max=23}
    }
}
