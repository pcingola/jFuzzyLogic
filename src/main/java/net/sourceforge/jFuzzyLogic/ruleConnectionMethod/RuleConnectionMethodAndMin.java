package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: AND
 * Connection Method: Minimum
 * 
 * @author pcingola@users.sourceforge.net
 */
public class RuleConnectionMethodAndMin extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodAndMin();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodAndMin() {
		super();
		name = "and";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		return Math.min(antecedent1, antecedent2);
	}

	@Override
	public String toStringCppFunction() {
		return "double " + toStringCpp() + "(double antecedent1, double antecedent2)\t{ return (antecedent1 < antecedent2 ? antecedent1 : antecedent2); }\n";
	}

	@Override
	public String toStringFcl() {
		return "AND : MIN;";
	}

}
