package net.sourceforge.jFuzzyLogic.demo.dynamics.IP;

import java.awt.event.ActionEvent;
import java.io.InputStream;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sourceforge.jFuzzyLogic.demo.dynamics.FuzzyDemo;

/**
 *
 * @author pjl
 */
public class IPDemo extends FuzzyDemo {

    private double angle;
    private double startingX;
    private JSlider angleSlider;

    
    public IPDemo(InputStream in,boolean applet) {
        super(in,applet);
    }
    
    public void initModelImpl(InputStream fclInput) {
        angle = 0.01;
        startingX = 3.0;
        
        
       // fclFile = new File("fcl/ip2.fcl");
        
        
        model = new IPModel();
        view = new IPView();

        //     humanController = new HumanForceController((ForceDrivenModel) model);
        fuzzyController = new IPFuzzyController2((IPModel) model, fclInput);

        ((IPModel) model).setX(startingX);

        ((IPModel) model).setPhiInDegrees(angle);
        view.setModel(model);
    }

    protected void addControlsImpl(JPanel cntrl) {
        cntrl.add(new JButton(new AbstractAction("RESET") {

            public void actionPerformed(ActionEvent e) {
                //    ((HumanForceController) humanController).getSlider().setValue(0);
                ((IPModel) model).reset();
                ((IPModel) model).setX(startingX);
                //       ((IPModel) model).setPhiInDegrees(0.0);
                view.reset();
                view.modelStateChanged();

            }
        }));

    
    }

    @Override
    protected void addFuzzyControls(JPanel cntrl) {
        JPanel sp = new JPanel();
        sp.add(new JLabel("Angle:"));
        final double  maxAng=50;
        final double  steps=200;
        final double fact=maxAng/steps/steps;
        
        angleSlider = new JSlider((int)-steps, (int)steps);
        //     final SpinnerNumberModel smA = new SpinnerNumberModel((int) angle, -180, 180, 1);
        angleSlider.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {
                angle = angleSlider.getValue();
                angle= Math.abs(angle)*angle*fact;
                ((IPFuzzyController2) fuzzyController).setTargetAngle(angle);
            }
        });
        angleSlider.setEnabled(fuzzyControlActive);
        sp.add(angleSlider);

        cntrl.add(sp);

    }

    @Override
    protected void setActiveImpl(boolean yes) {
        angleSlider.setEnabled(fuzzyControlActive);       
    }

	@Override
	public String getTitle() {
	
		return "Segway Demo";
	}
}
