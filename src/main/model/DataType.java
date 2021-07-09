package main.model;


public enum DataType {
    INT, // 0
    REAL, // 1
    STRING, // 2
    BOOL, // 3
    VOID, // 4
    ID; // 5


    public boolean isNumeric() {
        return ordinal() <= 1;
    }

    public DataType mix(DataType another) {
        if (another.ordinal() <= 1 && ordinal() <= 1) {
            if (another.ordinal() == 1 || ordinal() == 1)
                return REAL;

            return INT;
        }

        if (another.ordinal() == 2 && ordinal() == 2)
            return STRING;

        if (another.ordinal() == 3 && ordinal() == 3)
            return BOOL;

        throw new IllegalArgumentException("type cannot be decided!");
    }


}
