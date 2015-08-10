package net.sourceforge.jFuzzyLogic.demo.dynamics.generic;


import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sourceforge.jFuzzyLogic.demo.dynamics.Model;
import net.sourceforge.jFuzzyLogic.demo.dynamics.View;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * IPView provides a view of IPModel
 * @author drew
 * 
 * pjl modifications for Fuzzy Logic Demo
 */
public class GenericView extends JPanel implements View {

    private  GenericModel model;
    /** Creates new form IPView */
    public GenericView(GenericModel model) {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setModel(model);
    }


    GenericModel getModel() {
        return model;
    }


    /**
     * associate a model with this view
     */
    public void setModel(Model aModel) {
        model = (GenericModel) aModel;
        for (final Variable v:model.getVariables()) {
            JPanel p=new JPanel();
            p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
            JLabel lab=new JLabel(v.getName());
            final JSlider slider=new JSlider(0,1000);
            p.add(lab);
            p.add(slider);
            final double maxv=v.getUniverseMax();
            final double minv=v.getUniverseMin();
            
            slider.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    double x=minv+(slider.getModel().getValue())*(maxv-minv)/1000.0;
                    v.setValue(x);
                }
            });
           add(p); 
            
           System.out.println(" Added " + v.getName());
        }
        validate();
        repaint();
    }

    /**
     * call when a state change in the model requires an update to the view
     */
    public void modelStateChanged() {
        //       System.out.println("VIew.modelStateChanged");
        validate();
        repaint();
    }

    public Component getDisplayPanel() {
        return this;
    }

 
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isHumanActive() {
        return false; // throw new UnsupportedOperationException("Not supported yet.");
    }

}
