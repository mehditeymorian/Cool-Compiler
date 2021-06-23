package main.codegen;

import main.TokenList;

public class CodeGenerator implements main.parser.CodeGenerator {
    private TokenList tokenList;

    public CodeGenerator(TokenList tokenList) {
        this.tokenList = tokenList;
    }

    @Override
    public void doSemantic(String sem) {
        System.out.printf("Semantic: %s symbol: %s\n" , sem , tokenList.getCurrentSymbol().getValue());
    }
}
