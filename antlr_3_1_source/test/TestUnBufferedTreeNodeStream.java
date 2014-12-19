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

import org.antlr.runtime.tree.*;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

public class TestUnBufferedTreeNodeStream extends TestTreeNodeStream {

	public TreeNodeStream newStream(Object t) {
		return new UnBufferedTreeNodeStream(t);
	}

	public void testBufferOverflow() throws Exception {
		StringBuffer buf = new StringBuffer();
		StringBuffer buf2 = new StringBuffer();
		// make ^(101 102 ... n)
		Tree t = new CommonTree(new CommonToken(101));
		buf.append(" 101");
		buf2.append(" 101");
		buf2.append(" ");
		buf2.append(Token.DOWN);
		for (int i=0; i<= UnBufferedTreeNodeStream.INITIAL_LOOKAHEAD_BUFFER_SIZE+10; i++) {
			t.addChild(new CommonTree(new CommonToken(102+i)));
			buf.append(" ");
			buf.append(102+i);
			buf2.append(" ");
			buf2.append(102+i);
		}
		buf2.append(" ");
		buf2.append(Token.UP);

		TreeNodeStream stream = newStream(t);
		String expecting = buf.toString();
		String found = toNodesOnlyString(stream);
		assertEquals(expecting, found);

		expecting = buf2.toString();
		found = stream.toString();
		assertEquals(expecting, found);
	}

	/** Test what happens when tail hits the end of the buffer, but there
	 *  is more room left.  Specifically that would mean that head is not
	 *  at 0 but has advanced somewhere to the middle of the lookahead
	 *  buffer.
	 *
	 *  Use consume() to advance N nodes into lookahead.  Then use LT()
	 *  to load at least INITIAL_LOOKAHEAD_BUFFER_SIZE-N nodes so the
	 *  buffer has to wrap.
	 */
	public void testBufferWrap() throws Exception {
		int N = 10;
		// make tree with types: 1 2 ... INITIAL_LOOKAHEAD_BUFFER_SIZE+N
		Tree t = new CommonTree((Token)null);
		for (int i=0; i<UnBufferedTreeNodeStream.INITIAL_LOOKAHEAD_BUFFER_SIZE+N; i++) {
			t.addChild(new CommonTree(new CommonToken(i+1)));
		}

		// move head to index N
		TreeNodeStream stream = newStream(t);
		for (int i=1; i<=N; i++) { // consume N
			Tree node = (Tree)stream.LT(1);
			assertEquals(i, node.getType());
			stream.consume();
		}

		// now use LT to lookahead past end of buffer
		int remaining = UnBufferedTreeNodeStream.INITIAL_LOOKAHEAD_BUFFER_SIZE-N;
		int wrapBy = 4; // wrap around by 4 nodes
		assertTrue("bad test code; wrapBy must be less than N", wrapBy<N);
		for (int i=1; i<=remaining+wrapBy; i++) { // wrap past end of buffer
			Tree node = (Tree)stream.LT(i); // look ahead to ith token
			assertEquals(N + i, node.getType());
		}
	}

}
