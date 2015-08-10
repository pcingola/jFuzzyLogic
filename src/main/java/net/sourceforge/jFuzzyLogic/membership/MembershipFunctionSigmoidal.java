package net.sourceforge.jFuzzyLogic.membership;

/**
 * Sigmoidal membership function
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionSigmoidal extends MembershipFunctionContinuous {

	/**
	 * Constructor 
	 * @param gain : Mean 
	 * @param t0 : Standard deviation
	 */
	public MembershipFunctionSigmoidal(Value gain, Value t0) {
		super();

		// Initialize
		parameters = new Value[2];
		parameters[0] = gain;
		parameters[1] = t0;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if (!checkParamters(errors)) throw new RuntimeException(errors.toString());
	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;
		// No checking needed
		return ok;
	}

	@Override
	public void estimateUniverse() {
		// Are universeMin and universeMax already set? => nothing to do
		if ((!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax))) return;
		universeMin = parameters[1].getValue() - 9.0 / Math.abs(parameters[0].getValue());
		universeMax = parameters[1].getValue() + 9.0 / Math.abs(parameters[0].getValue());
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		return 1.0 / (1.0 + Math.exp(-parameters[0].getValue() * (in - parameters[1].getValue())));
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + " : " + parameters[0] + " , " + parameters[1];
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		return "SIGM " + parameters[0] + " " + parameters[1];
	}
}
