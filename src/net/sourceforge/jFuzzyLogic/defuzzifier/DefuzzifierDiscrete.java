package net.sourceforge.jFuzzyLogic.defuzzifier;

import java.util.HashMap;
import java.util.Iterator;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Generic discrete defuzzifier (a defuzzifier for continuous membership functions)
 * @author pcingola@users.sourceforge.net
 */
public abstract class DefuzzifierDiscrete extends Defuzzifier implements Iterable<Double> {

	/**
	 * Funcion values: A generic discrete function
	 * 			x = [x_1, x_2, .... , x_n]
	 * 			y = [y_1, y_2, .... , y_n]
	 * 			y_i = f[x_i]
	 * Values are stored in 'discreteValues' hash
	 */
	protected HashMap<Double, Double> discreteValues;

	public DefuzzifierDiscrete(Variable variable) {
		super(variable);
		discrete = true;
		init();
	}

	/** Deffuzification function */
	@Override
	public abstract double defuzzify();

	/** Get a point's 'y' value */
	public double getDiscreteValue(double x) {
		Double y = discreteValues.get(x);
		if (y == null) return 0;
		return y;
	}

	@Override
	protected void init() {
		discreteValues = new HashMap<Double, Double>();
	}

	/** Get an iterator (on discreteValues' keys) */
	@Override
	public Iterator<Double> iterator() {
		return discreteValues.keySet().iterator();
	}

	/**
	 * Do we need to re-initialize?
	 */
	@Override
	public boolean needsInit() {
		return false;
	}

	/** Reset values */
	@Override
	public void reset() {
		super.reset();

		if (discreteValues != null) {
			// Set all values to 0
			for (Double key : this)
				discreteValues.put(key, 0.0);
		}
	}

	/** Set a point */
	public void setPoint(double x, double y) {
		discreteValues.put(x, y);
	}

	/** How many points are there in this defuzzifier */
	public int size() {
		return discreteValues.size();
	}

}
