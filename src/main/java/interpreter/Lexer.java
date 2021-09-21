package interpreter;

import interpreter.etc.Line;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class Lexer {

    private List<Token> tokens = new ArrayList<Token>();
    private Line currentLine;

    public Lexer(File fileInput) {
        // Get the tokens from the method below and give them to the parser

        this.currentLine = new Line();

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

    public void advance(){
        if (currentLine.getCurrentChar() == '\n') {
            currentLine.advanceLine();
            return;
        }

        currentLine.advanceChar();
    }

    public List<Token> lex(FileReader input) throws IOException {
        List<Token> generatedTokens = new ArrayList<Token>();
        BufferedReader reader = new BufferedReader(input);

        String line;
        while ((line = reader.readLine()) != null) {
            generatedTokens.addAll(getTokensFromStatement(line));
            currentLine.advanceLine();
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
            } else if (isTokenNumber(character)) { // Checking for numbers
                int dotcount = 0;
                String numString = "";

            } else {
                generatedTokens.add(new Token(Character.toString(character), TokenType.UNKNOWN));
            }

        }

        return generatedTokens;
    }

    private boolean isToken(char character, char expected) {
        return character == expected;
    }

    private boolean isTokenNumber(char character) {
        return TokenType.NUMBER.getCharacters().contains(character);
    }
}
