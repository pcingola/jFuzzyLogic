package net.sourceforge.jFuzzyLogic.demo.dynamics.timestep;

public class RungeKutta {

	private int n;

	private double[] vel1;
	private double[] state1;
	private double[] state2;
	private double[] vel2;
	private double[] vel3;
	private double[] state3;
	private double[] vel4;

	private double time;

	private double dt;

	private DynamicModel model;

	private double[] state;

	public RungeKutta(double [] state,double time, double h,DynamicModel model ) {
		this.n = state.length;
		
		vel1 = new double[n];
		vel2 = new double[n];
		vel3 = new double[n];
		vel4 = new double[n];
		state1 = new double[n];
		state2 = new double[n];
		state3 = new double[n];

		
		this.time=time;
		this.dt=h;
		this.model=model;
		this.state=state;
	}

	public void stepRK(	) {

		// 1. initial velocity at time
		double tstart = time;
		model.eval(tstart, state, vel1);

		// 2. velocity at time+h/2 using previous vel estimate
		double tmid = time + dt/ 2.0;

		for (int i = 0; i < n; i++) {
			state1[i] = state[i] + dt * vel1[i] * 0.5;
		}

		model.eval(tmid, state1, vel2);

		// 3. redo using new velocity estimate

		for (int i = 0; i < n; i++) {
			state2[i] = state[i] + dt * vel2[i] * 0.5;
		}

		model.eval(tmid, state1, vel3);

		// 4. estimate velocity at end
		double tend = time + dt;

		for (int i = 0; i < n; i++) {
			state3[i] = state[i] + dt * vel3[i] * 0.5;
		}

		model.eval(tend, state3, vel4);

		for (int i = 0; i < n; i++) {
			state[i] += dt * (vel1[i] + 2.0 * vel2[i] + 2.0 * vel3[i] + vel4[i])
					/ 6.0;

		}

	}

	
	
}
