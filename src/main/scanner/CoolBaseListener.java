package main.scanner;

import main.model.Symbol;
import main.model.SymbolType;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;


public class CoolBaseListener implements CoolListener {

	private List<Symbol> symbols;

	public CoolBaseListener() {
		this.symbols = new ArrayList<>();
	}

	public List<Symbol> getSymbols() {
		return symbols;
	}

	@Override
	public void enterCool(CoolParser.CoolContext ctx) {

	}

	@Override
	public void exitCool(CoolParser.CoolContext ctx) {

	}

	@Override
	public void enterLine(CoolParser.LineContext ctx) {

	}

	@Override
	public void exitLine(CoolParser.LineContext ctx) {

	}

	@Override
	public void enterNewline(CoolParser.NewlineContext ctx) {

	}

	@Override
	public void exitNewline(CoolParser.NewlineContext ctx) {

	}

	@Override
	public void enterSpecial(CoolParser.SpecialContext ctx) {

	}

	@Override
	public void exitSpecial(CoolParser.SpecialContext ctx) {

	}

	@Override
	public void enterSpace(CoolParser.SpaceContext ctx) {

	}

	@Override
	public void exitSpace(CoolParser.SpaceContext ctx) {

	}

	@Override
	public void enterReserved(CoolParser.ReservedContext ctx) {

	}

	@Override
	public void exitReserved(CoolParser.ReservedContext ctx) {

	}

	@Override
	public void enterNumber(CoolParser.NumberContext ctx) {

	}

	@Override
	public void exitNumber(CoolParser.NumberContext ctx) {

	}

	@Override
	public void enterString(CoolParser.StringContext ctx) {

	}

	@Override
	public void exitString(CoolParser.StringContext ctx) {

	}

	@Override
	public void enterOperatorPunctuation(CoolParser.OperatorPunctuationContext ctx) {

	}

	@Override
	public void exitOperatorPunctuation(CoolParser.OperatorPunctuationContext ctx) {

	}

	@Override
	public void enterIdentifier(CoolParser.IdentifierContext ctx) {

	}

	@Override
	public void exitIdentifier(CoolParser.IdentifierContext ctx) {

	}

	@Override
	public void enterComment(CoolParser.CommentContext ctx) {

	}

	@Override
	public void exitComment(CoolParser.CommentContext ctx) {

	}

	@Override
	public void enterUnknown(CoolParser.UnknownContext ctx) {

	}

	@Override
	public void exitUnknown(CoolParser.UnknownContext ctx) {

	}

	@Override
	public void visitTerminal(TerminalNode terminalNode) {
		SymbolType type = SymbolType.values()[terminalNode.getSymbol().getType()];
		switch (type) {
			case WHITESPACE:
			case ONELINECOMMENT:
			case MULTICOMMENT:
				break;
			case UNKNOWN:
				throw new IllegalArgumentException("cannot compile");
			default:
				symbols.add(new Symbol(terminalNode.getText() , type));
		}
	}

	@Override
	public void visitErrorNode(ErrorNode errorNode) {

	}

	@Override
	public void enterEveryRule(ParserRuleContext parserRuleContext) {

	}

	@Override
	public void exitEveryRule(ParserRuleContext parserRuleContext) {

	}
}