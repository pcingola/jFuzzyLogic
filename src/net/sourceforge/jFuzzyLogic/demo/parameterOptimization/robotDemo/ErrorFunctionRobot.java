package net.sourceforge.jFuzzyLogic.demo.parameterOptimization.robotDemo;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.optimization.ErrorFunction;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Error function for robot.fcl fuzzy rule set
 *
 * @author pcingola@users.sourceforge.net
 */
public class ErrorFunctionRobot extends ErrorFunction {

	// Debug mode?
	public boolean verbose = true;
	double rd[], dq[], o[], v[], av[], la[];

	public ErrorFunctionRobot(String trainingFile) {
		load(trainingFile);
	}

	@Override
	public double evaluate(RuleBlock ruleBlock) {
		double error = 0;

		FunctionBlock fb = ruleBlock.getFunctionBlock();
		Variable varRb = fb.getVariable("rd");
		Variable varDq = fb.getVariable("dq");
		Variable varO = fb.getVariable("o");
		Variable varV = fb.getVariable("v");
		Variable varAv = fb.getVariable("av");
		Variable varLa = fb.getVariable("la");

		if (verbose) System.out.print("Evaluate: ");
		// For all samples
		for (int sample = 0; sample < rd.length; sample++) {
			// Set variables
			varRb.setValue(rd[sample]);
			varDq.setValue(dq[sample]);
			varO.setValue(o[sample]);
			varV.setValue(v[sample]);

			// Evaluate FIS
			fb.evaluate();

			// Get output
			double errAv = av[sample] - varAv.getValue();
			double errLa = la[sample] - varLa.getValue();

			// Accumulate error
			error += (errAv * errAv) + (errLa * errLa);

			if (verbose) Gpr.showMark(sample + 1, 100);
		}

		error = Math.sqrt(error);
		if (verbose) System.out.println("!\tError: " + error);

		return error;
	}

	/**
	 * Load trainig set from a file
	 * @param trainingFile
	 */
	void load(String trainingFile) {
		Gpr.debug("Loading trainig set from file: " + trainingFile);
		String lines[] = Gpr.readFile(trainingFile).split("\n");

		// Count lines (number of examples)
		int lineCount = 0;
		for (String line : lines) {
			if (!line.startsWith("#")) { // Skip comments
				lineCount++;
			}
		}
		Gpr.debug("Lines: " + lineCount);

		// Create samples
		rd = new double[lineCount];
		dq = new double[lineCount];
		o = new double[lineCount];
		v = new double[lineCount];
		av = new double[lineCount];
		la = new double[lineCount];

		// Read examples
		lineCount = 0;
		for (String line : lines) {
			if (!line.startsWith("#")) { // Skip comments
				String recs[] = line.split("\t");

				int recNum = 0;
				rd[lineCount] = Gpr.parseDoubleSafe(recs[recNum++]);
				dq[lineCount] = Gpr.parseDoubleSafe(recs[recNum++]);
				o[lineCount] = Gpr.parseDoubleSafe(recs[recNum++]);
				v[lineCount] = Gpr.parseDoubleSafe(recs[recNum++]);
				av[lineCount] = Gpr.parseDoubleSafe(recs[recNum++]);
				la[lineCount] = Gpr.parseDoubleSafe(recs[recNum++]);

				lineCount++;
			}
		}
	}
}
