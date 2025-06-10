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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, INT=52, BOOL=53, 
		FLOAT=54, STRING=55, RUNE=56, WS=57, TIPOS=58, ID=59, COMMENT=60, ML_COMMENT=61;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_funcDcl = 3, RULE_classDcl = 4, 
		RULE_classBody = 5, RULE_params = 6, RULE_stmt = 7, RULE_forInit = 8, 
		RULE_expr = 9, RULE_call = 10, RULE_matrixRows = 11, RULE_args = 12, RULE_caseBlock = 13, 
		RULE_defaultBlock = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "funcDcl", "classDcl", "classBody", "params", 
			"stmt", "forInit", "expr", "call", "matrixRows", "args", "caseBlock", 
			"defaultBlock"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'[]'", "'[][]'", "'='", "';'", "':='", "'func'", "'('", 
			"')'", "'{'", "'}'", "'class'", "','", "'if'", "'else'", "'for'", "'range'", 
			"'break'", "'continue'", "'return'", "'fmt.Println'", "'switch'", "'!'", 
			"'-'", "'*'", "'/'", "'%'", "'+'", "'+='", "'-='", "'['", "']'", "'>'", 
			"'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'++'", "'--'", 
			"'slices.Index'", "'len'", "'append'", "'strings.Join'", "'new'", "'.'", 
			"'case'", "':'", "'default'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT", "BOOL", "FLOAT", "STRING", "RUNE", "WS", 
			"TIPOS", "ID", "COMMENT", "ML_COMMENT"
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425631049102L) != 0)) {
				{
				{
				setState(30);
				dcl();
				}
				}
				setState(35);
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
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				funcDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				classDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
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
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new EVarDclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(T__0);
				setState(43);
				match(ID);
				setState(49);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(44);
					match(T__1);
					setState(45);
					match(TIPOS);
					}
					break;
				case T__2:
					{
					setState(46);
					match(T__2);
					setState(47);
					match(TIPOS);
					}
					break;
				case TIPOS:
					{
					setState(48);
					match(TIPOS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(51);
					match(T__3);
					setState(52);
					expr(0);
					}
				}

				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(55);
					match(T__4);
					}
				}

				}
				break;
			case ID:
				_localctx = new IVarDclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(ID);
				setState(59);
				match(T__5);
				setState(60);
				expr(0);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(61);
					match(T__4);
					}
				}

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
		public TerminalNode TIPOS() { return getToken(LanguageParser.TIPOS, 0); }
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
			setState(66);
			match(T__6);
			setState(67);
			match(ID);
			setState(68);
			match(T__7);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(69);
				params();
				}
			}

			setState(72);
			match(T__8);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIPOS) {
				{
				setState(73);
				match(TIPOS);
				}
			}

			setState(76);
			match(T__9);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425631049102L) != 0)) {
				{
				{
				setState(77);
				dcl();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(T__10);
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
			setState(85);
			match(T__11);
			setState(86);
			match(ID);
			setState(87);
			match(T__9);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460752303423618L) != 0)) {
				{
				{
				setState(88);
				classBody();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__10);
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
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				varDcl();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
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
		public List<TerminalNode> TIPOS() { return getTokens(LanguageParser.TIPOS); }
		public TerminalNode TIPOS(int i) {
			return getToken(LanguageParser.TIPOS, i);
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
			setState(100);
			match(ID);
			setState(101);
			match(TIPOS);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(102);
				match(T__12);
				setState(103);
				match(ID);
				setState(104);
				match(TIPOS);
				}
				}
				setState(109);
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
	public static class SwitchStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<CaseBlockContext> caseBlock() {
			return getRuleContexts(CaseBlockContext.class);
		}
		public CaseBlockContext caseBlock(int i) {
			return getRuleContext(CaseBlockContext.class,i);
		}
		public DefaultBlockContext defaultBlock() {
			return getRuleContext(DefaultBlockContext.class,0);
		}
		public SwitchStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
	public static class PrintStmtContext extends StmtContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
	public static class ForRangeStmtContext extends StmtContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ForRangeStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				expr(0);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(111);
					match(T__4);
					}
				}

				}
				break;
			case 2:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(T__9);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425631049102L) != 0)) {
					{
					{
					setState(115);
					dcl();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				match(T__10);
				}
				break;
			case 3:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(T__13);
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(123);
					match(T__7);
					}
					break;
				}
				setState(126);
				expr(0);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(127);
					match(T__8);
					}
				}

				setState(130);
				stmt();
				setState(133);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(131);
					match(T__14);
					setState(132);
					stmt();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ForRangeStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				match(T__15);
				setState(136);
				match(ID);
				setState(137);
				match(T__12);
				setState(138);
				match(ID);
				setState(139);
				match(T__5);
				setState(140);
				match(T__16);
				setState(141);
				expr(0);
				setState(142);
				match(T__9);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425631044876L) != 0)) {
					{
					{
					setState(143);
					stmt();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(T__10);
				}
				break;
			case 5:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
				match(T__15);
				setState(153);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(152);
					match(T__7);
					}
					break;
				}
				setState(155);
				forInit();
				setState(156);
				expr(0);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(157);
					match(T__4);
					}
				}

				setState(160);
				expr(0);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(161);
					match(T__8);
					}
				}

				setState(164);
				stmt();
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(166);
				match(T__15);
				setState(167);
				expr(0);
				setState(168);
				match(T__9);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425631044876L) != 0)) {
					{
					{
					setState(169);
					stmt();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(T__10);
				}
				break;
			case 7:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				match(T__17);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(178);
					match(T__4);
					}
				}

				}
				break;
			case 8:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(181);
				match(T__18);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(182);
					match(T__4);
					}
				}

				}
				break;
			case 9:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(185);
				match(T__19);
				setState(187);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(186);
					expr(0);
					}
					break;
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(189);
					match(T__4);
					}
				}

				}
				break;
			case 10:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(192);
				match(T__20);
				setState(193);
				match(T__7);
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425622836492L) != 0)) {
					{
					setState(194);
					args();
					}
				}

				setState(197);
				match(T__8);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(198);
					match(T__4);
					}
				}

				}
				break;
			case 11:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(201);
				match(T__21);
				setState(202);
				expr(0);
				setState(203);
				match(T__9);
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(204);
					caseBlock();
					}
					}
					setState(207); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__48 );
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__50) {
					{
					setState(209);
					defaultBlock();
					}
				}

				setState(212);
				match(T__10);
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
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				expr(0);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(218);
					match(T__4);
					}
				}

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
	public static class SliceLiteralContext extends ExprContext {
		public TerminalNode TIPOS() { return getToken(LanguageParser.TIPOS, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SliceLiteralContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class StringsJoinContext extends ExprContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public StringsJoinContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppendExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AppendExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class SliceAppendContext extends ExprContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SliceAppendContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatrixLiteralContext extends ExprContext {
		public TerminalNode TIPOS() { return getToken(LanguageParser.TIPOS, 0); }
		public MatrixRowsContext matrixRows() {
			return getRuleContext(MatrixRowsContext.class,0);
		}
		public MatrixLiteralContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class MatrixAccessContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MatrixAccessContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayAccessContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class SliceIndexContext extends ExprContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SliceIndexContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class IncDecContext extends ExprContext {
		public Token op;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IncDecContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class SliceLenContext extends ExprContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SliceLenContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class NegateContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(ExprContext ctx) { copyFrom(ctx); }
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
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(224);
				match(T__22);
				setState(225);
				expr(28);
				}
				break;
			case 2:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(T__23);
				setState(227);
				expr(26);
				}
				break;
			case 3:
				{
				_localctx = new IncDecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(ID);
				setState(229);
				((IncDecContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__40 || _la==T__41) ) {
					((IncDecContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new MatrixLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(T__2);
				setState(231);
				match(TIPOS);
				setState(232);
				match(T__9);
				setState(233);
				matrixRows();
				setState(234);
				match(T__10);
				}
				break;
			case 5:
				{
				_localctx = new SliceLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(T__1);
				setState(237);
				match(TIPOS);
				setState(238);
				match(T__9);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425622836492L) != 0)) {
					{
					setState(239);
					args();
					}
				}

				setState(242);
				match(T__10);
				}
				break;
			case 6:
				{
				_localctx = new ArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				match(T__9);
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425622836492L) != 0)) {
					{
					setState(244);
					args();
					}
				}

				setState(247);
				match(T__10);
				}
				break;
			case 7:
				{
				_localctx = new SliceIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248);
				match(T__42);
				setState(249);
				match(T__7);
				setState(250);
				args();
				setState(251);
				match(T__8);
				}
				break;
			case 8:
				{
				_localctx = new SliceLenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				match(T__43);
				setState(254);
				match(T__7);
				setState(255);
				args();
				setState(256);
				match(T__8);
				}
				break;
			case 9:
				{
				_localctx = new SliceAppendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(T__44);
				setState(259);
				match(T__7);
				setState(260);
				args();
				setState(261);
				match(T__8);
				}
				break;
			case 10:
				{
				_localctx = new AppendExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				match(T__44);
				setState(264);
				match(T__7);
				setState(265);
				match(ID);
				setState(266);
				match(T__12);
				setState(267);
				expr(0);
				setState(268);
				match(T__8);
				}
				break;
			case 11:
				{
				_localctx = new StringsJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(T__45);
				setState(271);
				match(T__7);
				setState(272);
				args();
				setState(273);
				match(T__8);
				}
				break;
			case 12:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(T__46);
				setState(276);
				match(ID);
				setState(277);
				match(T__7);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425622836492L) != 0)) {
					{
					setState(278);
					args();
					}
				}

				setState(281);
				match(T__8);
				}
				break;
			case 13:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				match(BOOL);
				}
				break;
			case 14:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				match(FLOAT);
				}
				break;
			case 15:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
				match(STRING);
				}
				break;
			case 16:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(INT);
				}
				break;
			case 17:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286);
				match(ID);
				}
				break;
			case 18:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				match(T__7);
				setState(288);
				expr(0);
				setState(289);
				match(T__8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(335);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(333);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(293);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(294);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0)) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(295);
						expr(26);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(296);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(297);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__27) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(298);
						expr(25);
						}
						break;
					case 3:
						{
						_localctx = new AddSubAssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(299);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(300);
						((AddSubAssignContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((AddSubAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(301);
						expr(24);
						}
						break;
					case 4:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(302);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(303);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(304);
						expr(21);
						}
						break;
					case 5:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(305);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(306);
						((EqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
							((EqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(307);
						expr(20);
						}
						break;
					case 6:
						{
						_localctx = new LogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(308);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(309);
						((LogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__39) ) {
							((LogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(310);
						expr(19);
						}
						break;
					case 7:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(311);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(312);
						match(T__3);
						setState(313);
						expr(18);
						}
						break;
					case 8:
						{
						_localctx = new CalleeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(314);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(316); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(315);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(318); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 9:
						{
						_localctx = new ArrayAccessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(320);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(321);
						match(T__30);
						setState(322);
						expr(0);
						setState(323);
						match(T__31);
						}
						break;
					case 10:
						{
						_localctx = new MatrixAccessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(325);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(326);
						match(T__30);
						setState(327);
						expr(0);
						setState(328);
						match(T__31);
						setState(329);
						match(T__30);
						setState(330);
						expr(0);
						setState(331);
						match(T__31);
						}
						break;
					}
					} 
				}
				setState(337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
	public static class GetContext extends CallContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public GetContext(CallContext ctx) { copyFrom(ctx); }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_call);
		int _la;
		try {
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				match(T__7);
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425622836492L) != 0)) {
					{
					setState(339);
					args();
					}
				}

				setState(342);
				match(T__8);
				}
				break;
			case T__47:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				match(T__47);
				setState(344);
				match(ID);
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
	public static class MatrixRowsContext extends ParserRuleContext {
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public MatrixRowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixRows; }
	}

	public final MatrixRowsContext matrixRows() throws RecognitionException {
		MatrixRowsContext _localctx = new MatrixRowsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_matrixRows);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(347);
				match(T__9);
				setState(348);
				args();
				setState(349);
				match(T__10);
				setState(350);
				match(T__12);
				}
				}
				setState(356);
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
		enterRule(_localctx, 24, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			expr(0);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(358);
				match(T__12);
				setState(359);
				expr(0);
				}
				}
				setState(364);
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
	public static class CaseBlockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_caseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(T__48);
			setState(366);
			expr(0);
			setState(367);
			match(T__49);
			setState(369); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(368);
				stmt();
				}
				}
				setState(371); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425631044876L) != 0) );
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
	public static class DefaultBlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public DefaultBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultBlock; }
	}

	public final DefaultBlockContext defaultBlock() throws RecognitionException {
		DefaultBlockContext _localctx = new DefaultBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_defaultBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(T__50);
			setState(374);
			match(T__49);
			setState(376); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(375);
				stmt();
				}
				}
				setState(378); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 644287425631044876L) != 0) );
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
			return precpred(_ctx, 25);
		case 1:
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 20);
		case 4:
			return precpred(_ctx, 19);
		case 5:
			return precpred(_ctx, 18);
		case 6:
			return precpred(_ctx, 17);
		case 7:
			return precpred(_ctx, 27);
		case 8:
			return precpred(_ctx, 22);
		case 9:
			return precpred(_ctx, 21);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u017d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001)\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0002\u0003\u0002"+
		"9\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0003\u0002A\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003G\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003K\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003O\b\u0003\n\u0003\f\u0003R\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004Z\b\u0004\n\u0004\f\u0004]\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0003\u0005c\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006j\b\u0006\n\u0006\f\u0006"+
		"m\t\u0006\u0001\u0007\u0001\u0007\u0003\u0007q\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007u\b\u0007\n\u0007\f\u0007x\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007}\b\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u0081\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0086"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0091\b\u0007\n"+
		"\u0007\f\u0007\u0094\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u009a\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u009f\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a3\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u00ab\b\u0007\n\u0007\f\u0007\u00ae\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b4\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00b8\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00bc"+
		"\b\u0007\u0001\u0007\u0003\u0007\u00bf\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00c4\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00c8\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007"+
		"\u00ce\b\u0007\u000b\u0007\f\u0007\u00cf\u0001\u0007\u0003\u0007\u00d3"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00d7\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00dc\b\b\u0003\b\u00de\b\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00f1\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00f6\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u0118\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u0124\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0004\t\u013d\b\t\u000b\t\f\t\u013e\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u014e\b\t\n\t\f\t\u0151\t\t\u0001\n\u0001\n\u0003\n\u0155\b"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u015a\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0161\b\u000b\n\u000b\f\u000b"+
		"\u0164\t\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0169\b\f\n\f\f\f\u016c"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u0172\b\r\u000b\r\f\r\u0173"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u0179\b\u000e\u000b\u000e"+
		"\f\u000e\u017a\u0001\u000e\u0000\u0001\u0012\u000f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0007\u0001"+
		"\u0000)*\u0001\u0000\u0019\u001b\u0002\u0000\u0018\u0018\u001c\u001c\u0001"+
		"\u0000\u001d\u001e\u0001\u0000!$\u0001\u0000%&\u0001\u0000\'(\u01c0\u0000"+
		"!\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004@\u0001"+
		"\u0000\u0000\u0000\u0006B\u0001\u0000\u0000\u0000\bU\u0001\u0000\u0000"+
		"\u0000\nb\u0001\u0000\u0000\u0000\fd\u0001\u0000\u0000\u0000\u000e\u00d6"+
		"\u0001\u0000\u0000\u0000\u0010\u00dd\u0001\u0000\u0000\u0000\u0012\u0123"+
		"\u0001\u0000\u0000\u0000\u0014\u0159\u0001\u0000\u0000\u0000\u0016\u0162"+
		"\u0001\u0000\u0000\u0000\u0018\u0165\u0001\u0000\u0000\u0000\u001a\u016d"+
		"\u0001\u0000\u0000\u0000\u001c\u0175\u0001\u0000\u0000\u0000\u001e \u0003"+
		"\u0002\u0001\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000"+
		"\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0001"+
		"\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$)\u0003\u0004\u0002"+
		"\u0000%)\u0003\u0006\u0003\u0000&)\u0003\b\u0004\u0000\')\u0003\u000e"+
		"\u0007\u0000($\u0001\u0000\u0000\u0000(%\u0001\u0000\u0000\u0000(&\u0001"+
		"\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000)\u0003\u0001\u0000\u0000"+
		"\u0000*+\u0005\u0001\u0000\u0000+1\u0005;\u0000\u0000,-\u0005\u0002\u0000"+
		"\u0000-2\u0005:\u0000\u0000./\u0005\u0003\u0000\u0000/2\u0005:\u0000\u0000"+
		"02\u0005:\u0000\u00001,\u0001\u0000\u0000\u00001.\u0001\u0000\u0000\u0000"+
		"10\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000034\u0005\u0004\u0000"+
		"\u000046\u0003\u0012\t\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000068\u0001\u0000\u0000\u000079\u0005\u0005\u0000\u000087\u0001\u0000"+
		"\u0000\u000089\u0001\u0000\u0000\u00009A\u0001\u0000\u0000\u0000:;\u0005"+
		";\u0000\u0000;<\u0005\u0006\u0000\u0000<>\u0003\u0012\t\u0000=?\u0005"+
		"\u0005\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000"+
		"?A\u0001\u0000\u0000\u0000@*\u0001\u0000\u0000\u0000@:\u0001\u0000\u0000"+
		"\u0000A\u0005\u0001\u0000\u0000\u0000BC\u0005\u0007\u0000\u0000CD\u0005"+
		";\u0000\u0000DF\u0005\b\u0000\u0000EG\u0003\f\u0006\u0000FE\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0005"+
		"\t\u0000\u0000IK\u0005:\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LP\u0005\n\u0000\u0000MO\u0003"+
		"\u0002\u0001\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000"+
		"\u0000RP\u0001\u0000\u0000\u0000ST\u0005\u000b\u0000\u0000T\u0007\u0001"+
		"\u0000\u0000\u0000UV\u0005\f\u0000\u0000VW\u0005;\u0000\u0000W[\u0005"+
		"\n\u0000\u0000XZ\u0003\n\u0005\u0000YX\u0001\u0000\u0000\u0000Z]\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005\u000b\u0000"+
		"\u0000_\t\u0001\u0000\u0000\u0000`c\u0003\u0004\u0002\u0000ac\u0003\u0006"+
		"\u0003\u0000b`\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000c\u000b"+
		"\u0001\u0000\u0000\u0000de\u0005;\u0000\u0000ek\u0005:\u0000\u0000fg\u0005"+
		"\r\u0000\u0000gh\u0005;\u0000\u0000hj\u0005:\u0000\u0000if\u0001\u0000"+
		"\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000l\r\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"np\u0003\u0012\t\u0000oq\u0005\u0005\u0000\u0000po\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000q\u00d7\u0001\u0000\u0000\u0000rv\u0005\n\u0000"+
		"\u0000su\u0003\u0002\u0001\u0000ts\u0001\u0000\u0000\u0000ux\u0001\u0000"+
		"\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001"+
		"\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000y\u00d7\u0005\u000b\u0000"+
		"\u0000z|\u0005\u000e\u0000\u0000{}\u0005\b\u0000\u0000|{\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0003"+
		"\u0012\t\u0000\u007f\u0081\u0005\t\u0000\u0000\u0080\u007f\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000"+
		"\u0000\u0000\u0082\u0085\u0003\u000e\u0007\u0000\u0083\u0084\u0005\u000f"+
		"\u0000\u0000\u0084\u0086\u0003\u000e\u0007\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u00d7\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005\u0010\u0000\u0000\u0088\u0089\u0005;\u0000"+
		"\u0000\u0089\u008a\u0005\r\u0000\u0000\u008a\u008b\u0005;\u0000\u0000"+
		"\u008b\u008c\u0005\u0006\u0000\u0000\u008c\u008d\u0005\u0011\u0000\u0000"+
		"\u008d\u008e\u0003\u0012\t\u0000\u008e\u0092\u0005\n\u0000\u0000\u008f"+
		"\u0091\u0003\u000e\u0007\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093\u0095\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u000b\u0000\u0000\u0096"+
		"\u00d7\u0001\u0000\u0000\u0000\u0097\u0099\u0005\u0010\u0000\u0000\u0098"+
		"\u009a\u0005\b\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0003\u0010\b\u0000\u009c\u009e\u0003\u0012\t\u0000\u009d\u009f\u0005"+
		"\u0005\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a2\u0003"+
		"\u0012\t\u0000\u00a1\u00a3\u0005\t\u0000\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0003\u000e\u0007\u0000\u00a5\u00d7\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0005\u0010\u0000\u0000\u00a7\u00a8\u0003\u0012"+
		"\t\u0000\u00a8\u00ac\u0005\n\u0000\u0000\u00a9\u00ab\u0003\u000e\u0007"+
		"\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005\u000b\u0000\u0000\u00b0\u00d7\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b3\u0005\u0012\u0000\u0000\u00b2\u00b4\u0005\u0005\u0000"+
		"\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b4\u00d7\u0001\u0000\u0000\u0000\u00b5\u00b7\u0005\u0013\u0000"+
		"\u0000\u00b6\u00b8\u0005\u0005\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00d7\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bb\u0005\u0014\u0000\u0000\u00ba\u00bc\u0003\u0012\t\u0000"+
		"\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00bf\u0005\u0005\u0000\u0000"+
		"\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bf\u00d7\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0015\u0000\u0000"+
		"\u00c1\u00c3\u0005\b\u0000\u0000\u00c2\u00c4\u0003\u0018\f\u0000\u00c3"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c7\u0005\t\u0000\u0000\u00c6\u00c8"+
		"\u0005\u0005\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8\u00d7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0005\u0016\u0000\u0000\u00ca\u00cb\u0003\u0012\t\u0000\u00cb\u00cd\u0005"+
		"\n\u0000\u0000\u00cc\u00ce\u0003\u001a\r\u0000\u00cd\u00cc\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d3\u0003\u001c\u000e\u0000\u00d2\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0005\u000b\u0000\u0000\u00d5\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d6n\u0001\u0000\u0000\u0000\u00d6r\u0001\u0000\u0000\u0000"+
		"\u00d6z\u0001\u0000\u0000\u0000\u00d6\u0087\u0001\u0000\u0000\u0000\u00d6"+
		"\u0097\u0001\u0000\u0000\u0000\u00d6\u00a6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00b1\u0001\u0000\u0000\u0000\u00d6\u00b5\u0001\u0000\u0000\u0000\u00d6"+
		"\u00b9\u0001\u0000\u0000\u0000\u00d6\u00c0\u0001\u0000\u0000\u0000\u00d6"+
		"\u00c9\u0001\u0000\u0000\u0000\u00d7\u000f\u0001\u0000\u0000\u0000\u00d8"+
		"\u00de\u0003\u0004\u0002\u0000\u00d9\u00db\u0003\u0012\t\u0000\u00da\u00dc"+
		"\u0005\u0005\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00db\u00dc"+
		"\u0001\u0000\u0000\u0000\u00dc\u00de\u0001\u0000\u0000\u0000\u00dd\u00d8"+
		"\u0001\u0000\u0000\u0000\u00dd\u00d9\u0001\u0000\u0000\u0000\u00de\u0011"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0006\t\uffff\uffff\u0000\u00e0\u00e1"+
		"\u0005\u0017\u0000\u0000\u00e1\u0124\u0003\u0012\t\u001c\u00e2\u00e3\u0005"+
		"\u0018\u0000\u0000\u00e3\u0124\u0003\u0012\t\u001a\u00e4\u00e5\u0005;"+
		"\u0000\u0000\u00e5\u0124\u0007\u0000\u0000\u0000\u00e6\u00e7\u0005\u0003"+
		"\u0000\u0000\u00e7\u00e8\u0005:\u0000\u0000\u00e8\u00e9\u0005\n\u0000"+
		"\u0000\u00e9\u00ea\u0003\u0016\u000b\u0000\u00ea\u00eb\u0005\u000b\u0000"+
		"\u0000\u00eb\u0124\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0002\u0000"+
		"\u0000\u00ed\u00ee\u0005:\u0000\u0000\u00ee\u00f0\u0005\n\u0000\u0000"+
		"\u00ef\u00f1\u0003\u0018\f\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2"+
		"\u0124\u0005\u000b\u0000\u0000\u00f3\u00f5\u0005\n\u0000\u0000\u00f4\u00f6"+
		"\u0003\u0018\f\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u0124\u0005"+
		"\u000b\u0000\u0000\u00f8\u00f9\u0005+\u0000\u0000\u00f9\u00fa\u0005\b"+
		"\u0000\u0000\u00fa\u00fb\u0003\u0018\f\u0000\u00fb\u00fc\u0005\t\u0000"+
		"\u0000\u00fc\u0124\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005,\u0000\u0000"+
		"\u00fe\u00ff\u0005\b\u0000\u0000\u00ff\u0100\u0003\u0018\f\u0000\u0100"+
		"\u0101\u0005\t\u0000\u0000\u0101\u0124\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0005-\u0000\u0000\u0103\u0104\u0005\b\u0000\u0000\u0104\u0105\u0003"+
		"\u0018\f\u0000\u0105\u0106\u0005\t\u0000\u0000\u0106\u0124\u0001\u0000"+
		"\u0000\u0000\u0107\u0108\u0005-\u0000\u0000\u0108\u0109\u0005\b\u0000"+
		"\u0000\u0109\u010a\u0005;\u0000\u0000\u010a\u010b\u0005\r\u0000\u0000"+
		"\u010b\u010c\u0003\u0012\t\u0000\u010c\u010d\u0005\t\u0000\u0000\u010d"+
		"\u0124\u0001\u0000\u0000\u0000\u010e\u010f\u0005.\u0000\u0000\u010f\u0110"+
		"\u0005\b\u0000\u0000\u0110\u0111\u0003\u0018\f\u0000\u0111\u0112\u0005"+
		"\t\u0000\u0000\u0112\u0124\u0001\u0000\u0000\u0000\u0113\u0114\u0005/"+
		"\u0000\u0000\u0114\u0115\u0005;\u0000\u0000\u0115\u0117\u0005\b\u0000"+
		"\u0000\u0116\u0118\u0003\u0018\f\u0000\u0117\u0116\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000"+
		"\u0119\u0124\u0005\t\u0000\u0000\u011a\u0124\u00055\u0000\u0000\u011b"+
		"\u0124\u00056\u0000\u0000\u011c\u0124\u00057\u0000\u0000\u011d\u0124\u0005"+
		"4\u0000\u0000\u011e\u0124\u0005;\u0000\u0000\u011f\u0120\u0005\b\u0000"+
		"\u0000\u0120\u0121\u0003\u0012\t\u0000\u0121\u0122\u0005\t\u0000\u0000"+
		"\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u00df\u0001\u0000\u0000\u0000"+
		"\u0123\u00e2\u0001\u0000\u0000\u0000\u0123\u00e4\u0001\u0000\u0000\u0000"+
		"\u0123\u00e6\u0001\u0000\u0000\u0000\u0123\u00ec\u0001\u0000\u0000\u0000"+
		"\u0123\u00f3\u0001\u0000\u0000\u0000\u0123\u00f8\u0001\u0000\u0000\u0000"+
		"\u0123\u00fd\u0001\u0000\u0000\u0000\u0123\u0102\u0001\u0000\u0000\u0000"+
		"\u0123\u0107\u0001\u0000\u0000\u0000\u0123\u010e\u0001\u0000\u0000\u0000"+
		"\u0123\u0113\u0001\u0000\u0000\u0000\u0123\u011a\u0001\u0000\u0000\u0000"+
		"\u0123\u011b\u0001\u0000\u0000\u0000\u0123\u011c\u0001\u0000\u0000\u0000"+
		"\u0123\u011d\u0001\u0000\u0000\u0000\u0123\u011e\u0001\u0000\u0000\u0000"+
		"\u0123\u011f\u0001\u0000\u0000\u0000\u0124\u014f\u0001\u0000\u0000\u0000"+
		"\u0125\u0126\n\u0019\u0000\u0000\u0126\u0127\u0007\u0001\u0000\u0000\u0127"+
		"\u014e\u0003\u0012\t\u001a\u0128\u0129\n\u0018\u0000\u0000\u0129\u012a"+
		"\u0007\u0002\u0000\u0000\u012a\u014e\u0003\u0012\t\u0019\u012b\u012c\n"+
		"\u0017\u0000\u0000\u012c\u012d\u0007\u0003\u0000\u0000\u012d\u014e\u0003"+
		"\u0012\t\u0018\u012e\u012f\n\u0014\u0000\u0000\u012f\u0130\u0007\u0004"+
		"\u0000\u0000\u0130\u014e\u0003\u0012\t\u0015\u0131\u0132\n\u0013\u0000"+
		"\u0000\u0132\u0133\u0007\u0005\u0000\u0000\u0133\u014e\u0003\u0012\t\u0014"+
		"\u0134\u0135\n\u0012\u0000\u0000\u0135\u0136\u0007\u0006\u0000\u0000\u0136"+
		"\u014e\u0003\u0012\t\u0013\u0137\u0138\n\u0011\u0000\u0000\u0138\u0139"+
		"\u0005\u0004\u0000\u0000\u0139\u014e\u0003\u0012\t\u0012\u013a\u013c\n"+
		"\u001b\u0000\u0000\u013b\u013d\u0003\u0014\n\u0000\u013c\u013b\u0001\u0000"+
		"\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u014e\u0001\u0000"+
		"\u0000\u0000\u0140\u0141\n\u0016\u0000\u0000\u0141\u0142\u0005\u001f\u0000"+
		"\u0000\u0142\u0143\u0003\u0012\t\u0000\u0143\u0144\u0005 \u0000\u0000"+
		"\u0144\u014e\u0001\u0000\u0000\u0000\u0145\u0146\n\u0015\u0000\u0000\u0146"+
		"\u0147\u0005\u001f\u0000\u0000\u0147\u0148\u0003\u0012\t\u0000\u0148\u0149"+
		"\u0005 \u0000\u0000\u0149\u014a\u0005\u001f\u0000\u0000\u014a\u014b\u0003"+
		"\u0012\t\u0000\u014b\u014c\u0005 \u0000\u0000\u014c\u014e\u0001\u0000"+
		"\u0000\u0000\u014d\u0125\u0001\u0000\u0000\u0000\u014d\u0128\u0001\u0000"+
		"\u0000\u0000\u014d\u012b\u0001\u0000\u0000\u0000\u014d\u012e\u0001\u0000"+
		"\u0000\u0000\u014d\u0131\u0001\u0000\u0000\u0000\u014d\u0134\u0001\u0000"+
		"\u0000\u0000\u014d\u0137\u0001\u0000\u0000\u0000\u014d\u013a\u0001\u0000"+
		"\u0000\u0000\u014d\u0140\u0001\u0000\u0000\u0000\u014d\u0145\u0001\u0000"+
		"\u0000\u0000\u014e\u0151\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000"+
		"\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0013\u0001\u0000"+
		"\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0152\u0154\u0005\b\u0000"+
		"\u0000\u0153\u0155\u0003\u0018\f\u0000\u0154\u0153\u0001\u0000\u0000\u0000"+
		"\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000"+
		"\u0156\u015a\u0005\t\u0000\u0000\u0157\u0158\u00050\u0000\u0000\u0158"+
		"\u015a\u0005;\u0000\u0000\u0159\u0152\u0001\u0000\u0000\u0000\u0159\u0157"+
		"\u0001\u0000\u0000\u0000\u015a\u0015\u0001\u0000\u0000\u0000\u015b\u015c"+
		"\u0005\n\u0000\u0000\u015c\u015d\u0003\u0018\f\u0000\u015d\u015e\u0005"+
		"\u000b\u0000\u0000\u015e\u015f\u0005\r\u0000\u0000\u015f\u0161\u0001\u0000"+
		"\u0000\u0000\u0160\u015b\u0001\u0000\u0000\u0000\u0161\u0164\u0001\u0000"+
		"\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000"+
		"\u0000\u0000\u0163\u0017\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000"+
		"\u0000\u0000\u0165\u016a\u0003\u0012\t\u0000\u0166\u0167\u0005\r\u0000"+
		"\u0000\u0167\u0169\u0003\u0012\t\u0000\u0168\u0166\u0001\u0000\u0000\u0000"+
		"\u0169\u016c\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000\u0000\u0000"+
		"\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u0019\u0001\u0000\u0000\u0000"+
		"\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u016e\u00051\u0000\u0000\u016e"+
		"\u016f\u0003\u0012\t\u0000\u016f\u0171\u00052\u0000\u0000\u0170\u0172"+
		"\u0003\u000e\u0007\u0000\u0171\u0170\u0001\u0000\u0000\u0000\u0172\u0173"+
		"\u0001\u0000\u0000\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0173\u0174"+
		"\u0001\u0000\u0000\u0000\u0174\u001b\u0001\u0000\u0000\u0000\u0175\u0176"+
		"\u00053\u0000\u0000\u0176\u0178\u00052\u0000\u0000\u0177\u0179\u0003\u000e"+
		"\u0007\u0000\u0178\u0177\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000"+
		"\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000"+
		"\u0000\u0000\u017b\u001d\u0001\u0000\u0000\u0000/!(158>@FJP[bkpv|\u0080"+
		"\u0085\u0092\u0099\u009e\u00a2\u00ac\u00b3\u00b7\u00bb\u00be\u00c3\u00c7"+
		"\u00cf\u00d2\u00d6\u00db\u00dd\u00f0\u00f5\u0117\u0123\u013e\u014d\u014f"+
		"\u0154\u0159\u0162\u016a\u0173\u017a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}