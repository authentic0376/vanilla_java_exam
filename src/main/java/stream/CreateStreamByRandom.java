package stream;

import java.util.Random;
import java.util.stream.DoubleStream;

public class CreateStreamByRandom {
    public static void main(String[] args) {
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(5);
        doubleStream.forEach(System.out::println);
    }
}
