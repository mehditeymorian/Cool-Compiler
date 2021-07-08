package main.codegen.assembly.generator;

import main.codegen.writer.AssemblyWriter;

public class SpaceAllocator {


    public static String allocate(String sizeRegister) {
        // allocate memory
        AssemblyWriter.instructionC("allocate","li","$v0","9");
        AssemblyWriter.instructionC("set size","move","$a0",sizeRegister);
        AssemblyWriter.instruction("syscall");

        return "$v0";
    }
}
