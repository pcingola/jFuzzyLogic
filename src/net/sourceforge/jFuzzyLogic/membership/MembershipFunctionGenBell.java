package net.sourceforge.jFuzzyLogic.membership;

/**
 * Generalized bell membership function
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionGenBell extends MembershipFunctionContinuous {

	/**
	 * Constructor 
	 * @param a : 'a' param
	 * @param b : 'b' param
	 * @param mean : Mean
	 */
	public MembershipFunctionGenBell(Value a, Value b, Value mean) {
		super();

		// Initialize
		parameters = new Value[3];
		parameters[0] = mean;
		parameters[1] = a;
		parameters[2] = b;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if( !checkParamters(errors) ) throw new RuntimeException(errors.toString());
	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;

		if( parameters[2].getValue() < 0 ) {
			ok = false;
			if( errors != null ) errors.append("Parameter b should be greater than zero: " + parameters[2] + "\n");
		}

		return ok;
	}

	@Override
	public void estimateUniverse() {
		// Are universeMin and universeMax already set? => nothing to do
		if( (!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax)) ) return;

		// When is membership <= 0.001 ?
		double delta = Math.pow(999, 1 / (2 * parameters[2].getValue())) * parameters[1].getValue();
		universeMin = parameters[0].getValue() - delta;
		universeMax = parameters[0].getValue() + delta;
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		double t = Math.abs((in - parameters[0].getValue()) / parameters[1].getValue());
		t = Math.pow(t, 2.0 * parameters[2].getValue());
		return 1.0 / (1.0 + t);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + " : " + " , " + parameters[0] + parameters[1] + " , " + parameters[2];
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		return "GBELL " + parameters[0] + " " + parameters[1] + " " + parameters[2];
	}
}
