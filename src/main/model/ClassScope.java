package main.model;

import java.util.ArrayList;
import java.util.List;

public class ClassScope extends Scope{
    private List<FunctionScope> functions;


    public ClassScope(Scope parent , String name) {
        super(parent , name);
        functions = new ArrayList<>();
    }

    public boolean hasFunction(FunctionScope functionScope) {
        for (FunctionScope each : functions) {
            if (each.getName().equals(functionScope.getName()))
                return true;
        }

        return false;
    }

    public void addFunction(FunctionScope child) {
        functions.add(child);
    }

    public List<FunctionScope> getFunctions() {
        return functions;
    }

}
