package usedecompile.testlombok;

import lombok.NonNull;

public class NonNullTest {

    private String name;

    public static void main(String[] args) {

        String nullString = null;
        System.out.println("non");
        System.out.println(nullString); // print success!
        callNonNullMethod();
    }

    private static void testMethodNonNull(@NonNull String nonNullString) {

        System.out.println(nonNullString); // print fail

    }

    private static void callNonNullMethod() {
        testMethodNonNull(null);
    }

}
