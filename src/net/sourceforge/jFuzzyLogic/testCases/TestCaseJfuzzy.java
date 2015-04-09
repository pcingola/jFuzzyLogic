/**
 *
 * JUnit test for jFuzzyLogic
 *
 *
 * @author pcingola@users.sourceforge.net
 */
package net.sourceforge.jFuzzyLogic.testCases;

import java.util.List;

import junit.framework.TestCase;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import org.junit.Assert;
import org.junit.Test;

/**
 * Main testing class
 *
 * @author pcingola@users.sourceforge.net
 *
 */
public class TestCaseJfuzzy extends TestCase {

	static double EPSILON = 0.000001; // A small number
	static boolean verbose = false; // Verbose?

	/**
	 * Verify that De Morgan's laws are OK
	 */
	void checkDeMorgan(FIS fis) {
		// De Morgan's laws test
		FunctionBlock fb = fis.getFunctionBlock(null);
		RuleBlock rb = fb.getRuleBlocks().values().iterator().next();
		List<Rule> rules = rb.getRules();
		Rule r1 = rules.get(0);
		Rule r2 = rules.get(1);
		Rule r3 = rules.get(2);
		Rule r4 = rules.get(3);

		r1.getDegreeOfSupport();

		// Set different values for 'food' and 'service'. Evaluate the system and show variables
		//		for( double service = 0.0, food = 1; service <= 10; service += 0.1 ) {
		for (double x1 = 0; x1 <= 1.0; x1 += 0.01) {
			for (double x2 = 0; x2 <= 1.0; x2 += 0.01) {
				// Evaluate system using these parameters
				fis.getVariable("x1").setValue(x1);
				fis.getVariable("x2").setValue(x2);
				fis.evaluate();

				// DeMorgan law: NOT(x1 IS small OR x2 IS small) == NOT(x1 IS small) AND NOT(x2 IS small)
				double diff = Math.abs(r1.getDegreeOfSupport() - r2.getDegreeOfSupport());
				if (diff > EPSILON) throw new RuntimeException(String.format("x1: %2.2f\tx2:%2.2f\t=> r1: %2.2f\tr2: %2.2f", x1, x2, r1.getDegreeOfSupport(), r2.getDegreeOfSupport()));

				// DeMorgan law: NOT(x1 IS small OR x2 IS small) == NOT(x1 IS small) AND NOT(x2 IS small)
				diff = Math.abs(r3.getDegreeOfSupport() - r4.getDegreeOfSupport());
				if (diff > EPSILON) throw new RuntimeException(String.format("x1: %2.6f\tx2:%2.6f\t=> r3: %2.6f\tr4: %2.6f", x1, x2, r3.getDegreeOfSupport(), r4.getDegreeOfSupport()));

			}
		}
	}

	/**
	 * Test method for membership function
	 */
	public void checkMembershipFunction(String title, FIS fis, String membershipFunctionFile) {
		Gpr.debug("Test");

		int mem[][] = loadMembershipFile(membershipFunctionFile);

		if (verbose) System.out.println(fis);
		FunctionBlock fb = fis.getFunctionBlock(null);

		for (int ind = 1; ind < mem.length; ind++) {
			double value = int100ToDouble(mem[ind][0]);

			fb.setVariable("inVar", value);

			int poor = doubleToInt100(fb.getVariable("inVar").getMembership("poor"));
			int good = doubleToInt100(fb.getVariable("inVar").getMembership("good"));
			int excellent = doubleToInt100(fb.getVariable("inVar").getMembership("excellent"));

			if (poor != mem[ind][1]) fail("Membership function " + title + ", poor(" + value + ") should be " + int100ToDouble(mem[ind][1]) + ", but it is " + int100ToDouble(poor));
			if (good != mem[ind][2]) fail("Membership function " + title + ", good(" + value + ") should be " + int100ToDouble(mem[ind][2]) + ", but it is " + int100ToDouble(good));
			if (excellent != mem[ind][3]) fail("Membership function " + title + ", excellent(" + value + ") should be " + int100ToDouble(mem[ind][3]) + ", but it is " + int100ToDouble(excellent));
		}
	}

