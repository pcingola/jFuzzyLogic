package net.sourceforge.jFuzzyLogic.demo.parameterOptimization.qualifyDemo;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.optimization.ErrorFunction;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Error function for qualify.fcl fuzzy rule set
 *
 * @author pcingola@users.sourceforge.net
 */
public class ErrorFunctionQualifyDemo extends ErrorFunction {

	JDialogFis jdf = null;

	// Desired output for credit limit (see Qualify_demo.xls spreadsheet)
	private static double credLimXL[][] = { //
	{ 0, 100, 100, 100, 75, 60 } //
			, { 73, 119, 150, 150, 138, 110 } //
			, { 80, 130, 190, 200, 200, 160 } //
			, { 86, 141, 206, 245, 250, 210 } //
			, { 93, 152, 221, 264, 286, 300 } //
			, { 99, 163, 237, 283, 300, 300 } // 
	};
	// Debug mode?
	public static boolean debug = false;
	private static double incomeXL[] = { 1000, 1300, 2000, 3000, 4000, 5000 }; // net income column (see Qualify_demo.xls spreadsheet)
	private static double scoreXL[] = { 400, 500, 600, 700, 800, 900 }; // score row (see Qualify_demo.xls spreadsheet)

	@Override
	public double evaluate(RuleBlock ruleBlock) {
		double error = 0;

		FunctionBlock functionBlock = ruleBlock.getFunctionBlock();

		// Good parameters combination
		ruleBlock.setVariable("city", 1); // Pick one city
		ruleBlock.setVariable("occupation_type", 10); // Good occupation type
		ruleBlock.setVariable("scoring_partner", -10); // No partner

		// Caculate for each table's element (score and income)
		for (int scoreInd = 0; scoreInd < scoreXL.length; scoreInd++) {
			double score = scoreXL[scoreInd];
			ruleBlock.setVariable("scoring", score);
			for (int incomeInd = 0; incomeInd < incomeXL.length; incomeInd++) {
				double income = incomeXL[incomeInd];
				ruleBlock.setVariable("sel", income);

				// Evaluate fuzzy system
				functionBlock.evaluate();

				// get output
				double credLimMul = ruleBlock.getVariable("credLimMul").getLatestDefuzzifiedValue();
				if (debug) {
					for (Variable var : ruleBlock.getFunctionBlock().variables())
						System.out.println(var.getName() + " : " + var.getValue());

					for (Rule r : ruleBlock.getRules())
						System.out.println(r);

					// Show variable
					Variable var = ruleBlock.getVariable("credLimMul");
					JFuzzyChart.get().chart(var, true);
				}

				// Calculate error (mean square)
				double desiredCredLim = credLimXL[scoreInd][incomeInd] / 100;
				error += (credLimMul - desiredCredLim) * (credLimMul - desiredCredLim);
				if (debug) Gpr.debug(score + ", " + income + "\t" + credLimMul + "\t" + desiredCredLim + "\t" + Math.sqrt(error));
			}
		}

		return Math.sqrt(error);
	}

}
