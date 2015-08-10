package net.sourceforge.jFuzzyLogic.test.performance;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;

public class TestExecutioner {

	public static boolean debug = true;

	public TestExecutioner() {}

	public List<Double> execute(String fileName, String[] inputVariables, int steps, int stepSize) {

		// Load FIS
		FIS fis = FIS.load(fileName, false);
		if( fis == null ) { // Error while loading?
			System.err.println("Can't load file: '" + fileName + "'");
			return null;
		}

		FunctionBlock functionBlock = fis.getFunctionBlock(null);

		// Time recording
		List<Double> timeRecords = new ArrayList<Double>();
		long startTime;
		int curStep = 0;

		// Test
		for( int i = 0; i <= steps; i++, curStep += stepSize ) {
			startTime = System.currentTimeMillis();

			for( int j = 0; j <= curStep; j++ ) {
				// Set inputs
				for( int k = 0; k < inputVariables.length; k++ )
					functionBlock.setVariable(inputVariables[k], Math.random() * 5);

				// Evaluate fuzzy set
				functionBlock.evaluate();
			}
			timeRecords.add(new Double(System.currentTimeMillis() - startTime));
			if( debug ) Gpr.debug("Evaluate " + fileName + "\ti:" + i + "\tcurStep: " + curStep);
		}
		return timeRecords;
	}
}
