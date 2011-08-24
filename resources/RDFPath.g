grammar RDFPath;

options { output = AST; }
tokens {
	QUERY;
	LOCATIONSTEP;
	CONDITION;
	FILTER;
	FILTERFUNCTION;
	SUBQUERY;
	REPEAT;
	SHORTESTPATH;
	ENDNODEFUNCTION;
	STARTNODE;
	EDGE;
}

/* PARSER RULES */

query
	:	startNode '::' locationStep ('>' locationStep)* ('.' endNodeFunction)? 
		-> ^(QUERY startNode locationStep+ endNodeFunction?)
	;
	
locationStep
	:	edge condition* 
		-> ^(LOCATIONSTEP edge condition*)
	|	edge condition* repeat 
		-> ^(LOCATIONSTEP edge condition* repeat)
	|	edge condition* shortestPath 
		-> ^(LOCATIONSTEP edge condition* shortestPath)
	;

condition
	:	'[' ( filter -> ^(CONDITION filter) 
	|	subquery -> ^(CONDITION subquery)) ']'
	;

filter
	:	filterFunction
		-> ^(FILTER filterFunction)
	;

filterFunction
	:	fn='EQUALS(' v=STRING ')' -> ^(FILTERFUNCTION $fn $v)
	|	fn='EQUALS(' v=INTVALUE ')' -> ^(FILTERFUNCTION $fn $v)
	|	fn='SUFFIX(' v=STRING ')' -> ^(FILTERFUNCTION $fn $v)
	|	fn='PREFIX(' v=STRING ')' -> ^(FILTERFUNCTION $fn $v)
	|	fn='MIN(' v=INTVALUE ')' -> ^(FILTERFUNCTION $fn $v)
	|	fn='MAX(' v=INTVALUE ')' -> ^(FILTERFUNCTION $fn $v)
	; 

subquery
	: 	edge '=' filterFunction
		-> ^(SUBQUERY edge filterFunction)
	;

repeat
	:	'(' v=INTVALUE ')' 
		-> ^(REPEAT $v)
	;

shortestPath
	:	'(*' v=INTVALUE ')' 
		-> ^(SHORTESTPATH $v)
	;

endNodeFunction
	:	fn='COUNT()' -> ^(ENDNODEFUNCTION $fn) 
	|	fn='SUM()' -> ^(ENDNODEFUNCTION $fn)
	|	fn='AVG()' -> ^(ENDNODEFUNCTION $fn)
	|	fn='MIN()' -> ^(ENDNODEFUNCTION $fn)
	|	fn='MAX()'-> ^(ENDNODEFUNCTION $fn)
	|	fn='DISTANCE(' v=STRING ')' -> ^(ENDNODEFUNCTION $fn $v)
	;

startNode
	:	v='*' -> ^(STARTNODE $v)
	|	v=TEXTVALUE -> ^(STARTNODE $v) 
	;

edge
	:	v=TEXTVALUE 
		-> ^(EDGE $v)
	;

/* LEXER RULES */

TEXTVALUE
	:	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')* 
	;

INTVALUE
	:	('0'..'9')+ 
	;

STRING
	:	'\'' TEXTVALUE '\'' 
	;

WS
	:	(' ' | '\t' | '\r' | '\n') {$channel=HIDDEN;}
	;
