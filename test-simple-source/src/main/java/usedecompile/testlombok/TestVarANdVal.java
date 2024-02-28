package usedecompile.testlombok;

import lombok.val;

public class TestVarANdVal {

    public static void main(String[] args) {

        val testString = "immutable";

        // Compile Error
//        testString = "assignment impossible";

        var test = "mutable";
        test = "assignment possible";

        // type Error
//        test = 10;


    }

}
