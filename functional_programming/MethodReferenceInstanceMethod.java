package functional_programming;

@FunctionalInterface
interface SquareCalculator {
    int calculate(int x);
}

class Calculator {
    public int square(int x) {
        return x * x;
    }
}

public class MethodReferenceInstanceMethod {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        SquareCalculator sq = calc::square;

        int input = 6;
        System.out.println("Square of " + input + " is: " + sq.calculate(input)); // Square of 6 is: 36
    }
}
