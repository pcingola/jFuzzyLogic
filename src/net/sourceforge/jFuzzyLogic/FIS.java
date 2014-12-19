package net.sourceforge.jFuzzyLogic;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import net.sourceforge.jFuzzyLogic.fcl.FclLexer;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.fcl.FclParser;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.RuleExpression;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethod;
import net.sourceforge.jFuzzyLogic.ruleActivationMethod.RuleActivationMethod;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethod;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;

/**
 * Fuzzy inference system (FIS)
 * 
 * A fuzzy logic inference system based on FCL language 
 * according to "INTERNATIONAL ELECTROTECHNICAL COMMISSION" IEC 1131 - Part 7
 * 
 * @author pcingola@users.sourceforge.net
 */
public class FIS extends FclObject implements Iterable<FunctionBlock>, CompileCpp {

	public static boolean debug = false;

	/** Several function blocks indexed by name */
	HashMap<String, FunctionBlock> functionBlocks;
	ArrayList<FunctionBlock> functionBlocksSorted;

	/**
	 * Create a "Fuzzy inference system (FIS)" from an FCL definition string
	 * @param lexer : lexer to use
	 * @param verbose : be verbose?
	 * @return A new FIS (or null on error)
	 */
	private static FIS createFromLexer(FclLexer lexer, boolean verbose) throws RecognitionException {
		FIS fis = new FIS();
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FclParser parser = new FclParser(tokens);

		// FclParser.fcl_return root = parser.fcl();
		FclParser.main_return root;
		root = parser.main();
		Tree parseTree = (Tree) root.getTree();

		// Error loading file?
		if (parseTree == null) {
			System.err.println("Can't create FIS");
			return null;
		}

		if (debug) Gpr.debug("Tree: " + parseTree.toStringTree());

		// Add every FunctionBlock (there may be more than one in each FCL file)
		for (int childNum = 0; childNum < parseTree.getChildCount(); childNum++) {
			Tree child = parseTree.getChild(childNum);
			if (debug) Gpr.debug("Child " + childNum + ":\t" + child + "\tTree:'" + child.toStringTree() + "'");

			// Create a new FunctionBlock
			FunctionBlock functionBlock = new FunctionBlock(fis);

			// Generate fuzzyRuleSet based on tree
			String name = functionBlock.fclTree(child);
			if (debug) Gpr.debug("FunctionBlock Name: '" + name + "'");
			fis.addFunctionBlock(name, functionBlock);
		}

		return fis;
	}

	/**
	 * Create a "Fuzzy inference system (FIS)" from an FCL definition string
	 * @param fclDefinition : FCL definition
	 * @param verbose : Be verbose?
	 * @return A new FIS or null on error
	 */
	public static FIS createFromString(String fclDefinition, boolean verbose) throws RecognitionException {
		// Parse string (lexer first, then parser)
		FclLexer lexer = new FclLexer(new ANTLRStringStream(fclDefinition));
		// Parse tree and create FIS
		return createFromLexer(lexer, verbose);
	}

