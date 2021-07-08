package main.codegen;

import main.TokenList;
import main.codegen.assembly.generator.*;
import main.codegen.desc.MinusPlus;
import main.codegen.writer.*;
import main.model.Descriptor;
import main.model.*;

import java.util.*;

import static main.codegen.Utils.*;

public class CodeGenerator implements main.parser.CodeGenerator {
    public static TreeSet<String> tempVariables;
    public static TreeSet<String> tempFloatVariables;

    private final TokenList tokenList;
    public static Map<String, Descriptor> variables;
    public static Stack<MinusPlus> minusPlusStack;
    public static Stack<Descriptor> semanticStack;
    public static Stack<String> labelStack;
    private final Stack<String> typeStack;
    private final Stack<Scope> scopeStack;
    private final List<Scope> classes;
    // used to process function input params
    private List<Variable> tempParams;
    private boolean arrayType;
    private String assignType = "";
    private boolean arrayAccessOccur;

    public CodeGenerator(TokenList tokenList) {
        this.tokenList = tokenList;
        variables = new HashMap<>();
        semanticStack = new Stack<>();
        minusPlusStack = new Stack<>();
        labelStack = new Stack<>();
        typeStack = new Stack<>();
        scopeStack = new Stack<>();
        tempFloatVariables = new TreeSet<>();
        tempVariables = new TreeSet<>();
        classes = new ArrayList<>();
        tempParams = new ArrayList<>();
        initTempVariables();
    }

    private void initTempVariables() {
        for (int i = 0; i < 10; i++) {
            tempVariables.add("$t" + i);
        }

        for (int i = 0; i <= 31; i += 2) {
            tempFloatVariables.add("$f" + i);
        }
    }

    @Override
    public void doSemantic(String sem) {
        Symbol currentSymbol = tokenList.getCurrentSymbol();
        try {
            forSemantic(currentSymbol,sem);
        } catch (Exception exception) {
            String lineMessage = String.format("error on line %d character %d." , currentSymbol.getLine() , currentSymbol.getPositionInLine());
            throw new RuntimeException(lineMessage , exception);
        }

    }

