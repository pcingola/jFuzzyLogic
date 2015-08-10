package net.sourceforge.jFuzzyLogic.membership;

/**
 * Difference sigmoidal membership function
 * @author yuanhao.li@gmail.com
 */

public class MembershipFunctionDifferenceSigmoidal extends MembershipFunctionContinuous {

	/**
	 * Constructor
	 * @param a1 : Standard deviation 1
	 * @param c1 : Mean 1
	 * @param a2 : Standard deviation 2
	 * @param c2 : Mean 2
	 */
	public MembershipFunctionDifferenceSigmoidal(Value a1, Value c1, Value a2, Value c2) {
		super();

		//Initialize
		parameters = new Value[4];
		parameters[0] = a1;
		parameters[1] = c1;
		parameters[2] = a2;
		parameters[3] = c2;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if( !checkParamters(errors) ) throw new RuntimeException(errors.toString());
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
		if( (!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax)) ) return;
		double min1 = parameters[1].getValue() - 9.0 / Math.abs(parameters[0].getValue());
		double max1 = parameters[1].getValue() + 9.0 / Math.abs(parameters[0].getValue());
		double min2 = parameters[3].getValue() - 9.0 / Math.abs(parameters[2].getValue());
		double max2 = parameters[3].getValue() + 9.0 / Math.abs(parameters[2].getValue());

		if( min1 < min2 ) universeMin = min1;
		else universeMin = min2;

		if( max1 > max2 ) universeMax = max1;
		else universeMax = max2;
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		double sigm1 = 1.0 / (1.0 + Math.exp(-parameters[0].getValue() * (in - parameters[1].getValue())));
		double sigm2 = 1.0 / (1.0 + Math.exp(-parameters[2].getValue() * (in - parameters[3].getValue())));
		double diff = sigm1 - sigm2;
		return Math.max(diff, 0.0 );
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + " : " + parameters[0] + " , " + parameters[1] + " , " + parameters[2] + " , " + parameters[3];
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		return "DSIGM " + parameters[0] + " " + parameters[1] + " " + parameters[2] + " " + parameters[3];
	}
}
