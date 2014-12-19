package net.sourceforge.jFuzzyLogic.ruleAccumulationMethod;

/**
 * Rule accumulation mathod: Sum
 * @author pcingola@users.sourceforge.net
 */
public class RuleAccumulationMethodBoundedSum extends RuleAccumulationMethod {

	public RuleAccumulationMethodBoundedSum() {
		super();
		name = "bsum";
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethod#aggregate(double, double)
	 */
	public double aggregate(double defuzzifierValue, double valueToAggregate) {
		return Math.min(1.0, defuzzifierValue + valueToAggregate);
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethod#toStringFcl()
	 */
	public String toStringFcl() {
		return "ACCU : BSUM;";
	}
}
