package net.sourceforge.jFuzzyLogic.rule;

import java.util.Iterator;
import java.util.LinkedList;

import net.sourceforge.jFuzzyLogic.CompileCpp;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethod;
import net.sourceforge.jFuzzyLogic.ruleActivationMethod.RuleActivationMethod;

/**
 * Fuzzy rule
 * 
 * Rule:	If (x1 is termX1) AND (x2 is termX2) ....  Then (y1 is termY1) AND (y2 is termY2) [weight: 1.0]
 * Notes: 
 * 	- "If" clause is called "antecedent"
 * 	- "then" clause is called "consequent"
 *  - There may be 1 or more antecedents connected using a 'RuleConnectionMethod' (e.g. AND, OR)
 *  - As there are many ways to implement 'AND' and 'OR' connectors, you can customize them 
 * @author pcingola@users.sourceforge.net
 */
public class Rule extends FclObject implements CompileCpp {

	/** Debug mode? */
	public static boolean debug = FIS.debug;

	/** Rule antecedent ('if' part) */
	RuleExpression antecedents;
	/** Rule consequent ('then' part) */
	LinkedList<RuleTerm> consequents;
	/** Degree of support */
	double degreeOfSupport;
	/** Rule's name */
	String name;
	/** Rule's weight */
	double weight;
	/** This rule belongs to ruleBlock */
	RuleBlock ruleBlock;

	/**
	 * Default constructor 
	 * Default weight: 1.0
	 * Default connection method: AND (minimum)
	 */
	public Rule(String name, RuleBlock ruleBlock) {
		antecedents = new RuleExpression();
		consequents = new LinkedList<RuleTerm>();
		weight = 1.0; // Default weight: 1.0
		this.name = name;
		this.ruleBlock = ruleBlock;
	}

	/** 
	 * Add a condition "... AND ( variable is termName)" to this rule 
	 * @param variable : Variable to evaluate
	 * @param termName : RuleTerm for this condition
	 * @return this Rule
	 */
	public Rule addAntecedent(Variable variable, String termName, boolean negated) {
		if (variable.getMembershipFunction(termName) == null) throw new RuntimeException("RuleTerm '" + termName + "' does not exists in variable '" + variable.getName() + "'");
		RuleTerm fuzzyRuleTerm = new RuleTerm(variable, termName, negated);
		antecedents.add(fuzzyRuleTerm);
		return this;
	}

	/** 
	 * Add consequent "( variable is termName)" to this rule
	 * @param variable : Variable to evaluate
	 * @param termName : RuleTerm for this condition
	 * @return this Rule
	 */
	public Rule addConsequent(Variable variable, String termName, boolean negated) {
		if (variable.getMembershipFunction(termName) == null) throw new RuntimeException("RuleTerm '" + termName + "' does not exists in variable '" + variable.getName() + "'");
		consequents.add(new RuleTerm(variable, termName, negated));
		return this;
	}

	/**
	 * Evaluate this rule using 'RuleImplicationMethod'
	 * @param ruleActivationMethod : Rule implication method to use
	 */
	public void evaluate() {
		RuleActivationMethod ruleActivationMethod = ruleBlock.getRuleActivationMethod();

		//---
		// Evaluate antecedents
		//---
		degreeOfSupport = antecedents.evaluate();

		// Apply weight
		degreeOfSupport *= weight;

		//---
		// Imply rule consequents: Apply degreeOfSupport to consequent linguisticTerms
		//---
		RuleAccumulationMethod ruleAccumulationMethod = ruleBlock.getRuleAccumulationMethod();
		if (debug) Gpr.debug("degreeOfSupport:" + degreeOfSupport + "\truleAccumulationMethod:" + ruleAccumulationMethod + "\truleImplicationMethod:" + ruleActivationMethod);
		for (RuleTerm term : consequents) {
			if (debug) Gpr.debug("\tfuzzyRuleTerm:" + term);
			ruleActivationMethod.imply(term, ruleAccumulationMethod, degreeOfSupport);
		}
	}

	public RuleExpression getAntecedents() {
		return antecedents;
	}

	public LinkedList<RuleTerm> getConsequents() {
		return consequents;
	}

	public double getDegreeOfSupport() {
		return degreeOfSupport;
	}

	public String getName() {
		return name;
	}

	public RuleBlock getRuleBlock() {
		return ruleBlock;
	}

	public double getWeight() {
		return weight;
	}

	public void setAntecedents(RuleExpression antecedents) {
		this.antecedents = antecedents;
	}

	public void setConsequents(LinkedList<RuleTerm> consequents) {
		this.consequents = consequents;
	}

	public void setDegreeOfSupport(double degreeOfSupport) {
		this.degreeOfSupport = degreeOfSupport;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRuleBlock(RuleBlock ruleBlock) {
		this.ruleBlock = ruleBlock;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		String strAnt = "", strCon = "";

		// Show antecedents
		strAnt = antecedents.toString();

		// Show consequents
		Iterator<RuleTerm> itc = consequents.iterator();
		while (itc.hasNext()) {
			RuleTerm term = itc.next();
			if (strCon.length() > 0) strCon += " , ";
			strCon += term.toString();
		}

		return name + "\t(" + degreeOfSupport + ")\tif " + strAnt + " then " + strCon + " [weight: " + weight + "]";
	}

	@Override
	public String toStringCpp() {
		RuleActivationMethod ruleActivationMethod = ruleBlock.getRuleActivationMethod();

		StringBuilder sb = new StringBuilder();

		// Show antecedents
		String dosName = "degreeOfSupport_" + name;
		sb.append("\tdouble " + dosName + " = " + weight + " * ( " + antecedents.toStringCpp() + " );\n");

		// Accumulate & activate
		RuleAccumulationMethod ruleAccumulationMethod = ruleBlock.getRuleAccumulationMethod();
		for (RuleTerm term : consequents)
			sb.append(ruleActivationMethod.toStringCpp(term, ruleAccumulationMethod, dosName) + "\n");

		return sb.toString();
	}

	@Override
	public String toStringFcl() {
		String strAnt = "", strCon = "";

		// Show antecedents
		strAnt = antecedents.toString();

		// Show consequents
		for (RuleTerm term : consequents) {
			if (strCon.length() > 0) strCon += " , ";
			strCon += term.toString();
		}

		return "IF " + strAnt + " THEN " + strCon + (weight != 1.0 ? " WITH " + weight : "") + ";";
	}

}
