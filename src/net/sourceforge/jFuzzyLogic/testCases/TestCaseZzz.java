/**
 *
 * JUnit test for jFuzzyLogic
 *
 *
 * @author pcingola@users.sourceforge.net
 */
package net.sourceforge.jFuzzyLogic.testCases;

import junit.framework.TestCase;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import org.junit.Assert;
import org.junit.Test;

/**
 * Main testing class
 *
 * @author pcingola@users.sourceforge.net
 *
 */
public class TestCaseZzz extends TestCase {

	static double EPSILON = 0.000001; // A small number
	static boolean verbose = true; // Verbose?

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
	 * Round a double to an integer (time 100)
	 */
	int doubleToInt100(double d) {
		return ((int) Math.round(d * 100));
	}

	double int100ToDouble(int i) {
		return (i) / 100.0;
	}

	@Test
	public void testMembershipWithVariables() {
		Gpr.debug("Test");

		// FCL.debug = true;
		FIS fis = FIS.load("./tests/membershipWithVariables.fcl", true);

		System.out.println(fis);
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
}
