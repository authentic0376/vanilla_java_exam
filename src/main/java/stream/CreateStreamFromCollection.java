package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreateStreamFromCollection {
    public static void main(String[] args) {
         // 모든 컬렉션은 스트림으로 만들 수 있다
        Collection<String> collection = Arrays.asList("a", "b", "c");
        /*
        * Arrays의 asList 메소드로 편리하게 리스트를 만든다
        * List는 Collection에 포함되므로 할당 가능하다
        * 아무튼 Collection을 선언하고 할당했다
        */

        // 컬렉션의 stream 메소드를 이용해서 콜렉션을 스트림으로 만들 수 있다.
        Stream<String> stream = collection.stream();
    }
}
