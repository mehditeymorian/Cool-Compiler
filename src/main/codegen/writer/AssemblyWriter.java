package main.codegen.writer;

import main.model.DataType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class AssemblyWriter {
    public static AssemblyWriter INSTANCE;
    private List<String> codeText;
    private List<String> memory;
    private String fileName;


    public static void init(String fileName) {
        INSTANCE = new AssemblyWriter(fileName);
    }

    private AssemblyWriter(String fileName) {
        this.fileName = fileName;
        codeText = new ArrayList<>();
        memory = new ArrayList<>();

        write(memory , "\t\t" , ".data");
    }

    public static void flush() {
        Path path = Paths.get(INSTANCE.fileName);
        try {
            Files.write(path , INSTANCE.codeText , StandardOpenOption.CREATE_NEW,StandardOpenOption.WRITE , StandardOpenOption.TRUNCATE_EXISTING);
            Files.write(path , INSTANCE.memory , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void comment(String comment) {
        write(INSTANCE.codeText , "#" , comment);
    }

    public static void label(String label) {
        write(INSTANCE.codeText , label , ":");
    }

    public static void instruction(String command, String... parts) {
        write(INSTANCE.codeText , "\t" ,command, " ", String.join("," , parts));
    }

    public static void instructionC(String comment , String command, String... parts) {
        write(INSTANCE.codeText , "\t" ,command, " ", String.join("," , parts) , "\t#" , comment);
    }

    public static void memory(String name , DataType dataType) {
        String typeLabel;
        switch (dataType) {
            case INT:
                typeLabel = ".half";
                break;
            case REAL:
                typeLabel = ".word";
                break;
            case VOID:
                typeLabel = "";
                break;
            case DOUBLE:
                typeLabel = ".float";
                break;
            case STRING:
                typeLabel = ".asciiz";
                break;
            default:
                typeLabel = "";
        }
        write(INSTANCE.memory , name , ": " , typeLabel);
    }

    public static void memoryStr(String name , String value) {
        write(INSTANCE.memory , name , ":" , ".asciiz \"" , value , "\"");
    }

    public static void memoryArray(String name , int size) {

    }

    public static void setMemoryValue(String label , String value) {
        List<String> memory = INSTANCE.memory;
        for (int i = 0; i < memory.size(); i++) {
            String each = memory.get(i).trim();
            if (each.startsWith(label)) {
                memory.set(i ,each + " " + value);
                break;
            }
        }
    }

    private static void write(List<String> list , String... values) {
        list.add(String.join(" " , values));
    }

}
