package net.sourceforge.jFuzzyLogic.optimization;

import java.util.ArrayList;

import net.sourceforge.jFuzzyLogic.rule.RuleBlock;

/**
 * Optimization for fuzzy rule sets
 * 
 * Tries to optimize parameters (fuzzy sets parameters and rule's weights) using an algorithm.
 *
 * @author pcingola@users.sourceforge.net
 */
public abstract class OptimizationMethod {

	private static int DEFAULT_MAX_ITERATIONS = 100; // Max number of iterations 

	protected boolean verbose = false; // Debug mode?
	protected int showEvery = 1;
	protected ErrorFunction errorFunction; // Error function to minimize 
	protected RuleBlock fuzzyRuleSet; // Fuzzy rule set's whose parameters we are optimizing 
	protected int maxIterations; // Max number of iterations 
	protected int maxLineSearchIterations; // Maximum 'line search' number of iterations 
	protected ArrayList<Parameter> parameterList; // Parameters to optimize 

	public OptimizationMethod(RuleBlock fuzzyRuleSet, ErrorFunction errorFunction, ArrayList<Parameter> parameterList) {
		this.fuzzyRuleSet = fuzzyRuleSet;
		this.errorFunction = errorFunction;
		this.parameterList = parameterList;
		maxIterations = DEFAULT_MAX_ITERATIONS;
	}

	/**
	 * Return 'true' when the algorithm made enough progress to finish the optimization
	 * @param iterationNum
	 * @return
	 */
	public boolean finishCondition(int iterationNum) {
		return false;
	}

	public ErrorFunction getErrorFunction() {
		return errorFunction;
	}

	public RuleBlock getFuzzyRuleSet() {
		return fuzzyRuleSet;
	}

	public int getMaxIterations() {
		return maxIterations;
	}

	public int getMaxLineSearchIterations() {
		return maxLineSearchIterations;
	}

	public ArrayList<Parameter> getParameterList() {
		return parameterList;
	}

	public int getShowEvery() {
		return showEvery;
	}

	public boolean isVerbose() {
		return verbose;
	}

	/**
	 * Perform optimization
	 */
	public void optimize() {
		optimizeInit();

		int iterNum = 1;
		for( ; !finishCondition(iterNum) && (iterNum <= maxIterations); iterNum++ ) {
			optimizeIteration(iterNum);

			// Show something every now and then
			if( verbose && (iterNum % showEvery == 0) ) System.out.println(stats(iterNum));
		}

		if( verbose && (iterNum > maxIterations) ) System.out.println("Max number of iterations reached");
		optimizeEnd();
	}

	public void optimizeEnd() {
		;
	}

	public void optimizeInit() {
		;
	}

	public abstract void optimizeIteration(int iterationNum);

	public void setErrorFunction(ErrorFunction errorFunction) {
		this.errorFunction = errorFunction;
	}

	public void setFuzzyRuleSet(RuleBlock fuzzyRuleSet) {
		this.fuzzyRuleSet = fuzzyRuleSet;
	}

	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	public void setMaxLineSearchIterations(int maxLineSearchIterations) {
		this.maxLineSearchIterations = maxLineSearchIterations;
	}

	public void setParameterList(ArrayList<Parameter> parameterList) {
		this.parameterList = parameterList;
	}

	public void setShowEvery(int showEvery) {
		this.showEvery = showEvery;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	/**
	 * Show some statistics
	 */
	public String stats(int iterationNumber) {
		return "Iterations:\t" + iterationNumber + " / " + maxIterations;
	}

}
