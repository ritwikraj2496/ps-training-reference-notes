package functional_programming;

import java.util.*;

public class MethodReferenceExample1 {
    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("One", "Two", "Three");
        list.forEach(MethodReferenceExample1::printMsg); // it's going to work only with static method, because of normal method we need to use object
    }
}