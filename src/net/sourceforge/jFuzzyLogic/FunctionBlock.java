package net.sourceforge.jFuzzyLogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.sourceforge.jFuzzyLogic.defuzzifier.Defuzzifier;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierCenterOfArea;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierCenterOfGravity;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierCenterOfGravityFunctions;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierCenterOfGravitySingletons;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierContinuous;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierLeftMostMax;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierMeanMax;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierRightMostMax;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionCosine;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDifferenceSigmoidal;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionFuncion;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionGaussian;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionGaussian2;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionGenBell;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionGenericSingleton;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionPieceWiseLinear;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionSigmoidal;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionSingleton;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTrapetzoidal;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular;
import net.sourceforge.jFuzzyLogic.membership.Value;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import org.antlr.runtime.tree.Tree;

/**
 * A complete inference system contains:
 * 		- input / output variables
 * 		- rule blocks
 *
 * Reference: See IEC 1131 - Part 7 - Fuzzy Control Programming
 *
 *
 * @author pcingola@users.sourceforge.net
 *
 */
public class FunctionBlock extends FclObject implements Iterable<RuleBlock>, Comparable<FunctionBlock>, CompileCpp {

	public static boolean debug = FIS.debug;

	FIS fis; // Which FIS does this FunctionBlock belong to?
	String name; // Function block name
	HashMap<String, RuleBlock> ruleBlocks; // Several RuleBlocks indexed by name
	HashMap<String, Variable> variablesByName; // Every variable is here (key: VariableName)

	public FunctionBlock(FIS fis) {
		this.fis = fis;
		ruleBlocks = new HashMap<String, RuleBlock>();
		variablesByName = new HashMap<String, Variable>();
	}

	@Override
	public int compareTo(FunctionBlock fb) {
		return name.compareTo(fb.getName());
	}

	/**
	 * Create a defuzzifier based on defuziffier's name and a variable
	 */
	protected Defuzzifier createDefuzzifier(String defuzzificationMethodType, Variable variable) {
		Defuzzifier defuzzifier;
		if (defuzzificationMethodType.equalsIgnoreCase("COG")) defuzzifier = new DefuzzifierCenterOfGravity(variable);
		else if (defuzzificationMethodType.equalsIgnoreCase("COGS")) defuzzifier = new DefuzzifierCenterOfGravitySingletons(variable);
		else if (defuzzificationMethodType.equalsIgnoreCase("COGF")) defuzzifier = new DefuzzifierCenterOfGravityFunctions(variable);
		else if (defuzzificationMethodType.equalsIgnoreCase("COA")) defuzzifier = new DefuzzifierCenterOfArea(variable);
		else if (defuzzificationMethodType.equalsIgnoreCase("LM")) defuzzifier = new DefuzzifierLeftMostMax(variable);
		else if (defuzzificationMethodType.equalsIgnoreCase("RM")) defuzzifier = new DefuzzifierRightMostMax(variable);
		else if (defuzzificationMethodType.equalsIgnoreCase("MM")) defuzzifier = new DefuzzifierMeanMax(variable);
		else throw new RuntimeException("Unknown/Unimplemented Rule defuzzification method '" + defuzzificationMethodType + "'");
		return defuzzifier;
	}

	/**
	 * Evaluate fuzzy rules in this function block
	 */
	public void evaluate() {
		// reset(true); // Reset variables
		reset(); // Reset variables

		// First: Reset defuzzifiers, variables, etc.
		for (RuleBlock ruleBlock : this)
			ruleBlock.reset();

		// Second: Evaluate each RuleBlock
		for (RuleBlock ruleBlock : this)
			ruleBlock.evaluate();

		// Third: Defuzzify each consequent variable
		for (Variable var : variables())
			if (var.isOutput()) var.defuzzify();
	}

