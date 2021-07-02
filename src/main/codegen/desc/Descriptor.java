package main.codegen.desc;

import main.model.DataType;

public class Descriptor {
    public enum Type{
        REGISTER, VARIABLE, LITERAL
    }

    private String value;
    private String prefix;
    private Type type;
    private DataType dataType;


    public Descriptor(String value , String prefix , Type type) {
        this.value = value;
        this.prefix = prefix;
        this.type = type;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void setDataType(String type) {
        this.dataType = DataType.valueOf(type.toUpperCase());
    }

    public String getValue() {
        return value;
    }

    public String getPrefix() {
        return prefix;
    }

    public String fullAddress() {
        return getPrefix() + "_" + getValue();
    }

    public Type getType() {
        return type;
    }
}
