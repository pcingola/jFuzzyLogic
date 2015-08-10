package net.sourceforge.jFuzzyLogic.membership;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Generic singleton membership function: Allows 'n' singletons (generic discrete membership function)
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionGenericSingleton extends MembershipFunctionDiscrete {

	/** Singleton function values x */
	Value x[];
	/** Singleton function values y */
	Value y[];

	/**
	 * Constructor for generin (N-values)
	 * @param x : x[] values array
	 * @param y : y[] values array
	 */
	public MembershipFunctionGenericSingleton(Value x[], Value y[]) {
		discrete = true;

		// Check parameters
		if (x == null) throw new RuntimeException("Parameter x[] can't be null");
		if (y == null) throw new RuntimeException("Parameter x[] can't be null");
		if (x.length > y.length) throw new RuntimeException("Array size differ");
		if (x.length < 1) throw new RuntimeException("Array size is 0");

		// Initialize
		this.x = x;
		this.y = y;

		// Check parameters
		StringBuffer errors = new StringBuffer();
		if (!checkParamters(errors)) throw new RuntimeException(errors.toString());
	}

	@Override
	public boolean checkParamters(StringBuffer errors) {
		boolean ok = true;

		if (x.length > 1) for (int i = 0; i < x.length; i++) {
			if ((i > 0) && (x[i - 1].getValue() > x[i].getValue())) {
				ok = false;
				if (errors != null) errors.append("Array not sorted: x[" + (i - 1) + "] = " + x[i - 1] + " , x[" + i + "] = " + x[i] + "\n");
			}

			if ((y[i].getValue() < 0) || (y[i].getValue() > 1)) {
				ok = false;
				if (errors != null) errors.append("Membership funcion out of range: y[" + i + "] = " + y[i] + " (should be in range [0,1]\n");
			}
		}

		return ok;
	}

	@Override
	public void estimateUniverse() {
		// Are universeMin and universeMax already set? => nothing to do
		if ((!Double.isNaN(universeMin)) && (!Double.isNaN(universeMax))) return;
		universeMin = x[0].getValue();
		universeMax = x[x.length - 1].getValue();
	}

	/**
	 * Find variables used by this function
	 */
	@Override
	public Set<Variable> findVariables() {
		HashSet<Variable> vars = new HashSet<Variable>();

		if (x != null) {
			for (Value val : x)
				if (val.getType() == Value.Type.VAR_REFERENCE && val.getVarRef() != null) vars.add(val.getVarRef());
		}

		if (y != null) {
			for (Value val : y)
				if (val.getType() == Value.Type.VAR_REFERENCE && val.getVarRef() != null) vars.add(val.getVarRef());
		}

		return vars;
	}

	/** Need to override this method (we store parameters differently in this function) */
	@Override
	public double getParameter(int i) {
		int j = i / 2;
		if ((i % 2) == 0) return x[j].getValue();
		return y[j].getValue();

	}

	/** Need to override this method (we store parameters differently in this function) */
	@Override
	public int getParametersLength() {
		return (x != null ? 2 * x.length : 0);
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete#iterator()
	 */
	@Override
	public Iterator<Double> iterator() {
		return new Iterator<Double>() {

			int i = 0;

			@Override
			public boolean hasNext() {
				return (i < x.length);
			}

			@Override
			public Double next() {
				return x[i].getValue();
			}

			@Override
			public void remove() {
			}
		};
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		int i, len = x.length;
		if (in <= x[0].getValue()) return y[0].getValue();
		if (in > x[len - 1].getValue()) return y[len - 1].getValue();
		for (i = 1; i < len; i++)
			if (in == x[i].getValue()) return y[i].getValue();
		return 0;
	}

	/**
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete#membership(int)
	 */
	@Override
	public double membership(int index) {
		if ((index < 0) || (index > x.length)) return 0;
		return y[index].getValue();
	}

	/** Need to override this method (we store parameters differently in this function) */
	@Override
	public void setParameter(int i, double value) {
		int j = i / 2;
		if ((i % 2) == 0) x[j].setValue(value);
		else y[j].setValue(value);
	}

	/**
	 * Number of points in this discrete function (i.e. number of 'singletons')
	 */
	@Override
	public int size() {
		return x.length;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer(getName() + " : ");
		for (int i = 0; i < x.length; i++) {
			str.append("[" + x[i] + ", " + y[i] + "] ");
			if (i < (x.length - 1)) str.append(", ");
		}
		str.append(";");
		return str.toString();
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		String str = "SINGLETONS ";
		for (int i = 0; i < x.length; i++)
			str += "(" + x[i] + ", " + y[i] + ") ";
		return str;
	}

	@Override
	public double valueX(int index) {
		return x[index].getValue();
	}
}