	/**
	 * Builds rule set based on FCL tree (parsed from an FCL file)
	 * @param tree : Tree to use
	 * @return : RuleSet's name (or "" if no name)
	 */
	public String fclTree(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Gpr.checkRootNode("FUNCTION_BLOCK", tree);
		ruleBlocks = new HashMap<String, RuleBlock>();

		boolean firstChild = true;
		int ruleBlockCount = 1;

		// Add every child
		for (int childNum = 0; childNum < tree.getChildCount(); childNum++) {
			Tree child = tree.getChild(childNum);
			if (debug) Gpr.debug("\t\tChild: " + child.toStringTree());
			String leaveName = child.getText();

			if (firstChild) name = leaveName;
			else if (leaveName.equalsIgnoreCase("VAR_INPUT")) fclTreeVariables(child);
			else if (leaveName.equalsIgnoreCase("VAR_OUTPUT")) fclTreeVariables(child);
			else if (leaveName.equalsIgnoreCase("FUZZIFY")) fclTreeFuzzify(child);
			else if (leaveName.equalsIgnoreCase("DEFUZZIFY")) fclTreeDefuzzify(child);
			else if (leaveName.equalsIgnoreCase("RULEBLOCK")) {
				// Create and parse RuleBlock
				RuleBlock ruleBlock = new RuleBlock(this);
				String rbname = ruleBlock.fclTree(child);

				if (rbname.equals("")) rbname = "RuleBlock_" + ruleBlockCount; // Create name if none is given
				ruleBlockCount++;

				// Add RuleBlock
				ruleBlocks.put(rbname, ruleBlock);
			} else throw new RuntimeException("Unknown item '" + leaveName + "':\t" + child.toStringTree());

			firstChild = false;
		}

		return name;
	}

	/**
	 * Parse a tree for "Defuzzify" item
	 * @param tree : Tree to parse
	 * @return Variable (old or created)
	 */
	private Variable fclTreeDefuzzify(Tree tree) {
		Gpr.checkRootNode("DEFUZZIFY", tree);
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		String defuzzificationMethodType = "COG";

		Tree child = tree.getChild(0);
		String varName = child.getText();

		// Get variable (or create a new one)
		Variable variable = getVariable(varName);
		if (variable == null) {
			variable = new Variable(varName);
			setVariable(varName, variable);
			if (debug) Gpr.debug("Variable '" + varName + "' does not exist => Creating it");
		}

		//---
		// Explore each sibling in this level
		//---
		for (int childNum = 1; childNum < tree.getChildCount(); childNum++) {
			child = tree.getChild(childNum);
			String leaveName = child.getText();
			if (debug) Gpr.debug("\t\tChild: " + child.toStringTree());

			if (leaveName.equalsIgnoreCase("TERM")) {
				// Linguistic term
				LinguisticTerm linguisticTerm = fclTreeFuzzifyTerm(child, variable);
				variable.add(linguisticTerm);
			} else if (leaveName.equalsIgnoreCase("ACCU")) // Accumulation method
				throw new RuntimeException("Accumulation method (ACCU) must be defined at RULE_BLOCK");
			// ruleAccumulationMethodType = child.getChild(0).getText();
			else if (leaveName.equalsIgnoreCase("METHOD")) // Defuzzification method
				defuzzificationMethodType = child.getChild(0).getText();
			else if (leaveName.equalsIgnoreCase("DEFAULT")) {
				// Default value
				String defaultValueStr = child.getChild(0).getText();
				if (defaultValueStr.equalsIgnoreCase("NC")) variable.setDefaultValue(Double.NaN); // Set it to "No Change"?
				else variable.setDefaultValue(Gpr.parseDouble(child.getChild(0))); // Set value
			} else if (leaveName.equalsIgnoreCase("RANGE")) {
				// Range values (universe min / max)
				double universeMin = Gpr.parseDouble(child.getChild(0));
				double universeMax = Gpr.parseDouble(child.getChild(1));
				if (universeMax <= universeMin) throw new RuntimeException("Range's min is grater than range's max! RANGE := ( " + universeMin + " .. " + universeMax + " );");
				variable.setUniverseMax(universeMax);
				variable.setUniverseMin(universeMin);
			} else throw new RuntimeException("Unknown/Unimplemented item '" + leaveName + "'");
		}

		// Defuzzification method
		Defuzzifier defuzzifier = createDefuzzifier(defuzzificationMethodType, variable);
		variable.setDefuzzifier(defuzzifier);

		return variable;
	}

