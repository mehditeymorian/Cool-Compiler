package main.codegen.assembly.generator;

import main.model.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.codegen.writer.LabelGenerator;
import main.model.DataType;

import static main.codegen.Utils.*;
import static main.codegen.writer.AssemblyWriter.*;

public class Assignment {

    public static void operatorAssign(Descriptor idDesc , Descriptor expressionDesc , String operator) {
        // TODO: 7/4/2021 check for mix of real and int

        setDataType(idDesc);
        String temp = getTempRegister(idDesc.getDataType());
        String command = getStoreCommand(expressionDesc.getDataType());
        String destination = idDesc.fullAddress();
        String src = "";

        // check type matching
        equalType(idDesc , expressionDesc);

        switch (expressionDesc.getType()) {
            case LITERAL: // a <- 2;
                src = getTempRegister(expressionDesc.getDataType());
                instruction(getLoadImmCommand(expressionDesc.getDataType()) , src , expressionDesc.getValue());
                break;
            case REGISTER: // a <- t0;
                src = expressionDesc.getValue();
                releaseTempRegister(expressionDesc.getValue());
                break;
            case VARIABLE:

                break;
        }
        instruction(getLoadCommand(idDesc.getDataType()),temp,destination);
        instruction(operator,src,temp,src);
        instruction(command , src , destination);
        releaseTempRegister(temp);
    }

    public static void idAssign(Descriptor idDesc , Descriptor expressionDesc) {
        setDataType(idDesc);
        if (idDesc.isArray()) {
            Array.create(idDesc , expressionDesc);
            return;
        }
        if (expressionDesc.getDataType().equals(DataType.STRING)) {
            assignString(idDesc , expressionDesc);
            return;
        }
        String command = getStoreCommand(expressionDesc.getDataType());
        String destination = idDesc.fullAddress();
        String src = getAddress(expressionDesc,expressionDesc.getDataType());

        // check type matching
        equalType(idDesc , expressionDesc);

        instruction(command , src , destination);
    }

    private static void assignString(Descriptor idDesc , Descriptor expressionDesc) {
        String loopLabel = LabelGenerator.label(LabelGenerator.Type.LOOP , "STR_EXTRACT");
        String constant1 = getTempRegister(DataType.INT);
        String dest = idDesc.fullAddress();
        String temp = getTempRegister(DataType.INT);
        String i = getTempRegister(DataType.INT);
        String src = "";
        String srcLen = "0";

        switch (expressionDesc.getType()) {
            case REGISTER:
                src = STRING_BUFFER;
                srcLen = STRING_BUFFER_LEN;
                break;
            case LITERAL:
                src = LabelGenerator.label(LabelGenerator.Type.CONSTANT);
                srcLen =  LabelGenerator.label(LabelGenerator.Type.CONSTANT);
                // create a constant for String and its size
                AssemblyWriter.memoryStr(src,expressionDesc.getValue());
                AssemblyWriter.memory(srcLen,DataType.INT,expressionDesc.getValue().length()+"");
                break;
        }
        releaseTempRegister(expressionDesc.getValue());
        setDataType(idDesc);



        instruction("li" , constant1 , "1");
        instruction("lw",i,srcLen);
        label(loopLabel);
        instruction("lb",temp,src+"("+i+")");
        instruction("sb",temp,dest+"("+i+")");
        instruction("sub",i,i,constant1);
        instruction("bgez",i,loopLabel);

        releaseTempRegister(i);
        releaseTempRegister(temp);
    }

    public static void refAssign(Descriptor classDesc , Descriptor refDesc , Descriptor expressionDesc) {
        setDataType(classDesc);
        String className = classDesc.getClassName();
        String dest = className + "_" + refDesc.getValue();
        String command = getStoreCommand(expressionDesc.getDataType());
        String src = "";

        switch (expressionDesc.getType()) {
            case LITERAL: // a <- 2;
                src = getTempRegister(expressionDesc.getDataType());
                instruction(getLoadImmCommand(expressionDesc.getDataType()) , src , expressionDesc.getValue());
                break;
            case REGISTER: // a <- t0;
                src = expressionDesc.getValue();
                releaseTempRegister(expressionDesc.getValue());
                break;
            case VARIABLE:

                break;
        }
        instruction(command , src , dest);
    }

    public static void arrayAssign(Descriptor idDescriptor ,Descriptor indexDescriptor, Descriptor expression) {
        setDataType(idDescriptor);
        setDataType(indexDescriptor);
        setDataType(expression);

        if (idDescriptor.getType() != Descriptor.Type.VARIABLE)
            throw new IllegalArgumentException("only id can be on the idDescriptor side of equation");


        String base = getAddress(idDescriptor , idDescriptor.getDataType());
        String src = getAddress(expression , expression.getDataType());
        String index = getAddress(indexDescriptor , indexDescriptor.getDataType());
        String storeCommand = getStoreCommand(idDescriptor.getDataType());


        if (indexDescriptor.getDataType() != DataType.BOOL)
            AssemblyWriter.instruction("mul",index,index,"4");
        AssemblyWriter.instruction("add" , base , base , index);
        AssemblyWriter.instruction(storeCommand , src , "("+base+")");

        releaseTempRegister(base,src,index);
    }
}
