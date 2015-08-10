package net.sourceforge.jFuzzyLogic.ruleAccumulationMethod;

import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Rule accumulation base method
 * 
 * From FCL's definition:
 * "The results of the rules are combined to obtain an overall result. The maximum algorithm is usually 
 * used for accumulation. 
 * Depending on the combination of operators in the individual steps, different inference strategies are 
 * obtained. The best-known are the so-called MaxMin Inference and MaxProd Inference, which use the 
 * maximum for accumulation and the minimum or the algebraic product for activation. In the case of the 
 * MaxMin Inference, the membership functions of the Fuzzy Sets of the conclusions are limited to the 
 * degree of accomplishment of the condition and then, in turn, combined to create a Fuzzy Set by 
 * forming a maximum. In MaxProd Inference, in contrast, the membership functions of the Fuzzy Sets 
 * of the conclusions are weighted, i.e. multiplied, with the degree of accomplishment of the condition 
 * and then combined."
 * 
 * @author pcingola@users.sourceforge.net
 */
public abstract class RuleAccumulationMethod extends FclObject {

	String name;

	public RuleAccumulationMethod() {
		super();
		name = "Undefined name! (Please set it up in constructor)";
	}

	/**
	 * Aggregate a 'valueToAggregate' to a 'defuzzifierValue'  
	 * @param defuzzifierValue : defuzzifier's current value
	 * @param valueToAggregate : value to aggregate
	 * @return new defuzzifier's value
	 */
	public abstract double aggregate(double defuzzifierValue, double valueToAggregate);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toStringCpp() {
		return "ruleAccumulationMethod_" + getName();
	}

	public String toStringCppFunction() {
		throw new RuntimeException("Unimplemented method foe class " + this.getClass().getCanonicalName());
	}

	@Override
	public String toStringFcl() {
		return getName();
	}
}
