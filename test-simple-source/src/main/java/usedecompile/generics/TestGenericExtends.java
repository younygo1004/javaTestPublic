package usedecompile.generics;

import java.io.Serializable;

public class TestGenericExtends<T extends Number & Serializable>{

    T type;

    public TestGenericExtends(T parameter) {
        this.type = parameter;
        printClass(type);
    }


    void printClass(Serializable a) {
        System.out.println("Serializable");
    }

    void printClass(Number a) {
        System.out.println("Number");
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
