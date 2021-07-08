package main.codegen.writer;

import main.model.DataType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AssemblyWriter {
    public static final String FLOAT_PRECISION = ".d";
    public static final String STRING_BUFFER = "BUFFER";
    public static final String STRING_BUFFER_LEN = "BUFFER_LEN";
    public static final String BUFFER_MAX = "30";

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

        write(codeText,"\t\t.text");
//        write(codeText,"\t\t.align 2");
        write(codeText,"\t\t.globl main");
        write(codeText,"main:");

        write(memory , "\t\t" , ".data");
//        write(memory , "\t\t" , ".align 0");
        write(memory,"nl:", " .asciiz", "\"\\n\"");
        write(memory,STRING_BUFFER,":", " .space ", BUFFER_MAX);
        write(memory,STRING_BUFFER_LEN,":", " .word ", BUFFER_MAX);
        write(memory,"NEW_LINE:", " .asciiz \"\\n\"");
    }

    public static void flush() {
        Path path = Paths.get(INSTANCE.fileName);
        try {
            Files.deleteIfExists(path);
            Files.write(path , INSTANCE.codeText , StandardOpenOption.CREATE,StandardOpenOption.WRITE);
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
        memory(name, dataType, getDefaultValue(dataType));
    }

    public static void memory(String name , DataType dataType, String value) {
        String typeLabel;
        switch (dataType) {
            case INT:
                typeLabel = ".word "+value;
                break;
            case REAL:
                typeLabel = ".float "+value;
                break;
            case STRING:
                typeLabel = ".space "+ BUFFER_MAX + " ";
                break;
            case BOOL:
                typeLabel = ".byte " + value;
                break;
            default:
                throw new IllegalArgumentException(dataType.name() + " cannot be defined in memory!");
        }
        write(INSTANCE.memory , name , ": " , typeLabel);
    }

    public static void memoryStr(String name , String value) {
        write(INSTANCE.memory , name , ":" , " .asciiz \"" , value , "\"");
    }

    public static void memoryArray(String name, DataType dataType , int count) {
        String dataDirective;
        String data;
        switch (dataType) {
            case INT:
                dataDirective = " .word ";
                data = IntStream.range(0 , count).mapToObj(value -> "0").collect(Collectors.joining(" , "));
                break;
            case REAL:
                dataDirective = " .float ";
                data = IntStream.range(0 , count).mapToObj(value -> "0.0").collect(Collectors.joining(" , "));
                break;
            case BOOL:
                dataDirective = " .byte ";
                data = IntStream.range(0 , count).mapToObj(value -> "0").collect(Collectors.joining(" , "));
                break;
            default:
                throw new IllegalArgumentException(dataType.name() + " cannot be defined in memory!");
        }
        write(INSTANCE.memory,name,": ",dataDirective,count+" , ",data);
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
        list.add(String.join("" , values));
    }

    public static String getDefaultValue(DataType type) {
        switch (type) {
            case BOOL:
            case INT:
                return "0";
            case REAL:
                return "0.0";
            case STRING:
                return "";
            default:
                throw new IllegalArgumentException(type.name() + " doesn't have a default value");
        }
    }

}
