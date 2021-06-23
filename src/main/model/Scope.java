package main.model;

import java.util.ArrayList;
import java.util.List;

public class Scope {
    private Scope parent;
    private String name;
    private List<Variable> variables;

    public Scope(Scope parent , String name) {
        this.parent = parent;
        this.name = name;
        variables = new ArrayList<>();
    }


    public boolean hasVariable(Variable variable) {

        for (Variable each : variables) {
            if (each.getName().equals(variable.getName()))
                return true;
        }

        if (parent != null)
            return parent.hasVariable(variable);

        return false;
    }

    public void addVariable(Variable variable) {
        variables.add(variable);
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public Scope getParent() {
        return parent;
    }

    public void setParent(Scope parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
