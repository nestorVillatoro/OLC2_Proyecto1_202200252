// Generated from /home/nestorvillatoro/Documentos/OLC2_Proyecto1_202200252/proyecto compi 2/api/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		INT=39, BOOL=40, FLOAT=41, STRING=42, RUNE=43, WS=44, TIPOS=45, ID=46, 
		COMMENT=47, ML_COMMENT=48;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_funcDcl = 3, RULE_classDcl = 4, 
		RULE_classBody = 5, RULE_params = 6, RULE_stmt = 7, RULE_forInit = 8, 
		RULE_expr = 9, RULE_call = 10, RULE_args = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "funcDcl", "classDcl", "classBody", "params", 
			"stmt", "forInit", "expr", "call", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'function'", "'('", "')'", "'{'", 
			"'}'", "'class'", "','", "'if'", "'else'", "'while'", "'for'", "'break'", 
			"'continue'", "'return'", "'!'", "'-'", "'*'", "'/'", "'%'", "'+'", "'+='", 
			"'-='", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", 
			"'['", "']'", "'new'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT", "BOOL", "FLOAT", "STRING", "RUNE", "WS", "TIPOS", 
			"ID", "COMMENT", "ML_COMMENT"
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

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 78786882164066L) != 0)) {
				{
				{
				setState(24);
				dcl();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DclContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public FuncDclContext funcDcl() {
			return getRuleContext(FuncDclContext.class,0);
		}
		public ClassDclContext classDcl() {
			return getRuleContext(ClassDclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				funcDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				classDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDclContext extends ParserRuleContext {
		public VarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDcl; }
	 
		public VarDclContext() { }
		public void copyFrom(VarDclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EVarDclContext extends VarDclContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode TIPOS() { return getToken(LanguageParser.TIPOS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EVarDclContext(VarDclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IVarDclContext extends VarDclContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IVarDclContext(VarDclContext ctx) { copyFrom(ctx); }
	}

	public final VarDclContext varDcl() throws RecognitionException {
		VarDclContext _localctx = new VarDclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDcl);
		int _la;
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new EVarDclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(T__0);
				setState(37);
				match(ID);
				setState(38);
				match(TIPOS);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(39);
					match(T__1);
					setState(40);
					expr(0);
					}
				}

				setState(43);
				match(T__2);
				}
				break;
			case ID:
				_localctx = new IVarDclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(ID);
				setState(45);
				match(T__3);
				setState(46);
				expr(0);
				setState(47);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public FuncDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDcl; }
	}

	public final FuncDclContext funcDcl() throws RecognitionException {
		FuncDclContext _localctx = new FuncDclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__4);
			setState(52);
			match(ID);
			setState(53);
			match(T__5);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(54);
				params();
				}
			}

			setState(57);
			match(T__6);
			setState(58);
			match(T__7);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 78786882164066L) != 0)) {
				{
				{
				setState(59);
				dcl();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<ClassBodyContext> classBody() {
			return getRuleContexts(ClassBodyContext.class);
		}
		public ClassBodyContext classBody(int i) {
			return getRuleContext(ClassBodyContext.class,i);
		}
		public ClassDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDcl; }
	}

	public final ClassDclContext classDcl() throws RecognitionException {
		ClassDclContext _localctx = new ClassDclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__9);
			setState(68);
			match(ID);
			setState(69);
			match(T__7);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 70368744177698L) != 0)) {
				{
				{
				setState(70);
				classBody();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public FuncDclContext funcDcl() {
			return getRuleContext(FuncDclContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classBody);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				varDcl();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				funcDcl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(83);
				match(T__10);
				setState(84);
				match(ID);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends StmtContext {
		public ContinueStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends StmtContext {
		public BreakStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends StmtContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public BlockStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends StmtContext {
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ForStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__18:
			case T__19:
			case T__34:
			case T__36:
			case INT:
			case BOOL:
			case FLOAT:
			case STRING:
			case ID:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				expr(0);
				setState(91);
				match(T__2);
				}
				break;
			case T__7:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(T__7);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 78786882164066L) != 0)) {
					{
					{
					setState(94);
					dcl();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100);
				match(T__8);
				}
				break;
			case T__11:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(T__11);
				setState(103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(102);
					match(T__5);
					}
					break;
				}
				setState(105);
				expr(0);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(106);
					match(T__6);
					}
				}

				setState(109);
				stmt();
				setState(112);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(110);
					match(T__12);
					setState(111);
					stmt();
					}
					break;
				}
				}
				break;
			case T__13:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				match(T__13);
				setState(115);
				match(T__5);
				setState(116);
				expr(0);
				setState(117);
				match(T__6);
				setState(118);
				stmt();
				}
				break;
			case T__14:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				match(T__14);
				setState(122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(121);
					match(T__5);
					}
					break;
				}
				setState(124);
				forInit();
				setState(125);
				expr(0);
				setState(126);
				match(T__2);
				setState(127);
				expr(0);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(128);
					match(T__6);
					}
				}

				setState(131);
				stmt();
				}
				break;
			case T__15:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				match(T__15);
				setState(134);
				match(T__2);
				}
				break;
			case T__16:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				match(T__16);
				setState(136);
				match(T__2);
				}
				break;
			case T__17:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(137);
				match(T__17);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 78786881650752L) != 0)) {
					{
					setState(138);
					expr(0);
					}
				}

				setState(141);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forInit);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				expr(0);
				setState(146);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CalleeContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public CalleeContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NewContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ExprContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ArrayContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualityContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubAssignContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubAssignContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(151);
				match(T__18);
				setState(152);
				expr(18);
				}
				break;
			case T__19:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(T__19);
				setState(154);
				expr(17);
				}
				break;
			case BOOL:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(BOOL);
				}
				break;
			case FLOAT:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(FLOAT);
				}
				break;
			case STRING:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(STRING);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				match(INT);
				}
				break;
			case T__34:
				{
				_localctx = new ArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(T__34);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 78786881650752L) != 0)) {
					{
					setState(160);
					args();
					}
				}

				setState(163);
				match(T__35);
				}
				break;
			case T__36:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(T__36);
				setState(165);
				match(ID);
				setState(166);
				match(T__5);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 78786881650752L) != 0)) {
					{
					setState(167);
					args();
					}
				}

				setState(170);
				match(T__6);
				}
				break;
			case ID:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(ID);
				}
				break;
			case T__5:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(T__5);
				setState(173);
				expr(0);
				setState(174);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(205);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(179);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(180);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(182);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__23) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(183);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new AddSubAssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(185);
						((AddSubAssignContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((AddSubAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(186);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(188);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2013265920L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(189);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(191);
						((EqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((EqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(192);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new LogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(194);
						((LogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__33) ) {
							((LogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(195);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(197);
						match(T__1);
						setState(198);
						expr(10);
						}
						break;
					case 8:
						{
						_localctx = new CalleeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(201); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(200);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(203); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	 
		public CallContext() { }
		public void copyFrom(CallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends CallContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FuncCallContext(CallContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends CallContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayAccessContext(CallContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GetContext extends CallContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public GetContext(CallContext ctx) { copyFrom(ctx); }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_call);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(T__5);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 78786881650752L) != 0)) {
					{
					setState(211);
					args();
					}
				}

				setState(214);
				match(T__6);
				}
				break;
			case T__37:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(T__37);
				setState(216);
				match(ID);
				}
				break;
			case T__34:
				_localctx = new ArrayAccessContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				match(T__34);
				setState(218);
				expr(0);
				setState(219);
				match(T__35);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			expr(0);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(224);
				match(T__10);
				setState(225);
				expr(0);
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00010\u00e8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0005\u0000\u001a\b\u0000\n\u0000\f\u0000\u001d\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001#\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002*\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00022\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00038\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"=\b\u0003\n\u0003\f\u0003@\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004H\b\u0004\n\u0004\f\u0004"+
		"K\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005"+
		"Q\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006V\b\u0006\n\u0006"+
		"\f\u0006Y\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007`\b\u0007\n\u0007\f\u0007c\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007h\b\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007l\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007q\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007{\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0082\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u008c\b\u0007\u0001\u0007\u0003\u0007\u008f\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0095\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00a2\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a9"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b1\b\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00ca\b\t\u000b\t\f"+
		"\t\u00cb\u0005\t\u00ce\b\t\n\t\f\t\u00d1\t\t\u0001\n\u0001\n\u0003\n\u00d5"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00de"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e3\b\u000b\n\u000b"+
		"\f\u000b\u00e6\t\u000b\u0001\u000b\u0000\u0001\u0012\f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0006\u0001\u0000\u0015"+
		"\u0017\u0002\u0000\u0014\u0014\u0018\u0018\u0001\u0000\u0019\u001a\u0001"+
		"\u0000\u001b\u001e\u0001\u0000\u001f \u0001\u0000!\"\u010d\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u00041\u0001"+
		"\u0000\u0000\u0000\u00063\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000"+
		"\u0000\nP\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000\u000e\u008e"+
		"\u0001\u0000\u0000\u0000\u0010\u0094\u0001\u0000\u0000\u0000\u0012\u00b0"+
		"\u0001\u0000\u0000\u0000\u0014\u00dd\u0001\u0000\u0000\u0000\u0016\u00df"+
		"\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018"+
		"\u0001\u0000\u0000\u0000\u001a\u001d\u0001\u0000\u0000\u0000\u001b\u0019"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0001"+
		"\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001e#\u0003"+
		"\u0004\u0002\u0000\u001f#\u0003\u0006\u0003\u0000 #\u0003\b\u0004\u0000"+
		"!#\u0003\u000e\u0007\u0000\"\u001e\u0001\u0000\u0000\u0000\"\u001f\u0001"+
		"\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000"+
		"#\u0003\u0001\u0000\u0000\u0000$%\u0005\u0001\u0000\u0000%&\u0005.\u0000"+
		"\u0000&)\u0005-\u0000\u0000\'(\u0005\u0002\u0000\u0000(*\u0003\u0012\t"+
		"\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+2\u0005\u0003\u0000\u0000,-\u0005.\u0000\u0000-.\u0005\u0004"+
		"\u0000\u0000./\u0003\u0012\t\u0000/0\u0005\u0003\u0000\u000002\u0001\u0000"+
		"\u0000\u00001$\u0001\u0000\u0000\u00001,\u0001\u0000\u0000\u00002\u0005"+
		"\u0001\u0000\u0000\u000034\u0005\u0005\u0000\u000045\u0005.\u0000\u0000"+
		"57\u0005\u0006\u0000\u000068\u0003\f\u0006\u000076\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0005\u0007\u0000"+
		"\u0000:>\u0005\b\u0000\u0000;=\u0003\u0002\u0001\u0000<;\u0001\u0000\u0000"+
		"\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0005"+
		"\t\u0000\u0000B\u0007\u0001\u0000\u0000\u0000CD\u0005\n\u0000\u0000DE"+
		"\u0005.\u0000\u0000EI\u0005\b\u0000\u0000FH\u0003\n\u0005\u0000GF\u0001"+
		"\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000LM\u0005\t\u0000\u0000M\t\u0001\u0000\u0000\u0000NQ\u0003\u0004"+
		"\u0002\u0000OQ\u0003\u0006\u0003\u0000PN\u0001\u0000\u0000\u0000PO\u0001"+
		"\u0000\u0000\u0000Q\u000b\u0001\u0000\u0000\u0000RW\u0005.\u0000\u0000"+
		"ST\u0005\u000b\u0000\u0000TV\u0005.\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000X\r\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0003\u0012"+
		"\t\u0000[\\\u0005\u0003\u0000\u0000\\\u008f\u0001\u0000\u0000\u0000]a"+
		"\u0005\b\u0000\u0000^`\u0003\u0002\u0001\u0000_^\u0001\u0000\u0000\u0000"+
		"`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000d\u008f\u0005"+
		"\t\u0000\u0000eg\u0005\f\u0000\u0000fh\u0005\u0006\u0000\u0000gf\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"ik\u0003\u0012\t\u0000jl\u0005\u0007\u0000\u0000kj\u0001\u0000\u0000\u0000"+
		"kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mp\u0003\u000e\u0007"+
		"\u0000no\u0005\r\u0000\u0000oq\u0003\u000e\u0007\u0000pn\u0001\u0000\u0000"+
		"\u0000pq\u0001\u0000\u0000\u0000q\u008f\u0001\u0000\u0000\u0000rs\u0005"+
		"\u000e\u0000\u0000st\u0005\u0006\u0000\u0000tu\u0003\u0012\t\u0000uv\u0005"+
		"\u0007\u0000\u0000vw\u0003\u000e\u0007\u0000w\u008f\u0001\u0000\u0000"+
		"\u0000xz\u0005\u000f\u0000\u0000y{\u0005\u0006\u0000\u0000zy\u0001\u0000"+
		"\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0003"+
		"\u0010\b\u0000}~\u0003\u0012\t\u0000~\u007f\u0005\u0003\u0000\u0000\u007f"+
		"\u0081\u0003\u0012\t\u0000\u0080\u0082\u0005\u0007\u0000\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0003\u000e\u0007\u0000\u0084\u008f"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0010\u0000\u0000\u0086\u008f"+
		"\u0005\u0003\u0000\u0000\u0087\u0088\u0005\u0011\u0000\u0000\u0088\u008f"+
		"\u0005\u0003\u0000\u0000\u0089\u008b\u0005\u0012\u0000\u0000\u008a\u008c"+
		"\u0003\u0012\t\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008f\u0005"+
		"\u0003\u0000\u0000\u008eZ\u0001\u0000\u0000\u0000\u008e]\u0001\u0000\u0000"+
		"\u0000\u008ee\u0001\u0000\u0000\u0000\u008er\u0001\u0000\u0000\u0000\u008e"+
		"x\u0001\u0000\u0000\u0000\u008e\u0085\u0001\u0000\u0000\u0000\u008e\u0087"+
		"\u0001\u0000\u0000\u0000\u008e\u0089\u0001\u0000\u0000\u0000\u008f\u000f"+
		"\u0001\u0000\u0000\u0000\u0090\u0095\u0003\u0004\u0002\u0000\u0091\u0092"+
		"\u0003\u0012\t\u0000\u0092\u0093\u0005\u0003\u0000\u0000\u0093\u0095\u0001"+
		"\u0000\u0000\u0000\u0094\u0090\u0001\u0000\u0000\u0000\u0094\u0091\u0001"+
		"\u0000\u0000\u0000\u0095\u0011\u0001\u0000\u0000\u0000\u0096\u0097\u0006"+
		"\t\uffff\uffff\u0000\u0097\u0098\u0005\u0013\u0000\u0000\u0098\u00b1\u0003"+
		"\u0012\t\u0012\u0099\u009a\u0005\u0014\u0000\u0000\u009a\u00b1\u0003\u0012"+
		"\t\u0011\u009b\u00b1\u0005(\u0000\u0000\u009c\u00b1\u0005)\u0000\u0000"+
		"\u009d\u00b1\u0005*\u0000\u0000\u009e\u00b1\u0005\'\u0000\u0000\u009f"+
		"\u00a1\u0005#\u0000\u0000\u00a0\u00a2\u0003\u0016\u000b\u0000\u00a1\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a3\u00b1\u0005$\u0000\u0000\u00a4\u00a5\u0005"+
		"%\u0000\u0000\u00a5\u00a6\u0005.\u0000\u0000\u00a6\u00a8\u0005\u0006\u0000"+
		"\u0000\u00a7\u00a9\u0003\u0016\u000b\u0000\u00a8\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\u00b1\u0005\u0007\u0000\u0000\u00ab\u00b1\u0005.\u0000\u0000"+
		"\u00ac\u00ad\u0005\u0006\u0000\u0000\u00ad\u00ae\u0003\u0012\t\u0000\u00ae"+
		"\u00af\u0005\u0007\u0000\u0000\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0"+
		"\u0096\u0001\u0000\u0000\u0000\u00b0\u0099\u0001\u0000\u0000\u0000\u00b0"+
		"\u009b\u0001\u0000\u0000\u0000\u00b0\u009c\u0001\u0000\u0000\u0000\u00b0"+
		"\u009d\u0001\u0000\u0000\u0000\u00b0\u009e\u0001\u0000\u0000\u0000\u00b0"+
		"\u009f\u0001\u0000\u0000\u0000\u00b0\u00a4\u0001\u0000\u0000\u0000\u00b0"+
		"\u00ab\u0001\u0000\u0000\u0000\u00b0\u00ac\u0001\u0000\u0000\u0000\u00b1"+
		"\u00cf\u0001\u0000\u0000\u0000\u00b2\u00b3\n\u0010\u0000\u0000\u00b3\u00b4"+
		"\u0007\u0000\u0000\u0000\u00b4\u00ce\u0003\u0012\t\u0011\u00b5\u00b6\n"+
		"\u000f\u0000\u0000\u00b6\u00b7\u0007\u0001\u0000\u0000\u00b7\u00ce\u0003"+
		"\u0012\t\u0010\u00b8\u00b9\n\u000e\u0000\u0000\u00b9\u00ba\u0007\u0002"+
		"\u0000\u0000\u00ba\u00ce\u0003\u0012\t\u000f\u00bb\u00bc\n\r\u0000\u0000"+
		"\u00bc\u00bd\u0007\u0003\u0000\u0000\u00bd\u00ce\u0003\u0012\t\u000e\u00be"+
		"\u00bf\n\f\u0000\u0000\u00bf\u00c0\u0007\u0004\u0000\u0000\u00c0\u00ce"+
		"\u0003\u0012\t\r\u00c1\u00c2\n\u000b\u0000\u0000\u00c2\u00c3\u0007\u0005"+
		"\u0000\u0000\u00c3\u00ce\u0003\u0012\t\f\u00c4\u00c5\n\t\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0002\u0000\u0000\u00c6\u00ce\u0003\u0012\t\n\u00c7\u00c9"+
		"\n\n\u0000\u0000\u00c8\u00ca\u0003\u0014\n\u0000\u00c9\u00c8\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000"+
		"\u0000\u0000\u00cd\u00b2\u0001\u0000\u0000\u0000\u00cd\u00b5\u0001\u0000"+
		"\u0000\u0000\u00cd\u00b8\u0001\u0000\u0000\u0000\u00cd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00cd\u00be\u0001\u0000\u0000\u0000\u00cd\u00c1\u0001\u0000"+
		"\u0000\u0000\u00cd\u00c4\u0001\u0000\u0000\u0000\u00cd\u00c7\u0001\u0000"+
		"\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u0013\u0001\u0000"+
		"\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d4\u0005\u0006"+
		"\u0000\u0000\u00d3\u00d5\u0003\u0016\u000b\u0000\u00d4\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d6\u00de\u0005\u0007\u0000\u0000\u00d7\u00d8\u0005&\u0000"+
		"\u0000\u00d8\u00de\u0005.\u0000\u0000\u00d9\u00da\u0005#\u0000\u0000\u00da"+
		"\u00db\u0003\u0012\t\u0000\u00db\u00dc\u0005$\u0000\u0000\u00dc\u00de"+
		"\u0001\u0000\u0000\u0000\u00dd\u00d2\u0001\u0000\u0000\u0000\u00dd\u00d7"+
		"\u0001\u0000\u0000\u0000\u00dd\u00d9\u0001\u0000\u0000\u0000\u00de\u0015"+
		"\u0001\u0000\u0000\u0000\u00df\u00e4\u0003\u0012\t\u0000\u00e0\u00e1\u0005"+
		"\u000b\u0000\u0000\u00e1\u00e3\u0003\u0012\t\u0000\u00e2\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u0017\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u001b\u001b\")17>IPW"+
		"agkpz\u0081\u008b\u008e\u0094\u00a1\u00a8\u00b0\u00cb\u00cd\u00cf\u00d4"+
		"\u00dd\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}