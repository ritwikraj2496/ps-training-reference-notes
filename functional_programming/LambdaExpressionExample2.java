package functional_programming;

interface Addable {
    int add(int a, int b);
}

public class LambdaExpressionExample2 {
    public static void main(String[] args) {
        Addable ad = (a, b) -> a + b;
        System.out.println(ad.add(10, 20));
    }
}
