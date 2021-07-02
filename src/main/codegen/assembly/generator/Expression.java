package main.codegen.assembly.generator;

import main.codegen.CodeGenerator;
import main.codegen.Utils;
import main.codegen.desc.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.model.DataType;


import static main.codegen.CodeGenerator.tempVariables;
import static main.codegen.Utils.getAdr;

public class Expression {

    public static void unary(Descriptor descriptor, String operator) {
        switch (operator) {
            case "neg":
                arithmetic(descriptor,"neg");
                break;
        }
    }

    public static void binary(Descriptor left , Descriptor right , String operator) {
        switch (operator) {
            case "bitwise_xor":
                arithmetic(left, right, "xor");
                break;
            case "bitwise_and":
                arithmetic(left, right, "and");
                break;
            case "bitwise_or":
                arithmetic(left, right, "or");
                break;
            case "bigger_than":
                arithmetic(left,right,"sgt");
                break;
            case "bigger_equal":
                arithmetic(left,right,"sge");
                break;
            case "equal_equal":
                arithmetic(left,right,"seq");
                break;
            case "not_equal":
                arithmetic(left,right,"sne");
                break;
            case "less_than":
                arithmetic(left,right,"sl t");
                break;
            case "less_equal":
                arithmetic(left,right,"sl e");
                break;
            case "add":
                arithmetic(left,right,"add");
                break;
            case "sub":
                arithmetic(left,right,"sub");
                break;
            case "mult":
                arithmetic(left,right,"mul");
                break;
            case "div":
                arithmetic(left,right,"di");
                break;
            case "mod":
                arithmetic(left,right,"rem");
                break;
        }
    }

    private static void arithmetic(Descriptor left , Descriptor right , String command) {
        String dest = tempVariables.pollFirst();
        String adr1 = getAdr(left);
        String adr2 = getAdr(right);

        // check type
        Utils.numericType(left , right);

        if (left.getType() != Descriptor.Type.LITERAL) {
            tempVariables.add(adr1);
            adr1 = wrapRegister(adr1);
        }
        if (right.getType() != Descriptor.Type.LITERAL) {
            tempVariables.add(adr2);
            adr2 = wrapRegister(adr2);
        }

        AssemblyWriter.instruction(command,dest,adr1,adr2);
        Descriptor result = new Descriptor(dest , null , Descriptor.Type.REGISTER);
        result.setDataType(left.getDataType().mix(right.getDataType()));
        CodeGenerator.semanticStack.push(result);
    }

    private static void arithmetic(Descriptor descriptor , String command) {
        String dest = tempVariables.pollFirst();
        String src = getAdr(descriptor);

        if (descriptor.getType() != Descriptor.Type.LITERAL) {
            tempVariables.add(src);
            src = wrapRegister(src);
        }

        AssemblyWriter.instruction(command,dest,src);
        Descriptor result = new Descriptor(dest , null , Descriptor.Type.REGISTER);
        result.setDataType(descriptor.getDataType());
        CodeGenerator.semanticStack.push(result);
    }


    public static String wrapRegister(String name) {
        return "0(" + name + ")";
    }
}
