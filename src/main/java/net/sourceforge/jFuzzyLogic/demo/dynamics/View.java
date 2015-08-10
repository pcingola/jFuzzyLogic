/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sourceforge.jFuzzyLogic.demo.dynamics;


import java.awt.Component;

/**
 *
 * @author pjl
 */
public interface  View {

    public Component getDisplayPanel();

    public void modelStateChanged();
    
    // is human controlling the object ?
    public boolean isHumanActive();
    
    public void reset();

    public void setModel(Model model);

}
