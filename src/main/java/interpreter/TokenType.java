package interpreter;

import java.util.List;

public enum TokenType {

    //Mathematical
    ADDITION("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SEMICOLON(";"),
    NUMBER(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')),
    FLOAT("."),
    UNKNOWN("");

    private String symbol;
    private List<Character> characters;

    TokenType(String symbol) {
        this.symbol = symbol;
    }

    TokenType(List<Character> characters) {
        this.characters = characters;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public List<Character> getCharacters(){
        return this.characters;
    }
}
