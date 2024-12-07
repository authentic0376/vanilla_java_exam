package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStreamFromArray {
    public static void main(String[] args) {
        // 어레이도 스트림으로 만들 수 있다
        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> stream = Arrays.stream(arr);

        // 인덱스로 어레이의 일부만 스트림으로 만들 수도 있다.
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        streamOfArrayPart.forEach(System.out::println); // 메소드 레퍼런스
        // 1번부터 2번 인덱스 즉, b, c만 출력됨
    }
}
