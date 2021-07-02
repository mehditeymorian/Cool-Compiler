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
    private String className;


    public Descriptor(String value , String prefix , Type type) {
        this.value = value;
        this.prefix = prefix;
        this.type = type;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void setDataType(String type) {
        try {
            this.dataType = DataType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            this.dataType = DataType.ID;
            className = type;
        }
    }

    public String getValue() {
        return value;
    }

    public String getPrefix() {
        return prefix;
    }

    public String fullAddress() {
//        if (className != null) return className + "_" + getValue();

        return getPrefix() + "_" + getValue();
    }

    public Type getType() {
        return type;
    }
}
