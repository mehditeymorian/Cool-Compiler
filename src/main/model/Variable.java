package main.model;

public class Variable {
    private int number;
    private String label;
    private String name;
    private String value;
    private DataType dataType;
    private boolean isArray;

    public Variable() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public boolean isArray() {
        return isArray;
    }

    public void setArray(boolean array) {
        isArray = array;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DataType getVariableType() {
        return dataType;
    }

    public void setVariableType(String type) {
        this.dataType = DataType.valueOf(type.toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable variable = (Variable) o;

        return label.equals(variable.label);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
