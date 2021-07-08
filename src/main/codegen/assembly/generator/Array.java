package main.codegen.assembly.generator;

import main.codegen.CodeGenerator;
import main.model.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.model.DataType;

import static main.codegen.Utils.*;

public class Array {

    public static void create(Descriptor idDescriptor , Descriptor sizeDescriptor) {
        setDataType(idDescriptor);
        setDataType(sizeDescriptor);

        if (sizeDescriptor.getDataType() != DataType.INT)
            throw new IllegalArgumentException("Array size can only be integer.");
        if (!idDescriptor.isArray())
            throw new IllegalArgumentException("Cannot assign array to a non array variable.");

        String size = getAddress(sizeDescriptor , sizeDescriptor.getDataType());

        AssemblyWriter.instructionC("store size" , "sw" , size , idDescriptor.sizeAddress());

        if (idDescriptor.getDataType() != DataType.BOOL)
            AssemblyWriter.instruction("mul",size,size,"4");


        // allocate memory
        AssemblyWriter.instructionC("allocate","li","$v0","9");
        AssemblyWriter.instructionC("set size","move","$a0",size);
        AssemblyWriter.instruction("syscall");

        AssemblyWriter.instructionC("store address" , "sw" , "$v0" , idDescriptor.fullAddress());



        releaseTempRegister(size);
//        int count = Integer.parseInt(sizeDescriptor.getValue());
//        AssemblyWriter.memoryArray(idDescriptor.fullAddress() , idDescriptor.getDataType() , count);
//        CodeGenerator.semanticStack.push(idDescriptor); // push id descriptor back not to crash assignment section
    }

    public static void access(Descriptor idDesc , Descriptor indexDesc) {
        setDataType(idDesc);
        setDataType(indexDesc);

        if (!idDesc.isArray())
            throw new IllegalArgumentException(idDesc.getValue() + " must be array.");

        if (indexDesc.getDataType() != DataType.INT)
            throw new IllegalArgumentException("index can only be integers.");

        String src = getAddress(idDesc,idDesc.getDataType());
        String index = getAddress(indexDesc , indexDesc.getDataType());

        if (indexDesc.getDataType() != DataType.BOOL)
            AssemblyWriter.instruction("mul" , index , index , "4");

        AssemblyWriter.instruction("add" , src , index , src);
        AssemblyWriter.instruction(getLoadCommand(idDesc.getDataType()),src,"("+src+")");

        Descriptor descriptor = new Descriptor(src , null , Descriptor.Type.REGISTER);
        descriptor.setDataType(idDesc.getDataType());
        CodeGenerator.semanticStack.push(descriptor);

        releaseTempRegister(index);
    }
}
