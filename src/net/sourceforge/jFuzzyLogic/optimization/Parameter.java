package net.sourceforge.jFuzzyLogic.optimization;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Representation of a parameter (that may be optimized using some optimization algorithm)
 * 
 * @author pcingola@users.sourceforge.net
 */
public abstract class Parameter {

	public static double UNIVERSE_TO_EPSILON_RATIO = 1000; // How we get 'epsilon' (to be used to calculate partial derivative) from universe 

	double epsilon; // A small number (e.g used to calculate derivatives) 
	String name; // Paramter's name

	/**
	 * Create a list of parameters 
	 * @return A list of parameters
	 */
	public static ArrayList<Parameter> parameters(RuleBlock ruleBlock) {
		ArrayList<Parameter> parameterList = new ArrayList<Parameter>();

		// Add variable's membership functions' parameters
		for (Variable variable : ruleBlock.getFunctionBlock().variables())
			parameterList.addAll(parametersMembershipFunction(variable));

		// Add rule's weights
		for (Rule rule : ruleBlock.getRules())
			parameterList.addAll(parametersRuleWeight(rule));

		return parameterList;
	}

	/**
	 * Add variable's membership functions' parameters to a list
	 * @param parameterList : Paramter's list
	 * @param variable : Variable whose parameters will be added to the list
	 */
	public static List<Parameter> parametersMembershipFunction(Variable variable) {
		double epsilon;
		ArrayList<Parameter> parameterList = new ArrayList<Parameter>();

		//---
		// Add variable's membership functions' parameters
		//---
		// Iterate over each linguistic term
		for (String termName : variable.getLinguisticTerms().keySet()) {
			LinguisticTerm linguisticTerm = variable.getLinguisticTerm(termName);
			// Get membership function
			MembershipFunction membershipFunction = linguisticTerm.getMembershipFunction();

			// Guess epsilon
			membershipFunction.estimateUniverse();
			double delta = membershipFunction.getUniverseMax() - membershipFunction.getUniverseMin();
			if (delta == 0) delta = variable.getUniverseMax() - variable.getUniverseMin();
			epsilon = delta / UNIVERSE_TO_EPSILON_RATIO;

			// Iterate over each membership funciotn's parameter
			for (int i = 0; i < membershipFunction.getParametersLength(); i++) {
				String paramName = variable.getName() + "_" + linguisticTerm.getTermName() + "_" + membershipFunction.getName() + "_" + i;
				ParameterMembershipFunction param = new ParameterMembershipFunction(paramName, epsilon, variable, membershipFunction, i);
				parameterList.add(param);
			}
		}

		return parameterList;
	}

	/**
	 * Add rule's weight parameters to a list
	 * @param parameterList : Paramter's list
	 * @param fuzzyRule : Rule whose parameters will be added to the list
	 */
	public static List<Parameter> parametersRuleWeight(Rule fuzzyRule) {
		ArrayList<Parameter> parameterList = new ArrayList<Parameter>();

		double epsilon = 0.01; // Default 'epsilon' for rules is 1/100
		String paramName = "Rule_" + fuzzyRule.getName();
		ParameterRuleWeight param = new ParameterRuleWeight(paramName, epsilon, fuzzyRule);
		parameterList.add(param);

		return parameterList;
	}

	/**
	 * Default constructor
	 * @param name : Parameter's name
	 * @param epsilon : A small number (e.g used to calculate derivates) 
	 */
	public Parameter(String name, double epsilon) {
		this.name = name;
		this.epsilon = epsilon;
	}

	/** Get a paramter's value */
	public abstract double get();

	public double getEpsilon() {
		return epsilon;
	}

	public String getName() {
		return name;
	}

	/**
	 * Sets parameter to 'value'
	 * @param value
	 * @return 'true' if set ok, 'false if can't be set (e.g. due to consistenci errors, out of range, etc.)
	 */
	public abstract boolean set(double value);

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + ": " + get();
	}

}
