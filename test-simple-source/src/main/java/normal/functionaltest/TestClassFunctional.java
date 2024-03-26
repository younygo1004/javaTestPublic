package normal.functionaltest;

public class TestClassFunctional {

    private void testFoo() {
        System.out.println("테스트 함수 호출됨");
        System.out.println("테스트 함수 호출됨");
        System.out.println("테스트 함수 호출됨");
        System.out.println("테스트 함수 호출됨");
    }

    public Runnable testReturn() {
        return this::testFoo;
    }

}
