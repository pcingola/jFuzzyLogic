/*
[The "BSD licence"]
Copyright (c) 2007-2008 Leon, Jen-Yuan Su
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
grammar gUnit;
options {language=Java;}
tokens {
	DOC_COMMENT;
}
@header {package org.antlr.gunit;}
@lexer::header {package org.antlr.gunit;}
@members {
public GrammarInfo grammarInfo;
public gUnitParser(TokenStream input, GrammarInfo grammarInfo) {
	super(input);
	this.grammarInfo = grammarInfo;
}
}

gUnitDef:	'gunit' g1=ID ('walks' g2=ID)? ';' 
		{
		if ( $g2==null ) {
			grammarInfo.setGrammarName($g1.text);
		}
		else {
			grammarInfo.setGrammarName($g2.text);
			grammarInfo.setTreeGrammarName($g1.text);
		}
		}
		header? suite*
	;

header	:	'@header' ACTION
		{
		int pos1, pos2;
		if ( (pos1=$ACTION.text.indexOf("package"))!=-1 && (pos2=$ACTION.text.indexOf(';'))!=-1 ) {
			grammarInfo.setHeader($ACTION.text.substring(pos1+8, pos2).trim());	// substring the package path
		}
		else {
			System.err.println("error(line "+$ACTION.getLine()+"): invalid header");
		}
		}
	;
		
suite	// gUnit test suite based on individual rule
@init {
    gUnitTestSuite ts = null;
}
	:	r1=ID ('walks' r2=ID)? ':' 
		{
		if ( $r2==null ) {
			ts = new gUnitTestSuite($r1.text);
		}
		else {
			ts = new gUnitTestSuite($r1.text, $r2.text);
		}
		}
		test[ts]+ {grammarInfo.addRuleTestSuite(ts);}
	;

test[gUnitTestSuite ts]	// individual test within a (rule)testsuite
	:	input ok='OK' {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile, $input.line), new BooleanTest(true));}
	|	input fail='FAIL' {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile, $input.line), new BooleanTest(false));}
	|	input 'returns' RETVAL {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile, $input.line), new ReturnTest($RETVAL));}
	|	input '->' output {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile, $input.line), new OutputTest($output.token));}
	;

input returns [String testInput, boolean inputIsFile, int line]
	:	STRING 
		{
		$testInput = $STRING.text.replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t")
		.replace("\\b", "\b").replace("\\f", "\f").replace("\\\"", "\"").replace("\\'", "\'").replace("\\\\", "\\");
		$inputIsFile = false;
		$line = $STRING.line;
		}
	|	ML_STRING
		{
		$testInput = $ML_STRING.text;
		$inputIsFile = false;
		$line = $ML_STRING.line;
		}
	|	file
		{
		$testInput = $file.text;
		$inputIsFile = true;
		$line = $file.line;
		}
	;

output returns [Token token]
	:	STRING 
		{
		$STRING.setText($STRING.text.replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t")
		.replace("\\b", "\b").replace("\\f", "\f").replace("\\\"", "\"").replace("\\'", "\'").replace("\\\\", "\\"));
		$token = $STRING;
		}
	|	ML_STRING {$token = $ML_STRING;}
	|	AST {$token = $AST;}
	|	ACTION {$token = $ACTION;}
	;

file returns [int line]	
	:	ID EXT? {$line = $ID.line;}
	;


// L E X I C A L   R U L E S

SL_COMMENT
 	:	'//' ~('\r'|'\n')* '\r'? '\n' {$channel=HIDDEN;}
	;

ML_COMMENT
	:	'/*' {$channel=HIDDEN;} .* '*/'
	;

STRING	:	'"' ( ESC | ~('\\'|'"') )* '"' {setText(getText().substring(1, getText().length()-1));}
	;

ML_STRING
	:	'<<' .* '>>' 
		{
		if ( getText().charAt(2)=='\n' && getText().charAt(getText().length()-3)=='\n' ) {
			setText(getText().substring(3, getText().length()-3));
		}
		else if ( getText().charAt(2)=='\n' ) {
			setText(getText().substring(3, getText().length()-2));
		}
		else if ( getText().charAt(getText().length()-3)=='\n' ) {
			setText(getText().substring(2, getText().length()-3));
		}
		else {
			setText(getText().substring(2, getText().length()-2));
		}
		}
	;

ID	:	('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

EXT	:	'.'('a'..'z'|'A'..'Z'|'0'..'9')+;

RETVAL	:	NESTED_RETVAL {setText(getText().substring(1, getText().length()-1));}
	;

fragment
NESTED_RETVAL :
	'['
	(	options {greedy=false;}
	:	NESTED_RETVAL
	|	.
	)*
	']'
	;

AST	:	NESTED_AST (' '? NESTED_AST)*;

fragment
NESTED_AST :
	'('
	(	options {greedy=false;}
	:	NESTED_AST
	|	.
	)*
	')'
	;

ACTION
	:	NESTED_ACTION {setText(getText().substring(1, getText().length()-1));}
	;

fragment
NESTED_ACTION :
	'{'
	(	options {greedy=false; k=3;}
	:	NESTED_ACTION
	|	STRING_LITERAL
	|	CHAR_LITERAL
	|	.
	)*
	'}'
	;

fragment
CHAR_LITERAL
	:	'\'' ( ESC | ~('\''|'\\') ) '\''
	;

fragment
STRING_LITERAL
	:	'"' ( ESC | ~('\\'|'"') )* '"'
	;

fragment
ESC	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	'>'
		|	'u' XDIGIT XDIGIT XDIGIT XDIGIT
		|	. // unknown, leave as it is
		)
	;
	
fragment
XDIGIT :
		'0' .. '9'
	|	'a' .. 'f'
	|	'A' .. 'F'
	;

WS	:	(	' '
		|	'\t'
		|	'\r'? '\n'
		)+
		{$channel=HIDDEN;}
	;
