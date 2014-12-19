package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical funcion
 * Function: cos(x1)
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffCos extends MffFunction {

	/** Constructor */
	public MffCos(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		if( values.length != 1 ) throw new RuntimeException("Function Exp needs only one argument: cos(x)");
		return Math.cos(values[0]);
	}

	@Override
	public String toStringFcl() {
		if( terms == null ) return "";
		return "cos( " + terms[0].toStringFcl() + " )";
	}

}
