package main.codegen.assembly.generator;

import main.codegen.CodeGenerator;
import main.codegen.Utils;
import main.codegen.writer.LabelGenerator;
import main.model.Descriptor;
import main.codegen.desc.MinusPlus;
import main.codegen.writer.AssemblyWriter;
import main.model.DataType;
import sun.security.krb5.internal.crypto.Des;


import static main.codegen.CodeGenerator.semanticStack;
import static main.codegen.CodeGenerator.tempVariables;
import static main.codegen.Utils.*;
import static main.codegen.writer.AssemblyWriter.FLOAT_PRECISION;

public class Expression {
    public static final int PRE_MINUS_PLUS = -1;
    public static final int POST_MINUS_PLUS = 1;

    public static void binary(Descriptor left , Descriptor right , String operatorRaw) {
        // set data type
        if (left.getType() == Descriptor.Type.VARIABLE)
            Utils.setDataType(left);
        if (right.getType() == Descriptor.Type.VARIABLE)
            Utils.setDataType(right);

        DataType resultType = left.getDataType().mix(right.getDataType());
        String operator;
        // TODO: 7/4/2021 casting not necessary for compare
        // TODO: 7/4/2021 send proper branch command
        switch (operatorRaw) {
            case "bitwise_xor":
                if (resultType == DataType.REAL)
                    throw new IllegalArgumentException("cannot perform XOR(^) operator on floating point.");
                arithmetic(left , right , "xor" , resultType);
                break;
            case "bitwise_and":
                if (resultType == DataType.REAL)
                    throw new IllegalArgumentException("cannot perform AND(&) operator on floating point.");
                arithmetic(left , right , "and" , resultType);
                break;
            case "bitwise_or":
                if (resultType == DataType.REAL)
                    throw new IllegalArgumentException("cannot perform OR(|) operator on floating point.");
                arithmetic(left , right , "or" , resultType);
                break;
            case "bigger_than":
                if (resultType == DataType.REAL) realCompare(left , right , "c.le" + FLOAT_PRECISION , "bc1f");
                else arithmetic(left , right , "sgt" , resultType);
                break;
            case "bigger_equal":
                if (resultType == DataType.REAL) realCompare(left , right , "c.lt" + FLOAT_PRECISION , "bc1f");
                else
                    arithmetic(left , right , "sge" , resultType);
                break;
            case "equal_equal":
                if (resultType == DataType.REAL)
                    realCompare(left , right , "c.eq" + FLOAT_PRECISION , "bc1t");
                else
                    arithmetic(left , right , "seq" , resultType);
                break;
            case "not_equal":
                if (resultType == DataType.REAL) realCompare(left , right , "c.eq" + FLOAT_PRECISION , "bc1f");
                else
                    arithmetic(left , right , "sne" , resultType);
                break;
            case "less_than":
                if (resultType == DataType.REAL)
                    realCompare(left , right , "c.lt" + FLOAT_PRECISION , "bc1t");
                else
                    arithmetic(left , right , "slt" , resultType);
                break;
            case "less_equal":
                if (resultType == DataType.REAL)
                    realCompare(left , right , "c.le" + FLOAT_PRECISION , "bc1t");
                else
                    arithmetic(left , right , "sle" , resultType);
                break;
            case "add":
                operator = resultType == DataType.REAL ? "add" + FLOAT_PRECISION : "add";
                arithmetic(left , right , operator , resultType);
                break;
            case "sub":
                operator = resultType == DataType.REAL ? "sub" + FLOAT_PRECISION : "sub";
                arithmetic(left , right , operator , resultType);
                break;
            case "mult":
                operator = resultType == DataType.REAL ? "mul" + FLOAT_PRECISION : "mulo";
                arithmetic(left , right , operator , resultType);
                break;
            case "div":
                operator = resultType == DataType.REAL ? "div" + FLOAT_PRECISION : "di";
                arithmetic(left , right , operator , resultType);
                break;
            case "mod":
                if (resultType == DataType.REAL)
                    throw new IllegalArgumentException("cannot perform Mod(%) operator on floating point.");
                arithmetic(left , right , "rem" , resultType);
                break;
        }
    }