	/**
	 * Parse a tree for "Fuzzify" item
	 * @param tree : Tree to parse
	 * @return Variable (old or created)
	 */
	private Variable fclTreeFuzzify(Tree tree) {
		Gpr.checkRootNode("FUZZIFY", tree);
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Tree child = tree.getChild(0);
		String varName = child.getText();

		// Get variable (or create a new one)
		Variable variable = getVariable(varName);
		if (variable == null) {
			variable = new Variable(varName);
			setVariable(varName, variable);
			if (debug) Gpr.debug("Variable '" + varName + "' does not exist => Creating it");
		}

		// Explore each sibling in this level
		for (int childNum = 1; childNum < tree.getChildCount(); childNum++) {
			child = tree.getChild(childNum);
			if (debug) Gpr.debug("\t\tChild: " + child.toStringTree());
			String leaveName = child.getText();

			if (leaveName.equalsIgnoreCase("TERM")) {
				LinguisticTerm linguisticTerm = fclTreeFuzzifyTerm(child, variable);
				variable.add(linguisticTerm);
			} else throw new RuntimeException("Unknown/Unimplemented item '" + leaveName + "'");
		}

		return variable;
	}

	/**
	 * Parse a tree for "Term" item
	 * @param tree : Tree to parse
	 * @return A new LinguisticTerm
	 */
	private LinguisticTerm fclTreeFuzzifyTerm(Tree tree, Variable variable) {
		Gpr.checkRootNode("TERM", tree);
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		String termName = tree.getChild(0).getText();
		Tree child = tree.getChild(1);
		String leaveName = child.getText();
		if (debug) Gpr.debug("\t\tTermname: " + termName + "\tLeavename: " + leaveName);

		MembershipFunction membershipFunction = null;
		if (leaveName.equalsIgnoreCase("POINT")) membershipFunction = fclTreeFuzzifyTermPieceWiseLinear(tree);
		else if (leaveName.equalsIgnoreCase("COSINE")) membershipFunction = fclTreeFuzzifyTermCosine(child);
		else if (leaveName.equalsIgnoreCase("DSIGM")) membershipFunction = fclTreeFuzzifyTermDifferenceSigmoidal(child);
		else if (leaveName.equalsIgnoreCase("GAUSS")) membershipFunction = fclTreeFuzzifyTermGauss(child);
		else if (leaveName.equalsIgnoreCase("GAUSS2")) membershipFunction = fclTreeFuzzifyTermGauss2(child);
		else if (leaveName.equalsIgnoreCase("TRIAN")) membershipFunction = fclTreeFuzzifyTermTriangular(child);
		else if (leaveName.equalsIgnoreCase("GBELL")) membershipFunction = fclTreeFuzzifyTermGenBell(child);
		else if (leaveName.equalsIgnoreCase("TRAPE")) membershipFunction = fclTreeFuzzifyTermTrapetzoidal(child);
		else if (leaveName.equalsIgnoreCase("SIGM")) membershipFunction = fclTreeFuzzifyTermSigmoidal(child);
		else if (leaveName.equalsIgnoreCase("SINGLETONS")) membershipFunction = fclTreeFuzzifyTermSingletons(child);
		else if (leaveName.equalsIgnoreCase("FUNCTION")) membershipFunction = fclTreeFuzzifyTermFunction(child);
		else if (leaveName.equalsIgnoreCase("-")) membershipFunction = fclTreeFuzzifyTermSingleton(child);
		else if (leaveName.equalsIgnoreCase("+")) membershipFunction = fclTreeFuzzifyTermSingleton(child);
		else membershipFunction = fclTreeFuzzifyTermSingleton(child);
		LinguisticTerm linguisticTerm = new LinguisticTerm(termName, membershipFunction);

		// Create linguistic term
		return linguisticTerm;
	}

