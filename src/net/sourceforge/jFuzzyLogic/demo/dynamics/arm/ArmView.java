package net.sourceforge.jFuzzyLogic.demo.dynamics.arm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.JPanel;

/*
 * IPView.java
 *
 * Created on March 31, 2004, 5:57 PM
 *
 *  Copyright 2004 Andrew Kaluzniacki
 *  All rights reserved.
 *  http://drewk.net
 *
 * Modifications 2008 by Paul Leonard for fuzzy logic demo.
 * 
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

import net.sourceforge.jFuzzyLogic.demo.dynamics.Model;
import net.sourceforge.jFuzzyLogic.demo.dynamics.View;

/**
 * IPView provides a view of IPModel
 * @author drew
 * 
 * pjl modifications for Fuzzy Logic Demo
 */
public class ArmView extends JPanel implements View {

    private ArmModel model;
	private int xA;
	private int yA;
	private double scale;

   
   
    public ArmView() {
        setDoubleBuffered(true);
      //  setBackground(Color.PINK);

        setToolTipText(" Press the mouse to pull the block ");
        // allow user to pull using the mouse
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                setTargetAt(e.getX(), e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });



    }

    void setTargetAt(int x, int y) {
        //      System.out.println(" Set force at ");

        //double fx = screenToForce(x - worldToScreen(model.getX()));
    	
    	double xM=(x-xA)/scale;
    	double yM=-(y-yA)/scale;
    	
        model.setTarget(xM,yM);
        repaint();
    }

    ArmModel getModel() {
        return model;
    }

    @Override
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
       //	if (true) return;
        Graphics2D g2 = (Graphics2D) g;      // in most cases (ours) this is a safe cast


        if (model == null) {
            return;        // get the dimensions of the JPanel so that we can scale everything properly
        //  Insets insets = getInsets();
        }
        
        //System.out.println(model);
        
        int viewWidth = getWidth();// - insets.left - insets.right;
        int viewHeight = getHeight();// - insets.top - insets.bottom;

        
        scale=0.5*Math.min(viewWidth,viewHeight)/(model.arm.L1+model.arm.L2);
        
        
        xA=viewWidth/2;
        yA=viewHeight/2;
        
        
        g2.setColor(Color.CYAN);
      //  g2.drawLine(0,0,viewWidth,viewHeight); // arg1, arg2, arg3)

        int x1=xA;
        int x2=xA+(int)(scale*model.x1);
        int x3=xA+(int)(scale*model.x2);
        int y1=yA;
        int y2=yA-(int)(scale*model.y1);
        int y3=yA-(int)(scale*model.y2);
        Stroke sOrig=g2.getStroke();
        
        int rad=16;
        
        BasicStroke s=new BasicStroke(rad,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND);
        g2.setStroke(s);
        
        
        g2.drawLine(x1,y1,x2,y2);
        g2.drawLine(x2,y2,x3,y3);
        
        g2.setColor(Color.PINK);
        
        g2.fillOval(x1-rad,y1-rad, 2*rad, 2*rad);
        g2.fillOval(x2-rad,y2-rad, 2*rad, 2*rad);
        g2.setColor(Color.RED);
        g2.fillOval(x3-rad,y3-rad, 2*rad, 2*rad);
        
        
        
        int xTar=(int) (xA+model.xTarget*scale);
        int yTar=(int) (yA-model.yTarget*scale);
        
        g2.setStroke(sOrig);
        
        g2.setColor(Color.BLACK);
        g2.fillOval(xTar-3, yTar-3, 7, 7);
        
        
        double x1t=model.arm.L1*Math.cos(model.phi1target);
        double y1t=model.arm.L1*Math.sin(model.phi1target);
       
        double x2t=x1t+model.arm.L2*Math.cos(model.phi1target+model.phi2target);
        double y2t=y1t+model.arm.L2*Math.sin(model.phi1target+model.phi2target);
        

        x2=xA+(int)(scale*x1t);
        x3=xA+(int)(scale*x2t);
        
        y2=yA-(int)(scale*y1t);
        y3=yA-(int)(scale*y2t);
        
        g2.drawLine(x1,y1,x2,y2);
        g2.drawLine(x2,y2,x3,y3);
       
        
        
    }

    public void reset() {
       
    }

    /**
     * associate a model with this view
     */
    public void setModel(Model aModel) {
        model = (ArmModel) aModel;
    }

    /**
     * call when a state change in the model requires an update to the view
     */
    public void modelStateChanged() {
        //       System.out.println("VIew.modelStateChanged");
        //  validate();
        repaint();
    }

  

    public Component getDisplayPanel() {
        return this;
    }


    public boolean isHumanActive() {
        return false; //isMouseActive;
    }
}
