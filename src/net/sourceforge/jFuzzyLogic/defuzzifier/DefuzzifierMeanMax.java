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
			if( values[i] >= max ) 
				max = values[i];
		}

		// No max? => this variable has no active antecedent
		if( max <= 0 ) return Double.NaN;

		// Calculate mean of max
		boolean isFirstMax = false;
		int startOfMax= 0;
		for( int i = 0; i < values.length; i++ ) {
			if( values[i] == max ) {
				if(isFirstMax == false){
					isFirstMax= true;
//					minOfMax = values[i];
					startOfMax = i;
//					System.out.println("Start: "+startOfMax);
				}
//				maxX = min + stepSize * i; 
				maxX = i;
//				maxX += i;
				count++;
			}
		}

//		System.out.println("Finish: "+maxX);

		// Return mean of max
		int middleI = (int) ((maxX + startOfMax) / 2);
//		System.out.println("Middle I: "+middleI);
	
		return min + stepSize * middleI;
	}

	@Override
	public String toStringFcl() {
		return "METHOD : MM;";
	}
}
