package main;

import main.model.Symbol;
import main.parser.Lexical;
import main.scanner.CoolBaseListener;
import main.scanner.CoolLexer;
import main.scanner.CoolParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;

public class TokenList implements Lexical {
    private List<Symbol> symbols;
    private int index = 0;
    private Symbol currentSymbol;


    public TokenList(String fileName) throws IOException {
        CharStream stream = new ANTLRFileStream(fileName);
        CoolLexer lexer = new CoolLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CoolParser parser = new CoolParser(tokenStream);
        parser.setBuildParseTree(true);
        CoolParser.CoolContext cool = parser.cool();
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        CoolBaseListener listener = new CoolBaseListener();
        parseTreeWalker.walk(listener , cool);
        symbols = listener.getSymbols();
    }

    @Override
    public String nextToken() {
        currentSymbol = index < symbols.size() ? symbols.get(index) : null;
        index++;
        return currentSymbol != null ? currentSymbol.getType() : "$";
    }

    public Symbol getCurrentSymbol() {
        return currentSymbol;
    }
}
