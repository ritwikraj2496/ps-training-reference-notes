package functional_programming;

@FunctionalInterface
interface TextTransformer {
    String transform(String text);
}

public class LambdaUpperCaseExample {
    public static void main(String[] args) {
        TextTransformer toUpper = (text) -> text.toUpperCase();

        String input = "java rocks";
        System.out.println("Uppercase: " + toUpper.transform(input)); //Uppercase: JAVA ROCKS
    }
}
