package net.sourceforge.jFuzzyLogic.optimization;

import java.util.ArrayList;

import net.sourceforge.jFuzzyLogic.rule.RuleBlock;

/**
 * Paramtric partial derivate optimization for fuzzy rule sets
 * 
 * Tries to optimize parameters (fuzzy sets parameters and rule's weights) using a 'derivate' algorithm.
 * Derivate optimization: Simply calculates derivate and tries to optimize in that direction using a 'line search' algorithm.
 *
 * @author pcingola@users.sourceforge.net
 */
public class OptimizationPartialDerivate extends OptimizationMethod {

	public double EPSILON = 0.0000001; // A small number to compare doubles
	public double alphaLineIterations; // Alpha for line iterations

	/** Some counters for statistics */
	protected int countDerivatemTooSmall, countImpovement, countNoImpovement, countMaxIterations, countOptimizations, countIterations, countLineIterations,
			countGoodLineIterations, countBadLineIterations;

	public static int DEFAULT_MAX_LINE_SEARCH_ITERATIONS = 20; // Maximum 'line search' number of iterations 

	protected int maxLineSearchIterations; // Maximum 'line search' number of iterations 

	public OptimizationPartialDerivate(RuleBlock fuzzyRuleSet, ErrorFunction errorFunction, ArrayList<Parameter> parameterList) {
		super(fuzzyRuleSet, errorFunction, parameterList);
		maxLineSearchIterations = DEFAULT_MAX_LINE_SEARCH_ITERATIONS;
	}

	/**
	 * Estimate partial derivate 
	 * @param parameterNumber : Parameter number to estimate
	 * @param errro0 : Function value at X_0
	 * @return
	 */
	private double derivate(int parameterNumber, double error0) {
		Parameter param = parameterList.get(parameterNumber);
		double epsilon = param.getEpsilon();
		double paramValue = param.get();

		if( param.set(paramValue + epsilon) ) ; // Increase parameter (in this dimention) to estimate derivate 
		else if( param.set(paramValue - epsilon) ) epsilon *= -1; // Cant' increase? => Decrease parameter (in this dimention) to estimate derivate 
		else epsilon = 0; // Can't increase / decrease => no change

		double error1;
		if( epsilon != 0 ) {
			// Parameter changed? => re evaluate
			error1 = errorFunction.evaluate(fuzzyRuleSet);
			// Restore old parameter's value
			param.set(paramValue);
		} else error1 = error0; // No change

		// Partial derivate
		double derivate = (error0 - error1) / epsilon;
		if( error1 < error0 ) System.out.println("Can descent!   error1: " + error1 + "\terror0: " + error0);
		if( verbose ) System.out.println("Parameter:" + param.getName() + "\tDerivate: " + derivate + "\tepsilon: " + epsilon);

		// Return derivate
		return derivate;
	}

	@Override
	public void optimizeIteration(int iterationNum) {
		int len = parameterList.size();
		double alpha, error, error0;

		countIterations++;

		// For each parameter...
		for( int paramNum = 0; paramNum < len; paramNum++ ) {
			// Calculate error funtion at 'X_0' (starting point)
			error0 = errorFunction.evaluate(fuzzyRuleSet);
			if( verbose ) System.out.println("Iteration: " + iterationNum + "\tParameter: " + paramNum + "\tError: " + error0);
			double paramValue = parameterList.get(paramNum).get();

			// Estimate partial derivate
			double derivate = derivate(paramNum, error0);

			// derivate too small? => Abort
			if( Math.abs(derivate) <= EPSILON ) {
				countDerivatemTooSmall++;
				if( verbose ) System.out.println("Derivate's abs too small (derivate: " + derivate + " < " + parameterList.get(paramNum).getEpsilon() + ")");
			} else {
				//---
				// Line search: Iterate until we get a suitable alpha (derivate's step size)
				//---
				alpha = 1; // We set initial alpha value to 1.0 and 
				for( int lineIterNum = 0; lineIterNum < maxLineSearchIterations; lineIterNum++ ) {
					countLineIterations++;

					// Advance against derivate's direction (step = -alpha)
					parameterList.get(paramNum).set(paramValue - alpha * derivate);

					// Evaluate new point (is it better than before?)
					error = errorFunction.evaluate(fuzzyRuleSet);
					if( verbose ) System.out.println("\tLine iteration: " + lineIterNum + "\talpha: " + alpha + "\tDelta_Error: " + (error - error0));
					if( error < error0 ) {
						countGoodLineIterations++;
						break; // Better? => Continue using this point 
					}
					alpha /= 2; // Worst? => Use a smaller alpha 
					countBadLineIterations++;
				}
			}
		}

		countImpovement++;
	}

	/**
	 * Some statistics
	 * @return
	 */
	@Override
	public String stats(int iterationNumber) {
		String stats = "\tTotal Optimizations: " + countOptimizations//
				+ "\n\tNorm Too Small (return cause): " + countDerivatemTooSmall//
				+ "\n\tNo Impovement  (return cause): " + countNoImpovement //
				+ "\n\tMax iterations (return cause): " + countMaxIterations //
				+ "\n\tImpovement (iteration): " + countImpovement //
				+ "\n\tcountIterations: " + countIterations + "\tgood: " + countGoodLineIterations + " / bad: " + countBadLineIterations //
				+ "\n\tAverage good alpha: " + (alphaLineIterations / countGoodLineIterations) //
				+ "\n\tcountLineIterations: " + countLineIterations;
		return stats;
	}
}
