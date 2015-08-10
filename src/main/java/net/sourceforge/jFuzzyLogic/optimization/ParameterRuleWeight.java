package net.sourceforge.jFuzzyLogic.optimization;

import net.sourceforge.jFuzzyLogic.rule.Rule;

/**
 * Representation of a parameter (that may be optimized using some optimization algorithm)
 * Rule's weight parameter
 * 
 * @author pcingola@users.sourceforge.net
 */
public class ParameterRuleWeight extends Parameter {

	Rule fuzzyRule;

	/**
	 * Default constructor
	 * @param name : Parameter's name
	 * @param epsilon : A small number (e.g used to calculate derivates) 
	 * @param fuzzyRule : Fuzzy rule this parameter refers to.
	 */
	public ParameterRuleWeight(String name, double epsilon, Rule fuzzyRule) {
		super(name, epsilon);
		this.fuzzyRule = fuzzyRule;
	}

	@Override
	public double get() {
		return fuzzyRule.getWeight();
	}

	public Rule getFuzzyRule() {
		return fuzzyRule;
	}

	@Override
	public boolean set(double value) {
		boolean ok = true;

		if( value > 1.0 ) { // Out of range? 
			value = 1.0;
			ok = false;
		} else if( value < 0 ) { // Out of range? 
			value = 0;
			ok = false;
		}

		fuzzyRule.setWeight(value);
		return ok;
	}

	public void setFuzzyRule(Rule fuzzyRule) {
		this.fuzzyRule = fuzzyRule;
	}

}
