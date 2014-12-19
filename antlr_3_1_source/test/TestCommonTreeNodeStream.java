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

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

/** Tests specific to CommonTreeNodeStream */
public class TestCommonTreeNodeStream extends TestTreeNodeStream {
	public void testPushPop() throws Exception {
		// ^(101 ^(102 103) ^(104 105) ^(106 107) 108 109)
		// stream has 9 real + 8 nav nodes
		// Sequence of types: 101 DN 102 DN 103 UP 104 DN 105 UP 106 DN 107 UP 108 109 UP
		Tree r0 = new CommonTree(new CommonToken(101));
		Tree r1 = new CommonTree(new CommonToken(102));
		r1.addChild(new CommonTree(new CommonToken(103)));
		r0.addChild(r1);
		Tree r2 = new CommonTree(new CommonToken(104));
		r2.addChild(new CommonTree(new CommonToken(105)));
		r0.addChild(r2);
		Tree r3 = new CommonTree(new CommonToken(106));
		r3.addChild(new CommonTree(new CommonToken(107)));
		r0.addChild(r3);
		r0.addChild(new CommonTree(new CommonToken(108)));
		r0.addChild(new CommonTree(new CommonToken(109)));

		CommonTreeNodeStream stream = new CommonTreeNodeStream(r0);
		String expecting = " 101 2 102 2 103 3 104 2 105 3 106 2 107 3 108 109 3";
		String found = stream.toString();
		assertEquals(expecting, found);

		// Assume we want to hit node 107 and then "call 102" then return

		int indexOf102 = 2;
		int indexOf107 = 12;
		for (int k=1; k<=indexOf107; k++) { // consume til 107 node
			stream.consume();
		}
		// CALL 102
		assertEquals(107, ((Tree)stream.LT(1)).getType());
		stream.push(indexOf102);
		assertEquals(102, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 102
		assertEquals(Token.DOWN, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume DN
		assertEquals(103, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 103
		assertEquals(Token.UP, ((Tree)stream.LT(1)).getType());
		// RETURN
		stream.pop();
		assertEquals(107, ((Tree)stream.LT(1)).getType());
	}

	public void testNestedPushPop() throws Exception {
		// ^(101 ^(102 103) ^(104 105) ^(106 107) 108 109)
		// stream has 9 real + 8 nav nodes
		// Sequence of types: 101 DN 102 DN 103 UP 104 DN 105 UP 106 DN 107 UP 108 109 UP
		Tree r0 = new CommonTree(new CommonToken(101));
		Tree r1 = new CommonTree(new CommonToken(102));
		r1.addChild(new CommonTree(new CommonToken(103)));
		r0.addChild(r1);
		Tree r2 = new CommonTree(new CommonToken(104));
		r2.addChild(new CommonTree(new CommonToken(105)));
		r0.addChild(r2);
		Tree r3 = new CommonTree(new CommonToken(106));
		r3.addChild(new CommonTree(new CommonToken(107)));
		r0.addChild(r3);
		r0.addChild(new CommonTree(new CommonToken(108)));
		r0.addChild(new CommonTree(new CommonToken(109)));

		CommonTreeNodeStream stream = new CommonTreeNodeStream(r0);

		// Assume we want to hit node 107 and then "call 102", which
		// calls 104, then return

		int indexOf102 = 2;
		int indexOf107 = 12;
		for (int k=1; k<=indexOf107; k++) { // consume til 107 node
			stream.consume();
		}
		assertEquals(107, ((Tree)stream.LT(1)).getType());
		// CALL 102
		stream.push(indexOf102);
		assertEquals(102, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 102
		assertEquals(Token.DOWN, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume DN
		assertEquals(103, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 103

		// CALL 104
		int indexOf104 = 6;
		stream.push(indexOf104);
		assertEquals(104, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 102
		assertEquals(Token.DOWN, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume DN
		assertEquals(105, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 103
		assertEquals(Token.UP, ((Tree)stream.LT(1)).getType());
		// RETURN (to UP node in 102 subtree)
		stream.pop();

		assertEquals(Token.UP, ((Tree)stream.LT(1)).getType());
		// RETURN (to empty stack)
		stream.pop();
		assertEquals(107, ((Tree)stream.LT(1)).getType());
	}

	public void testPushPopFromEOF() throws Exception {
		// ^(101 ^(102 103) ^(104 105) ^(106 107) 108 109)
		// stream has 9 real + 8 nav nodes
		// Sequence of types: 101 DN 102 DN 103 UP 104 DN 105 UP 106 DN 107 UP 108 109 UP
		Tree r0 = new CommonTree(new CommonToken(101));
		Tree r1 = new CommonTree(new CommonToken(102));
		r1.addChild(new CommonTree(new CommonToken(103)));
		r0.addChild(r1);
		Tree r2 = new CommonTree(new CommonToken(104));
		r2.addChild(new CommonTree(new CommonToken(105)));
		r0.addChild(r2);
		Tree r3 = new CommonTree(new CommonToken(106));
		r3.addChild(new CommonTree(new CommonToken(107)));
		r0.addChild(r3);
		r0.addChild(new CommonTree(new CommonToken(108)));
		r0.addChild(new CommonTree(new CommonToken(109)));

		CommonTreeNodeStream stream = new CommonTreeNodeStream(r0);

		while ( stream.LA(1)!=Token.EOF ) {
			stream.consume();
		}
		int indexOf102 = 2;
		int indexOf104 = 6;
		assertEquals(Token.EOF, ((Tree)stream.LT(1)).getType());

		// CALL 102
		stream.push(indexOf102);
		assertEquals(102, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 102
		assertEquals(Token.DOWN, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume DN
		assertEquals(103, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 103
		assertEquals(Token.UP, ((Tree)stream.LT(1)).getType());
		// RETURN (to empty stack)
		stream.pop();
		assertEquals(Token.EOF, ((Tree)stream.LT(1)).getType());

		// CALL 104
		stream.push(indexOf104);
		assertEquals(104, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 102
		assertEquals(Token.DOWN, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume DN
		assertEquals(105, ((Tree)stream.LT(1)).getType());
		stream.consume(); // consume 103
		assertEquals(Token.UP, ((Tree)stream.LT(1)).getType());
		// RETURN (to empty stack)
		stream.pop();
		assertEquals(Token.EOF, ((Tree)stream.LT(1)).getType());
	}

	public void testStackStretch() throws Exception {
		// make more than INITIAL_CALL_STACK_SIZE pushes
		Tree r0 = new CommonTree(new CommonToken(101));
		CommonTreeNodeStream stream = new CommonTreeNodeStream(r0);
		// go 1 over initial size
		for (int i=1; i<=CommonTreeNodeStream.INITIAL_CALL_STACK_SIZE+1; i++) {
			stream.push(i);
		}
		assertEquals(10, stream.pop());
		assertEquals(9, stream.pop());
	}

}
