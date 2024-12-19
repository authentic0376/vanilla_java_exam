package stream;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CreateStreamFromRegexSplit {
    public static void main(String[] args) {
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("aq, bw, ce");
        streamOfString.forEach(System.out::println);
    }
}
