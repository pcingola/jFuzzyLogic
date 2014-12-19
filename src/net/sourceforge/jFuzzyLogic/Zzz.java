package net.sourceforge.jFuzzyLogic;

public class Zzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FIS fis = FIS.load("s2.fcl", true); // Load from 'FCL' file
		fis.setVariable("service", 3); // Set inputs
		fis.setVariable("food", 7);
		fis.evaluate(); // Evaluate
		System.out.println("Output value:" + fis.getVariable("tip").getValue()); // Show output variable
	}

}
