/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sourceforge.jFuzzyLogic.demo.dynamics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import net.sourceforge.jFuzzyLogic.defuzzifier.Defuzzifier;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierContinuous;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete;
import net.sourceforge.jFuzzyLogic.plot.PlotWindow;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author pjl
 */
public class DemoPanelFis extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int nx;
	private final int ny;
	List<Variable> vars;

	DemoPanelFis(List<Variable> variables, int nx, int ny) {
		vars = variables;
		this.nx = nx;
		this.ny = ny;
	}

	/**
	 * Create a chart showing each linguistic term
	 * @param showIt : If true, plot is displayed
	 */
	public JFreeChart chart(Variable v) {
		boolean discrete = true;
		boolean plotDefuzz = false;

		double universeMin = v.getUniverseMin();
		double universeMax = v.getUniverseMax();

		// Sanity check
		if (Double.isNaN(universeMin) || Double.isInfinite(universeMax)) {
			v.estimateUniverse();
			universeMin = v.getUniverseMin();
			universeMax = v.getUniverseMax();

		}
		int numberOfPoints = PlotWindow.DEFAULT_CHART_NUMBER_OF_POINTS;
		double step = (universeMax - universeMin) / (numberOfPoints);

		// Create a data set
		XYSeriesCollection xyDataset = new XYSeriesCollection();

		//---
		// Current value
		//---
		double value = v.getValue();
		if (!Double.isNaN(value)) {
			XYSeries seriesValue = new XYSeries("");
			seriesValue.setDescription(null);
			seriesValue.add(value - 2 * step, 0);
			seriesValue.add(value - step, 1);
			seriesValue.add(value, 1);
			seriesValue.add(value + step, 1);
			seriesValue.add(value + 2 * step, 0);
			xyDataset.addSeries(seriesValue);
		}

		String name = v.getName();

		String topTitle = name;
		//---
		// Plot deffuzyfier values (if any)
		//---
		Defuzzifier defuzzifier = v.getDefuzzifier();

		if ((defuzzifier != null) && (defuzzifier instanceof DefuzzifierContinuous)) {
			DefuzzifierContinuous def = (DefuzzifierContinuous) defuzzifier;

			double latestDefuzzifiedValue = v.getLatestDefuzzifiedValue();
			String title = name; // String.format("%s:%2.2f (%s)", name, latestDefuzzifiedValue, defuzzifier.getName());
			topTitle += "=" + String.format("% 6.2f", latestDefuzzifiedValue);
			XYSeries series = new XYSeries(title);
			double values[] = def.getValues();
			numberOfPoints = values.length;
			double xx = def.getMin();
			step = (def.getMax() - def.getMin()) / (numberOfPoints);
			for (int i = 0; i < numberOfPoints; i++, xx += step)
				series.add(xx, values[i]); // Add serie to dataSet
			xyDataset.addSeries(series);
			plotDefuzz = true;
		}

		//---
		// Plot each linguistic term (create an xyDataSet and append it)
		//---
		int j = 0;
		for (LinguisticTerm lt : v) {
			// Add this linguistic term to dataset
			MembershipFunction membershipFunction = lt.getMembershipFunction();
			discrete &= membershipFunction.isDiscrete();

			// Create a series and add points
			XYSeries series = new XYSeries(lt.getTermName());
			if (membershipFunction.isDiscrete()) {
				// Discrete case: Evaluate membership function and add points to dataset
				MembershipFunctionDiscrete membershipFunctionDiscrete = (MembershipFunctionDiscrete) membershipFunction;
				numberOfPoints = membershipFunctionDiscrete.size();
				for (int i = 0; i < numberOfPoints; i++) {
					//System.out.println(membershipFunctionDiscrete.valueX(i)+" "+ membershipFunctionDiscrete.membership(i));
					series.add(membershipFunctionDiscrete.valueX(i), membershipFunctionDiscrete.membership(i));
				}
			} else {
				// Continuous case: Add every membershipfunction's point 
				numberOfPoints = PlotWindow.DEFAULT_CHART_NUMBER_OF_POINTS;
				double xx = universeMin;
				for (int i = 0; i < numberOfPoints; i++, xx += step)
					series.add(xx, membershipFunction.membership(xx));
			}

			// Add serie to dataSet
			xyDataset.addSeries(series);
			j++;
		}

		// Create chart and show it
		JFreeChart chart;

		if (!discrete) chart = ChartFactory.createXYAreaChart(topTitle, "x", "Membership", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		else chart = ChartFactory.createScatterPlot(topTitle, "x", "Membership", xyDataset, PlotOrientation.VERTICAL, true, true, false); // Set 'Value' color to BLACK 
		XYPlot plot = chart.getXYPlot();
		plot.getRenderer().setSeriesPaint(0, Color.BLACK);
		// Set 'deffuzifier' color to GREY 
		if (plotDefuzz) plot.getRenderer().setSeriesPaint(1, Color.gray);

		return chart;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int w = getWidth(), h = getHeight();

		int nx1 = nx;
		int ny1 = ny;

		//------------------
		int plotSizex = w / nx1;
		int plotSizey = h / ny1;
		Rectangle2D rect = new Rectangle2D.Double();

		// Plot each variable

		Iterator<Variable> iter = vars.iterator();
		for (int ix = 0; ix < nx1; ix++)
			for (int iy = 0; iy < ny1; iy++) {
				if (!iter.hasNext()) return;
				Variable var = iter.next();

				rect.setFrame(ix * plotSizex, iy * plotSizey, plotSizex, plotSizey);
				chart(var).draw((Graphics2D) g, rect);

			}
	}
}
