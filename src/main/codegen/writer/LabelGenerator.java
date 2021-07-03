package main.codegen.writer;


public class LabelGenerator {
    private static int loopCount = 0;
    private static int jumpCount = 0;
    private static int constantCount = 0;
    public enum Type {
        LOOP, JUMP, CONSTANT
    }

    public static String variable(String... scopes) {
        return String.join("_" , scopes);
    }

    // label for loops jumps
    public static String label(Type type, String ...scopes) {
        int count = type == Type.LOOP ? loopCount++:
                    type == Type.JUMP ? jumpCount++
                                      : constantCount++;
        if (scopes == null) return "label_" + count;
        String prefix = String.join("_" , scopes);
        String typeName = type.name().toLowerCase();
        return prefix + "_" + typeName + count;
    }

    public static void main(String[] args) {
        System.out.println(LabelGenerator.label(Type.JUMP,"Main","func"));
        System.out.println(LabelGenerator.label(Type.JUMP,"Main","func"));
        System.out.println(LabelGenerator.label(Type.JUMP,"Main","func"));
        System.out.println(LabelGenerator.label(Type.LOOP,"Sorting","sort"));
        System.out.println(LabelGenerator.label(Type.LOOP,"Main","deletePost"));
    }
}
