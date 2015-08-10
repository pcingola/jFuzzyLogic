package net.sourceforge.jFuzzyLogic.rule;

import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;

/** 
 * A fuzzy logic term for a 'Rule'. E.g.: "speed IS high"
 * @author pcingola@users.sourceforge.net
 */
public class RuleTerm extends FclObject {

	/** Is it negated? */
	boolean negated;
	/** RuleTerm's name */
	String termName;
	/** Varible */
	Variable variable;

	/**
	 * Constructor 
	 * @param variable
	 * @param term
	 * @param negated
	 */
	public RuleTerm(Variable variable, String term, boolean negated) {
		this.variable = variable;
		termName = term;
		this.negated = negated;
	}

	public LinguisticTerm getLinguisticTerm() {
		return variable.getLinguisticTerm(termName);
	}

	public double getMembership() {
		double memb = variable.getMembership(termName);
		if (negated) memb = 1.0 - memb;
		return memb;
	}

	public MembershipFunction getMembershipFunction() {
		return variable.getMembershipFunction(termName);
	}

	public String getTermName() {
		return termName;
	}

	public Variable getVariable() {
		return variable;
	}

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	public void setTermName(String term) {
		termName = term;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	@Override
	public String toStringCpp() {
		String neg = "";
		if (negated) neg = "1 -";
		return neg + variable.getName() + "_" + termName;
	}

	public String toStringCppDeffName() {
		return getVariable().getName() + "_" + getTermName();
	}

	@Override
	public String toStringFcl() {
		String is = "IS";
		if (negated) is = " IS NOT";
		if (variable == null) return "[ERROR: Variable not found] " + is + " " + termName;
		return variable.getName() + " " + is + " " + termName;
	}

}
