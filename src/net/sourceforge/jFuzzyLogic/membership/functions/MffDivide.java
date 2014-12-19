package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical funcion
 * Function: Divide(x1,x2,x3....xn) = x1 / x2 / x3 / ... / xn  
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffDivide extends MffFunction {

	/**
	 * Constructor
	 */
	public MffDivide(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		double calc = Double.NaN;
		for( int i = 0; i < values.length; i++ )
			if( !Double.isNaN(values[i]) ) if( Double.isNaN(calc) ) calc = values[i]; // Set first argument (divisor)
			else calc /= values[i]; // Divide by dividends
		return calc;
	}

	public String toStringFcl() {
		if( terms == null ) return "";
		String out = "";
		for( int i = 0; i < terms.length; i++ ) {
			out += terms[i].toStringFcl();
			if( i < terms.length - 1 ) out += " / ";
		}

		return "( " + out + " )";
	}

}
