package usedecompile.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest1 {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add("test");

        String str1 = list1.get(0);

        TestGenecricClass<String> tg = new TestGenecricClass<>();
        TestGenecricClass<Integer> tg2 = new TestGenecricClass<>();

        TestGenecricClass<String> tgc = new TestGenecricClass<>("test");
        tgc.printClass("test");
        TestGenecricClass<Integer> tgc2 = new TestGenecricClass<>(0);
        tgc2.printClass("test");

        TestGenecricClass<Type1> t1 = new TestGenecricClass<>();
        TestGenecricClass<Type2> t2 = new TestGenecricClass<>();

        TestGenecricClass<? extends Type1> tgc3 = new TestGenecricClass<Type1>();
        tgc3.printClass("test");
        TestGenecricClass<? super Type2> tgc4 = new TestGenecricClass<>();
        tgc4.printClass("test");


    }
}
