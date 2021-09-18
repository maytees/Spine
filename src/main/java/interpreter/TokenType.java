package interpreter;

public enum TokenType {

    //Mathematical
    ADDITION("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SEMICOLON(";"),
    NUMBER("1234567890"),
    UNKNOWN("");

    private String symbol;

    TokenType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
