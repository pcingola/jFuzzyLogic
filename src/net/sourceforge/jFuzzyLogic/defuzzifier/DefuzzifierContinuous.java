package net.sourceforge.jFuzzyLogic.defuzzifier;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Generic continuous defuzzifier (a defuzzifier for continuous membership functions)
 * @author pcingola@users.sourceforge.net
 */
public abstract class DefuzzifierContinuous extends Defuzzifier {

	/** Default number of points for 'values[]' */
	public static int DEFAULT_NUMBER_OF_POINTS = 1000;

	protected double max; // Where function ends
	protected double min; // Where function begins

	/**
	 * Step size between each element in 'values[]'
	 * 			stepSize = (max - min) / values.length
	 */
	protected double stepSize;

	/**
	 * Funcion values: A generic continuous function
	 * 			y = f(x)
	 * where x : [min, max]
	 * Values are stored in 'values[]' array.
	 * Array's index is calculated as:
	 * 			index = (x - min) / (max - min) * (values.length)
	 */
	protected double values[];

	public DefuzzifierContinuous(Variable variable) {
		super(variable);
		discrete = false;
		init();
	}

	public void addValue(int index, double value) {
		values[index] += value;
	}

	/** Deffuzification function */
	@Override
	public abstract double defuzzify();

	/** Calculate function's area */
	public double getArea() {
		double sum = 0;
		for (int i = 0; i < values.length; i++)
			sum += values[i];
		return sum * stepSize;
	}

	/** Get 'values[]' index */
	public int getIndex(double d) {
		if ((d < min) || (d > max)) throw new RuntimeException("Value out of range: " + d);
		return (int) ((d - min) / stepSize);
	}

	public int getLength() {
		if (values != null) return values.length;
		return 0;
	}

	public double getMax() {
		return max;
	}

	public double getMin() {
		return min;
	}

	public double getStepSize() {
		return stepSize;
	}

	/** Get a value from 'values[]' using a double as index */
	public double getValue(double x) {
		return values[getIndex(x)];
	}

	public double getValue(int index) {
		return values[index];
	}

	public double[] getValues() {
		return values;
	}

	/**
	 * Initialize
	 */
	@Override
	protected void init() {
		variable.estimateUniverse();
		double umin = variable.getUniverseMin();
		double umax = variable.getUniverseMax();
		int numberOfPoints = DEFAULT_NUMBER_OF_POINTS;

		if (values == null || values.length != numberOfPoints) values = new double[numberOfPoints];

		// Go on only if min & max are set
		if (Double.isNaN(umin) || Double.isNaN(umax)) {
			min = max = Double.NaN;
			return;
		}

		// Check parameters
		if (umin > umax) throw new RuntimeException("Parameter max is out of range (should satisfy: min < max). min: " + umin + "\tmax: " + umax);

		// Initialize
		min = umin;
		max = umax;
		stepSize = (max - min) / numberOfPoints;
		reset();
	}

	@Override
	public boolean isDiscrete() {
		return discrete;
	}

	/**
	 * Do we need to re-initialize?
	 */
	@Override
	public boolean needsInit() {
		return Double.isNaN(max) || Double.isNaN(min);
	}

	/** Reset values (in 'values[] array) */
	@Override
	public void reset() {
		super.reset();

		if (values != null) {
			for (int i = 0; i < values.length; i++)
				values[i] = 0;
		}
	}

	@Override
	public void setDiscrete(boolean discrete) {
		this.discrete = discrete;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public void setStepSize(double stepSize) {
		this.stepSize = stepSize;
	}

	public void setValue(double valueX, double valueY) {
		values[getIndex(valueX)] = valueY;
	}

	public void setValue(int index, double value) {
		values[index] = value;
	}

	public void setValues(double[] values) {
		this.values = values;
	}
}
