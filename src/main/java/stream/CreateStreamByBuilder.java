package stream;

import java.util.stream.Stream;

public class CreateStreamByBuilder {
    public static void main(String[] args) {
        /*
         * 타입파라미터를 지정하지 않으면 타입이 Stream<Object> 가 된다
         * 우변에 Stream.<String>builder() 타입 파라미터 문법
         */
        Stream<String> stream = Stream.<String>builder().add("a").add("b").add("c").build();
    }
}
