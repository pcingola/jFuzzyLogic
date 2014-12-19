package net.sourceforge.jFuzzyLogic.defuzzifier;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Right Most Max defuzzyfier
 * @author pcingola@users.sourceforge.net
 */
public class DefuzzifierRightMostMax extends DefuzzifierContinuous {

	public DefuzzifierRightMostMax(Variable variable) {
		super(variable);
	}

	/** Deffuzification function */
	@Override
	public double defuzzify() {
		double max = 0, maxX = 0;

		// Find last max
		for( int i = 0; i < values.length; i++ ) {
			if( values[i] >= max ) {
				max = values[i];
				maxX = min + stepSize * i;
			}
		}

		// No max? => this variable has no active antecedent
		if( max <= 0 ) return Double.NaN;

		return maxX;

	}

	@Override
	public String toStringFcl() {
		return "METHOD : RM;";
	}
}
