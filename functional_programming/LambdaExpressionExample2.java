package functional_programming;

interface Addable1 {
    int add(int a, int b);
}

public class LambdaExpressionExample2 {
    public static void main(String[] args) {
        Addable1 ad = (a, b) -> a + b;
        System.out.println(ad.add(10, 20));
    }
}
