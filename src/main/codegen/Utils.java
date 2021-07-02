package main.codegen;

import main.codegen.desc.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.model.DataType;
import sun.security.krb5.internal.crypto.Des;

import java.util.Map;

import static main.codegen.CodeGenerator.tempVariables;

public class Utils {

    public static String getAdr(Descriptor descriptor) {
        String result;
        if (descriptor.getType() == Descriptor.Type.LITERAL)
            result = descriptor.getValue();
        else if (descriptor.getType() == Descriptor.Type.REGISTER)
            result = descriptor.getValue();
        else { // (left.getType() == Descriptor.Type.VARIABLE)
            String command = "lw";
            String src = descriptor.fullAddress();
            String destination = tempVariables.pollFirst();
            AssemblyWriter.instruction(command , destination , src);
            result = destination;
            // set data type
            descriptor.setDataType(getDataType(src));
        }

        return result;
    }

    public static DataType getDataType(String fullAddress) {
        // looking for full address
        for (Map.Entry<String, Descriptor> each : CodeGenerator.variables.entrySet()) {
            if (each.getKey().equals(fullAddress))
                return each.getValue().getDataType();
        }
        String[] split = fullAddress.split("_");
        String classAddress = split[0] + "_" + split[2];
        for (Map.Entry<String, Descriptor> each : CodeGenerator.variables.entrySet()) {
            if (each.getKey().equals(classAddress))
                return each.getValue().getDataType();
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
