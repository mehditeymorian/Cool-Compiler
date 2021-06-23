grammar Cool;

cool: line+ | EOF ;

line: (newline|space|reserved|number|special|string|operatorPunctuation|id|comment|unknown)*? NEWLINE ;

newline: NEWLINE;

special: SPECIAL;

space: WHITESPACE;

reserved : KEYWORD;

number: INT | HEX | FLOAT | SCIENTIFIC;

string: STRING;

operatorPunctuation: CODE;

id: ID;

comment: ONELINECOMMENT | MULTICOMMENT;

unknown: UNKNOWN+;

KEYWORD: 'void' | 'for' | 'rof' | 'out_' | 'in_int()' | 'int' | 'while' | 'let' | 'new'
	|	 'real' | 'if' | 'fi' | 'break' | 'then' | 'bool' | 'else' | 'Array' | 'continue' | 'len' | 'string'
	|	 'return' | 'loop' | 'class' | 'in_string()' | 'pool';

INT: SIGN NUMBER;

fragment NUMBER: [0-9]+;

HEX: '0' ('x' | 'X') [0-9a-fA-F]+;

FLOAT: NUMBER '.' [0-9]*;

SCIENTIFIC: NUMBER '.' NUMBER E INT;

CODE: '+' | '-' | '*' | '+=' | '-=' | '*=' | '/=' | '++' | '--' | '/'
      	|  '<' | '<=' | '>' | '>=' | '!=' | '==' | '<-' | '%' | '&&'
      	|  '||' | '&' | '|' | '"' | '^' | '!' | '.' | ',' | ';' | '['
      	|  ']' | '(' | ')' | '{' | '}' | ':';

ID: [a-zA-Z] [a-zA-Z0-9_]*;

fragment SIGN: ('-'|'+')?;

STRING: '"' (SPECIAL | ~ ["\\])* '"';

fragment E: [eE];

ONELINECOMMENT: '//' (~ '\n')* [\n]?;

MULTICOMMENT: '/*' (MULTICOMMENT | .)*? '*/';

SPECIAL: ('\\n'|'\\t'|'\\"'|'\\\''|'\\0'|'\\f'|'\\r');

NEWLINE: ('\r'? '\n' | '\r')+ ;

WHITESPACE: [ \t\r\f]+;

UNKNOWN: .;

