package stream;

import java.util.stream.Stream;

public class CreateStreamByLambda {
    public static void main(String[] args) {

        /*
         * Stream.generate()
         * Suplier<T> 람다 함수를 통해 스트림을 만든다
         */

        // 5번 넣음
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(5);

        // 모든 요소를 출력...5번 출력 됨
        // 람다 대신 메소드 레퍼런스 사용 (s) -> System.out.println(s)
        streamGenerated.forEach(System.out::println);
    }
}
