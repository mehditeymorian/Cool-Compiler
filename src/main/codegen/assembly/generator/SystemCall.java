package main.codegen.assembly.generator;

import main.codegen.CodeGenerator;
import main.codegen.desc.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.model.DataType;
import sun.security.krb5.internal.crypto.Des;

public class SystemCall {

    public static void printOut() {
        // TODO: 7/2/2021  
    }

    public static void inputInt() {
        AssemblyWriter.instructionC("input int code","li","$v0","5");
        AssemblyWriter.instructionC("input integer","syscall");

        String dest = CodeGenerator.tempVariables.pollFirst();
        AssemblyWriter.instruction("mov",dest,"$v0");
        Descriptor descriptor = new Descriptor(dest , null , Descriptor.Type.REGISTER);
        descriptor.setDataType(DataType.INT);
        CodeGenerator.semanticStack.push(descriptor);
    }

    public static void inputString() {
        String dest = CodeGenerator.tempVariables.pollFirst();
        AssemblyWriter.instructionC("input string code","li","$v0","8");
        AssemblyWriter.instruction("la" , "$a0" , dest);
        AssemblyWriter.instructionC("input string","syscall");
        Descriptor descriptor = new Descriptor(dest , null , Descriptor.Type.REGISTER);
        descriptor.setDataType(DataType.STRING);
        CodeGenerator.semanticStack.push(descriptor);
    }

    public static void lenId() {
        // TODO: 7/2/2021  
    }

    public static void lenStr() {
        // TODO: 7/2/2021  
    }
}
