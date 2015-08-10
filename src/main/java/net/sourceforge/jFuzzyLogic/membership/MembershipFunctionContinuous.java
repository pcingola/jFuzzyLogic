package net.sourceforge.jFuzzyLogic.membership;

/**
 * Base continuous membership function
 * @author pcingola@users.sourceforge.net
 */
public abstract class MembershipFunctionContinuous extends MembershipFunction {

	/**
	 * Default constructor 
	 */
	public MembershipFunctionContinuous() {
		super();
		discrete = false;
	}

}
