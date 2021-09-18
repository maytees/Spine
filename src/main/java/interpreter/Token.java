package interpreter;

public class Token {

    private String value;
    private TokenType tokenType;

    /***
     * Automatically creates the token type from the given value
     * @param value
     */

    public Token(String value) {

    }

    public Token(String value, TokenType tokenType) {
        this.value = value;
        this.tokenType = tokenType;
    }

    public String getToken(){
        return "{\"" + value + "\", " + this.tokenType.toString() + "}";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }
}
