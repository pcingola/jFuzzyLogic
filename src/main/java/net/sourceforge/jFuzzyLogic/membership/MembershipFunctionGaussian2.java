package net.sourceforge.jFuzzyLogic.membership;

/**
 * Combined Gaussian membership function
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionGaussian2 extends MembershipFunctionContinuous {

	/**
	 * Constructor 
	 * @param mean : Mean 
	 * @param stdev : Standardt deviation
	 */
	public MembershipFunctionGaussian2(Value meanl, Value stdevl, Value meanr, Value stdevr) {
		super();

		// Initialize
		parameters = new Value[4];
		parameters[0] = meanl;
		parameters[1] = stdevl;
		parameters[2] = meanr;
		parameters[3] = stdevr;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if (!checkParamters(errors)) throw new RuntimeException(errors.toString());

	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;

		if (parameters[1].getValue() < 0 || parameters[3].getValue() < 0) {
			ok = false;
			if (errors != null) errors.append("Parameters 'stdev' should be greater than zero : " + parameters[1] + " " + parameters[3] + "\n");
		}

		if (parameters[0].getValue() > parameters[2].getValue()) {
			ok = false;
			if (errors != null) errors.append("Parameters 'mean1' should be lower than 'meand2' : " + parameters[0] + " " + parameters[2] + "\n");
		}

		return ok;
	}

	@Override
	public void estimateUniverse() {
		// Are universeMin and universeMax already set? => nothing to do
		if ((!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax))) return;
		universeMin = parameters[0].getValue() - 4.0 * parameters[1].getValue();
		universeMax = parameters[2].getValue() + 4.0 * parameters[3].getValue();
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		if (in < parameters[0].getValue()) {
			return Math.exp(-(in - parameters[0].getValue()) * (in - parameters[0].getValue()) / (2 * parameters[1].getValue() * parameters[1].getValue()));
		} else if (in > parameters[2].getValue()) {
			return Math.exp(-(in - parameters[2].getValue()) * (in - parameters[2].getValue()) / (2 * parameters[3].getValue() * parameters[3].getValue()));
		} else return 1;
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
		return "GAUSS2 " + parameters[0] + " " + parameters[1] + " " + parameters[2] + " " + parameters[3];
	}
}
