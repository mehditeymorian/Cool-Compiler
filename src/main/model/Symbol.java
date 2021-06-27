package main.model;

public class Symbol {
    private String value;
    private String type;
    private int line;
    private int positionInLine;

    public Symbol(String value , String type, int line, int positionInLine) {
        this.value = value;
        this.type = type;
        this.line = line;
        this.positionInLine = positionInLine;
    }

    public int getLine() {
        return line;
    }

    public int getPositionInLine() {
        return positionInLine;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