	/**
	 * Parse a tree for cosine membership function
	 * @param tree : tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermCosine(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Value net_max = new Value(tree.getChild(0), this);
		Value offset = new Value(tree.getChild(1), this);
		MembershipFunction membershipFunction = new MembershipFunctionCosine(net_max, offset);
		return membershipFunction;
	}

	/**
	 * Parse a tree for difference sigmoidal membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermDifferenceSigmoidal(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Value a1 = new Value(tree.getChild(0), this);
		Value c1 = new Value(tree.getChild(1), this);
		Value a2 = new Value(tree.getChild(2), this);
		Value c2 = new Value(tree.getChild(3), this);
		MembershipFunction membershipFunction = new MembershipFunctionDifferenceSigmoidal(a1, c1, a2, c2);
		return membershipFunction;
	}

	/**
	 * Parse a tree for trapetzoidal membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermFunction(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		return new MembershipFunctionFuncion(this, tree.getChild(0));
	}

	/**
	 * Parse a tree for gaussian membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermGauss(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Tree child = tree.getChild(0);
		Value mean = new Value(child, this);
		Value stdev = new Value(tree.getChild(1), this);
		MembershipFunction membershipFunction = new MembershipFunctionGaussian(mean, stdev);
		return membershipFunction;
	}

	/**
	 * Parse a tree for gaussian2 membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermGauss2(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Tree child = tree.getChild(0);
		Value mean = new Value(child, this);
		Value stdev = new Value(tree.getChild(1), this);
		Value mean2 = new Value(tree.getChild(2), this);
		Value stdev2 = new Value(tree.getChild(3), this);
		MembershipFunction membershipFunction = new MembershipFunctionGaussian2(mean, stdev, mean2, stdev2);
		return membershipFunction;
	}

	/**
	 * Parse a tree for generilized bell membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermGenBell(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Tree child = tree.getChild(0);
		Value a = new Value(child, this);
		Value b = new Value(tree.getChild(1), this);
		Value mean = new Value(tree.getChild(2), this);
		MembershipFunction membershipFunction = new MembershipFunctionGenBell(a, b, mean);
		return membershipFunction;
	}

	/**
	 * Parse a tree for piece-wice linear membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermPieceWiseLinear(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		int numberOfPoints = tree.getChildCount() - 1;
		if (debug) Gpr.debug("\tNumber of points: " + numberOfPoints);

		Value x[] = new Value[numberOfPoints];
		Value y[] = new Value[numberOfPoints];
		for (int childNum = 1; childNum < tree.getChildCount(); childNum++) {
			Tree child = tree.getChild(childNum);
			if (debug) Gpr.debug("\t\tChild: " + child.toStringTree());
			String leaveName = child.getText();

			// It's a set of points? => Defines a piece-wise linear membership function
			if (leaveName.equalsIgnoreCase("POINT")) {
				x[childNum - 1] = new Value(child.getChild(0), this); // Parse and add each point
				y[childNum - 1] = new Value(child.getChild(1), this);
				if (debug) Gpr.debug("\t\tParsed point " + childNum + " x=" + x[childNum - 1] + ", y=" + y[childNum - 1]);
				if ((y[childNum - 1].getValue() < 0) || (y[childNum - 1].getValue() > 1)) throw new RuntimeException("\n\tError parsing line " + child.getLine() + " character " + child.getCharPositionInLine() + ": Membership function out of range (should be between 0 and 1). Value: '" + y[childNum - 1] + "'\n\tTree: " + child.toStringTree());
			} else throw new RuntimeException("Unknown (or unimplemented) option : " + leaveName);
		}
		return new MembershipFunctionPieceWiseLinear(x, y);
	}

	/**
	 * Parse a tree for sigmoidal membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermSigmoidal(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Value gain = new Value(tree.getChild(0), this);
		Value t0 = new Value(tree.getChild(1), this);
		MembershipFunction membershipFunction = new MembershipFunctionSigmoidal(gain, t0);
		return membershipFunction;
	}

	/**
	 * Parse a tree for piece-wice linear membership function item
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermSingleton(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Value singleTonValueX = new Value(tree, this);
		MembershipFunction membershipFunction = new MembershipFunctionSingleton(singleTonValueX);
		return membershipFunction;
	}

	/**
	 * Parse a tree for singletons membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermSingletons(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());

		// Count number of points
		int numPoints = 0;
		for (int childNum = 0; childNum < tree.getChildCount(); childNum++) {
			Tree child = tree.getChild(childNum);

			String leaveName = child.getText();
			if (leaveName.equalsIgnoreCase("(")) numPoints++;
			if (debug) Gpr.debug("leaveName : " + leaveName + "\tnumPoints: " + numPoints);
		}

		// Parse multiple points (for piece-wise linear)
		return fclTreeFuzzifyTermSingletonsPoints(tree.getChild(0), numPoints);
	}

	/**
	 * Parse a tree for singletons membership function series of points
	 * @param tree : Tree to parse
	 * @param numberOfPoints : Number of points in this function
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermSingletonsPoints(Tree tree, int numberOfPoints) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());

		Value x[] = new Value[numberOfPoints];
		Value y[] = new Value[numberOfPoints];
		for (int childNum = 0; childNum < tree.getChildCount(); childNum++) {
			Tree child = tree.getChild(childNum);
			String leaveName = child.getText();
			if (debug) Gpr.debug("Sub-Parsing: " + leaveName);

			// It's a set of points? => Defines a piece-wise linear membership function
			if (leaveName.equalsIgnoreCase("(")) {
				x[childNum] = new Value(child.getChild(0), this); // Parse and add each point
				y[childNum] = new Value(child.getChild(1), this);

				if ((y[childNum].getValue() < 0) || (y[childNum].getValue() > 1)) throw new RuntimeException("\n\tError parsing line " + child.getLine() + " character " + child.getCharPositionInLine() + ": Membership function out of range (should be between 0 and 1). Value: '" + y[childNum] + "'\n\tTree: " + child.toStringTree());

				if (debug) Gpr.debug("Parsed point " + childNum + " x=" + x[childNum] + ", y=" + y[childNum]);
			} else throw new RuntimeException("Unknown (or unimplemented) option : " + leaveName);
		}
		return new MembershipFunctionGenericSingleton(x, y);
	}

	/**
	 * Parse a tree for trapetzoidal membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermTrapetzoidal(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Value min = new Value(tree.getChild(0), this);
		Value midLow = new Value(tree.getChild(1), this);
		Value midHigh = new Value(tree.getChild(2), this);
		Value max = new Value(tree.getChild(3), this);
		MembershipFunction membershipFunction = new MembershipFunctionTrapetzoidal(min, midLow, midHigh, max);
		return membershipFunction;
	}

	/**
	 * Parse a tree for triangular membership function
	 * @param tree : Tree to parse
	 * @return A new membership function
	 */
	private MembershipFunction fclTreeFuzzifyTermTriangular(Tree tree) {
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		Value min = new Value(tree.getChild(0), this);
		Value mid = new Value(tree.getChild(1), this);
		Value max = new Value(tree.getChild(2), this);
		MembershipFunction membershipFunction = new MembershipFunctionTriangular(min, mid, max);
		return membershipFunction;
	}