	/**
	 * Load an FCL file and create a "Fuzzy inference system (FIS)"  
	 * @param fileName : FCL file name
	 * @param verbose : Be verbose?
	 * @return A new FIS or null on error
	 */
	public static FIS load(InputStream inputStream, boolean verbose) {
		// Parse file (lexer first, then parser)
		FclLexer lexer;
		try {
			lexer = new FclLexer(new ANTLRInputStream(inputStream));
		} catch (IOException e1) {
			System.err.println("Error reading inputStream'" + inputStream + "'");
			return null;
		}

		// Parse tree and create FIS
		try {
			return createFromLexer(lexer, verbose);
		} catch (RecognitionException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Load an FCL file and create a "Fuzzy inference system (FIS)"  
	 * @param fileName : FCL file name
	 * @return A new FIS or null on error
	 */
	public static FIS load(String fileName) {
		return load(fileName, false);
	}

	/**
	 * Load an FCL file and create a "Fuzzy inference system (FIS)"  
	 * @param fileName : FCL file name
	 * @param verbose : Be verbose?
	 * @return A new FIS or null on error
	 */
	public static FIS load(String fileName, boolean verbose) {
		// Parse file (lexer first, then parser)
		FclLexer lexer;
		try {
			lexer = new FclLexer(new ANTLRReaderStream(new FileReader(fileName)));
		} catch (IOException e) {
			System.err.println("Error reading file '" + fileName + "'");
			return null;
		}

		// Parse tree and create FIS
		try {
			return createFromLexer(lexer, verbose);
		} catch (RecognitionException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Default constructor
	 */
	public FIS() {
		functionBlocks = new HashMap<String, FunctionBlock>();
	}

	/** Add a function block */
	public void addFunctionBlock(String name, FunctionBlock functionBlock) {
		functionBlocks.put(name, functionBlock);
		functionBlocksSorted = null;
	}

	/**
	 * Evaluate fuzzy rules all function blocks (in alphabetical order: functionBlock.name)  
	 */
	public void evaluate() {
		if (functionBlocks.size() > 1) {
			// Create a sorted list
			ArrayList<FunctionBlock> fbs = new ArrayList<FunctionBlock>(functionBlocks.size());
			fbs.addAll(functionBlocks.values());
			Collections.sort(fbs);

			// Evaluate them all
			for (FunctionBlock fb : fbs)
				fb.evaluate();

		} else if (functionBlocks.size() == 1) {
			getFunctionBlock(null).evaluate();
		}
	}

	/**
	 * Get a FunctionBlock 
	 * @param name : FunctionBlock's name (can be null to retrieve first available one)
	 * @return FunctionBlock (or null if not found)
	 */
	public FunctionBlock getFunctionBlock(String name) {
		if (name == null) {
			if (functionBlocks.size() > 1) throw new RuntimeException("Can't use default FunctionBlock when there are more than one function blocks!");
			return functionBlocks.values().iterator().next();
		}
		return functionBlocks.get(name);
	}

	/**
	 * Get a variable from first available function block
	 * @param name
	 * @return
	 */
	public Variable getVariable(String varName) {
		FunctionBlock defaultFunctionBlock = getFunctionBlock(null);
		if (defaultFunctionBlock == null) throw new RuntimeException("Default function block not found!");

		Variable var = defaultFunctionBlock.getVariable(varName);
		if (var == null) throw new RuntimeException("Variable '" + varName + "' not found!");

		return var;
	}

	@Override
	public Iterator<FunctionBlock> iterator() {
		if (functionBlocksSorted == null) {
			functionBlocksSorted = new ArrayList<FunctionBlock>(functionBlocks.size());
			functionBlocksSorted.addAll(functionBlocks.values());
			Collections.sort(functionBlocksSorted);
		}
		return functionBlocksSorted.iterator();
	}

	/**
	 * Set a variable from first available function block
	 * @param varName : Variable's name
	 * @param value : Value to be set
	 */
	public void setVariable(String varName, double value) {
		if (functionBlocks.size() > 1) throw new RuntimeException("ERROR: No 'default' FunctionBlock. There are more than one FunctionBlocks, so you should set the variables by using FIS.setVariable(fbName, varName, value) method instead.");
		setVariable(null, varName, value);
	}

	/**
	 * Set a variable from 'fbName' function block
	 * @param fbName
	 * @param varName
	 * @param value
	 */
	public void setVariable(String fbName, String varName, double value) {
		FunctionBlock fb = getFunctionBlock(fbName);
		if (fb == null) throw new RuntimeException("Function block '" + (fbName != null ? fbName : "default") + "' not found!");
		fb.setVariable(varName, value);
	}

	/**
	 * Create a C++ program for this FIS
	 * @return
	 */
	@Override
	public String toStringCpp() {
		StringBuffer out = new StringBuffer();

		out.append("//--------------------------------------------------------------------------------\n");
		out.append("// Code generated by jFuzzyLogic\n");
		out.append("// jFuzzyLogic Version : " + JFuzzyLogic.VERSION + " \n");
		out.append("// jFuzzyLogic creted by Pablo Cingolani\n");
		out.append("//--------------------------------------------------------------------------------\n\n");
		out.append("\n#include <stdio.h>\n");
		out.append("\n#include <stdlib.h>\n");

		// Sort function blocks by name
		ArrayList<String> fbNames = new ArrayList<String>(functionBlocks.keySet());
		Collections.sort(fbNames);

		// Ge all activations and accumulation methods
		HashSet<RuleAccumulationMethod> raccs = new HashSet<RuleAccumulationMethod>();
		HashSet<RuleActivationMethod> racts = new HashSet<RuleActivationMethod>();
		HashSet<RuleConnectionMethod> rcons = new HashSet<RuleConnectionMethod>();
		for (String name : fbNames) {
			FunctionBlock functionBlock = getFunctionBlock(name);

			for (RuleBlock rb : functionBlock.getRuleBlocks().values()) {
				raccs.add(rb.getRuleAccumulationMethod());
				racts.add(rb.getRuleActivationMethod());
				for (Rule r : rb) {
					RuleExpression rexp = r.getAntecedents();
					rcons.addAll(rexp.getRuleConnectionMethods());
				}
			}
		}

		// Show code
		for (RuleAccumulationMethod racc : raccs)
			out.append(racc.toStringCppFunction() + "\n");

		for (RuleActivationMethod ract : racts)
			out.append(ract.toStringCppFunction() + "\n");

		for (RuleConnectionMethod rcon : rcons)
			out.append(rcon.toStringCppFunction() + "\n");

		// Iterate over each function block and append it to output string
		for (String name : fbNames) {
			FunctionBlock functionBlock = getFunctionBlock(name);
			out.append(functionBlock.toStringCpp());
		}

		// Main method
		out.append("int main(int argc, char *argv[]) {\n");

		// Create function blocks
		out.append("\t// Create function blocks\n");
		for (String name : fbNames)
			out.append("\tFunctionBlock_" + name + " " + name + ";\n");
		out.append("\n");

		// Assign values
		out.append("\t// Parse input\n");
		int inVar = 1;
		for (String name : fbNames) {
			FunctionBlock functionBlock = getFunctionBlock(name);
			for (Variable var : functionBlock.variablesSorted()) {
				if (var.isInput()) {
					out.append("\tif( argc > " + inVar + " ) { " + name + "." + var.getName() + " = atof(argv[" + inVar + "]); }\n");
					inVar++;
				}
			}
		}
		out.append("\n");

		// Calculate
		out.append("\t// Calculate\n");
		for (String name : fbNames)
			out.append("\t" + name + ".calc();\n");
		out.append("\n");

		// Show results
		out.append("\t// Show results\n");
		for (String name : fbNames)
			out.append("\t" + name + ".print();\n");
		out.append("}");

		return out.toString();
	}

	@Override
	public String toStringFcl() {
		StringBuffer out = new StringBuffer();

		// Sort function blocks by name
		ArrayList<String> al = new ArrayList<String>(functionBlocks.keySet());
		Collections.sort(al);

		// Iterate over each function block and append it to output string
		for (String name : al) {
			FunctionBlock functionBlock = getFunctionBlock(name);
			out.append(functionBlock.toStringFcl());
		}

		return out.toString();
	}

}
