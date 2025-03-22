grammar Language;

program: dcl*;

dcl: varDcl | funcDcl | classDcl | stmt;

varDcl: 
	  'var' ID TIPOS ('=' expr)? ';'	# EVarDcl
	  | ID ':=' expr ';'				# IVarDcl;

funcDcl: 'function' ID '('params?')''{'dcl*'}';

classDcl: 'class' ID '{' classBody* '}';

classBody: varDcl | funcDcl;

params: ID (',' ID)*;

stmt:
	expr ';' # ExprStmt
	| '{' dcl* '}'								# BlockStmt
	| 'if' '('? expr ')'? stmt ('else' stmt)?		# IfStmt
	| 'while' '(' expr ')' stmt					# WhileStmt
	| 'for' '('? forInit expr ';' expr ')'? stmt	# ForStmt
	| 'break' ';'								# BreakStmt
	| 'continue' ';'							# ContinueStmt
	| 'return' expr? ';'						# ReturnStmt;

forInit: varDcl | expr ';';

expr:
	'!' expr									# NotExpr
	|'-' expr									# Negate
	| expr op = ('*' | '/' | '%') expr			# MulDiv
	| expr op = ('+' | '-') expr				# AddSub
	| expr op = ('+=' | '-=') expr				# AddSubAssign 
	| expr op = ('>' | '<' | '>=' | '<=') expr	# Relational
	| expr op = ('==' | '!=') expr				# Equality
	| expr op = ( '&&' | '||') expr				# Logical
	| expr call+								# Callee
	| expr '=' expr								# Assign
	| BOOL										# Boolean
	| FLOAT										# Float
	| STRING									# String
	| INT										# Int
	| '[' args? ']'								# Array
	| 'new' ID '(' args? ')'					# New
	| ID										# Identifier
	| '(' expr ')'								# Parens;

call: 
	'(' args? ')' 	# FuncCall 
	| '.' ID 		# Get  
	| '[' expr ']'	# ArrayAccess;

args: expr (',' expr)*;

INT: [0-9]+;
BOOL: 'true' | 'false';
FLOAT: [0-9]+ '.' [0-9]+;
STRING: '"' ~'"'* '"';
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