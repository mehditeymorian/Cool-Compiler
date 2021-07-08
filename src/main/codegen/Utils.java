package main.codegen;

import main.model.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.model.DataType;

import java.util.Map;

import static main.codegen.CodeGenerator.tempFloatVariables;
import static main.codegen.CodeGenerator.tempVariables;
import static main.codegen.writer.AssemblyWriter.FLOAT_PRECISION;

public class Utils {

    // resultDataType is same as descriptor.getDataType() in normal situation
    // but if result data type is different then they are different
    public static String getAddress(Descriptor descriptor, DataType resultDataType) { // result resultDataType
        String result;
        if (descriptor.getType() == Descriptor.Type.LITERAL) {
            String command = getLoadImmCommand(descriptor.getDataType());
            String src = descriptor.getValue();
            String destination = getTempRegister(descriptor.getDataType());
            AssemblyWriter.instruction(command , destination , src);
            result = destination;
        } else if (descriptor.getType() == Descriptor.Type.REGISTER)
            result = descriptor.getValue();
        else { // (left.getType() == Descriptor.Type.VARIABLE)
            String command = getLoadCommand(descriptor.getDataType());
            String src = descriptor.fullAddress();
            String destination = getTempRegister(descriptor.getDataType());
            AssemblyWriter.instruction(command , destination , src);
            result = destination;
        }

        if (descriptor.getDataType() == DataType.INT && resultDataType == DataType.REAL) { // cast from int to real
            String fTemp = getTempRegister(resultDataType);
            AssemblyWriter.instruction("mtc1" , result , fTemp);
            AssemblyWriter.instruction("cvt"+FLOAT_PRECISION+".w",fTemp,fTemp);
            releaseTempRegister(result);
            return fTemp;
        }

        return result;
    }


    public static void setDataType(Descriptor descriptor) {
        if (descriptor.getDataType() != null || descriptor.getType() != Descriptor.Type.VARIABLE)
            return;
        String fullAddress = descriptor.fullAddress();
        // looking for full address
        for (Map.Entry<String, Descriptor> each : CodeGenerator.variables.entrySet()) {
            if (each.getKey().equals(fullAddress)) {
                descriptor.setDataType(each.getValue().getDataType());
                descriptor.setClassName(each.getValue().getClassName());
                descriptor.setArray(each.getValue().isArray());
                return;
            }
        }
        String[] split = fullAddress.split("_");
        String classAddress = split[0] + "_" + split[2];
        for (Map.Entry<String, Descriptor> each : CodeGenerator.variables.entrySet()) {
            if (each.getKey().equals(classAddress)) {
                descriptor.setDataType(each.getValue().getDataType());
                descriptor.setClassName(each.getValue().getClassName());
                descriptor.setArray(each.getValue().isArray());
                return;
            }
        }

        throw new IllegalArgumentException("variable " + descriptor.getValue() + " not found!");
    }

    public static void equalType(Descriptor first , Descriptor second) {
        if (!first.getDataType().equals(second.getDataType()))
            throw new IllegalArgumentException("type mismatch for " + first.getValue());
    }

    public static void numericType(Descriptor first , Descriptor second) {
        if (!first.getDataType().isNumeric() || !second.getDataType().isNumeric())
            throw new IllegalArgumentException("type must be numeric");
    }

    public static String getLoadCommand(DataType type) {
        switch (type) {
            case BOOL:
                return "lb";
            case INT:
                return "lw";
            case REAL:
                return "lwc1";
            default:
                throw new IllegalArgumentException("cannot find proper load command");
        }
    }

    public static String getStoreCommand(DataType type) {
        switch (type) {
            case BOOL:
                return "sb";
            case INT:
                return "sw";
            case REAL:
                return "swc1";
            default:
                throw new IllegalArgumentException("cannot find proper load command");
        }
    }

    public static String getLoadImmCommand(DataType type) {
        switch (type) {
            case BOOL:
            case INT:
                return "li";
            case REAL:
                return "li" + FLOAT_PRECISION;
            default:
                throw new IllegalArgumentException("cannot find proper load command");
        }
    }

    public static String getTempRegister(DataType dataType) {
        return dataType == DataType.REAL ? tempFloatVariables.pollFirst() : tempVariables.pollFirst();
    }


    public static void releaseTempRegister(String ...registers) {
        for (String register : registers) {
            if (register.startsWith("$f")) tempFloatVariables.add(register);
            else tempVariables.add(register);
        }
    }
}
