package main.codegen.assembly.generator;

import main.codegen.CodeGenerator;
import main.codegen.Utils;
import main.codegen.desc.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.codegen.writer.LabelGenerator;
import main.model.DataType;

import static main.codegen.writer.AssemblyWriter.*;

public class Assignment {

    public static void idAssign(Descriptor idDesc , Descriptor expressionDesc) {
        if (expressionDesc.getDataType().equals(DataType.STRING)) {
            assignString(idDesc , expressionDesc);
            return;
        }

        Utils.setDataType(idDesc);
        String command = getCommand(expressionDesc);
        String destination = idDesc.fullAddress();
        String src = "";

        // check type matching
        Utils.equalType(idDesc , expressionDesc);

        switch (expressionDesc.getType()) {
            case LITERAL: // a <- 2;
                src = CodeGenerator.tempVariables.pollFirst();
                instruction("li" , src , expressionDesc.getValue());
                break;
            case REGISTER: // a <- t0;
                src = expressionDesc.getValue();
                CodeGenerator.tempVariables.add(expressionDesc.getValue());

                break;
            case VARIABLE:

                break;
        }
        instruction(command , src , destination);
    }

    private static void assignString(Descriptor idDesc , Descriptor expressionDesc) {
        CodeGenerator.tempVariables.add(expressionDesc.getValue());
        Utils.setDataType(idDesc);
        String dest = idDesc.fullAddress();
        String constant1 = CodeGenerator.tempVariables.pollFirst();
        String temp = CodeGenerator.tempVariables.pollFirst();
        String i = CodeGenerator.tempVariables.pollFirst();
        String loopLabel = LabelGenerator.label(LabelGenerator.Type.LOOP , "STR_EXTRACT");

        instruction("li" , constant1 , "1");
        instruction("li",i,BUFFER_MAX);
        label(loopLabel);
        instruction("lb",temp,STRING_BUFFER+"("+i+")");
        instruction("sb",temp,dest+"("+i+")");
        instruction("sub",i,i,constant1);
        instruction("bgez",i,loopLabel);

        CodeGenerator.tempVariables.add(temp);
        CodeGenerator.tempVariables.add(i);
    }

    public static void refAssign(Descriptor classDesc , Descriptor refDesc , Descriptor expressionDesc) {
        Utils.setDataType(classDesc);
        String className = classDesc.getClassName();
        String dest = className + "_" + refDesc.getValue();
        String command = getCommand(expressionDesc);
        String src = "";

        switch (expressionDesc.getType()) {
            case LITERAL: // a <- 2;
                src = CodeGenerator.tempVariables.pollFirst();
                instruction("li" , src , expressionDesc.getValue());
                break;
            case REGISTER: // a <- t0;
                src = expressionDesc.getValue();
                CodeGenerator.tempVariables.add(expressionDesc.getValue());
                break;
            case VARIABLE:

                break;
        }
        instruction(command , src , dest);
    }

    public static void arrayAssign() {

    }

    private static String getCommand(Descriptor descriptor) {
        switch (descriptor.getDataType()) {
            case STRING:
                return "";
            case REAL:
                return "";
            case INT:
                return "sw";
            case DOUBLE:
                return "";
            default:
                return "";
        }
    }
}
