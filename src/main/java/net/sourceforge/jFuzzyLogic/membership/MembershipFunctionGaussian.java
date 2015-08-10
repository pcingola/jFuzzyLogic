package net.sourceforge.jFuzzyLogic.membership;

/**
 * Gaussian membership function
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionGaussian extends MembershipFunctionContinuous {

	/**
	 * Constructor 
	 * @param mean : Mean 
	 * @param stdev : Standardt deviation
	 */
	public MembershipFunctionGaussian(Value mean, Value stdev) {
		super();

		// Initialize
		parameters = new Value[2];
		parameters[0] = mean;
		parameters[1] = stdev;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if( !checkParamters(errors) ) throw new RuntimeException(errors.toString());

	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;

		if( parameters[1].getValue() < 0 ) {
			ok = false;
			if( errors != null ) errors.append("Parameter 'stdev' should be greater than zero : " + parameters[1] + "\n");
		}

		return ok;
	}

	@Override
	public void estimateUniverse() {
		// Are universeMin and universeMax already set? => nothing to do
		if( (!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax)) ) return;
		universeMin = parameters[0].getValue() - 4.0 * parameters[1].getValue();
		universeMax = parameters[0].getValue() + 4.0 * parameters[1].getValue();
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		return Math.exp(-(in - parameters[0].getValue()) * (in - parameters[0].getValue()) / (2 * parameters[1].getValue() * parameters[1].getValue()));
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
		return "GAUSS " + parameters[0] + " " + parameters[1];
	}
}
