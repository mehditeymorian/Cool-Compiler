package main;

import main.codegen.CodeGenerator;
import main.codegen.writer.AssemblyWriter;
import main.parser.Parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Main {
    public static final String OUTPUT_NAME = "-out";
    public static final String DEBUG_MODE = "-debug";
    public static final String INPUT_NAME = "-in";

    public static void main(String[] args) throws IOException {
        HashMap<String, String> options = getOptions(args);

        AssemblyWriter.init(getOutputName(options));
        System.out.println("Initializing Assembly Generator.");
        TokenList tokenList = new TokenList(options.get(INPUT_NAME));
        CodeGenerator codeGenerator = new CodeGenerator(tokenList);
        System.out.println("Initializing Parser.");
        InputStream resource = Main.class.getResourceAsStream("/resources/table.npt");
        if (resource != null)
            System.out.println("Parse Table is available.");
        Parser parser = new Parser(tokenList , codeGenerator , resource);
        try {
            parser.parse();
            AssemblyWriter.flush();
        } catch (Exception exception) {
           if (options.get(DEBUG_MODE).equals("1")) { // debug mode is enabled
               exception.printStackTrace();
           }else System.out.println("Cannot compile!");
        }

    }

    private static HashMap<String, String> getOptions(String[] args) {
        HashMap<String, String> result = new HashMap<>();
        result.put(DEBUG_MODE , "0");
        for (String arg : args) {
            String[] split = arg.split("=");
            switch (split[0].toLowerCase()) {
                case OUTPUT_NAME:
                    if (split.length == 2)
                        result.put(OUTPUT_NAME , split[1]);
                    break;
                case DEBUG_MODE:
                    result.put(DEBUG_MODE , "1");
                    break;
                case INPUT_NAME:
                    if (split.length == 1)
                        throw new IllegalArgumentException("Specify input file address.");
                    result.put(INPUT_NAME , split[1]);
                    break;
                default:
            }
        }
        return result;
    }

    private static String getOutputName(HashMap<String, String> options) {
        String outputName = options.get(OUTPUT_NAME);
        if (outputName == null){
            File file = new File(options.get(INPUT_NAME));
            String[] parent = file.getAbsolutePath().split("\\w+\\..+");
            outputName = parent[0] + "\\" + file.getName().split("\\.")[0] + ".s";
        }
        return outputName;
    }


}
