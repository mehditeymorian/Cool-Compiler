package main.scanner;// Generated from H:/Projects/Java/ScannerAntlr/src\Cool.g4 by ANTLR 4.9.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
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
			"KEYWORD", "INT", "HEX", "FLOAT", "SCIENTIFIC", "CODE", "ID", "SIGN", 
			"STRING", "E", "ONELINECOMMENT", "MULTICOMMENT", "SPECIAL", "NEWLINE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u012a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u009e"+
		"\n\2\3\3\6\3\u00a1\n\3\r\3\16\3\u00a2\3\4\3\4\3\4\6\4\u00a8\n\4\r\4\16"+
		"\4\u00a9\3\5\3\5\3\5\7\5\u00af\n\5\f\5\16\5\u00b2\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\u00da\n\7\3\b\3\b\7\b\u00de\n\b\f\b\16\b\u00e1\13\b\3\t\5\t\u00e4\n\t"+
		"\3\n\3\n\3\n\7\n\u00e9\n\n\f\n\16\n\u00ec\13\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\7\f\u00f6\n\f\f\f\16\f\u00f9\13\f\3\f\5\f\u00fc\n\f\3\r\3\r"+
		"\3\r\3\r\3\r\7\r\u0103\n\r\f\r\16\r\u0106\13\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0119"+
		"\n\16\3\17\5\17\u011c\n\17\3\17\3\17\6\17\u0120\n\17\r\17\16\17\u0121"+
		"\3\20\6\20\u0125\n\20\r\20\16\20\u0126\3\21\3\21\3\u0104\2\22\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\2\23\n\25\2\27\13\31\f\33\r\35\16\37\17!\20"+
		"\3\2\17\3\2\62;\4\2ZZzz\5\2\62;CHch\4\2,-//\4\2\61\61>>\13\2#$((*+..\60"+
		"\60==]]_`}\177\4\2C\\c|\6\2\62;C\\aac|\4\2--//\4\2$$^^\4\2GGgg\3\2\f\f"+
		"\5\2\13\13\16\17\"\"\2\u0166\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\23\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3\u009d"+
		"\3\2\2\2\5\u00a0\3\2\2\2\7\u00a4\3\2\2\2\t\u00ab\3\2\2\2\13\u00b3\3\2"+
		"\2\2\r\u00d9\3\2\2\2\17\u00db\3\2\2\2\21\u00e3\3\2\2\2\23\u00e5\3\2\2"+
		"\2\25\u00ef\3\2\2\2\27\u00f1\3\2\2\2\31\u00fd\3\2\2\2\33\u0118\3\2\2\2"+
		"\35\u011f\3\2\2\2\37\u0124\3\2\2\2!\u0128\3\2\2\2#$\7x\2\2$%\7q\2\2%&"+
		"\7k\2\2&\u009e\7f\2\2\'(\7h\2\2()\7q\2\2)\u009e\7t\2\2*+\7t\2\2+,\7q\2"+
		"\2,\u009e\7h\2\2-.\7q\2\2./\7w\2\2/\60\7v\2\2\60\61\7a\2\2\61\62\7u\2"+
		"\2\62\63\7v\2\2\63\64\7t\2\2\64\65\7k\2\2\65\66\7p\2\2\66\u009e\7i\2\2"+
		"\678\7k\2\289\7p\2\29:\7a\2\2:;\7k\2\2;<\7p\2\2<\u009e\7v\2\2=>\7k\2\2"+
		">?\7p\2\2?\u009e\7v\2\2@A\7y\2\2AB\7j\2\2BC\7k\2\2CD\7n\2\2D\u009e\7g"+
		"\2\2EF\7n\2\2FG\7g\2\2G\u009e\7v\2\2HI\7p\2\2IJ\7g\2\2J\u009e\7y\2\2K"+
		"L\7q\2\2LM\7w\2\2MN\7v\2\2NO\7a\2\2OP\7k\2\2PQ\7p\2\2Q\u009e\7v\2\2RS"+
		"\7t\2\2ST\7g\2\2TU\7c\2\2U\u009e\7n\2\2VW\7k\2\2W\u009e\7h\2\2XY\7h\2"+
		"\2Y\u009e\7k\2\2Z[\7d\2\2[\\\7t\2\2\\]\7g\2\2]^\7c\2\2^\u009e\7m\2\2_"+
		"`\7v\2\2`a\7j\2\2ab\7g\2\2b\u009e\7p\2\2cd\7d\2\2de\7q\2\2ef\7q\2\2f\u009e"+
		"\7n\2\2gh\7g\2\2hi\7n\2\2ij\7u\2\2j\u009e\7g\2\2kl\7C\2\2lm\7t\2\2mn\7"+
		"t\2\2no\7c\2\2o\u009e\7{\2\2pq\7e\2\2qr\7q\2\2rs\7p\2\2st\7v\2\2tu\7k"+
		"\2\2uv\7p\2\2vw\7w\2\2w\u009e\7g\2\2xy\7n\2\2yz\7g\2\2z\u009e\7p\2\2{"+
		"|\7u\2\2|}\7v\2\2}~\7t\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\u009e\7"+
		"i\2\2\u0081\u0082\7t\2\2\u0082\u0083\7g\2\2\u0083\u0084\7v\2\2\u0084\u0085"+
		"\7w\2\2\u0085\u0086\7t\2\2\u0086\u009e\7p\2\2\u0087\u0088\7n\2\2\u0088"+
		"\u0089\7q\2\2\u0089\u008a\7q\2\2\u008a\u009e\7r\2\2\u008b\u008c\7e\2\2"+
		"\u008c\u008d\7n\2\2\u008d\u008e\7c\2\2\u008e\u008f\7u\2\2\u008f\u009e"+
		"\7u\2\2\u0090\u0091\7k\2\2\u0091\u0092\7p\2\2\u0092\u0093\7a\2\2\u0093"+
		"\u0094\7u\2\2\u0094\u0095\7v\2\2\u0095\u0096\7t\2\2\u0096\u0097\7k\2\2"+
		"\u0097\u0098\7p\2\2\u0098\u009e\7i\2\2\u0099\u009a\7r\2\2\u009a\u009b"+
		"\7q\2\2\u009b\u009c\7q\2\2\u009c\u009e\7n\2\2\u009d#\3\2\2\2\u009d\'\3"+
		"\2\2\2\u009d*\3\2\2\2\u009d-\3\2\2\2\u009d\67\3\2\2\2\u009d=\3\2\2\2\u009d"+
		"@\3\2\2\2\u009dE\3\2\2\2\u009dH\3\2\2\2\u009dK\3\2\2\2\u009dR\3\2\2\2"+
		"\u009dV\3\2\2\2\u009dX\3\2\2\2\u009dZ\3\2\2\2\u009d_\3\2\2\2\u009dc\3"+
		"\2\2\2\u009dg\3\2\2\2\u009dk\3\2\2\2\u009dp\3\2\2\2\u009dx\3\2\2\2\u009d"+
		"{\3\2\2\2\u009d\u0081\3\2\2\2\u009d\u0087\3\2\2\2\u009d\u008b\3\2\2\2"+
		"\u009d\u0090\3\2\2\2\u009d\u0099\3\2\2\2\u009e\4\3\2\2\2\u009f\u00a1\t"+
		"\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\6\3\2\2\2\u00a4\u00a5\7\62\2\2\u00a5\u00a7\t\3\2"+
		"\2\u00a6\u00a8\t\4\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\b\3\2\2\2\u00ab\u00ac\5\5\3\2\u00ac"+
		"\u00b0\7\60\2\2\u00ad\u00af\t\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3"+
		"\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\n\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b3\u00b4\5\5\3\2\u00b4\u00b5\7\60\2\2\u00b5\u00b6\5\5\3\2"+
		"\u00b6\u00b7\5\25\13\2\u00b7\u00b8\5\21\t\2\u00b8\u00b9\5\5\3\2\u00b9"+
		"\f\3\2\2\2\u00ba\u00da\t\5\2\2\u00bb\u00bc\7-\2\2\u00bc\u00da\7?\2\2\u00bd"+
		"\u00be\7/\2\2\u00be\u00da\7?\2\2\u00bf\u00c0\7,\2\2\u00c0\u00da\7?\2\2"+
		"\u00c1\u00c2\7\61\2\2\u00c2\u00da\7?\2\2\u00c3\u00c4\7-\2\2\u00c4\u00da"+
		"\7-\2\2\u00c5\u00c6\7/\2\2\u00c6\u00da\7/\2\2\u00c7\u00da\t\6\2\2\u00c8"+
		"\u00c9\7>\2\2\u00c9\u00da\7?\2\2\u00ca\u00da\7@\2\2\u00cb\u00cc\7@\2\2"+
		"\u00cc\u00da\7?\2\2\u00cd\u00ce\7#\2\2\u00ce\u00da\7?\2\2\u00cf\u00d0"+
		"\7?\2\2\u00d0\u00da\7?\2\2\u00d1\u00d2\7>\2\2\u00d2\u00da\7/\2\2\u00d3"+
		"\u00da\7\'\2\2\u00d4\u00d5\7(\2\2\u00d5\u00da\7(\2\2\u00d6\u00d7\7~\2"+
		"\2\u00d7\u00da\7~\2\2\u00d8\u00da\t\7\2\2\u00d9\u00ba\3\2\2\2\u00d9\u00bb"+
		"\3\2\2\2\u00d9\u00bd\3\2\2\2\u00d9\u00bf\3\2\2\2\u00d9\u00c1\3\2\2\2\u00d9"+
		"\u00c3\3\2\2\2\u00d9\u00c5\3\2\2\2\u00d9\u00c7\3\2\2\2\u00d9\u00c8\3\2"+
		"\2\2\u00d9\u00ca\3\2\2\2\u00d9\u00cb\3\2\2\2\u00d9\u00cd\3\2\2\2\u00d9"+
		"\u00cf\3\2\2\2\u00d9\u00d1\3\2\2\2\u00d9\u00d3\3\2\2\2\u00d9\u00d4\3\2"+
		"\2\2\u00d9\u00d6\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\16\3\2\2\2\u00db\u00df"+
		"\t\b\2\2\u00dc\u00de\t\t\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\20\3\2\2\2\u00e1\u00df\3\2\2"+
		"\2\u00e2\u00e4\t\n\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\22"+
		"\3\2\2\2\u00e5\u00ea\7$\2\2\u00e6\u00e9\5\33\16\2\u00e7\u00e9\n\13\2\2"+
		"\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed"+
		"\u00ee\7$\2\2\u00ee\24\3\2\2\2\u00ef\u00f0\t\f\2\2\u00f0\26\3\2\2\2\u00f1"+
		"\u00f2\7\61\2\2\u00f2\u00f3\7\61\2\2\u00f3\u00f7\3\2\2\2\u00f4\u00f6\n"+
		"\r\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fc\t\r"+
		"\2\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\30\3\2\2\2\u00fd\u00fe"+
		"\7\61\2\2\u00fe\u00ff\7,\2\2\u00ff\u0104\3\2\2\2\u0100\u0103\5\31\r\2"+
		"\u0101\u0103\13\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103\u0106"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0107\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0108\7,\2\2\u0108\u0109\7\61\2\2\u0109\32\3\2\2"+
		"\2\u010a\u010b\7^\2\2\u010b\u0119\7p\2\2\u010c\u010d\7^\2\2\u010d\u0119"+
		"\7v\2\2\u010e\u010f\7^\2\2\u010f\u0119\7$\2\2\u0110\u0111\7^\2\2\u0111"+
		"\u0119\7)\2\2\u0112\u0113\7^\2\2\u0113\u0119\7\62\2\2\u0114\u0115\7^\2"+
		"\2\u0115\u0119\7h\2\2\u0116\u0117\7^\2\2\u0117\u0119\7t\2\2\u0118\u010a"+
		"\3\2\2\2\u0118\u010c\3\2\2\2\u0118\u010e\3\2\2\2\u0118\u0110\3\2\2\2\u0118"+
		"\u0112\3\2\2\2\u0118\u0114\3\2\2\2\u0118\u0116\3\2\2\2\u0119\34\3\2\2"+
		"\2\u011a\u011c\7\17\2\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u0120\7\f\2\2\u011e\u0120\7\17\2\2\u011f\u011b\3"+
		"\2\2\2\u011f\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\36\3\2\2\2\u0123\u0125\t\16\2\2\u0124\u0123\3\2\2"+
		"\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127 "+
		"\3\2\2\2\u0128\u0129\13\2\2\2\u0129\"\3\2\2\2\25\2\u009d\u00a2\u00a9\u00b0"+
		"\u00d9\u00df\u00e3\u00e8\u00ea\u00f7\u00fb\u0102\u0104\u0118\u011b\u011f"+
		"\u0121\u0126\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}