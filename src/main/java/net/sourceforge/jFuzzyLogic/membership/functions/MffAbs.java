package net.sourceforge.jFuzzyLogic.membership.functions;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Membership function that is a (simple) mathematical funcion
 * Function: abs(x1)
 * 
 * @author pcingola@users.sourceforge.net
 */
public class MffAbs extends MffFunction {

	/** Constructor */
	public MffAbs(FunctionBlock functionBlock, FclObject terms[]) {
		super(functionBlock, terms);
	}

	@Override
	protected double evaluateFunction() {
		if( values.length != 1 ) throw new RuntimeException("Function Abs needs only one argument: abs(x)");
		return Math.abs(values[0]);
	}

	@Override
	public String toStringFcl() {
		if( terms == null ) return "";
		return "abs( " + terms[0].toStringFcl() + " )";
	}

}
