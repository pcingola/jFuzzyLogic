package net.sourceforge.jFuzzyLogic.defuzzifier;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Center of gravity for singletons defuzzyfier
 * @author pcingola@users.sourceforge.net
 */
public class DefuzzifierCenterOfGravitySingletons extends DefuzzifierDiscrete {

	public DefuzzifierCenterOfGravitySingletons(Variable variable) {
		super(variable);
	}

	/** Deffuzification function */
	@Override
	public double defuzzify() {
		double x, y, sum = 0, sumWeight = 0;
		for( Double xD : this ) {
			y = getDiscreteValue(xD);
			x = xD;
			sumWeight += x * y;
			sum += y;
		}

		if( sum != 0 ) return sumWeight / sum;
		return Double.NaN;
	}

	@Override
	public String toStringFcl() {
		return "METHOD : COGS;";
	}
}
