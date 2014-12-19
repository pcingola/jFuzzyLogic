package net.sourceforge.jFuzzyLogic.testCases;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestSuiteAll {

	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static Test suite() {
		TestSuite suite = new TestSuite();

		// Stats
		suite.addTestSuite(TestCaseJfuzzy.class);
		suite.addTestSuite(TestCaseTipper.class);
		suite.addTestSuite(TestCaseCommandLine.class);

		return suite;
	}
}
