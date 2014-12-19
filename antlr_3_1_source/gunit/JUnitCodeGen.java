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
package org.antlr.gunit;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.StringTemplateGroupLoader;
import org.antlr.stringtemplate.CommonGroupLoader;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;

import java.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JUnitCodeGen {
	public GrammarInfo grammarInfo;
	public Map<String, String> ruleWithReturn;
	
	private final static Handler console = new ConsoleHandler();
	private static final Logger logger = Logger.getLogger(JUnitCodeGen.class.getName());
	static {
		logger.addHandler(console);
	}
	
	public JUnitCodeGen(GrammarInfo grammarInfo) throws ClassNotFoundException {
		this.grammarInfo = grammarInfo;
		/** Map the name of rules having return value to its return type */
		ruleWithReturn = new HashMap<String, String>();
		Class c;
		if ( grammarInfo.getHeader()!=null ) {	// if using package, get the parser class from appropriate path
			c = Class.forName(grammarInfo.getHeader()+"."+grammarInfo.getGrammarName()+"Parser");
		}
		else {
			c = Class.forName(grammarInfo.getGrammarName()+"Parser");
		}
	    Method[] methods = c.getDeclaredMethods();
        for(Method method : methods) {
        	if ( !method.getReturnType().getName().equals("void") ) {
        		ruleWithReturn.put(method.getName(), method.getReturnType().getName().replace('$', '.'));
        	}
        }
	}

	public void compile() throws IOException{
		String junitFileName;
		if ( grammarInfo.getTreeGrammarName()!=null ) {
			junitFileName = "Test"+grammarInfo.getTreeGrammarName();
		}
		else {
			junitFileName = "Test"+grammarInfo.getGrammarName();
		}
		String lexerName = grammarInfo.getGrammarName()+"Lexer";
		String parserName = grammarInfo.getGrammarName()+"Parser";
		
		StringTemplateGroupLoader loader = new CommonGroupLoader("org/antlr/gunit", null);
		StringTemplateGroup.registerGroupLoader(loader);
		StringTemplateGroup.registerDefaultLexer(AngleBracketTemplateLexer.class);
		StringBuffer buf = compileToBuffer(junitFileName, lexerName, parserName);
		writeTestFile(".", junitFileName+".java", buf.toString());
	}

	public StringBuffer compileToBuffer(String className, String lexerName,
			String parserName) {
		StringTemplateGroup group = StringTemplateGroup.loadGroup("junit");
		StringBuffer buf = new StringBuffer();
		buf.append(genClassHeader(group, className));
		buf.append(genTestRuleMethods(group));
		buf.append(genSupportingMethods(group, lexerName, parserName));
		buf.append(group.getInstanceOf("examineParserExecResult").toString());
		buf.append("\n\n}");
		return buf;
	}
	
	protected String genClassHeader(StringTemplateGroup group, String junitFileName) {
		StringTemplate classHeaderST = group.getInstanceOf("classHeader");
		if ( grammarInfo.getHeader()!=null ) {	// Set up class package if there is
			classHeaderST.setAttribute("header", "package "+grammarInfo.getHeader()+";");
		}
		classHeaderST.setAttribute("junitFileName", junitFileName);
		return classHeaderST.toString();
	}
	
	protected String genTestRuleMethods(StringTemplateGroup group) {
		StringBuffer buf = new StringBuffer();
		if ( grammarInfo.getTreeGrammarName()!=null ) {	// Generate junit codes of for tree grammar rule
			for ( gUnitTestSuite ts: grammarInfo.getRuleTestSuites() ) {
				int i = 0;
				for ( gUnitTestInput input: ts.testSuites.keySet() ) {	// each rule may contain multiple tests
					i++;
					StringTemplate testRuleMethodST;
					/** If rule has multiple return values or ast*/
					if ( ts.testSuites.get(input).getType()==6 && ruleWithReturn.containsKey(ts.treeRule) ) {
						testRuleMethodST = group.getInstanceOf("testTreeRuleMethod2");
						String inputString = escapeForJava(input.testInput);
						String outputString = ts.testSuites.get(input).getText();
						testRuleMethodST.setAttribute("methodName", "test"+changeFirstCapital(ts.treeRule)+"_walks_"+ 
								changeFirstCapital(ts.rule)+i);
						testRuleMethodST.setAttribute("testTreeRuleName", '"'+ts.treeRule+'"');
						testRuleMethodST.setAttribute("testRuleName", '"'+ts.rule+'"');
						testRuleMethodST.setAttribute("testInput", '"'+inputString+'"');
						testRuleMethodST.setAttribute("returnType", ruleWithReturn.get(ts.treeRule));
						testRuleMethodST.setAttribute("isFile", input.inputIsFile);
						testRuleMethodST.setAttribute("expecting", outputString);
					}
					else {
						testRuleMethodST = group.getInstanceOf("testTreeRuleMethod");
						String inputString = escapeForJava(input.testInput);
						String outputString = ts.testSuites.get(input).getText();
						testRuleMethodST.setAttribute("methodName", "test"+changeFirstCapital(ts.treeRule)+"_walks_"+ 
								changeFirstCapital(ts.rule)+i);
						testRuleMethodST.setAttribute("testTreeRuleName", '"'+ts.treeRule+'"');
						testRuleMethodST.setAttribute("testRuleName", '"'+ts.rule+'"');
						testRuleMethodST.setAttribute("testInput", '"'+inputString+'"');
						testRuleMethodST.setAttribute("isFile", input.inputIsFile);
						testRuleMethodST.setAttribute("tokenType", ts.testSuites.get(input).getType());
						
						if ( ts.testSuites.get(input).getType()==6 ) {	// trim ';' at the end of ACTION if there is...
							//testRuleMethodST.setAttribute("expecting", outputString.substring(0, outputString.length()-1));
							testRuleMethodST.setAttribute("expecting", outputString);
						}
						else if ( ts.testSuites.get(input).getType()==7 ) {	// Expected: RETVAL
							testRuleMethodST.setAttribute("expecting", outputString);
						}
						else {	// Attach "" to expected STRING or AST
							testRuleMethodST.setAttribute("expecting", '"'+outputString.replace("\n", "\\n")+'"');
						}
					}
					buf.append(testRuleMethodST.toString());
				}
			}
		}
		else {	// Generate junit codes of for grammar rule
			for ( gUnitTestSuite ts: grammarInfo.getRuleTestSuites() ) {
				int i = 0;
				for ( gUnitTestInput input: ts.testSuites.keySet() ) {	// each rule may contain multiple tests
					i++;
					StringTemplate testRuleMethodST;
					/** If rule has multiple return values or ast*/
					if ( ts.testSuites.get(input).getType()==6 && ruleWithReturn.containsKey(ts.rule) ) {
						testRuleMethodST = group.getInstanceOf("testRuleMethod2");
						String inputString = escapeForJava(input.testInput);
						String outputString = ts.testSuites.get(input).getText();
						testRuleMethodST.setAttribute("methodName", "test"+changeFirstCapital(ts.rule)+i);
						testRuleMethodST.setAttribute("testRuleName", '"'+ts.rule+'"');
						testRuleMethodST.setAttribute("testInput", '"'+inputString+'"');
						testRuleMethodST.setAttribute("returnType", ruleWithReturn.get(ts.rule));
						testRuleMethodST.setAttribute("isFile", input.inputIsFile);
						testRuleMethodST.setAttribute("expecting", outputString);
					}
					else {
						testRuleMethodST = group.getInstanceOf("testRuleMethod");
						String inputString = escapeForJava(input.testInput);
						String outputString = ts.testSuites.get(input).getText();
						testRuleMethodST.setAttribute("methodName", "test"+changeFirstCapital(ts.rule)+i);
						testRuleMethodST.setAttribute("testRuleName", '"'+ts.rule+'"');
						testRuleMethodST.setAttribute("testInput", '"'+inputString+'"');
						testRuleMethodST.setAttribute("isFile", input.inputIsFile);
						testRuleMethodST.setAttribute("tokenType", ts.testSuites.get(input).getType());
						
						if ( ts.testSuites.get(input).getType()==6 ) {	// trim ';' at the end of ACTION if there is...
							//testRuleMethodST.setAttribute("expecting", outputString.substring(0, outputString.length()-1));
							testRuleMethodST.setAttribute("expecting", outputString);
						}
						else if ( ts.testSuites.get(input).getType()==7 ) {	// Expected: RETVAL
							testRuleMethodST.setAttribute("expecting", outputString);
						}
						else {	// Attach "" to expected STRING or AST
							testRuleMethodST.setAttribute("expecting", '"'+outputString.replace("\n", "\\n")+'"');
						}
					}
					buf.append(testRuleMethodST.toString());
				}
			}
		}
		return buf.toString();
	}
	
	protected String genSupportingMethods(StringTemplateGroup group, String lexerName, String parserName) {
		StringTemplate supportingMethodST;
		String parserPath;
		String treeParserPath;
		/** Set up appropriate class path for parser/tree parser if using package */
		if ( grammarInfo.getHeader()!=null ) {
			parserPath = grammarInfo.getHeader()+"."+parserName;
			treeParserPath = grammarInfo.getHeader()+"."+grammarInfo.getTreeGrammarName();
		}
		else {
			parserPath = parserName;
			treeParserPath = grammarInfo.getTreeGrammarName();
		}
		/** Set up different parser executer for parser grammar and tree grammar */
		if ( grammarInfo.getTreeGrammarName()!=null ) {	// Load template for testing tree grammar
			supportingMethodST = group.getInstanceOf("execTreeParser");
			supportingMethodST.setAttribute("treeParserName", grammarInfo.getTreeGrammarName());
			supportingMethodST.setAttribute("treeParserPath", treeParserPath);
		}
		else {	// Load template for testing grammar
			supportingMethodST = group.getInstanceOf("execParser");
		}
		supportingMethodST.setAttribute("lexerName", lexerName);
		supportingMethodST.setAttribute("parserName", parserName);
		supportingMethodST.setAttribute("parserPath", parserPath);
		return supportingMethodST.toString();
	}

	protected void writeTestFile(String dir, String fileName, String content) {
		try {
			File f = new File(dir, fileName);
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			bw.write(content);
			bw.close();
			w.close();
		}
		catch (IOException ioe) {
			logger.log(Level.SEVERE, "can't write file", ioe);
		}
	}

	protected String escapeForJava(String inputString) {
		// Gotta escape literal backslash before putting in specials that use escape.
		inputString = inputString.replace("\\", "\\\\");
		// Then double quotes need escaping (singles are OK of course).
		inputString = inputString.replace("\"", "\\\"");
		// note: replace newline to String ".\n", replace tab to String ".\t"
		inputString = inputString.replace("\n", "\\n").replace("\t", "\\t");
		
		return inputString;
	}
	
	protected String changeFirstCapital(String ruleName) {
		String firstChar = String.valueOf(ruleName.charAt(0));
		return firstChar.toUpperCase()+ruleName.substring(1);
	}
}
