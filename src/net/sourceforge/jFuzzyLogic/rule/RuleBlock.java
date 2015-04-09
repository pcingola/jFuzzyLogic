package net.sourceforge.jFuzzyLogic.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.sourceforge.jFuzzyLogic.CompileCpp;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethod;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethodBoundedSum;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethodMax;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethodNormedSum;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethodProbOr;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethodSum;
import net.sourceforge.jFuzzyLogic.ruleActivationMethod.RuleActivationMethod;
import net.sourceforge.jFuzzyLogic.ruleActivationMethod.RuleActivationMethodMin;
import net.sourceforge.jFuzzyLogic.ruleActivationMethod.RuleActivationMethodProduct;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethod;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodAndBoundedDif;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodAndDrastic;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodAndHamacher;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodAndMin;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodAndNilpotent;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodAndProduct;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodOrBoundedSum;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodOrDrastic;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodOrEinstein;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodOrMax;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodOrNilpotent;
import net.sourceforge.jFuzzyLogic.ruleConnectionMethod.RuleConnectionMethodOrProbOr;

import org.antlr.runtime.tree.Tree;

/**
 * A set of fuzzy rules
 *
 *
 * Reference: See IEC 1131 - Part 7 - Fuzzy Control Programming
 *
 * @author pcingola@users.sourceforge.net
 */
public class RuleBlock extends FclObject implements Iterable<Rule>, Comparable<RuleBlock>, CompileCpp {

	/** Debug mode? */
	public static boolean debug = FIS.debug;

	FunctionBlock functionBlock; // Which FunctionBlock does this RuleBlock belong to
	String name;
	RuleAccumulationMethod ruleAccumulationMethod; // Rule accumulation method: How results of the rules are combined to obtain an overall result (e.g. MAX: maximum, BSUM: bounded sum, etc.)
	RuleActivationMethod ruleActivationMethod; // Rule activation (implication) method: How the 'if' activates the 'then' (e.g. MIN: minimum, PROD: product)
	ArrayList<Rule> rules; // All the rules

	public static boolean isDebug() {
		return debug;
	}

	public static void setDebug(boolean debug) {
		RuleBlock.debug = debug;
	}

	public RuleBlock(FunctionBlock functionBlock) {
		name = "";
		this.functionBlock = functionBlock;
		rules = new ArrayList<Rule>();
		ruleActivationMethod = new RuleActivationMethodMin(); // Default activation method: Min
	}

	/**
	 * Add a rule to this ruleSet
	 * @param fuzzyRule : Rule to add
	 * @return this
	 */
	public RuleBlock add(Rule fuzzyRule) {
		rules.add(fuzzyRule);
		return this;
	}

	@Override
	public int compareTo(RuleBlock rb) {
		return name.compareTo(rb.getName());
	}

	/**
	 * Create a rule accumulation method based on name
	 *
	 * @param ruleAccumulationMethodType
	 * @return
	 */
	RuleAccumulationMethod createAccumulationMethod(String ruleAccumulationMethodType) {
		RuleAccumulationMethod ruleAccumulationMethod;
		if (ruleAccumulationMethodType.equalsIgnoreCase("MAX")) ruleAccumulationMethod = new RuleAccumulationMethodMax();
		else if (ruleAccumulationMethodType.equalsIgnoreCase("BSUM")) ruleAccumulationMethod = new RuleAccumulationMethodBoundedSum();
		else if (ruleAccumulationMethodType.equalsIgnoreCase("NSUM")) ruleAccumulationMethod = new RuleAccumulationMethodNormedSum();
		else if (ruleAccumulationMethodType.equalsIgnoreCase("PROBOR")) ruleAccumulationMethod = new RuleAccumulationMethodProbOr();
		else if (ruleAccumulationMethodType.equalsIgnoreCase("SUM")) ruleAccumulationMethod = new RuleAccumulationMethodSum();
		else throw new RuntimeException("Unknown/Unimplemented Rule accumulation method '" + ruleAccumulationMethodType + "'");
		return ruleAccumulationMethod;
	}

	/**
	 * Evaluate fuzzy rule set
	 */
	public void evaluate() {
		// Apply each rule
		for (Rule rule : rules) {
			if (debug) Gpr.debug("Evaluating rule: " + rule);
			rule.evaluate();
		}
	}

