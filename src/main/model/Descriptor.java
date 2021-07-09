package main.model;

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
    private boolean isArray;
    private int minusPlusState;

    public Descriptor(String value , String prefix , Type type) {
        this.value = value;
        this.prefix = prefix;
        this.type = type;
    }

    public DataType getDataType() {
        return dataType;
    }

    public boolean isArray() {
        return isArray;
    }

    public void setArray(boolean array) {
        isArray = array;
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

    public int getMinusPlusState() {
        return minusPlusState;
    }

    public void setMinusPlusState(int minusPlusState) {
        this.minusPlusState = minusPlusState;
    }

    // use to label
    public String getPrefix() {
        return prefix;
    }

    // unique id for memory
    public String fullAddress() {
        if(getPrefix() == null) return getValue();
//        if (className != null) return className + "_" + getValue();

        return getPrefix() + "_" + getValue();
    }

    // use for arrays
    public String sizeAddress() {
        return fullAddress() + "_size";
    }

    public Type getType() {
        return type;
    }
}
