package net.sourceforge.jFuzzyLogic.test.performance;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;

import net.sourceforge.jFuzzyLogic.plot.PlotWindow;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PerformanceChart {

	private String chartTitle;
	private int stepSize;
	private XYSeriesCollection xyDataset;

	public PerformanceChart(int stepSize, String chartTitle) {
		super();
		this.stepSize = stepSize;
		xyDataset = new XYSeriesCollection();
		this.chartTitle = chartTitle;
	}

	void addData(List<Double> data, String title) {
		int xx = 0;
		XYSeries series = new XYSeries(title);
		for( int i = 0; i < data.size(); i++, xx += stepSize ) {
			series.add(xx, ((Double) data.get(i)).doubleValue());
		}
		xyDataset.addSeries(series);
	}

	void display(String windowTitle) {
		//		 Create plot and show it
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, "No. of Fuzzy Inference Cycles", "Time (ms)", xyDataset, PlotOrientation.VERTICAL, true, true, true);
		chart.setBackgroundPaint(Color.white);
		final XYPlot xyPlot = chart.getXYPlot();
		final XYItemRenderer renderer = xyPlot.getRenderer();

		if( renderer instanceof XYLineAndShapeRenderer ) {
			final XYLineAndShapeRenderer rr = (XYLineAndShapeRenderer) renderer;
			//rr.setShapesVisible(true);
			// rr.setDefaultShapesFilled(false);
			rr.setSeriesStroke(1, new BasicStroke(1.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[] { 6f, 3f }, 0.0f));
			rr.setSeriesStroke(2, new BasicStroke(1.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[] { 10f, 6f }, 0.0f));
			rr.setSeriesStroke(3, new BasicStroke(1.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[] { 5f, 5f }, 0.0f));
			rr.setSeriesPaint(0, Color.BLACK);
			rr.setSeriesPaint(1, Color.GREEN);
			rr.setSeriesPaint(2, Color.RED);
			rr.setSeriesPaint(3, Color.BLUE);
			rr.setLinesVisible(true);
			//rr.setSeriesShape(0, ShapeUtilities.createDiamond(5));
		}

		PlotWindow.showIt(windowTitle, chart);
	}
}
