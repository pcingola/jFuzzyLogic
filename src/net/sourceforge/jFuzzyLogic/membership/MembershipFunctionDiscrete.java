package net.sourceforge.jFuzzyLogic.membership;

import java.util.Iterator;

/**
 * Base Discrete membership function
 * @author pcingola@users.sourceforge.net
 */
public abstract class MembershipFunctionDiscrete extends MembershipFunction {

	public MembershipFunctionDiscrete() {
		super();
		discrete = true;
	}

	/**
	 * Create an iterator for every discrete value (x values)
	 * @return An iterator
	 */
	public abstract Iterator<Double> iterator();

	/** Memebership function for point number 'index' */
	public abstract double membership(int index);

	/** Number of points in this function */
	public abstract int size();

	/** Value 'x' for point number 'index' */
	public abstract double valueX(int index);

}
