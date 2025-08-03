package functional_programming;

import java.util.*;

public class LambdaForEach {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();

        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(  //method version of for Each loop
            (n)->System.out.println(n)
        );
    }
}

