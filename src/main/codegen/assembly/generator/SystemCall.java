package main.codegen.assembly.generator;

import main.codegen.CodeGenerator;
import main.codegen.desc.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.codegen.writer.LabelGenerator;
import main.model.DataType;

import static main.codegen.Utils.getTempRegister;
import static main.codegen.Utils.releaseTempRegister;
import static main.codegen.writer.AssemblyWriter.*;

public class SystemCall {

    public static void printInt(Descriptor descriptor) {
        String src = "";
        switch (descriptor.getType()) {
            case LITERAL:
                src = descriptor.getValue();
                break;
            case VARIABLE:
                String temp = getTempRegister(descriptor.getDataType());
                instruction("lw",temp,descriptor.fullAddress());
                src = "0(" + temp + ")";
                releaseTempRegister(temp);
                break;
            case REGISTER:
                src = "0(" + descriptor.getValue() +")";
                releaseTempRegister(descriptor.getValue());
                break;
        }
        // TODO: 7/4/2021 double check these for floating
        instruction( "li" , "$v0" , "1");
        instruction("la","$a0",src);
        instructionC("print integer","syscall");
    }

    public static void printString(Descriptor descriptor) {
        switch (descriptor.getType()) {
            case LITERAL:
                String src2 = LabelGenerator.label(LabelGenerator.Type.CONSTANT);
                AssemblyWriter.memoryStr(src2,descriptor.getValue());
                printString(new Descriptor(src2 , null , Descriptor.Type.VARIABLE));
                break;
            case VARIABLE:
                String src = descriptor.fullAddress();
                instruction("li","$v0","4");
                instruction("la","$a0",src);
                instructionC("print string","syscall");
                break;
        }
    }

    public static void inputInt() {
        instructionC("input int code","li","$v0","5");
        instructionC("input integer","syscall");

        String dest = getTempRegister(DataType.INT);
        instruction("move",dest,"$v0");
        Descriptor descriptor = new Descriptor(dest , null , Descriptor.Type.REGISTER);
        descriptor.setDataType(DataType.INT);
        CodeGenerator.semanticStack.push(descriptor);
    }

    public static void inputString() {

        // take line string
        instructionC("input string code","li","$v0","8");
        instruction("la" , "$a0" , STRING_BUFFER);
        instruction("la" , "$a1" , BUFFER_MAX);
        instructionC("input string","syscall");

        // descriptor for buffer address
        String bufferReg = getTempRegister(DataType.STRING);
        Descriptor bufferDesc = new Descriptor(bufferReg , null , Descriptor.Type.REGISTER);
        bufferDesc.setDataType(DataType.STRING);
        CodeGenerator.semanticStack.push(bufferDesc);

        AssemblyWriter.instruction("la",bufferReg,STRING_BUFFER);

//        // descriptor for buffer len
//        String lenReg = CodeGenerator.tempVariables.pollFirst();
//        Descriptor lenDesc = new Descriptor(lenReg , null , Descriptor.Type.REGISTER);
//        lenDesc.setDataType(DataType.INT);
//        CodeGenerator.semanticStack.push(lenDesc);
//
//        AssemblyWriter.instruction("lw",lenReg,STRING_BUFFER_LEN);

    }

    public static void lenId() {
        // TODO: 7/2/2021  
    }

    public static void lenStr() {
        // TODO: 7/2/2021  
    }

    public static void printLine() {
        instruction("li","$v0","4");
        instruction("la","$a0","NEW_LINE");
        instructionC("line feed","syscall");
    }
}
