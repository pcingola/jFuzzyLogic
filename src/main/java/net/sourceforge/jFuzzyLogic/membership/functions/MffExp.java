package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical funcion
 * Function: Exp(x1) = e^x1   
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffExp extends MffFunction {

	/** Constructor */
	public MffExp(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		if( values.length != 1 ) throw new RuntimeException("Function Exp needs only one argument: exp(x)");
		return Math.exp(values[0]);
	}

	public String toStringFcl() {
		if( terms == null ) return "";
		return "exp( " + terms[0].toStringFcl() + " )";
	}

}
