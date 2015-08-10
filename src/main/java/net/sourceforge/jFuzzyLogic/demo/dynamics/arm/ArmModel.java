package net.sourceforge.jFuzzyLogic.demo.dynamics.arm;

/*
 * IPModel.java
 *
 * Created on March 31, 2004, 12:08 PM
 *
 *  Copyright 2004 Andrew Kaluzniacki
 *  All rights reserved.
 *  http://drewk.net
 * 
 *  Mods by  Paul Leonard  Sep 2008.
 */

import net.sourceforge.jFuzzyLogic.demo.dynamics.ForceDrivenModel;
import net.sourceforge.jFuzzyLogic.demo.dynamics.Model;
import net.sourceforge.jFuzzyLogic.demo.dynamics.timestep.RungeKutta;

public final class ArmModel implements Model {

	double phi1; // angle of the pendulum - verticle down is 0, increasing
						// counter clockwise
	double dphi1dt ; // first time derivative of phi
	double phi2 ; // angle of the pendulum - verticle down is 0, increasing
						// counter clockwise
	double dphi2dt; // first time derivative of phi

	private double time = 0; // time elapsed in simulation
	private double timeStep = 1e-4;

	double x1, y1, x2, y2;

	ArmDynamics arm;
	double[] state = new double[4];

	private RungeKutta rk;

	double baseHeight=0.0;
	double xTarget;
	double yTarget;
	double phiTarget;
	double rTarget;
	
	double phi2target;
	double phi1target;

	double getDphi1dt() {
		return dphi1dt;
	}

	void setPhi1(double phi) {
		this.phi1 = phi;
	}

	public double getPhi2dt() {
		return dphi2dt;
	}

	/** Creates a new instance of IPModel */
	public ArmModel() {
		this.reset();
		arm = new ArmDynamics();
		rk = new RungeKutta(state, time, timeStep, arm);
	}

	double getTime() {
		return time;
	}

	public void update(double deltaTime) {

		// System.out.println(" **** Model.update");
		double endTime = time + deltaTime;
		double t1 = time;

		// break deltaTime into even smaller time steps.
		while (time < endTime) {
			rk.stepRK();
			time += timeStep;
		}

		phi1 = state[0];
		phi2 = state[1];
		dphi1dt=state[2];
		dphi2dt=state[3];
		
//		while(phi1 > Math.PI) phi1-=Math.PI*2;
//		while(phi1 < -Math.PI) phi1+=Math.PI*2;
//		while(phi2 > Math.PI) phi2-=Math.PI*2;
//		while(phi2 < -Math.PI) phi2+=Math.PI*2;
		
		x1 = arm.L1 * Math.cos(phi1);
		y1 = arm.L1 * Math.sin(phi1);
		x2 = x1 + arm.L2 * Math.cos(phi1 + phi2);
		y2 = y1 + arm.L2 * Math.sin(phi1 + phi2);

	
	};

	/**
	 * reset the state of the model to an initial state
	 */
	public void reset() {

		System.out.println(" IP  model reset ");
		phi1 = 0;
		phi2 = 0;
		dphi1dt = 0;
		dphi2dt = 0;
		time = 0;
		state[0] = phi1;
		state[1] = phi2;
		state[2] = dphi1dt;  
		state[3] = dphi2dt;

	}

	/**
	 * return a string representing the state of the model
	 */
	public String toString() {
		java.text.DecimalFormat nf = new java.text.DecimalFormat();

		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setPositivePrefix("+");

		return String
				.format(" phi1 = %7.1f \t dphi1dt= %7.1f \t phi2= %7.2f \t dphi2dt= %7.1f t1=%4.3f t2=%4.3f ",
						phi1, dphi1dt, phi2, dphi2dt,arm.t1,arm.t2);

	}


	public void setTarget(double x,double y) {
		xTarget=x;
		yTarget=y;
		
		phiTarget=Math.atan2(y,x);
		rTarget=Math.sqrt(x*x+y*y);
		
		double D=(x*x+y*y-arm.L1*arm.L1-arm.L2*arm.L2)/(2.0*arm.L1*arm.L2);
		if (D > 1.0) return;
		System.out.println("D="+D);
		
		double phi21=Math.atan2(Math.sqrt(1-D*D),D);
		double phi22=Math.atan2(-Math.sqrt(1-D*D),D);

		//System.out.println("D="+D+ " sinP1= "+sinPhi1+);
		
		
		double phi11=phiTarget-Math.atan2(arm.L2*Math.sin(phi21),(arm.L1+arm.L2*Math.cos(phi21)));
		double phi12=phiTarget-Math.atan2(arm.L2*Math.sin(phi22),(arm.L1+arm.L2*Math.cos(phi22)));

		double x11=arm.L1*Math.sin(phi11);
		double x12=arm.L1*Math.sin(phi12);
		
		if (x11 > x12) {
			phi1target=phi11;
			phi2target=phi21;
		} else {
			phi1target=phi12;
			phi2target=phi22;
		}
		
		
	}
	
	public void release(){
		setTorques(0,0);
	}
	
	public void setTorques(double t1,double t2){
		
		arm.t1=t1;
		arm.t2=t2;
		
	}

	

	/**
	 * main() serves as a simple demo of IPModel and runs the model through 10
	 * seconds of time outputing the state to the console In typical use of
	 * IPModel, main() would not be called
	 * 
	 * @param args
	 *            the command line arguments - these are ignored
	 */
	public static void main(String[] args) {
		System.out.println("Arm Model - run for 10 seconds..\n");

		ArmModel model = new ArmModel();

		// run for 10 seconds.
		for (double t = 0.0; t <= 10.0; t = t + 0.1) {
			System.out.println(model);
			model.update(0.1);
		}
	}

}
