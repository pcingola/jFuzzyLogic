package net.sourceforge.jFuzzyLogic.demo.dynamics.block;

import net.sourceforge.jFuzzyLogic.demo.dynamics.ForceDrivenModel;
import net.sourceforge.jFuzzyLogic.demo.dynamics.Model;

/**
 * An IPModel object represents the dynamics of an inverted pendulum attached to a
 * sliding block.
 * @author Andrew Kaluzniacki
 */
public final class BlockModel implements Model, ForceDrivenModel {

	private double dxdt = 0; // first time derivative of x
	private double Fx = 0; // the external force applied to the block
	private double m1 = 0; // mass of block
	private double rightLim = Double.POSITIVE_INFINITY;
	private double time = 0; // time elapsed in simulation
	private double timeStep = 1e-3;
	private double x = 0; // the position of the block mass (pendulum pivot) - increases to the right

	/**
	 * main() serves as a simple demo of IPModel and runs the model through 10 seconds of
	 * time outputing the state to the console
	 * In typical use of IPModel, main() would not be called
	 * @param args the command line arguments - these are ignored
	 */
	public static void main(String[] args) {
		System.out.println("Inverted Pendulum Model - run for 10 seconds..\n");

		BlockModel model = new BlockModel();

		// run for 10 seconds.
		for( double t = 0.0; t <= 10.0; t = t + 0.1 ) {
			System.out.println(model);
			model.update(0.1);
		}
	}

	/** Creates a new instance of IPModel */
	public BlockModel() {
		reset();
	}

	private double eqDv(double t, double x, double v) {
		return Fx / m1; // v'
	}

	private double eqDx(double t, double x, double v) {
		return v; // x' = v
	}

	public double getDxdt() {
		return dxdt;
	}

	double getForce() {
		return Fx;
	}

	public double getM1() {
		return m1;
	}

	public double getRightLim() {
		return rightLim;
	}

	double getTime() {
		return time;
	}

	/**
	 * return the current value of x
	 */
	public double getX() {
		return x;
	}

	/**
	 * reset the state of the model to an initial state
	 */
	public void reset() {
		m1 = 1.0;
		x = 0;
		dxdt = 0;
		Fx = 0;
		time = 0;
	}

	public void setDxdt(double dxdt) {
		this.dxdt = dxdt;
	}

	public void setForce(double force) {
		//     System.out.println(" " + pPos + "  " + x);
		Fx = force;
	};

	public void setX(double x) {
		this.x = x;
	}

	/**
	 * propogate the state of the system through a small time h
	 *
	 *  Runge Kutta Notes  - taken from Mathematical Methods of Physics - 2nd ed  Mathews + Walker
	 *
	 *  dy/dx = f(x,y)   -   this is the equation we know, what we want to find is y(x)
	 *
	 *  Suppose y = y0 at x = x0,  we choose a small interval h and calculate
	 *
	 *  k1 = h * f(x0, y0)
	 *  k2 = h * f(x0 + h/2, y0 + k1/2)
	 *  k3 = h * f(x0 + h/2, y0 + k2/2)
	 *  k4 = h * f(x0 + h, y0 + k3)
	 *
	 *  Then at x = x0 + h , y (=) y0 + 1/6(k1 + 2 * k2 + 2 * k3 + k4)
	 *
	 *
	 *  For several coupled differential equations it is a little messier
	 *
	 *  We have to do this for four first order diff eqs for x,phi,v,w.
	 *
	 *  Note that our diffeq are not actually explicitly dependent on t - since we take Fx and Fphi to be constant in our interval h.
	 *  But I include t in the calls I make for clarity.
	 */
	private void stepRK(double h) {

		double v = dxdt; //  we call v dx
		double t = time;

		// calculate all the new values - using old values
		double k1a = h * eqDx(t, x, v);
		double k1c = h * eqDv(t, x, v);

		double k2a = h * eqDx(t + h / 2.0, x + k1a / 2.0, v + k1c / 2.0);
		double k2c = h * eqDv(t + h / 2.0, x + k1a / 2.0, v + k1c / 2.0);

		double k3a = h * eqDx(t + h / 2.0, x + k2a / 2.0, v + k2c / 2.0);
		double k3c = h * eqDv(t + h / 2.0, x + k2a / 2.0, v + k2c / 2.0);

		double k4a = h * eqDx(t + h, x + k3a, v + k3c);
		double k4c = h * eqDv(t + h, x + k3a, v + k3c);

		double newX = x + (k1a + 2.0 * k2a + 2.0 * k3a + k4a) / 6.0;
		double newV = v + (k1c + 2.0 * k2c + 2.0 * k3c + k4c) / 6.0;

		// now update the old values with the new
		time = t + h;
		x = newX;

		dxdt = newV;

	}

	/**
	 * return a string representing the state of the model
	 */
	@Override
	public String toString() {
		java.text.DecimalFormat nf = new java.text.DecimalFormat();

		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setPositivePrefix("+");

		return "model:" + "    x=" + nf.format(x) + "    dx=" + nf.format(dxdt) + "    time:" + nf.format(time) + "    force:" + nf.format(Fx);
	}

	// the internal state of the model is private to the model
	// reset() sets these values.

	/**
	 * propagate the model state through deltaTime using the Runge-Kutta method.
	 */
	public void update(double deltaTime) {

		double endTime = time + deltaTime;
		// break deltaTime into even smaller time steps.
		while(time < endTime)
			stepRK(timeStep);

	}

}
