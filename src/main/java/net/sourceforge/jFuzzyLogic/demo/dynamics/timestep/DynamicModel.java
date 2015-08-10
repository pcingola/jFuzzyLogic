package net.sourceforge.jFuzzyLogic.demo.dynamics.timestep;

public interface DynamicModel {

	void eval(double t1, double[] state, double[] vel);

}
