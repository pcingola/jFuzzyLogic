package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical funcion
 * Function: Modulus(x1,x2) = x1 % x2   
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffModulus extends MffFunction {

	/** Constructor */
	public MffModulus(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		if( values.length != 2 ) throw new RuntimeException("Function Modulus needs two (and only two) arguments: x ^ y");
		return values[0] % values[1];
	}

	@Override
	public String toStringFcl() {
		if( terms == null ) return "";
		return "( " + terms[0].toStringFcl() + " % " + terms[1].toStringFcl() + " )";
	}

}
