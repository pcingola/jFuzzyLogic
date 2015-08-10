package net.sourceforge.jFuzzyLogic.defuzzifier;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Center of area defuzzyfier (bisector)
 * @author pcingola@users.sourceforge.net
 */
public class DefuzzifierCenterOfArea extends DefuzzifierContinuous {

	public DefuzzifierCenterOfArea(Variable variable) {
		super(variable);
	}

	/** Deffuzification function */
	public double defuzzify() {
		double sumLow = 0, sumHigh = 0;
		int low, hi;

		// Calculate lower and upper sums (approximating integrals). 
		// Center of area is where integrals (sums) are equal
		for( low = 0, hi = values.length - 1; low < hi; ) {
			if( sumLow <= sumHigh ) {
				low++;
				sumLow += values[low];
			} else {
				hi--;
				sumHigh += values[hi];
			}
		}

		// No sum / integrals? => this variable has no active antecedent
		if( sumLow <= 0 ) return Double.NaN;

		// Calculate center of area point (either 'low' or 'high' should be the same)
		return min + stepSize * low;
	}

	public String toStringFcl() {
		return "METHOD : COA;";
	}
}
