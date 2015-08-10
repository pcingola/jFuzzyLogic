package net.sourceforge.jFuzzyLogic.membership;

import java.util.Iterator;
import java.util.Set;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.membership.functions.MffAbs;
import net.sourceforge.jFuzzyLogic.membership.functions.MffCos;
import net.sourceforge.jFuzzyLogic.membership.functions.MffDivide;
import net.sourceforge.jFuzzyLogic.membership.functions.MffExp;
import net.sourceforge.jFuzzyLogic.membership.functions.MffFunction;
import net.sourceforge.jFuzzyLogic.membership.functions.MffLn;
import net.sourceforge.jFuzzyLogic.membership.functions.MffLog;
import net.sourceforge.jFuzzyLogic.membership.functions.MffModulus;
import net.sourceforge.jFuzzyLogic.membership.functions.MffNop;
import net.sourceforge.jFuzzyLogic.membership.functions.MffPow;
import net.sourceforge.jFuzzyLogic.membership.functions.MffSin;
import net.sourceforge.jFuzzyLogic.membership.functions.MffSubstract;
import net.sourceforge.jFuzzyLogic.membership.functions.MffSum;
import net.sourceforge.jFuzzyLogic.membership.functions.MffTan;
import net.sourceforge.jFuzzyLogic.membership.functions.MffTimes;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import org.antlr.runtime.tree.Tree;

/**
 * Membership function that is a (simple) mathematical funcion (the result is a singleton)
 *
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionFuncion extends MembershipFunctionDiscrete {

	/** Function implemented by this node */
	protected MffFunction function;

	/**
	 * Constructor for a whole AST (tree)
	 */
	public MembershipFunctionFuncion(FunctionBlock functionBlock, Tree tree) {
		super();

		// Add parameters (use first parameter as X vale and second as Y value (same as MembershipFunctionSingleton)
		parameters = new Value[2];
		for (int i = 0; i < parameters.length; i++)
			parameters[i] = new Value();

		//---
		// Create function tree
		//---
		FclObject fun = createFuncionTree(functionBlock, tree);

		// First item (tree's root) is a function? => Ok add tree
		if (fun instanceof MffFunction) function = (MffFunction) fun;
		else {
			// First item is NOT a function (e.g. a variable or a double)? => Make it a function (using 'Nop')
			FclObject args[] = new FclObject[1];
			args[0] = fun;
			function = new MffNop(functionBlock, args);
		}
	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		// Gpr.warn("NOT IMPLEMENTED!");
		return true;
	}

	/**
	 * Create a tree o functions (MffFunction)
	 * @param functionBlock Fuzzy Set for this function
	 * @param tree : AST (tree) to parse
	 * @return A tree of MffFunctions. Each leave can be either a function, a value (Double), a Variable or a Variable's name.
	 */
	private FclObject createFuncionTree(FunctionBlock functionBlock, Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		String treeName = tree.getText().toUpperCase();

		// Select appropriate function (and create it)
		if (treeName.equals("+")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffSum(functionBlock, terms);
		} else if (treeName.equals("-")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffSubstract(functionBlock, terms);
		} else if (treeName.equals("*")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffTimes(functionBlock, terms);
		} else if (treeName.equals("/")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffDivide(functionBlock, terms);
		} else if (treeName.equals("^")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffPow(functionBlock, terms);
		} else if (treeName.equals("%")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffModulus(functionBlock, terms);
		} else if (treeName.equalsIgnoreCase("exp")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffExp(functionBlock, terms);
		} else if (treeName.equalsIgnoreCase("ln")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffLn(functionBlock, terms);
		} else if (treeName.equalsIgnoreCase("log")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffLog(functionBlock, terms);
		} else if (treeName.equalsIgnoreCase("sin")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffSin(functionBlock, terms);
		} else if (treeName.equalsIgnoreCase("cos")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffCos(functionBlock, terms);
		} else if (treeName.equalsIgnoreCase("tan")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffTan(functionBlock, terms);
		} else if (treeName.equalsIgnoreCase("abs")) {
			FclObject terms[] = parseTerms(functionBlock, tree);
			return new MffAbs(functionBlock, terms);
		} else {
			// Parse it as a 'Value'
			return new Value(tree, functionBlock);
		}
	}

	@Override
	public void estimateUniverse() {
		double val = 0;
		if (function != null) val = function.evaluate();
		universeMin = universeMax = val;
	}

	@Override
	public Set<Variable> findVariables() {
		return function.findVariables();
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete#iterator()
	 */
	@Override
	public Iterator<Double> iterator() {
		return new Iterator<Double>() {

			int i = 0;

			@Override
			public boolean hasNext() {
				return (i == 0);
			}

			@Override
			public Double next() {
				return parameters[0].getValue();
			}

			@Override
			public void remove() {
			}
		};
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		double x = function.evaluate();
		if (in == x) return 1.0;
		return 0;
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete#membership(int)
	 */
	@Override
	public double membership(int index) {
		if (index == 0) return 1.0;
		return 0;
	}

	/**
	 * Parse each term (from tree) creating appropriate functions.
	 *
	 * @param ruleBlock Fuzzy Set for this function
	 * @param tree : AST (tree) to parse
	 * @return An array of objects (terms[])
	 */
	private FclObject[] parseTerms(FunctionBlock functionBlock, Tree tree) {
		if (debug) Gpr.debug("Tree:" + tree.toStringTree());

		Tree child = tree.getChild(0);
		int numberOfChilds = tree.getChildCount();
		FclObject terms[] = new FclObject[numberOfChilds];

		for (int i = 0; i < numberOfChilds; i++) {
			child = tree.getChild(i);
			if (debug) Gpr.debug("\t\tChild:" + child.toStringTree());
			terms[i] = createFuncionTree(functionBlock, child);
		}

		return terms;
	}

	/** It's only one singleton */
	@Override
	public int size() {
		return 1;
	}

	@Override
	public String toString() {
		return getName() + ": " + function.toString();
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		return "FUNCTION " + function.toString();
	}

	@Override
	public double valueX(int index) {
		if (index == 0) {
			// Evaluate function
			double eval = function.evaluate();
			if (debug) Gpr.debug("Evaluation: " + function + "\t=>\t" + eval);

			// Update 'singleton' value
			parameters[0].setValue(eval);
			parameters[1].setValue(1.0);

			return eval;
		}
		throw new RuntimeException("Array index out of range: " + index);
	}
}
