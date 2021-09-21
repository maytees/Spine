package interpreter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class Lexer {

    private List<Token> tokens = new ArrayList<Token>();
    private long pos = 0;
    private long lineNum = 0;

    public Lexer(File fileInput) {
        // Get the tokens from the method below and give them to the parser
        try {
            tokens.addAll(lex(new FileReader(fileInput)));
            listTokens();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listTokens(){
        for (Token token : tokens) {
            System.out.println(token.getToken());
        }
    }

    public List<Token> lex(FileReader input) throws IOException {
        List<Token> generatedTokens = new ArrayList<Token>();
        BufferedReader reader = new BufferedReader(input);

        String line;
        while ((line = reader.readLine()) != null) {
            generatedTokens.addAll(getTokensFromStatement(line));
            lineNum++;
        }

        return generatedTokens;
    }

    public List<Token> getTokensFromStatement(String line) {
        List<Token> generatedTokens = new ArrayList<Token>();
        char lastChar;

        for (char character : line.toCharArray()) {
            if (character == ' ') {
                continue;
            } else if (isToken(character, '+')) {
                generatedTokens.add(new Token("+", TokenType.ADDITION));
            } else if (isToken(character, '-')) {
                generatedTokens.add(new Token("-", TokenType.SUBTRACT));
            } else if (isToken(character, '*')) {
                generatedTokens.add(new Token("*", TokenType.MULTIPLY));
            } else if (isToken(character, '/')) {
                generatedTokens.add(new Token("/", TokenType.DIVIDE));
            } else if (isToken(character, ';')) {
                generatedTokens.add(new Token(";", TokenType.SEMICOLON));
            }else{
                generatedTokens.add(new Token(Character.toString(character),TokenType.UNKNOWN));
            }

            lastChar = character;
            pos++;
        }

        pos = 0;
        return generatedTokens;
    }

    private boolean isToken(char character, char expected) {
        return character == expected;
    }
}
