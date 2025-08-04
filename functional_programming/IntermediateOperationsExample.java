package functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationsExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ravi", "Priya");
        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upper); // [RAVI, PRIYA]

        List<Integer> nums = Arrays.asList(5, 10, 15, 20);
        List<Integer> evens = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens); // [10, 20]

        List<List<String>> data = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"));
        List<String> flat = data.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flat); // [A, B, C, D]
    }

}
