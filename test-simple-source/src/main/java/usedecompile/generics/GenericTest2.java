package usedecompile.generics;

public class GenericTest2 {

    public static void main(String[] args) {

        TestGenericMethod tg = new TestGenericMethod();

        String st = tg.testMethodT("test");

        System.out.println(st);

        Integer i = tg.testMethodExtends(100);

        System.out.println(i);

        Number n = tg.testNumber(1);
//        Integer i1 = tg.testNumber(1); // compile error


        Integer i2 = (Integer) tg.testNumber(90);

        System.out.println(i2);
        System.out.println("---------------------------");

        TestGenericExtends<Number> tgn = new TestGenericExtends<>(1);

//        Integer i3 = (Integer) tg.testNumber(1.5); // runtime : ClassCastException



    }
}
