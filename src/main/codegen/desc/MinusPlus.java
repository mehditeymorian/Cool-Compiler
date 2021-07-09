package main.codegen.desc;

import main.model.Descriptor;

public class MinusPlus {
    private Descriptor descriptor;
    private int code;

    public MinusPlus(Descriptor descriptor , int code) {
        this.descriptor = descriptor;
        this.code = code;
    }


    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public int getCode() {
        return code;
    }
}