    private void forSemantic(Symbol currentSymbol,String sem) {
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
                Descriptor item = new Descriptor(currentSymbol.getValue() , getPrefix() , Descriptor.Type.VARIABLE);
                semanticStack.push(item);
                if (!minusPlusStack.isEmpty())
                    minusPlusStack.peek().setDescriptor(item);
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
            case "push_bool":
                System.out.println(currentSymbol.getValue());
                String boolValue = currentSymbol.getValue().equals("true") ? "1" : "0";
                Descriptor boolLiteral = new Descriptor(boolValue , getPrefix() , Descriptor.Type.LITERAL);
                boolLiteral.setDataType(DataType.BOOL);
                semanticStack.push(boolLiteral);
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
            case "create_array":
                typeStack.pop();
//                Descriptor sizeDesc = semanticStack.pop();
//                Descriptor nameDesc = semanticStack.pop();
//                Array.create(nameDesc , sizeDesc);
                // check assignment
                break;
            case "array_access":
                if (arrayAccessOccur) {
                    Descriptor indexDesc = semanticStack.pop();
                    Descriptor idDesc = semanticStack.pop();
                    Array.access(idDesc,indexDesc);
                    arrayAccessOccur = false;
                }
                break;
            case "set_access":
                arrayAccessOccur = true;
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
                Expression.binary(bottom , top , sem);
                break;
            case "neg":
                Expression.unary(semanticStack.pop() , "neg");
                break;


            case "call":
                functionCall(true);
                break;
            case "no_param_call":
                functionCall(false);
                break;


            case "cast":
                Cast.perform(semanticStack.pop() , DataType.valueOf(typeStack.pop().toUpperCase()));
                break;
            case "assign": // -= += *= /=
                assignment();
                break;
            case "simple_assign": // =
                simpleAssignment();
                arrayAccessOccur = false;
                break;
            case "mult_assign":
            case "div_assign":
            case "minus_assign": // -=
            case "plus_assign": // +=
            case "id_assign":
            case "reference_assign":
            case "array_assign":
                assignType = sem;
                break;


            case "cjz":
                // out label
                AssemblyWriter.label(labelStack.pop());
                break;
            case "jp":
                String jzLabel = labelStack.pop();

                String label2 = LabelGenerator.label(LabelGenerator.Type.JUMP , getPrefix());
                labelStack.push(label2);
                AssemblyWriter.instruction("b" , label2);

                AssemblyWriter.label(jzLabel);
                break;
            case "cjp":
                String cjpLabel = labelStack.pop();
                AssemblyWriter.label(cjpLabel);
                break;
            case "jb":
                // this label is for cjz
                AssemblyWriter.instruction("b" , labelStack.pop());
                break;
            case "jb_while":
                String temp = labelStack.pop();
                AssemblyWriter.instruction("b" , labelStack.pop());
                labelStack.push(temp);
                break;
            case "jz":
                jz();

                String bodyLabel = LabelGenerator.label(LabelGenerator.Type.JUMP , getPrefix());
                labelStack.push(bodyLabel);
                AssemblyWriter.instruction("b" , bodyLabel);
                String statementLabel = LabelGenerator.label(LabelGenerator.Type.JUMP , getPrefix());
                labelStack.push(statementLabel);
                AssemblyWriter.label(statementLabel);
                break;
            case "jz_while":
                jz();
                break;
            case "cjb":
                String conditionLabel = LabelGenerator.label(LabelGenerator.Type.LOOP , getPrefix());
                labelStack.push(conditionLabel);
                AssemblyWriter.label(conditionLabel);
                break;
            case "visit_loop_body":
                String l1 = labelStack.pop();
                String l2 = labelStack.pop();
                String l3 = labelStack.pop();
                AssemblyWriter.instruction("b" , labelStack.pop());
                AssemblyWriter.label(l2);
                labelStack.push(l3);
                labelStack.push(l1);
                break;


            // TODO: 7/3/2021 fix these
            case "pre_plus_plus":
                minusPlusStack.push(new MinusPlus(null , -1));
                break;
            case "pre_minus_minus":
                minusPlusStack.push(new MinusPlus(null , -2));
                break;
            case "post_plus_plus":
                minusPlusStack.push(new MinusPlus(semanticStack.peek() , 1));
                break;
            case "post_minus_minus":
                minusPlusStack.push(new MinusPlus(semanticStack.peek() , 2));
                break;
            case "not":
                // TODO: 7/3/2021
                break;


            case "visit_body":
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

    private void jz() {
        String outLabel = LabelGenerator.label(LabelGenerator.Type.JUMP , getPrefix());
        labelStack.push(outLabel);

        Descriptor descriptor = semanticStack.pop();
        if (descriptor.getDataType() == null)
            setDataType(descriptor);
        if (descriptor.getValue() == null) { // floating point compare
            AssemblyWriter.instruction("bc1t" , outLabel); // branch if coprocessor 1 flag is true
        } else {
            String value = getAddress(descriptor , descriptor.getDataType());
            if (descriptor.getType() != Descriptor.Type.LITERAL)
                releaseTempRegister(value);
            AssemblyWriter.instruction("beqz" , value , outLabel);
        }
    }

    private void functionCall(boolean hasParam) {
        if (hasParam) {
            Descriptor top = semanticStack.pop();
            Descriptor down = semanticStack.pop();
            String name = down.getValue();
            switch (name) {
                case "out_int":
                    SystemCall.printInt(top);
                    break;
                case "out_string":
                    SystemCall.printString(top);
                    break;
                case "len":
                    SystemCall.length(top);
                    break;
            }
        } else {
            Descriptor descriptor = semanticStack.pop();
            switch (descriptor.getValue()) {
                case "print_line":
                    SystemCall.printLine();
                    break;
                case "in_string":
                    SystemCall.inputString();
                    break;
                case "in_int":
                    SystemCall.inputInt();
                    break;
            }
        }

    }

    private void simpleAssignment() {
        Descriptor right = semanticStack.pop();
        switch (assignType) {
            case "id_assign": // id <- expr.
                Descriptor leftId = semanticStack.pop();
                Assignment.idAssign(leftId , right);
                break;
            case "reference_assign": // id.id <- expr
                Descriptor idSrc = semanticStack.pop();
                Descriptor idRef = semanticStack.pop();
                Assignment.refAssign(idRef , idSrc , right);
                break;
            case "array_assign": // id[sub expr] <- expr
                Descriptor indexDesc = semanticStack.pop();
                Descriptor left = semanticStack.pop();
                Assignment.arrayAssign(left, indexDesc, right);
                break;
        }
    }

    private void assignment() {
        // TODO: 7/4/2021 add other type of assignment like ref assign and array assign 
        Descriptor right = semanticStack.pop();
        Descriptor leftId = semanticStack.pop();
        switch (assignType) {
            case "minus_assign":
                Assignment.operatorAssign(leftId , right , "sub");
                break;
            case "plus_assign":
                Assignment.operatorAssign(leftId , right , "add");
                break;
            case "mult_assign":
                Assignment.operatorAssign(leftId , right , "mulo");
                break;
            case "div_assign":
                Assignment.operatorAssign(leftId , right , "div");
                break;
            // TODO: 7/4/2021 add % too 
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
        descriptor.setArray(arrayType);
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
        if (!variable.isArray())
            AssemblyWriter.memory(variable.getLabel() , variable.getVariableType());
        else {
            AssemblyWriter.memory(variable.getLabel() , DataType.INT);
            AssemblyWriter.memory(variable.getSizeLabel() , DataType.INT);
        }

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