    private static void realCompare(Descriptor left , Descriptor right , String command , String branch) {
//        String dest = getTempRegister(DataType.REAL);
        String adr1 = getAddress(left , DataType.REAL);
        String adr2 = getAddress(right , DataType.REAL);


        releaseTempRegister(adr1 , adr2);


        AssemblyWriter.instruction(command , adr1 , adr2);


        String temp = getTempRegister(DataType.INT);
        String setLabel = LabelGenerator.label(LabelGenerator.Type.OUT);

        AssemblyWriter.instruction(getLoadImmCommand(DataType.INT) , temp , "1");
        AssemblyWriter.instruction(branch , setLabel);
        AssemblyWriter.instruction(getLoadImmCommand(DataType.INT) , temp , "0");
        AssemblyWriter.label(setLabel);

        Descriptor result = new Descriptor(temp , null , Descriptor.Type.REGISTER);
        result.setDataType(DataType.INT);
        CodeGenerator.semanticStack.push(result);

//        AssemblyWriter.instruction("cfc1",dest,"$25");
//        AssemblyWriter.instructionC("read float condition flag","andi",dest,"1");

//        Descriptor result = new Descriptor(null , null , Descriptor.Type.REGISTER);
//        result.setDataType(DataType.REAL);
//        CodeGenerator.semanticStack.push(result);

    }

    private static void arithmetic(Descriptor left , Descriptor right , String command , DataType resultType) {
        String dest = getTempRegister(resultType);
        String adr1 = getAddress(left , resultType);
        String adr2 = getAddress(right , resultType);


        releaseTempRegister(adr1);
        releaseTempRegister(adr2);


        doMinusPlusUnary(right , adr2 , PRE_MINUS_PLUS);
        doMinusPlusUnary(left , adr1 , PRE_MINUS_PLUS);

        AssemblyWriter.instruction(command , dest , adr1 , adr2);
        Descriptor result = new Descriptor(dest , null , Descriptor.Type.REGISTER);
        result.setDataType(resultType);
        CodeGenerator.semanticStack.push(result);

        doMinusPlusUnary(null , null , POST_MINUS_PLUS);
        doMinusPlusUnary(null , null , POST_MINUS_PLUS);
    }

    public static void unary(Descriptor descriptor , String operator) {
        // TODO: 7/4/2021 fix for floating point
        switch (operator) {
            case "neg":
                arithmetic(descriptor , "neg");
                break;
            case "not":
                notUnary(descriptor);
                break;
        }
    }

    private static void arithmetic(Descriptor descriptor , String command) {
        String src = getAddress(descriptor , descriptor.getDataType());

        AssemblyWriter.instruction(command , src , src);
        Descriptor result = new Descriptor(src , null , Descriptor.Type.REGISTER);
        result.setDataType(descriptor.getDataType());
        CodeGenerator.semanticStack.push(result);
    }

    private static void notUnary(Descriptor descriptor) {
        String outLabel = LabelGenerator.label(LabelGenerator.Type.OUT);
        String jumpLabel = LabelGenerator.label(LabelGenerator.Type.JUMP);
        String src = getAddress(descriptor , descriptor.getDataType());

        AssemblyWriter.instruction("beqz" , src , jumpLabel);
        AssemblyWriter.instruction("li" , src , "0");
        AssemblyWriter.instruction("b" , outLabel);
        AssemblyWriter.label(jumpLabel);
        AssemblyWriter.instruction("li" , src , "1");
        AssemblyWriter.label(outLabel);
        Descriptor result = new Descriptor(src , null , Descriptor.Type.REGISTER);
        result.setDataType(DataType.INT);
        semanticStack.push(result);
    }


    public static String wrapRegister(String name) {
        return "0(" + name + ")";
    }

    public static void doMinusPlusUnary(Descriptor descriptor , String adr , int state) { // TODO: 7/2/2021 FIX THIS SHIT
        if (CodeGenerator.minusPlusStack.isEmpty())
            return;

        MinusPlus minusPlus = CodeGenerator.minusPlusStack.pop();
        int code = minusPlus.getCode();
        if (state == PRE_MINUS_PLUS && code < 0 || state == POST_MINUS_PLUS && code > 0) {
            if (descriptor == null) {
                descriptor = minusPlus.getDescriptor();
                adr = getAddress(descriptor , descriptor.getDataType());
                if (descriptor.getType() != Descriptor.Type.LITERAL) {
                    tempVariables.add(adr);
                    adr = wrapRegister(adr);
                }
            }
            String src = tempVariables.pollFirst();
            String command = Math.abs(code) == 2 ? "sub" : "add";
            String adr2 = "1";
            AssemblyWriter.instruction(command , src , adr , adr2);
            AssemblyWriter.instruction("sw" , src , descriptor.fullAddress());
            tempVariables.add(src);
        } else CodeGenerator.minusPlusStack.add(0 , minusPlus);
    }
}
