package functional_programming;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, String> isSameLength = (a, b) -> a.length() == b.length();

        System.out.println(isSameLength.test("java", "code"));    // true
        System.out.println(isSameLength.test("hello", "worlds")); // false
    }
}
