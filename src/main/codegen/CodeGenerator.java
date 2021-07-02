package main.codegen;

import main.TokenList;
import main.codegen.assembly.generator.Assignment;
import main.codegen.assembly.generator.Expression;
import main.codegen.writer.*;
import main.codegen.desc.Descriptor;
import main.model.*;

import java.util.*;

import static main.codegen.Utils.getAdr;

public class CodeGenerator implements main.parser.CodeGenerator {
    private final TokenList tokenList;
    public static Map<String,Descriptor> variables;
    public static TreeSet<String> tempVariables;
    public static Stack<Descriptor> semanticStack;
    public static Stack<String> labelStack;
    private final Stack<String> typeStack;
    private final Stack<Scope> scopeStack;
    private final List<Scope> classes;
    // used to process function input params
    private List<Variable> tempParams;
    private boolean arrayType;
    private String assignType = "";

    public CodeGenerator(TokenList tokenList) {
        this.tokenList = tokenList;
        variables = new HashMap<>();
        semanticStack = new Stack<>();
        labelStack = new Stack<>();
        typeStack = new Stack<>();
        scopeStack = new Stack<>();
        tempVariables = new TreeSet<>();
        classes = new ArrayList<>();
        tempParams = new ArrayList<>();
        initTempVariables();
    }

    private void initTempVariables() {
        for (int i = 0; i < 10; i++) {
            tempVariables.add("$t" + i);
        }
    }

    @Override
    public void doSemantic(String sem) {
        Symbol currentSymbol = tokenList.getCurrentSymbol();
        switch (sem) {
            case "end_scope":
                scopeStack.pop();
                break;
            case "create_class":
                createClass();
                break;
            case "create_function":
                createFunction();
                break;
            case "end_function":
                System.out.println("end function");
                break;
            case "push_id":
                semanticStack.push(new Descriptor(currentSymbol.getValue() , getPrefix() , Descriptor.Type.VARIABLE));
                break;
            case "push_type":
                typeStack.push(currentSymbol.getValue());
                break;
            case "push_func_type":
                typeStack.push(currentSymbol.getValue());
                break;
            case "push_cast_type":
                typeStack.push(currentSymbol.getValue());
                break;
            case "push_array_type":
                typeStack.push(currentSymbol.getValue());
                break;
            case "push_string":
                Descriptor stringLiteral = new Descriptor(currentSymbol.getValue() , getPrefix() , Descriptor.Type.LITERAL);
                stringLiteral.setDataType(DataType.STRING);
                semanticStack.push(stringLiteral);
                break;
            case "push_real":
                Descriptor realLiteral = new Descriptor(currentSymbol.getValue() , getPrefix() , Descriptor.Type.LITERAL);
                realLiteral.setDataType(DataType.REAL);
                semanticStack.push(realLiteral);
                break;
            case "push_icv":
                Descriptor icv = new Descriptor(currentSymbol.getValue() , getPrefix() , Descriptor.Type.LITERAL);
                icv.setDataType(DataType.INT);
                semanticStack.push(icv);
                break;
            case "push_double":
                Descriptor doubleLiteral = new Descriptor(currentSymbol.getValue() , getPrefix() , Descriptor.Type.LITERAL);
                doubleLiteral.setDataType(DataType.DOUBLE);
                semanticStack.push(doubleLiteral);
                break;
            case "push_void":
                Descriptor voidLiteral = new Descriptor(currentSymbol.getValue() , getPrefix() , Descriptor.Type.LITERAL);
                voidLiteral.setDataType(DataType.VOID);
                semanticStack.push(voidLiteral);
                break;
            case "array_type":
                arrayType = true;
                break;
            case "add_param":
                addFunctionParam();
                break;
            case "add_symbol":
                addSymbolToScope();
                break;


            case "bitwise_xor":
            case "bitwise_and":
            case "bitwise_or":
            case "bigger_than":
            case "bigger_equal":
            case "equal_equal":
            case "not_equal":
            case "less_than":
            case "less_equal":
            case "add":
            case "sub":
            case "mult":
            case "div":
            case "mod":
                Descriptor top = semanticStack.pop();
                Descriptor bottom = semanticStack.pop();
                Expression.binary(bottom, top ,sem);
            case "neg":
                break;





            case "call":
                break;
            case "print_out":
                break;
            case "input_int":
                break;
            case "input_string":
                break;
            case "call_len_str":
                break;
            case "call_len_id":
                break;


            case "assign": // -= += *= /=
                assignment();
                break;
            case "simple_assign": // =
                simpleAssignment();
                break;
            case "minus_assign": // -=
            case "plus_assign": // +=
            case "id_assign":
            case "reference_assign":
            case "array_assign":
                assignType = sem;
                break;


            case "cjz":
                String goLabel = labelStack.pop();
                AssemblyWriter.label(goLabel);
                break;
            case "jp":
                String jzLabel = labelStack.pop();

                String label2 = LabelGenerator.label(LabelGenerator.Type.JUMP , getPrefix());
                labelStack.push(label2);
                AssemblyWriter.instruction("b",label2);

                AssemblyWriter.label(jzLabel);
                break;
            case "cjp":
                String cjpLabel = labelStack.pop();
                AssemblyWriter.label(cjpLabel);
                break;
            case "jb":
                break;
            case "jz":
                String label = LabelGenerator.label(LabelGenerator.Type.JUMP , getPrefix());
                labelStack.push(label);

                Descriptor descriptor = semanticStack.pop();
                String value = getAdr(descriptor);
                if (descriptor.getType() != Descriptor.Type.LITERAL)
                    tempVariables.add(value);
                AssemblyWriter.instruction("jz",value,label);
                break;
            case "cjb":
                break;


            case "plus_plus":
                break;
            case "minus_minus":
                break;
            case "not":
                break;


            case "visit_body":
                break;
            case "visit_loop_body":
                break;


            case "load_return":
                break;
            case "continue_statement":
                break;
            case "return_statement":
                break;
            case "break_statement":
                break;

            case "any_expr":

                break;
            case "bool_expr":

                break;
            case "int_expr":

                break;
            case "assign_expr":

                break;

            default:

        }
    }

