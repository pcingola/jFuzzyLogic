package net.sourceforge.jFuzzyLogic.demo.tipper;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Tets class: Create a simple fuzzy inference system (FIS) form an 'FCL' string
 * @author pcingola@users.sourceforge.net
 */
public class TestTipperString {

	public static void main(String[] args) throws Exception {
		System.out.println("Begin TestTipperString");

		String fcl = "FUNCTION_BLOCK tipper  // Block definition (there may be more than one block per file)\n" + //
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
				"   ACCU : MAX;         // Use 'max' accumulation method\n" + //
				"   AND : MIN;          // Use 'min' for 'and' (also implicit use 'max' for 'or' to fulfill DeMorgan's Law)\n" + //
				"   ACT : MIN;          // Use 'min' activation method\n" + //
				"\n" + //
				"   RULE 1 : IF service IS poor OR food is rancid THEN tip IS cheap;\n" + //
				"   RULE 2 : IF service IS good THEN tip IS average; \n" + //
				"   RULE 3 : IF service IS excellent AND food IS delicious THEN tip is generous;\n" + //
				"END_RULEBLOCK\n" + //
				"\n" + //
				"END_FUNCTION_BLOCK\n";

		FIS fis = FIS.createFromString(fcl, true);
		FunctionBlock functionBlock = fis.getFunctionBlock("tipper");
		JFuzzyChart.get().chart(functionBlock);

		// Set inputs
		functionBlock.setVariable("service", 3);
		functionBlock.setVariable("food", 7);

		// Evaluate fuzzy set
		functionBlock.evaluate();

		// Show output variable's chart 
		Variable tip = functionBlock.getVariable("tip");
		JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

		// Print ruleSet
		System.out.println(functionBlock);

		System.out.println("End TestTipperString");
	}

	public TestTipperString() {
	}
}
