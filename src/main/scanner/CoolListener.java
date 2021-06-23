// Generated from H:/Projects/Java/CoolCompiler/src/main/scanner\Cool.g4 by ANTLR 4.9.1
package main.scanner;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CoolParser}.
 */
public interface CoolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CoolParser#cool}.
	 * @param ctx the parse tree
	 */
	void enterCool(CoolParser.CoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#cool}.
	 * @param ctx the parse tree
	 */
	void exitCool(CoolParser.CoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(CoolParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(CoolParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#newline}.
	 * @param ctx the parse tree
	 */
	void enterNewline(CoolParser.NewlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#newline}.
	 * @param ctx the parse tree
	 */
	void exitNewline(CoolParser.NewlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#special}.
	 * @param ctx the parse tree
	 */
	void enterSpecial(CoolParser.SpecialContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#special}.
	 * @param ctx the parse tree
	 */
	void exitSpecial(CoolParser.SpecialContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#space}.
	 * @param ctx the parse tree
	 */
	void enterSpace(CoolParser.SpaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#space}.
	 * @param ctx the parse tree
	 */
	void exitSpace(CoolParser.SpaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#reserved}.
	 * @param ctx the parse tree
	 */
	void enterReserved(CoolParser.ReservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#reserved}.
	 * @param ctx the parse tree
	 */
	void exitReserved(CoolParser.ReservedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CoolParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CoolParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(CoolParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(CoolParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#operatorPunctuation}.
	 * @param ctx the parse tree
	 */
	void enterOperatorPunctuation(CoolParser.OperatorPunctuationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#operatorPunctuation}.
	 * @param ctx the parse tree
	 */
	void exitOperatorPunctuation(CoolParser.OperatorPunctuationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(CoolParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(CoolParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(CoolParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(CoolParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#unknown}.
	 * @param ctx the parse tree
	 */
	void enterUnknown(CoolParser.UnknownContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#unknown}.
	 * @param ctx the parse tree
	 */
	void exitUnknown(CoolParser.UnknownContext ctx);
}