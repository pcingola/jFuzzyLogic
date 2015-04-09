package net.sourceforge.jFuzzyLogic.membership;

import java.util.HashSet;
import java.util.Set;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Piece-wise linear membership function
 * @author pcingola@users.sourceforge.net
 */
public class MembershipFunctionPieceWiseLinear extends MembershipFunctionContinuous {

	/** Piece wise linear function values x */
	Value x[];
	/** Piece wise linear function values y */
	Value y[];

	/**
	 * Default constructor
	 * @param x [] : x points array
	 * @param y [] : y points array
	 * A piecewise linear function is defined by 'n' points:
	 * 		(x_1,y_1) , (x_2,y2) , ... (x_n,y_n)
	 * ordered by x[] (increasing)
	 * See also 'membership()' for a precise definition.
	 */
	public MembershipFunctionPieceWiseLinear(Value x[], Value y[]) {
		super();

		// Check parameters
		if (x == null) throw new RuntimeException("Parameter x[] can't be null");
		if (y == null) throw new RuntimeException("Parameter x[] can't be null");
		if (x.length > y.length) throw new RuntimeException("Array size differ");
		if (x.length < 1) throw new RuntimeException("Array size is 0");

		// Initialize (for the sake of clarity we keep parameters as 2 arrays 'x[], y[]'
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
	 * Membership funcion is defined as:
	 * 		membership(x) = y[0]											if x <= x[0]
	 * 		membership(x) = y[n]											if x >= x[n]  (where n = x.length)
	 * 		membership(x) = y[i - 1] + (y[i] - y[i - 1]) / (in - x[i])		if x[i-1] < x <= x[i]
	 *
	 * @see net.sourceforge.jFuzzyLogic.membership.MembershipFunction#membership(double)
	 */
	@Override
	public double membership(double in) {
		int i, len = x.length;
		if (in <= x[0].getValue()) return y[0].getValue();
		if (in > x[len - 1].getValue()) return y[len - 1].getValue();
		for (i = 1; i < len; i++)
			if (in <= x[i].getValue()) return y[i - 1].getValue() + (y[i].getValue() - y[i - 1].getValue()) * ((in - x[i - 1].getValue()) / (x[i].getValue() - x[i - 1].getValue()));
		if (Double.isNaN(in)) return Double.NaN;
		throw new RuntimeException("Error calculating membership! This should never happen! (in = " + in + ")");
	}

	/** Need to override this method (we store parameters differently in this function) */
	@Override
	public void setParameter(int i, double value) {
		int j = i / 2;
		if ((i % 2) == 0) x[j].setValue(value);
		else y[j].setValue(value);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer(getName() + " : ");
		for (int i = 0; i < x.length; i++) {
			str.append("(" + x[i].getValue() + ", " + y[i].getValue() + ") ");
			if (i < (x.length - 1)) str.append(", ");
		}
		str.append(";");
		return str.toString();
	}

	@Override
	public String toStringCpp() {
		StringBuilder sb = new StringBuilder();
		int i, len = x.length;
		sb.append("\tif ( x <= " + x[0].getValue() + " )\treturn " + y[0].getValue() + ";\n");
		sb.append("\tif ( x > " + x[len - 1].getValue() + " )\treturn " + y[len - 1].getValue() + ";\n");
		for (i = 1; i < len; i++)
			sb.append("\tif ( x <= " + x[i].getValue() + " )\treturn " + y[i - 1].getValue() + " + ( " + y[i].getValue() + " - " + y[i - 1].getValue() + " ) * ( ( x - " + x[i - 1].getValue() + " ) / ( " + x[i].getValue() + " - " + x[i - 1].getValue() + " ) );\n");
		return sb.toString();
	}

	/** FCL representation */
	@Override
	public String toStringFcl() {
		String str = " ";
		for (int i = 0; i < x.length; i++)
			str += "(" + x[i].toStringFcl() + ", " + y[i].toStringFcl() + ") ";
		return str;
	}
}
