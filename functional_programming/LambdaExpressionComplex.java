package functional_programming;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressionComplex {
    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 1: Using forEach with a lambda expression
        System.out.println("Example 1: Using forEach");
        numbers.forEach(number -> System.out.print(number + " "));
        System.out.println();  // New line for better output formatting

        // Example 2: Using map and reduce to calculate the sum of squares
        System.out.println("Example 2: Using map and reduce");
        int sumOfSquares = numbers.stream()
                                  .map(x -> x * x)
                                  .reduce(0, Integer::sum);
        System.out.println("Sum of squares: " + sumOfSquares);

        // Example 3: Using filter to get even numbers
        System.out.println("Example 3: Using filter");
        List<Integer> evenNumbers = numbers.stream()
                                          .filter(x -> x % 2 == 0)
                                          .toList();  // Convert stream to list (Java 16+)
        System.out.println("Even numbers: " + evenNumbers);
    }
}
