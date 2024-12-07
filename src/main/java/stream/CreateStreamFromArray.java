package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStreamFromArray {
    public static void main(String[] args) {
        // 어레이도 스트림으로 만들 수 있다
        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> stream = Arrays.stream(arr);
    }
}
