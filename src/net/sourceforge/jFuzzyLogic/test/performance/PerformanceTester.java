package net.sourceforge.jFuzzyLogic.test.performance;

public class PerformanceTester {

	public static String path = "fcl/";

	public static void main(String[] args) throws Exception {
		PerformanceTester test = new PerformanceTester();
		System.out.println("Begin Performance tester execution");

		if( false ) test.executeOoS();
		else test.executeTrust();

		System.out.println("End: Performance tester execution");
	}

	public PerformanceTester() {}

	private void executeOoS() {
		// Load from 'FCL' file
		String tsMany = path + "/QoS/TSQoSManyRules.fcl";
		String tsFew = path + "/QoS/TSQoSFewRules.fcl";
		String mamMany = path + "/QoS/MamdaniQoSManyRules.fcl";
		String mamFew = path + "/QoS/MamdaniQoSFewRules.fcl";
		String larsenMany = path + "/QoS/LarsenQoSManyRules.fcl";
		String larsenFew = path + "/QoS/LarsenQoSFewRules.fcl";
		String singletonMany = path + "/QoS/SingletonQoSManyRules.fcl";
		String singletonFew = path + "/QoS/SingletonQoSFewRules.fcl";

		String[] inputVariables = { "commitment", "clarity", "influence" };

		int stepSize = 1;
		int steps = 1;

		TestExecutioner executioner = new TestExecutioner();
		pause(1000);

		PerformanceChart chart = new PerformanceChart(stepSize, "Performance Comparison (3 rules)");
		chart.addData(executioner.execute(tsFew, inputVariables, steps, stepSize), "Takagi-Sugeno");
		chart.addData(executioner.execute(mamFew, inputVariables, steps, stepSize), "Mamdani");
		chart.addData(executioner.execute(larsenFew, inputVariables, steps, stepSize), "Larsen");
		chart.addData(executioner.execute(singletonFew, inputVariables, steps, stepSize), "Singleton");

		pause(1000);
		chart.display("QoS Performance Comparison (3 rules)");
		pause(1000);
		PerformanceChart chart2 = new PerformanceChart(stepSize, "Performance Comparison (30 rules)");
		chart2.addData(executioner.execute(tsMany, inputVariables, steps, stepSize), "Takagi-Sugeno");
		chart2.addData(executioner.execute(mamMany, inputVariables, steps, stepSize), "Mamdani");
		chart2.addData(executioner.execute(larsenMany, inputVariables, steps, stepSize), "Larsen");
		chart2.addData(executioner.execute(singletonMany, inputVariables, steps, stepSize), "Singleton");
		pause(1000);

		chart2.display("QoS Performance Comparison (30 rules)");

	}

	private void executeTrust() {
		// Load from 'FCL' file
		String tsMany = path + "/trust/TSManyRules.fcl";
		String tsFew = path + "/trust/TSFewRules.fcl";
		String mamMany = path + "/trust/MamdaniManyRules.fcl";
		String mamFew = path + "/trust/MamdaniFewRules.fcl";
		String larsenMany = path + "/trust/LarsenManyRules.fcl";
		String larsenFew = path + "/trust/LarsenFewRules.fcl";
		String singletonMany = path + "/trust/SingletonManyRules.fcl";
		String singletonFew = path + "/trust/SingletonFewRules.fcl";

		String[] inputVariables = { "WTV", "OW", "AC" };

		int stepSize = 15;
		int steps = 30;

		TestExecutioner executioner = new TestExecutioner();
		pause(1000);

		PerformanceChart chart = new PerformanceChart(stepSize, "Performance Comparison (3 rules)");
		chart.addData(executioner.execute(tsFew, inputVariables, steps, stepSize), "Takagi-Sugeno");
		chart.addData(executioner.execute(mamFew, inputVariables, steps, stepSize), "Mamdani");
		chart.addData(executioner.execute(larsenFew, inputVariables, steps, stepSize), "Larsen");
		chart.addData(executioner.execute(singletonFew, inputVariables, steps, stepSize), "Singleton");

		pause(1000);
		chart.display("Trust Performance Comparison (3 rules)");
		pause(1000);

		PerformanceChart chart2 = new PerformanceChart(stepSize, "Performance Comparison (30 rules)");
		chart2.addData(executioner.execute(tsMany, inputVariables, steps, stepSize), "Takagi-Sugeno");
		chart2.addData(executioner.execute(mamMany, inputVariables, steps, stepSize), "Mamdani");
		chart2.addData(executioner.execute(larsenMany, inputVariables, steps, stepSize), "Larsen");
		chart2.addData(executioner.execute(singletonMany, inputVariables, steps, stepSize), "Singleton");

		chart2.display("Trust Performance Comparison (30 rules)");
	}

	private void pause(long pause) {
		try {
			Thread.sleep(pause);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
