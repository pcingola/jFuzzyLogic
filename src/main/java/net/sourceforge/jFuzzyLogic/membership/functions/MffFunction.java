package net.sourceforge.jFuzzyLogic.membership.functions;

import java.util.HashSet;
import java.util.Set;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.membership.Value;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Membership function that is a (simple) mathematical function
 * (Mff stands for 'Membership Function type Function').
 *
 * Implements a mathematical function that depends on variables (should
 * be input variables only, to avoid some sort of 'race conditions').
 *
 * @author pcingola@users.sourceforge.net
 */
public abstract class MffFunction extends FclObject {

	/** Debug mode? */
	public static boolean debug = false;

	/** Function block related to this function (need it to look up variables) */
	FunctionBlock functionBlock;

	/** Function terms (they can be either MembershipFunctionFuncion or Variable) */
	protected FclObject terms[];

	/** Evaluated values for each term */
	protected double values[];

	/**
	 * Default (hidden) constructor
	 */
	public MffFunction(FunctionBlock functionBlock, FclObject terms[]) {
		this.functionBlock = functionBlock;
		this.terms = terms;
		values = new double[terms.length];
	}

	/**
	 * Get function's result (after evaluation)
	 * @return A double (function's result)
	 */
	public double evaluate() {
		if (debug) Gpr.debug("Evaluating: " + this);
		evaluateTerms();
		return evaluateFunction();
	}

	/**
	 * Evaluate this function
	 * @return double
	 */
	protected abstract double evaluateFunction();

	/**
	 * Evaluate each function's term
	 */
	protected void evaluateTerms() {
		// Evaluate each term
		for (int i = 0; i < terms.length; i++) {
			if (terms[i] == null) // Null function => Nothing to do
			values[i] = Double.NaN;
			else if (terms[i] instanceof Variable) {
				// Variable's value
				Variable var = ((Variable) terms[i]);
				if (var.isOutput()) throw new RuntimeException("Can't use an output variable '" + var.getName() + "' for a function (It may create a race condition)");
				values[i] = var.getValue();
			} else if (terms[i] instanceof Value) {
				Value term = (Value) terms[i];
				values[i] = term.getValue();
			} else if (terms[i] instanceof MffFunction) {
				// Function's value
				MffFunction mff = (MffFunction) terms[i]; // Get function
				mff.evaluateTerms(); // Evaluate function's terms (recurse into tree)
				values[i] = mff.evaluateFunction(); // Evaluate function
				if (debug) Gpr.debug("Evaluated: " + mff + " = " + values[i]);
			}
			if (debug) Gpr.debug("Term[" + i + "]: " + terms[i] + "\tClass:" + terms[i].getClass().getSimpleName() + "\tValue: " + values[i]);
		}
	}

	public Set<Variable> findVariables() {
		HashSet<Variable> vars = new HashSet<Variable>();

		if (terms != null) {
			for (FclObject fco : terms) {
				if (fco instanceof Variable) {
					vars.add((Variable) fco);
				} else if (fco instanceof Value) {
					Value val = (Value) fco;
					if (val.getType() == Value.Type.VAR_REFERENCE && val.getVarRef() != null) vars.add(val.getVarRef());
				} else if (fco instanceof MffFunction) {
					vars.addAll(((MffFunction) fco).findVariables());
				}
			}
		}

		return vars;

	}

	@Override
	public String toStringCpp() {
		if (terms == null) return "";
		String out = this.getClass().getSimpleName() + "(";
		for (int i = 0; i < terms.length; i++) {
			out += terms[i].toStringFcl();
			if (i < terms.length - 1) out += ", ";
		}

		return out + ")";
	}

	@Override
	public String toStringFcl() {
		if (terms == null) return "";
		String out = this.getClass().getSimpleName() + "(";
		for (int i = 0; i < terms.length; i++) {
			out += terms[i].toStringFcl();
			if (i < terms.length - 1) out += ", ";
		}

		return out + ")";
	}
}
