package interpreter.etc;

public class Line {

    private long charIndx = 1L;
    private long lineIndx = 1L;
    private char currentChar;
    private String content;

    public Line() {
        this.content = "";
    }

    public Line(long charIndx, long lineIndx) {
        this.charIndx = charIndx;
        this.lineIndx = lineIndx;

        this.content = "";
    }

    public Line(long charIndx, long lineIndx, String content) {
        this.charIndx = charIndx;
        this.lineIndx = lineIndx;
        this.content = content;
    }

    public void advanceChar() {
        this.charIndx++;
    }

    public void advanceLine() {
        this.lineIndx++;
    }

    public String getLineDesc(){
        return "LINE " + this.lineIndx + " CHAR " + this.charIndx;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public long getCharIndx() {
        return charIndx;
    }

    public long getLineIndx() {
        return lineIndx;
    }

    public String getContent() {
        return content;
    }

    public char getCurrentChar() {
        return this.currentChar;
    }
}
