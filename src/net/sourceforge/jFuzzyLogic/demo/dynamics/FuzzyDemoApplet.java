
package net.sourceforge.jFuzzyLogic.demo.dynamics;

import java.io.InputStream;
import javax.swing.JMenuBar;

import net.sourceforge.jFuzzyLogic.demo.dynamics.IP.IPDemo;
import net.sourceforge.jFuzzyLogic.demo.dynamics.arm.ArmDemo;

/**
 * P.J.Leonard : Fuzzy logic demo Sep 2008
 *
 */
public  class FuzzyDemoApplet extends javax.swing.JApplet {
   
    FuzzyDemo demo;

    /** Initializes the applet IPApplet */
    @Override
    public void init() {
    	
    	demo = new ArmDemo(FuzzyDemoApplet.class.getResourceAsStream("arm/arm.fcl"), false);
		
        setContentPane(demo.getPanel());
        //setSize(800,800);
    }

    
    // start the applet
    @Override
    public void start() {
       demo.start();
     }
    
    // stop the applet
    @Override
    public void stop() {
        demo.stop();
    } 
}



