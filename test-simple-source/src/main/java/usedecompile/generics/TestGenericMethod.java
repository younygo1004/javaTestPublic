package usedecompile.generics;

public class TestGenericMethod {

    public <T> T testMethodT(T t){
        return t;
    }

    public <T extends Number> T testMethodExtends(T t) {
        return t;
    }

    public Number testNumber(Number n) {
        return n;
    }

}
