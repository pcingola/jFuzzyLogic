package net.sourceforge.jFuzzyLogic.fcl;

import net.sourceforge.jFuzzyLogic.CompileCpp;

/**
 * The root of all FCL objects
 * 
 * @author pcingola
 *
 */
public abstract class FclObject implements CompileCpp {

	@Override
	public String toString() {
		return toStringFcl();
	}

	@Override
	public String toStringCpp() {
		return "// " + this.getClass().getName();
	}

	public abstract String toStringFcl();
}
