package net.sourceforge.jFuzzyLogic.membership;

/**
 * Paralelogram membership function
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionTrapetzoidal extends MembershipFunctionContinuous {

	/**
	 * Constructor 
	 * @param min : Begining of trapetzoidal
	 * @param midLow : Lower midium point of trapetzoidal
	 * @param midHigh : Higher midium point of trapetzoidal
	 * @param max : End of trapetzoidal
	 */
	public MembershipFunctionTrapetzoidal(Value min, Value midLow, Value midHigh, Value max) {
		super();

		// Initialize
		parameters = new Value[4];
		parameters[0] = min;
		parameters[1] = midLow;
		parameters[2] = midHigh;
		parameters[3] = max;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if( !checkParamters(errors) ) throw new RuntimeException(errors.toString());
	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;

		if( parameters[0].getValue() > parameters[1].getValue() ) {
			ok = false;
			if( errors != null ) errors.append("Parameter midLow is out of range (should stisfy: min <= midLow): " + parameters[0] + " > " + parameters[1] + "\n");
		}

		if( parameters[1].getValue() > parameters[2].getValue() ) {
			ok = false;
			if( errors != null ) errors.append("Parameter midHigh is out of range (should stisfy: midLow <= midHigh): " + parameters[1] + " > " + parameters[2] + "\n");
		}

		if( parameters[2].getValue() > parameters[3].getValue() ) {
			ok = false;
			if( errors != null ) errors.append("Parameter max is out of range (should stisfy: midHigh <= max): " + parameters[2] + " > " + parameters[3] + "\n");
		}

		return ok;
	}

	@Override
	public void estimateUniverse() {
		// Are universeMin and universeMax already set? => nothing to do
		if( (!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax)) ) return;
		universeMin = parameters[0].getValue();
		universeMax = parameters[3].getValue();
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		// Out of range => 0
		if( (in < parameters[0].getValue()) || (in > parameters[3].getValue()) ) return 0;

		// Between 'midLow' and 'midHigh' => 1
		if( (in >= parameters[1].getValue()) && (in <= parameters[2].getValue()) ) return 1;

		// Between 'min' and 'midLow'
		if( in < parameters[1].getValue() ) return ((in - parameters[0].getValue()) / (parameters[1].getValue() - parameters[0].getValue()));

		// Between 'midHigh' and 'max'
		return 1 - ((in - parameters[2].getValue()) / (parameters[3].getValue() - parameters[2].getValue()));
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
		return "TRAPE " + parameters[0] + " " + parameters[1] + " " + parameters[2] + " " + parameters[3];
	}
}