	/**
	 * Test method for membership function
	 */
	public void checkMembershipFunction(String title, String fclFile, String membershipFunctionFile) {
		int mem[][] = loadMembershipFile(membershipFunctionFile);

		FIS fis = FIS.load(fclFile);
		if (verbose) System.out.println(fis);
		FunctionBlock fb = fis.getFunctionBlock(null);

		for (int ind = 1; ind < mem.length; ind++) {
			double value = int100ToDouble(mem[ind][0]);

			fb.setVariable("inVar", value);

			int poor = doubleToInt100(fb.getVariable("inVar").getMembership("poor"));
			int good = doubleToInt100(fb.getVariable("inVar").getMembership("good"));
			int excellent = doubleToInt100(fb.getVariable("inVar").getMembership("excellent"));

			if (poor != mem[ind][1]) fail("Membership function " + title + ", poor(" + value + ") should be " + int100ToDouble(mem[ind][1]) + ", but it is " + int100ToDouble(poor));
			if (good != mem[ind][2]) fail("Membership function " + title + ", good(" + value + ") should be " + int100ToDouble(mem[ind][2]) + ", but it is " + int100ToDouble(good));
			if (excellent != mem[ind][3]) fail("Membership function " + title + ", excellent(" + value + ") should be " + int100ToDouble(mem[ind][3]) + ", but it is " + int100ToDouble(excellent));
		}
	}

	/**
	 * Round a double to an integer (time 100)
	 */
	int doubleToInt100(double d) {
		return ((int) Math.round(d * 100));
	}

	double int100ToDouble(int i) {
		return (i) / 100.0;
	}

	/**
	 * Read a table of numbers as an array of integers
	 */
	int[][] loadMembershipFile(String fileName) {
		String file = Gpr.readFile(fileName);
		String lines[] = file.split(System.getProperty("line.separator"));
		int numCols = lines[0].split("\t").length;
		int vals[][] = new int[lines.length - 1][numCols];

		// Parse all lines
		// Skip first line (title)
		for (int lineNum = 1; lineNum < lines.length; lineNum++) {
			String valStr[] = lines[lineNum].split("\t");
			// Parse each line
			for (int col = 0; col < numCols; col++)
				vals[lineNum - 1][col] = Integer.parseInt(valStr[col]);
		}

		return vals;
	}

	/**
	 * Show a 'separator' line
	 */
	public void separator() {
		if (verbose) System.out.println("-------------------------------------------------------------------------------");
	}

