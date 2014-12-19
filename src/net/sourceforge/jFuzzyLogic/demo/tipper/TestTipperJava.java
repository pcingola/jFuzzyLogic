package net.sourceforge.jFuzzyLogic.demo.tipper;

import java.util.HashMap;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierCenterOfGravity;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionPieceWiseLinear;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTrapetzoidal;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular;
import net.sourceforge.jFuzzyLogic.membership.Value;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.RuleExpression;
import net.sourceforge.jFuzzyLogic.rule.RuleTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethodMax;
import net.sourceforge.jFuzzyLogic.ruleActivationMethod.RuleActivationMethodMin;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodAndMin;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodOrMax;

/**
 * Tets class: Create a simple fuzzy inference system (FIS) form java code (no FCL)
 * 
 * @author pcingola@users.sourceforge.net
 */
public class TestTipperJava {

	/**
	 * Show animation
	 * @param fis
	 * @throws Exception
	 */
	static void animateFis(FIS fis) throws Exception {
		if (JFuzzyChart.UseMockClass) {
			Gpr.debug("Using mock class");
			return; // Nothing done
		}

		// Create a plot
		JDialogFis jdf = new JDialogFis(fis, 800, 600);

		// Set different values for 'food' and 'service'. Evaluate the system and show variables
		//		for( double service = 0.0, food = 1; service <= 10; service += 0.1 ) {
		for (double service = 0.0, food = 1; service <= 10; service += 0.1) {
			food = service;
			// Evaluate system using these parameters
			fis.getVariable("service").setValue(service);
			fis.getVariable("food").setValue(food);
			fis.evaluate();

			// Print result & update plot
			System.out.println(String.format("Service: %2.2f\tfood:%2.2f\t=> tip: %2.2f %%", service, food, fis.getVariable("tip").getValue()));
			jdf.repaint();

			// Small delay
			Thread.sleep(100);
		}

	}

