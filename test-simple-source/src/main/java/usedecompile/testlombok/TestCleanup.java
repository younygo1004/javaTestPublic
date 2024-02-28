package usedecompile.testlombok;

import lombok.Cleanup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class TestCleanup {

    public static void main(String[] args) throws IOException {

        @Cleanup // auto add close() method
        BufferedReader brCleanUp = new BufferedReader(new InputStreamReader(System.in));

        String test = brCleanUp.readLine();


    }

}
