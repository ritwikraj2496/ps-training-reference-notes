package functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumericStreamsExample {
    public static void main(String[] args) {
        IntStream.range(1, 5)
                .forEach(System.out::println); // 1234

        List<String> words = Arrays.asList("apple", "banana");
        int totalLength = words.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println(totalLength); // 11

        DoubleStream prices = DoubleStream.of(9.99, 14.99, 19.99);
        System.out.println(prices.average().getAsDouble()); // 14.99
    }
}