	/**
	 * Main
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Begin TestTipperJava");

		FIS fis = new FIS();

		// FUNCTION_BLOCK tipper
		FunctionBlock functionBlock = new FunctionBlock(fis);
		fis.addFunctionBlock("tipper", functionBlock);

		//		VAR_INPUT              
		//		   service : REAL;
		//		   food : REAL
		//		END_VAR

		Variable service = new Variable("service");
		Variable food = new Variable("food");
		functionBlock.setVariable(service.getName(), service);
		functionBlock.setVariable(food.getName(), food);

		//		VAR_OUTPUT
		//		   tip : REAL;
		//		END_VAR

		Variable tip = new Variable("tip");
		functionBlock.setVariable(tip.getName(), tip);

		//		FUZZIFY service
		//		   TERM poor := (0, 1) (4, 0) ;
		//		   TERM good := (1, 0) (4,1) (6,1) (9,0);
		//		   TERM excellent := (6, 0) (9, 1);
		//		END_FUZZIFY

		Value poorX[] = { new Value(0), new Value(4) };
		Value poorY[] = { new Value(1), new Value(0) };
		MembershipFunction poor = new MembershipFunctionPieceWiseLinear(poorX, poorY);

		MembershipFunction good = new MembershipFunctionTrapetzoidal(new Value(1), new Value(4), new Value(6), new Value(9));

		Value exX[] = { new Value(6), new Value(9), new Value(10) };
		Value exY[] = { new Value(0), new Value(1), new Value(1) };
		MembershipFunction excellent = new MembershipFunctionPieceWiseLinear(exX, exY);

		LinguisticTerm ltPoor = new LinguisticTerm("poor", poor);
		LinguisticTerm ltGood = new LinguisticTerm("good", good);
		LinguisticTerm ltExcellent = new LinguisticTerm("excellent", excellent);

		service.add(ltPoor);
		service.add(ltGood);
		service.add(ltExcellent);

		//		FUZZIFY food
		//		   TERM rancid := (0, 1) (1, 1) (3,0) ;
		//		   TERM delicious := (7,0) (9,1) (10,1);
		//		END_FUZZIFY

		Value ranX[] = { new Value(0), new Value(1), new Value(3) };
		Value ranY[] = { new Value(1), new Value(1), new Value(0) };
		MembershipFunction rancid = new MembershipFunctionPieceWiseLinear(ranX, ranY);

		Value delX[] = { new Value(7), new Value(9), new Value(10) };
		Value delY[] = { new Value(0), new Value(1), new Value(1) };
		MembershipFunction delicious = new MembershipFunctionPieceWiseLinear(delX, delY);

		LinguisticTerm ltRancid = new LinguisticTerm("rancid", rancid);
		LinguisticTerm ltDelicious = new LinguisticTerm("delicious", delicious);

		food.add(ltRancid);
		food.add(ltDelicious);

		//		DEFUZZIFY tip
		//		   TERM cheap := (0,0) (5,1) (10,0);
		//		   TERM average := (10,0) (15,1) (20,0);
		//		   TERM generous := (20,0) (25,1) (30,0);
		//		   METHOD : COG;
		//		   DEFAULT := 0;
		//		END_DEFUZZIFY

		MembershipFunction cheap = new MembershipFunctionTriangular(new Value(0), new Value(5), new Value(10));
		MembershipFunction average = new MembershipFunctionTriangular(new Value(10), new Value(15), new Value(20));
		MembershipFunction generous = new MembershipFunctionTriangular(new Value(20), new Value(25), new Value(30));

		LinguisticTerm ltCheap = new LinguisticTerm("cheap", cheap);
		LinguisticTerm ltAverage = new LinguisticTerm("average", average);
		LinguisticTerm ltGenerous = new LinguisticTerm("generous", generous);

		tip.add(ltCheap);
		tip.add(ltAverage);
		tip.add(ltGenerous);

		tip.setDefuzzifier(new DefuzzifierCenterOfGravity(tip));

		//		RULEBLOCK No1
		//		   ACCU : MAX;
		//		   AND : MIN;
		//		   ACT : MIN;
		RuleBlock ruleBlock = new RuleBlock(functionBlock);
		ruleBlock.setName("No1");
		ruleBlock.setRuleAccumulationMethod(new RuleAccumulationMethodMax());
		ruleBlock.setRuleActivationMethod(new RuleActivationMethodMin());

		//		   RULE 1 : IF service IS poor OR food is rancid THEN tip IS cheap;
		Rule rule1 = new Rule("Rule1", ruleBlock);
		rule1.addAntecedent(service, "poor", false);
		rule1.addAntecedent(food, "rancid", false);
		rule1.addConsequent(tip, "cheap", false);
		ruleBlock.add(rule1);

		//		   RULE 2 : IF service IS good THEN tip IS average;
		Rule rule2 = new Rule("Rule2", ruleBlock);
		rule2.addAntecedent(service, "good", false);
		rule2.addConsequent(tip, "average", false);
		ruleBlock.add(rule2);

		//		   RULE 3 : IF ((service IS good) OR (service IS excellent)) AND food IS delicious THEN tip is generous;
		Rule rule3 = new Rule("Rule3", ruleBlock);
		RuleTerm term1 = new RuleTerm(service, "good", false); // Create 'terms'
		RuleTerm term2 = new RuleTerm(service, "excellent", false);
		RuleTerm term3 = new RuleTerm(food, "delicious", false);

		RuleExpression antecedentOr = new RuleExpression(term1, term2, RuleConnectionMethodOrMax.get()); // Combine terms using connection methods: OR, AND
		RuleExpression antecedentAnd = new RuleExpression(antecedentOr, term3, RuleConnectionMethodAndMin.get());
		rule3.setAntecedents(antecedentAnd); // Set antecedent

		rule3.addConsequent(tip, "generous", false);
		ruleBlock.add(rule3);

		//		END_RULEBLOCK
		//
		//		END_FUNCTION_BLOCK
		HashMap<String, RuleBlock> ruleBlocksMap = new HashMap<String, RuleBlock>();
		ruleBlocksMap.put(ruleBlock.getName(), ruleBlock);
		functionBlock.setRuleBlocks(ruleBlocksMap);

		//---
		// Show generated FIS (FCL) and show animation
		//---
		System.out.println(fis);
		animateFis(fis);

		System.out.println("End TestTipperJava");
	}

	public TestTipperJava() {
	}
}
