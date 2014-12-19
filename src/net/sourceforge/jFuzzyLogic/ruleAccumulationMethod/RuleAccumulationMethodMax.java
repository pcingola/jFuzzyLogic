package net.sourceforge.jFuzzyLogic.ruleAccumulationMethod;

/**
 * Rule accumulation mathod: Max
 * @author pcingola@users.sourceforge.net
 */
public class RuleAccumulationMethodMax extends RuleAccumulationMethod {

	public RuleAccumulationMethodMax() {
		super();
		name = "max";
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethod#aggregate(double, double)
	 */
	@Override
	public double aggregate(double defuzzifierValue, double valueToAggregate) {
		return Math.max(defuzzifierValue, valueToAggregate);
	}

	@Override
	public String toStringCppFunction() {
		return "double " + toStringCpp() + "(double defuzzifierValue, double valueToAggregate)\t{ return ( defuzzifierValue > valueToAggregate ? defuzzifierValue : valueToAggregate ); }\n";
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethod#toStringFcl()
	 */
	@Override
	public String toStringFcl() {
		return "ACCU : MAX;";
	}

}
