package main.model;

public class Symbol {
    private String value;
    private SymbolType type;

    public Symbol(String value , SymbolType type) {
        this.value = value;
        this.type = type;
    }


    public String getValue() {
        return value;
    }

    public SymbolType getType() {
        return type;
    }
}
