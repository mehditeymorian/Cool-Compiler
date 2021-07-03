package main.codegen;

import main.codegen.desc.Descriptor;
import main.codegen.writer.AssemblyWriter;

import java.util.Map;

import static main.codegen.CodeGenerator.tempVariables;

public class Utils {

    public static String getAdr(Descriptor descriptor) {
        String result;
        if (descriptor.getType() == Descriptor.Type.LITERAL){
            String command = "li";
            String src = descriptor.getValue();
            String destination = tempVariables.pollFirst();
            AssemblyWriter.instruction(command,destination,src);
            result = destination;
        }
        else if (descriptor.getType() == Descriptor.Type.REGISTER)
            result = descriptor.getValue();
        else { // (left.getType() == Descriptor.Type.VARIABLE)
            String command = "lw";
            String src = descriptor.fullAddress();
            String destination = tempVariables.pollFirst();
            AssemblyWriter.instruction(command , destination , src);
            result = destination;
            // set data type
            setDataType(descriptor);
        }

        return result;
    }

    public static void setDataType(Descriptor descriptor) {
        String fullAddress = descriptor.fullAddress();
        // looking for full address
        for (Map.Entry<String, Descriptor> each : CodeGenerator.variables.entrySet()) {
            if (each.getKey().equals(fullAddress)){
                descriptor.setDataType(each.getValue().getDataType());
                descriptor.setClassName(each.getValue().getClassName());
                return;
            }
        }
        String[] split = fullAddress.split("_");
        String classAddress = split[0] + "_" + split[2];
        for (Map.Entry<String, Descriptor> each : CodeGenerator.variables.entrySet()) {
            if (each.getKey().equals(classAddress)){
                descriptor.setDataType(each.getValue().getDataType());
                descriptor.setClassName(each.getValue().getClassName());
                return;
            }
        }

        throw new IllegalArgumentException("variable " + fullAddress + " not found!");
    }

    public static void equalType(Descriptor first , Descriptor second) {
        if (!first.getDataType().equals(second.getDataType()))
            throw new IllegalArgumentException("type mismatch for " + first.getValue());
    }

    public static void numericType(Descriptor first , Descriptor second) {
        if (!first.getDataType().isNumeric() || !second.getDataType().isNumeric())
            throw new IllegalArgumentException("type must be numeric");
    }

}
