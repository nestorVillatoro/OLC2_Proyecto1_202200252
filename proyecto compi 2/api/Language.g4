grammar Language;

program: dcl*;

dcl: varDcl | funcDcl | classDcl | stmt;

varDcl: 
      'var' ID ('[]' TIPOS | '[][]' TIPOS | TIPOS) ('=' expr)? ';'?   # EVarDcl
      | ID ':=' expr ';'?                                             # IVarDcl;


funcDcl: 'func' ID '('params?')' TIPOS? '{'dcl*'}';

classDcl: 'class' ID '{' classBody* '}';

classBody: varDcl | funcDcl;

params: ID TIPOS (',' ID TIPOS)*;

stmt:
	expr ';'? # ExprStmt
	| '{' dcl* '}'								# BlockStmt
	| 'if' '('? expr ')'? stmt ('else' stmt)?		# IfStmt	
    | 'for' ID ',' ID ':=' 'range' expr '{' stmt* '}'  # ForRangeStmt
	| 'for' '('? forInit expr ';'? expr ')'? stmt	# ForStmt 
    | 'for' expr '{' stmt* '}'  		            # WhileStmt 
	| 'break' ';'?								# BreakStmt
	| 'continue' ';'?							# ContinueStmt
	| 'return' expr? ';'?						# ReturnStmt
	| 'fmt.Println' '(' args? ')' ';'?           # PrintStmt
	| 'switch' expr '{' caseBlock+ defaultBlock? '}'  # SwitchStmt;

forInit: varDcl | expr ';'?;

expr:
    '!' expr                                  # NotExpr
    | expr call+                              # Callee
    | '-' expr                                # Negate
    | expr op = ('*' | '/' | '%') expr        # MulDiv
    | expr op = ('+' | '-') expr              # AddSub
    | expr op = ('+=' | '-=') expr            # AddSubAssign
    | expr '[' expr ']'                       # ArrayAccess
    | expr '[' expr ']' '[' expr ']'          # MatrixAccess
    | expr op = ('>' | '<' | '>=' | '<=') expr # Relational
    | expr op = ('==' | '!=') expr            # Equality
    | expr op = ( '&&' | '||') expr           # Logical
    | expr '=' expr                           # Assign
    | ID op = ('++' | '--')                   # IncDec
    | '[][]' TIPOS '{' matrixRows '}'         # MatrixLiteral
    | '[]' TIPOS '{' args? '}'                # SliceLiteral
    | '{' args? '}'                           # Array
    | 'slices.Index' '(' args ')'             # SliceIndex
    | 'len' '(' args ')'                      # SliceLen
    | 'append' '(' args ')'                   # SliceAppend
    | 'append' '(' ID ',' expr ')'            # AppendExpr
    | 'strings.Join' '(' args ')'             # StringsJoin
    | 'new' ID '(' args? ')'                  # New
    | BOOL                                    # Boolean
    | FLOAT                                   # Float
    | STRING                                  # String
    | INT                                     # Int
    | ID                                      # Identifier
    | '(' expr ')'                            # Parens;


call: 
    '(' args? ')'                         # FuncCall
    | '.' ID                                 # Get;

matrixRows: ('{'args'}'',')*;

args: expr (',' expr)*;
caseBlock: 'case' expr ':' stmt+; 
defaultBlock: 'default' ':' stmt+;

INT: [0-9]+;
BOOL: 'true' | 'false';
FLOAT: [0-9]+ '.' [0-9]+;
STRING: '"' ( ~["\\] | '\\' . )* '"';
RUNE: [0-9] | [1-9][0-9] | '1'[0-9][0-9] | '2'[0-4][0-9] | '25'[0-5];
WS: [ \t\r\n]+ -> skip;
TIPOS:
	 'int'
	 | 'float64'
	 | 'string'
	 | 'bool'
	 | 'rune';
ID: [a-zA-Z_][a-zA-Z0-9_]*;


COMMENT: '//' ~[\r\n]* -> skip;
ML_COMMENT: '/*' .*? '*/' -> skip;