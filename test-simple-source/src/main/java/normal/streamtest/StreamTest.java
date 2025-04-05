package normal.streamtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<String> testList1 = new ArrayList<>();
        testList1.add("111");
        testList1.add("112");
        testList1.add("113");
        testList1.add("114");


        List<String> testList2 = new LinkedList<>();
        testList2.add("111");
        testList2.add("112");
        testList2.add("113");
        testList2.add("114");


        List<String> collect = testList1.stream().toList();
        List<String> collect1 = testList2.stream().collect(Collectors.toList());

        System.out.println(collect.getClass());
        System.out.println(collect1.getClass());


    }
}
