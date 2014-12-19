package net.sourceforge.jFuzzyLogic.demo.dynamics.IP;



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
 
 
/**
 * An IPModel object represents the dynamics of an inverted pendulum attached to a
 * sliding block.
 * 
 * @author Andrew Kaluzniacki
 */
public final class IPModel implements Model ,ForceDrivenModel {
 
    private double timeStep=1e-3;
    private double m1 = 0; 	// mass of block
    private double x = 0;	// the position of the block mass (pendulum pivot) - increases to the right
    private double dxdt = 0;	// first time derivative of x    
    private double Fx = 0; 	// the external force applied to the block
    private double Fphi = 0; 	// the external force applied to the pendulum
    
    private double m2 = 0;	// mass of pendulum weight
    private double l = 0; 	// length of pendulum
    private double phi = 0;	// angle of the pendulum  - verticle down is 0, increasing counter clockwise
    private double dphidt = 0;	// first time derivative of phi
    
    private double time = 0;	// time elapsed in simulation
    
    private final double g = 9.8;	// gravity is final
    


    double getDphidt() {
        return dphidt;
    }

    void setPhi(double phi) {
        this.phi = phi;
    }

    public double getDxdt() {
        return dxdt;
    }

   

    public double getM1() {
        return m1;
    }

    public double getM2() {
        return m2;
    }

 
    void setDphidt(double dphidt) {
        this.dphidt = dphidt;
    }

    public void setDxdt(double dxdt) {
        this.dxdt = dxdt;
    }

    public void setX(double x) {
        System.out.println(" IP model set x "+ x);
        this.x = x;
    }
  
    
    
    /** Creates a new instance of IPModel */
    public IPModel() {
        this.reset();
    }

    double getForce() {
      return Fx;
    }

    double getTime() {
        return time;
    }

 

   public  void setForce(double force) {
   //     System.out.println(" " + pPos + "  " + x);
        Fx=force;
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
        
        double v = dxdt;  //  we call v dx
        double w = dphidt;
        double t = time;
        
        // calculate all the new values - using old values
        double k1a = h *   eqDx(t, x, phi, v, w);
        double k1b = h * eqDphi(t, x, phi, v, w);
        double k1c = h *   eqDv(t, x, phi, v, w);
        double k1d = h *   eqDw(t, x, phi, v, w);
        
        double k2a = h *   eqDx(t + h/2.0, x + k1a/2.0, phi + k1b/2.0, v + k1c/2.0, w + k1d/2.0);
        double k2b = h * eqDphi(t + h/2.0, x + k1a/2.0, phi + k1b/2.0, v + k1c/2.0, w + k1d/2.0);
        double k2c = h *   eqDv(t + h/2.0, x + k1a/2.0, phi + k1b/2.0, v + k1c/2.0, w + k1d/2.0);
        double k2d = h *   eqDw(t + h/2.0, x + k1a/2.0, phi + k1b/2.0, v + k1c/2.0, w + k1d/2.0);
        
        
        double k3a = h *   eqDx(t + h/2.0, x + k2a/2.0, phi + k2b/2.0, v + k2c/2.0, w + k2d/2.0);
        double k3b = h * eqDphi(t + h/2.0, x + k2a/2.0, phi + k2b/2.0, v + k2c/2.0, w + k2d/2.0);
        double k3c = h *   eqDv(t + h/2.0, x + k2a/2.0, phi + k2b/2.0, v + k2c/2.0, w + k2d/2.0);
        double k3d = h *   eqDw(t + h/2.0, x + k2a/2.0, phi + k2b/2.0, v + k2c/2.0, w + k2d/2.0);
        
        double k4a = h *   eqDx(t + h, x + k3a, phi + k3b, v + k3c, w + k3d);
        double k4b = h * eqDphi(t + h, x + k3a, phi + k3b, v + k3c, w + k3d);
        double k4c = h *   eqDv(t + h, x + k3a, phi + k3b, v + k3c, w + k3d);
        double k4d = h *   eqDw(t + h, x + k3a, phi + k3b, v + k3c, w + k3d);
        
        double newX = x +     (k1a + 2.0 * k2a + 2.0 * k3a + k4a)/6.0;
        double newPhi = phi + (k1b + 2.0 * k2b + 2.0 * k3b + k4b)/6.0;
        double newV = v +     (k1c + 2.0 * k2c + 2.0 * k3c + k4c)/6.0;
        double newW = w +     (k1d + 2.0 * k2d + 2.0 * k3d + k4d)/6.0;
        
        // now update the old values with the new
        time = t + h;
        x = newX;
        
        phi = newPhi;
        dxdt = newV;
        dphidt = newW;
      
  
    }
    
    
    private double eqDx(double t, double x, double phi, double v, double w) {
        return v; // x' = v
    }
    
