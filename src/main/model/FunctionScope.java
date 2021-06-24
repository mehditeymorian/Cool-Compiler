package main.model;

import java.util.ArrayList;
import java.util.List;

public class FunctionScope extends Scope{
    private String returnType;
    private boolean isReturnArray;
    private List<Variable> params;

    public FunctionScope(Scope parent , String name , String returnType) {
        super(parent , name);
        this.returnType = returnType;
        params = new ArrayList<>();
    }

    public String getReturnType() {
        return returnType;
    }

    public void addParam(Variable variable) {
        params.add(variable);
    }

    public void addParam(List<Variable> variable) {
        params.addAll(variable);
    }

    public List<Variable> getParams() {
        return params;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public boolean isReturnArray() {
        return isReturnArray;
    }

    public void setReturnArray(boolean returnArray) {
        isReturnArray = returnArray;
    }

    public void setParams(List<Variable> params) {
        this.params = params;
    }
}
