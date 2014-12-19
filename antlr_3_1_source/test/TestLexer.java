/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
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
package org.antlr.test;

public class TestLexer extends BaseTest {
	protected boolean debug = false;

	/** Public default constructor used by TestRig */
	public TestLexer() {
	}

	public void testSetText() throws Exception {
		// this must return A not I to the parser; calling a nonfragment rule
		// from a nonfragment rule does not set the overall token.
		String grammar =
			"grammar P;\n"+
			"a : A {System.out.println(input);} ;\n"+
			"A : '\\\\' 't' {setText(\"\t\");} ;\n" +
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "\\t", debug);
		assertEquals("\t\n", found);
	}

	public void testRefToRuleDoesNotSetTokenNorEmitAnother() throws Exception {
		// this must return A not I to the parser; calling a nonfragment rule
		// from a nonfragment rule does not set the overall token.
		String grammar =
			"grammar P;\n"+
			"a : A EOF {System.out.println(input);} ;\n"+
			"A : '-' I ;\n" +
			"I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "-34", debug);
		assertEquals("-34\n", found);
	}

	public void testRefToRuleDoesNotSetChannel() throws Exception {
		// this must set channel of A to HIDDEN.  $channel is local to rule
		// like $type.
		String grammar =
			"grammar P;\n"+
			"a : A EOF {System.out.println($A.text+\", channel=\"+$A.channel);} ;\n"+
			"A : '-' WS I ;\n" +
			"I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "- 34", debug);
		assertEquals("- 34, channel=0\n", found);
	}

	public void testWeCanSetType() throws Exception {
		String grammar =
			"grammar P;\n"+
			"tokens {X;}\n" +
			"a : X EOF {System.out.println(input);} ;\n"+
			"A : '-' I {$type = X;} ;\n" +
			"I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "-34", debug);
		assertEquals("-34\n", found);
	}

	public void testRefToFragment() throws Exception {
		// this must return A not I to the parser; calling a nonfragment rule
		// from a nonfragment rule does not set the overall token.
		String grammar =
			"grammar P;\n"+
			"a : A {System.out.println(input);} ;\n"+
			"A : '-' I ;\n" +
			"fragment I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "-34", debug);
		assertEquals("-34\n", found);
	}

	public void testMultipleRefToFragment() throws Exception {
		// this must return A not I to the parser; calling a nonfragment rule
		// from a nonfragment rule does not set the overall token.
		String grammar =
			"grammar P;\n"+
			"a : A EOF {System.out.println(input);} ;\n"+
			"A : I '.' I ;\n" +
			"fragment I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "3.14159", debug);
		assertEquals("3.14159\n", found);
	}

	public void testLabelInSubrule() throws Exception {
		// can we see v outside?
		String grammar =
			"grammar P;\n"+
			"a : A EOF ;\n"+
			"A : 'hi' WS (v=I)? {$channel=0; System.out.println($v.text);} ;\n" +
			"fragment I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "hi 342", debug);
		assertEquals("342\n", found);
	}

	public void testRefToTokenInLexer() throws Exception {
		String grammar =
			"grammar P;\n"+
			"a : A EOF ;\n"+
			"A : I {System.out.println($I.text);} ;\n" +
			"fragment I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "342", debug);
		assertEquals("342\n", found);
	}

	public void testListLabelInLexer() throws Exception {
		String grammar =
			"grammar P;\n"+
			"a : A ;\n"+
			"A : i+=I+ {for (Object t : $i) System.out.print(\" \"+((Token)t).getText());} ;\n" +
			"fragment I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "33 297", debug);
		assertEquals(" 33 297\n", found);
	}

	public void testDupListRefInLexer() throws Exception {
		String grammar =
			"grammar P;\n"+
			"a : A ;\n"+
			"A : i+=I WS i+=I {$channel=0; for (Object t : $i) System.out.print(\" \"+((Token)t).getText());} ;\n" +
			"fragment I : '0'..'9'+ ;\n"+
			"WS : (' '|'\\n') {$channel=HIDDEN;} ;";
		String found = execParser("P.g", grammar, "PParser", "PLexer",
				    "a", "33 297", debug);
		assertEquals(" 33 297\n", found);
	}

	public void testCharLabelInLexer() {
		String grammar =
			"grammar T;\n" +
			"a : B ;\n" +
			"B : x='a' {System.out.println((char)$x);} ;\n" ;
		String found = execParser("T.g", grammar, "TParser", "TLexer",
								  "a", "a", debug);
		assertEquals("a\n", found);
	}

	public void testRepeatedLabelInLexer() {
		String grammar =
			"lexer grammar t;\n" +
			"B : x='a' x='b' ;\n" ;
		boolean found =
			rawGenerateAndBuildRecognizer(
				"t.g", grammar, null, "tLexer", false);
		boolean expecting = true; // should be ok
		assertEquals(expecting, found);
	}

	public void testRepeatedRuleLabelInLexer() {
		String grammar =
			"lexer grammar t;\n" +
			"B : x=A x=A ;\n" +
			"fragment A : 'a' ;\n" ;
		boolean found =
			rawGenerateAndBuildRecognizer(
				"t.g", grammar, null, "tLexer", false);
		boolean expecting = true; // should be ok
		assertEquals(expecting, found);
	}

	public void testIsolatedEOTEdge() {
		String grammar =
			"lexer grammar T;\n" +
			"QUOTED_CONTENT \n" +
			"        : 'q' (~'q')* (('x' 'q') )* 'q' ; \n";
		boolean found =
			rawGenerateAndBuildRecognizer(
				"T.g", grammar, null, "TLexer", false);
		boolean expecting = true; // should be ok
		assertEquals(expecting, found);
	}	

	public void testEscapedLiterals() {
		/* Grammar:
			A : '\"' ;  should match a single double-quote: "
			B : '\\\"' ; should match input \"
		*/
		String grammar =
			"lexer grammar T;\n" +
			"A : '\\\"' ;\n" +
			"B : '\\\\\\\"' ;\n" ; // '\\\"'
		boolean found =
			rawGenerateAndBuildRecognizer(
				"T.g", grammar, null, "TLexer", false);
		boolean expecting = true; // should be ok
		assertEquals(expecting, found);
	}
}
