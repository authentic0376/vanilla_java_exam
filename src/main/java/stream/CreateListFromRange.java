package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateListFromRange {
    public static void main(String[] args) {

        // 스트림을 이용해서 숫자 범위를 리스트로 만들기
        List<Integer> listForNumbers = IntStream
                .range(0, 10)
                .boxed()
                .collect(Collectors.toList());
        /*
        * boxed를 쓴 이유
        *
        * - List<int> 는 존재하지 않는다
        * - IntStream은 Integer가 아니라 int 스트림을 만든다
        * - 그걸 boxed가 감싸서(boxing) Integer로 변환해주는 것이다
        *
        * */
        System.out.println(listForNumbers);

        // 스트림을 이용해서 숫자 범위를 배열로 만들기
        int[] intArray = IntStream.range(0, 10).toArray();
        System.out.println(toString(intArray));
    }

    public static String toString(int[] array) {
        if (array == null) {
            return "null"; // 빈 배열과 아예 null인 것은 구별해야 한다
        }
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