	public String fclTree(Tree tree) {
		boolean rulesAdded = false;
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		name = tree.getChild(0).getText();
		if (debug) Gpr.debug("RuleBlock name: " + name);

		// Use 'default' methods
		RuleConnectionMethod and = RuleConnectionMethodAndMin.get(), or = RuleConnectionMethodOrMax.get();
		String ruleAccumulationMethodType = "SUM";

		// Explore each sibling in this level
		for (int childNum = 1; childNum < tree.getChildCount(); childNum++) {
			Tree child = tree.getChild(childNum);
			if (debug) Gpr.debug("Parsing: " + child.toStringTree());
			String leaveName = child.getText();

			if (leaveName.equalsIgnoreCase("AND")) {
				//---
				// Which 'AND' method to use? (Note: We also set 'OR' method accordingly to fulfill DeMorgan's law
				//---
				if (rulesAdded) throw new RuntimeException("AND method must be defined prior to RULE definition");
				String type = child.getChild(0).getText();
				if (type.equalsIgnoreCase("MIN")) {
					and = RuleConnectionMethodAndMin.get();
					or = RuleConnectionMethodOrMax.get();
				} else if (type.equalsIgnoreCase("PROD")) {
					and = RuleConnectionMethodAndProduct.get();
					or = RuleConnectionMethodOrProbOr.get();
				} else if (type.equalsIgnoreCase("BDIF")) {
					and = RuleConnectionMethodAndBoundedDif.get();
					or = RuleConnectionMethodOrBoundedSum.get();
				} else if (type.equalsIgnoreCase("DMIN")) {
					and = RuleConnectionMethodAndDrastic.get();
					or = RuleConnectionMethodOrDrastic.get();
				} else if (type.equalsIgnoreCase("NIPMIN")) {
					and = RuleConnectionMethodAndNilpotent.get();
					or = RuleConnectionMethodOrNilpotent.get();
				} else if (type.equalsIgnoreCase("HAMACHER")) {
					and = RuleConnectionMethodAndHamacher.get();
					or = RuleConnectionMethodOrEinstein.get();
				} else throw new RuntimeException("Unknown (or unimplemented) 'AND' method: " + type);
			} else if (leaveName.equalsIgnoreCase("OR")) {
				//---
				// Which 'OR' method to use? (Note: We also set 'AND' method accordingly to fulfill DeMorgan's law
				//---
				if (rulesAdded) throw new RuntimeException("OR method must be defined prior to RULE definition");
				String type = child.getChild(0).getText(); // Bug corrected by Arkadiusz M. amaterek@users.sourceforge.net
				if (type.equalsIgnoreCase("MAX")) {
					or = RuleConnectionMethodOrMax.get();
					and = RuleConnectionMethodAndMin.get();
				} else if (type.equalsIgnoreCase("ASUM")) {
					or = RuleConnectionMethodOrProbOr.get();
					and = RuleConnectionMethodAndProduct.get();
				} else if (type.equalsIgnoreCase("BSUM")) {
					or = RuleConnectionMethodOrBoundedSum.get();
					and = RuleConnectionMethodAndBoundedDif.get();
				} else if (type.equalsIgnoreCase("DMAX")) {
					or = RuleConnectionMethodOrDrastic.get();
					and = RuleConnectionMethodAndDrastic.get();
				} else if (type.equalsIgnoreCase("NIPMAX")) {
					or = RuleConnectionMethodOrNilpotent.get();
					and = RuleConnectionMethodAndNilpotent.get();
				} else if (type.equalsIgnoreCase("EINSTEIN")) {
					or = RuleConnectionMethodOrEinstein.get();
					and = RuleConnectionMethodAndHamacher.get();
				} else throw new RuntimeException("Unknown (or unimplemented) 'OR' method: " + type);
			} else if (leaveName.equalsIgnoreCase("ACT")) fclTreeRuleBlockActivation(child);
			else if (leaveName.equalsIgnoreCase("RULE")) {
				rulesAdded = true;
				fclTreeRuleBlockRule(child, and, or);
			} else if (leaveName.equalsIgnoreCase("ACCU")) // Accumulation method
			ruleAccumulationMethodType = child.getChild(0).getText();
			else throw new RuntimeException("Unknown (or unimplemented) ruleblock item : " + leaveName);
		}

		// Create rule accumulation method
		ruleAccumulationMethod = createAccumulationMethod(ruleAccumulationMethodType);

		return name;
	}

	/**
	 * Parse rule Implication Method (or rule activation method)
	 * @param tree : Tree to parse
	 */
	private void fclTreeRuleBlockActivation(Tree tree) {
		String type = tree.getChild(0).getText();
		if (debug) Gpr.debug("Parsing: " + type);

		if (type.equalsIgnoreCase("MIN")) ruleActivationMethod = new RuleActivationMethodMin();
		else if (type.equalsIgnoreCase("PROD")) ruleActivationMethod = new RuleActivationMethodProduct();
		else throw new RuntimeException("Unknown (or unimplemented) 'ACT' method: " + type);
	}

