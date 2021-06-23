package main.model;

import java.util.ArrayList;
import java.util.List;

public class ClassScope extends Scope{
    private List<FunctionScope> children;


    public ClassScope(Scope parent , String name) {
        super(parent , name);
        children = new ArrayList<>();
    }

    public void addChild(FunctionScope child) {
        children.add(child);
    }

    public List<FunctionScope> getChildren() {
        return children;
    }

}