    private double eqDphi(double t, double x, double phi, double v, double w) {
        return w; // phi' = w
    }
    
    private double eqDv(double t, double x, double phi, double v, double w) {
        
        double n = 2*(l*Fx - Math.cos(phi) * Fphi + l * Math.sin(phi)* ( g * m1 * Math.cos(phi) + l * m2 * w * w));
        
        double d  = l * (2*m1 + m2 - m2 * Math.cos(2*phi));
        
        return n/d;  // v'
    }
    
    private double eqDw(double t, double x, double phi, double v, double w) {
        
        double n = 2*l*m2*Math.cos(phi)*Fx + 2*(m1+m2)*(-Fphi + g*l*m1*Math.sin(phi)) + l*m2*m2*Math.sin(2*phi)*w*w;
        
        double d = l*l*m2*(-2*m1-m2+m2*Math.cos(2*phi));
        
        return n/d;  // w'
    }
    
    /**
     * propagate the model state through deltaTime using the Runge-Kutta method.
     */
    public void update(double deltaTime) {
        
     //   System.out.println(" **** Model.update");
        double endTime=time+deltaTime;
        
               // break deltaTime into even smaller time steps.
        while(time <endTime) {
            stepRK(timeStep);
        }
        
    };
    
    /**
     * reset the state of the model to an initial state
     */
    public void reset() {
        
        System.out.println(" IP  model reset ");
        m1 = 1.0;
        x = 0;
        dxdt = 0;
        
        Fx = 0;
        Fphi = 0;
        m2 = 1.0;
        l = 1;
        phi = Math.PI; // verticle
        dphidt = 0;
        
        time = 0;
    }
    
    /**
     * return a string representing the state of the model
     */
    public String toString() {
        java.text.DecimalFormat nf = new java.text.DecimalFormat();

        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        nf.setPositivePrefix("+");
        
        return String.format(" phi = %7.1f \t dphidt= %7.1f \t x= %7.2f \t dxdt= %7.1f \t force= %7.1f" 
                , getPhiInDegrees(),getDPhiDtInDegrees(),x,dxdt,Fx);
            
    }
    
    /**
     * return the current value of x
     */    
    public double getX() {
        return x;
    }
    
     /**
     * return the current value of phi
     */    
    public double getPhiInDegrees() {
        return -(180*Math.IEEEremainder(phi+Math.PI,Math.PI*2)/Math.PI);
    }
    
    
      /**
     * return the current value of phi in degrees
     */    
    public void setPhiInDegrees(double deg) {
        phi=-(Math.PI+deg*Math.PI/180.0);
    }
    
    
     /**
     * @return the current value of phi in degrees (clockwise from vertical)
     */    
    public double getDPhiDtInDegrees() {
        return -180.0*dphidt/Math.PI;
    }
    
     /**
     * return the current value of phi
     */    
    double getPhi() {
        return phi;
    }
    
     /**
     * return the current value of l
     */    
    public double getL() {
        return l;
    }
    
 
    /**
     * main() serves as a simple demo of IPModel and runs the model through 10 seconds of
     * time outputing the state to the console
     * In typical use of IPModel, main() would not be called
     * @param args the command line arguments - these are ignored
     */
    public static void main(String[] args) {
        System.out.println("Inverted Pendulum Model - run for 10 seconds..\n");
        
        IPModel model = new IPModel();
        
        // run for 10 seconds.
        for (double t = 0.0; t <= 10.0; t = t + 0.1) {
            System.out.println(model);
            model.update(0.1);
        }
    }

	
}