	/**
	 * Parse a tree for "Variable" item (either input or output variables)
	 * @param tree
	 */
	private void fclTreeVariables(Tree tree) {
		Gpr.checkRootNode("VAR_OUTPUT", "VAR_INPUT", tree);
		if (debug) Gpr.debug("Tree: " + tree.toStringTree());
		for (int childNum = 0; childNum < tree.getChildCount(); childNum++) {
			Tree child = tree.getChild(childNum);
			if (debug) Gpr.debug("\tChild: " + child.toStringTree());
			String varName = child.getText();
			Variable variable = new Variable(varName);
			if (debug) Gpr.debug("\tAdding variable: " + varName);

			// Set range?
			if (child.getChildCount() > 1) {
				Tree rangeTree = child.getChild(1);
				if (debug) Gpr.debug("\tRangeTree: " + rangeTree.toStringTree());
				double min = Gpr.parseDouble(rangeTree.getChild(0));
				double max = Gpr.parseDouble(rangeTree.getChild(1));

				if (debug) Gpr.debug("\tSetting universe to: [ " + min + " , " + max + " ]");
				variable.setUniverseMin(min);
				variable.setUniverseMax(max);
			}

			if (varibleExists(variable.getName())) if (debug) Gpr.debug("Warning: Variable '" + variable.getName() + "' duplicated");
			else setVariable(varName, variable); // OK? => Add variable
		}
	}

