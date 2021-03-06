// Generated from Enquanto.g4 by ANTLR 4.4

package plp.enquanto.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnquantoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__33=1, T__32=2, T__31=3, T__30=4, T__29=5, T__28=6, T__27=7, T__26=8, 
		T__25=9, T__24=10, T__23=11, T__22=12, T__21=13, T__20=14, T__19=15, T__18=16, 
		T__17=17, T__16=18, T__15=19, T__14=20, T__13=21, T__12=22, T__11=23, 
		T__10=24, T__9=25, T__8=26, T__7=27, T__6=28, T__5=29, T__4=30, T__3=31, 
		T__2=32, T__1=33, T__0=34, INT=35, ID=36, Texto=37, Espaco=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'"
	};
	public static final String[] ruleNames = {
		"T__33", "T__32", "T__31", "T__30", "T__29", "T__28", "T__27", "T__26", 
		"T__25", "T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", 
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "INT", "ID", "Texto", "Espaco"
	};


	public EnquantoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Enquanto.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u00ef\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\3$\6$\u00da\n$\r$\16"+
		"$\u00db\3%\6%\u00df\n%\r%\16%\u00e0\3&\3&\7&\u00e5\n&\f&\16&\u00e8\13"+
		"&\3&\3&\3\'\3\'\3\'\3\'\3\u00e6\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(\3\2\3\5\2\13"+
		"\f\17\17\"\"\u00f1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5Q\3\2"+
		"\2\2\7S\3\2\2\2\tU\3\2\2\2\13W\3\2\2\2\rY\3\2\2\2\17[\3\2\2\2\21`\3\2"+
		"\2\2\23d\3\2\2\2\25g\3\2\2\2\27j\3\2\2\2\31m\3\2\2\2\33q\3\2\2\2\35w\3"+
		"\2\2\2\37z\3\2\2\2!|\3\2\2\2#\u0081\3\2\2\2%\u0087\3\2\2\2\'\u0089\3\2"+
		"\2\2)\u008f\3\2\2\2+\u009a\3\2\2\2-\u009d\3\2\2\2/\u00a5\3\2\2\2\61\u00ab"+
		"\3\2\2\2\63\u00ae\3\2\2\2\65\u00b3\3\2\2\2\67\u00b7\3\2\2\29\u00bf\3\2"+
		"\2\2;\u00c2\3\2\2\2=\u00c4\3\2\2\2?\u00cd\3\2\2\2A\u00cf\3\2\2\2C\u00d1"+
		"\3\2\2\2E\u00d3\3\2\2\2G\u00d9\3\2\2\2I\u00de\3\2\2\2K\u00e2\3\2\2\2M"+
		"\u00eb\3\2\2\2OP\7\61\2\2P\4\3\2\2\2QR\7}\2\2R\6\3\2\2\2ST\7=\2\2T\b\3"+
		"\2\2\2UV\7?\2\2V\n\3\2\2\2WX\7\177\2\2X\f\3\2\2\2YZ\7`\2\2Z\16\3\2\2\2"+
		"[\\\7h\2\2\\]\7c\2\2]^\7e\2\2^_\7c\2\2_\20\3\2\2\2`a\7c\2\2ab\7v\2\2b"+
		"c\7g\2\2c\22\3\2\2\2de\7<\2\2ef\7?\2\2f\24\3\2\2\2gh\7>\2\2hi\7?\2\2i"+
		"\26\3\2\2\2jk\7f\2\2kl\7g\2\2l\30\3\2\2\2mn\7p\2\2no\7c\2\2op\7q\2\2p"+
		"\32\3\2\2\2qr\7h\2\2rs\7c\2\2st\7n\2\2tu\7u\2\2uv\7q\2\2v\34\3\2\2\2w"+
		"x\7q\2\2xy\7w\2\2y\36\3\2\2\2z{\7*\2\2{ \3\2\2\2|}\7r\2\2}~\7c\2\2~\177"+
		"\7t\2\2\177\u0080\7c\2\2\u0080\"\3\2\2\2\u0081\u0082\7g\2\2\u0082\u0083"+
		"\7p\2\2\u0083\u0084\7v\2\2\u0084\u0085\7c\2\2\u0085\u0086\7q\2\2\u0086"+
		"$\3\2\2\2\u0087\u0088\7,\2\2\u0088&\3\2\2\2\u0089\u008a\7g\2\2\u008a\u008b"+
		"\7z\2\2\u008b\u008c\7k\2\2\u008c\u008d\7d\2\2\u008d\u008e\7c\2\2\u008e"+
		"(\3\2\2\2\u008f\u0090\7x\2\2\u0090\u0091\7g\2\2\u0091\u0092\7t\2\2\u0092"+
		"\u0093\7f\2\2\u0093\u0094\7c\2\2\u0094\u0095\7f\2\2\u0095\u0096\7g\2\2"+
		"\u0096\u0097\7k\2\2\u0097\u0098\7t\2\2\u0098\u0099\7q\2\2\u0099*\3\2\2"+
		"\2\u009a\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c,\3\2\2\2\u009d\u009e\7"+
		"u\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2"+
		"\7q\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7g\2\2\u00a4.\3\2\2\2\u00a5\u00a6"+
		"\7u\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7c\2\2\u00a9"+
		"\u00aa\7q\2\2\u00aa\60\3\2\2\2\u00ab\u00ac\7@\2\2\u00ac\u00ad\7?\2\2\u00ad"+
		"\62\3\2\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7m\2\2\u00b0\u00b1\7k\2\2\u00b1"+
		"\u00b2\7r\2\2\u00b2\64\3\2\2\2\u00b3\u00b4\7z\2\2\u00b4\u00b5\7q\2\2\u00b5"+
		"\u00b6\7t\2\2\u00b6\66\3\2\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7u\2\2\u00b9"+
		"\u00ba\7e\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7x\2\2"+
		"\u00bd\u00be\7c\2\2\u00be8\3\2\2\2\u00bf\u00c0\7>\2\2\u00c0\u00c1\7@\2"+
		"\2\u00c1:\3\2\2\2\u00c2\u00c3\7g\2\2\u00c3<\3\2\2\2\u00c4\u00c5\7g\2\2"+
		"\u00c5\u00c6\7p\2\2\u00c6\u00c7\7s\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9"+
		"\7c\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7q\2\2\u00cc"+
		">\3\2\2\2\u00cd\u00ce\7+\2\2\u00ce@\3\2\2\2\u00cf\u00d0\7-\2\2\u00d0B"+
		"\3\2\2\2\u00d1\u00d2\7/\2\2\u00d2D\3\2\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5"+
		"\7g\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7c\2\2\u00d7F\3\2\2\2\u00d8\u00da"+
		"\4\62;\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dcH\3\2\2\2\u00dd\u00df\4c|\2\u00de\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1J\3\2\2\2"+
		"\u00e2\u00e6\7$\2\2\u00e3\u00e5\13\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00ea\7$\2\2\u00eaL\3\2\2\2\u00eb\u00ec\t\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ee\b\'\2\2\u00eeN\3\2\2\2\6\2\u00db\u00e0\u00e6"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}