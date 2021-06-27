package main.model;

public class ExpressionType{
    private String type;
    private Level level;
    private boolean isBinary;

    public static ExpressionType of(String type , Level level) {
        return new ExpressionType(type , level);
    }

    private ExpressionType(String type , Level level) {
        this.type = type;
        this.level = level;
    }

    public boolean isBinary() {
        return isBinary;
    }

    public ExpressionType setBinary(boolean binary) {
        isBinary = binary;
        return this;
    }

    public String getType() {
        return type;
    }

    public Level getLevel() {
        return level;
    }

    public enum Level{
        EXPRESSION, SUB_EXPRESSION, TERM, BITWISE, OPERAND
    }

    @Override
    public String toString() {
        return "ExpressionType{" +
                "type='" + type + '\'' +
                ", level=" + level +
                ", isBinary=" + isBinary +
                '}';
    }
}