	/**
	 * Get a RuleBlock
	 * @param ruleBlockName : Rule block's name (can be null to retrieve first available one)
	 * @return Fuzzy rule block (or null if not found)
	 */
	public RuleBlock getFuzzyRuleBlock(String ruleBlockName) {
		if (ruleBlockName == null) ruleBlockName = ruleBlocks.keySet().iterator().next();
		return ruleBlocks.get(ruleBlockName);
	}

	public String getName() {
		return name;
	}

	public HashMap<String, RuleBlock> getRuleBlocks() {
		return ruleBlocks;
	}

	public Variable getVariable(String name) {
		return variablesByName.get(name);
	}

	public HashMap<String, Variable> getVariables() {
		return variablesByName;
	}

	@Override
	public Iterator<RuleBlock> iterator() {
		return ruleBlocks.values().iterator();
	}

	//	/**
	//	 * Reset all variables
	//	 */
	//	public void reset(boolean useDefault) {
	//		for (Variable var : variables())
	//			var.reset(useDefault);
	//	}

	/**
	 * Reset all variables
	 */
	public void reset() {
		for (Variable var : variables())
			var.reset();
	}

	public List<RuleBlock> ruleBlocksSorted() {
		ArrayList<RuleBlock> rbs = new ArrayList<RuleBlock>(ruleBlocks.values());
		Collections.sort(rbs);
		return rbs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRuleBlocks(HashMap<String, RuleBlock> ruleBlocks) {
		this.ruleBlocks = ruleBlocks;
	}

	/**
	 * Set a variable
	 * @param variableName : Variable's name
	 * @param value : variable's value to be set
	 * @return this
	 */
	public void setVariable(String variableName, double value) {
		Variable var = getVariable(variableName);
		if (var == null) throw new RuntimeException("No such variable: '" + variableName + "'");
		var.setValue(value);
	}

	public Variable setVariable(String name, Variable variable) {
		return variablesByName.put(name, variable);
	}

	public void setVariables(HashMap<String, Variable> variables) {
		variablesByName = variables;
	}

	@Override
	public String toStringCpp() {
		StringBuffer calcMethod = new StringBuffer(); // Method calc()
		StringBuffer constructor = new StringBuffer(); // Constructor
		StringBuffer defuzzifyMethod = new StringBuffer(); // Method defuzzify()
		StringBuffer fuzzifyMethod = new StringBuffer(); // Fuzzify method
		StringBuffer methodsDecl = new StringBuffer(); // Methods declaration
		StringBuffer membershipMethods = new StringBuffer(); // All membership functions
		StringBuffer printMethod = new StringBuffer(); // Method print()
		StringBuffer resetMethod = new StringBuffer(); // Method reset()
		StringBuffer varDefuzzifiers = new StringBuffer(); // All defuzzifier variables
		StringBuffer varsFuzzify = new StringBuffer(); // Fuzzyfy variables
		StringBuffer varsIn = new StringBuffer(); // Input vars
		StringBuffer varsOut = new StringBuffer(); // Output vars

		varsIn.append("\t// VAR_INPUT\n");
		varsOut.append("\t// VAR_OUTPUT\n");

		// Methods
		String className = "FunctionBlock_" + name;
		calcMethod.append("// Calculate function block\nvoid " + className + "::calc() {\n\treset();\n\tfuzzify();\n");
		constructor.append("// Constructor\n" + className + "::" + className + "() {\n");
		defuzzifyMethod.append("// Defuzzify \nvoid " + className + "::defuzzify() {\n");
		fuzzifyMethod.append("// Fuzzify all variables\nvoid " + className + "::fuzzify() {\n");
		membershipMethods.append("// Membership functions \n");
		methodsDecl.append( //
				"\tpublic:\n" //
				+ "\t" + className + "();\n" //
				+ "\tvoid calc();\n" //
				+ "\tvoid print();\n" //
				+ "\n\tprivate:\n" //
				+ "\tvoid defuzzify();\n" //
				+ "\tvoid fuzzify();\n" //
				+ "\tvoid reset();\n" //
				);
		printMethod.append("// Print \nvoid " + className + "::print() {\n\tprintf(\"Function block " + name + ":\\n\");\n");
		resetMethod.append("// Reset output\nvoid " + className + "::reset() {\n");

		//---
		// Show variables (sorted by name)
		//---
		for (Variable var : variablesSorted()) {
			var.estimateUniverse();

			if (!Double.isNaN(var.getDefaultValue())) constructor.append("\t" + var.getName() + " = " + var.getDefaultValue() + ";\n");

			if (var.isInput()) {
				// Add input variables
				varsIn.append("\tdouble " + var.getName());
				varsIn.append(";\n");

				// Add to print method
				printMethod.append("\tprintf(\"\tInput  %20s : %f\\n\", \"" + var.getName() + "\" , " + var.getName() + ");\n");

				// Add fuzzyfiers
				varsFuzzify.append("\t// FUZZIFY " + var.getName() + "\n");
				for (LinguisticTerm linguisticTerm : var.linguisticTermsSorted()) {
					String ltVar = var.getName() + "_" + linguisticTerm.getTermName();
					varsFuzzify.append("\tdouble " + ltVar + ";\n");
					fuzzifyMethod.append("\t" + ltVar + " = " + linguisticTerm.toStringCppMethodName(var) + "(" + var.getName() + ");\n");

					// Membership function
					membershipMethods.append(linguisticTerm.toStringCpp(className, var) + "\n");
					methodsDecl.append("\tdouble " + linguisticTerm.toStringCppMethodName(var) + "(double x);\n");

					// Add to print method
					printMethod.append("\tprintf(\"\t       %20s : %f\\n\", \"" + ltVar + "\" , " + ltVar + ");\n");
				}
				varsFuzzify.append("\n");

			} else {
				// Add output variables
				varsOut.append("\tdouble " + var.getName());
				varsOut.append(";\n");

				// Add to print method
				printMethod.append("\tprintf(\"\tOutput %20s : %f\\n\", \"" + var.getName() + "\" , " + var.getName() + ");\n");

				// Add defuzzyfier variable
				int len = ((DefuzzifierContinuous) var.getDefuzzifier()).getLength();
				varDefuzzifiers.append("\t// DEFUZZIFY " + var.getName() + "\n");
				varDefuzzifiers.append("\tdouble " + var.toStringCppDefuzzifyVarName() + "[" + len + "];\n");

				// Add to reset method
				resetMethod.append("\tfor( int i=0 ; i < " + len + " ; i++ )\t{ " + var.toStringCppDefuzzifyVarName() + "[i] = 0.0; }\n");

				for (LinguisticTerm linguisticTerm : var.linguisticTermsSorted()) {
					// Membership function
					membershipMethods.append(linguisticTerm.toStringCpp(className, var) + "\n");
					methodsDecl.append("\tdouble " + linguisticTerm.toStringCppMethodName(var) + "(double x);\n");

				}
				varDefuzzifiers.append("\n");

				defuzzifyMethod.append(var.getDefuzzifier().toStringCpp());
			}
		}

		//---
		// Iterate over each ruleSet and append it to output string
		// Sort ruleBlocks by name
		//---
		StringBuffer ruleBlocksStr = new StringBuffer();
		for (RuleBlock ruleBlock : ruleBlocksSorted()) {
			ruleBlocksStr.append(ruleBlock.toStringCpp(className));
			methodsDecl.append("\tvoid calc_" + ruleBlock.getName() + "();\n");
			calcMethod.append("\tcalc_" + ruleBlock.getName() + "();\n");
		}

		constructor.append("}\n");
		calcMethod.append("\tdefuzzify();\n}\n");
		defuzzifyMethod.append("}\n");
		fuzzifyMethod.append("}\n");
		printMethod.append("}\n");
		resetMethod.append("}\n");

		// Build the whole thing
		return "class FunctionBlock_" + name + " {\n\n" //
				+ "\tpublic: \n" //
				+ varsIn + "\n" //
				+ varsOut + "\n" //
				+ "\tprivate: \n" //
				+ varsFuzzify + "\n"//
				+ varDefuzzifiers + "\n"//
				+ methodsDecl + "\n" //
				+ "};\n\n" //
				+ constructor + "\n" //
				+ calcMethod + "\n" //
				+ ruleBlocksStr + "\n" //
				+ defuzzifyMethod + "\n" //
				+ fuzzifyMethod + "\n" //
				+ membershipMethods + "\n" //
				+ printMethod + "\n" //
				+ resetMethod + "\n" //
				; //
	}

	@Override
	public String toStringFcl() {
		StringBuffer varsIn = new StringBuffer();
		StringBuffer varsOut = new StringBuffer();
		StringBuffer fuzzifiers = new StringBuffer();
		StringBuffer defuzzifiers = new StringBuffer();

		//---
		// Show variables (sorted by name)
		//---
		for (Variable var : variablesSorted()) {
			if (var.getDefuzzifier() == null) {
				// Add input variables
				varsIn.append("\t" + var.getName() + " : REAL;\n");

				// Add fuzzyfiers
				fuzzifiers.append("FUZZIFY " + var.getName() + "\n");
				for (LinguisticTerm linguisticTerm : var.linguisticTermsSorted())
					fuzzifiers.append("\t" + linguisticTerm.toStringFcl() + "\n");
				fuzzifiers.append("END_FUZZIFY\n\n");

			} else {
				// Add output variables
				varsOut.append("\t" + var.getName() + " : REAL;\n");

				// Add defuzzyfiers
				defuzzifiers.append("DEFUZZIFY " + var.getName() + "\n");
				for (LinguisticTerm linguisticTerm : var.linguisticTermsSorted())
					defuzzifiers.append("\t" + linguisticTerm.toStringFcl() + "\n");

				defuzzifiers.append("\t" + var.getDefuzzifier().toStringFcl() + "\n");
				defuzzifiers.append("\tDEFAULT := " + (Double.isNaN(var.getDefaultValue()) ? "NC" : Double.toString(var.getDefaultValue())) + ";\n");
				var.estimateUniverse();
				defuzzifiers.append("\tRANGE := (" + var.getUniverseMin() + " .. " + var.getUniverseMax() + ");\n");
				defuzzifiers.append("END_DEFUZZIFY\n\n");
			}
		}

		varsIn.insert(0, "VAR_INPUT\n");
		varsIn.append("END_VAR\n");
		varsOut.insert(0, "VAR_OUTPUT\n");
		varsOut.append("END_VAR\n");

		//---
		// Iterate over each ruleSet and append it to output string
		//---
		StringBuffer ruleBlocksStr = new StringBuffer();
		for (RuleBlock ruleBlock : ruleBlocksSorted())
			ruleBlocksStr.append(ruleBlock.toStringFcl());

		// Build the whole thing
		return "FUNCTION_BLOCK " + name + "\n\n" //
				+ varsIn + "\n" //
				+ varsOut + "\n" //
				+ fuzzifiers //
				+ defuzzifiers //
				+ ruleBlocksStr + "\n" //
				+ "END_FUNCTION_BLOCK\n\n";
	}

	/** Get all variables */
	public Collection<Variable> variables() {
		return variablesByName.values();
	}

	/** Get all variables (sorted by name) */
	public List<Variable> variablesSorted() {
		List<Variable> ll = new LinkedList<Variable>(variablesByName.values());
		Collections.sort(ll);
		return ll;
	}

	/** Does this variable exist in this FunctionBlock? */
	public boolean varibleExists(String variableName) {
		if (variablesByName == null) return false;
		if (getVariable(variableName) != null) return true;
		return false;
	}

}
