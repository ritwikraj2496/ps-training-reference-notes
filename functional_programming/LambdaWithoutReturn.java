package functional_programming;

interface MyFunctionalInterface {
    int add(int a, int b);
}

public class LambdaWithoutReturn {
    public static void main(String[] args) {

        // Lambda expression without using the return keyword
        MyFunctionalInterface addition = (a, b) -> a + b;

        // Using the lambda expression to perform addition
        int result = addition.add(5, 7);

        // Displaying the result
        System.out.println("Result of addition: " + result);
    }
}

