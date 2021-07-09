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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u0113\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u0086\n\2\3\3\3\3\3\4\6\4"+
		"\u008b\n\4\r\4\16\4\u008c\3\5\3\5\3\5\6\5\u0092\n\5\r\5\16\5\u0093\3\6"+
		"\3\6\3\6\7\6\u0099\n\6\f\6\16\6\u009c\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c3\n\b\3\t\3"+
		"\t\7\t\u00c7\n\t\f\t\16\t\u00ca\13\t\3\n\5\n\u00cd\n\n\3\13\3\13\3\13"+
		"\7\13\u00d2\n\13\f\13\16\13\u00d5\13\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\7\r\u00df\n\r\f\r\16\r\u00e2\13\r\3\r\5\r\u00e5\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u00ec\n\16\f\16\16\16\u00ef\13\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u0102\n\17\3\20\5\20\u0105\n\20\3\20\3\20\6\20\u0109\n\20\r\20\16\20"+
		"\u010a\3\21\6\21\u010e\n\21\r\21\16\21\u010f\3\22\3\22\3\u00ed\2\23\3"+
		"\3\5\4\7\2\t\5\13\6\r\7\17\b\21\t\23\2\25\n\27\2\31\13\33\f\35\r\37\16"+
		"!\17#\20\3\2\17\3\2\62;\4\2ZZzz\5\2\62;CHch\4\2,-//\4\2\61\61>>\13\2#"+
		"$((*+..\60\60<=]]_`}\177\4\2C\\c|\6\2\62;C\\aac|\4\2--//\4\2$$^^\4\2G"+
		"Ggg\3\2\f\f\5\2\13\13\16\17\"\"\2\u014b\2\3\3\2\2\2\2\5\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\3\u0085\3\2\2\2\5\u0087\3\2\2\2\7\u008a\3\2\2\2\t\u008e\3\2\2\2\13"+
		"\u0095\3\2\2\2\r\u009d\3\2\2\2\17\u00c2\3\2\2\2\21\u00c4\3\2\2\2\23\u00cc"+
		"\3\2\2\2\25\u00ce\3\2\2\2\27\u00d8\3\2\2\2\31\u00da\3\2\2\2\33\u00e6\3"+
		"\2\2\2\35\u0101\3\2\2\2\37\u0108\3\2\2\2!\u010d\3\2\2\2#\u0111\3\2\2\2"+
		"%&\7x\2\2&\'\7q\2\2\'(\7k\2\2(\u0086\7f\2\2)*\7h\2\2*+\7q\2\2+\u0086\7"+
		"t\2\2,-\7t\2\2-.\7q\2\2.\u0086\7h\2\2/\60\7k\2\2\60\61\7p\2\2\61\u0086"+
		"\7v\2\2\62\63\7y\2\2\63\64\7j\2\2\64\65\7k\2\2\65\66\7n\2\2\66\u0086\7"+
		"g\2\2\678\7n\2\289\7g\2\29\u0086\7v\2\2:;\7p\2\2;<\7g\2\2<\u0086\7y\2"+
		"\2=>\7t\2\2>?\7g\2\2?@\7c\2\2@\u0086\7n\2\2AB\7k\2\2B\u0086\7h\2\2CD\7"+
		"h\2\2D\u0086\7k\2\2EF\7d\2\2FG\7t\2\2GH\7g\2\2HI\7c\2\2I\u0086\7m\2\2"+
		"JK\7v\2\2KL\7j\2\2LM\7g\2\2M\u0086\7p\2\2NO\7d\2\2OP\7q\2\2PQ\7q\2\2Q"+
		"\u0086\7n\2\2RS\7g\2\2ST\7n\2\2TU\7u\2\2U\u0086\7g\2\2VW\7C\2\2WX\7t\2"+
		"\2XY\7t\2\2YZ\7c\2\2Z\u0086\7{\2\2[\\\7e\2\2\\]\7q\2\2]^\7p\2\2^_\7v\2"+
		"\2_`\7k\2\2`a\7p\2\2ab\7w\2\2b\u0086\7g\2\2cd\7u\2\2de\7v\2\2ef\7t\2\2"+
		"fg\7k\2\2gh\7p\2\2h\u0086\7i\2\2ij\7t\2\2jk\7g\2\2kl\7v\2\2lm\7w\2\2m"+
		"n\7t\2\2n\u0086\7p\2\2op\7n\2\2pq\7q\2\2qr\7q\2\2r\u0086\7r\2\2st\7e\2"+
		"\2tu\7n\2\2uv\7c\2\2vw\7u\2\2w\u0086\7u\2\2xy\7r\2\2yz\7q\2\2z{\7q\2\2"+
		"{\u0086\7n\2\2|}\7v\2\2}~\7t\2\2~\177\7w\2\2\177\u0086\7g\2\2\u0080\u0081"+
		"\7h\2\2\u0081\u0082\7c\2\2\u0082\u0083\7n\2\2\u0083\u0084\7u\2\2\u0084"+
		"\u0086\7g\2\2\u0085%\3\2\2\2\u0085)\3\2\2\2\u0085,\3\2\2\2\u0085/\3\2"+
		"\2\2\u0085\62\3\2\2\2\u0085\67\3\2\2\2\u0085:\3\2\2\2\u0085=\3\2\2\2\u0085"+
		"A\3\2\2\2\u0085C\3\2\2\2\u0085E\3\2\2\2\u0085J\3\2\2\2\u0085N\3\2\2\2"+
		"\u0085R\3\2\2\2\u0085V\3\2\2\2\u0085[\3\2\2\2\u0085c\3\2\2\2\u0085i\3"+
		"\2\2\2\u0085o\3\2\2\2\u0085s\3\2\2\2\u0085x\3\2\2\2\u0085|\3\2\2\2\u0085"+
		"\u0080\3\2\2\2\u0086\4\3\2\2\2\u0087\u0088\5\7\4\2\u0088\6\3\2\2\2\u0089"+
		"\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\b\3\2\2\2\u008e\u008f\7\62\2\2\u008f\u0091"+
		"\t\3\2\2\u0090\u0092\t\4\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\n\3\2\2\2\u0095\u0096\5\7\4\2"+
		"\u0096\u009a\7\60\2\2\u0097\u0099\t\2\2\2\u0098\u0097\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\f\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009e\5\7\4\2\u009e\u009f\7\60\2\2\u009f\u00a0\5"+
		"\7\4\2\u00a0\u00a1\5\27\f\2\u00a1\u00a2\5\5\3\2\u00a2\16\3\2\2\2\u00a3"+
		"\u00c3\t\5\2\2\u00a4\u00a5\7-\2\2\u00a5\u00c3\7?\2\2\u00a6\u00a7\7/\2"+
		"\2\u00a7\u00c3\7?\2\2\u00a8\u00a9\7,\2\2\u00a9\u00c3\7?\2\2\u00aa\u00ab"+
		"\7\61\2\2\u00ab\u00c3\7?\2\2\u00ac\u00ad\7-\2\2\u00ad\u00c3\7-\2\2\u00ae"+
		"\u00af\7/\2\2\u00af\u00c3\7/\2\2\u00b0\u00c3\t\6\2\2\u00b1\u00b2\7>\2"+
		"\2\u00b2\u00c3\7?\2\2\u00b3\u00c3\7@\2\2\u00b4\u00b5\7@\2\2\u00b5\u00c3"+
		"\7?\2\2\u00b6\u00b7\7#\2\2\u00b7\u00c3\7?\2\2\u00b8\u00b9\7?\2\2\u00b9"+
		"\u00c3\7?\2\2\u00ba\u00bb\7>\2\2\u00bb\u00c3\7/\2\2\u00bc\u00c3\7\'\2"+
		"\2\u00bd\u00be\7(\2\2\u00be\u00c3\7(\2\2\u00bf\u00c0\7~\2\2\u00c0\u00c3"+
		"\7~\2\2\u00c1\u00c3\t\7\2\2\u00c2\u00a3\3\2\2\2\u00c2\u00a4\3\2\2\2\u00c2"+
		"\u00a6\3\2\2\2\u00c2\u00a8\3\2\2\2\u00c2\u00aa\3\2\2\2\u00c2\u00ac\3\2"+
		"\2\2\u00c2\u00ae\3\2\2\2\u00c2\u00b0\3\2\2\2\u00c2\u00b1\3\2\2\2\u00c2"+
		"\u00b3\3\2\2\2\u00c2\u00b4\3\2\2\2\u00c2\u00b6\3\2\2\2\u00c2\u00b8\3\2"+
		"\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2"+
		"\u00bf\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\20\3\2\2\2\u00c4\u00c8\t\b\2"+
		"\2\u00c5\u00c7\t\t\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\22\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb"+
		"\u00cd\t\n\2\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\24\3\2\2"+
		"\2\u00ce\u00d3\7$\2\2\u00cf\u00d2\5\35\17\2\u00d0\u00d2\n\13\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d7\7$\2\2\u00d7\26\3\2\2\2\u00d8\u00d9\t\f\2\2\u00d9\30\3\2\2\2\u00da"+
		"\u00db\7\61\2\2\u00db\u00dc\7\61\2\2\u00dc\u00e0\3\2\2\2\u00dd\u00df\n"+
		"\r\2\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e5\t\r"+
		"\2\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\32\3\2\2\2\u00e6\u00e7"+
		"\7\61\2\2\u00e7\u00e8\7,\2\2\u00e8\u00ed\3\2\2\2\u00e9\u00ec\5\33\16\2"+
		"\u00ea\u00ec\13\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1\u00f2\7\61\2\2\u00f2\34\3\2\2"+
		"\2\u00f3\u00f4\7^\2\2\u00f4\u0102\7p\2\2\u00f5\u00f6\7^\2\2\u00f6\u0102"+
		"\7v\2\2\u00f7\u00f8\7^\2\2\u00f8\u0102\7$\2\2\u00f9\u00fa\7^\2\2\u00fa"+
		"\u0102\7)\2\2\u00fb\u00fc\7^\2\2\u00fc\u0102\7\62\2\2\u00fd\u00fe\7^\2"+
		"\2\u00fe\u0102\7h\2\2\u00ff\u0100\7^\2\2\u0100\u0102\7t\2\2\u0101\u00f3"+
		"\3\2\2\2\u0101\u00f5\3\2\2\2\u0101\u00f7\3\2\2\2\u0101\u00f9\3\2\2\2\u0101"+
		"\u00fb\3\2\2\2\u0101\u00fd\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\36\3\2\2"+
		"\2\u0103\u0105\7\17\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0109\7\f\2\2\u0107\u0109\7\17\2\2\u0108\u0104\3"+
		"\2\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b \3\2\2\2\u010c\u010e\t\16\2\2\u010d\u010c\3\2\2\2"+
		"\u010e\u010f\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\"\3"+
		"\2\2\2\u0111\u0112\13\2\2\2\u0112$\3\2\2\2\25\2\u0085\u008c\u0093\u009a"+
		"\u00c2\u00c8\u00cc\u00d1\u00d3\u00e0\u00e4\u00eb\u00ed\u0101\u0104\u0108"+
		"\u010a\u010f\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}