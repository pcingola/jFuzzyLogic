package net.sourceforge.jFuzzyLogic.demo.dynamics.timestep;

public class TestOsc {

	static double m = 1.0;
	static double k = 1.0;
	static double c = .0;

	static double f = 1.0;

	public static void main(String args[]) {

		double dt = .1;

		DynamicModel osc = new DynamicModel() {

			@Override
			public void eval(double t1, double[] state, double[] vel) {
				vel[0] = state[1];
				vel[1] = (f - c * state[1] - k * state[0]) / m;
				// TODO Auto-generated method stub

			}
		};

		double state[] = new double[2];

		RungeKutta rk = new RungeKutta(state, 0.0, dt, osc);

		for (int i = 0; i < 100; i++) {
			rk.stepRK();
			System.out.println(state[0] + "  " + state[1]);
			f = 0.0;
		}

	}

}
