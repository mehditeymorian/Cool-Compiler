package main.model;


public enum DataType {
    INT, // 0
    REAL, // 1
    DOUBLE, // 2
    STRING, // 3
    BOOL, // 4
    VOID,
    ID; // 5


    public boolean isNumeric() {
        return ordinal() <= 2;
    }

    public DataType mix(DataType another) {
        if (another.ordinal() <= 2 && ordinal() <= 2) {
            if (another.ordinal() == 1 || ordinal() == 1)
                return REAL;

            return INT;
        }

        if (another.ordinal() <= 3 && ordinal() <= 3)
            return DOUBLE;

        if (another.ordinal() <= 4 && ordinal() <= 4)
            return BOOL;

        throw new IllegalArgumentException("type cannot be decided!");
    }


}
