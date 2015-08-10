package net.sourceforge.jFuzzyLogic.optimization;

import java.util.ArrayList;

import net.sourceforge.jFuzzyLogic.rule.RuleBlock;

/**
 * Paramtric Gradient optimization for fuzzy rule sets
 * 
 * Tries to optimize parameters (fuzzy sets parameters and rule's weights) using a 'gradient' algorithm.
 * Gradient optimization: Simply calculates gradient and tries to optimize in that direction using a 'line search' algorithm.
 * 
 * @author pcingola@users.sourceforge.net
 */
public class OptimizationGradient extends OptimizationPartialDerivate {

	public static int countGradientNormTooSmall;

	public OptimizationGradient(RuleBlock fuzzyRuleSet, ErrorFunction errorFunction, ArrayList<Parameter> parameterList) {
		super(fuzzyRuleSet, errorFunction, parameterList);
	}

	/**
	 * parameterList ===> parameterValues
	 * @param parameterValues
	 */
	private void copyFromParameterList(double parameterValues[]) {
		for( int j = 0; j < parameterValues.length; j++ )
			parameterValues[j] = parameterList.get(j).get();
	}

	/**
	 * parameterList <=== parameterValues
	 * @param parameterValues
	 */
	private void copyToParameterList(double parameterValues[]) {
		for( int j = 0; j < parameterValues.length; j++ )
			parameterList.get(j).set(parameterValues[j]);
	}

	/**
	 * Estimate gradient
	 * @param portfolioOriginal Portfolio (estimate portfolioOriginal's gradient to weigths)
	 * @param gradient An array where results are stored
	 * @param ev0 funtion evaluated at W0 (starting point to calculate gradient)
	 * @return Gradient's norm (and sets gradient[])
	 */
	private double gradient(double gradient[], double ev0) {
		double norm = 0;
		double e0 = errorFunction.evaluate(fuzzyRuleSet); // Calculate error funtion's "gradient"

		//---
		// For each dimention, estimate partial derivate
		//---
		for( int i = 0; i < parameterList.size(); i++ ) {
			Parameter param = parameterList.get(i);
			double epsilon = param.getEpsilon();
			double paramValue = param.get();

			if( param.set(paramValue + epsilon) ) ; // Increase parameter (in this dimention) to estimate derivate 
			else if( param.set(paramValue - epsilon) ) epsilon *= -1; // Cant' increase? => Decrease parameter (in this dimention) to estimate derivate 
			else epsilon = 0; // Cant' increase / decrease => no change

			double e1;
			if( epsilon != 0 ) {
				// Parameter changed? => re evaluate
				e1 = errorFunction.evaluate(fuzzyRuleSet);
				// Restore old parameter's value
				param.set(paramValue);
			} else e1 = e0; // No change

			// Partial derivative
			gradient[i] = (e0 - e1) / epsilon;
			if( verbose ) System.out.println("Parameter:" + param.getName() + "\tDerivate: " + gradient[i] + "\tepsilon: " + epsilon);

			norm += gradient[i] * gradient[i]; // Calculate gradient's norm
		}

		// Return gradient's norm
		return norm;
	}

	/**
	 * Gradient optimization for error functions
	 * Gradient descent algorithm
	 * It also does a line search to get a good 'next point' on each iteration
	 */
	@Override
	public void optimize() {
		int i, j, k, len;
		len = parameterList.size();
		double gradient[] = new double[len]; // Gradient
		double alpha, norm = 0, error, error0;
		double parameterValues0[] = new double[len];

		countOptimizations++;

		//---
		// Iterate gradient descent
		//---
		for( i = 0; i < maxIterations; i++ ) {
			countIterations++;
			// Calculate error funtion at 'X_0' (starting point)
			error0 = errorFunction.evaluate(fuzzyRuleSet);
			if( verbose ) System.out.println("Iteration: " + i + "\tError: " + error0);

			// Save initial parameter values
			copyFromParameterList(parameterValues0);

			// Estimate gradient
			norm = gradient(gradient, error0);

			// Norm too small? => Abort
			if( norm <= EPSILON ) {
				// Restore initial values and quit
				copyToParameterList(parameterValues0);
				countGradientNormTooSmall++;
				if( verbose ) System.out.println("Gradient's norm too small => finished (norm: " + norm + ")");
				return;
			}

			//---
			// Line search: Iterate until we get a suitable alpha (gradient's step size)
			//---
			alpha = 1; // We set initial alpha value to 1.0 and 
			for( k = 0; k < maxLineSearchIterations; k++ ) {
				countLineIterations++;

				// Advance against gradient's direction (step = -alpha)
				for( j = 0; j < len; j++ )
					parameterList.get(j).set(parameterValues0[j] - alpha * gradient[j]);

				// Evaluate new point (is it better than before?)
				error = errorFunction.evaluate(fuzzyRuleSet);
				if( verbose ) System.out.println("\tLine tteration: " + k + "\talpha: " + alpha + "\tDelta_Error: " + (error - error0));
				if( error < error0 ) {
					alphaLineIterations += alpha;
					countGoodLineIterations++;
					break; // Better? => Continue using this point 
				}
				alpha /= 2; // Worst? => Use a smaller alpha 
				countBadLineIterations++;
			}

			// Can't get a better error function on this line? => Restore old parameters and return
			// (we couldn't improbe, so we are still at W0, next iteration it's going to be the same as this one)
			if( k >= maxLineSearchIterations ) {
				copyToParameterList(parameterValues0);
				countNoImpovement++;
				if( verbose ) System.out.println("Couldn't get any improvement => finished");
				return;
			}

			countImpovement++;
		}

		countMaxIterations++; // Number of time 'max iterations was reached
	}

	@Override
	public String stats(int iterationNumber) {
		String stats = super.stats(iterationNumber) + "\n\tGradient Norm Too Small (return cause): " + countGradientNormTooSmall;
		return stats;
	}
}
