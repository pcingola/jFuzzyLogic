package net.sourceforge.jFuzzyLogic.plot;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.defuzzifier.Defuzzifier;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * 
 * Charts variables, membership functions, function blocks, etc.
 * 
 * Code provided by: Carmelo (cswi)
 *
 */
public abstract class JFuzzyChart {

	public static boolean UseMockClass = false;

	private static JFuzzyChart jFuzzyChart = null;

	public static JFuzzyChart get() {
		if (jFuzzyChart != null) return jFuzzyChart;

		try {

			if (UseMockClass) jFuzzyChart = (JFuzzyChart) Class.forName("net.sourceforge.jFuzzyLogic.plot.JFuzzyChartMock").newInstance();
			else jFuzzyChart = (JFuzzyChart) Class.forName("net.sourceforge.jFuzzyLogic.plot.JFuzzyChartImpl").newInstance();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return jFuzzyChart;
	}

	protected JFuzzyChart() {
	}

	/**
	 * Create a defuzzifier's chart 
	 * @param title : Title to show (if null => show membership function name)
	 * @param showIt : If true, plot is displayed
	 */
	// public abstract JFreeChart chart(Defuzzifier def, String title, boolean showIt);
	public abstract void chart(Defuzzifier def, String title, boolean showIt);

	/** 
	 * Show a chart for each function block 
	 */
	public abstract void chart(FIS fis);

	/** 
	 * Show a chart for each variable in a function block 
	 */
	public abstract void chart(FunctionBlock fb);

	/**
	 * Create a membership function chart 
	 * @param showIt : If true, plot is displayed
	 */
	public abstract void chart(LinguisticTerm lt, boolean showIt);

	/**
	 * Create a membership function chart 
	 * @param title : Title to show (if null => show membership function name)
	 * @param showIt : If true, plot is displayed
	 */
	public abstract void chart(MembershipFunction mf, String title, boolean showIt);

	/**
	 * Create a chart showing each linguistic term
	 * @param showIt : If true, plot is displayed
	 */
	public abstract void chart(Variable var, boolean showIt);

	/**
	 * Create a chart showing defuzzifier 
	 * @param showIt : If true, plot is displayed
	 */
	public abstract void chart(Variable var, Defuzzifier defuzzifier, boolean showIt);

	/**
	 * Draw a chart in a Graphics object
	 * @param g
	 * @param rect
	 * @param var
	 */
	public abstract void draw(Graphics2D g, Rectangle2D rect, Variable var);

}
