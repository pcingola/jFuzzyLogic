package net.sourceforge.jFuzzyLogic.plot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import org.jfree.chart.JFreeChart;

/**
 * Paints the JFreeChart
 */
public class PanelPaintGraph extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFreeChart chart;

	public PanelPaintGraph(JFreeChart chart) {
		this.chart = chart;
	}

	public JFreeChart getChart() {
		return chart;
	}

	@Override
	public void paintComponent(Graphics g) {
		if( chart != null ) {
			Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
			chart.draw((Graphics2D) g, rect);
		}
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

}
