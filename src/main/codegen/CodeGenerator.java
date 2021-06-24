package main.codegen;

import main.TokenList;
import main.model.*;

import java.util.*;

public class CodeGenerator implements main.parser.CodeGenerator {
    private final TokenList tokenList;
    private final Set<String> set;
    private final Stack<String> idStack;
    private final Stack<String> typeStack;
    private final Stack<String> literalStack;
    private final Stack<Scope> scopeStack;
    private List<Scope> classes;
    private List<Variable> tempParams;
    private boolean arrayType;

    public CodeGenerator(TokenList tokenList) {
        this.tokenList = tokenList;
        idStack = new Stack<>();
        typeStack = new Stack<>();
        literalStack = new Stack<>();
        scopeStack = new Stack<>();
        set = new HashSet<>();
        classes = new ArrayList<>();
        tempParams = new ArrayList<>();
    }

    @Override
    public void doSemantic(String sem) {
        Symbol currentSymbol = tokenList.getCurrentSymbol();
        set.add(sem);
        switch (sem) {
            case "end_scope":
                scopeStack.pop();
                break;
            case "sub":
                break;
            case "create_symbolTable":
                String className = idStack.pop();
                Scope scope = new ClassScope(null , className);
                classes.add(scope);
                scopeStack.push(scope);
                break;
            case "create_function":
            case "make_function_dscp":
                String functionName = idStack.pop();
                String functionType = typeStack.pop();
                FunctionScope functionScope = new FunctionScope(getCurrentScope() , functionName , functionType);
                functionScope.addParam(tempParams);
                tempParams.clear();
                functionScope.setReturnArray(arrayType);
                ClassScope parent = (ClassScope) functionScope.getParent();
                if (parent.hasFunction(functionScope))
                    throw new IllegalArgumentException(String.format("cannot define %s function twice!\n" , functionName));

                parent.addFunction(functionScope);
                scopeStack.push(functionScope);
                arrayType = false;
                break;
            case "end_function":
                break;
            case "push_id":
                idStack.push(currentSymbol.getValue());
                break;
            case "visit_body":
                break;
            case "plus_plus":
                break;
            case "push_type":
                typeStack.push(currentSymbol.getValue());
                break;
            case "jz":
                break;
            case "neg":
                break;
            case "push_lit":
                literalStack.push(currentSymbol.getValue());
                break;
            case "cjb":
                break;
            case "array_type":
                arrayType = true;
                break;
            case "return_statement":
                break;
            case "add":
                break;
            case "call_len_id":
                break;
            case "cjp":
                break;
            case "assign_param":
                String paramName = idStack.pop();
                String paramType = typeStack.pop();
                Variable param = new Variable();
                param.setName(paramName);
                param.setType(paramType);
                param.setArray(arrayType);
                arrayType = false;
                tempParams.add(param);
                break;
            case "simple_assign":
                break;
            case "array_assign":
                break;
            case "create_array":
                break;
            case "call":
                break;
            case "cjz":
                break;
            case "add_symbol":
                String varName = idStack.pop();
                String varType = typeStack.pop();
                Variable variable = new Variable();
                variable.setName(varName);
                variable.setType(varType);
                variable.setArray(arrayType);
                arrayType = false;
                if (getCurrentScope().hasVariable(variable))
                    throw new IllegalArgumentException(String.format("Variable %s cannot be defined twice!\n" , variable.getName()));
                getCurrentScope().addVariable(variable);
                break;
            case "jb":
                break;
            case "input_int":
                break;
            case "visit_loop_body":
                break;
            case "break_statement":
                break;
            case "push_compare":
                break;
            default:

        }
    }

    public Set<String> getSet() {
        return set;
    }

    public Scope getCurrentScope() {
        return scopeStack.isEmpty() ? null : scopeStack.peek();
    }
}
