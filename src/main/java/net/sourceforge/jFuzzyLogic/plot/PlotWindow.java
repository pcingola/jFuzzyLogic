package net.sourceforge.jFuzzyLogic.plot;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * Create a window and show a chart 
 * @author pcingola@users.sourceforge.net
 */
public class PlotWindow extends ApplicationFrame {

	private static final long serialVersionUID = 2415305565840273359L;

	public static int DEFAULT_CHART_NUMBER_OF_POINTS = 1024;
	public static int DEFAULT_WIDTH = 500;
	public static int DEFAULT_HEIGHT = 300;

	public static void showIt(String windowTitle, JFreeChart chart) {
		PlotWindow plotWindow = new PlotWindow(windowTitle, chart);
		plotWindow.pack();
		RefineryUtilities.centerFrameOnScreen(plotWindow);
		plotWindow.setVisible(true);
	}

	private PlotWindow(String windowTitle, JFreeChart chart) {
		super(windowTitle);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setContentPane(chartPanel);
	}

}
