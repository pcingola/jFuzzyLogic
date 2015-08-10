package net.sourceforge.jFuzzyLogic.plot;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.defuzzifier.Defuzzifier;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierContinuous;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierDiscrete;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionContinuous;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * 
 * Charts variables, membership functions, function blocks, etc.
 * 
 * Code provided by: Carmelo (cswi)
 *
 */
public class JFuzzyChartImpl extends JFuzzyChart {

	/**
	 * Create a defuzzifier's chart 
	 * @param title : Title to show (if null => show membership function name)
	 * @param showIt : If true, plot is displayed
	 */
	@Override
	public void chart(Defuzzifier def, String title, boolean showIt) {
		//		if (def.isDiscrete()) return chartDefuzzifierDiscrete((DefuzzifierDiscrete) def, title, showIt);
		//		return chartDefuzzifierContinuous((DefuzzifierContinuous) def, title, showIt);
		if (def.isDiscrete()) chartDefuzzifierDiscrete((DefuzzifierDiscrete) def, title, showIt);
		else chartDefuzzifierContinuous((DefuzzifierContinuous) def, title, showIt);
	}

	/** 
	 * Show a chart for each function block 
	 */
	@Override
	public void chart(FIS fis) {
		for (FunctionBlock fb : fis)
			chart(fb);
	}

	/** 
	 * Show a chart for each variable in a function block 
	 */
	@Override
	public void chart(FunctionBlock fb) {
		// Plot each variable
		for (Variable var : fb.variables()) {
			JFreeChart chart = chartCreate(var, false); // Code adapted by: Carmelo (cswi)
			DialogGraph.execute(chart);
		}
	}

	/**
	 * Create a membership function chart 
	 * @param showIt : If true, plot is displayed
	 */
	@Override
	public void chart(LinguisticTerm lt, boolean showIt) {
		(new JFuzzyChartImpl()).chart(lt.getMembershipFunction(), lt.getTermName(), showIt);
	}

	/**
	 * Create a membership function chart 
	 * @param title : Title to show (if null => show membership function name)
	 * @param showIt : If true, plot is displayed
	 */
	@Override
	public void chart(MembershipFunction mf, String title, boolean showIt) {
		if (mf.isDiscrete()) chartMembershipFunctionDiscrete((MembershipFunctionDiscrete) mf, title, showIt);
		else chartMembershipFunctionContinuous((MembershipFunctionContinuous) mf, title, showIt);
	}

	/**
	 * Create a chart showing each linguistic term
	 * @param showIt : If true, plot is displayed
	 */
	@Override
	public void chart(Variable var, boolean showIt) {
		chartCreate(var, showIt);
	}

	/**
	 * Create a chart showing defuzzifier 
	 * @param showIt : If true, plot is displayed
	 */
	@Override
	public void chart(Variable var, Defuzzifier defuzzifier, boolean showIt) {
		String title = String.format("%s:%2.2f (%s)", var.getName(), var.getLatestDefuzzifiedValue(), defuzzifier.getName());

		JFreeChart chart;
		if (defuzzifier.isDiscrete()) chart = chartDefuzzifierDiscrete((DefuzzifierDiscrete) defuzzifier, title, false);
		else chart = chartDefuzzifierContinuous((DefuzzifierContinuous) defuzzifier, title, false);

		if (showIt) DialogGraph.execute(chart);
	}

