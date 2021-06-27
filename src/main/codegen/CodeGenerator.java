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
    private final Stack<ExpressionType> exprTypeStack;
    private List<Scope> classes;
    private List<Variable> tempParams;
    private boolean arrayType;
    private String assignType = "";
    public static String[] BOOL_OPERATORS = {"<" , "<=" , ">" , ">=" , "==" , "!="};
    public static String[] NUMBER_OPERATORS = {"add" , "sub" , "mult" , "div" , "mod","bitwise_xor","bitwise_and","bitwise_or"};
    public static String[] ASSIGN_OPERATORS = {"minus_assign","plus_assign","id_assign","reference_assign","array_assign"};
    public static final String UNARY_OPERATOR = "unary_operator";

    public CodeGenerator(TokenList tokenList) {
        this.tokenList = tokenList;
        idStack = new Stack<>();
        typeStack = new Stack<>();
        literalStack = new Stack<>();
        scopeStack = new Stack<>();
        exprTypeStack = new Stack<>();
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
            case "create_symbolTable":
                createClass();
                break;
            case "create_function":
                createFunction();
                break;
            case "end_function":
                break;
            case "push_id":
                idStack.push(currentSymbol.getValue());
                break;
            case "push_type":
                typeStack.push(currentSymbol.getValue());
                break;
            case "push_lit":
                literalStack.push(currentSymbol.getValue());
                break;
            case "array_type":
                arrayType = true;
                break;
            case "add_param":
                addFunctionParam();
                break;
            case "add_symbol":
                addVariableToScope();
                break;


            case "push_compare":
                exprTypeStack.push(ExpressionType.of(currentSymbol.getValue(), ExpressionType.Level.EXPRESSION));
                break;
            case "add":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION).setBinary(true));
                break;
            case "sub":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION).setBinary(true));
                break;
            case "neg":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION));
                break;
            case "mult":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION).setBinary(true));
                break;
            case "div":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION).setBinary(true));
                break;
            case "mod":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION).setBinary(true));
                break;


            case "bitwise_xor":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION).setBinary(true));
                break;
            case "bitwise_and":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION).setBinary(true));
                break;
            case "bitwise_or":
//                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.SUB_EXPRESSION).setBinary(true));
                break;


            case "call":
                break;
            case "print_out":
                break;
            case "input_int":
                exprTypeStack.push(ExpressionType.of(UNARY_OPERATOR, ExpressionType.Level.OPERAND));
                break;
            case "input_string":
                exprTypeStack.push(ExpressionType.of(UNARY_OPERATOR, ExpressionType.Level.OPERAND));
                break;
            case "call_len_str":
                exprTypeStack.push(ExpressionType.of(UNARY_OPERATOR, ExpressionType.Level.OPERAND));
                break;
            case "call_len_id":
                exprTypeStack.push(ExpressionType.of(UNARY_OPERATOR, ExpressionType.Level.OPERAND));
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
                exprTypeStack.push(ExpressionType.of(sem, ExpressionType.Level.OPERAND));
                break;



            case "cjz":
                break;
            case "cjp":
                break;
            case "jb":
                break;
            case "jz":
                break;
            case "cjb":
                break;


            case "plus_plus":
                exprTypeStack.push(ExpressionType.of(UNARY_OPERATOR, ExpressionType.Level.OPERAND));
                break;
            case "minus_minus":
                exprTypeStack.push(ExpressionType.of(UNARY_OPERATOR, ExpressionType.Level.OPERAND));
                break;
            case "not":
                exprTypeStack.push(ExpressionType.of(UNARY_OPERATOR, ExpressionType.Level.OPERAND));
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
                if (!exprTypeStack.isEmpty()) {
                    ExpressionType pop = exprTypeStack.pop();
//                    if (!pop.isBinary())
//                        exprTypeStack.pop();
                }

                break;
            case "bool_expr":
                if (!isBoolExpression())
                    throw new IllegalArgumentException("a boolean expression required");
                break;
            case "int_expr":
                if (!isNumberExpression())
                    throw new IllegalArgumentException("a number expression required");
                break;
            case "assign_expr":
                if (!isAssignExpression())
                    throw new IllegalArgumentException("a assign expression required");
                break;

            default:

        }
    }

    private void simpleAssignment() {
        switch (assignType) {
            case "id_assign": // id <- expr.
                break;
            case "reference_assign": // id.id <- expr
                break;
            case "array_assign": // id[sub expr] <- expr
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
    }

    private void addVariableToScope() {
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
    }

    private void addFunctionParam() {
        String paramName = idStack.pop();
        String paramType = typeStack.pop();
        Variable param = new Variable();
        param.setNumber(tempParams.size());
        param.setName(paramName);
        param.setType(paramType);
        param.setArray(arrayType);
        arrayType = false;
        tempParams.add(param);
    }

    private void createClass() {
        String className = idStack.pop();
        Scope scope = new ClassScope(null , className);
        classes.add(scope);
        scopeStack.push(scope);
    }


    private boolean isBoolExpression() {
        ExpressionType pop = exprTypeStack.pop();
//        for (String boolOperator : BOOL_OPERATORS) {
//            if (pop.getType().equals(boolOperator))
//                return true;
//        }
        return true;
    }

    private boolean isNumberExpression() {
        ExpressionType pop = exprTypeStack.pop();
//        for (String boolOperator : NUMBER_OPERATORS) {
//            if (pop.getType().equals(boolOperator))
//                return true;
//        }
        return true;
    }

    private boolean isAssignExpression() {
        ExpressionType pop = exprTypeStack.pop();
//        for (String boolOperator : ASSIGN_OPERATORS) {
//            if (pop.getType().equals(boolOperator))
//                return true;
//        }
        return true;
    }

    public Set<String> getSet() {
        return set;
    }

    public Scope getCurrentScope() {
        return scopeStack.isEmpty() ? null : scopeStack.peek();
    }
}
