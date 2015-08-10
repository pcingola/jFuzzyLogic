package net.sourceforge.jFuzzyLogic.demo.dynamics.arm;

import net.sourceforge.jFuzzyLogic.demo.dynamics.timestep.DynamicModel;
import net.sourceforge.jFuzzyLogic.demo.dynamics.timestep.RungeKutta;

public class ArmDynamics implements DynamicModel {

	double m1=1, m2=1, m3=3;
	double L1=1, L2=1, a1=0.5, a2=0.5;
	double I1=0.01, I2=0.01, g=9.81, c1=0.5, c2=0.5;
	public double t1;
	public double t2;
	
	ArmDynamics(){
		
	}


	
	@Override
	public void eval(double t, double[] state, double[] vel) {
		
		// adapted from Example 5_6
		double y[]=state;
		
		// input torque (free fall)

		double Torque1=-c1*y[2]+t1; 
		double Torque2=-c2*y[3]+t2;  
		
		double A11=m1*a1*a1+m2*(L1*L1+a2*a2)+m3*(L1*L1+L2*L2)+I1+I2
		    +2*L1*(m2*a2+m3*L2)*Math.cos(y[1]);
		
		double A22=m2*a2*a2+m3*L2*L2+I2;
		double A12=m2*(a2*a2+L1*a2*Math.cos(y[1]))+m3*(L2*L2+L1*L2*Math.cos(y[1]))+I2;
		double B1= 2*L1*(m2*a2+m3*L2)*Math.sin(y[1])*y[2]*y[3]
		    +L1*(m2*a2+m3*L2)*Math.sin(y[1])*y[3]*y[3]
		    -(m1*a1+m2*L1+m3*L1)*g*Math.cos(y[0])
		    -(m2*a2+m3*L2)*g*Math.cos(y[0]+y[1]);
		double B2= -L1*(m2*a2+m3*L2)*Math.sin(y[1])*y[2]*y[2]
		    -(m2*a2+m3*L2)*g*Math.cos(y[0]+y[1]);
		
		double detA= A11*A22-A12*A12;
		
		double b1=Torque1+B1;
		double b2=Torque2+B2;
		
		double c1=(b1*A22-b2*A12)/detA;
		double c2=(-b1*A12+b2*A11)/detA;
		
		vel[0]=state[2];
		vel[1]=state[3];
		vel[2]=c1;
		vel[3]=c2;
		
	}

	
	// Test code to reproduce Example 5_6
	public static void main(String args[]) {

		double dt = .01;
		double tend = 10;
		double t=0.0;
		
		DynamicModel osc = new ArmDynamics();
		
		double state[] = new double[4];

		RungeKutta rk = new RungeKutta(state, 0.0, dt, osc);

		
		System.out.println("z=[");
		while(t < tend) {
			rk.stepRK();
			
			System.out.println( "["+t+" "+state[0] + " " + state[1] + " "+state[2]+"  "+ state[3] +"]");
			t+=dt;
		}
		System.out.println("]");
	}

}
