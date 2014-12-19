package net.sourceforge.jFuzzyLogic.plot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * A panel that is used to plot all variable in a Fuzzy inference system (FIS)
 */
public class JPanelFis extends JPanel {

	private static final long serialVersionUID = 1L;

	FIS fis;
	int plotHeight, plotWidth; // Each plot's size 
	int posx = 0, posy = 0; // Position each plot within the panel	

	public JPanelFis(FIS fis) {
		this.fis = fis;
	}

	/**
	 * Prepare coordinates for next plot
	 * @param plotSizex
	 * @param plotSizey
	 */
	public void nextPosition(int plotSizex, int plotSizey, int panelWidth, int panelHeight) {
		// Positions for next plot
		posx += plotSizex;
		if ((posx + plotSizex) > panelWidth) { // Out of screen?
			posx = 0;
			posy += plotSizey;
		}

		if ((posy + plotSizey) > panelHeight) { // Out of screen?
			posx = 0;
			posy = 0;
		}

	}

	@Override
	public void paintComponent(Graphics g) {

		if (fis != null) {
			// How many variables do we need to plot?
			FunctionBlock fb = fis.getFunctionBlock(null);
			if (fb != null) {
				// Initialize plot sizes and positions
				posx = posy = 0;
				int w = getWidth(), h = getHeight();
				int vars = fb.getVariables().size();
				int nx = (int) Math.sqrt(vars);
				int ny = vars / nx;
				if ((nx * ny - vars) < 0) ny++;
				int plotSizex = w / nx;
				int plotSizey = h / ny;
				Rectangle2D rect = new Rectangle2D.Double();

				// Plot each variable
				for (Variable var : fb.variablesSorted()) {
					// Rectangle2D rect = new Rectangle2D.Double(posx, posy, plotSizex, plotSizey); // Define where this variable should be plotted
					rect.setFrame(posx, posy, plotSizex, plotSizey);

					JFuzzyChart.get().draw((Graphics2D) g, rect, var);

					nextPosition(plotSizex, plotSizey, w, h); // Calculate where next plot should be
				}
			}
		}
	}
}
