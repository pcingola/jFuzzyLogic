package net.sourceforge.jFuzzyLogic.membership;

import java.util.Iterator;

/**
 * Singleton membership function
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionSingleton extends MembershipFunctionDiscrete {

	/**
	 * Constructor for a simple (only one value) singleton
	 * @param valueX
	 * @param valueY
	 */
	public MembershipFunctionSingleton(Value valueX) {
		super();

		// Initialize
		parameters = new Value[2];
		parameters[0] = valueX;
		parameters[1] = Value.ONE;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if( !checkParamters(errors) ) throw new RuntimeException(errors.toString());
	}

	/**
	 * Constructor for a simple (only one value) singleton
	 * @param valueX
	 * @param valueY
	 */
	public MembershipFunctionSingleton(Value valueX, Value valueY) {
		super();

		// Initialize
		parameters = new Value[2];
		parameters[0] = valueX;
		parameters[1] = valueY;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if( !checkParamters(errors) ) throw new RuntimeException(errors.toString());
	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;

		if( (parameters[1].getValue() < 0) || (parameters[1].getValue() > 1) ) {
			ok = false;
			if( errors != null ) errors.append("Error: valueY out of range: " + parameters[1] + "\n");
		}

		return ok;
	}

	@Override
	public void estimateUniverse() {
		// Are universeMin and universeMax already set? => nothing to do
		if( (!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax)) ) return;
		universeMin = parameters[0].getValue();
		universeMax = parameters[0].getValue();
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete#iterator()
	 */
	@Override
	public Iterator<Double> iterator() {
		return new Iterator<Double>() {

			int i = 0;

			public boolean hasNext() {
				return (i == 0);
			}

			public Double next() {
				return parameters[0].getValue();
			}

			public void remove() {}
		};
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		if( in == parameters[0].getValue() ) return parameters[1].getValue();
		return 0;
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete#membership(int)
	 */
	@Override
	public double membership(int index) {
		if( index == 0 ) return parameters[1].getValue();
		return 0;
	}

	@Override
	public int size() {
		return 1;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + " : {" + parameters[0] + ", " + parameters[1] + "}";
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		return " " + parameters[0];
	}

	@Override
	public double valueX(int index) {
		if( index == 0 ) return parameters[0].getValue();
		throw new RuntimeException("Array index out of range: " + index);
	}
}
