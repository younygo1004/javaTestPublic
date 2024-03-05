package usedecompile.enhancedfor;

import java.util.ArrayList;
import java.util.List;

public class ForExample {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("123");
        strings.add("123");
        strings.add("123");
        strings.add("123");

        String[] strings1 = new String[]{"123", "123", "123", "123", "123"};
        int[] ints = new int[]{1, 1, 1, 1, 1};

        for (String element : strings) System.out.println(element);
        for (String element : strings1) System.out.println(element);
        for (int element : ints) System.out.println(element);

        strings.forEach(System.out::println);


    }
}
