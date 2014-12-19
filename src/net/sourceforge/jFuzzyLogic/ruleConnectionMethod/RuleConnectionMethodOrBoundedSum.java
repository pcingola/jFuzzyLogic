package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: OR
 * Connection Method: Bounded sum
 * 
 * @author pcingola@users.sourceforge.net
 */
public class RuleConnectionMethodOrBoundedSum extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodOrBoundedSum();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodOrBoundedSum() {
		super();
		name = "or";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		return Math.min(1, antecedent1 + antecedent2);
	}

	@Override
	public String toStringFcl() {
		return "OR: BSUM;";
	}
}
