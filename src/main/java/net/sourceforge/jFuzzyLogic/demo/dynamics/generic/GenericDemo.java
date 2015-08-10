package net.sourceforge.jFuzzyLogic.demo.dynamics.generic;

import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sourceforge.jFuzzyLogic.demo.dynamics.FuzzyDemo;

 /*
 * @author pjl
 */
public class GenericDemo extends FuzzyDemo {
  
    
    public GenericDemo(InputStream in,boolean applet) {
        super(in,applet);
    }
    public void initModelImpl(InputStream in) {
     //   fclFile = new File("fcl/block.fcl");
        model = new GenericModel();      
        fuzzyController = new GenericFuzzyController((GenericModel) model, in);
        view  = new GenericView((GenericModel)model);
        //view.setModel(model);
    
    }

    protected void addControlsImpl(JPanel cntrl) {

//        cntrl.add(new JButton(new AbstractAction("ZERO") {
//            public void actionPerformed(ActionEvent e) {
//                ((GenericModel) model).reset();
//            }
//        }));
//        
//        
//        cntrl.add(new JButton(new AbstractAction("RANDOM") {           
//            final Random rand=new Random();
//            public void actionPerformed(ActionEvent e) {
//                ((GenericModel) model).reset();                
//                ((GenericModel) model).setX((rand.nextDouble() -0.5)*2);
//                ((GenericModel) model).setDxdt((rand.nextDouble() -0.5)*2);
//            }            
//        }));
    }

    
    JSlider posSlider;
 @Override
 
    protected void addFuzzyControls(JPanel cntrl) {
//        
//        JPanel sp = new JPanel();
//        sp.add(new JLabel("Position:"));
////        final double  maxAng=50;
//        final double  steps=200;
////        final double fact=maxAng/steps/steps;
////        
//        posSlider = new JSlider((int)-steps, (int)steps);
//        //     final SpinnerNumberModel smA = new SpinnerNumberModel((int) angle, -180, 180, 1);
//        posSlider.addChangeListener(new ChangeListener() {
//
//            
//            public void stateChanged(ChangeEvent e) {
//                double x = 3.0*posSlider.getValue()/(double)steps;
//                ((GenericFuzzyController) fuzzyController).setTargetPosition(x);
//            }
//        });
//        posSlider.setEnabled(fuzzyControlActive);
//        sp.add(posSlider);
//
//        cntrl.add(sp);

    }
 
  @Override
    protected void setActiveImpl(boolean yes) {
//        posSlider.setEnabled(fuzzyControlActive);       
    }
@Override
public String getTitle() {
	// TODO Auto-generated method stub
	return null;
}
}
