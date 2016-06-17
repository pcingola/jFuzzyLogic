package net.sourceforge.jFuzzyLogic.defuzzifier;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Mean of maxima defuzzyfier
 * @author pcingola@users.sourceforge.net
 */
public class DefuzzifierMeanMax extends DefuzzifierContinuous {

	public DefuzzifierMeanMax(Variable variable) {
		super(variable);
	}

	/** Deffuzification function */
	@Override
	public double defuzzify() {
		double max = 0, maxX = 0;
		int count = 0;

		// Calculate max
		for( int i = 0; i < values.length; i++ ) {
			if( values[i] >= max ) max = values[i];
		}

		// No max? => this variable has no active antecedent
		if( max <= 0 ) return Double.NaN;

		// Calculate mean of max
		for( int i = 0; i < values.length; i++ ) {
			if( values[i] == max ) {
				maxX += min + stepSize * i;
				count++;
			}
		}

		// Return mean of max
		return maxX / count;

	}

	@Override
	public String toStringFcl() {
		return "METHOD : MM;";
	}
}
