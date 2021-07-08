package main;

import main.codegen.CodeGenerator;
import main.codegen.writer.AssemblyWriter;
import main.parser.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AssemblyWriter.init("result.s");
        TokenList tokenList = new TokenList(Main.class.getResource("test4.txt").getFile());
        CodeGenerator codeGenerator = new CodeGenerator(tokenList);
        Parser parser = new Parser(tokenList , codeGenerator , "H:\\Projects\\Java\\CoolCompiler\\src\\main\\parser\\table.npt");
        parser.parse();
        AssemblyWriter.flush();


    }
}
