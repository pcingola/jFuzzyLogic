package net.sourceforge.jFuzzyLogic.membership;

import java.util.HashSet;
import java.util.Set;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Base membership function
 * @author pcingola@users.sourceforge.net
 */
public abstract class MembershipFunction extends FclObject {

	/** Debug mode for this class? */
	public static boolean debug = FIS.debug;

	boolean discrete;
	Value parameters[]; // Function's parameters
	double universeMax; // Universe max (range max)
	double universeMin; // Universe min (range min)

	/** Default Constructor */
	MembershipFunction() {
		universeMax = universeMin = Double.NaN;
	}

	public abstract boolean checkParamters(StringBuffer errors);

	/** Try to guess the universe (if not set) */
	public abstract void estimateUniverse();

	public void estimateUniverseForce() {
		universeMin = universeMax = Double.NaN;
		estimateUniverse();
	}

	/**
	 * Find variables used by this function
	 */
	public Set<Variable> findVariables() {
		HashSet<Variable> vars = new HashSet<Variable>();

		if (parameters != null) {
			for (Value val : parameters)
				if (val.getType() == Value.Type.VAR_REFERENCE && val.getVarRef() != null) vars.add(val.getVarRef());
		}

		return vars;
	}

	/** Short name */
	public String getName() {
		String str = this.getClass().getName();
		String mfStr = "MembershipFunction";
		int ind = str.lastIndexOf('.');
		if (ind >= 0) {
			str = str.substring(ind + 1);
			if (str.startsWith(mfStr)) str = str.substring(mfStr.length());
		}
		return str;
	}

	public double getParameter(int i) {
		return parameters[i].getValue();
	}

	public int getParametersLength() {
		return (parameters != null ? parameters.length : 0);
	}

	public double getUniverseMax() {
		return universeMax;
	}

	public double getUniverseMin() {
		return universeMin;
	}

	public boolean isDiscrete() {
		return discrete;
	}

	/**
	 * Get membership function's value.
	 * @param in : Variable's 'x' value
	 * Note: Output mu be in range [0,1]
	 */
	public abstract double membership(double in);

	public void setDiscrete(boolean discrete) {
		this.discrete = discrete;
	}

	public void setParameter(int i, double value) {
		parameters[i].setValue(value);
	}

	public void setUniverseMax(double universeMax) {
		this.universeMax = universeMax;
	}

	public void setUniverseMin(double universeMin) {
		this.universeMin = universeMin;
	}

	@Override
	public String toStringCpp() {
		throw new RuntimeException("Unimplemented method 'toStringCpp()' for class " + this.getClass().getCanonicalName());
	}

	@Override
	public String toStringFcl() {
		return getName();
	}
}