	protected JFreeChart chartCreate(Variable var, boolean showIt) {
		boolean discrete = true;
		boolean plotDefuzz = false;

		// Sanity check
		var.estimateUniverse();
		int numberOfPoints = PlotWindow.DEFAULT_CHART_NUMBER_OF_POINTS;
		double step = (var.getUniverseMax() - var.getUniverseMin()) / (numberOfPoints);

		// Create a data set
		XYSeriesCollection xyDataset = new XYSeriesCollection();

		//---
		// Current value
		//---
		double value = var.getValue();
		if (!Double.isNaN(value)) {
			XYSeries seriesValue = new XYSeries("Value");
			seriesValue.add(value - 2 * step, 0);
			seriesValue.add(value - step, 1);
			seriesValue.add(value, 1);
			seriesValue.add(value + step, 1);
			seriesValue.add(value + 2 * step, 0);
			xyDataset.addSeries(seriesValue);
		}

		//---
		// Plot deffuzyfier values (if any)
		//---
		Defuzzifier defuzzifier = var.getDefuzzifier();
		if ((defuzzifier != null) && (defuzzifier instanceof DefuzzifierContinuous)) {
			DefuzzifierContinuous def = (DefuzzifierContinuous) defuzzifier;

			// Title
			String title = String.format("%s:%2.2f (%s)", var.getName(), var.getLatestDefuzzifiedValue(), defuzzifier.getName());

			// Data points
			XYSeries series = new XYSeries(title);
			double values[] = def.getValues();
			numberOfPoints = values.length;
			double xx = def.getMin();
			step = (def.getMax() - def.getMin()) / (numberOfPoints);

			// Calculate values
			for (int i = 0; i < numberOfPoints; i++, xx += step)
				series.add(xx, values[i]);

			// Add serie to dataSet
			xyDataset.addSeries(series);
			plotDefuzz = true;
		}

		for (LinguisticTerm lt : var) {
			// Add this linguistic term to dataset
			MembershipFunction membershipFunction = lt.getMembershipFunction();
			discrete &= membershipFunction.isDiscrete();

			// Create a series and add points
			XYSeries series = new XYSeries(lt.getTermName());
			if (membershipFunction.isDiscrete()) {
				// Discrete case: Evaluate membership function and add points to dataset
				MembershipFunctionDiscrete membershipFunctionDiscrete = (MembershipFunctionDiscrete) membershipFunction;
				numberOfPoints = membershipFunctionDiscrete.size();
				for (int i = 0; i < numberOfPoints; i++)
					series.add(membershipFunctionDiscrete.valueX(i), membershipFunctionDiscrete.membership(i));
			} else {
				// Continuous case: Add every membershipfunction's point 
				numberOfPoints = PlotWindow.DEFAULT_CHART_NUMBER_OF_POINTS;
				double xx = var.getUniverseMin();
				for (int i = 0; i < numberOfPoints; i++, xx += step)
					series.add(xx, membershipFunction.membership(xx));
			}

			// Add serie to dataSet
			xyDataset.addSeries(series);
		}

		// Create chart and show it
		JFreeChart chart;
		if (!discrete) chart = ChartFactory.createXYAreaChart(var.getName(), "x", "Membership", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		else chart = ChartFactory.createScatterPlot(var.getName(), "x", "Membership", xyDataset, PlotOrientation.VERTICAL, true, true, false);

		// Set 'Value' color to BLACK 
		XYPlot plot = chart.getXYPlot();
		plot.getRenderer().setSeriesPaint(0, Color.BLACK);
		// Set 'deffuzifier' color to GREY 
		if (plotDefuzz) plot.getRenderer().setSeriesPaint(1, Color.gray);

		// Show chart
		if (showIt) DialogGraph.execute(chart);

		return chart;
	}

	/**
	 * Create a defuzzifier's chart 
	 * @param title : Title to show (if null => show membership function name)
	 * @param showIt : If true, plot is displayed
	 */
	private JFreeChart chartDefuzzifierContinuous(DefuzzifierContinuous def, String title, boolean showIt) {
		// Default title
		if (title == null) title = def.getName();

		// Sanity check
		double min = def.getMin();
		double max = def.getMax();
		if (Double.isNaN(min) || Double.isInfinite(max)) {
			Gpr.debug("Limits not calculated yet: [" + min + ", " + max + "]");
			return null;
		}

		// Create a series and add values[] points
		XYSeries series = new XYSeries(title);
		double values[] = def.getValues();
		int numberOfPoints = values.length;
		double xx = min;
		double step = (max - min) / (numberOfPoints);
		for (int i = 0; i < numberOfPoints; i++, xx += step)
			series.add(xx, values[i]);
		XYDataset xyDataset = new XYSeriesCollection(series);

		// Create plot and show it
		JFreeChart chart = ChartFactory.createXYAreaChart(title, "x", "Membership", xyDataset, PlotOrientation.VERTICAL, false, true, false);

		if (showIt) PlotWindow.showIt(title, chart);

		return chart;
	}

	/**
	 * Create a defuzzifier's chart 
	 * @param title : Title to show (if null => show membership function name)
	 * @param showIt : If true, plot is displayed
	 */
	private JFreeChart chartDefuzzifierDiscrete(DefuzzifierDiscrete def, String title, boolean showIt) {
		if (title == null) title = def.getName();

		// Create a series and add values[] points
		XYSeries series = new XYSeries(title);
		for (Double x : def) {
			double xx = x;
			double yy = def.getDiscreteValue(xx);
			series.add(xx, yy);
		}
		XYDataset xyDataset = new XYSeriesCollection(series);

		// Create plot and show it
		JFreeChart chart = ChartFactory.createScatterPlot(title, "x", "Membership", xyDataset, PlotOrientation.VERTICAL, false, true, false);
		if (showIt) PlotWindow.showIt(title, chart);

		return chart;
	}

	/**
	 * Create a membership function chart 
	 * @param title : Title to show (if null => show membership function name)
	 * @param showIt : If true, plot is displayed
	 */
	private JFreeChart chartMembershipFunctionContinuous(MembershipFunctionContinuous mf, String title, boolean showIt) {
		int numberOfPoints = PlotWindow.DEFAULT_CHART_NUMBER_OF_POINTS;

		if (title == null) title = mf.getName();

		// Sanity check
		double universeMin = mf.getUniverseMin();
		double universeMax = mf.getUniverseMax();
		if (Double.isNaN(universeMin) || Double.isInfinite(universeMax)) {
			mf.estimateUniverse();
			universeMin = mf.getUniverseMin();
			universeMax = mf.getUniverseMax();
		}

		// Evaluate membership function and add points to dataset
		XYSeries series = new XYSeries(title);
		double xx = universeMin;
		double step = (universeMax - universeMin) / (numberOfPoints);
		for (int i = 0; i < numberOfPoints; i++, xx += step) {
			series.add(xx, mf.membership(xx));
		}
		XYDataset xyDataset = new XYSeriesCollection(series);

		// Create plot and show it
		JFreeChart chart = ChartFactory.createXYLineChart(title, "x", "Membership", xyDataset, PlotOrientation.VERTICAL, false, true, false);
		if (showIt) PlotWindow.showIt(title, chart);

		return chart;
	}

	/**
	 * Create a membership function chart 
	 * @param title : Title to show (if null => show membership function name)
	 * @param showIt : If true, plot is displayed
	 */
	private JFreeChart chartMembershipFunctionDiscrete(MembershipFunctionDiscrete mf, String title, boolean showIt) {
		int numberOfPoints = mf.size();
		if (title == null) title = mf.getName();

		// Evaluate membership function and add points to dataset
		XYSeries series = new XYSeries(title);
		for (int i = 0; i < numberOfPoints; i++)
			series.add(mf.valueX(i), mf.membership(i));
		XYDataset xyDataset = new XYSeriesCollection(series);

		// Create plot and show it
		JFreeChart chart = ChartFactory.createScatterPlot(title, "x", "Membership", xyDataset, PlotOrientation.VERTICAL, false, true, false);
		if (showIt) PlotWindow.showIt(title, chart);

		return chart;
	}

	@Override
	public void draw(Graphics2D g, Rectangle2D rect, Variable var) {
		JFreeChart chart = chartCreate(var, false);
		chart.draw(g, rect);
	}

}
