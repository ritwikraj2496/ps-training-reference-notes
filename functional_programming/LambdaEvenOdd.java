package functional_programming;

@FunctionalInterface
interface NumberCheck {
    boolean check(int n);
}

public class LambdaEvenOdd {
    public static void main(String[] args) {
        NumberCheck isEven = (n) -> n % 2 == 0;

        int num = 7;
        if (isEven.check(num)) {
            System.out.println(num + " is even");
        } else {
            System.out.println(num + " is odd"); //7 is odd
        }
    }
}
