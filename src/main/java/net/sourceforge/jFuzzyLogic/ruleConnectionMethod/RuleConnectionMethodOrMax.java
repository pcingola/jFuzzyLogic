package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: OR
 * Connection Method: Maximum
 * 
 * @author pcingola@users.sourceforge.net
 */
public class RuleConnectionMethodOrMax extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodOrMax();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodOrMax() {
		super();
		name = "or";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		return Math.max(antecedent1, antecedent2);
	}

	@Override
	public String toStringCppFunction() {
		return "double " + toStringCpp() + "(double antecedent1, double antecedent2)\t{ return (antecedent1 > antecedent2 ? antecedent1 : antecedent2); }\n";
	}

	@Override
	public String toStringFcl() {
		return "OR: MAX;";
	}
}
