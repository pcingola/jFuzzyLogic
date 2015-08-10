package net.sourceforge.jFuzzyLogic.membership;

/**
 * Cosine membership function
 * Bug found & corrected by Pablo Cingolani (Junit test added)
 * 
 * @author yuanhao.li@gmail.com
 */
public class MembershipFunctionCosine extends MembershipFunctionContinuous {

	/**
	 * Constructor
	 * @param net_max : max value in x axis
	 * @param offset: offset in x-axis
	 */
	public MembershipFunctionCosine(Value net_max, Value offset) {
		super();

		// Initialize
		parameters = new Value[2];
		parameters[0] = net_max;
		parameters[1] = offset;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if (!checkParamters(errors)) throw new RuntimeException(errors.toString());
	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;

		if (parameters[0].getValue() < 0) {
			ok = false;
			if (errors != null) errors.append("Parameter 'net_max' should be greater than zero : " + parameters[0] + "\n");
		}
		return ok;
	}

	@Override
	public void estimateUniverse() {
		if ((!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax))) return;
		universeMin = parameters[1].getValue() - parameters[0].getValue();
		universeMax = parameters[1].getValue() + parameters[0].getValue();
	}

	/**
	 * @See net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		double x = in - parameters[1].getValue();
		double t = parameters[0].getValue();
		double tPi = Math.PI / parameters[0].getValue();
		if ((-t <= x) && (x <= t)) return (Math.cos(x * tPi) + 1) / 2;
		return 0;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + " : " + parameters[0] + " " + parameters[1];
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		return "COSINE " + parameters[0] + " " + parameters[1];
	}
}
