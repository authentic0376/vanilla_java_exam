package stream;


import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {
    public static void main(String[] args) {
        /*
        * Stream은 기본타입을 처리하지 못한다
        * 래퍼클래스(Integer, Double 등)로 변환해서 처리하므로 메모리 사용이 늘고 더 느리다
        * 기본타입을 직접 다룰 수 있도록 IntStream, DoubleStream 등이 따로 있다
        *
        * 이 예제는 둘의 효율차이(실행시간차이)를 보여준다
        *
        */

        int n = 10_000_000;

        // IntStream 예제
        long startTime1 = System.currentTimeMillis();
        int intStreamSum = IntStream.range(1, n + 1)
                .filter(i -> i % 2 == 0) // 짝수 필터링
                .sum();
        long endTime1 = System.currentTimeMillis();

        System.out.println("IntStream 결과: " + intStreamSum);
        System.out.println("IntStream 실행 시간: " + (endTime1 - startTime1) + "ms");

        // Stream<Integer> 예제
        long startTime2 = System.currentTimeMillis();
        int streamIntegerSum = Stream.iterate(1, i -> i + 1)
                .limit(n) // 1부터 n까지 생성
                .filter(i -> i % 2 == 0) // 짝수 필터링
                .mapToInt(Integer::intValue) // 언박싱, Stream<Integer>에서 IntStream으로 바뀐다
                .sum();
        long endTime2 = System.currentTimeMillis();

        System.out.println("Stream<Integer> 결과: " + streamIntegerSum);
        System.out.println("Stream<Integer> 실행 시간: " + (endTime2 - startTime2) + "ms");
    }

}

