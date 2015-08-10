package net.sourceforge.jFuzzyLogic.demo.dynamics.IP;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;

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
public class IPView extends JPanel implements View {

    private IPModel model;
    int xOffDefault = 50;
    int xOff = xOffDefault;
    double xScale = 200.0;    // constants
    static final int rightAx[] = {0, 20, 0};
    static final int gAy[] = {10, 0, -10};
    static final int leftAx[] = {0, -20, 0};
    static final Shape arrowL = new Polygon(leftAx, gAy, 3);
    static final Shape arrowR = new Polygon(rightAx, gAy, 3);
    static final int blockWidth = 40;
    static final int blockHeight = 20;
    static final int penMassRadius = 15;
    static final double armLen = .4;  // todo look at model
    private boolean isMouseActive;
    private double forceScale = 1.0;
    static Image homeImage = new ImageIcon(IPView.class.getResource("house.gif")).getImage();
    static Image treeImage = new ImageIcon(IPView.class.getResource("tree.gif")).getImage();
    static Image leftImage = new ImageIcon(IPView.class.getResource("left.gif")).getImage();
    static Image rightImage = new ImageIcon(IPView.class.getResource("right.gif")).getImage();

    /** Creates new form IPView */
    public IPView() {
        setDoubleBuffered(true);
        setBackground(Color.LIGHT_GRAY);

        setToolTipText(" Press the mouse to pull the block ");
        // allow user to pull using the mouse
        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                setForceAt(e.getX(), e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                isMouseActive = true;
                setForceAt(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isMouseActive = false;
                model.setForce(0.0);
                repaint();
            }
        });

    }

    void setForceAt(int x, int y) {
        //      System.out.println(" Set force at ");

        double fx = screenToForce(x - worldToScreen(model.getX()));
        model.setForce(fx);
        repaint();
    }

    IPModel getModel() {
        return model;
    }

    @Override
    public void paintComponent(Graphics g) {
        //   System.out.println(" VIEW.paint ################################################## ");

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;      // in most cases (ours) this is a safe cast


        if (model == null) {
            return;        // get the dimensions of the JPanel so that we can scale everything properly
        //  Insets insets = getInsets();
        }
        int viewWidth = getWidth();// - insets.left - insets.right;
        int viewHeight = getHeight();// - insets.top - insets.bottom;

        // scale the size of the model to the size of the view.
        // the constants are chosen for asthetics, but could be based on say
        // the masses of  the objects.
        // Note that for the view to be physiclly correct, l and x must be
        // correctly proportianal. ( FIXME - better explaination )

        double modelX = model.getX();
        double modelPhi = model.getPhi();


        int blockX = worldToScreen(modelX);

        //  very lazy way to adjust the offset to keep block on screen
        while (blockX < viewWidth / 8.0) {
            xOff++;
            blockX = worldToScreen(modelX);
        }

        while (blockX > 7.0 * viewWidth / 8.0) {
            xOff--;
            blockX = worldToScreen(modelX);
        }


        // OK now we can get on with drawing.
        
        int homeX = worldToScreen(0.0);
        int hiw = homeImage.getWidth(null);


        int blockY = (int) (viewHeight / 2);

        if ((homeX + hiw) > 0 || homeX < viewWidth) {
            g2.drawImage(homeImage, homeX, blockY - blockHeight - 70, null);
        }

        double wL=screenToWorld(0);
        double wR=screenToWorld(viewWidth);
        double treeSpacing=800/xScale;
        
        wL = treeSpacing*(Math.floor(wL/treeSpacing)+0.5);
       int treeH=treeImage.getHeight(null);
       int treeW=treeImage.getWidth(null);
        
        for(;wL<wR;wL+=treeSpacing){
            int x;
            g2.drawImage(treeImage, x=worldToScreen(wL), blockY - treeH, null);
            
        }
     
       int xxx=blockX-leftImage.getWidth(null)/2;
       int yyy=rightImage.getHeight(null);
        if (blockX > homeX+hiw) {
            g2.drawImage(leftImage,xxx,yyy, null);           
        } else if (blockX < homeX){
          g2.drawImage(rightImage, xxx,yyy, null);           
        }
    
        g2.drawString(String.format("%+5.2f",-modelX), xxx+10,yyy-10);
       
        g2.fillRect(0, blockY - blockHeight - 5, viewWidth, 2 * blockHeight + 25);
        // draw ticks to show any frame of reference motion
        int tickSpacing = 100;
        int tickX = xOff - tickSpacing * (xOff / tickSpacing);
        if (tickX < -tickSpacing/2) {
            tickX += tickSpacing;
        }
        g2.setColor(Color.WHITE);

        g2.setStroke(new BasicStroke(8));

        while (tickX < viewWidth) {
            g2.fillRect(tickX, blockY + 2, tickSpacing / 2, 4);
            tickX += tickSpacing;
        }

        //    System.out.println(tickX);

        // paint the block
        g2.setColor(Color.blue);
        g2.fill(new Rectangle(blockX - blockWidth / 2, blockY - blockHeight, blockWidth, blockHeight));


//        int zeroX = worldToScreen(0.0);
//        int targetWid = blockWidth + 2;

        // paint the target
//        g2.setColor(Color.BLACK);
//        g2.fill(new Rectangle(zeroX - targetWid, blockY + 4, targetWid, 16));
//        g2.setColor(Color.WHITE);
//
//        g2.drawString("PARKING", zeroX - targetWid + 1, blockY + 14);

        // paint the pendulum mass

        // position of the pendulum blob
        int penX = (int) (blockX + armLen * xScale * Math.sin(modelPhi));
        int penY = (int) (blockY + armLen * xScale * Math.cos(modelPhi) - blockHeight);

        g2.setColor(Color.red);
        g2.fillOval(penX - penMassRadius, penY - penMassRadius, 2 * penMassRadius, 2 * penMassRadius);

        g2.setStroke(new BasicStroke(4));

        // paint the rod
        g2.drawLine(blockX, blockY - blockHeight, penX, penY);
        g2.setColor(Color.BLACK);
        int pivotRad = 4;

        // little circle at the pivot
        g2.drawOval(blockX - pivotRad, blockY - pivotRad - blockHeight,
                2 * pivotRad, 2 * pivotRad);

        // draw the force acting on block

        if (isHumanActive()) {
            g2.setColor(Color.ORANGE);
        } else {
            g2.setColor(Color.YELLOW);
        }

        int fX = forceToScreen(model.getForce());

        if (fX > 0) {
            int xx = blockX;
            int yy = blockY - blockHeight / 2;
            g2.drawLine(xx, yy, xx + fX, yy);
            g2.translate(xx + fX, yy);
            g2.fill(arrowR);
            g2.translate(-(xx + fX), -yy);

        } else if (fX < 0) {
            int xx = blockX;
            int yy = blockY - blockHeight / 2;

            g2.drawLine(xx, yy, xx + fX, yy);
            g2.translate(xx + fX, yy);
            g2.fill(arrowL);
            g2.translate(-(xx + fX), -yy);


        }

        g2.setColor(Color.BLACK);
        // show human the state
        g2.drawString("XREF=" + xOff + "   " + model.toString(), 10, getHeight() - 10);
    }

    public void reset() {
        xOff = xOffDefault;
    }

    /**
     * associate a model with this view
     */
    public void setModel(Model aModel) {
        model = (IPModel) aModel;
    }

    /**
     * call when a state change in the model requires an update to the view
     */
    public void modelStateChanged() {
        //       System.out.println("VIew.modelStateChanged");
        //  validate();
        repaint();
    }

    public int worldToScreen(double x) {
        return (int) (xOff + x * xScale);

    }

    public double screenToWorld(int x) {
        return (x - xOff) / xScale;
    }

    public int forceToScreen(double x) {
        return (int) (x / forceScale);

    }

    public double screenToForce(int x) {
        return x * forceScale;
    }

    public Component getDisplayPanel() {
        return this;
    }


    public boolean isHumanActive() {
        return isMouseActive;
    }
}