	/**
	 * Check that De Morgan laws are correct for all AND/OR combinations
	 */
	@Test
	public void testDeMorgan() {
		Gpr.debug("Test");

		if (verbose) System.out.println("Testing De Morgan's law: AND=MIN / OR=MAX");
		FIS fis = FIS.load("fcl/testDeMorgan_1.fcl");
		if (verbose) System.out.println(fis);
		checkDeMorgan(fis);

		if (verbose) System.out.println("Testing De Morgan's law: AND=PROD / OR=ASUM (a.k.a. PROB_OR)");
		fis = FIS.load("fcl/testDeMorgan_2.fcl");
		if (verbose) System.out.println(fis);
		checkDeMorgan(fis);

		if (verbose) System.out.println("Testing De Morgan's law: AND=BDIF / OR=BSUM");
		fis = FIS.load("fcl/testDeMorgan_3.fcl");
		if (verbose) System.out.println(fis);
		checkDeMorgan(fis);

		if (verbose) System.out.println("Testing De Morgan's law: AND=DMIN / OR=DMAX");
		fis = FIS.load("fcl/testDeMorgan_4.fcl");
		if (verbose) System.out.println(fis);
		checkDeMorgan(fis);

		if (verbose) System.out.println("Testing De Morgan's law: AND=NIPMIN / OR=NIPMAX");
		fis = FIS.load("fcl/testDeMorgan_5.fcl");
		if (verbose) System.out.println(fis);
		checkDeMorgan(fis);

		if (verbose) System.out.println("Testing De Morgan's law: AND=HAMACHER / OR=EINSTEIN");
		fis = FIS.load("fcl/testDeMorgan_6.fcl");
		if (verbose) System.out.println(fis);
		checkDeMorgan(fis);
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#load(java.lang.String)}.
	 */
	@Test
	public void testFileParsing1() {
		Gpr.debug("Test");

		FIS fis = FIS.load("./tests/junit1.fcl", true);
		if (verbose) System.out.println(fis);
		separator();
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#load(java.lang.String)}.
	 */
	@Test
	public void testFileParsing2() {
		Gpr.debug("Test");

		FIS fis = FIS.load("./tests/junit2.fcl", true);
		if (verbose) System.out.println(fis);
		separator();
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#load(java.lang.String)}.
	 */
	@Test
	public void testFileParsing3() {
		Gpr.debug("Test");

		FIS fis = FIS.load("./tests/junit3.fcl", true);
		if (verbose) System.out.println(fis);
		separator();
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#load(java.lang.String)}.
	 */
	@Test
	public void testFileParsing4() {
		Gpr.debug("Test");

		FIS fis = FIS.load("./tests/junit4.fcl", true);
		if (verbose) System.out.println(fis);
		separator();
	}

	/**
	 * Test method a fuzzy system that uses functions
	 */
	@Test
	public void testFunctions() {
		Gpr.debug("Test");

		// Load tipper fuzzy system
		FIS fis = FIS.load("./tests/junit_functions.fcl", true);
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Load stored results
		int mem[][] = loadMembershipFile("./tests/junit_functions.txt");

		// Compare running the system vs. stored results
		for (int ind = 0; ind < mem.length; ind++) {
			// Get input variables from stores results
			double inVar = int100ToDouble(mem[ind][0]);

			// Set variables and run the system
			fb.setVariable("inVar", inVar);
			fb.evaluate();

			// Get output variable
			double outVar = fb.getVariable("outVar").getLatestDefuzzifiedValue();

			// Compare output variable to stored result
			if (doubleToInt100(outVar) != mem[ind][4]) fail("Output outVar(inVar=" + inVar + ") should be " + int100ToDouble(mem[ind][4]) + ", but it is " + outVar);
		}
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionCosine() {
		Gpr.debug("Test");

		checkMembershipFunction("Cosine", "./tests/junit_cosine.fcl", "./tests/junit_cosine.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionDsigm() {
		Gpr.debug("Test");

		checkMembershipFunction("Dsigm", "./tests/junit_dsigm.fcl", "./tests/junit_dsigm.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionGauss() {
		Gpr.debug("Test");

		checkMembershipFunction("Gauss", "./tests/junit_gauss.fcl", "./tests/junit_gauss.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionGbell() {
		Gpr.debug("Test");

		checkMembershipFunction("Gbell", "./tests/junit_gbell.fcl", "./tests/junit_gbell.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionOnLine4() {
		Gpr.debug("Test");

		FIS fis = FIS.load("./tests/on_line_variable.fcl");

		double i = 4.0;
		fis.setVariable("inputZeroMin", i - 1.0);
		fis.setVariable("inputZeroMed", i);
		fis.setVariable("inputZeroMax", i + 1.0);

		checkMembershipFunction("Online", fis, "./tests/on_line_variable_4.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionOnLine5() {
		Gpr.debug("Test");

		FIS fis = FIS.load("./tests/on_line_variable.fcl");

		double i = 5.0;
		fis.setVariable("inputZeroMin", i - 1.0);
		fis.setVariable("inputZeroMed", i);
		fis.setVariable("inputZeroMax", i + 1.0);

		checkMembershipFunction("Online", fis, "./tests/on_line_variable_5.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionOnLine6() {
		Gpr.debug("Test");

		FIS fis = FIS.load("./tests/on_line_variable.fcl");

		double i = 6.0;
		fis.setVariable("inputZeroMin", i - 1.0);
		fis.setVariable("inputZeroMed", i);
		fis.setVariable("inputZeroMax", i + 1.0);

		checkMembershipFunction("Online", fis, "./tests/on_line_variable_6.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionPiecewiseLinear() {
		Gpr.debug("Test");

		checkMembershipFunction("Piecewise_linear", "./tests/junit_piecewise_linear.fcl", "./tests/junit_piecewise_linear.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionSigmoid() {
		Gpr.debug("Test");

		checkMembershipFunction("Sigmoid", "./tests/junit_sigmoid.fcl", "./tests/junit_sigmoid.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionSingletons() {
		Gpr.debug("Test");

		checkMembershipFunction("Singleton", "./tests/junit_singletons.fcl", "./tests/junit_singletons.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionTrapezoid() {
		Gpr.debug("Test");

		checkMembershipFunction("Trapezoid", "./tests/junit_trape.fcl", "./tests/junit_trape.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionTriangular() {
		Gpr.debug("Test");

		checkMembershipFunction("Triangular", "./tests/junit_triang.fcl", "./tests/junit_triang.txt");
	}

	@Test
	public void testMembershipWithVariables() {
		Gpr.debug("Test");

		// FCL.debug = true;
		FIS fis = FIS.load("./tests/membershipWithVariables.fcl", true);

		Variable var = fis.getVariable("out");
		if (verbose) {
			System.out.println(var);
			System.out.println("Universe:\t[" + var.getUniverseMin() + " , " + var.getUniverseMax() + "]: " + var.getValue());
		}

		//---
		// Part 1
		//---
		double low = 1, mid = 2, high = 3;
		fis.setVariable("low", low);
		fis.setVariable("mid", mid);
		fis.setVariable("high", high);
		fis.evaluate();

		if (verbose) {
			System.out.println(var);
			System.out.println("Universe:\t[" + var.getUniverseMin() + " , " + var.getUniverseMax() + "]: " + var.getValue());
		}
		Assert.assertTrue(Math.abs(0.0 - var.getUniverseMin()) < EPSILON);
		Assert.assertTrue(Math.abs(3.0 - var.getUniverseMax()) < EPSILON);

		//---
		// Part 2:Re-assign variables and make sure that the 'universe' is properly recalculated
		//---
		low = 2;
		mid = 4;
		high = 6;
		fis.setVariable("low", low);
		fis.setVariable("mid", mid);
		fis.setVariable("high", high);
		fis.evaluate();

		if (verbose) {
			System.out.println(var);
			System.out.println("Universe:\t[" + var.getUniverseMin() + " , " + var.getUniverseMax() + "]: " + var.getValue());
		}
		Assert.assertTrue(Math.abs(0.0 - var.getUniverseMin()) < EPSILON);
		Assert.assertTrue(Math.abs(6.0 - var.getUniverseMax()) < EPSILON);
	}

	/**
	 * Test method a fuzzy system that showed NA values due to 'Triangle' membership function bug
	 * Bug report and FCL code by Shashankrao Wankhede
	 */
	@Test
	public void testNAmembership() {
		Gpr.debug("Test");

		// FCL.debug = true;
		FIS fis = FIS.load("./tests/junit_shashankrao.fcl", true);
		if (verbose) System.out.println(fis);

		// This set of values used to produce a 'NaN' output
		double ra = 0.5;
		double ad = 0.0;
		fis.setVariable("ra", ra);
		fis.setVariable("ad", ad);
		fis.evaluate();

		// Right output should be 0.5
		double ta = fis.getVariable("ta").getValue();
		if (Double.isNaN(ta) || Double.isInfinite(ta) || (Math.abs(ta - 0.5) > EPSILON)) fail("System's output should be 0.5, but it's " + ta + "\n" + fis.getVariable("ta"));
	}

	@Test
	public void testNoRule() {
		Gpr.debug("Test");

		// FCL.debug = true;
		FIS fis = FIS.load("tests/noRules.fcl", true);
		if (verbose) System.out.println(fis);
	}

}
