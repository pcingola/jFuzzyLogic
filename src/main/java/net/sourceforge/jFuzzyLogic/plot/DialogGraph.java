package net.sourceforge.jFuzzyLogic.plot;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

import org.jfree.chart.JFreeChart;

/**
 * 
 * Dialog windows where you can see a graph
 * 
 * Code provided by: Carmelo (cswi)
 *
 */
public class DialogGraph extends JDialog {

	public static int DEFAULT_HEIGHT = 250;
	public static int DEFAULT_WIDTH = 425;
	public static int posx = 0;
	public static int posy = 0;
	private static final long serialVersionUID = 1L;

	PanelPaintGraph panel;

	public static DialogGraph execute(JFreeChart chart) {
		return execute(chart, posx, posy, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public static DialogGraph execute(JFreeChart chart, int width, int height) {
		return execute(chart, posx, posy, width, height);
	}

	public static DialogGraph execute(JFreeChart chart, int posx, int posy, int width, int height) {
		if (chart == null) return null;

		DialogGraph dg = new DialogGraph(null, false);
		dg.panel = new PanelPaintGraph(chart);
		dg.setSize(width, height);
		dg.setLocation(posx, posy);
		dg.setLayout(new BorderLayout());
		dg.getContentPane().add(dg.panel, BorderLayout.CENTER);
		dg.setVisible(true);
		nextPosition(width, height);
		return dg;
	}

	/**
	 * Prepare coordinates for next plot
	 * @param sizex
	 * @param sizey
	 */
	public static void nextPosition(int sizex, int sizey) {
		// Screen size, to be able to position the plots automatically
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Positions for next plot
		posx += sizex;
		if ((posx + sizex) > screenSize.width) { // Out of screen?
			posx = 0;
			posy += sizey;
		}

		if ((posy + sizey) > screenSize.height) { // Out of screen?
			posx = 0;
			posy = 0;
		}

	}

	private DialogGraph(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public PanelPaintGraph getPanel() {
		return panel;
	}

	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		BoxLayout layout = new BoxLayout(getContentPane(), 0);
		getContentPane().setLayout(layout);
		pack();
	}

	public void setPanel(PanelPaintGraph panel) {
		this.panel = panel;
	}

}
