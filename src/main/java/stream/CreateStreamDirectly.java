package stream;

import java.util.stream.Stream;

public class CreateStreamDirectly {
    public static void main(String[] args) {
        // 다른 자료형에서 변환하는 게 아니라
        // 직접, 바로 스트림을 만들 수 있다
        Stream<String> stream = Stream.of("a", "b", "c");
    }
}
