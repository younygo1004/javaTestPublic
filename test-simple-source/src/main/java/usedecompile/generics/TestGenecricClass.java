package usedecompile.generics;

public class TestGenecricClass<E> {

    E element;

    public TestGenecricClass() {
    }

    public TestGenecricClass(E element) {
        this.element = element;
        printClass(element);
    }

    void printClass(String a) {
        System.out.println("String");
    }

    void printClass(Integer a) {
        System.out.println("Integer");
    }

    void printClass(Object a) {
        System.out.println("Object");
    }

}
