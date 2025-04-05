package normal.nulltest;

public class NullTestClass {

    public static void main(String[] args) {

        Object object = null;
        
        String string = null;
        
        if (object == string)
            System.out.println("둘다 null로 같음");

    }
}
