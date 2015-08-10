package net.sourceforge.jFuzzyLogic.demo.dynamics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import net.sourceforge.jFuzzyLogic.demo.dynamics.IP.IPDemo;
import net.sourceforge.jFuzzyLogic.demo.dynamics.arm.ArmDemo;
import net.sourceforge.jFuzzyLogic.demo.dynamics.block.BlockDemo;
import net.sourceforge.jFuzzyLogic.demo.dynamics.generic.GenericDemo;

/**
 * Fuzzy control demo: Inverted pendulum problem
 * @author pjl
 */
public class FuzzyDemoApp {

	static FuzzyDemo demo;
	static JFrame frame;
	
	public static void main(String args[]) throws FileNotFoundException {
		frame = new JFrame();
	
		JMenuBar bar=new JMenuBar();
		frame.setJMenuBar(bar);
		JMenu menu=new JMenu("Model");
		bar.add(menu);
		JMenuItem item=new JMenuItem("Segway");
		menu.add(item);
		
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FuzzyDemo demo = new IPDemo(FuzzyDemoApplet.class.getResourceAsStream("IP/ip2.fcl"), false);
				demoStart(demo);
			}
		});
		
		item=new JMenuItem("Robot Arm");
		menu.add(item);
		
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FuzzyDemo demo = new ArmDemo(FuzzyDemoApplet.class.getResourceAsStream("arm/arm.fcl"), false);
				demoStart(demo);
			}
		});
		
		
		item=new JMenuItem("Block");
		menu.add(item);
		
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FuzzyDemo demo = new BlockDemo(FuzzyDemoApplet.class.getResourceAsStream("block/block.fcl"), false);
				demoStart(demo);
			}
		});
		
		
//		item=new JMenuItem("Tipper");
//		menu.add(item);
//		
//		item.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				FuzzyDemo demo = new GenericDemo(FuzzyDemoApplet.class.getResourceAsStream("tipper/tipper.fcl"), false);
//				demoStart(demo);
//			}
//		});
		
		
		frame.setSize(1000, 800);
		frame.setVisible(true);
	}
	
	public static void demoStart(FuzzyDemo demoNew){
		if (demo != null) {
			demo.dispose();
		}
		demo=demoNew;
		frame.setContentPane(demo.getPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(demo.getTitle());
		demo.start();
		frame.validate();
		frame.repaint();
		
	}

}
