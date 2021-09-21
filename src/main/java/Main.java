import interpreter.Lexer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File fileToRead = new File("/home/matees/Documents/dev/java/Spine/hi.mng");
        fileToRead.createNewFile();
        new Lexer(fileToRead);
    }
}
