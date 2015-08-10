package net.sourceforge.jFuzzyLogic.demo.parameterOptimization.robotDemo;

import java.util.ArrayList;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.optimization.OptimizationDeltaJump;
import net.sourceforge.jFuzzyLogic.optimization.Parameter;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;

/**
 * Fuzzy rule set parameter optimization for robot.fcl
 * 
 * @author pcingola@users.sourceforge.net
 */
public class ParameterOptimizationRobot {

	public static final String trainingFile = "paper/caseStudy/trainigSet.txt";
	public static final String fclFile = "fcl/robot.fcl";

	public static int NUM_ITERATIONS = 20;

	public static void main(String[] args) throws Exception {
		System.out.println("ParameterOptimizationDemo: Begin");

		//---
		// Load FIS (Fuzzy Inference System)
		//---
		FIS fis = FIS.load(fclFile);
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
		JFuzzyChart.get().chart(functionBlock);
		RuleBlock ruleBlock = functionBlock.getFuzzyRuleBlock(null);

		//---
		// Create a list of parameter to optimize
		//---
		ArrayList<Parameter> parameterList = new ArrayList<Parameter>();

		// Add variables to be optimized
		parameterList.addAll(Parameter.parametersMembershipFunction(ruleBlock.getVariable("dq")));
		parameterList.addAll(Parameter.parametersMembershipFunction(ruleBlock.getVariable("v")));
		// parameterList.addAll(Parameter.parametersMembershipFunction(ruleBlock.getVariable("o")));
		// parameterList.addAll(Parameter.parametersMembershipFunction(ruleBlock.getVariable("rd")));

		//		// Add every rule's weight
		//		for (Rule rule : ruleBlock.getRules())
		//			parameterList.addAll(Parameter.parametersRuleWeight(rule));

		//---
		// Create an error function to be optimized (i.e. minimized)
		//---
		ErrorFunctionRobot errorFunction = new ErrorFunctionRobot(trainingFile);

		//---
		// Optimize (using 'Delta jump optimization')
		//---
		OptimizationDeltaJump optimizationDeltaJump = new OptimizationDeltaJump(ruleBlock, errorFunction, parameterList);
		optimizationDeltaJump.setMaxIterations(NUM_ITERATIONS); // Number optimization of iterations
		optimizationDeltaJump.setVerbose(true);
		optimizationDeltaJump.optimize();

		//---
		// Save optimized fuzzyRuleSet to file
		//---
		System.out.println(functionBlock);
		Gpr.toFile("fcl/robot_optimized.fcl", functionBlock.toString());

		// Show 
		// functionBlock.reset(false);
		functionBlock.reset();
		JFuzzyChart.get().chart(functionBlock);

		System.out.println("ParameterOptimizationDemo: End");
	}
}
