package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical funcion
 * Function: Substract(x1,x2,x3....xn) = x1 - x2 - x3 - .... - xn  
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffSubstract extends MffFunction {

	/**
	 * Constructor
	 */
	public MffSubstract(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		double sum = Double.NaN;
		for( int i = 0; i < values.length; i++ )
			if( !Double.isNaN(values[i]) ) if( Double.isNaN(sum) ) sum = values[i]; // Set first (non-NaN) value 
			else sum -= values[i]; // Substract other values from first one

		// Only one term => it's negative (e.g. "- 5" )
		if( values.length == 1 ) sum *= -1;

		return sum;
	}

	@Override
	public String toStringFcl() {
		if( terms == null ) return "";

		// Only one term? => It's negative (e.g. "- 5") 
		if( terms.length == 1 ) return "( - " + terms[0].toStringFcl() + " )";

		// Show every term
		String out = "";
		for( int i = 0; i < terms.length; i++ ) {
			out += terms[i].toStringFcl();
			if( i < terms.length - 1 ) out += " - ";
		}

		return "( " + out + " )";
	}

}
