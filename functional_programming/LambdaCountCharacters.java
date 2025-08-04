package functional_programming;

@FunctionalInterface
interface StringLengthFinder {
    int findLength(String str);
}

public class LambdaCountCharacters {
    public static void main(String[] args) {
        StringLengthFinder finder = (str) -> str.length();

        String input = "Lambda";
        System.out.println("Length of \"" + input + "\" is: " + finder.findLength(input)); //Length of "Lambda" is: 6
    }
}
