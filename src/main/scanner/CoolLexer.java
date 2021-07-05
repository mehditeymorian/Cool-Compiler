// Generated from H:/Projects/Java/CoolCompiler/src/main/scanner\Cool.g4 by ANTLR 4.9.1
package main.scanner;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, INT=2, HEX=3, FLOAT=4, SCIENTIFIC=5, CODE=6, ID=7, STRING=8, 
		ONELINECOMMENT=9, MULTICOMMENT=10, SPECIAL=11, NEWLINE=12, WHITESPACE=13, 
		UNKNOWN=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KEYWORD", "INT", "NUMBER", "HEX", "FLOAT", "SCIENTIFIC", "CODE", "ID", 
			"SIGN", "STRING", "E", "ONELINECOMMENT", "MULTICOMMENT", "SPECIAL", "NEWLINE", 
			"WHITESPACE", "UNKNOWN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD", "INT", "HEX", "FLOAT", "SCIENTIFIC", "CODE", "ID", "STRING", 
			"ONELINECOMMENT", "MULTICOMMENT", "SPECIAL", "NEWLINE", "WHITESPACE", 
			"UNKNOWN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u012d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\u00a0\n\2\3\3\3\3\3\4\6\4\u00a5\n\4\r\4\16\4\u00a6\3\5\3\5\3"+
		"\5\6\5\u00ac\n\5\r\5\16\5\u00ad\3\6\3\6\3\6\7\6\u00b3\n\6\f\6\16\6\u00b6"+
		"\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00dd\n\b\3\t\3\t\7\t\u00e1\n\t\f\t\16\t\u00e4\13\t"+
		"\3\n\5\n\u00e7\n\n\3\13\3\13\3\13\7\13\u00ec\n\13\f\13\16\13\u00ef\13"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00f9\n\r\f\r\16\r\u00fc\13"+
		"\r\3\r\5\r\u00ff\n\r\3\16\3\16\3\16\3\16\3\16\7\16\u0106\n\16\f\16\16"+
		"\16\u0109\13\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u011c\n\17\3\20\5\20\u011f\n\20\3"+
		"\20\3\20\6\20\u0123\n\20\r\20\16\20\u0124\3\21\6\21\u0128\n\21\r\21\16"+
		"\21\u0129\3\22\3\22\3\u0107\2\23\3\3\5\4\7\2\t\5\13\6\r\7\17\b\21\t\23"+
		"\2\25\n\27\2\31\13\33\f\35\r\37\16!\17#\20\3\2\17\3\2\62;\4\2ZZzz\5\2"+
		"\62;CHch\4\2,-//\4\2\61\61>>\13\2#$((*+..\60\60<=]]_`}\177\4\2C\\c|\6"+
		"\2\62;C\\aac|\4\2--//\4\2$$^^\4\2GGgg\3\2\f\f\5\2\13\13\16\17\"\"\2\u0169"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3\u009f\3\2\2\2\5\u00a1\3\2\2\2\7"+
		"\u00a4\3\2\2\2\t\u00a8\3\2\2\2\13\u00af\3\2\2\2\r\u00b7\3\2\2\2\17\u00dc"+
		"\3\2\2\2\21\u00de\3\2\2\2\23\u00e6\3\2\2\2\25\u00e8\3\2\2\2\27\u00f2\3"+
		"\2\2\2\31\u00f4\3\2\2\2\33\u0100\3\2\2\2\35\u011b\3\2\2\2\37\u0122\3\2"+
		"\2\2!\u0127\3\2\2\2#\u012b\3\2\2\2%&\7x\2\2&\'\7q\2\2\'(\7k\2\2(\u00a0"+
		"\7f\2\2)*\7h\2\2*+\7q\2\2+\u00a0\7t\2\2,-\7t\2\2-.\7q\2\2.\u00a0\7h\2"+
		"\2/\60\7q\2\2\60\61\7w\2\2\61\62\7v\2\2\62\u00a0\7a\2\2\63\64\7k\2\2\64"+
		"\65\7p\2\2\65\66\7a\2\2\66\67\7k\2\2\678\7p\2\289\7v\2\29:\7*\2\2:\u00a0"+
		"\7+\2\2;<\7k\2\2<=\7p\2\2=\u00a0\7v\2\2>?\7y\2\2?@\7j\2\2@A\7k\2\2AB\7"+
		"n\2\2B\u00a0\7g\2\2CD\7n\2\2DE\7g\2\2E\u00a0\7v\2\2FG\7p\2\2GH\7g\2\2"+
		"H\u00a0\7y\2\2IJ\7t\2\2JK\7g\2\2KL\7c\2\2L\u00a0\7n\2\2MN\7k\2\2N\u00a0"+
		"\7h\2\2OP\7h\2\2P\u00a0\7k\2\2QR\7d\2\2RS\7t\2\2ST\7g\2\2TU\7c\2\2U\u00a0"+
		"\7m\2\2VW\7v\2\2WX\7j\2\2XY\7g\2\2Y\u00a0\7p\2\2Z[\7d\2\2[\\\7q\2\2\\"+
		"]\7q\2\2]\u00a0\7n\2\2^_\7g\2\2_`\7n\2\2`a\7u\2\2a\u00a0\7g\2\2bc\7C\2"+
		"\2cd\7t\2\2de\7t\2\2ef\7c\2\2f\u00a0\7{\2\2gh\7e\2\2hi\7q\2\2ij\7p\2\2"+
		"jk\7v\2\2kl\7k\2\2lm\7p\2\2mn\7w\2\2n\u00a0\7g\2\2op\7n\2\2pq\7g\2\2q"+
		"\u00a0\7p\2\2rs\7u\2\2st\7v\2\2tu\7t\2\2uv\7k\2\2vw\7p\2\2w\u00a0\7i\2"+
		"\2xy\7t\2\2yz\7g\2\2z{\7v\2\2{|\7w\2\2|}\7t\2\2}\u00a0\7p\2\2~\177\7n"+
		"\2\2\177\u0080\7q\2\2\u0080\u0081\7q\2\2\u0081\u00a0\7r\2\2\u0082\u0083"+
		"\7e\2\2\u0083\u0084\7n\2\2\u0084\u0085\7c\2\2\u0085\u0086\7u\2\2\u0086"+
		"\u00a0\7u\2\2\u0087\u0088\7k\2\2\u0088\u0089\7p\2\2\u0089\u008a\7a\2\2"+
		"\u008a\u008b\7u\2\2\u008b\u008c\7v\2\2\u008c\u008d\7t\2\2\u008d\u008e"+
		"\7k\2\2\u008e\u008f\7p\2\2\u008f\u0090\7i\2\2\u0090\u0091\7*\2\2\u0091"+
		"\u00a0\7+\2\2\u0092\u0093\7r\2\2\u0093\u0094\7q\2\2\u0094\u0095\7q\2\2"+
		"\u0095\u00a0\7n\2\2\u0096\u0097\7v\2\2\u0097\u0098\7t\2\2\u0098\u0099"+
		"\7w\2\2\u0099\u00a0\7g\2\2\u009a\u009b\7h\2\2\u009b\u009c\7c\2\2\u009c"+
		"\u009d\7n\2\2\u009d\u009e\7u\2\2\u009e\u00a0\7g\2\2\u009f%\3\2\2\2\u009f"+
		")\3\2\2\2\u009f,\3\2\2\2\u009f/\3\2\2\2\u009f\63\3\2\2\2\u009f;\3\2\2"+
		"\2\u009f>\3\2\2\2\u009fC\3\2\2\2\u009fF\3\2\2\2\u009fI\3\2\2\2\u009fM"+
		"\3\2\2\2\u009fO\3\2\2\2\u009fQ\3\2\2\2\u009fV\3\2\2\2\u009fZ\3\2\2\2\u009f"+
		"^\3\2\2\2\u009fb\3\2\2\2\u009fg\3\2\2\2\u009fo\3\2\2\2\u009fr\3\2\2\2"+
		"\u009fx\3\2\2\2\u009f~\3\2\2\2\u009f\u0082\3\2\2\2\u009f\u0087\3\2\2\2"+
		"\u009f\u0092\3\2\2\2\u009f\u0096\3\2\2\2\u009f\u009a\3\2\2\2\u00a0\4\3"+
		"\2\2\2\u00a1\u00a2\5\7\4\2\u00a2\6\3\2\2\2\u00a3\u00a5\t\2\2\2\u00a4\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\b\3\2\2\2\u00a8\u00a9\7\62\2\2\u00a9\u00ab\t\3\2\2\u00aa\u00ac\t\4\2"+
		"\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\n\3\2\2\2\u00af\u00b0\5\7\4\2\u00b0\u00b4\7\60\2\2\u00b1"+
		"\u00b3\t\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\f\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8"+
		"\5\7\4\2\u00b8\u00b9\7\60\2\2\u00b9\u00ba\5\7\4\2\u00ba\u00bb\5\27\f\2"+
		"\u00bb\u00bc\5\5\3\2\u00bc\16\3\2\2\2\u00bd\u00dd\t\5\2\2\u00be\u00bf"+
		"\7-\2\2\u00bf\u00dd\7?\2\2\u00c0\u00c1\7/\2\2\u00c1\u00dd\7?\2\2\u00c2"+
		"\u00c3\7,\2\2\u00c3\u00dd\7?\2\2\u00c4\u00c5\7\61\2\2\u00c5\u00dd\7?\2"+
		"\2\u00c6\u00c7\7-\2\2\u00c7\u00dd\7-\2\2\u00c8\u00c9\7/\2\2\u00c9\u00dd"+
		"\7/\2\2\u00ca\u00dd\t\6\2\2\u00cb\u00cc\7>\2\2\u00cc\u00dd\7?\2\2\u00cd"+
		"\u00dd\7@\2\2\u00ce\u00cf\7@\2\2\u00cf\u00dd\7?\2\2\u00d0\u00d1\7#\2\2"+
		"\u00d1\u00dd\7?\2\2\u00d2\u00d3\7?\2\2\u00d3\u00dd\7?\2\2\u00d4\u00d5"+
		"\7>\2\2\u00d5\u00dd\7/\2\2\u00d6\u00dd\7\'\2\2\u00d7\u00d8\7(\2\2\u00d8"+
		"\u00dd\7(\2\2\u00d9\u00da\7~\2\2\u00da\u00dd\7~\2\2\u00db\u00dd\t\7\2"+
		"\2\u00dc\u00bd\3\2\2\2\u00dc\u00be\3\2\2\2\u00dc\u00c0\3\2\2\2\u00dc\u00c2"+
		"\3\2\2\2\u00dc\u00c4\3\2\2\2\u00dc\u00c6\3\2\2\2\u00dc\u00c8\3\2\2\2\u00dc"+
		"\u00ca\3\2\2\2\u00dc\u00cb\3\2\2\2\u00dc\u00cd\3\2\2\2\u00dc\u00ce\3\2"+
		"\2\2\u00dc\u00d0\3\2\2\2\u00dc\u00d2\3\2\2\2\u00dc\u00d4\3\2\2\2\u00dc"+
		"\u00d6\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dc\u00db\3\2"+
		"\2\2\u00dd\20\3\2\2\2\u00de\u00e2\t\b\2\2\u00df\u00e1\t\t\2\2\u00e0\u00df"+
		"\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\22\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e7\t\n\2\2\u00e6\u00e5\3\2\2"+
		"\2\u00e6\u00e7\3\2\2\2\u00e7\24\3\2\2\2\u00e8\u00ed\7$\2\2\u00e9\u00ec"+
		"\5\35\17\2\u00ea\u00ec\n\13\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2\2"+
		"\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7$\2\2\u00f1\26\3\2\2\2\u00f2"+
		"\u00f3\t\f\2\2\u00f3\30\3\2\2\2\u00f4\u00f5\7\61\2\2\u00f5\u00f6\7\61"+
		"\2\2\u00f6\u00fa\3\2\2\2\u00f7\u00f9\n\r\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fe\3\2"+
		"\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00ff\t\r\2\2\u00fe\u00fd\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\32\3\2\2\2\u0100\u0101\7\61\2\2\u0101\u0102\7,\2"+
		"\2\u0102\u0107\3\2\2\2\u0103\u0106\5\33\16\2\u0104\u0106\13\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0107\u0105\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010b\7,\2\2\u010b\u010c\7\61\2\2\u010c\34\3\2\2\2\u010d\u010e\7^\2\2"+
		"\u010e\u011c\7p\2\2\u010f\u0110\7^\2\2\u0110\u011c\7v\2\2\u0111\u0112"+
		"\7^\2\2\u0112\u011c\7$\2\2\u0113\u0114\7^\2\2\u0114\u011c\7)\2\2\u0115"+
		"\u0116\7^\2\2\u0116\u011c\7\62\2\2\u0117\u0118\7^\2\2\u0118\u011c\7h\2"+
		"\2\u0119\u011a\7^\2\2\u011a\u011c\7t\2\2\u011b\u010d\3\2\2\2\u011b\u010f"+
		"\3\2\2\2\u011b\u0111\3\2\2\2\u011b\u0113\3\2\2\2\u011b\u0115\3\2\2\2\u011b"+
		"\u0117\3\2\2\2\u011b\u0119\3\2\2\2\u011c\36\3\2\2\2\u011d\u011f\7\17\2"+
		"\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0123"+
		"\7\f\2\2\u0121\u0123\7\17\2\2\u0122\u011e\3\2\2\2\u0122\u0121\3\2\2\2"+
		"\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125 \3"+
		"\2\2\2\u0126\u0128\t\16\2\2\u0127\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\"\3\2\2\2\u012b\u012c\13\2\2"+
		"\2\u012c$\3\2\2\2\25\2\u009f\u00a6\u00ad\u00b4\u00dc\u00e2\u00e6\u00eb"+
		"\u00ed\u00fa\u00fe\u0105\u0107\u011b\u011e\u0122\u0124\u0129\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}