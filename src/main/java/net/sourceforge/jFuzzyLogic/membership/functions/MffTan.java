package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical funcion
 * Function: tan(x1)
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffTan extends MffFunction {

	/** Constructor */
	public MffTan(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		if( values.length != 1 ) throw new RuntimeException("Function Exp needs only one argument: tan(x)");
		return Math.tan(values[0]);
	}

	@Override
	public String toStringFcl() {
		if( terms == null ) return "";
		return "tan( " + terms[0].toStringFcl() + " )";
	}

}
