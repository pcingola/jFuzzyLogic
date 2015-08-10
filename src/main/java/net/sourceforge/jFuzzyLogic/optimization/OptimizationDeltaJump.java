package net.sourceforge.jFuzzyLogic.optimization;

import java.util.ArrayList;

import net.sourceforge.jFuzzyLogic.rule.RuleBlock;

/**
 * Paramtric optimization using 'jump' criteria for fuzzy rule sets
 *
 * Tries to optimize parameters (fuzzy sets parameters and rule's weights) using a 'jump' algorithm.
 * Jump optimization: Simply tries different parameters 'jumping' (changing the parameter a specified amount). 
 * 
 * Note: This is NOT a very sophisticated algorithm (actually looks a lot like 'random search'), but if 
 * you are not in a hurry, most of the time works better than Gradient descent.
 * 
 * @author pcingola@users.sourceforge.net
 */
public class OptimizationDeltaJump extends OptimizationMethod {

	/** Default Max 'line search' number of iterations */
	private static int DEFAULT_MAX_LINE_SEARCH_ITERATIONS = 20;

	/** Maximum 'line search' number of iterations */
	protected int maxLineSearchIterations;

	public OptimizationDeltaJump(RuleBlock fuzzyRuleSet, ErrorFunction errorFunction, ArrayList<Parameter> parameterList) {
		super(fuzzyRuleSet, errorFunction, parameterList);
		maxLineSearchIterations = DEFAULT_MAX_LINE_SEARCH_ITERATIONS;
	}

	/**
	 * Estimate jump 
	 * @param parameterNumber : Parameter number to estimate
	 * @param errro0 : Function value at X_0
	 * @return
	 */
	private double jump(int parameterNumber, double error0) {
		Parameter param = parameterList.get(parameterNumber);
		double epsilon = param.getEpsilon();
		double paramValue = param.get();
		double error1;

		// Increase parameter (in this dimension)
		if (param.set(paramValue + epsilon)) {
			// Parameter changed? => re evaluate
			error1 = errorFunction.evaluate(fuzzyRuleSet);
			// Restore old parameter's value
			param.set(paramValue);
			// Good jump? (error decresed?) => ok
			if (error1 < error0) return epsilon;
		} else if (verbose) System.out.println("Cannot set parameter [" + parameterNumber + "] to " + (paramValue + epsilon));

		// Decrease parameter (in this dimension)
		if (param.set(paramValue - epsilon)) {
			// Parameter changed? => re evaluate
			error1 = errorFunction.evaluate(fuzzyRuleSet);
			// Restore old parameter's value
			param.set(paramValue);
			// Good jump? (error decresed?) => ok
			if (error1 < error0) return -epsilon;
		} else if (verbose) System.out.println("Cannot set parameter [" + parameterNumber + "] to " + (paramValue - epsilon));

		return 0;
	}

	/**
	 * Gradient optimization for error functions
	 * Gradient descent algorithm
	 * It also does a line search to get a good 'next point' on each iteration
	 * @param verbose : Be verbose (recomended, because it takes some time to converge)
	 */
	@Override
	public void optimizeIteration(int iterationNum) {
		int paramNum, lineIterNum, len = parameterList.size();
		double alpha, error, error0 = 0, errorItStart = 0, paramValue, jump, deltaErrorIt, bestAlpha, bestAlphaError;
		boolean changed = true;

		// For each parameter (dimension)
		for (paramNum = 0; paramNum < len; paramNum++) {
			// Get parameter to be optimized
			Parameter parameter = parameterList.get(paramNum);
			paramValue = parameter.get();
			if (verbose) System.out.println("Parameter [" + paramNum + "]: " + parameter.getName() + "\tvalue: " + paramValue);

			// Estimate universe (if not already done)
			if (parameter instanceof ParameterMembershipFunction) ((ParameterMembershipFunction) parameter).getVariable().estimateUniverse();

			// Calculate error function at 'X_0' (starting point)
			if (changed) error0 = errorFunction.evaluate(fuzzyRuleSet);
			if (paramNum == 0) errorItStart = error0;

			// Calculate 'jump' size / direction
			jump = jump(paramNum, error0);

			changed = false;
			if (jump != 0) { // Can jump?
				//---
				// Line search: Iterate until we get a suitable alpha (jump step size)
				//---
				alpha = 1; // We set initial alpha value to 1.0
				bestAlpha = 0; // Best alpha
				bestAlphaError = error0; // Error using 'bestAlpha'
				for (lineIterNum = 0; lineIterNum < maxLineSearchIterations; lineIterNum++)
					// Advance towards 'jump' direction (step = alpha * jump)
					if (parameter.set(paramValue + alpha * jump)) { // Can set parameter?

						// Evaluate new point (is it better than before?)
						error = errorFunction.evaluate(fuzzyRuleSet);
						double deltaErr = error - error0;
						if (verbose) System.out.println("\t\tLine iteration:" + lineIterNum + ", alpha:" + alpha + ", Delta_Error:" + deltaErr);

						// Better error (smaller)? => Ok, try using a bigger alpha
						if (deltaErr < 0) {
							if (error < bestAlphaError) { // Store 'best' alpha so far
								bestAlphaError = error;
								bestAlpha = alpha;
							}
							alpha *= 2; // Increase alpha's size
						} else {
							// Error is bigger? => break loop 
							if (verbose) System.out.println("\t\tLine iteration: Error increases, stop.");
							break;
						}
					} else break; // Cannot set parameter? => break loop

				// Set parameter to 'best' value found in "line search"
				parameter.set(paramValue + bestAlpha * jump);
				changed = (bestAlpha != 0);

				if (verbose) {
					if (lineIterNum >= maxLineSearchIterations) System.out.println("\t\tWARNING: Too many line iterations! This may point a desing error in your fuzzy system.");
					if (paramValue != parameter.get()) System.out.println("\tIteration: " + iterationNum + "\tParameter: " + paramNum + " (" + parameter.getName() + ")\tError before: " + error0 + "\tError after: " + bestAlphaError + "\tParameter before: " + paramValue + "\t after: " + parameter.get() + "\tbest alpha: " + bestAlpha);
				}
			}
		}

		// Calculate full itearation's delta error
		deltaErrorIt = error0 - errorItStart;
		if (verbose) System.out.println("Delta error (full iteration): " + deltaErrorIt);
		if (deltaErrorIt >= 0) {
			if (verbose) System.out.println("Can't get any better! Giving up");
			return;
		}
	}

}