	/**
	 * Parse rule Implication Method (or rule activation method)
	 * @param tree : Tree to parse
	 */
	private void fclTreeRuleBlockRule(Tree tree, RuleConnectionMethod and, RuleConnectionMethod or) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Rule fuzzyRule = new Rule(tree.getChild(0).getText(), this);

		for (int childNum = 1; childNum < tree.getChildCount(); childNum++) {
			Tree child = tree.getChild(childNum);
			if (debug) Gpr.debug("\t\tChild: " + child.toStringTree());
			String type = child.getText();

			if (type.equalsIgnoreCase("IF")) fuzzyRule.setAntecedents(fclTreeRuleBlockRuleIf(child.getChild(0), and, or));
			else if (type.equalsIgnoreCase("THEN")) fclTreeRuleBlockRuleThen(child, fuzzyRule);
			else if (type.equalsIgnoreCase("WITH")) fclTreeRuleBlockRuleWith(child, fuzzyRule);
			else throw new RuntimeException("Unknown (or unimplemented) rule block item: " + type);
		}

		add(fuzzyRule);
	}

	/**
	 * Parse rule 'IF' (or rule's weight)
	 * @param tree : Tree to parse
	 */
	private RuleExpression fclTreeRuleBlockRuleIf(Tree tree, RuleConnectionMethod and, RuleConnectionMethod or) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		String ifConnector = tree.getText();

		// Create a new expresion
		RuleExpression fuzzyRuleExpression = new RuleExpression();

		if (ifConnector.equalsIgnoreCase("AND")) {
			fuzzyRuleExpression.setRuleConnectionMethod(and);
			// Recurse on term1
			fuzzyRuleExpression.setTerm1(fclTreeRuleBlockRuleIf(tree.getChild(0), and, or));
			// Recurse on term2
			fuzzyRuleExpression.setTerm2(fclTreeRuleBlockRuleIf(tree.getChild(1), and, or));
		} else if (ifConnector.equalsIgnoreCase("OR")) {
			fuzzyRuleExpression.setRuleConnectionMethod(or);
			// Recurse on term2
			fuzzyRuleExpression.setTerm1(fclTreeRuleBlockRuleIf(tree.getChild(0), and, or));
			// Recurse on term2
			fuzzyRuleExpression.setTerm2(fclTreeRuleBlockRuleIf(tree.getChild(1), and, or));
		} else if (ifConnector.equalsIgnoreCase("NOT")) {
			fuzzyRuleExpression.setNegated(true);
			fuzzyRuleExpression.setTerm1(fclTreeRuleBlockRuleIf(tree.getChild(0), and, or));
		} else if (ifConnector.equalsIgnoreCase("(")) fuzzyRuleExpression.setTerm1(fclTreeRuleBlockRuleIf(tree.getChild(0), and, or));
		else {
			// It's a "(Variable IS linguisticTerm)" clause
			// or "(Variable IS NOT linguisticTerm)" clause
			String varName = tree.getText();
			String lingTerm = tree.getChild(0).getText();
			boolean negate = false;
			if (lingTerm.equalsIgnoreCase("NOT")) {
				lingTerm = tree.getChild(1).getText();
				negate = true;
			}
			Variable variable = getVariable(varName);
			RuleTerm fuzzyRuleTerm = new RuleTerm(variable, lingTerm, negate);
			fuzzyRuleExpression.add(fuzzyRuleTerm);
		}
		return fuzzyRuleExpression;
	}

	/**
	 * Parse rule 'THEN' (or rule's weight)
	 * @param tree : Tree to parse
	 */
	private void fclTreeRuleBlockRuleThen(Tree tree, Rule fuzzyRule) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());

		for (int childNum = 0; childNum < tree.getChildCount(); childNum++) {
			Tree child = tree.getChild(childNum);
			if (debug) Gpr.debug("\t\tChild: " + child.toStringTree());
			String thenVariable = child.getText();

			String thenValue = child.getChild(0).getText();
			Variable variable = getVariable(thenVariable);
			if (variable == null) throw new RuntimeException("Variable " + thenVariable + " does not exist");
			fuzzyRule.addConsequent(variable, thenValue, false);
		}
	}

	/**
	 * Parse rule 'WITH' (or rule's weight)
	 * @param tree : Tree to parse
	 */
	private void fclTreeRuleBlockRuleWith(Tree tree, Rule fuzzyRule) {
		if (debug) Gpr.debug("Parsing: " + tree.getChild(0).getText());
		fuzzyRule.setWeight(Gpr.parseDouble(tree.getChild(0)));
	}

	public FunctionBlock getFunctionBlock() {
		return functionBlock;
	}

	public String getName() {
		return name;
	}

	public RuleAccumulationMethod getRuleAccumulationMethod() {
		return ruleAccumulationMethod;
	}

	public RuleActivationMethod getRuleActivationMethod() {
		return ruleActivationMethod;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public Variable getVariable(String name) {
		return functionBlock.getVariable(name);
	}

	@Override
	public Iterator<Rule> iterator() {
		return rules.iterator();
	}

	/**
	 * Remove a rule to this ruleSet
	 * @param fuzzyRule : Rule to remove
	 * @return this
	 */
	public RuleBlock remove(Rule fuzzyRule) {
		rules.remove(fuzzyRule);
		return this;
	}

	/**
	 * Reset ruleset (should be done prior to each inference)
	 * Also create 'variables' list (if needed)
	 */
	public void reset() {
		HashMap<Variable, Variable> resetted = new HashMap<Variable, Variable>();

		//---
		// Reset every consequent variable on every rule
		//---
		for (Rule fr : rules) {
			// Reset rule's degree of support
			fr.setDegreeOfSupport(0);

			//---
			// Reset every consequent variable (and add it to variables list if needed)
			//---
			LinkedList<RuleTerm> llc = fr.getConsequents();
			for (RuleTerm term : llc) {
				Variable var = term.getVariable();
				// Not already resetted?
				if (resetted.get(var) == null) {
					// Sanity check
					if (var.getDefuzzifier() == null) throw new RuntimeException("Defuzzifier not set for output variable '" + var.getName() + "'");
					// var.reset(true); // Reset variable
					var.reset(); // Reset variable
					resetted.put(var, var); // Mark it as 'resetted' so we don't reset it again
				}
			}

			//---
			// Reset every antecedent's variable  (and add it to variables list if needed)
			//---
			for (Variable var : fr.getAntecedents())
				// Not already resetted?
				if (resetted.get(var) == null) {
					// var.reset(true); // Reset variable
					var.reset(); // Reset variable
					resetted.put(var, var); // Mark it as 'resetted' so we don't reset it again
				}
		}
	}

	public void setFunctionBlock(FunctionBlock functionBlock) {
		this.functionBlock = functionBlock;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRuleAccumulationMethod(RuleAccumulationMethod ruleAccumulationMethod) {
		this.ruleAccumulationMethod = ruleAccumulationMethod;
	}

	public void setRuleActivationMethod(RuleActivationMethod ruleImplicationMethod) {
		ruleActivationMethod = ruleImplicationMethod;
	}

	public void setRules(List<Rule> rules) {
		this.rules = new ArrayList<Rule>();
		this.rules.addAll(rules);
	}

	/**
	 * Set a variable
	 * @param variableName : Variable's name
	 * @param value : variable's value to be set
	 * @return this
	 */
	public RuleBlock setVariable(String variableName, double value) {
		functionBlock.setVariable(variableName, value);
		return this;
	}

	public void setVariables(HashMap<String, Variable> variables) {
		functionBlock.setVariables(variables);
	}

	public String toStringCpp(String className) {
		StringBuffer rb = new StringBuffer();
		rb.append("// RULEBLOCK " + name + "\n");
		rb.append("void " + className + "::calc_" + name + "() {\n");

		// Show rules
		int ruleNum = 1;
		for (Rule rule : rules) {
			// Rule name/number
			String name = rule.getName();
			if ((name == null) || (name.equals(""))) name = Integer.toString(ruleNum);

			rb.append("\t// RULE " + name + " : " + rule.toStringFcl() + "\n");
			rb.append(rule.toStringCpp());
			ruleNum++;
		}

		rb.append("}\n");

		return rb.toString();
	}

	@Override
	public String toStringFcl() {
		StringBuffer rb = new StringBuffer();
		String operator = "";

		// Show rules
		int ruleNum = 1;
		for (Rule rule : rules) {
			// Rule name/number
			String name = rule.getName();
			if ((name == null) || (name.equals(""))) name = Integer.toString(ruleNum);

			rb.append("\tRULE " + name + " : " + rule.toStringFcl() + "\n");
			if (rule.getAntecedents().getRuleConnectionMethod() != null) operator = rule.getAntecedents().getRuleConnectionMethod().toStringFcl();
			ruleNum++;
		}

		// Build string
		String ruleBlockStr = "RULEBLOCK " + name + "\n";
		if (ruleActivationMethod != null) ruleBlockStr += "\t" + ruleActivationMethod.toStringFcl() + "\n";
		if (ruleAccumulationMethod != null) ruleBlockStr += "\t" + ruleAccumulationMethod.toStringFcl() + "\n";
		if (!operator.isEmpty()) ruleBlockStr += "\t" + operator + "\n";
		ruleBlockStr += rb + "END_RULEBLOCK\n";

		return ruleBlockStr;
	}

	/** Does this variable exist in this RuleBlock? */
	public boolean varibleExists(String variableName) {
		return functionBlock.varibleExists(variableName);
	}
}
