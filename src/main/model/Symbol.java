package main.model;

public class Symbol {
    private String value;
    private String type;

    public Symbol(String value , String type) {
        this.value = value;
        this.type = type;
    }


    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
