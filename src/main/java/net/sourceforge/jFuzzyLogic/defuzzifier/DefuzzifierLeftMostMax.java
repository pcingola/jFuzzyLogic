package net.sourceforge.jFuzzyLogic.defuzzifier;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Leftmost maxima defuzzyfier
 * @author pcingola@users.sourceforge.net
 */
public class DefuzzifierLeftMostMax extends DefuzzifierContinuous {

	public DefuzzifierLeftMostMax(Variable variable) {
		super(variable);
	}

	/** Deffuzification function */
	public double defuzzify() {
		double max = 0, maxX = 0;

		// Find first max
		for( int i = 0; i < values.length; i++ ) {
			if( values[i] > max ) {
				max = values[i];
				maxX = min + stepSize * i;
			}
		}

		// No max? => this variable has no active antecedent
		if( max <= 0 ) return Double.NaN;

		return maxX;
	}
	
	public String toStringFcl() {
		return "METHOD : LM;";
	}
}
