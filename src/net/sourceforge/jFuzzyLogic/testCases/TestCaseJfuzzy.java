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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Main testing class 
 * 
 * @author pcingola@users.sourceforge.net
 *
 */
public class TestCaseJfuzzy extends TestCase {

	// A small number
	static double EPSILON = 0.000001;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Verify that De Morgan's laws are OK
	 * @param fis
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
	 * Round a double to an integer (time 100)
	 * @param d
	 * @return
	 */
	int doubleToInt100(double d) {
		return ((int) Math.round(d * 100));
	}

	double int100ToDOuble(int i) {
		return (i) / 100.0;
	}

	/**
	 * Read a table of numbers as an array of integers
	 * @param fileName
	 * @return
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
		System.out.println("-------------------------------------------------------------------------------");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Check that De Morgan laws are correct for all AND/OR combinations
	 */
	@Test
	public void testDeMorgan() {
		System.out.println("Testing De Morgan's law: AND=MIN / OR=MAX");
		FIS fis = FIS.load("fcl/testDeMorgan_1.fcl");
		System.out.println(fis);
		checkDeMorgan(fis);

		System.out.println("Testing De Morgan's law: AND=PROD / OR=ASUM (a.k.a. PROB_OR)");
		fis = FIS.load("fcl/testDeMorgan_2.fcl");
		System.out.println(fis);
		checkDeMorgan(fis);

		System.out.println("Testing De Morgan's law: AND=BDIF / OR=BSUM");
		fis = FIS.load("fcl/testDeMorgan_3.fcl");
		System.out.println(fis);
		checkDeMorgan(fis);

		System.out.println("Testing De Morgan's law: AND=DMIN / OR=DMAX");
		fis = FIS.load("fcl/testDeMorgan_4.fcl");
		System.out.println(fis);
		checkDeMorgan(fis);

		System.out.println("Testing De Morgan's law: AND=NIPMIN / OR=NIPMAX");
		fis = FIS.load("fcl/testDeMorgan_5.fcl");
		System.out.println(fis);
		checkDeMorgan(fis);

		System.out.println("Testing De Morgan's law: AND=HAMACHER / OR=EINSTEIN");
		fis = FIS.load("fcl/testDeMorgan_6.fcl");
		System.out.println(fis);
		checkDeMorgan(fis);
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#load(java.lang.String)}.
	 */
	@Test
	public void testFileParsing1() {
		FIS fis = FIS.load("./tests/junit1.fcl", true);
		System.out.println(fis);
		separator();
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#load(java.lang.String)}.
	 */
	@Test
	public void testFileParsing2() {
		FIS fis = FIS.load("./tests/junit2.fcl", true);
		System.out.println(fis);
		separator();
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#load(java.lang.String)}.
	 */
	@Test
	public void testFileParsing3() {
		FIS fis = FIS.load("./tests/junit3.fcl", true);
		System.out.println(fis);
		separator();
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#load(java.lang.String)}.
	 */
	@Test
	public void testFileParsing4() {
		FIS fis = FIS.load("./tests/junit4.fcl", true);
		System.out.println(fis);
		separator();
	}

	/**
	 * Test method a fuzzy system that uses functions
	 */
	@Test
	public void testFunctions() {
		// Load tipper fuzzy system
		FIS fis = FIS.load("./tests/junit_functions.fcl", true);
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Load stored results
		int mem[][] = loadMembershipFile("./tests/junit_functions.txt");

		// Compare running the system vs. stored results 
		for (int ind = 0; ind < mem.length; ind++) {
			// Get input variables from stores results
			double inVar = int100ToDOuble(mem[ind][0]);

			// Set variables and run the system
			fb.setVariable("inVar", inVar);
			fb.evaluate();

			// Get output variable
			double outVar = fb.getVariable("outVar").getLatestDefuzzifiedValue();

			// Compare output variable to stored result
			if (doubleToInt100(outVar) != mem[ind][4]) fail("Tipper output outVar(inVar=" + inVar + ") should be " + int100ToDOuble(mem[ind][4]) + ", but it is " + outVar);
		}
	}

	/**
	 * Test method for membership function
	 */
	public void testMembershipFunction(String title, FIS fis, String membershipFunctionFile) {
		int mem[][] = loadMembershipFile(membershipFunctionFile);

		System.out.println(fis);
		FunctionBlock fb = fis.getFunctionBlock(null);

		for (int ind = 1; ind < mem.length; ind++) {
			double value = int100ToDOuble(mem[ind][0]);

			fb.setVariable("inVar", value);

			int poor = doubleToInt100(fb.getVariable("inVar").getMembership("poor"));
			int good = doubleToInt100(fb.getVariable("inVar").getMembership("good"));
			int excellent = doubleToInt100(fb.getVariable("inVar").getMembership("excellent"));

			if (poor != mem[ind][1]) fail("Membership function " + title + ", poor(" + value + ") should be " + int100ToDOuble(mem[ind][1]) + ", but it is " + int100ToDOuble(poor));
			if (good != mem[ind][2]) fail("Membership function " + title + ", good(" + value + ") should be " + int100ToDOuble(mem[ind][2]) + ", but it is " + int100ToDOuble(good));
			if (excellent != mem[ind][3]) fail("Membership function " + title + ", excellent(" + value + ") should be " + int100ToDOuble(mem[ind][3]) + ", but it is " + int100ToDOuble(excellent));
		}
	}

	/**
	 * Test method for membership function
	 */
	public void testMembershipFunction(String title, String fclFile, String membershipFunctionFile) {
		int mem[][] = loadMembershipFile(membershipFunctionFile);

		FIS fis = FIS.load(fclFile);
		System.out.println(fis);
		FunctionBlock fb = fis.getFunctionBlock(null);

		for (int ind = 1; ind < mem.length; ind++) {
			double value = int100ToDOuble(mem[ind][0]);

			fb.setVariable("inVar", value);

			int poor = doubleToInt100(fb.getVariable("inVar").getMembership("poor"));
			int good = doubleToInt100(fb.getVariable("inVar").getMembership("good"));
			int excellent = doubleToInt100(fb.getVariable("inVar").getMembership("excellent"));

			if (poor != mem[ind][1]) fail("Membership function " + title + ", poor(" + value + ") should be " + int100ToDOuble(mem[ind][1]) + ", but it is " + int100ToDOuble(poor));
			if (good != mem[ind][2]) fail("Membership function " + title + ", good(" + value + ") should be " + int100ToDOuble(mem[ind][2]) + ", but it is " + int100ToDOuble(good));
			if (excellent != mem[ind][3]) fail("Membership function " + title + ", excellent(" + value + ") should be " + int100ToDOuble(mem[ind][3]) + ", but it is " + int100ToDOuble(excellent));
		}
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionCosine() {
		testMembershipFunction("Cosine", "./tests/junit_cosine.fcl", "./tests/junit_cosine.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionDsigm() {
		testMembershipFunction("Dsigm", "./tests/junit_dsigm.fcl", "./tests/junit_dsigm.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionGauss() {
		testMembershipFunction("Gauss", "./tests/junit_gauss.fcl", "./tests/junit_gauss.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionGbell() {
		testMembershipFunction("Gbell", "./tests/junit_gbell.fcl", "./tests/junit_gbell.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionOnLine4() {
		FIS fis = FIS.load("./tests/on_line_variable.fcl");

		double i = 4.0;
		fis.setVariable("inputZeroMin", i - 1.0);
		fis.setVariable("inputZeroMed", i);
		fis.setVariable("inputZeroMax", i + 1.0);

		testMembershipFunction("Online", fis, "./tests/on_line_variable_4.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionOnLine5() {
		FIS fis = FIS.load("./tests/on_line_variable.fcl");

		double i = 5.0;
		fis.setVariable("inputZeroMin", i - 1.0);
		fis.setVariable("inputZeroMed", i);
		fis.setVariable("inputZeroMax", i + 1.0);

		testMembershipFunction("Online", fis, "./tests/on_line_variable_5.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionOnLine6() {
		FIS fis = FIS.load("./tests/on_line_variable.fcl");

		double i = 6.0;
		fis.setVariable("inputZeroMin", i - 1.0);
		fis.setVariable("inputZeroMed", i);
		fis.setVariable("inputZeroMax", i + 1.0);

		testMembershipFunction("Online", fis, "./tests/on_line_variable_6.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionPiecewiseLinear() {
		testMembershipFunction("Piecewise_linear", "./tests/junit_piecewise_linear.fcl", "./tests/junit_piecewise_linear.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionSigmoid() {
		testMembershipFunction("Sigmoid", "./tests/junit_sigmoid.fcl", "./tests/junit_sigmoid.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionSingletons() {
		testMembershipFunction("Singleton", "./tests/junit_singletons.fcl", "./tests/junit_singletons.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionTrapezoid() {
		testMembershipFunction("Trapezoid", "./tests/junit_trape.fcl", "./tests/junit_trape.txt");
	}

	/**
	 * Test method for membership function
	 */
	@Test
	public void testMembershipFunctionTriangular() {
		testMembershipFunction("Triangular", "./tests/junit_triang.fcl", "./tests/junit_triang.txt");
	}

	/**
	 * Test method a fuzzy system that showed NA values due to 'Triangle' membership function bug
	 * Bug report and FCL code by Shashankrao Wankhede
	 */
	@Test
	public void testNAmembership() {
		// FCL.debug = true;
		FIS fis = FIS.load("./tests/junit_shashankrao.fcl", true);
		System.out.println(fis);

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
		// FCL.debug = true;
		FIS fis = FIS.load("tests/noRules.fcl", true);
		System.out.println(fis);
	}
}
