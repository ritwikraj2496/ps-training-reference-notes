package functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        list.stream().forEach(System.out::println);

        List<String> result = Stream.of("a", "b", "c")
                .collect(Collectors.toList());
        System.out.println(result); // [a, b, c]

        int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum); // 10
    }
}
