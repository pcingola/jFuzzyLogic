package net.sourceforge.jFuzzyLogic.testCases;

import junit.framework.TestCase;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;

import org.antlr.runtime.RecognitionException;
import org.junit.Assert;
import org.junit.Test;

public class TestCaseTipper extends TestCase {

	public static final double EPSILON = 0.001; // Error tolerated
	static boolean verbose = false; // Verbose?

	public void createTxtFile() {
		// Load from 'FCL' file
		String fileName = "tests/tipper.fcl";
		FIS fis = FIS.load(fileName, true);

		// Show ruleset
		FunctionBlock functionBlock = fis.getFunctionBlock(null);

		// Set inputs
		for (double service = 0; service <= 10; service += 1.0)
			for (double food = 0; food <= 10; food += 1.0) {
				// Set inputs
				functionBlock.setVariable("service", service);
				functionBlock.setVariable("food", food);

				// Evaluate
				functionBlock.evaluate();

				// Get output
				double tip = functionBlock.getVariable("tip").getValue();

				// Show
				System.out.println(service + "\t" + food + "\t" + tip);
			}
	}

	/**
	 * Round a double to an integer (time 100)
	 */
	int doubleToInt100(double d) {
		return ((int) Math.round(d * 100));
	}

	double int100ToDOuble(int i) {
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

	@Test
	public void test() {
		Gpr.debug("Test");

		// Load from 'FCL' file
		String fileName = "tests/tipper.fcl";
		FIS fis = FIS.load(fileName, true);

		// Show ruleset
		FunctionBlock functionBlock = fis.getFunctionBlock(null);

		// Read results file
		String lines[] = Gpr.readFile("tests/tipper.txt").split("\n");

		// Iterate
		for (String line : lines) {
			// Parse line
			String recs[] = line.split("\t");

			double service = Gpr.parseDoubleSafe(recs[0]);
			double food = Gpr.parseDoubleSafe(recs[1]);
			double tip = Gpr.parseDoubleSafe(recs[2]);

			// Set inputs
			functionBlock.setVariable("service", service);
			functionBlock.setVariable("food", food);

			// Evaluate
			functionBlock.evaluate();

			// Get output
			double tipEv = functionBlock.getVariable("tip").getValue();

			// Show
			Assert.assertEquals(tip, tipEv, EPSILON);
		}
	}

	/**
	 * Test method for {@link net.sourceforge.jFuzzyLogic.FIS#createFromString(java.lang.String, boolean)}.
	 */
	@Test
	public void testStringParsing() {
		Gpr.debug("Test");

		String fcl = "FUNCTION_BLOCK tipper_parsed_from_string  // Block definition (there may be more than one block per file)\n" + //
				"\n" + //
				"VAR_INPUT              // Define input variables\n" + //
				"   service : REAL;\n" + //
				"   food : REAL;\n" + //
				"END_VAR\n" + //
				"\n" + //
				"VAR_OUTPUT             // Define output variable\n" + //
				"   tip : REAL;\n" + //
				"END_VAR\n" + //
				"\n" + //
				"FUZZIFY service            // Fuzzify input variable 'service': {'poor', 'good' , 'excellent'}\n" + //
				"   TERM poor := (0, 1) (4, 0) ; \n" + //
				"   TERM good := (1, 0) (4,1) (6,1) (9,0);\n" + //
				"   TERM excellent := (6, 0) (9, 1);\n" + //
				"END_FUZZIFY\n" + //
				"\n" + //
				"FUZZIFY food           // Fuzzify input variable 'food': { 'rancid', 'delicious' }\n" + //
				"   TERM rancid := (0, 1) (1, 1) (3,0) ;\n" + //
				"   TERM delicious := (7,0) (9,1);\n" + //
				"END_FUZZIFY\n" + //
				"\n" + //
				"DEFUZZIFY tip          // Defzzzify output variable 'tip' : {'cheap', 'average', 'generous' }\n" + //
				"   TERM cheap := (0,0) (5,1) (10,0);\n" + //
				"   TERM average := (10,0) (15,1) (20,0);\n" + //
				"   TERM generous := (20,0) (25,1) (30,0);\n" + //
				"   METHOD : COG;       // Use 'Center Of Gravity' defuzzification method\n" + //
				"   DEFAULT := 0;       // Default value is 0 (if no rule activates defuzzifier)\n" + //
				"END_DEFUZZIFY\n" + //
				"\n" + //
				"RULEBLOCK No1\n" + //
				"   AND : MIN;          // Use 'min' for 'and' (also implicit use 'max' for 'or' to fulfill DeMorgan's Law)\n" + //
				"   ACT : MIN;          // Use 'min' activation method\n" + //
				"   ACCU : MAX;         // Use 'max' accumulation method\n" + //
				"\n" + //
				"   RULE 1 : IF service IS poor OR food is rancid THEN tip IS cheap;\n" + //
				"   RULE 2 : IF service IS good THEN tip IS average; \n" + //
				"   RULE 3 : IF service IS excellent AND food IS delicious THEN tip is generous;\n" + //
				"END_RULEBLOCK\n" + //
				"\n" + //
				"END_FUNCTION_BLOCK\n";

		try {
			FIS fis = FIS.createFromString(fcl, true);
			if (verbose) System.out.println(fis);
		} catch (RecognitionException e) {
			fail("RecognitionException:" + e);
		}
	}

	/**
	 * Test method 'tipper' fuzzy system
	 */
	@Test
	public void testTipper() {
		Gpr.debug("Test");

		// Load tipper fuzzy system
		FIS fis = FIS.load("./tests/junit_tipper.fcl", true);
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Load stored results
		int mem[][] = loadMembershipFile("./tests/junit_tipper.txt");

		// Compare running the system vs. stored results 
		for (int ind = 1; ind < mem.length; ind++) {
			// Get input variables from stores results
			double service = int100ToDOuble(mem[ind][0]);
			double food = int100ToDOuble(mem[ind][1]);

			// Set variables and run the system
			fb.setVariable("service", service);
			fb.setVariable("food", food);
			fb.evaluate();

			// Get output variable
			double tip = fb.getVariable("tip").getLatestDefuzzifiedValue();

			// Compare output variable to stored result
			if (doubleToInt100(tip) != mem[ind][2]) fail("Tipper output tip(service=" + service + ", food=" + food + ") should be " + int100ToDOuble(mem[ind][2]) + ", but it is " + tip);
		}
	}

	/**
	 * Test method generating a string and parsing it
	 */
	@Test
	public void testToString() {
		Gpr.debug("Test");

		// Load system
		String fileName = "tests/tipper.fcl";
		FIS fis = FIS.load(fileName, true);

		// Parse FCL code generated by fis.toString()
		FIS fis2;
		try {
			fis2 = FIS.createFromString(fis.toString(), false);
		} catch (RecognitionException e) {
			throw new RuntimeException("Could not parse FCL code generated by fis.toString(). This should never happen!!!");
		}

		// Compare both fis (should be identical)
		boolean ok = fis.toString().equals(fis2.toString());
		if (verbose) System.out.println("Are both fis equal?: " + ok);
		if (!ok) throw new RuntimeException("FCL code for both fis is not the same.");
	}

}
