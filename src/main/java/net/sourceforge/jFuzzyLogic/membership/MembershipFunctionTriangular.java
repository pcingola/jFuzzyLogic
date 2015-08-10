package net.sourceforge.jFuzzyLogic.membership;

/**
 * Triangular membership function
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionTriangular extends MembershipFunctionContinuous {

	/**
	 * Constructor 
	 * @param min : Begining of triangular function
	 * @param mid : Midium of triangular function
	 * @param max : End of triangular function
	 */
	public MembershipFunctionTriangular(Value min, Value mid, Value max) {
		super();

		// Initialize
		parameters = new Value[3];
		parameters[0] = min;
		parameters[1] = mid;
		parameters[2] = max;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if( !checkParamters(errors) ) throw new RuntimeException(errors.toString());
	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;

		if( parameters[0].getValue() > parameters[1].getValue() ) {
			ok = false;
			if( errors != null ) errors.append("Parameter mid is out of range (should stisfy: min <= mid): " + parameters[0] + " > " + parameters[1] + "\n");
		}

		if( parameters[1].getValue() > parameters[2].getValue() ) {
			ok = false;
			if( errors != null ) errors.append("Parameter max is out of range (should stisfy: mid <= max): " + parameters[1] + " > " + parameters[2] + "\n");
		}

		return ok;
	}

	@Override
	public void estimateUniverse() {
		// Are universeMin and universeMax already set? => nothing to do
		if( (!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax)) ) return;
		universeMin = parameters[0].getValue();
		universeMax = parameters[2].getValue();
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		// Outside range? => membership is 0
		if( (in < parameters[0].getValue()) || (in > parameters[2].getValue()) ) return 0;

		// Middle point of the triangle? => membership is 1.0
		// Note: This comparison is useful when one of the extremes and the 'mid' point are the same
		// 			E.g.:	TERM negSmall := TRIAN -0.4 0 0;		
		//					=> The membership value at 0 should be one, but the formula below gives 0
		if( in == parameters[1].getValue() ) return 1.0;

		// Value between 'min' and 'mid'
		if( in < parameters[1].getValue() ) return ((in - parameters[0].getValue()) / (parameters[1].getValue() - parameters[0].getValue()));

		// Value between 'mid' and 'max'
		return 1 - ((in - parameters[1].getValue()) / (parameters[2].getValue() - parameters[1].getValue()));
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + " : " + parameters[0] + " , " + parameters[1] + " , " + parameters[2];
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		return "TRIAN " + parameters[0] + " " + parameters[1] + " " + parameters[2];
	}
}
