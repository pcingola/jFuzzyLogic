package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical funcion
 * Function: Pow(x1,x2) = x1 ^ x2
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffPow extends MffFunction {

	/**
	 * Constructor
	 */
	public MffPow(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		if( values.length != 2 ) throw new RuntimeException("Function Pow needs two (and only two) arguments: x ^ y");
		return Math.pow(values[0], values[1]);
	}

	@Override
	public String toStringFcl() {
		if( terms == null ) return "";
		return "( " + terms[0].toStringFcl() + " ^ (" + terms[1].toStringFcl() + "))";
	}

}
