package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical function
 * Function: Sum(x1,x2,x3,...,xn) = x1 + x2 + x3 + ... + xn 
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffSum extends MffFunction {

	/**
	 * Constructor
	 */
	public MffSum(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		double sum = 0;
		for( int i = 0; i < values.length; i++ )
			if( !Double.isNaN(values[i]) ) sum += values[i];

		return sum;
	}

	public String toStringFcl() {
		if( terms == null ) return "";
		String out = "";
		for( int i = 0 ; i < terms.length ; i++ ) {
			out += terms[i].toStringFcl();
			if( i < terms.length -1 ) out += " + ";
 		}
		
		return "( " + out + " )";
	}

}
