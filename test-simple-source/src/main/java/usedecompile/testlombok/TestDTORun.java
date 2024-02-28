package usedecompile.testlombok;

import usedecompile.testlombok.testdto.*;

public class TestDTORun {

    public static void main(String[] args) {
        TestDTOGetterSetter testDTOGetterSetter = new TestDTOGetterSetter();
        TestDTOToString testDTOToString = new TestDTOToString();
        TestDTOEqualsAndHashCode testDTOEqualsAndHashCode = new TestDTOEqualsAndHashCode();
        TestDTONoArg testDTONoArg = new TestDTONoArg();
        TestDTOAllArg testDTOAllArg = new TestDTOAllArg("","","","","");
        TestDTORequiredArgs1 testDTORequiredArgs1 = new TestDTORequiredArgs1();
        TestDTORequiredArgs2 testDTORequiredArgs2 = new TestDTORequiredArgs2();
        TestDTORequiredArgs3 testDTORequiredArgs3 = new TestDTORequiredArgs3("1","1");
        TestDTOData testDTOData = new TestDTOData("1","1");
        TestDTOValue testDTOValue = new TestDTOValue("1","1","1","1","1");
        TestDTOBuilder testDTOBuilder = TestDTOBuilder.builder().build();
        

    }
}