    private void simpleAssignment() {
        Descriptor right = semanticStack.pop();
        switch (assignType) {
            case "id_assign": // id <- expr.
                Descriptor leftId = semanticStack.pop();
                Assignment.idAssign(leftId,right);
                break;
            case "reference_assign": // id.id <- expr
                Descriptor idRef = semanticStack.pop();
                Descriptor idSrc = semanticStack.pop();
                break;
            case "array_assign": // id[sub expr] <- expr
                Descriptor left = semanticStack.pop();
                Descriptor subExpr = semanticStack.pop();
                break;
        }
    }

    private void assignment() {
        switch (assignType) {
            case "minus_assign":

                break;
            case "plus_assign":

                break;
        }
    }

    private void createFunction() {
        String functionName = semanticStack.pop().getValue();
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
    }

    private void addSymbolToScope() {
        String varType = typeStack.pop();

        Descriptor descriptor = semanticStack.pop();
        descriptor.setDataType(varType);
        variables.put(descriptor.fullAddress() , descriptor);

        Variable variable = new Variable();
        variable.setName(descriptor.getValue());
        variable.setVariableType(varType);
        variable.setArray(arrayType);
        arrayType = false;

        if (getCurrentScope().hasVariable(variable))
            throw new IllegalArgumentException(String.format("Variable %s cannot be defined twice!\n" , variable.getName()));

        variable.setLabel(LabelGenerator.variable(descriptor.getPrefix() , descriptor.getValue()));
        getCurrentScope().addVariable(variable);
        AssemblyWriter.memory(variable.getLabel() , variable.getVariableType());

    }

    private void addFunctionParam() {
        String paramName = semanticStack.pop().getValue();
        String paramType = typeStack.pop();
        Variable param = new Variable();
        param.setNumber(tempParams.size());
        param.setName(paramName);
        param.setVariableType(paramType);
        param.setArray(arrayType);
        arrayType = false;
        tempParams.add(param);
    }

    private void createClass() {
        String className = semanticStack.pop().getValue();
        Scope scope = new ClassScope(null , className);
        classes.add(scope);
        scopeStack.push(scope);
    }

    public Scope getCurrentScope() {
        return scopeStack.isEmpty() ? null : scopeStack.peek();
    }

    public String getPrefix() {
        String className = classes.size() == 0 ? "" : classes.get(classes.size() - 1).getName();
        Scope currentScope = getCurrentScope();
        String functionName = currentScope == null ? "" : currentScope.getName();

        if (className.isEmpty() && functionName.isEmpty()) return "";

        return functionName.equals(className) ? className : className + "_" + functionName;
    }
}
