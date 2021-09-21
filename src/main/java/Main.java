import interpreter.Lexer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File fileToRead;
        boolean testing = true;

        if (testing) {
            fileToRead = new File("/home/matees/Documents/dev/java/Spine/test/devtest/basictest.sp");
            fileToRead.createNewFile();
        }else{
            fileToRead = new File(args[0]);
        }

        new Lexer(fileToRead);
    }
}
