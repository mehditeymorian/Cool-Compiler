package main.codegen.assembly.generator;

import main.codegen.CodeGenerator;
import main.codegen.Utils;
import main.codegen.desc.Descriptor;
import main.codegen.writer.AssemblyWriter;

public class Assignment {

    public static void idAssign(Descriptor idDesc , Descriptor expressionDesc) {
        idDesc.setDataType(Utils.getDataType(idDesc.fullAddress()));
        String command = getCommand(expressionDesc);
        String destination = "";
        String src = "";

        // check type matching
        Utils.equalType(idDesc , expressionDesc);

        switch (expressionDesc.getType()) {
            case LITERAL: // a <- 2;
                destination = idDesc.fullAddress();
                src = expressionDesc.getValue();
                break;
            case REGISTER: // a <- t0;
                destination = idDesc.fullAddress();
                src = expressionDesc.getValue();
                CodeGenerator.tempVariables.add(expressionDesc.getValue());

                break;
            case VARIABLE:

                break;
        }
        AssemblyWriter.instruction(command,destination,src);
    }

    public static void refAssign() {

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
                return  "sw";
            case DOUBLE:
                return "";
            default:
                return "";
        }
    }
}
