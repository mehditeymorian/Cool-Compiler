package main.codegen.assembly.generator;

import main.codegen.CodeGenerator;
import main.codegen.Utils;
import main.model.Descriptor;
import main.codegen.writer.AssemblyWriter;
import main.model.DataType;

import static main.codegen.Utils.*;
import static main.codegen.writer.AssemblyWriter.FLOAT_PRECISION;

public class Cast {

    public static void perform(Descriptor descriptor , DataType dataType) {
        Utils.setDataType(descriptor);

        if (dataType == descriptor.getDataType()) {
            CodeGenerator.semanticStack.push(descriptor);
            return;
        }

        // part of casting happens in here
        String src = getAddress(descriptor , dataType);

        if (descriptor.getDataType() == DataType.REAL) {
            String temp = getTempRegister(dataType);
            AssemblyWriter.instruction("cvt.w"+FLOAT_PRECISION,src,src);
            AssemblyWriter.instruction("mfc1.d",temp,src);
            releaseTempRegister(src);
            src = temp;
        }

        Descriptor result = new Descriptor(src , null , Descriptor.Type.REGISTER);
        result.setDataType(dataType);
        CodeGenerator.semanticStack.push(result);
    }
}
